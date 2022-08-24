package Main;

import Model.*;

import java.util.Random;

import javax.swing.JOptionPane;
import View.BattleInterface;

public class BattleManager {

	private final BattleInterface BattleUi;
	private final Player player;
	private final Pokemon opponentPokemon;
	private Pokemon playerPokemon;
	public int Indice;
	String str;

	/**
	 * Creates a Battle object.
	 *
	 * @param p          = Pokemon Choose by the Player
	 * @param opponent   = A Randon Enemy Chosse in the Pokemons in the Area
	 * @param indicePoke = Indice of the Pokemon Player
	 */
	public BattleManager(Player p, Pokemon opponent, int indicePoke) {
		player = p;
		opponentPokemon = opponent;
		playerPokemon = player.getParty()[indicePoke];
		Indice = indicePoke;
		BattleUi = new BattleInterface(this);
		BattleUi.setVisible(true);
		BattleUi.CreateUI(playerPokemon, opponentPokemon);
	}

	/**
	 * Process the Move used by the Player
	 */
	public void UseMove(Move move) {
		if (move.getCurrentPP() > 0) {
			Move opponentMove = opponentPokemon.getMoveSet()[(byte) (Math.random() * opponentPokemon.getMoveSet().length)];
			if (playerPokemon.getInBattleStat(Stat.SPEED) >= opponentPokemon.getInBattleStat(Stat.SPEED)) {
				ProcessMoveInOrder(playerPokemon, move, opponentPokemon, opponentMove);
			} else {
				ProcessMoveInOrder(opponentPokemon, opponentMove, playerPokemon, move);
			}
		} else {
			JOptionPane.showMessageDialog(null, move.getName() + "Dont have Power Point!");
		}
	}

	/**
	 * Process the move in the Order of the Speed Stats
	 */
	public void ProcessMoveInOrder(Pokemon first, Move moveFirst, Pokemon second, Move moveSecond) {
		BattleUi.txtLog.setText("");
		int Damage = 0;
		Damage = ExecuteMove(first, moveFirst, second);
		second.takeDamage(Damage);
		if (second.isFainted()) {
			ProcessDeath(second);
		} else if (!moveSecond.equals(Move.FISSURE)) {
			Damage = ExecuteMove(second, moveSecond, first);
			first.takeDamage(Damage);
			if (first.isFainted()) {
				ProcessDeath(first);
			}
		} else {
			BattleUi.txtLog.setText(BattleUi.txtLog.getText() + second.getName() + " Miss" + str + "\n");
		}
		BattleUi.RefreshUI(playerPokemon, opponentPokemon);
	}

	/**
	 * Give the Damage to the Oponnent
	 */
	public int ExecuteMove(Pokemon pokemon, Move move, Pokemon target) {
		int Damage = 0;
		str = "";
		if ((byte) (Math.random() * 100) <= move.getAccuracy()) {
			if (MoveType.STATUS.equals(move.getMoveType())) {
				BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Used  " + move.getName() + "!\n" + str + "\n");
				pokemon.InBattleStatusIncrease(move);
			} 
			else if(MoveType.ENEMYSTATUS.equals(move.getMoveType())){
				BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Used  " + move.getName() + "!\n" + str + "\n");
				target.InBattleStatusDecrease(move);
			}
			else {
				if (move.equals(Move.NIGHT_SHADE) || move.equals(Move.SEISMIC_TOSS)) {
					Damage = target.getLevel();
					//target.takeDamage(Damage);
				} else if (move.equals(Move.PSYWAVE)) {
					Damage = (int) (Math.random() * (target.getLevel() * 1.5));
					//target.takeDamage(Damage);
				} else if (move.equals(Move.SUPER_FANG)) {
					Damage = (int) (target.getInBattleHp() * 0.5);
					//target.takeDamage(Damage);
				} else {
					Damage = CalculateDamage(pokemon, move, target);
					//target.takeDamage(Damage);
				}
				BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Used  " + move.getName() + "!\nDid " + Damage + " Damage!\n" + str + "\n");
			}
		} else {
			BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Miss" + str + "\n");
		}
		return Damage;
	}

	/**
	 * Calculate the Damage to the Oponnent
	 */
	private int CalculateDamage(Pokemon pokemon, Move move, Pokemon target) {
		int attack, defense;
		switch (move.getMoveType()) {
		case PHYSICAL:
			attack = pokemon.getInBattleStat(Stat.ATTACK);
			defense = target.getInBattleStat(Stat.DEFENSE);
			break;
		case SPECIAL:
			attack = pokemon.getInBattleStat(Stat.SP_ATTACK);
			defense = target.getInBattleStat(Stat.SP_DEFENSE);
			break;
		default:
			return 0;
		}
		return (int) (Math.round((((((2 * pokemon.getLevel() / 5) + 2) * move.getPower() * attack / defense) / 50) + 2)
				* ModifiersStab(pokemon, move, target)) / 255);
	}

	/**
	 * Calculate the Stab, Crit and Type Effectiveness
	 */
	private float ModifiersStab(Pokemon pokemon, Move move, Pokemon target) {
		float stab = 1, typeEffectiveness = 1, crit = 1;
		for (Type t : pokemon.getType()) {
			if (t == move.getType())
				stab = (float) 1.5;
		}
		for (Type t : target.getType()) {
			if (move.getType().SuperEffective(t)) {
				str = move.getName() + " is Super Effective against " + target.getName() + "\n";
				typeEffectiveness *= 2;
			} else if (move.getType().NotVeryEffective(t)) {
				str = move.getName() + " is Not Very Effective against " + target.getName() + "\n";
				typeEffectiveness *= .5;
			} else if (move.getType().NoEffect(t))
				typeEffectiveness *= 0;
		}
		if (Math.random() * 100 <= (pokemon.getInBattleStat(Stat.SPEED) * 100 / 512)) {
			str += pokemon.getName() + " hit a Critical Hit\n";
			crit = 2;
		}
		return (float) (stab * typeEffectiveness * crit * (((int) (new Random().nextInt((255 - 217) + 1) + 217))));
	}
	/**
	*Aply Debuff
	*/
	public static boolean applyStatus(Move move, final Pokemon pokemon) {
		final Status s = move.getStatusEffect();
		for (int i = 0; i < pokemon.getStatus().length; i++) {
			if (s.ordinal() == i) {
				pokemon.getStatus()[i] = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Process the Death of the Pokemon that Took Damage
	 */
	private void ProcessDeath(Pokemon poke) {
		BattleUi.RefreshUI(playerPokemon, opponentPokemon);
		if (poke == opponentPokemon) {
			int aux = calcExp(poke);
			JOptionPane.showMessageDialog(null, getPokemon().getName() + " gained " + aux + "!");
			GameManager.StopSound();
			GameManager.PlaySound(1);
			BattleUi.dispose();
		} else {
			JOptionPane.showMessageDialog(null, playerPokemon.getName() + " Died!");
			BattleUi.ContainerMenu.setVisible(false);
			BattleUi.ContainerPokemon.setVisible(true);
			BattleUi.ChangePokemon();
		}
	}

	/**
	 * Call the Method to check if the Pokemon Level Up
	 */
	public int calcExp(Pokemon enemy) {
		return (int) ((enemy.getExpYield() * enemy.getLevel()) / 5.0);
	}

	/**
	 * Gets and Sets
	 *
	 */
	public Pokemon getPokemon() {
		return playerPokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		playerPokemon = pokemon;
	}

	public Pokemon getOpponent() {
		return opponentPokemon;
	}

	public Player getPlayer() {
		return player;
	}
}

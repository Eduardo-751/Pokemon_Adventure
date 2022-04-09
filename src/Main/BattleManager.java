package Main;

import Model.Player;
import Model.Pokemon;

import javax.swing.JOptionPane;

import Model.Move;
import Model.Stat;
import View.BattleInterface;

public class BattleManager {

    private final BattleInterface BattleUi;
    private final Player player;
    private final Pokemon opponentPokemon;
    private Pokemon playerPokemon;
    public int Indice;

    /**
     * Creates a Battle object.
     *
     * @param p = Pokemon Choose by the Player
     * @param opponent = A Randon Enemy Chosse in the Pokemons in the Area
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

    public void UseMove(Move move) throws InterruptedException {
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

    public void ProcessMoveInOrder(Pokemon first, Move moveFirst, Pokemon second, Move moveSecond) throws InterruptedException {
        BattleUi.txtLog.setText("");
        ExecuteMove(first, moveFirst, second);
        if (second.isFainted()) {
            CheckDeath(second);
        } else {
            ExecuteMove(second, moveSecond, first);
            if (first.isFainted()) {
                CheckDeath(first);
            }
        }
    }

    public void ExecuteMove(Pokemon pokemon, Move move, Pokemon target) {

        int Damage = CalculateDamage(pokemon, move, target);
        String str = "";
        if ((byte) (Math.random() * 100) <= move.getAccuracy()) {
            target.takeDamage(Damage);
            if (typeEffectiveness(target, move) == 0.5) {
                str = move.getName() + " is Not Very Effective against " + target.getName();
            } else if (typeEffectiveness(target, move) == 2) {
                str = move.getName() + " is Super Effective against " + target.getName();
            }
            BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Used  " + move.getName() + "!\n" + str + "\n");
        } else {
            BattleUi.txtLog.setText(BattleUi.txtLog.getText() + pokemon.getName() + " Miss\n");
        }
        BattleUi.RefreshUI(playerPokemon, opponentPokemon);
    }

    private int CalculateDamage(Pokemon pokemon, Move move, Pokemon target) {
        int attack, defense;
        attack = pokemon.getInBattleStat(Stat.ATTACK);
        defense = target.getInBattleStat(Stat.DEFENSE);
        move.downPP();
        return (int) (((attack / (double) defense) * ((2 * pokemon.getLevel() + 10) / 250.0) * move.getPower()) * typeEffectiveness(target, move) + 1);
    }

    private void CheckDeath(Pokemon poke) {
        if (poke == opponentPokemon) {
            GameManager.StopSound();
            GameManager.PlaySound(1);
            BattleUi.dispose();
        } else {
            JOptionPane.showMessageDialog(null, playerPokemon.getName() + " Died!");
            BattleUi.ChangePokemon(getPokemon());
            BattleUi.ContainerMenu.setVisible(false);
            BattleUi.ContainerPokemon.setVisible(true);
        }
    }

    private float typeEffectiveness(Pokemon target, Move move) {
        float typeEffectiveness = 1;

        if (move.getType().SuperEffective(target.getType())) {
            typeEffectiveness *= 2;
        } else if (move.getType().NotVeryEffective(target.getType())) {
            typeEffectiveness *= .5;
        } else if (move.getType().NoEffect(target.getType())) {
            typeEffectiveness *= 0;
        }
        return typeEffectiveness;
    }

    public int calcExp(Pokemon enemy) {
        return (int) ((enemy.getExpYield() * enemy.getLevel()) / 5.0);
    }

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

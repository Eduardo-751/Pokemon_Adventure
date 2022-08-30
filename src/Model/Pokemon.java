package Model;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Pokemon {

    private Species Specie;
    private byte Level;
    private Move[] MoveSet = new Move[4];
  //HP, Attack, Defense, Sp. Attack, Sp. Defense, Speed
    private int[] CurrentStats;
    private int[] InBattleStats;
    private boolean[] status;
    private int ExpToNextLvl, CurrentExp;

    /**
     * Creates a brand new Pokemon based on a given species.This Pokemon will
     * start at level 5.
     *
     * @param species Enum pf the Specie of the Pokemon
     * @param level Level to Start Pokemon
     */
    public Pokemon(Species species, int level) {
    	Specie = species;
        InBattleStats = new int[6];
        Level = (byte) level;

        status = new boolean[] {false, false, false, false, false, false};
        //Update the Stats
        CurrentStats = new int[]{
            CalculateStat(Stat.HP),
            CalculateStat(Stat.ATTACK),
            CalculateStat(Stat.DEFENSE),
            CalculateStat(Stat.SP_ATTACK),
            CalculateStat(Stat.SP_DEFENSE),
            CalculateStat(Stat.SPEED)};

        //Set Current Exp
        CurrentExp = species.calculateExp(level);
        //Calculate Exp to Next Level
        if (level < 100) {
            ExpToNextLvl = species.calculateExp((level + 1));
        } else {
            ExpToNextLvl = species.calculateExp((100));
        }

        System.arraycopy(CurrentStats, 0, InBattleStats, 0, CurrentStats.length);
        initializeMoves();
    }
	
    //Function to increase Exp
    public void AddExp(int newExp) {
        CurrentExp += newExp;
        levelUp();
    }
    
    //Function that checks if your pokemon Level Up
    public void levelUp() {
        if (CurrentExp >= ExpToNextLvl) {
            Level++;
            ExpToNextLvl = Specie.calculateExp(Level + 1);
            JOptionPane.showMessageDialog(null, getName() + " grew to Level: " + getLevel() + "!");
            System.arraycopy(CurrentStats, 0, InBattleStats, 0, CurrentStats.length);

            //Update the Stats
            CurrentStats = new int[]{
                CalculateStat(Stat.HP),
                CalculateStat(Stat.ATTACK),
                CalculateStat(Stat.DEFENSE),
                CalculateStat(Stat.SP_ATTACK),
                CalculateStat(Stat.SP_DEFENSE),
                CalculateStat(Stat.SPEED)};
            
            Revive();
            Evolve();
        }
    }
    
    //Function that checks if your pokemon Learn a new Move
    public Move NewMove() {
        for (Move m : Specie.getLearnset().keySet()) {
            if (Specie.getLearnset().get(m) == Level && !Arrays.asList(getMoveSet()).contains(m)) {
                return m;
            }
        }
        return null;
    }
    
    public void LearnNewMove(Move newMove, int i) {
    	MoveSet[i] = newMove;
    }

    
    //Function that checks if your pokemon Evolve
	public void Evolve() {
		if(!Specie.hasEvolution()) {
        	if(Specie.getEvolutionLevel() <= Level) {
        		Species s = Specie.getEvolutionSpecie();
        		int dialogResult = JOptionPane.showConfirmDialog(null, Specie.getName() + " Can Evolve to " + s.getName() + "!", "Confirm", JOptionPane.YES_NO_OPTION);
        		if (dialogResult == JOptionPane.YES_OPTION) {
        			Specie = s;
        			CurrentStats = new int[]{
        	                CalculateStat(Stat.HP),
        	                CalculateStat(Stat.ATTACK),
        	                CalculateStat(Stat.DEFENSE),
        	                CalculateStat(Stat.SP_ATTACK),
        	                CalculateStat(Stat.SP_DEFENSE),
        	                CalculateStat(Stat.SPEED)};
        			Revive();
                }
        	}
        }
	}
	
    //Function to Calculate Damage
    public void takeDamage(int damage) {
        InBattleStats[(byte) Stat.HP.ordinal()] -= (short) damage;
        if (InBattleStats[(byte) Stat.HP.ordinal()] < 0) {
            InBattleStats[(byte) Stat.HP.ordinal()] = 0;
        }
    }

    //Function that checks if your pokemon is Dead
    public boolean isFainted() {
        return InBattleStats[Stat.HP.ordinal()] <= 0;
    }

    //Calculates any stat.
    private int CalculateStat(Stat stat) {
        return ((stat == Stat.HP ? ((Specie.getBaseStat((byte) stat.ordinal()) * 2 * Level) / 100 + Level + 10)
                : ((Specie.getBaseStat((byte) stat.ordinal()) * 2 * Level) / 100 + 5)));

    }

    //Function to Reset the Stats
    public void Revive() {
        for (int i = Stat.ATTACK.ordinal(); i <= Stat.SPEED.ordinal(); i++) {
            InBattleStats[i] = CurrentStats[i];
        }
        InBattleStats[(byte) Stat.HP.ordinal()] = CurrentStats[(byte) Stat.HP.ordinal()];
        for(byte i = (byte)Status.POISON.ordinal(); i <= (byte)Status.SEED.ordinal(); i++)
        {
            status[i] = false;
        }
    }

    //Function to Pick in the HashMao the Move Set
    private void initializeMoves() {
    	for (int i = 0; i < 4; i++) {
    		for (Move m : Specie.getLearnset().keySet()) {
    			 if (Specie.getLearnset().get(m) <= Level && !Arrays.asList(getMoveSet()).contains(m)) {
    				 MoveSet[i] = m;
    				 break;
    			 }
    			 else 
    				 MoveSet[i] = Move.NULL;
    		}
    	}
    }

    //Function to Calculate The capture method in Generation I
	public boolean calculateCatchRate(int ball) {
		int ballModifire;
		if(ball==200)
			ballModifire=9;
		else
			ballModifire=12;
		if((Math.random() * ball) < Specie.getCatchRate()) {
			if ((Math.random() * 255) <= (CurrentStats[(byte) Stat.HP.ordinal()] * 1020) / (InBattleStats[(byte) Stat.HP.ordinal()] * ballModifire)) {
				return true;
			}
		}
		return false;
	}
	
    public void InBattleStatusIncrease(Move move){
    	for (int i = Stat.ATTACK.ordinal(); i <= Stat.SPEED.ordinal(); i++) {
            InBattleStats[i] += move.getStatEffect()[i];
        }
    }
    
    public void InBattleStatusDecrease(Move move){
    	for (int i = Stat.ATTACK.ordinal(); i <= Stat.SPEED.ordinal(); i++) {
            InBattleStats[i] -= move.getStatEffect()[i];
        }
    }

    /**
     * Gets and Sets
     *
     * @return
     */
    public int getInBattleHp() {
        return InBattleStats[(byte) Stat.HP.ordinal()];
    }
    public int getInBattleStat(final Stat stat) {
        return InBattleStats[(byte) stat.ordinal()];
    }
    public void setInBattleStats(int[] inBattleStats) {
		InBattleStats = inBattleStats;
	}
	public int getCurrentStat(final Stat stat) throws ArrayIndexOutOfBoundsException {
        return CurrentStats[(byte) stat.ordinal()];
    }
    public int getLevel() {
        return Level;
    }
    public String getName() {
        return Specie.getName();
    }
    public Species getSpecie() {
        return Specie;
    }
    public Type[] getType() {
        return Specie.getType();
    }
    public String getTypeName() {
    	String str = "";
    	for(Type t : Specie.getType())
    		str += " " + t.name();
    	return str;
    }
    public int getExp() {
        return CurrentExp;
    }
    public int getExpToNextLvl() {
        return ExpToNextLvl;
    }
    public int getExpYield() {
        return Specie.getExpYield();
    }
    public int getCatchRate() {
        return Specie.getCatchRate();
    }
    public boolean[] getStatus() {
        return status;
    }
    public Move[] getMoveSet() {
        byte count = (byte) MoveSet.length;
        for (Move m : MoveSet) {
            if (m == null) {
                count--;
            }
        }
        return Arrays.copyOfRange(MoveSet, 0, count);
    }
}

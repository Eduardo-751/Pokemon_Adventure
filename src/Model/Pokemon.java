package Model;

import java.util.Arrays;

public class Pokemon {

    private final Species Species;
    private byte Level;
    //HP, Attack, Defense, Sp. Attack, Sp. Defense, Speed
    private final Move[] MoveSet = new Move[4];
    private int[] CurrentStats;
    private final int[] InBattleStats;
    private int ExpToNextLvl, CurrentExp;

    /**
     * Creates a brand new Pokemon based on a given species.This Pokemon will
     * start at level 5.
     *
     * @param species Enum pf the Specie of the Pokemon
     * @param level Level to Start Pokemon
     */
    public Pokemon(Species species, int level) {
        Species = species;
        InBattleStats = new int[6];
        Level = (byte) level;

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

    /**
     * Function that checks if your pokemon Level Up
     *
     * @return
     */
    public boolean levelUp() {
        if (CurrentExp >= ExpToNextLvl) {
            Level++;
            ExpToNextLvl = Species.calculateExp(Level + 1);

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
            return true;
        }
        return false;
    }

    //Function to increase Exp
    public void AddExp(int newExp) {
        CurrentExp += newExp;
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
        return InBattleStats[(byte) Stat.HP.ordinal()] <= 0;
    }

    //Calculates any stat.
    private int CalculateStat(Stat stat) {
        return ((stat == Stat.HP ? ((Species.getBaseStat((byte) stat.ordinal()) * 2 * Level) / 100 + Level + 10)
                : ((Species.getBaseStat((byte) stat.ordinal()) * 2 * Level) / 100 + 5)));

    }

    //Function to Reset the Stats
    public void Revive() {
        for (int i = Stat.ATTACK.ordinal(); i <= Stat.SPEED.ordinal(); i++) {
            InBattleStats[i] = CurrentStats[i];
        }
        InBattleStats[(byte) Stat.HP.ordinal()] = CurrentStats[(byte) Stat.HP.ordinal()];
    }

    //Function to Pick in the HashMao the Move Set
    private void initializeMoves() {
        for (Move m : Species.getLearnset().keySet()) {
            if (Species.getLearnset().get(m) <= Level) {
                for (int i = 0; i < MoveSet.length; i++) {
                    if (MoveSet[i] == null) {
                        MoveSet[i] = m;
                        break;
                    }
                }
            }
        }
    }

    //Function to Learn the Move
    public boolean LearnNewMove(Move m) {
        boolean aux = false;
        for (int i = 0; i < MoveSet.length; i++) {
            if (MoveSet[i] == null) {
                MoveSet[i] = m;
                aux = true;
                break;
            }
        }
        return aux;
    }

    //Function to Check if have move to Learn
    public Move canLearnNewMove() {
        for (Move m : Species.getLearnset().keySet()) {
            if (Species.getLearnset().get(m) == Level) {
                return m;
            }
        }
        return null;
    }

    /**
     * Gets and Sets
     *
     * @return
     */
    public int getInBattleHp() {
        return InBattleStats[(byte) Stat.HP.ordinal()];
    }

    public int getInBattleStat(final Stat stat) throws ArrayIndexOutOfBoundsException {
        return InBattleStats[(byte) stat.ordinal()];
    }

    public int getCurrentStat(final Stat stat) throws ArrayIndexOutOfBoundsException {
        return CurrentStats[(byte) stat.ordinal()];
    }

    public int getLevel() {
        return Level;
    }

    public String getName() {
        return Species.getName();
    }

    public Species getSpecie() {
        return Species;
    }

    public Type getType() {
        return Species.getType();
    }

    public int getExp() {
        return CurrentExp;
    }

    public int getExpToNextLvl() {
        return ExpToNextLvl;
    }

    public int getExpYield() {
        return Species.getExpYield();
    }

    public int getCatchRate() {
        return Species.getCatchRate();
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

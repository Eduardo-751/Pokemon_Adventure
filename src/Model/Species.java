package Model;

import java.util.Map;
import java.util.TreeMap;

public enum Species {
    BULBASAUR("Bulbasaur", "001", new short[]{45, 49, 49, 65, 65, 45}, 64, 45, Type.GRASS, convertToMap(new int[]{1, 1, 7, 11, 21, 15, 18, 24, 27, 30, 33, 36,}, new Move[]{Move.TACKLE, Move.GROWL, Move.LEECH_SEED, Move.RAZOR_LEAF, Move.TAKE_DOWN, Move.SLEEP_POWDER, Move.SEED_BOMB, Move.SWEET_SCENT, Move.SYNTHESIS, Move.WORRY_SEED, Move.DOUBLE_EDGE, Move.SOLAR_BEAM})),
    CHARMANDER("Charmander", "004", new short[]{39, 52, 43, 60, 50, 65}, 65, 45, Type.FIRE, convertToMap(new int[]{1, 1, 6, 8, 12, 17, 20, 24, 28, 32, 36, 40}, new Move[]{Move.SCRATCH, Move.GROWL, Move.EMBER, Move.SMOKESCREEN, Move.DRAGON_BREATH, Move.FIRE_FANG, Move.SLASH, Move.FLAMETHROWER, Move.SCARY_FACE, Move.FIRE_SPIN, Move.INFERNO, Move.FLARE_BLITZ})),
    SQUIRTLE("Squirtle", "007", new short[]{44, 48, 65, 50, 64, 43}, 66, 45, Type.WATER, convertToMap(new int[]{1, 1, 6, 9, 12, 15, 18, 21, 24, 27, 32, 36}, new Move[]{Move.TACKLE, Move.TAIL_WHIP, Move.WATER_GUN, Move.RAPID_SPIN, Move.BITE, Move.WATER_PULSE, Move.PROTECT, Move.RAIN_DANCE, Move.AQUA_TAIL, Move.SHELL_SMASH, Move.HYDRO_PUMP, Move.SKULL_BASH})),
    CATERPIE("Caterpie", "010", new short[]{45, 30, 35, 20, 20, 45}, 53, 255, Type.BUG, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    METAPOD("Metapod", "011", new short[]{50, 20, 55, 25, 25, 30}, 72, 120, Type.BUG, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    WEEDLE("Weedle", "013", new short[]{40, 35, 30, 25, 25, 50}, 52, 200, Type.BUG, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    KAKUNA("Kakuna", "014", new short[]{45, 25, 50, 25, 25, 35}, 71, 120, Type.BUG, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    PIDGEY("Pidgey", "016", new short[]{40, 45, 40, 35, 35, 56}, 55, 255, Type.NORMAL, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    RATATA("Ratata", "019", new short[]{30, 56, 35, 25, 35, 72}, 57, 255, Type.NORMAL, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    SPEAROW("Spearow", "021", new short[]{40, 60, 30, 31, 31, 70}, 58, 255, Type.NORMAL, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    NIDORAN("Nidoran", "032", new short[]{46, 57, 40, 40, 40, 50}, 60, 235, Type.POISON, convertToMap(new int[]{1}, new Move[]{Move.TACKLE})),
    MANKEY("Mankey", "056", new short[]{40, 80, 35, 35, 45, 70}, 74, 190, Type.FIGHTING, convertToMap(new int[]{1}, new Move[]{Move.TACKLE}));
    
	private final int[] BaseStats;
    private final String Name;
    private final String DexNumber;
    private final Type TYPE;
    private final Map<Move, Integer> MoveSet;
    private final int ExpYield;
    private final int CatchRate;

    /**
     * Creates a brand new Pokemon Specie.
     */
    Species(String name, String dexNumber, short[] stats, int expYield, int catchRate, Type type, Map<Move, Integer> moveSet) {
        BaseStats = new int[]{stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]};
        DexNumber = dexNumber;
        Name = name;
        TYPE = type;
        MoveSet = moveSet;
        ExpYield = expYield;
        CatchRate = catchRate;
    }
    
    /**
     * Calculate Exp to Next Level
     */
    public int calculateExp(int level) {
        return (int) ((4 * Math.pow(level, 3)) / 5);
    }
    
    /**
     * Set the HashMap
     */
    private static Map<Move, Integer> convertToMap(int[] a, Move[] b) {
        Map<Move, Integer> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                m.put(b[i], a[i]);
            }
        }

        return m;
    }

    /**
     * Gets and Sets
     *
     * @return
     */
    public String getDexNumber() {
        return DexNumber;
    }

    public int getBaseStat(int stat) throws ArrayIndexOutOfBoundsException {
        return BaseStats[stat];
    }

    public String getName() {
        return Name;
    }

    public Type getType() {
        return TYPE;
    }

    public Map<Move, Integer> getLearnset() {
        return MoveSet;
    }

    public int getExpYield() {
        return ExpYield;
    }

    public int getCatchRate() {
        return CatchRate;
    }
}

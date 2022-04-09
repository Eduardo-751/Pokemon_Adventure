package Model;

public enum Move {
	
    SURF("Surf", Type.WATER, (byte) 15, 90, (byte) 100),
    DIG("Dig", Type.NORMAL, (byte) 15, 80, (byte) 100),
    CUT("Cut", Type.NORMAL, (byte) 30, 50, (byte) 95),
    
    TACKLE("Tackle", Type.NORMAL, (byte) 30, 50, (byte) 100),
    SCRATCH("Scratch", Type.NORMAL, (byte) 35, 40, (byte) 100),
    GROWL("Growl", Type.NORMAL, (byte) 40, -1, (byte) 100),
    LEECH_SEED("Leech Seed", Type.GRASS, (byte) 10, -1, (byte) 90),
    RAZOR_LEAF("Razor Leaf", Type.GRASS, (byte) 25, 55, (byte) 95),
    TAKE_DOWN("Take Down", Type.NORMAL, (byte) 20, 90, (byte) 85),
    SLEEP_POWDER("Sleep Powder", Type.GRASS, (byte) 15, -1, (byte) 75),
    SEED_BOMB("Seed Bomb", Type.GRASS, (byte) 15, 80, (byte) 100),
    SWEET_SCENT("Sweet Scent", Type.NORMAL, (byte) 20, -1, (byte) 100),
    SYNTHESIS("Synthesis", Type.GRASS, (byte) 5, -1, (byte) 100),
    WORRY_SEED("Worry Seed", Type.GRASS, (byte) 10, -1, (byte) 100),
    DOUBLE_EDGE("Double Edge", Type.NORMAL, (byte) 15, 120, (byte) 100),
    SOLAR_BEAM("Solar Beam", Type.GRASS, (byte) 10, 120, (byte) 100),
    EMBER("Ember", Type.FIRE, (byte) 25, 40, (byte) 100),
    SMOKESCREEN("Smokescreen", Type.NORMAL, (byte) 20, -1, (byte) 100),
    DRAGON_BREATH("dragon Breath", Type.DRAGON, (byte) 20, 60, (byte) 100),
    FIRE_FANG("Fire Fang", Type.FIRE, (byte) 15, 65, (byte) 95),
    SLASH("Slash", Type.NORMAL, (byte) 20, 70, (byte) 100),
    FLAMETHROWER("Flamethrwer", Type.FIRE, (byte) 15, 90, (byte) 100),
    SCARY_FACE("Scary Face", Type.NORMAL, (byte) 10, -1, (byte) 100),
    FIRE_SPIN("Fire Spin", Type.FIRE, (byte) 15, 35, (byte) 85),
    INFERNO("Inferno", Type.FIRE, (byte) 5, 100, (byte) 50),
    FLARE_BLITZ("Flare Blitz", Type.FIRE, (byte) 15, 120, (byte) 100),
    TAIL_WHIP("Tail Whip", Type.NORMAL, (byte) 30, (short) -1, (byte) 100),
    WATER_GUN("Water Gun", Type.WATER, (byte) 25, 40, (byte) 100),
    RAPID_SPIN("Rapid Spin", Type.NORMAL, (byte) 40, 50, (byte) 100),
    BITE("Bite", Type.DARK, (byte) 25, 60, (byte) 100),
    WATER_PULSE("Water Pulse", Type.WATER, (byte) 20, 60, (byte) 100),
    PROTECT("Protect", Type.NORMAL, (byte) 10, -1, (byte) 100),
    RAIN_DANCE("Rain Dance", Type.WATER, (byte) 5, -1, (byte) 100),
    AQUA_TAIL("Aqua Tail", Type.WATER, (byte) 10, 90, (byte) 90),
    SHELL_SMASH("Shell Smash", Type.NORMAL, (byte) 15, -1, (byte) 100),
    HYDRO_PUMP("Hydro Pump", Type.WATER, (byte) 5, 110, (byte) 80),
    SKULL_BASH("Skull Bash", Type.NORMAL, (byte) 10, 130, (byte) 100);

    
    private final String Name;
    private final Type TYPE;
    private final int Power;
    private final byte Accuracy;
    private final byte PP;
    private byte BattlePP;

    /**
     * Creates a Move object.
     */
    Move(String name, Type type, byte pp, int power, byte accuracy) {
        Name = name;
        TYPE = type;
        Accuracy = accuracy;
        Power = power;
        PP = pp;
        BattlePP = pp;
    }

    public void addPP(int pp) {
        BattlePP += pp;
    }

    public void downPP() {
        BattlePP--;
    }

    /**
     * Gets and Sets
     *
     * @param PP
     */
    public void setPP(byte PP) {
        BattlePP = PP;
    }

    public int getCurrentPP() {
        return BattlePP;
    }

    public int getTotalPP() {
        return PP;
    }

    public void resetPP() {
        BattlePP = PP;
    }

    public int getPower() {
        return Power;
    }

    public String getName() {
        return Name;
    }

    public Type getType() {
        return TYPE;
    }

    public int getAccuracy() {
        return Accuracy;
    }
}

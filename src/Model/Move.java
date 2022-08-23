package Model;

public enum Move {
	
	ABSORB("Absorb", Type.GRASS, MoveType.SPECIAL, (byte)25, 20, (byte)100),
	ACID("Acid", Type.POISON, MoveType.SPECIAL, (byte)30, 40, (byte)100),
	ACID_ARMOR("Acid Armor", Type.POISON, MoveType.STATUS, (byte)40, -1, (byte)100, new short[] {0, 0, 2, 0, 2, 0}),
	AGILITY("Agility", Type.PSYCHIC, MoveType.STATUS, (byte)30, -1, (byte)100),
	AMNESIA("Amnesia", Type.PSYCHIC, MoveType.STATUS, (byte)20, -1, (byte)100),
	AURORA_BEAM("Aurora Beam", Type.ICE, MoveType.SPECIAL, (byte)20, 65, (byte)100),
	BARRAGE("Barrage", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 15, (byte)85),
	BARRIER("Barrier", Type.PSYCHIC, MoveType.STATUS, (byte)30, -1, (byte)100),
	BIDE("Bide", Type.NORMAL, MoveType.PHYSICAL, (byte)10, -1, (byte)100),
	BIND("Bind", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 15, (byte)85),
	BITE("Bite", Type.NORMAL, MoveType.PHYSICAL, (byte)25, 60, (byte)100),
	BLIZZARD("Blizzard", Type.ICE, MoveType.SPECIAL, (byte)5, 120, (byte)70),
	BODY_SLAM("Body Slam", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 85, (byte)100),
	BONE_CLUB("Bone Club", Type.GROUND, MoveType.PHYSICAL, (byte)20, 65, (byte)85),
	BONEMERANG("Bonemerang", Type.GROUND, MoveType.PHYSICAL, (byte)10, 50, (byte)90),
	BUBBLE("Bubble", Type.WATER, MoveType.SPECIAL, (byte)30, 20, (byte)100),
	BUBBLEBEAM("BubbleBeam", Type.WATER, MoveType.SPECIAL, (byte)20, 65, (byte)100),
	CLAMP("Clamp", Type.WATER, MoveType.PHYSICAL, (byte)10, 35, (byte)85),
	COMET_PUNCH("Comet Punch", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 18, (byte)85),
	CONFUSE_RAY("Confuse Ray", Type.GHOST, MoveType.STATUS, (byte)10, -1, (byte)100),
	CONFUSION("Confusion", Type.PSYCHIC, MoveType.SPECIAL, (byte)25, 50, (byte)100),
	CONSTRICT("Constrict", Type.NORMAL, MoveType.PHYSICAL, (byte)35, 10, (byte)100),
	CONVERSION("Conversion", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100),
	COUNTER("Counter", Type.FIGHTING, MoveType.PHYSICAL, (byte)20, -1, (byte)100),
	CRABHAMMER("Crabhammer", Type.WATER, MoveType.PHYSICAL, (byte)10, 90, (byte)90),
	CUT("Cut", Type.NORMAL, MoveType.PHYSICAL, (byte)30, 50, (byte)95),
	DEFENSE_CURL("Defense Curl", Type.NORMAL, MoveType.STATUS, (byte)40, -1, (byte)100),
	DIG("Dig", Type.GROUND, MoveType.PHYSICAL, (byte)10, 80, (byte)100),
	DISABLE("Disable", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),
	DIZZY_PUNCH("Dizzy Punch", Type.NORMAL, MoveType.PHYSICAL, (byte)10, 70, (byte)100),
	DOUBLE_KICK("Double Kick", Type.FIGHTING, MoveType.PHYSICAL, (byte)30, 30, (byte)100),
	DOUBLE_TEAM("Double Team", Type.NORMAL, MoveType.STATUS, (byte)15, -1, (byte)100),
	DOUBLE_EDGE("Double-Edge", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 120, (byte)100),
	DOUBLESLAP("DoubleSlap", Type.NORMAL, MoveType.PHYSICAL, (byte)10, 15, (byte)85),
	DRAGON_RAGE("Dragon Rage", Type.DRAGON, MoveType.SPECIAL, (byte)10, 100, (byte)83),
	DREAM_EATER("Dream Eater", Type.PSYCHIC, MoveType.SPECIAL, (byte)15, 100, (byte)100),
	DRILL_PECK("Drill Peck", Type.FLYING, MoveType.PHYSICAL, (byte)20, 80, (byte)100),
	EARTHQUAKE("Earthquake", Type.GROUND, MoveType.PHYSICAL, (byte)10, 100, (byte)100),
	EGG_BOMB("Egg Bomb", Type.NORMAL, MoveType.PHYSICAL, (byte)10, 100, (byte)75),
    EMBER("Ember", Type.FIRE, MoveType.SPECIAL, (byte)25, 40, (byte)100),
    EXPLOSION("Explosion", Type.NORMAL, MoveType.PHYSICAL, (byte)5, 250, (byte)100),
    FIRE_BLAST("Fire Blast", Type.FIRE, MoveType.SPECIAL, (byte)5, 120, (byte)85),
    FIRE_PUNCH("Fire Punch", Type.FIRE, MoveType.PHYSICAL, (byte)15, 75, (byte)100),
    FIRE_SPIN("Fire Spin", Type.FIRE, MoveType.SPECIAL, (byte)15, 35, (byte)85),
    FISSURE("Fissure", Type.GROUND, MoveType.PHYSICAL, (byte)5, 200, (byte)30),
    FLAMETHROWER("Flamethrower", Type.FIRE, MoveType.SPECIAL, (byte)15, 95, (byte)100),
    FLASH("Flash", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),
    FLY("Fly", Type.FLYING, MoveType.PHYSICAL, (byte)15, 90, (byte)95),
    FOCUS_ENERGY("Focus Energy", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100),
    FURY_ATTACK("Fury Attack", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 15, (byte)85),
    FURY_SWIPES("Fury Swipes", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 18, (byte)80),
    GLARE("Glare", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)90),
    GROWTH("Growth", Type.NORMAL, MoveType.STATUS, (byte)40, -1, (byte)100),
    GROWL("Growl", Type.NORMAL, MoveType.ENEMYSTATUS, (byte)40, -1, (byte)100, new short[] {0, 1, 0, 1, 0, 0}),
    GUILLOTINE("Guillotine", Type.NORMAL, MoveType.PHYSICAL, (byte)5, 200, (byte)30),
    GUST("Gust", Type.FLYING, MoveType.SPECIAL, (byte)35, 40, (byte)100),
    HARDEN("Harden", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100, new short[] {0, 0, 2, 0, 2, 0}),
    HAZE("Haze", Type.ICE, MoveType.STATUS, (byte)30, (short)-1, (byte)100),
    HEADBUTT("Headbutt", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 70, (byte)100),
    HI_JUMP_KICK("Hi Jump Kick", Type.FIGHTING, MoveType.PHYSICAL, (byte)10, 130, (byte)90),
    HORN_ATTACK("Horn Attack", Type.NORMAL, MoveType.PHYSICAL, (byte)25, 65, (byte)100),
    HORN_DRILL("Horn Drill", Type.NORMAL, MoveType.PHYSICAL, (byte)5, 200, (byte)30),
    HYDRO_PUMP("Hydro Pump", Type.WATER, MoveType.SPECIAL, (byte)5, 120, (byte)80),
    HYPER_BEAM("Hyper Beam", Type.NORMAL, MoveType.SPECIAL, (byte)5, 150, (byte)90),
    HYPER_FANG("Hyper Fang", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 80, (byte)90),
    HYPNOSIS("Hypnosis", Type.PSYCHIC, MoveType.STATUS, (byte)20, -1, (byte)60),
    ICE_PUNCH("Ice Punch", Type.ICE, MoveType.PHYSICAL, (byte)15, 75, (byte)100),
    ICE_BEAM("Ice Beam", Type.ICE, MoveType.SPECIAL, (byte)10, 95, (byte)100),
    JUMP_KICK("Jump Kick", Type.FIGHTING, MoveType.PHYSICAL, (byte)10, 100, (byte)95),
    KARATE_CHOP("Karate Chop", Type.FIGHTING, MoveType.PHYSICAL, (byte)25, 50, (byte)100),
    KINESIS("Kinesis", Type.PSYCHIC, MoveType.STATUS, (byte)15, -1, (byte)80),
    LEECH_LIFE("Leech Life", Type.BUG, MoveType.PHYSICAL, (byte)15, 20, (byte)100),
    LEECH_SEED("Leech Seed", Type.GRASS, MoveType.STATUS, (byte)10, -1, (byte)90),
    LEER("Leer", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100),
    LICK("Lick", Type.GHOST, MoveType.PHYSICAL, (byte)30, 20, (byte)100),
    LIGHT_SCREEN("Light Screen", Type.PSYCHIC, MoveType.STATUS, (byte)30, -1, (byte)100),
    LOVELY_KISS("Lovely Kiss", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)75),
    LOW_KICK("Low Kick", Type.FIGHTING, MoveType.PHYSICAL, (byte)20, 30, (byte)100),
    MEDITATE("Meditate", Type.PSYCHIC, MoveType.STATUS, (byte)40, -1, (byte)100),
    MEGA_DRAIN("Mega Drain", Type.GRASS, MoveType.SPECIAL, (byte)15, 40, (byte)100),
    MEGA_KICK("Mega Kick", Type.NORMAL, MoveType.PHYSICAL, (byte)5, 120, (byte)75),
    MEGA_PUNCH("Mega Punch", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 80, (byte)85),
    METRONOME("Metronome", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    MIMIC("Mimic", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    MINIMIZE("Minimize", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),
    MIRROR_MOVE("Mirror Move", Type.FLYING, MoveType.STATUS, (byte)20, -1, (byte)100),
    MIST("Mist", Type.ICE, MoveType.STATUS, (byte)30, -1, (byte)100),
    NIGHT_SHADE("Night Shade", Type.GHOST, MoveType.SPECIAL, (byte)15, -1, (byte)100),
    PAY_DAY("Pay Day", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 40, (byte)100),
    PECK("Peck", Type.FLYING, MoveType.PHYSICAL, (byte)35, 35, (byte)100),
    PETAL_DANCE("Petal Dance", Type.GRASS, MoveType.SPECIAL, (byte)10, 120, (byte)100),
    PIN_MISSILE("Pin Missile", Type.BUG, MoveType.PHYSICAL, (byte)20, 14, (byte)85),
    POISON_GAS("Poison Gas", Type.POISON, MoveType.STATUS, (byte)40, -1, (byte)80),
    POISON_STING("Poison Sting", Type.POISON, MoveType.PHYSICAL, (byte)35, 15, (byte)100),
    POISONPOWDER("PoisonPowder", Type.POISON, MoveType.STATUS, (byte)35, -1, (byte)75),
    POUND("Pound", Type.NORMAL, MoveType.PHYSICAL, (byte)35, 40, (byte)100),
	PSYBEAM("Psybeam", Type.PSYCHIC, MoveType.SPECIAL, (byte)20, 65, (byte)100),
	PSYCHIC("Psychic", Type.PSYCHIC, MoveType.SPECIAL, (byte)10, 90, (byte)100),
    PSYWAVE("Psywave", Type.PSYCHIC, MoveType.SPECIAL, (byte)15, -1, (byte)80),
    QUICK_ATTACK("Quick Attack", Type.NORMAL, MoveType.PHYSICAL, (byte)30, 40, (byte)100),
    RAGE("Rage", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 20, (byte)100),
    RAZOR_LEAF("Razor Leaf", Type.GRASS, MoveType.PHYSICAL, (byte)25, 55, (byte)95),
    RAZOR_WIND("Razor Wind", Type.NORMAL, MoveType.SPECIAL, (byte)10, 80, (byte)100),
    RECOVER("Recover", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    REFLECT("Reflect", Type.PSYCHIC, MoveType.STATUS, (byte)20, -1, (byte)100),
    REST("Rest", Type.PSYCHIC, MoveType.STATUS, (byte)10, -1, (byte)100),
    ROAR("Roar", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),
    ROCK_SLIDE("Rock Slide", Type.ROCK, MoveType.PHYSICAL, (byte)10, 75, (byte)90),
    ROCK_THROW("Rock Throw", Type.ROCK, MoveType.PHYSICAL, (byte)15, 50, (byte)90),
    ROLLING_KICK("Rolling Kick", Type.FIGHTING, MoveType.PHYSICAL, (byte)15, 60, (byte)85),
    SAND_ATTACK("Sand-Attack", Type.GROUND, MoveType.ENEMYSTATUS, (byte)15, -1, (byte)100, new short[] {0, 0, 0, 0, 0, 0}),
    SCRATCH("Scratch", Type.NORMAL, MoveType.PHYSICAL, (byte)35, 40, (byte)100),
    SCREECH("Screech", Type.NORMAL, MoveType.STATUS, (byte)40, -1, (byte)85),
    SEISMIC_TOSS("Seismic Toss", Type.FIGHTING, MoveType.PHYSICAL, (byte)20, -1, (byte)100),
    SELFDESTRUCT("Selfdestruct", Type.NORMAL, MoveType.PHYSICAL, (byte)5, 200, (byte)100),
    SHARPEN("Sharpen", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100),
    SING("Sing", Type.NORMAL, MoveType.STATUS, (byte)15, -1, (byte)55),
    SKULL_BASH("Skull Bash", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 100, (byte)100),
    SKY_ATTACK("Sky Attack", Type.FLYING, MoveType.PHYSICAL, (byte)5, 140, (byte)90),
    SLAM("Slam", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 80, (byte)75),
    SLASH("Slash", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 70, (byte)100),
    SLEEP_POWDER("Sleep Powder", Type.GRASS, MoveType.STATUS, (byte)15, -1, (byte)75),
    SLUDGE("Sludge", Type.POISON, MoveType.SPECIAL, (byte)20, 65, (byte)100),
    SMOG("Smog", Type.POISON, MoveType.SPECIAL, (byte)20, 20, (byte)70),
    SMOKESCREEN("SmokeScreen", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),
    SOFTBOILED("Softboiled", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    SOLARBEAM("SolarBeam", Type.GRASS, MoveType.SPECIAL, (byte)10, 120, (byte)100),
    SONICBOOM("SonicBoom", Type.NORMAL, MoveType.SPECIAL, (byte)20, 90, (byte)50),
    SPIKE_CANNON("Spike Cannon", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 20, (byte)100),
    SPLASH("Splash", Type.NORMAL, MoveType.STATUS, (byte)40, -1, (byte)100),
    SPORE("Spore", Type.GRASS, MoveType.STATUS, (byte)15, -1, (byte)100),
    STOMP("Stomp", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 65, (byte)100),
    STRENGTH("Strength", Type.NORMAL, MoveType.PHYSICAL, (byte)15, 80, (byte)100),
    STRING_SHOT("String Shot", Type.BUG, MoveType.ENEMYSTATUS, (byte)40, -1, (byte)95, new short[] {0, 0, 0, 0, 0, 1}),
    STRUGGLE("Struggle", Type.NORMAL, MoveType.PHYSICAL, (byte)1, 50, (byte)100),
    STUN_SPORE("Stun Spore", Type.GRASS, MoveType.STATUS, (byte)30, -1, (byte)75),
    SUBMISSION("Submission", Type.FIGHTING, MoveType.PHYSICAL, (byte)25, 80, (byte)80),
    SUBSTITUTE("Substitute", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    SUPER_FANG("Super Fang", Type.NORMAL, MoveType.PHYSICAL, (byte)10, -1, (byte)90),
    SUPERSONIC("Supersonic", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)55),
    SURF("Surf", Type.WATER, MoveType.SPECIAL, (byte)15, 95, (byte)100),
    SWIFT("Swift", Type.NORMAL, MoveType.SPECIAL, (byte)20, 60, (byte)100),
    SWORDS_DANCE("Swords Dance", Type.NORMAL, MoveType.STATUS, (byte)30, -1, (byte)100),
    TACKLE("Tackle", Type.NORMAL, MoveType.PHYSICAL, (byte)30, 50, (byte)100),
    TAIL_WHIP("Tail Whip", Type.NORMAL, MoveType.ENEMYSTATUS, (byte)30, -1, (byte)100, new short[] {0, 0, 1, 0, 0, 0}),
    TAKE_DOWN("Take Down", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 90, (byte)85),
    TELEPORT("Teleport", Type.PSYCHIC, MoveType.STATUS, (byte)20, -1, (byte)100),
    THRASH("Thrash", Type.NORMAL, MoveType.PHYSICAL, (byte)10, 120, (byte)100),
    THUNDER_WAVE("Thunder Wave", Type.ELECTRIC, MoveType.STATUS, (byte)20, -1, (byte)100),
    THUNDERPUNCH("ThunderPunch", Type.ELECTRIC, MoveType.PHYSICAL, (byte)15, 75, (byte)100),
    THUNDERSHOCK("ThunderShock", Type.ELECTRIC, MoveType.SPECIAL, (byte)30, 40, (byte)100),
    THUNDERBOLT("Thunderbolt", Type.ELECTRIC, MoveType.SPECIAL, (byte)15, 95, (byte)100),
    THUNDER("Thunder", Type.ELECTRIC, MoveType.SPECIAL, (byte)10, 120, (byte)70),
    TOXIC("Toxic", Type.POISON, MoveType.STATUS, (byte)10, -1, (byte)90),
    TRANSFORM("Transform", Type.NORMAL, MoveType.STATUS, (byte)10, -1, (byte)100),
    TRI_ATTACK("Tri Attack", Type.NORMAL, MoveType.SPECIAL, (byte)10, 80, (byte)100),
    TWINEEDLE("Twineedle", Type.BUG, MoveType.PHYSICAL, (byte)20, 25, (byte)100),
	VICEGRIP("ViceGrip", Type.NORMAL, MoveType.PHYSICAL, (byte)30, 55, (byte)100),
	VINE_WHIP("Vine Whip", Type.GRASS, MoveType.PHYSICAL, (byte)15, 35, (byte)100),
	WATER_GUN("Water Gun", Type.WATER, MoveType.SPECIAL, (byte)25, 40, (byte)100),
	WATERFALL("Waterfall", Type.WATER, MoveType.PHYSICAL, (byte)15, 80, (byte)100),
	WHIRLWIND("Whirlwind", Type.NORMAL, MoveType.STATUS, (byte)20, -1, (byte)100),   
	WING_ATTACK("Wing Attack", Type.FLYING, MoveType.PHYSICAL, (byte)35, 60, (byte)100),
	WITHDRAW("Withdraw", Type.WATER, MoveType.STATUS, (byte)40, -1, (byte)100),
    WRAP("Wrap", Type.NORMAL, MoveType.PHYSICAL, (byte)20, 15, (byte)90);

    
    private final String Name;
    private final Type TYPE;
    private final MoveType Move_Type;
    private final int Power;
    private final byte Accuracy;
    private final byte PP;
    private byte BattlePP;
    private Status StatusEffect;
    private int[] StatEffect;

    //Creates a Move object without Status Effect or Stat Effect.
    Move(String name, Type type, MoveType m, byte pp, int power, byte accuracy) {
        Name = name;
        TYPE = type;
        Move_Type = m;
        Accuracy = accuracy;
        Power = power;
        PP = pp;
        BattlePP = pp;
    }
    //Creates a Move object with Status Effect.
    Move(String name, Type type, MoveType m, byte pp, int power, byte accuracy, Status status) {
        Name = name;
        TYPE = type;
        Move_Type = m;
        Accuracy = accuracy;
        Power = power;
        PP = pp;
        BattlePP = pp;
        StatusEffect = status;
    }
    //Creates a Move object with Stat Effect.
    Move(String name, Type type, MoveType m, byte pp, int power, byte accuracy, short[] stat) {
        Name = name;
        TYPE = type;
        Move_Type = m;
        Accuracy = accuracy;
        Power = power;
        PP = pp;
        BattlePP = pp;
        StatEffect = new int[]{stat[0], stat[1], stat[2], stat[3], stat[4], stat[5]};
    }
    //Creates a Move object with Status Effect and Stat Effect.
    Move(String name, Type type, MoveType m, byte pp, int power, byte accuracy, Status status, short[] stat) {
        Name = name;
        TYPE = type;
        Move_Type = m;
        Accuracy = accuracy;
        Power = power;
        PP = pp;
        BattlePP = pp;
        StatusEffect = status;
        StatEffect = new int[]{stat[0], stat[1], stat[2], stat[3], stat[4], stat[5]};
    }

    public void addPP(int pp) {
        BattlePP += pp;
    }
    public void downPP() {
        BattlePP -= 1;
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
    public MoveType getMoveType() {
            return Move_Type;
    }   
    public Status getStatusEffect() {
        return StatusEffect;
    }
    public int[] getStatEffect() {
        return StatEffect;
    }
    public int getAccuracy() {
        return Accuracy;
    }
}

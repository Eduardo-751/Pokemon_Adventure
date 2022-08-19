package Model;

import java.util.Map;
import java.util.TreeMap;

public enum Species {
  
	VENUSAUR("Venusaur", "003", null, 45, new short[] {80, 82, 83, 100, 100, 80}, 236, convertToMap(new int[] {1, 1, 1, 1, 7, 13, 22, 30, 43, 55, 65}, new Move[] { Move.TACKLE, Move.GROWL, Move.LEECH_SEED, Move.VINE_WHIP, Move.LEECH_SEED, Move.VINE_WHIP, Move.POISONPOWDER, Move.RAZOR_LEAF, Move.GROWTH,Move.SLEEP_POWDER,Move.SOLARBEAM}), Type.GRASS, Type.POISON),
	IVYSAUR("Ivysaur", "002", Species.VENUSAUR, 45, new short[] {60, 62, 63, 80, 80, 60}, 142, convertToMap(new int[] {1, 1, 7, 1, 13, 22, 30, 38, 46, 54}, new Move[] { Move.TACKLE, Move.GROWL, Move.LEECH_SEED, Move.LEECH_SEED, Move.VINE_WHIP, Move.POISONPOWDER, Move.RAZOR_LEAF, Move.GROWTH,Move.SLEEP_POWDER,Move.SOLARBEAM}), Type.GRASS, Type.POISON),
	BULBASAUR("Bulbasaur", "001", Species.IVYSAUR, 45, new short[] {45, 49, 49, 65, 65, 45}, 64, convertToMap(new int[] {1, 1, 7, 13, 20, 27, 34, 41, 48}, new Move[] { Move.TACKLE, Move.GROWL, Move.LEECH_SEED,Move.VINE_WHIP, Move.POISONPOWDER, Move.RAZOR_LEAF, Move.GROWTH,Move.SLEEP_POWDER,Move.SOLARBEAM}), Type.GRASS, Type.POISON),
	CHARIZARD("Charizard", "006", null, 45, new short[] {78, 84, 78, 109, 85, 100}, 240, convertToMap(new int[] {1, 1, 1, 1, 9, 15, 24, 36, 46, 55}, new Move[] { Move.SCRATCH, Move.GROWL, Move.EMBER, Move.LEER, Move.EMBER, Move.LEER, Move.RAGE, Move.SLASH, Move.FLAMETHROWER, Move.FIRE_SPIN}), Type.FIRE, Type.FLYING),
    CHARMELEON("Charmeleon", "005", Species.CHARIZARD, 45, new short[] {58, 64, 58, 80, 65, 80}, 142, convertToMap(new int[] {1, 1, 1, 9, 15, 22, 33, 42, 56}, new Move[] { Move.SCRATCH, Move.GROWL, Move.EMBER, Move.EMBER, Move.LEER, Move.RAGE, Move.SLASH, Move.FLAMETHROWER, Move.FIRE_SPIN}), Type.FIRE),
	CHARMANDER("Charmander", "004", Species.CHARMELEON, 45, new short[] {39, 52, 43, 60, 50, 65}, 62, convertToMap(new int[] {1, 1, 9, 15, 22, 30, 38, 46}, new Move[] { Move.SCRATCH, Move.GROWL, Move.EMBER, Move.LEER, Move.RAGE, Move.SLASH, Move.FLAMETHROWER, Move.FIRE_SPIN}), Type.FIRE),
    BLASTOISE("Blastoise", "009", null, 45, new short[] {79, 83, 100, 85, 105, 78}, 239, convertToMap(new int[] {1, 1, 1, 1, 8, 15, 24, 31, 42, 52}, new Move[] {Move.TACKLE, Move.TAIL_WHIP, Move.BUBBLE, Move.WATER_GUN, Move.BUBBLE, Move.WATER_GUN, Move.BITE, Move.WITHDRAW, Move.SKULL_BASH, Move.HYDRO_PUMP}), Type.WATER),
    WARTORTLE("Wartortle", "008", Species.BLASTOISE, 45, new short[] {59, 63, 80, 65, 80, 58}, 142, convertToMap(new int[] {1, 1, 1, 8, 15, 24, 31, 39, 47}, new Move[] {Move.TACKLE, Move.TAIL_WHIP, Move.BUBBLE, Move.BUBBLE, Move.WATER_GUN, Move.BITE, Move.WITHDRAW, Move.SKULL_BASH, Move.HYDRO_PUMP}), Type.WATER),
    SQUIRTLE("Squirtle", "007", Species.WARTORTLE, 45, new short[] {44, 48, 65, 50, 64, 43}, 63, convertToMap(new int[] {1, 1, 8, 15, 22, 28, 35, 42}, new Move[] {Move.TACKLE, Move.TAIL_WHIP, Move.BUBBLE, Move.WATER_GUN, Move.BITE, Move.WITHDRAW, Move.SKULL_BASH, Move.HYDRO_PUMP}), Type.WATER),
    BUTTERFREE("Butterfree", "012", null, 45, new short[] {60, 45, 50, 80, 80, 70}, 173, convertToMap(new int[] {1, 12, 15 , 16, 17, 21, 26, 32}, new Move[] {Move.CONFUSION, Move.CONFUSION, Move.POISONPOWDER, Move.STUN_SPORE, Move.SLEEP_POWDER, Move.SUPERSONIC, Move.WHIRLWIND, Move.PSYBEAM}), Type.BUG, Type.FLYING),
    METAPOD("Metapod", "011", Species.BUTTERFREE, 120, new short[] {50, 20, 55, 25, 25, 30}, 72, convertToMap(new int[] {1, 7}, new Move[] {Move.HARDEN, Move.HARDEN}), Type.BUG),
    CATERPIE("Caterpie", "010", Species.METAPOD, 255, new short[] {45, 30, 35, 20, 20, 45}, 39, convertToMap(new int[] {1, 1}, new Move[] {Move.TACKLE, Move.STRING_SHOT}), Type.BUG),
    BEEDRILL("Beedrill", "015", null, 45, new short[] {65, 80, 40, 45, 80, 75}, 173, convertToMap(new int[] {1, 12, 16, 20, 25, 30, 35}, new Move[] {Move.FURY_ATTACK, Move.FURY_ATTACK, Move.FOCUS_ENERGY, Move.TWINEEDLE, Move.RAGE, Move.PIN_MISSILE, Move.AGILITY}), Type.BUG, Type.POISON),
    KAKUNA("Kakuna", "014", Species.BEEDRILL, 120, new short[] {45, 25, 50, 25, 25, 35}, 72, convertToMap(new int[] {1}, new Move[] {Move.HARDEN}), Type.BUG, Type.POISON),
    WEEDLE("Weedle", "013", Species.KAKUNA, 255, new short[] {40, 35, 30, 20, 20, 50}, 39, convertToMap(new int[] {1, 1}, new Move[] {Move.POISON_STING, Move.STRING_SHOT}), Type.BUG, Type.POISON),
    PIDGEOT("Pidgeot", "018", null, 45, new short[] {83, 80, 75, 70, 70, 91}, 172, convertToMap(new int[] {1, 1, 1, 5, 12, 21, 31, 44, 54}, new Move[] {Move.GUST, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.WHIRLWIND, Move.WING_ATTACK, Move.AGILITY, Move.MIRROR_MOVE}), Type.NORMAL, Type.FLYING),
    PIDGEOTTO("Pidgeotto", "017", Species.PIDGEOT, 120, new short[] {63, 60, 55, 50, 50, 71}, 113, convertToMap(new int[] {1, 1, 5, 12, 21, 31, 40, 49}, new Move[] {Move.GUST, Move.SAND_ATTACK, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.WHIRLWIND, Move.WING_ATTACK, Move.AGILITY, Move.MIRROR_MOVE}), Type.NORMAL, Type.FLYING),
    PIDGEY("Pidgey", "016", Species.PIDGEOTTO, 255, new short[] {40, 45, 40, 35, 35, 56}, 50, convertToMap(new int[] {1, 5, 12, 19, 28, 36, 44}, new Move[] {Move.GUST, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.WHIRLWIND, Move.WING_ATTACK, Move.AGILITY, Move.MIRROR_MOVE}), Type.NORMAL, Type.FLYING),
    RATICATE("Raticate", "020", null, 127, new short[] {55, 81, 60, 50, 70, 97}, 116, convertToMap(new int[] {1, 1, 1, 7, 14, 37, 41}, new Move[] {Move.TACKLE, Move.QUICK_ATTACK, Move.TAIL_WHIP, Move.QUICK_ATTACK, Move.HYPER_FANG, Move.FOCUS_ENERGY, Move.SUPER_FANG}), Type.NORMAL),
    RATTATA("Rattata", "019", Species.RATICATE, 255, new short[] {30, 56, 35, 25, 35, 72}, 57, convertToMap(new int[] {1, 1, 7, 14, 23, 34}, new Move[] {Move.TACKLE, Move.TAIL_WHIP, Move.QUICK_ATTACK, Move.HYPER_FANG, Move.FOCUS_ENERGY, Move.SUPER_FANG}), Type.NORMAL),
    FEAROW("Fearow", "022", null, 90, new short[] {65, 90, 65, 61, 61, 100}, 162, convertToMap(new int[] {1, 1, 1, 9, 15, 25, 34, 43}, new Move[] {Move.PECK, Move.LEER, Move.GROWL, Move.LEER, Move.FURY_ATTACK, Move.MIRROR_MOVE, Move.DRILL_PECK, Move.AGILITY}), Type.NORMAL, Type.FLYING),
    SPEAROW("Spearow", "021", Species.FEAROW, 255, new short[] {40, 60, 30, 31, 31, 70}, 58, convertToMap(new int[] {1, 1, 9, 15, 22, 29, 36}, new Move[] {Move.PECK, Move.GROWL, Move.LEER, Move.FURY_ATTACK, Move.MIRROR_MOVE, Move.DRILL_PECK, Move.AGILITY}), Type.NORMAL, Type.FLYING),
    ARBOK("Arbok", "024", null, 90, new short[] {60, 85, 69, 65, 79, 80}, 147, convertToMap(new int[] {1, 1, 1, 10, 17, 27, 36, 47}, new Move[] {Move.WRAP, Move.POISON_STING, Move.LEER, Move.POISON_STING, Move.BITE, Move.GLARE, Move.SCREECH, Move.ACID}), Type.POISON),
    EKANS("Ekans", "023", Species.ARBOK, 255, new short[] {35, 60, 44, 40, 54, 55}, 62, convertToMap(new int[] {1, 1, 10, 17, 24, 31,38}, new Move[] {Move.WRAP, Move.LEER, Move.POISON_STING, Move.BITE, Move.GLARE, Move.SCREECH, Move.ACID}), Type.POISON),
    RAICHU("Raichu", "026", null, 75, new short[] {60, 90, 55, 90, 80, 100}, 122, convertToMap(new int[] {1, 1, 1}, new Move[] {Move.THUNDERSHOCK, Move.GROWL, Move.THUNDER_WAVE}), Type.ELECTRIC),
    PIKACHU("Pikachu", "025", Species.RAICHU, 190, new short[] {35, 55, 30, 50, 40, 90}, 82, convertToMap(new int[] {1, 1, 6, 8, 11, 15, 20, 26, 33, 41, 50}, new Move[] {Move.THUNDERSHOCK, Move.GROWL, Move.TAIL_WHIP, Move.THUNDER_WAVE, Move.QUICK_ATTACK, Move.DOUBLE_TEAM, Move.SLAM, Move.THUNDERBOLT, Move.AGILITY, Move.THUNDER, Move.LIGHT_SCREEN}), Type.ELECTRIC),
    SANDSLASH("Sandslash", "028", null, 90, new short[] {75, 100, 110, 45, 55, 65}, 163, convertToMap(new int[] {1, 1, 10, 17, 27, 36, 47}, new Move[] {Move.SCRATCH, Move.SAND_ATTACK, Move.SAND_ATTACK, Move.SLASH, Move.POISON_STING, Move.SWIFT, Move.FURY_ATTACK}), Type.GROUND),
    SANDSHREW("Sandshrew", "027", Species.SANDSLASH, 255, new short[] {50, 75, 85, 20, 30, 40}, 93, convertToMap(new int[] {1, 10, 17, 24, 31, 38}, new Move[] {Move.SCRATCH, Move.SAND_ATTACK, Move.SLASH, Move.POISON_STING, Move.SWIFT, Move.FURY_ATTACK}), Type.GROUND),
    NIDOQUEEN("Nidoqueen", "031", null, 45, new short[] {90, 82, 87, 75, 85, 76}, 194, convertToMap(new int[] {1, 1, 1, 1, 8, 14, 23}, new Move[] {Move.TACKLE, Move.SCRATCH, Move.TAIL_WHIP, Move.BODY_SLAM, Move.SCRATCH, Move.POISON_STING, Move.BODY_SLAM}), Type.POISON, Type.GROUND),
    NIDORINA("Nidorina", "030", Species.NIDOQUEEN, 120, new short[] {70, 62, 67, 55, 55, 56}, 117, convertToMap(new int[] {1, 1, 1, 8, 14, 23, 32, 41, 50}, new Move[] {Move.GROWL, Move.SCRATCH, Move.TACKLE, Move.SCRATCH, Move.POISON_STING, Move.TAIL_WHIP, Move.BITE, Move.FURY_SWIPES, Move.DOUBLE_KICK}), Type.POISON),
    NIDORAN_FEMALE("Nidoran", "029", Species.NIDORINA, 235, new short[] {55, 47, 52, 40, 40, 41}, 59, convertToMap(new int[] {1, 1, 8, 14, 21, 29, 36, 43}, new Move[] {Move.GROWL, Move.TACKLE, Move.SCRATCH, Move.POISON_STING, Move.TAIL_WHIP, Move.BITE, Move.FURY_SWIPES, Move.DOUBLE_KICK}), Type.POISON),
    NIDOKING("Nidoking", "034", null, 45, new short[] {81, 92, 77, 85, 75, 85}, 195, convertToMap(new int[] {1, 1, 1, 1, 8, 14, 23}, new Move[] {Move.TACKLE, Move.HORN_ATTACK, Move.POISON_STING, Move.THRASH, Move.HORN_ATTACK, Move.POISON_STING, Move.THRASH}), Type.POISON, Type.GROUND),
    NIDORINO("Nidorino", "033", Species.NIDOKING, 120, new short[] {61, 72, 57, 55, 55, 65}, 118, convertToMap(new int[] {1, 1, 1, 8, 14, 23, 32, 41, 50}, new Move[] {Move.LEER, Move.HORN_ATTACK, Move.TACKLE, Move.HORN_ATTACK, Move.POISON_STING, Move.FOCUS_ENERGY, Move.FURY_ATTACK, Move.HORN_DRILL, Move.DOUBLE_KICK}), Type.POISON),
    NIDORAN_MALE("Nidoran", "032", Species.NIDORINO, 235, new short[] {46, 57, 40, 40, 40, 50}, 60, convertToMap(new int[] {1, 1, 8, 14, 21, 29, 36, 43}, new Move[] {Move.LEER, Move.TACKLE, Move.HORN_ATTACK, Move.POISON_STING, Move.FOCUS_ENERGY, Move.FURY_ATTACK, Move.HORN_DRILL, Move.DOUBLE_KICK}), Type.POISON),
    CLEFABLE("Clefable", "036", null, 25, new short[] {95, 70, 73, 85, 90, 60}, 129, convertToMap(new int[] {1, 1, 1, 1}, new Move[] {Move.SING, Move.DOUBLESLAP, Move.MINIMIZE, Move.METRONOME}), Type.NORMAL),
    CLEFAIRY("Clefairy", "035", Species.CLEFABLE, 150, new short[] {70, 45, 48, 60, 65, 35}, 68, convertToMap(new int[] {1, 1, 13, 18, 24, 31, 39, 48}, new Move[] {Move.POUND, Move.GROWL, Move.SING, Move.DOUBLESLAP, Move.MINIMIZE, Move.METRONOME, Move.DEFENSE_CURL, Move.LIGHT_SCREEN}), Type.NORMAL),
    NINETALES("Ninetales", "038", null, 75, new short[] {73, 76, 75, 81, 100, 100}, 178,convertToMap(new int[] {1, 1, 1, 1}, new Move[] {Move.EMBER, Move.TAIL_WHIP, Move.QUICK_ATTACK, Move.ROAR}), Type.FIRE),
    VULPIX("Vulpix", "037", Species.NINETALES, 190, new short[] {38, 41, 40, 50, 65, 65}, 63, convertToMap(new int[] {1, 1, 16, 21, 28, 35, 42}, new Move[] {Move.EMBER, Move.TAIL_WHIP, Move.QUICK_ATTACK, Move.ROAR, Move.CONFUSE_RAY, Move.FLAMETHROWER, Move.FIRE_SPIN}), Type.FIRE),
    WIGGLYTUFF("Wigglytuff", "040", null, 50, new short[] {140, 70, 45, 75, 50, 45}, 109, convertToMap(new int[] {1, 1, 1, 1}, new Move[] {Move.SING, Move.DISABLE, Move.DEFENSE_CURL, Move.DOUBLESLAP}), Type.NORMAL),
    JIGGLYPUFF("Jigglypuff", "039", Species.WIGGLYTUFF, 170, new short[] {115, 45, 20, 45, 25, 20}, 76, convertToMap(new int[] {1, 9, 14, 19, 24, 29, 34, 39}, new Move[] {Move.SING, Move.POUND, Move.DISABLE, Move.DEFENSE_CURL, Move.DOUBLESLAP, Move.REST, Move.BODY_SLAM, Move.DOUBLE_EDGE}), Type.NORMAL),
    GOLBAT("Golbat", "042", null, 90, new short[] {75, 80, 70, 65, 75, 90}, 171, convertToMap(new int[] {1, 1, 1, 10, 15, 21, 32, 43}, new Move[] {Move.LEECH_LIFE, Move.BITE, Move.SCREECH, Move.SUPERSONIC, Move.BITE, Move.CONFUSE_RAY, Move.WING_ATTACK, Move.HAZE}), Type.POISON, Type.FLYING),
    ZUBAT("Zubat", "041", Species.GOLBAT, 255, new short[] {40, 45, 35, 30, 40, 55}, 54, convertToMap(new int[] {1, 10, 15, 21, 28, 36}, new Move[] {Move.LEECH_LIFE, Move.SUPERSONIC, Move.BITE, Move.CONFUSE_RAY, Move.WING_ATTACK, Move.HAZE}), Type.POISON, Type.FLYING),
    VILEPLUME("Vileplume", "045", null, 45, new short[] {75, 80, 85, 100, 90, 50}, 184, convertToMap(new int[] {1, 1, 1, 1, 15, 17, 19}, new Move[] {Move.STUN_SPORE, Move.SLEEP_POWDER, Move.ACID, Move.PETAL_DANCE, Move.POISONPOWDER, Move.STUN_SPORE, Move.SLEEP_POWDER}), Type.GRASS, Type.POISON),
    GLOOM("Gloom", "044", Species.VILEPLUME, 120, new short[] {60, 65, 70, 85, 75, 40}, 132, convertToMap(new int[] {1, 1, 1, 15, 17, 19, 28, 38, 52}, new Move[] {Move.ABSORB, Move.POISONPOWDER, Move.STUN_SPORE, Move.POISONPOWDER, Move.STUN_SPORE, Move.SLEEP_POWDER, Move.ACID, Move.PETAL_DANCE, Move.SOLARBEAM}), Type.GRASS, Type.POISON),
    ODDISH("Oddish", "043", Species.GLOOM, 255, new short[] {45, 50, 55, 75, 65, 30}, 78, convertToMap(new int[] {1, 15, 17, 19, 24, 33, 46}, new Move[] {Move.ABSORB, Move.POISONPOWDER, Move.STUN_SPORE, Move.SLEEP_POWDER, Move.ACID, Move.PETAL_DANCE, Move.SOLARBEAM}), Type.GRASS, Type.POISON),
    PARASECT("Parasect", "047", null, 75, new short[] {60, 95, 80, 60, 80, 30}, 128, convertToMap(new int[] {1, 1, 1, 13, 20, 30, 39, 48}, new Move[] {Move.SCRATCH, Move.STUN_SPORE, Move.LEECH_LIFE, Move.STUN_SPORE, Move.LEECH_LIFE, Move.SPORE, Move.SLASH, Move.GROWTH}), Type.BUG, Type.GRASS),
    PARAS("Paras", "046", Species.PARASECT, 190, new short[] {35, 70, 55, 45, 55, 25}, 70, convertToMap(new int[] {1, 13, 20, 27, 34, 41}, new Move[] {Move.SCRATCH, Move.STUN_SPORE, Move.LEECH_LIFE, Move.SPORE, Move.SLASH, Move.GROWTH}), Type.BUG, Type.GRASS),
    VENOMOTH("Venomoth", "049", null, 75, new short[] {70, 65, 60, 90, 75, 90}, 138, convertToMap(new int[] {1, 1, 1, 1, 24, 27, 30, 38, 43, 50}, new Move[] {Move.TACKLE, Move.DISABLE, Move.POISONPOWDER, Move.LEECH_LIFE, Move.POISONPOWDER, Move.LEECH_LIFE, Move.STUN_SPORE, Move.PSYBEAM, Move.SLEEP_POWDER, Move.PSYCHIC}), Type.BUG, Type.POISON),
    VENONAT("Venonat", "048", Species.VENOMOTH, 190, new short[] {60, 55, 50, 40, 55, 45}, 75, convertToMap(new int[] {1, 1, 24, 27, 30, 35, 38, 43}, new Move[] {Move.TACKLE, Move.DISABLE, Move.POISONPOWDER, Move.LEECH_LIFE, Move.STUN_SPORE, Move.PSYBEAM, Move.SLEEP_POWDER, Move.PSYCHIC}), Type.BUG, Type.POISON),
    DUGTRIO("Dugtrio", "051", null, 50, new short[] {35, 80, 50, 50, 70, 120}, 153, convertToMap(new int[] {1, 1, 1, 15, 19, 24, 35, 47}, new Move[] {Move.SCRATCH, Move.GROWL, Move.DIG, Move.GROWL, Move.DIG, Move.SAND_ATTACK, Move.SLASH, Move.EARTHQUAKE}), Type.GROUND),
    DIGLETT("Diglett", "050", Species.DUGTRIO, 255, new short[] {10, 55, 25, 35, 45, 95}, 81, convertToMap(new int[] {1, 15, 19, 24, 31, 40}, new Move[] {Move.SCRATCH, Move.GROWL, Move.DIG, Move.SAND_ATTACK, Move.SLASH, Move.EARTHQUAKE}), Type.GROUND),
    PERSIAN("Persian", "053", null, 90, new short[] {65, 70, 60, 65, 65, 115}, 154, convertToMap(new int[] {1, 1, 1, 1, 12, 17, 24, 37, 51}, new Move[] {Move.SCRATCH, Move.GROWL, Move.BITE, Move.SCREECH, Move.BITE, Move.PAY_DAY, Move.SCREECH, Move.FURY_SWIPES, Move.SLASH}), Type.NORMAL),
    MEOWTH("Meowth", "052", Species.PERSIAN, 255, new short[] {40, 45, 35, 40, 40, 90}, 69, convertToMap(new int[] {1, 1, 12, 17, 24, 33, 44}, new Move[] {Move.SCRATCH, Move.GROWL, Move.BITE, Move.PAY_DAY, Move.SCREECH, Move.FURY_SWIPES, Move.SLASH}), Type.NORMAL),
    GOLDUCK("Golduck", "055", null, 75, new short[] {80, 82, 78, 95, 80, 85}, 175, convertToMap(new int[] {1, 1, 1, 28, 31, 39, 48, 59}, new Move[] {Move.SCRATCH, Move.TAIL_WHIP, Move.DISABLE, Move.TAIL_WHIP, Move.DISABLE, Move.CONFUSION, Move.FURY_SWIPES, Move.HYDRO_PUMP}), Type.WATER),
    PSYDUCK("Psyduck", "054", Species.GOLDUCK, 190, new short[] {50, 52, 48, 65, 50, 55}, 64, convertToMap(new int[] {1, 28, 31, 36, 43, 52}, new Move[] {Move.SCRATCH, Move.TAIL_WHIP, Move.DISABLE, Move.CONFUSION, Move.FURY_SWIPES, Move.HYDRO_PUMP}), Type.WATER),
    PRIMEAPE("Primeape", "057", null, 75, new short[] {65, 105, 60, 60, 70, 95}, 159, convertToMap(new int[] {1, 1, 1, 1, 15, 21, 27, 37, 46}, new Move[] {Move.SCRATCH, Move.LEER, Move.KARATE_CHOP, Move.FURY_SWIPES, Move.KARATE_CHOP, Move.FURY_SWIPES, Move.FOCUS_ENERGY, Move.SEISMIC_TOSS, Move.THRASH}), Type.FIGHTING),
    MANKEY("Mankey", "056", Species.PRIMEAPE, 190, new short[] {40, 80, 35, 35, 45, 70}, 61, convertToMap(new int[] {1, 1, 15, 21, 27, 33, 39}, new Move[] {Move.SCRATCH, Move.LEER, Move.KARATE_CHOP, Move.FURY_SWIPES, Move.FOCUS_ENERGY, Move.SEISMIC_TOSS, Move.THRASH}), Type.FIGHTING),
    ARCANINE("Arcanine", "059", null, 75, new short[] {90, 110, 80, 100, 80, 95}, 194, convertToMap(new int[] {1, 1, 1, 1}, new Move[] {Move.ROAR, Move.EMBER, Move.LEER, Move.TAKE_DOWN}), Type.FIRE),
    GROWLITHE("ithe", "058", Species.ARCANINE, 190, new short[] {55, 70, 45, 70, 50, 60}, 70, convertToMap(new int[] {1, 1, 18, 23, 30, 39, 50}, new Move[] {Move.BITE, Move.ROAR, Move.EMBER, Move.LEER, Move.TAKE_DOWN, Move.AGILITY, Move.FLAMETHROWER}), Type.FIRE),
    POLIWRATH("Poliwrath", "062", null, 45, new short[] {90, 85, 95, 70, 90, 70}, 225, convertToMap(new int[] {1, 1, 1, 1, 16, 19}, new Move[] {Move.HYPNOSIS, Move.WATER_GUN, Move.DOUBLESLAP, Move.BODY_SLAM, Move.HYPNOSIS, Move.WATER_GUN}), Type.WATER, Type.FIGHTING),
    POLIWHIRL("Poliwhirl", "061", Species.POLIWRATH, 120, new short[] {65, 65, 65, 50, 50, 90}, 135, convertToMap(new int[] {1, 1, 1, 16, 19, 26, 33, 41, 49}, new Move[] {Move.BUBBLE, Move.HYPNOSIS, Move.WATER_GUN, Move.HYPNOSIS, Move.WATER_GUN, Move.DOUBLESLAP, Move.BODY_SLAM, Move.AMNESIA, Move.HYDRO_PUMP}), Type.WATER),
    POLIWAG("Poliwag", "060", Species.POLIWHIRL, 255, new short[] {40, 50, 40, 40, 40, 90}, 60, convertToMap(new int[] {1, 16, 19, 25, 31, 38, 45}, new Move[] {Move.BUBBLE, Move.HYPNOSIS, Move.WATER_GUN, Move.DOUBLESLAP, Move.BODY_SLAM, Move.AMNESIA, Move.HYDRO_PUMP}), Type.WATER),
    ALAKAZAM("Alakazam", "065", null, 50, new short[] {55, 50, 45, 135, 85, 120}, 221, convertToMap(new int[] {1, 1, 1, 16, 20, 27, 31, 38, 42}, new Move[] {Move.TELEPORT, Move.CONFUSION, Move.DISABLE, Move.CONFUSION, Move.DISABLE, Move.PSYBEAM, Move.RECOVER, Move.PSYCHIC, Move.REFLECT}), Type.PSYCHIC),
    KADABRA("Kadabra", "064", Species.ALAKAZAM, 100, new short[] {40, 35, 30, 120, 70, 105}, 140, convertToMap(new int[] {1, 1, 1, 16, 20, 27, 31, 38, 42}, new Move[] {Move.TELEPORT, Move.CONFUSION, Move.DISABLE, Move.CONFUSION, Move.DISABLE, Move.PSYBEAM, Move.RECOVER, Move.PSYCHIC, Move.REFLECT}), Type.PSYCHIC),
    ABRA("Abra", "063", Species.KADABRA, 200, new short[] {25, 20, 15, 105, 55, 90}, 62, convertToMap(new int[] {1}, new Move[] {Move.TELEPORT}), Type.PSYCHIC),
    MACHAMP("Machamp", "068", null, 45, new short[] {90, 130, 80, 65, 85, 55}, 227, convertToMap(new int[] {1, 1, 1, 20, 25, 36, 44, 52}, new Move[] {Move.KARATE_CHOP, Move.LOW_KICK, Move.LEER, Move.LOW_KICK, Move.LEER, Move.FOCUS_ENERGY, Move.SEISMIC_TOSS, Move.SUBMISSION}), Type.FIGHTING),
    MACHOKE("Machoke", "067", Species.MACHAMP, 90, new short[] {80, 100, 70, 50, 60, 45}, 142, convertToMap(new int[] {1, 1, 1, 20, 25, 36, 44, 52}, new Move[] {Move.KARATE_CHOP, Move.LOW_KICK, Move.LEER, Move.LOW_KICK, Move.LEER, Move.FOCUS_ENERGY, Move.SEISMIC_TOSS, Move.SUBMISSION}), Type.FIGHTING),
    MACHOP("Machop", "066", Species.MACHOKE, 180, new short[] {70, 80, 50, 35, 35, 35}, 61, convertToMap(new int[] {1, 20, 25, 32, 39, 46}, new Move[] {Move.KARATE_CHOP, Move.LOW_KICK, Move.LEER, Move.FOCUS_ENERGY, Move.SEISMIC_TOSS, Move.SUBMISSION}), Type.FIGHTING),
    VICTREEBEL("Victreebel", "071", null, 45, new short[] {80, 105, 65, 100, 60, 70}, 216, convertToMap(new int[] {1, 1, 1, 1, 13, 15, 18}, new Move[] {Move.SLEEP_POWDER, Move.STUN_SPORE, Move.ACID, Move.RAZOR_LEAF, Move.WRAP,  Move.POISONPOWDER, Move.SLEEP_POWDER}), Type.GRASS, Type.POISON),
    WEEPINBELL("Weepinbell", "070", Species.VICTREEBEL, 120, new short[] {65, 90, 50, 85, 45, 55}, 137, convertToMap(new int[] {1, 1, 1, 13, 15, 18, 23, 29, 38, 49}, new Move[] {Move.VINE_WHIP, Move.GROWTH, Move.WRAP, Move.WRAP, Move.POISONPOWDER, Move.SLEEP_POWDER, Move.STUN_SPORE, Move.ACID, Move.RAZOR_LEAF, Move.SLAM}), Type.GRASS, Type.POISON),
    BELLSPROUT("Bellsprout", "069", Species.WEEPINBELL, 255, new short[] {50, 75, 35, 70, 30, 40}, 60, convertToMap(new int[] {1, 1, 13, 15, 18, 21, 26, 33, 42}, new Move[] {Move.VINE_WHIP, Move.GROWTH, Move.WRAP, Move.POISONPOWDER, Move.SLEEP_POWDER, Move.STUN_SPORE, Move.ACID, Move.RAZOR_LEAF, Move.SLAM}), Type.GRASS, Type.POISON),
    TENTACRUEL("Tentacruel", "073", null, 60, new short[] {80, 70, 65, 80, 120, 100}, 180, convertToMap(new int[] {1, 1, 1, 7, 13, 18, 22, 27, 35, 43, 50}, new Move[] {Move.ACID, Move.SUPERSONIC, Move.WRAP, Move.SUPERSONIC, Move.WRAP, Move.POISON_STING, Move.WATER_GUN, Move.CONSTRICT, Move.BARRIER, Move.SCREECH, Move.HYDRO_PUMP}), Type.WATER, Type.POISON),
    TENTACOOL("Tentacool", "072", Species.TENTACRUEL, 190, new short[] {40, 40, 35, 50, 100, 70}, 67, convertToMap(new int[] {1, 7, 13, 18, 22, 27, 33, 40, 48}, new Move[] {Move.ACID, Move.SUPERSONIC, Move.WRAP, Move.POISON_STING, Move.WATER_GUN, Move.CONSTRICT, Move.BARRIER, Move.SCREECH, Move.HYDRO_PUMP}), Type.WATER, Type.POISON),
    GOLEM("Golem", "076", null, 45, new short[] {80, 110, 130, 55, 65, 45}, 218, convertToMap(new int[] {1, 1, 11, 16, 21, 29, 36, 43}, new Move[] {Move.TACKLE, Move.DEFENSE_CURL, Move.DEFENSE_CURL, Move.ROCK_THROW, Move.SELFDESTRUCT, Move.HARDEN, Move.EARTHQUAKE, Move.EXPLOSION}), Type.ROCK, Type.GROUND),
    GRAVELER("Graveler", "075", Species.GOLEM, 120, new short[] {55, 95, 115, 45, 45, 35}, 134, convertToMap(new int[] {1, 1, 11, 16, 21, 29, 36, 43}, new Move[] {Move.TACKLE, Move.DEFENSE_CURL, Move.DEFENSE_CURL, Move.ROCK_THROW, Move.SELFDESTRUCT, Move.HARDEN, Move.EARTHQUAKE, Move.EXPLOSION}), Type.ROCK, Type.GROUND),
    GEODUDE("Geodude", "074", Species.GRAVELER, 255, new short[] {40, 80, 100, 30, 30, 20}, 73, convertToMap(new int[] {1, 11, 16, 21, 26, 31, 36}, new Move[] {Move.TACKLE, Move.DEFENSE_CURL, Move.ROCK_THROW, Move.SELFDESTRUCT, Move.HARDEN, Move.EARTHQUAKE, Move.EXPLOSION}), Type.ROCK, Type.GROUND),
    RAPIDASH("Rapidash", "078", null, 60, new short[] {65, 100, 70, 80, 80, 105}, 175, convertToMap(new int[] {1, 1, 1, 1, 30, 32, 35, 39, 47, 55}, new Move[] {Move.EMBER, Move.TAIL_WHIP, Move.STOMP, Move.GROWL, Move.TAIL_WHIP, Move.STOMP, Move.GROWL, Move.FIRE_SPIN, Move.TAKE_DOWN, Move.AGILITY}), Type.FIRE),
    PONYTA("Ponyta", "077", Species.RAPIDASH, 190, new short[] {50, 85, 55, 65, 65, 90}, 82, convertToMap(new int[] {1, 30, 32, 35, 39, 43, 48}, new Move[] {Move.EMBER, Move.TAIL_WHIP, Move.STOMP, Move.GROWL, Move.FIRE_SPIN, Move.TAKE_DOWN, Move.AGILITY}), Type.FIRE),
    SLOWBRO("Slowbro", "080", null, 75, new short[] {95, 75, 110, 100, 80, 30}, 172, convertToMap(new int[] {1, 1, 1, 18, 22, 27, 33, 37, 44, 55}, new Move[] {Move.CONFUSION, Move.DISABLE, Move.HEADBUTT, Move.DISABLE, Move.HEADBUTT, Move.GROWL, Move.WATER_GUN, Move.WITHDRAW, Move.AMNESIA, Move.PSYCHIC}), Type.WATER, Type.PSYCHIC),
    SLOWPOKE("Slowpoke", "079", Species.SLOWBRO, 190, new short[] {90, 65, 65, 40, 40, 15}, 63, convertToMap(new int[] {1, 18, 22, 27, 33, 40, 48}, new Move[] {Move.CONFUSION, Move.DISABLE, Move.HEADBUTT, Move.GROWL, Move.WATER_GUN, Move.AMNESIA, Move.PSYCHIC}), Type.WATER, Type.PSYCHIC),
    MAGNETON("Magneton", "082", null, 60, new short[] {50, 60, 95, 120, 70, 70}, 163, convertToMap(new int[] {1, 1, 1, 21, 25, 29, 38, 46, 54}, new Move[] {Move.TACKLE, Move.SONICBOOM, Move.THUNDERSHOCK, Move.SONICBOOM, Move.THUNDERSHOCK, Move.SUPERSONIC, Move.THUNDER_WAVE, Move.SWIFT, Move.SCREECH}), Type.ELECTRIC),
    MAGNEMITE("Magnemite", "081", Species.MAGNETON, 190, new short[] {25, 35, 70, 95, 55, 45}, 65, convertToMap(new int[] {1, 21, 25, 29, 35, 41, 47}, new Move[] {Move.TACKLE, Move.SONICBOOM, Move.THUNDERSHOCK, Move.SUPERSONIC, Move.THUNDER_WAVE, Move.SWIFT, Move.SCREECH}), Type.ELECTRIC),
    FARFETCH_D("Farfetch%27d", "083", null, 45, new short[] {52, 65, 55, 58, 62, 60}, 123, convertToMap(new int[] {1, 1, 7, 15, 23, 31, 39}, new Move[] {Move.PECK, Move.SAND_ATTACK, Move.LEER, Move.FURY_ATTACK, Move.SWORDS_DANCE, Move.AGILITY, Move.SLASH}), Type.NORMAL, Type.FLYING),
    DODRIO("Dodrio", "085", null, 45, new short[] {60, 110, 70, 60, 60, 100}, 161, convertToMap(new int[] {1, 1, 1, 20, 24, 30, 39, 45, 51}, new Move[] {Move.PECK, Move.GROWL, Move.FURY_ATTACK, Move.GROWL, Move.FURY_ATTACK, Move.DRILL_PECK, Move.RAGE, Move.TRI_ATTACK, Move.AGILITY}), Type.NORMAL, Type.FLYING),
    DODUO("Doduo", "084", Species.DODRIO, 190, new short[] {35, 85, 45, 35, 35, 75}, 62, convertToMap(new int[] {1, 20, 24, 30, 36, 40, 44}, new Move[] {Move.PECK, Move.GROWL, Move.FURY_ATTACK, Move.DRILL_PECK, Move.RAGE, Move.TRI_ATTACK, Move.AGILITY}), Type.NORMAL, Type.FLYING),
    DEWGONG("Dewgong", "087", null, 75, new short[] {90, 70, 80, 70, 95, 70}, 166, convertToMap(new int[] {1, 1, 1, 30, 35, 44, 50, 56}, new Move[] {Move.HEADBUTT, Move.GROWL, Move.AURORA_BEAM, Move.GROWL, Move.AURORA_BEAM, Move.REST, Move.TAKE_DOWN, Move.ICE_BEAM}), Type.WATER, Type.ICE),
    SEEL("Seel", "086", Species.DEWGONG, 190, new short[] {65, 45, 55, 45, 70, 45}, 65, convertToMap(new int[] {1, 30, 35, 40, 45, 50}, new Move[] {Move.HEADBUTT, Move.GROWL, Move.AURORA_BEAM, Move.REST, Move.TAKE_DOWN, Move.ICE_BEAM}), Type.WATER),
    MUK("Muk", "089", null, 75, new short[] {105, 105, 75, 65, 100, 50}, 175, convertToMap(new int[] {1, 1, 1, 30, 33, 37, 45, 53, 60}, new Move[] {Move.POUND, Move.DISABLE, Move.POISON_GAS, Move.POISON_GAS, Move.MINIMIZE, Move.SLUDGE, Move.HARDEN, Move.SCREECH, Move.ACID_ARMOR}), Type.POISON),
    GRIMER("Grimer", "088", Species.MUK, 190, new short[] {80, 80, 50, 40, 50, 25}, 65, convertToMap(new int[] {1, 1, 30, 33, 37, 42, 48, 55}, new Move[] {Move.POUND, Move.DISABLE, Move.POISON_GAS, Move.MINIMIZE, Move.SLUDGE, Move.HARDEN, Move.SCREECH, Move.ACID_ARMOR}), Type.POISON),
    CLOYSTER("Cloyster", "091", null, 60, new short[] {50, 95, 180, 85, 45, 70}, 184, convertToMap(new int[] {1, 1, 1, 1, 50}, new Move[] {Move.WITHDRAW, Move.SUPERSONIC, Move.CLAMP, Move.AURORA_BEAM, Move.SPIKE_CANNON}), Type.WATER, Type.ICE),
    SHELLDER("Shellder", "090", Species.CLOYSTER, 190, new short[] {30, 65, 100, 45, 25, 40}, 61, convertToMap(new int[] {1, 1, 18, 23, 30, 39, 50}, new Move[] {Move.TACKLE, Move.WITHDRAW, Move.SUPERSONIC, Move.CLAMP, Move.AURORA_BEAM, Move.LEER, Move.ICE_BEAM}), Type.WATER),
    GENGAR("Gengar", "094", null, 45, new short[] {60, 65, 60, 130, 75, 110}, 225, convertToMap(new int[] {1, 1, 1, 29, 38}, new Move[] {Move.LICK, Move.CONFUSE_RAY, Move.NIGHT_SHADE, Move.HYPNOSIS, Move.DREAM_EATER}), Type.GHOST, Type.POISON),
    HAUNTER("Haunter", "093", Species.GENGAR, 90, new short[] {45, 50, 45, 115, 55, 95}, 142, convertToMap(new int[] {1, 1, 1, 29, 38}, new Move[] {Move.LICK, Move.CONFUSE_RAY, Move.NIGHT_SHADE, Move.HYPNOSIS, Move.DREAM_EATER}), Type.GHOST, Type.POISON),
    GASTLY("Gastly", "092", Species.HAUNTER, 190, new short[] {30, 35, 30, 100, 35, 80}, 62, convertToMap(new int[] {1, 1, 1, 27, 35}, new Move[] {Move.LICK, Move.CONFUSE_RAY, Move.NIGHT_SHADE, Move.HYPNOSIS, Move.DREAM_EATER}), Type.GHOST, Type.POISON),
    ONIX("Onix", "095", null, 45, new short[] {35, 45, 160, 30, 45, 70}, 108, convertToMap(new int[] {1, 1, 15, 19, 25, 33, 43}, new Move[] {Move.TACKLE, Move.SCREECH, Move.BIND, Move.ROCK_THROW, Move.RAGE, Move.SLAM, Move.HARDEN}), Type.ROCK, Type.GROUND),
    HYPNO("Hypno", "097", null, 75, new short[] {85, 73, 70, 73, 115, 67}, 169, convertToMap(new int[] {1, 1, 1, 1, 12, 17 ,24, 33, 37, 43}, new Move[] {Move.POUND, Move.HYPNOSIS, Move.DISABLE, Move.CONFUSION, Move.DISABLE, Move.CONFUSION, Move.HEADBUTT, Move.POISON_GAS, Move.PSYCHIC, Move.MEDITATE}), Type.PSYCHIC),
    DROWZEE("Drowzee", "096", Species.HYPNO, 190, new short[] {60, 48, 45, 43, 90, 42}, 66, convertToMap(new int[] {1, 1, 12, 17, 24, 29, 32, 37}, new Move[] {Move.POUND, Move.HYPNOSIS, Move.DISABLE, Move.CONFUSION, Move.HEADBUTT, Move.POISON_GAS, Move.PSYCHIC, Move.MEDITATE}), Type.PSYCHIC),
    KINGLER("Kingler", "099", null, 60, new short[] {55, 130, 115, 50, 50, 75}, 166, convertToMap(new int[] {1, 1, 1, 20, 25, 34, 42, 49}, new Move[] {Move.BUBBLE, Move.LEER, Move.VICEGRIP, Move.VICEGRIP, Move.GUILLOTINE, Move.STOMP, Move.CRABHAMMER, Move.HARDEN}), Type.WATER),
    KRABBY("Krabby", "098", Species.KINGLER, 225, new short[] {30, 105, 90, 25, 25, 50}, 65, convertToMap(new int[] {1, 1, 20, 25, 30, 35, 40}, new Move[] {Move.BUBBLE, Move.LEER, Move.VICEGRIP, Move.GUILLOTINE, Move.STOMP, Move.CRABHAMMER, Move.HARDEN}), Type.WATER),
    ELECTRODE("Electrode", "101", null, 60, new short[] {60, 50, 70, 80, 80, 140}, 168, convertToMap(new int[] {1, 1, 1, 17, 22, 29, 40, 50}, new Move[] {Move.TACKLE, Move.SCREECH, Move.SONICBOOM, Move.SONICBOOM, Move.SELFDESTRUCT, Move.LIGHT_SCREEN, Move.SWIFT, Move.EXPLOSION}), Type.ELECTRIC),
    VOLTORB("Voltorb", "100", Species.ELECTRODE, 190, new short[] {40, 30, 50, 55, 55, 100}, 66, convertToMap(new int[] {1, 1, 17, 22, 29, 36, 43}, new Move[] {Move.TACKLE, Move.SCREECH, Move.SONICBOOM, Move.SELFDESTRUCT, Move.LIGHT_SCREEN, Move.SWIFT, Move.EXPLOSION}), Type.ELECTRIC),
    EXEGGUTOR("Exeggutor", "103", null, 45, new short[] {95, 95, 85, 125, 65, 55}, 182, convertToMap(new int[] {1, 1, 28}, new Move[] {Move.BARRAGE, Move.HYPNOSIS, Move.STOMP}), Type.GRASS, Type.PSYCHIC),
    EXEGGCUTE("Exeggcute", "102", Species.EXEGGUTOR, 90, new short[] {60, 40, 80, 60, 45, 40}, 65, convertToMap(new int[] {1, 1, 25, 28, 32, 37, 42, 48}, new Move[] {Move.BARRAGE, Move.HYPNOSIS, Move.REFLECT, Move.LEECH_SEED, Move.STUN_SPORE, Move.POISONPOWDER, Move.SOLARBEAM, Move.SLEEP_POWDER}), Type.GRASS, Type.PSYCHIC),
    MAROWAK("Marowak", "105", null, 75, new short[] {60, 80, 110, 50, 80, 45}, 149, convertToMap(new int[] {1, 1, 1, 1, 25, 33, 41, 48, 55}, new Move[] {Move.GROWL, Move.BONE_CLUB, Move.LEER, Move.FOCUS_ENERGY, Move.LEER, Move.FOCUS_ENERGY, Move.THRASH, Move.BONEMERANG, Move.RAGE}), Type.GROUND),
    CUBONE("Cubone", "104", Species.MAROWAK, 190, new short[] {50, 50, 95, 40, 50, 35}, 64, convertToMap(new int[] {1, 1, 25, 31, 38, 43, 46}, new Move[] {Move.GROWL, Move.BONE_CLUB, Move.LEER, Move.FOCUS_ENERGY, Move.THRASH, Move.BONEMERANG, Move.RAGE}), Type.GROUND),
    HITMONLEE("Hitmonlee", "106", null, 45, new short[] {50, 120, 53, 35, 110, 87}, 159, convertToMap(new int[] {1, 1, 33, 38, 43, 48, 53}, new Move[] {Move.DOUBLE_KICK, Move.MEDITATE, Move.ROLLING_KICK, Move.JUMP_KICK, Move.FOCUS_ENERGY, Move.HI_JUMP_KICK, Move.MEGA_KICK}), Type.FIGHTING),
    HITMONCHAN("Hitmonchan", "107", null, 45, new short[] {50, 105, 79, 35, 110, 76}, 159, convertToMap(new int[] {1, 1, 33, 38, 43, 48, 53}, new Move[] {Move.COMET_PUNCH, Move.AGILITY, Move.FIRE_PUNCH, Move.ICE_PUNCH, Move.THUNDERPUNCH, Move.MEGA_PUNCH, Move.COUNTER}), Type.FIGHTING),
    LICKITUNG("itung", "108", null, 45, new short[] {90, 55, 75, 60, 75, 30}, 77, convertToMap(new int[] {1, 1, 7, 15, 23, 31, 39}, new Move[] {Move.WRAP, Move.SUPERSONIC, Move.STOMP, Move.DISABLE, Move.DEFENSE_CURL, Move.SLAM, Move.SCREECH}), Type.NORMAL),
    WEEZING("Weezing", "110", null, 60, new short[] {65, 90, 120, 85, 70, 60}, 172, convertToMap(new int[] {1, 1, 1, 32, 39, 43, 49, 53}, new Move[] {Move.TACKLE, Move.SMOG, Move.SLUDGE, Move.SLUDGE, Move.SMOKESCREEN, Move.SELFDESTRUCT, Move.HAZE, Move.EXPLOSION}), Type.POISON),
    KOFFING("Koffing", "109", Species.WEEZING, 190, new short[] {40, 65, 95, 60, 45, 35}, 68, convertToMap(new int[] {1, 1, 32, 37, 40, 45, 48}, new Move[] {Move.TACKLE, Move.SMOG, Move.SLUDGE, Move.SMOKESCREEN, Move.SELFDESTRUCT, Move.HAZE, Move.EXPLOSION}), Type.POISON),
    RHYDON("Rhydon", "112", null, 60, new short[] {105, 130, 120, 45, 45, 40}, 170, convertToMap(new int[] {1, 1, 1, 1, 30, 35, 40, 48, 55, 64}, new Move[] {Move.HORN_ATTACK, Move.STOMP, Move.TAIL_WHIP, Move.FURY_ATTACK, Move.STOMP, Move.TAIL_WHIP, Move.FURY_ATTACK, Move.HORN_DRILL, Move.LEER, Move.TAKE_DOWN}), Type.GROUND, Type.ROCK),
    RHYHORN("Rhyhorn", "111", Species.RHYDON, 120, new short[] {80, 85, 95, 30, 30, 25}, 69, convertToMap(new int[] {1, 30, 35, 40, 45, 50, 55}, new Move[] {Move.HORN_ATTACK, Move.STOMP, Move.TAIL_WHIP, Move.FURY_ATTACK, Move.HORN_DRILL, Move.LEER, Move.TAKE_DOWN}), Type.GROUND, Type.ROCK),
    CHANSEY("Chansey", "113", null, 30, new short[] {250, 5, 5, 35, 105, 50}, 395, convertToMap(new int[] {1, 1, 24, 30, 38, 44, 48, 54}, new Move[] {Move.POUND, Move.DOUBLESLAP, Move.SING, Move.GROWL, Move.MINIMIZE, Move.DEFENSE_CURL, Move.LIGHT_SCREEN, Move.DOUBLE_EDGE}), Type.NORMAL),
    TANGELA("Tangela", "114", null, 45, new short[] {65, 55, 115, 100, 40, 60}, 87, convertToMap(new int[] {1, 1, 29, 32, 36, 39, 45, 49}, new Move[] {Move.CONSTRICT, Move.BIND, Move.ABSORB, Move.POISONPOWDER, Move.STUN_SPORE, Move.SLEEP_POWDER, Move.SLAM, Move.GROWTH}), Type.GRASS),
    KANGASKHAN("Kangaskhan", "115", null, 45, new short[] {105, 95, 80, 40, 80, 90}, 172, convertToMap(new int[] {1, 1, 26, 31, 36, 41, 46}, new Move[] {Move.COMET_PUNCH, Move.RAGE, Move.BITE, Move.TAIL_WHIP, Move.MEGA_PUNCH, Move.LEER, Move.DIZZY_PUNCH}), Type.NORMAL),
    SEADRA("Seadra", "117", null, 75, new short[] {55, 65, 95, 95, 45, 85}, 154, convertToMap(new int[] {1, 1, 19, 24, 30, 41, 52}, new Move[] {Move.BUBBLE, Move.SMOKESCREEN, Move.SMOKESCREEN, Move.LEER, Move.WATER_GUN, Move.AGILITY, Move.HYDRO_PUMP}), Type.WATER),
    HORSEA("Horsea", "116", Species.SEADRA, 225, new short[] {30, 40, 70, 70, 25, 60}, 59, convertToMap(new int[] {1, 19, 24, 30, 37, 45}, new Move[] {Move.BUBBLE, Move.SMOKESCREEN, Move.LEER, Move.WATER_GUN, Move.AGILITY, Move.HYDRO_PUMP}), Type.WATER),
    SEAKING("Seaking", "119", null, 60, new short[] {80, 92, 65, 65, 80, 68}, 158, convertToMap(new int[] {1, 1, 1, 19, 24, 30, 39, 48, 54}, new Move[] {Move.PECK, Move.TAIL_WHIP, Move.SUPERSONIC, Move.SUPERSONIC, Move.HORN_ATTACK, Move.FURY_ATTACK, Move.WATERFALL, Move.HORN_DRILL, Move.AGILITY}), Type.WATER),
    GOLDEEN("Goldeen", "118", Species.SEAKING, 225, new short[] {45, 67, 60, 35, 50, 63}, 64, convertToMap(new int[] {1, 1, 19, 24, 30, 37, 45, 54}, new Move[] {Move.PECK, Move.TAIL_WHIP, Move.SUPERSONIC, Move.HORN_ATTACK, Move.FURY_ATTACK, Move.WATERFALL, Move.HORN_DRILL, Move.AGILITY}), Type.WATER),
    STARMIE("Starmie", "121", null, 60, new short[] {60, 75, 85, 100, 85, 115}, 182, convertToMap(new int[] {1, 1, 1}, new Move[] {Move.TACKLE, Move.WATER_GUN, Move.HARDEN}), Type.WATER, Type.PSYCHIC),
    STARYU("Staryu", "120", Species.STARMIE, 225, new short[] {30, 45, 55, 70, 55, 85}, 68, convertToMap(new int[] {1, 17, 22, 27, 32, 37, 42, 47}, new Move[] {Move.TACKLE, Move.WATER_GUN, Move.HARDEN, Move.RECOVER, Move.SWIFT, Move.MINIMIZE, Move.LIGHT_SCREEN, Move.HYDRO_PUMP}), Type.WATER),
    MR_MIME("Mr. Mime", "122", null, 45, new short[] {40, 45, 65, 100, 120, 90}, 161, convertToMap(new int[] {1, 1, 15, 23, 31, 39, 47}, new Move[] {Move.CONFUSION, Move.BARRIER, Move.CONFUSION, Move.LIGHT_SCREEN, Move.DOUBLESLAP, Move.MEDITATE, Move.SUBSTITUTE}), Type.PSYCHIC),
    SCYTHER("Scyther", "123", null, 45, new short[] {70, 110, 80, 55, 80, 105}, 100, convertToMap(new int[] {1, 17, 20, 24, 29, 35, 42}, new Move[] {Move.QUICK_ATTACK, Move.LEER, Move.FOCUS_ENERGY, Move.DOUBLE_TEAM, Move.SLASH, Move.SWORDS_DANCE, Move.AGILITY}), Type.BUG, Type.FLYING),
    JYNX("Jynx", "124", null, 45, new short[] {65, 50, 35, 115, 95, 95}, 159, convertToMap(new int[] {1, 1, 18, 23, 31, 39, 47, 58}, new Move[] {Move.POUND, Move.LOVELY_KISS, Move.LICK, Move.DOUBLESLAP, Move.ICE_PUNCH, Move.BODY_SLAM, Move.THRASH, Move.BLIZZARD}), Type.ICE, Type.PSYCHIC),
    ELECTABUZZ("Electabuzz", "125", null, 45, new short[] {65, 83, 57, 95, 85, 105}, 172, convertToMap(new int[] {1, 1, 34, 37, 42, 49, 54}, new Move[] {Move.QUICK_ATTACK, Move.LEER, Move.THUNDERSHOCK, Move.SCREECH, Move.THUNDERPUNCH, Move.LIGHT_SCREEN, Move.THUNDER}), Type.ELECTRIC),
    MAGMAR("Magmar", "126", null, 45, new short[] {65, 95, 57, 100, 85, 93}, 173, convertToMap(new int[] {1, 36, 39, 43, 48, 52, 55}, new Move[] {Move.EMBER, Move.LEER, Move.CONFUSE_RAY, Move.FIRE_PUNCH, Move.SMOKESCREEN, Move.SMOG, Move.FLAMETHROWER}), Type.FIRE),
    PINSIR("Pinsir", "127", null, 45, new short[] {65, 125, 100, 55, 70, 85}, 175, convertToMap(new int[] {1, 25, 30, 36, 43, 49, 54}, new Move[] {Move.VICEGRIP, Move.SEISMIC_TOSS, Move.GUILLOTINE, Move.FOCUS_ENERGY, Move.HARDEN, Move.SLASH, Move.SWORDS_DANCE}), Type.BUG),
    TAUROS("Tauros", "128", null, 45, new short[] {75, 100, 95, 40, 70, 110}, 211, convertToMap(new int[] {1, 21, 28, 35, 44, 51}, new Move[] {Move.TACKLE, Move.STOMP, Move.TAIL_WHIP, Move.LEER, Move.RAGE, Move.TAKE_DOWN}), Type.NORMAL),
    GYARADOS("Gyarados", "130", null, 45, new short[] {95, 125, 79, 60, 100, 81}, 189, convertToMap(new int[] {1, 1, 1, 1, 20, 25, 32, 41, 52}, new Move[] {Move.BITE, Move.DRAGON_RAGE, Move.LEER, Move.HYDRO_PUMP, Move.BITE, Move.DRAGON_RAGE, Move.LEER, Move.HYDRO_PUMP, Move.HYPER_BEAM}), Type.WATER, Type.FLYING),
    MAGIKARP("Magikarp", "129", Species.GYARADOS, 255, new short[] {20, 10, 55, 15, 20, 80}, 40, convertToMap(new int[] {1, 15}, new Move[] {Move.SPLASH, Move.TACKLE}), Type.WATER),
    LAPRAS("Lapras", "131", null, 45, new short[] {130, 85, 80, 85, 95, 60}, 187, convertToMap(new int[] {1, 1, 16, 20, 25, 31, 38, 46}, new Move[] {Move.WATER_GUN, Move.GROWL, Move.SING, Move.MIST, Move.BODY_SLAM, Move.CONFUSE_RAY, Move.ICE_BEAM, Move.HYDRO_PUMP}), Type.WATER, Type.ICE),
    DITTO("Ditto", "132", null, 35, new short[] {48, 48, 48, 48, 48, 48}, 101, convertToMap(new int[] {1}, new Move[] {Move.TRANSFORM}), Type.NORMAL),
    EEVEE("Eevee", "133", null, 45, new short[] {55, 55, 50, 45, 65, 55}, 65, convertToMap(new int[] {1, 1, 27, 31, 37, 45}, new Move[] {Move.TACKLE, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.TAIL_WHIP, Move.BITE, Move.TAKE_DOWN}), Type.NORMAL),
    VAPOREON("Vaporeon", "134", null, 45, new short[] {130, 65, 60, 110, 95, 65}, 184, convertToMap(new int[] {1, 1, 1, 1, 27, 31, 37, 40, 42, 44, 48, 54}, new Move[] {Move.TACKLE, Move.QUICK_ATTACK, Move.WATER_GUN, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.WATER_GUN, Move.TAIL_WHIP, Move.BITE, Move.ACID_ARMOR, Move.HAZE, Move.MIST, Move.HYDRO_PUMP}), Type.WATER),
    JOLTEON("Jolteon", "135", null, 45, new short[] {65, 65, 60, 110, 95, 130}, 184, convertToMap(new int[] {1, 1, 1, 1, 27, 31, 37, 40, 42, 44, 48, 54}, new Move[] {Move.TACKLE, Move.QUICK_ATTACK, Move.THUNDERSHOCK, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.THUNDERSHOCK, Move.TAIL_WHIP, Move.THUNDER_WAVE, Move.DOUBLE_KICK, Move.AGILITY, Move.PIN_MISSILE, Move.THUNDER}), Type.ELECTRIC),
    FLAREON("Flareon", "136", null, 45, new short[] {65, 130, 60, 95, 110, 65}, 184, convertToMap(new int[] {1, 1, 1, 1, 27, 31, 37, 40, 42, 44, 48, 54}, new Move[] {Move.TACKLE, Move.QUICK_ATTACK, Move.EMBER, Move.SAND_ATTACK, Move.QUICK_ATTACK, Move.EMBER, Move.TAIL_WHIP, Move.BITE, Move.LEER, Move.FIRE_SPIN, Move.RAGE, Move.FLAMETHROWER}), Type.FIRE),
    PORYGON("Porygon", "137", null, 45, new short[] {65, 60, 70, 85, 75, 40}, 79, convertToMap(new int[] {1, 1, 1, 23, 28, 35, 42}, new Move[] {Move.TACKLE, Move.SHARPEN, Move.CONVERSION, Move.PSYBEAM, Move.RECOVER, Move.AGILITY, Move.TRI_ATTACK}), Type.NORMAL),
    OMASTAR("Omastar", "139", null, 45, new short[] {70, 60, 125, 115, 70, 55}, 173, convertToMap(new int[] {1, 1, 1, 34, 39, 44, 49}, new Move[] {Move.WATER_GUN, Move.WITHDRAW, Move.HORN_ATTACK, Move.HORN_ATTACK, Move.LEER, Move.SPIKE_CANNON, Move.HYDRO_PUMP}), Type.ROCK, Type.WATER),
    OMANYTE("Omanyte", "138", Species.OMASTAR, 45, new short[] {35, 40, 100, 90, 55, 35}, 71, convertToMap(new int[] {1, 1, 34, 39, 46, 53}, new Move[] {Move.WATER_GUN, Move.WITHDRAW, Move.HORN_ATTACK, Move.LEER, Move.SPIKE_CANNON, Move.HYDRO_PUMP}), Type.ROCK, Type.WATER),
    KABUTOPS("Kabutops", "141", null, 45, new short[] {60, 115, 105, 65, 70, 80}, 173, convertToMap(new int[] {1, 1, 1, 34, 39, 46, 53}, new Move[] {Move.SCRATCH, Move.HARDEN, Move.ABSORB, Move.ABSORB, Move.SLASH, Move.LEER, Move.HYDRO_PUMP}), Type.ROCK, Type.WATER),
    KABUTO("Kabuto", "140", Species.KABUTOPS, 45, new short[] {30, 80, 90, 55, 45, 55}, 71, convertToMap(new int[] {1, 1, 34, 39, 44, 49}, new Move[] {Move.SCRATCH, Move.HARDEN, Move.ABSORB, Move.SLASH, Move.LEER, Move.HYDRO_PUMP}), Type.ROCK, Type.WATER),
    AERODACTYL("Aerodactyl", "142", null, 45, new short[] {80, 105, 65, 60, 75, 130}, 180, convertToMap(new int[] {1, 1, 33, 38, 45, 54}, new Move[] {Move.WING_ATTACK, Move.AGILITY, Move.SUPERSONIC, Move.BITE, Move.TAKE_DOWN, Move.HYPER_BEAM}), Type.ROCK, Type.FLYING),
    SNORLAX("Snorlax", "143", null, 25, new short[] {160, 110, 65, 65, 110, 30}, 189, convertToMap(new int[] {1, 1, 1, 35, 41, 48, 56}, new Move[] {Move.HEADBUTT, Move.AMNESIA, Move.REST, Move.BODY_SLAM, Move.HARDEN, Move.DOUBLE_EDGE, Move.HYPER_BEAM}), Type.NORMAL),
    ARTICUNO("Articuno", "144", null, 3, new short[] {90, 85, 100, 95, 125, 85}, 261, convertToMap(new int[] {1, 1, 51, 55, 60}, new Move[] {Move.PECK, Move.ICE_BEAM, Move.BLIZZARD, Move.AGILITY, Move.MIST}), Type.ICE, Type.FLYING),
    ZAPDOS("Zapdos", "145", null, 3, new short[] {90, 90, 85, 125, 90, 100}, 261, convertToMap(new int[] {1, 1, 51, 55, 60}, new Move[] {Move.THUNDERSHOCK, Move.DRILL_PECK, Move.THUNDER, Move.AGILITY, Move.LIGHT_SCREEN}), Type.ELECTRIC, Type.FLYING),
    MOLTRES("Moltres", "146", null, 3, new short[] {90, 100, 90, 125, 85, 90}, 261, convertToMap(new int[] {1, 1, 51, 55, 60}, new Move[] {Move.PECK, Move.FIRE_SPIN, Move.LEER, Move.AGILITY, Move.SKY_ATTACK}), Type.FIRE, Type.FLYING),
    DRAGONITE("Dragonite", "149", null, 45, new short[] {91, 134, 95, 100, 100, 80}, 270, convertToMap(new int[] {1, 1, 1, 1, 10, 20, 35, 45, 60}, new Move[] {Move.WRAP, Move.LEER, Move.THUNDER_WAVE, Move.AGILITY, Move.THUNDER_WAVE, Move.AGILITY, Move.SLAM, Move.DRAGON_RAGE, Move.HYPER_BEAM}), Type.DRAGON, Type.FLYING),
    DRAGONAIR("Dragonair", "148", Species.DRAGONITE, 45, new short[] {61, 84, 65, 70, 70, 70}, 147, convertToMap(new int[] {1, 1, 1, 10, 20, 35, 45, 55}, new Move[] {Move.WRAP, Move.LEER, Move.THUNDER_WAVE, Move.THUNDER_WAVE, Move.AGILITY, Move.SLAM, Move.DRAGON_RAGE, Move.HYPER_BEAM}), Type.DRAGON),
    DRATINI("Dratini", "147", Species.DRAGONAIR, 45, new short[] {41, 64, 45, 50, 50, 50}, 60, convertToMap(new int[] {1, 1, 10, 20, 30, 40, 50}, new Move[] {Move.WRAP, Move.LEER, Move.THUNDER_WAVE, Move.AGILITY, Move.SLAM, Move.DRAGON_RAGE, Move.HYPER_BEAM}), Type.DRAGON),
    MEWTWO("Mewtwo", "150", null, 3, new short[] {106, 110, 90, 154, 90, 130}, 306, convertToMap(new int[] {1, 1, 1, 1, 63, 66, 70, 75, 81}, new Move[] {Move.CONFUSION, Move.DISABLE, Move.SWIFT, Move.PSYCHIC, Move.BARRIER, Move.PSYCHIC, Move.RECOVER, Move.MIST, Move.AMNESIA}), Type.PSYCHIC),
    MEW("Mew", "151", null, 45, new short[] {100, 100, 100, 100, 100, 100}, 270, convertToMap(new int[] {1, 10, 20, 30, 40}, new Move[] {Move.POUND, Move.TRANSFORM, Move.MEGA_PUNCH, Move.METRONOME, Move.PSYCHIC}), Type.PSYCHIC);

   
   
	private final int[] BaseStats;
    private final String Name;
    private final String DexNumber;
    private final Type[] TYPE;
    private final Map<Move, Integer> MoveSet;
    private final int ExpYield;
    private final int CatchRate;

   /**
    * Creates a brand new Pokemon Specie.
    */
   Species(String name, String dexNumber, Species evolution, int catchRate, short[] stats, int expYield, Map<Move, Integer> moveSet, Type... type) {
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

   public Type[] getType() {
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

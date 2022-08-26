package Model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Location {

	NULL(false, false, null, "Null", null, 0, 0),
    PALLET_TOWN(true, false, null, "Pallet Town", null, 0, 0),
    VIRIDIAN_CITY(true, true, null, "Viridian City", null, 0, 0),
    PEWTER_CITY(true, true, null, "Pewter City", null, 0, 0),
    CERULEAN_CITY(true, true, null, "Cerulean City", null, 0, 0),
    VERMILION_CITY(true, true, null, "Vermilion City", null, 0, 0),
    LAVENDER_TOWN(true, true, null, "Lavender Town", null, 0, 0),
    CINNABAR_ISLAND(true, true, null, "Cinnabar Island", null, 0, 0),
    CELADON_CITY(true, true, null, "Celadon City", null, 0, 0),
    FUCHSIA_CITY(true, true, null, "Fuchsia City", null, 0, 0),
    SAFFRON_CITY(true, true, null, "Saffron City", null, 0, 0),
    ROUTE_01(false, false, null, "Route 01", convertToMap(new int[]{50, 100}, new Species[]{Species.PIDGEY, Species.RATTATA}), 2, 5),
    ROUTE_02(false, false, null, "Route 02", convertToMap(new int[]{45, 90, 95, 100}, new Species[]{Species.PIDGEY, Species.RATTATA, Species.CATERPIE, Species.WEEDLE}), 2, 5),
    ROUTE_03(false, false, null, "Route 03", convertToMap(new int[]{30, 60, 70, 80, 90, 100}, new Species[]{Species.PIDGEY, Species.SPEAROW, Species.NIDORAN_MALE, Species.NIDORAN_FEMALE, Species.JIGGLYPUFF, Species.MANKEY}), 5, 7),
    ROUTE_04(false, false, null, "Route 04", convertToMap(new int[]{35, 70, 80, 90, 100}, new Species[]{Species.RATTATA, Species.SPEAROW, Species.EKANS, Species.SANDSHREW, Species.MANKEY}), 6, 12),
    ROUTE_05(false, false, null, "Route 05", convertToMap(new int[]{35, 70, 85, 100}, new Species[]{Species.PIDGEY, Species.MEOWTH, Species.ODDISH, Species.BELLSPROUT}), 13, 16),
    ROUTE_06(false, false, null, "Route 06", convertToMap(new int[]{35, 70, 85, 100}, new Species[]{Species.PIDGEY, Species.MEOWTH, Species.ODDISH, Species.BELLSPROUT}), 13, 16),
    ROUTE_07(false, false, null, "Route 07", convertToMap(new int[]{35, 70, 80, 90, 95, 100}, new Species[]{Species.PIDGEY, Species.MEOWTH, Species.ODDISH, Species.BELLSPROUT, Species.GROWLITHE, Species.VULPIX}), 17, 20),
    ROUTE_08(false, false, null, "Route 08", convertToMap(new int[]{30, 60, 70, 80, 90, 100}, new Species[]{Species.PIDGEY, Species.MEOWTH, Species.EKANS, Species.SANDSHREW, Species.GROWLITHE, Species.VULPIX}), 17, 20),
    ROUTE_09(false, false, null, "Route 09", convertToMap(new int[]{35, 70, 85, 100}, new Species[]{Species.RATTATA, Species.SPEAROW, Species.EKANS, Species.SANDSHREW}), 13, 17),
    ROUTE_10(false, false, null, "Route 10", convertToMap(new int[]{30, 45, 60, 100}, new Species[]{Species.SPEAROW, Species.EKANS, Species.SANDSHREW, Species.VOLTORB}), 13, 17),
    ROUTE_11(false, false, null, "Route 11", convertToMap(new int[]{35, 55, 75, 100}, new Species[]{Species.SPEAROW, Species.EKANS, Species.SANDSHREW, Species.DROWZEE}), 11, 17),
    ROUTE_12(false, false, null, "Route 12", convertToMap(new int[]{30, 45, 50, 80, 95, 100}, new Species[]{Species.PIDGEY, Species.ODDISH, Species.GLOOM, Species.VENONAT, Species.BELLSPROUT, Species.WEEPINBELL}), 22, 27),
    ROUTE_13(false, false, null, "Route 13", convertToMap(new int[]{20, 25, 40, 45, 75, 90, 95, 100}, new Species[]{Species.PIDGEY, Species.PIDGEOTTO, Species.ODDISH, Species.GLOOM, Species.VENONAT, Species.BELLSPROUT, Species.WEEPINBELL, Species.DITTO}), 22, 27),
    ROUTE_14(false, false, null, "Route 14", convertToMap(new int[]{10, 15, 30, 35, 65, 80, 85, 100}, new Species[]{Species.PIDGEY, Species.PIDGEOTTO, Species.ODDISH, Species.GLOOM, Species.VENONAT, Species.BELLSPROUT, Species.WEEPINBELL, Species.DITTO}), 24, 30),
    ROUTE_15(false, false, null, "Route 15", convertToMap(new int[]{20, 25, 40, 45, 75, 90, 95, 100}, new Species[]{Species.PIDGEY, Species.PIDGEOTTO, Species.ODDISH, Species.GLOOM, Species.VENONAT, Species.BELLSPROUT, Species.WEEPINBELL, Species.DITTO}), 24, 30),
    ROUTE_16(false, false, null, "Route 16", convertToMap(new int[]{30, 35, 65, 100}, new Species[]{Species.RATTATA, Species.RATICATE, Species.SPEAROW, Species.DODUO}), 18, 25),
    ROUTE_17(false, false, null, "Route 17", convertToMap(new int[]{5, 30, 60, 65, 100}, new Species[]{Species.RATTATA, Species.RATICATE, Species.SPEAROW, Species.FEAROW, Species.DODUO}), 24, 28),
    ROUTE_18(false, false, null, "Route 18", convertToMap(new int[]{5, 20, 50, 65, 100}, new Species[]{Species.RATTATA, Species.RATICATE, Species.SPEAROW, Species.FEAROW, Species.DODUO}), 24, 29),
    ROUTE_19(false, false, null, "Route 19", convertToMap(new int[]{100}, new Species[]{Species.TENTACOOL}), 5, 40),
    ROUTE_20(false, false, null, "Route 20", convertToMap(new int[]{100}, new Species[]{Species.TENTACOOL}), 5, 40),
    ROUTE_21(false, false, null, "Route 21", convertToMap(new int[]{50, 100}, new Species[]{Species.TANGELA, Species.TENTACOOL}), 17, 28),
    ROUTE_22(false, false, null, "Route 22", convertToMap(new int[]{45, 90, 100}, new Species[]{Species.RATTATA, Species.SPEAROW, Species.MANKEY}), 2, 5),
    ROUTE_23(false, false, null, "Route 23", convertToMap(new int[]{15, 40, 50, 55, 65, 70, 95, 100}, new Species[]{Species.SPEAROW, Species.FEAROW, Species.EKANS, Species.ARBOK, Species.SANDSHREW, Species.SANDSLASH, Species.MANKEY, Species.PRIMEAPE}), 32, 38),
    ROUTE_24(false, false, null, "Route 24", convertToMap(new int[]{10, 15, 25, 30, 45, 70, 95, 100}, new Species[]{Species.CATERPIE, Species.METAPOD, Species.WEEDLE, Species.KAKUNA, Species.PIDGEY, Species.ODDISH, Species.BELLSPROUT, Species.ABRA}), 7, 12),
    ROUTE_25(false, false, null, "Route 25", convertToMap(new int[]{10, 15, 25, 30, 45, 65, 85, 100}, new Species[]{Species.CATERPIE, Species.METAPOD, Species.WEEDLE, Species.KAKUNA, Species.PIDGEY, Species.ODDISH, Species.BELLSPROUT, Species.ABRA}), 7, 14),
    VIRIDIAN_FOREST(false, false, null, "Viridian Forest", convertToMap(new int[]{5, 45, 50, 95, 100}, new Species[]{Species.CATERPIE, Species.KAKUNA, Species.METAPOD, Species.WEEDLE, Species.PIKACHU}), 3, 8),
    MT_MOON_SQUARE(true, true, null, "Mt Moon Square", null, 0, 0),
    MT_MOON(false, false, null, "Mt Moon", convertToMap(new int[]{6, 55, 70, 100}, new Species[]{Species.CLEFAIRY, Species.ZUBAT, Species.PARAS, Species.GEODUDE}), 8, 12),
    DIGLETTS_CAVE(false, false, null, "Diglett's Cave", convertToMap(new int[]{95, 100}, new Species[]{Species.DIGLETT, Species.DUGTRIO}), 15, 31),
    ROCK_TUNNEL(false, false, null, "Rock Tunnel", convertToMap(new int[]{35, 65, 80, 90, 100}, new Species[]{Species.ZUBAT, Species.GEODUDE, Species.MACHOP, Species.MANKEY, Species.ONIX}), 13, 18),
    SAFARI_ZONE_CENTER(false, false, null, "Safari Zone Center", convertToMap(new int[]{10, 15, 25, 30, 35, 50, 70, 90, 92, 96, 100}, new Species[]{Species.NIDORAN_MALE, Species.NIDORINO, Species.NIDORAN_FEMALE, Species.NIDORINA, Species.PARASECT, Species.VENONAT, Species.EXEGGCUTE, Species.RHYHORN, Species.CHANSEY, Species.SCYTHER, Species.PINSIR}), 23, 30),
    SAFARI_ZONE_EAST(false, false, null, "Safari Zone East", convertToMap(new int[]{10, 15, 25, 30, 45, 50, 70, 90, 96, 98, 100}, new Species[]{Species.NIDORAN_MALE, Species.NIDORINO, Species.NIDORAN_FEMALE, Species.NIDORINA, Species.PARAS, Species.PARASECT, Species.DODUO, Species.EXEGGCUTE, Species.KANGASKHAN, Species.SCYTHER, Species.PINSIR}), 24, 33),
    SAFARI_ZONE_NORTH(false, false, null, "Safari Zone North", convertToMap(new int[]{10, 20, 30, 40, 50, 55, 75, 95, 99, 100}, new Species[]{Species.NIDORAN_MALE, Species.NIDORINO, Species.NIDORAN_FEMALE, Species.NIDORINA, Species.PARAS, Species.VENOMOTH, Species.EXEGGCUTE, Species.RHYHORN, Species.CHANSEY, Species.TAUROS}), 24, 30),
    SAFARI_ZONE_WEST(false, false, null, "Safari Zone West", convertToMap(new int[]{5, 15, 20, 30, 45, 50, 70, 90, 95, 100}, new Species[]{Species.NIDORAN_MALE, Species.NIDORINO, Species.NIDORAN_FEMALE, Species.NIDORINA, Species.VENONAT, Species.VENOMOTH, Species.DODUO, Species.EXEGGCUTE, Species.KANGASKHAN, Species.TAUROS}), 24, 30),
    POWER_PLANT(false, false, null, "Power Plant", convertToMap(new int[]{25, 55, 65, 95, 100}, new Species[]{Species.PIKACHU, Species.MAGNEMITE, Species.MAGNETON, Species.VOLTORB, Species.ELECTABUZZ}), 22, 35),
    SEAFOAM_ISLANDS(false, false, null, "Seafoam Islands", convertToMap(new int[]{40, 50, 60, 65, 70, 80, 95, 100}, new Species[]{Species.SEEL, Species.PSYDUCK, Species.SLOWPOKE, Species.GOLDUCK, Species.SLOWBRO, Species.ZUBAT, Species.GOLBAT, Species.DEWGONG}), 22, 35),
	INDIGO_PLATEAU(true, true, null, "Indigo Plateau", null, 0, 0);
	
    private final String Name;
    private final Map<Species, Integer> PokemonsLivingHere;
    private Location LocationToNorth;
    private Location LocationToWest;
    private Location LocationToSouth;
    private Location LocationToEast;
    private final Move MoveRequiriment;
    private final int MinLvl, MaxLvl; 
    public final boolean HasPokeCenter;
    public final boolean HasStore;
    
    Location(boolean hasPC, boolean hasStore, Move move, String name, Map<Species, Integer>  pokemonLivingHere, int min, int max) {
        HasPokeCenter = hasPC;
        HasStore = hasStore;
        Name = name;
        MoveRequiriment = move;
        MinLvl = min;
        MaxLvl = max;
        PokemonsLivingHere = pokemonLivingHere;
    }
    
    private static Map<Species, Integer> convertToMap(int[] a, Species[] b) {
        Map<Species, Integer> s = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                s.put(b[i], a[i]);
            }
        }
        return s;
    }

    /**
     * Create Grid of the World
     */
    public void CreateGridMap() {
    	PALLET_TOWN.DefaultValue(ROUTE_01, ROUTE_21, NULL, NULL);
        VIRIDIAN_CITY.DefaultValue(ROUTE_02, ROUTE_01, ROUTE_22, NULL);
        PEWTER_CITY.DefaultValue(NULL, VIRIDIAN_FOREST, NULL, ROUTE_03);
        CERULEAN_CITY.DefaultValue(ROUTE_24, ROUTE_05, ROUTE_04, ROUTE_09);
        VERMILION_CITY.DefaultValue(ROUTE_06, NULL, NULL, ROUTE_11);
        LAVENDER_TOWN.DefaultValue(ROUTE_10, ROUTE_12, ROUTE_08, NULL);
        CELADON_CITY.DefaultValue(NULL, NULL, ROUTE_16, ROUTE_07);
        FUCHSIA_CITY.DefaultValue(SAFARI_ZONE_CENTER, ROUTE_19, ROUTE_18, ROUTE_15);
        SAFFRON_CITY.DefaultValue(ROUTE_05, ROUTE_06, ROUTE_07, ROUTE_08);
        CINNABAR_ISLAND.DefaultValue(ROUTE_21, NULL, NULL, ROUTE_20);
        ROUTE_01.DefaultValue(VIRIDIAN_CITY, PALLET_TOWN, NULL, NULL);
        ROUTE_02.DefaultValue(VIRIDIAN_FOREST, VIRIDIAN_CITY, NULL, NULL);
        ROUTE_03.DefaultValue(NULL, NULL, PEWTER_CITY, MT_MOON_SQUARE);
        ROUTE_04.DefaultValue(NULL, NULL, MT_MOON, CERULEAN_CITY);
        ROUTE_05.DefaultValue(CERULEAN_CITY, SAFFRON_CITY, MT_MOON, NULL);
        ROUTE_06.DefaultValue(SAFFRON_CITY, VERMILION_CITY, NULL, NULL);
        ROUTE_07.DefaultValue(NULL, NULL, CELADON_CITY, SAFFRON_CITY);
        ROUTE_08.DefaultValue(NULL, NULL, SAFFRON_CITY, LAVENDER_TOWN);
        ROUTE_09.DefaultValue(NULL, NULL, CERULEAN_CITY, ROCK_TUNNEL);
        ROUTE_10.DefaultValue(ROCK_TUNNEL, LAVENDER_TOWN, NULL, POWER_PLANT);
        ROUTE_11.DefaultValue(NULL, NULL, VERMILION_CITY, ROUTE_12);
        ROUTE_12.DefaultValue(LAVENDER_TOWN, ROUTE_13, ROUTE_11, NULL);
        ROUTE_13.DefaultValue(ROUTE_12, ROUTE_14, NULL, NULL);
        ROUTE_14.DefaultValue(ROUTE_13, NULL, ROUTE_15, NULL);
        ROUTE_15.DefaultValue(NULL, NULL, FUCHSIA_CITY, ROUTE_14);
        ROUTE_16.DefaultValue(NULL, ROUTE_17, NULL, CELADON_CITY);
        ROUTE_17.DefaultValue(ROUTE_16, ROUTE_18, NULL, NULL);
        ROUTE_18.DefaultValue(ROUTE_17, NULL, NULL, FUCHSIA_CITY);
        ROUTE_19.DefaultValue(FUCHSIA_CITY, NULL, ROUTE_20, NULL);
        ROUTE_20.DefaultValue(SEAFOAM_ISLANDS, NULL, CINNABAR_ISLAND, ROUTE_19);
        ROUTE_21.DefaultValue(PALLET_TOWN, CINNABAR_ISLAND, NULL, NULL);
        ROUTE_22.DefaultValue(ROUTE_23, NULL, NULL, VIRIDIAN_CITY);
        ROUTE_23.DefaultValue(INDIGO_PLATEAU, ROUTE_22, NULL, NULL);
        ROUTE_24.DefaultValue(NULL, CERULEAN_CITY, NULL, ROUTE_25);
        ROUTE_25.DefaultValue(NULL, NULL, ROUTE_24, NULL);
        MT_MOON_SQUARE.DefaultValue(NULL, NULL, ROUTE_03, MT_MOON);
        MT_MOON.DefaultValue(NULL, NULL, MT_MOON_SQUARE, ROUTE_04);
        VIRIDIAN_FOREST.DefaultValue(PEWTER_CITY, ROUTE_02, NULL, NULL);
        DIGLETTS_CAVE.DefaultValue(NULL, ROUTE_11, ROUTE_02, NULL);
        ROCK_TUNNEL.DefaultValue(NULL, ROUTE_10, ROUTE_09, NULL);
        SAFARI_ZONE_CENTER.DefaultValue(SAFARI_ZONE_NORTH, FUCHSIA_CITY, SAFARI_ZONE_WEST, SAFARI_ZONE_EAST);
        SAFARI_ZONE_NORTH.DefaultValue(NULL, SAFARI_ZONE_CENTER, NULL, NULL);
        SAFARI_ZONE_EAST.DefaultValue(NULL, NULL, SAFARI_ZONE_CENTER, NULL);
        SAFARI_ZONE_WEST.DefaultValue(NULL, NULL, NULL, SAFARI_ZONE_CENTER);
        POWER_PLANT.DefaultValue(NULL, NULL, ROUTE_10, NULL);
        SEAFOAM_ISLANDS.DefaultValue(NULL, ROUTE_20, NULL, NULL);
        INDIGO_PLATEAU.DefaultValue(NULL, ROUTE_23, NULL, NULL);
    }
    
    public void DefaultValue(Location n, Location s, Location w, Location e) {
        LocationToNorth = n;
        LocationToSouth = s;
        LocationToWest = w;
        LocationToEast = e;
    }
    /**
     * Gets and Sets
     *
     * @return
     */   
    public boolean PokemonsLivingHere() {
        return null != PokemonsLivingHere;
    }
    public Map<Species, Integer> getPokemonsLivingHere() {
    	return PokemonsLivingHere;
    }
    public Move getMove(){
        return MoveRequiriment;
    }  
    public boolean HasPokeCenter() {
        return HasPokeCenter();
    }
    public Location getLocationToNorth() {
        return LocationToNorth;
    }
    public Location getLocationToWest() {
        return LocationToWest;
    }
    public Location getLocationToSouth() {
        return LocationToSouth;
    }
    public Location getLocationToEast() {
        return LocationToEast;
    }
    public void setLocationToNorth(Location l) {
        LocationToNorth = l;
    }
    public void setLocationToWest(Location l) {
        LocationToWest = l;
    }
    public void setLocationToSouth(Location l) {
        LocationToSouth = l;
    }
    public void setLocationToEast(Location l) {
        LocationToEast = l;
    }
    public String getImgUrl() {
        return Name;
    }
    public int getMinLvl() {
    	return MinLvl;
    }
    public int getMaxLvl() {
    	return MaxLvl;
    }
}

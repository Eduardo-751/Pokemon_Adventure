package Model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Location {

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
        Location.PALLET_TOWN.setLocationToNorth(Location.ROUTE_01);
        Location.PALLET_TOWN.setLocationToSouth(Location.ROUTE_21);
        Location.VIRIDIAN_CITY.setLocationToNorth(Location.ROUTE_02);
        Location.VIRIDIAN_CITY.setLocationToSouth(Location.ROUTE_01);
        Location.VIRIDIAN_CITY.setLocationToWest(Location.ROUTE_22);
        Location.PEWTER_CITY.setLocationToEast(Location.ROUTE_03);
        Location.PEWTER_CITY.setLocationToSouth(Location.VIRIDIAN_FOREST);
        Location.CERULEAN_CITY.setLocationToNorth(Location.ROUTE_24);
        Location.CERULEAN_CITY.setLocationToSouth(Location.ROUTE_05);
        Location.CERULEAN_CITY.setLocationToWest(Location.ROUTE_04);
        Location.CERULEAN_CITY.setLocationToEast(Location.ROUTE_09);
        Location.VERMILION_CITY.setLocationToNorth(Location.ROUTE_06);
        Location.VERMILION_CITY.setLocationToEast(Location.ROUTE_11);
        Location.LAVENDER_TOWN.setLocationToNorth(Location.ROUTE_10);
        Location.LAVENDER_TOWN.setLocationToSouth(Location.ROUTE_12);
        Location.LAVENDER_TOWN.setLocationToWest(Location.ROUTE_08);
        Location.CELADON_CITY.setLocationToWest(Location.ROUTE_16);
        Location.CELADON_CITY.setLocationToEast(Location.ROUTE_07);
        Location.FUCHSIA_CITY.setLocationToNorth(Location.SAFARI_ZONE_CENTER);
        Location.FUCHSIA_CITY.setLocationToSouth(Location.ROUTE_19);
        Location.FUCHSIA_CITY.setLocationToWest(Location.ROUTE_18);
        Location.FUCHSIA_CITY.setLocationToEast(Location.ROUTE_15);
        Location.SAFFRON_CITY.setLocationToNorth(Location.ROUTE_05);
        Location.SAFFRON_CITY.setLocationToSouth(Location.ROUTE_06);
        Location.SAFFRON_CITY.setLocationToWest(Location.ROUTE_07);
        Location.SAFFRON_CITY.setLocationToEast(Location.ROUTE_08);
        Location.CINNABAR_ISLAND.setLocationToNorth(Location.ROUTE_21);
        Location.CINNABAR_ISLAND.setLocationToEast(Location.ROUTE_20);
        Location.ROUTE_01.setLocationToNorth(Location.VIRIDIAN_CITY);
        Location.ROUTE_01.setLocationToSouth(Location.PALLET_TOWN);
        Location.ROUTE_02.setLocationToNorth(Location.VIRIDIAN_FOREST);
        Location.ROUTE_02.setLocationToSouth(Location.VIRIDIAN_CITY);
        Location.ROUTE_03.setLocationToWest(Location.PEWTER_CITY);
        Location.ROUTE_03.setLocationToEast(Location.MT_MOON_SQUARE);
        Location.ROUTE_04.setLocationToWest(Location.MT_MOON);
        Location.ROUTE_04.setLocationToEast(Location.CERULEAN_CITY);
        Location.ROUTE_05.setLocationToWest(Location.MT_MOON);
        Location.ROUTE_05.setLocationToNorth(Location.CERULEAN_CITY);
        Location.ROUTE_05.setLocationToSouth(Location.SAFFRON_CITY);
        Location.ROUTE_06.setLocationToNorth(Location.SAFFRON_CITY);
        Location.ROUTE_06.setLocationToSouth(Location.VERMILION_CITY);
        Location.ROUTE_07.setLocationToWest(Location.CELADON_CITY);
        Location.ROUTE_07.setLocationToEast(Location.SAFFRON_CITY);
        Location.ROUTE_08.setLocationToWest(Location.SAFFRON_CITY);
        Location.ROUTE_08.setLocationToEast(Location.LAVENDER_TOWN);
        Location.ROUTE_09.setLocationToWest(Location.CERULEAN_CITY);
        Location.ROUTE_09.setLocationToEast(Location.ROCK_TUNNEL);
        Location.ROUTE_10.setLocationToNorth(Location.ROCK_TUNNEL);
        Location.ROUTE_10.setLocationToSouth(Location.LAVENDER_TOWN);
        Location.ROUTE_10.setLocationToEast(Location.POWER_PLANT);
        Location.ROUTE_11.setLocationToWest(Location.VERMILION_CITY);
        Location.ROUTE_11.setLocationToEast(Location.ROUTE_12);
        Location.ROUTE_12.setLocationToNorth(Location.LAVENDER_TOWN);
        Location.ROUTE_12.setLocationToSouth(Location.ROUTE_13);
        Location.ROUTE_12.setLocationToWest(Location.ROUTE_11);
        Location.ROUTE_13.setLocationToNorth(Location.ROUTE_12);
        Location.ROUTE_13.setLocationToSouth(Location.ROUTE_14);
        Location.ROUTE_14.setLocationToWest(Location.ROUTE_15);
        Location.ROUTE_14.setLocationToNorth(Location.ROUTE_13);
        Location.ROUTE_15.setLocationToWest(Location.FUCHSIA_CITY);
        Location.ROUTE_15.setLocationToEast(Location.ROUTE_14);
        Location.ROUTE_16.setLocationToEast(Location.CELADON_CITY);
        Location.ROUTE_16.setLocationToSouth(Location.ROUTE_17);
        Location.ROUTE_17.setLocationToNorth(Location.ROUTE_16);
        Location.ROUTE_17.setLocationToSouth(Location.ROUTE_18);
        Location.ROUTE_18.setLocationToNorth(Location.ROUTE_17);
        Location.ROUTE_18.setLocationToEast(Location.FUCHSIA_CITY);
        Location.ROUTE_19.setLocationToNorth(Location.FUCHSIA_CITY);
        Location.ROUTE_19.setLocationToWest(Location.ROUTE_20);
        Location.ROUTE_20.setLocationToNorth(Location.SEAFOAM_ISLANDS);
        Location.ROUTE_20.setLocationToEast(Location.ROUTE_19);
        Location.ROUTE_20.setLocationToWest(Location.CINNABAR_ISLAND);
        Location.ROUTE_21.setLocationToNorth(Location.PALLET_TOWN);
        Location.ROUTE_21.setLocationToSouth(Location.CINNABAR_ISLAND);
        Location.ROUTE_22.setLocationToNorth(Location.ROUTE_23);
        Location.ROUTE_22.setLocationToEast(Location.VIRIDIAN_CITY);
        Location.ROUTE_23.setLocationToNorth(Location.INDIGO_PLATEAU);
        Location.ROUTE_23.setLocationToSouth(Location.ROUTE_22);
        Location.ROUTE_24.setLocationToSouth(Location.CERULEAN_CITY);
        Location.ROUTE_24.setLocationToEast(Location.ROUTE_25);
        Location.ROUTE_25.setLocationToWest(Location.ROUTE_24);
        Location.MT_MOON_SQUARE.setLocationToWest(Location.ROUTE_03);
        Location.MT_MOON_SQUARE.setLocationToEast(Location.MT_MOON);
        Location.MT_MOON.setLocationToWest(Location.MT_MOON_SQUARE);
        Location.MT_MOON.setLocationToEast(Location.ROUTE_04);
        Location.VIRIDIAN_FOREST.setLocationToNorth(Location.PEWTER_CITY);
        Location.VIRIDIAN_FOREST.setLocationToSouth(Location.ROUTE_02);
        Location.DIGLETTS_CAVE.setLocationToWest(Location.ROUTE_02);
        Location.DIGLETTS_CAVE.setLocationToSouth(Location.ROUTE_11);
        Location.ROCK_TUNNEL.setLocationToSouth(Location.ROUTE_10);
        Location.ROCK_TUNNEL.setLocationToWest(Location.ROUTE_09);
        Location.SAFARI_ZONE_CENTER.setLocationToNorth(Location.SAFARI_ZONE_NORTH);
        Location.SAFARI_ZONE_CENTER.setLocationToSouth(Location.FUCHSIA_CITY);
        Location.SAFARI_ZONE_CENTER.setLocationToWest(Location.SAFARI_ZONE_WEST);
        Location.SAFARI_ZONE_CENTER.setLocationToEast(Location.SAFARI_ZONE_EAST);
        Location.SAFARI_ZONE_NORTH.setLocationToSouth(Location.SAFARI_ZONE_CENTER);
        Location.SAFARI_ZONE_EAST.setLocationToWest(Location.SAFARI_ZONE_CENTER);
        Location.SAFARI_ZONE_WEST.setLocationToEast(Location.SAFARI_ZONE_CENTER);
        Location.POWER_PLANT.setLocationToWest(Location.ROUTE_10);
        Location.SEAFOAM_ISLANDS.setLocationToSouth(Location.ROUTE_20);
        Location.INDIGO_PLATEAU.setLocationToSouth(Location.ROUTE_23);
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

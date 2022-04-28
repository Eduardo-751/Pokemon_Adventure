package Model;

public enum Location {

    PALLET_TOWN(true, false, null, "Pallet Town", null, null, 0, 0),
    VIRIDIAN_CITY(true, true, null, "Viridian City", null, null, 0, 0),
    PEWTER_CITY(true, true, null, "Cinnabar Island", null, null, 0, 0),
    CERULEAN_CITY(true, true, null, "Cerulean City", null, null, 0, 0),
    VERMILION_CITY(true, true, null, "Vermilion City", null, null, 0, 0),
    LAVENDER_TOWN(true, true, null, "Lavender Town", null, null, 0, 0),
    CINNABAR_ISLAND(true, true, null, "Cinnabar Island", null, null, 0, 0),
    CELADON_CITY(true, true, null, "Celadon City", null, null, 0, 0),
    FUCHSIA_CITY(true, true, null, "Fuchsia City", null, null, 0, 0),
    SAFFRON_CITY(true, true, null, "Saffron City", null, null, 0, 0),
    ROUTE_01(false, false, null, "Route 01", new int[]{50, 100}, new Species[]{Species.PIDGEY, Species.RATATA}, 2, 5),
    ROUTE_02(false, false, null, "Route 02", new int[]{5, 50, 95, 100}, new Species[]{Species.CATERPIE, Species.PIDGEY, Species.RATATA,  Species.WEEDLE}, 2, 5),
    ROUTE_03(false, false, null, "Route 03", new int[]{20, 40, 70, 100}, new Species[]{Species.MANKEY, Species.NIDORAN, Species.PIDGEY, Species.SPEAROW}, 6, 7),
    ROUTE_04(false, false, null, "Route 04", new int[]{}, new Species[]{}, 6, 12),
    ROUTE_05(false, false, null, "Route 05", new int[]{}, new Species[]{}, 10, 16),
    ROUTE_06(false, false, null, "Route 06", new int[]{}, new Species[]{}, 10, 17),
    ROUTE_07(false, false, null, "Route 07", new int[]{}, new Species[]{}, 17, 20),
    ROUTE_08(false, false, null, "Route 08", new int[]{}, new Species[]{}, 15, 18),
    ROUTE_09(false, false, null, "Route 09", new int[]{}, new Species[]{}, 14, 17),
    ROUTE_10(false, false, null, "Route 10", new int[]{}, new Species[]{}, 13, 17),
    ROUTE_11(false, false, null, "Route 11", new int[]{}, new Species[]{}, 11, 17),
    ROUTE_12(false, false, null, "Route 12", new int[]{}, new Species[]{}, 22, 27),
    ROUTE_13(false, false, null, "Route 13", new int[]{}, new Species[]{}, 22, 27),
    ROUTE_14(false, false, null, "Route 14", new int[]{}, new Species[]{}, 24, 29),
    ROUTE_15(false, false, null, "Route 15", new int[]{}, new Species[]{}, 24, 29),
    ROUTE_16(false, false, null, "Route 16", new int[]{}, new Species[]{}, 18, 25),
    ROUTE_17(false, false, null, "Route 17", new int[]{}, new Species[]{}, 24, 28),
    ROUTE_18(false, false, null, "Route 18", new int[]{}, new Species[]{}, 24, 29),
    ROUTE_19(false, false, null, "Route 19", new int[]{}, new Species[]{}, 5, 40),
    ROUTE_20(false, false, null, "Route 20", new int[]{}, new Species[]{}, 5, 40),
    ROUTE_21(false, false, Move.SURF, "Route 21", new int[]{}, new Species[]{}, 17, 28),
    ROUTE_22(false, false, null, "Route 22", new int[]{45, 55, 100}, new Species[]{Species.MANKEY, Species.SPEAROW, Species.RATATA}, 2, 5),
    ROUTE_24(false, false, null, "Route 24", new int[]{}, new Species[]{}, 7, 12),
    ROUTE_25(false, false, null, "Route 25", new int[]{}, new Species[]{}, 8, 14),
    ROUTE_26(false, false, Move.CUT, "Route 26", new int[]{}, new Species[]{}, 28, 30),
    ROUTE_27(false, false, null, "Route 27", new int[]{}, new Species[]{},  28, 32),
    ROUTE_28(false, false, Move.CUT, "Route 28", new int[]{}, new Species[]{}, 40, 43),
    VIRIDIAN_FOREST(false, false, null, "Viridian Forest", new int[]{60, 50, 40, 0}, new Species[]{Species.CATERPIE, Species.KAKUNA, Species.METAPOD, Species.WEEDLE}, 3, 8),
    KANTO_POWER_PLANT(false, false, null, "Kanto Power Plant", new int[]{}, new Species[]{}, 20, 37),
    ROCK_TUNNEL(false, false, null, "Rock Tunnel", new int[]{}, new Species[]{}, 13, 18),
    MT_MOON_SQUARE(true, true, Move.DIG, "Mt Moon Square", null, null, 0, 0),
    MT_MOON(false, false, null, "Mt Moon", new int[]{}, new Species[]{}, 8, 12);

    private final String Name;
    private final Species[] PokemonsLivingHere;
    private final int[] SpawnChance;
    private Location LocationToNorth;
    private Location LocationToWest;
    private Location LocationToSouth;
    private Location LocationToEast;
    private final Move MoveRequiriment;
    private final int MinLvl, MaxLvl; 
    public final boolean HasPokeCenter;
    public final boolean HasStore;

    Location(boolean hasPC, boolean hasStore, Move move, String name, int[] spawnChance, Species[] pokemonLivingHere, int min, int max) {
        HasPokeCenter = hasPC;
        HasStore = hasStore;
        Name = name;
        MoveRequiriment = move;
        MinLvl = min;
        MaxLvl = max;
        PokemonsLivingHere = pokemonLivingHere;
        SpawnChance = spawnChance;
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
        Location.LAVENDER_TOWN.setLocationToEast(Location.KANTO_POWER_PLANT);
        Location.CELADON_CITY.setLocationToWest(Location.ROUTE_16);
        Location.CELADON_CITY.setLocationToEast(Location.ROUTE_07);
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
        Location.ROUTE_10.setLocationToWest(Location.KANTO_POWER_PLANT);
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
        Location.ROUTE_19.setLocationToSouth(Location.ROUTE_20);
        Location.ROUTE_20.setLocationToNorth(Location.ROUTE_19);
        Location.ROUTE_20.setLocationToWest(Location.CINNABAR_ISLAND);
        Location.ROUTE_21.setLocationToNorth(Location.PALLET_TOWN);
        Location.ROUTE_21.setLocationToSouth(Location.CINNABAR_ISLAND);
        Location.ROUTE_22.setLocationToEast(Location.VIRIDIAN_CITY);
        Location.ROUTE_22.setLocationToSouth(Location.ROUTE_26);
        Location.ROUTE_22.setLocationToWest(Location.ROUTE_28);
        Location.ROUTE_24.setLocationToNorth(Location.ROUTE_25);
        Location.ROUTE_24.setLocationToSouth(Location.CERULEAN_CITY);
        Location.ROUTE_25.setLocationToSouth(Location.ROUTE_24);
        Location.ROUTE_26.setLocationToNorth(Location.ROUTE_22);
        Location.ROUTE_26.setLocationToWest(Location.ROUTE_27);
        Location.ROUTE_27.setLocationToEast(Location.ROUTE_26);
        Location.ROUTE_28.setLocationToEast(Location.ROUTE_22);
        Location.MT_MOON_SQUARE.setLocationToWest(Location.ROUTE_03);
        Location.MT_MOON_SQUARE.setLocationToEast(Location.MT_MOON);
        Location.MT_MOON.setLocationToWest(Location.MT_MOON_SQUARE);
        Location.MT_MOON.setLocationToEast(Location.ROUTE_04);
        Location.VIRIDIAN_FOREST.setLocationToNorth(Location.PEWTER_CITY);
        Location.VIRIDIAN_FOREST.setLocationToSouth(Location.ROUTE_02);
        Location.ROCK_TUNNEL.setLocationToSouth(Location.ROUTE_10);
        Location.ROCK_TUNNEL.setLocationToWest(Location.ROUTE_09);
        Location.KANTO_POWER_PLANT.setLocationToWest(Location.LAVENDER_TOWN);
    }

    /**
     * Gets and Sets
     *
     * @return
     */   
    public boolean PokemonsLivingHere() {
        return null != PokemonsLivingHere;
    }
    
    public Species[] getPokemonsLivingHere() {
    	return PokemonsLivingHere;
    }
    
    public int[] getSpawnChance() {
    	return SpawnChance;
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

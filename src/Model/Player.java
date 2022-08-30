package Model;

import java.util.Arrays;
import java.util.Random;

public class Player {

    private final int Money;
    private final Pokemon[] Party;
    private Location CurrentLocation;

    public Player(String name, Location startLocation) {
        Money = 0;
        Party = new Pokemon[6];
        CurrentLocation = startLocation;
    }
    
    /**
     * Create a Wild Pokemon
     */
    public Pokemon CreateWildPokemon() {
        int random = new Random().nextInt(100);
        int lvl = new Random().nextInt((CurrentLocation.getMaxLvl() - CurrentLocation.getMinLvl()) + 1) + CurrentLocation.getMinLvl();
        for (Species s : CurrentLocation.getPokemonsLivingHere().keySet()) {
            if (CurrentLocation.getPokemonsLivingHere().get(s) >= random) {
            	return new Pokemon(s, lvl);
            }
        }        
        return null;
    }

    /**
     * Gets and Sets
     *
     * @return
     */
    public int getMoney() {
        return Money;
    }

    public Pokemon[] getParty() {
        byte count = (byte) Party.length;
        for (Pokemon p : Party) {
            if (p == null) {
                count--;
            }
        }
        return Arrays.copyOfRange(Party, 0, count);
    }

    public boolean addToParty(final Pokemon pokemon) {
        for (int i = 0; i < Party.length; i++) {
            if (Party[i] == null) {
                Party[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    public Location getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        CurrentLocation = currentLocation;
    }
}

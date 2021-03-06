package Model;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

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
        for(int i=0; i<CurrentLocation.getSpawnChance().length ; i++) 
            if (CurrentLocation.getSpawnChance()[i] >= random)
            	return new Pokemon(CurrentLocation.getPokemonsLivingHere()[i], lvl);
        
        return null;
    }
    
    /**
     * Check if the Pokemon Level up
     */
    public void CheckLvlUp(Pokemon p) {
        if (p.levelUp()) {
            JOptionPane.showMessageDialog(null, p.getName() + " grew to Level: " + p.getLevel() + "!");
            Move aux = p.canLearnNewMove();
            if (aux != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "You Can Learning " + aux.getName() + "!", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (p.LearnNewMove(aux)) {
                        JOptionPane.showMessageDialog(null, p.getName() + " Learned " + aux.getName() + "!");
                    } else {
                        JOptionPane.showMessageDialog(null, p.getName() + " cannot learn " + aux.getName() + "!");
                    }
                }
            }
        }
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

package Main;

import Model.Location;
import Model.Player;
import View.MenuInterface;

public class GameManager {

    private static Player player;
    private static final SoundManager sound = new SoundManager();

    public static void main(String[] args) {
        player = new Player("Eduardo", Location.PALLET_TOWN);
        MenuInterface frame = new MenuInterface(player);
        frame.setVisible(true);

        PlaySound(0);
    }

    /**
     * Control Sounds
     */
    public static void PlaySound(int i) {
        sound.SetClip(i);
        sound.PlayClip();
    }
    public static void StopSound() {
        sound.StopClip();
    }
}

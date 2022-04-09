package Main;

import Model.Location;
import Model.Player;
import View.MenuInterface;

public class GameManager {

    private static Player player;
    private static final SoundManager sound = new SoundManager();

    public static void main(String[] args) {
        player = new Player("Eduardo", Location.PALLET_TOWN);
        player.getCurrentLocation().CreateGridMap();

        MenuInterface frame = new MenuInterface(player);
        frame.setVisible(true);

        PlaySound(0);
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        GameManager.player = player;
    }

    public static void PlaySound(int i) {
        sound.SetClip(i);
        sound.PlayClip();
    }

    public static void StopSound() {
        sound.StopClip();
    }
}

package Main;

import javax.swing.JInternalFrame;

import Model.Location;
import Model.Player;
import View.ControlFrame;
import View.MenuInterface;

public class GameManager {

    private static final SoundManager sound = new SoundManager();
    private static ControlFrame mainFrame = new ControlFrame();
    private static Player player;

    public static void main(String[] args) {
        player = new Player("Eduardo", Location.PALLET_TOWN);
        mainFrame.setVisible(true);
        MenuInterface newFrame = new MenuInterface();
        AddControlFrame(newFrame);
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
    
    public static Player getPlayer() {
    	return player;
    }
    public static void AddControlFrame(JInternalFrame frame) {
    	mainFrame.setDesktopPane(frame);;
    }
    public static void RemoveControlFrame(JInternalFrame frame) {
    	mainFrame.remove(frame);
    }
}

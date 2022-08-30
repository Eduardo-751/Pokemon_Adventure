package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.GameManager;
import Model.Player;
import Model.Pokemon;
import Model.Species;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ChoiseInterface extends JFrame {

	private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private Player player;
    private JLabel[] starter = new JLabel[3];

    /**
     * Create the frame.
     *
     * @param p the Player Create by the GameManager
     */
    public ChoiseInterface(Player p) {
        player = p;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setUndecorated(true);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JLabel lblStarter = new JLabel("");
        lblStarter.setBounds(285, 55, 238, 238);
        contentPane.add(lblStarter);
        
        starter[0] = new JLabel();
        starter[0].setBounds(157, 235, 149, 152);
        contentPane.add(starter[0]);
        
        starter[1] = new JLabel();
        starter[1].setBounds(338, 304, 149, 152);
        contentPane.add(starter[1]);

        starter[2] = new JLabel();
        starter[2].setBounds(513, 235, 149, 152);
        contentPane.add(starter[2]);

        RefreshUI(null);
        
        starter[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Bulbasaur", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    ChangeToGame(Species.BULBASAUR);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Pokemon/Icon/001.png")));
                RefreshUI(starter[0]);
            }
        });

        starter[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Charmander", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    ChangeToGame(Species.CHARMANDER);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Pokemon/Icon/004.png")));
                RefreshUI(starter[1]);
            }
        });

        starter[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Squirtle", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    ChangeToGame(Species.SQUIRTLE);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Pokemon/Icon/007.png")));
                RefreshUI(starter[2]);
            }
        });

        JLabel lblChossePokemon = new JLabel("");
        lblChossePokemon.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Menu/Choose/ChoosePokemon.png")));
        lblChossePokemon.setBounds(0, 0, 800, 480);
        contentPane.add(lblChossePokemon);
    }

    public void ChangeToGame(Species species) {
    	player.addToParty(new Pokemon(species, 5));
        GameManager.StopSound();
        GameManager.PlaySound(1);
        GameInterface frame = new GameInterface(player);
        frame.setVisible(true);
        dispose();
    }
    
    public void RefreshUI(JLabel selected) {
    	for(JLabel s : starter) {
    		if(s == selected)
    			s.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Menu/Choose/Open.png")));
    		else
    			s.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Menu/Choose/Close.png")));
    	}
    }
}

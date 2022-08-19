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

        JLabel lblBulbassauro = new JLabel("");
        lblBulbassauro.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
        lblBulbassauro.setBounds(157, 235, 149, 152);
        contentPane.add(lblBulbassauro);

        JLabel lblCharmander = new JLabel("");
        lblCharmander.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
        lblCharmander.setBounds(338, 304, 149, 152);
        contentPane.add(lblCharmander);

        JLabel lblSquirtle = new JLabel("");
        lblSquirtle.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
        lblSquirtle.setBounds(513, 235, 149, 152);
        contentPane.add(lblSquirtle);

        lblBulbassauro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Bulbasaur", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    player.addToParty(new Pokemon(Species.valueOf("BULBASAUR"), 5));
                    ChangeToGame();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/001.png")));
                lblBulbassauro.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Open.png")));
                lblSquirtle.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
                lblCharmander.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
            }
        });

        lblCharmander.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Charmander", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    player.addToParty(new Pokemon(Species.valueOf("CHARMANDER"), 5));
                    ChangeToGame();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/004.png")));
                lblCharmander.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Open.png")));
                lblBulbassauro.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
                lblSquirtle.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
            }
        });

        lblSquirtle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "You Choose Squirtle", "Confirm", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    player.addToParty(new Pokemon(Species.valueOf("SQUIRTLE"), 5));
                    ChangeToGame();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblStarter.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/007.png")));
                lblSquirtle.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Open.png")));
                lblBulbassauro.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
                lblCharmander.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/Close.png")));
            }
        });

        JLabel lblChossePokemon = new JLabel("");
        lblChossePokemon.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/ChoosePokemon.png")));
        lblChossePokemon.setBounds(0, 0, 800, 480);
        contentPane.add(lblChossePokemon);
    }

    public void ChangeToGame() {
        GameManager.StopSound();
        GameManager.PlaySound(1);
        GameInterface frame = new GameInterface(player);
        frame.setVisible(true);
        dispose();
    }
}

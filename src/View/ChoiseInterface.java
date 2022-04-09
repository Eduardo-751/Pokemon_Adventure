package View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
        setBounds(100, 100, 1033, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setUndecorated(true);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JLabel lblStarter = new JLabel("");
        lblStarter.setBounds(384, 11, 238, 238);
        contentPane.add(lblStarter);

        JLabel lblBulbassauro = new JLabel("");
        lblBulbassauro.setBounds(234, 271, 142, 143);
        contentPane.add(lblBulbassauro);

        JLabel lblCharmander = new JLabel("");
        lblCharmander.setBounds(436, 330, 149, 152);
        contentPane.add(lblCharmander);

        JLabel lblSquirtle = new JLabel("");
        lblSquirtle.setBounds(645, 271, 142, 143);
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
                lblSquirtle.setBorder(null);
                lblCharmander.setBorder(null);
                Border border = BorderFactory.createBevelBorder(0);
                lblBulbassauro.setBorder(border);
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
                lblBulbassauro.setBorder(null);
                lblSquirtle.setBorder(null);
                Border border = BorderFactory.createBevelBorder(0);
                lblCharmander.setBorder(border);
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
                lblBulbassauro.setBorder(null);
                lblCharmander.setBorder(null);
                Border border = BorderFactory.createBevelBorder(0);
                lblSquirtle.setBorder(border);
            }
        });

        JLabel lblChossePokemon = new JLabel("");
        lblChossePokemon.setIcon(new ImageIcon(ChoiseInterface.class.getResource("/Img/ChoosePokemon.jpg")));
        lblChossePokemon.setBounds(0, 0, 1024, 729);
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

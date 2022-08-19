package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Player;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class MenuInterface extends JFrame {

	private static final long serialVersionUID = 1L;
    private final JPanel contentPane  = new JPanel();
    private Player player;

    /**
     * Create the frame.
     *
     * @param p the Player Create by the GameManager
     */
    public MenuInterface(Player p) {
        player = p;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 1920, 1080);
        setUndecorated(true);
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnNewGame = new JButton("NewGame");
        btnNewGame.addActionListener((ActionEvent e) -> {
            ChoiseInterface frame = new ChoiseInterface(player);
            frame.setVisible(true);
            dispose();
        });
        btnNewGame.setFont(new Font("Old English Text MT", Font.BOLD, 35));
        btnNewGame.setBounds(894, 685, 269, 64);
        contentPane.add(btnNewGame);

        JButton btnContinue = new JButton("Continue");
        btnContinue.addActionListener((ActionEvent e) -> {
        });
        btnContinue.setFont(new Font("Old English Text MT", Font.BOLD, 35));
        btnContinue.setBounds(894, 776, 269, 64);
        contentPane.add(btnContinue);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionEvent e) -> {
            dispose();
        });
        btnExit.setFont(new Font("Old English Text MT", Font.BOLD, 35));
        btnExit.setBounds(894, 863, 269, 64);
        contentPane.add(btnExit);
        
        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, -15, 1920, 1108);
        lblBackground.setIcon(new ImageIcon(MenuInterface.class.getResource("/Img/wallpaperMenu.jpg")));
        contentPane.add(lblBackground);
    }
}

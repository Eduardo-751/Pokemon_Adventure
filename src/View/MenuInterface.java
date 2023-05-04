package View;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.GameManager;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class MenuInterface extends JInternalFrame {

	private static final long serialVersionUID = 1L;
    private final JPanel contentPane  = new JPanel();

    /**
     * Create the frame.
     *
     * @param p the Player Create by the GameManager
     */
    public MenuInterface() {
    	setBorder(null);
        setBounds(0, 0, 1920, 1080);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

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
        
        JButton btnNewGame = new JButton("NewGame");
        btnNewGame.addActionListener((ActionEvent e) -> {
        	btnContinue.setVisible(false);
        	btnExit.setVisible(false);
        	btnNewGame.setVisible(false);
            ChoiseInterface newFrame = new ChoiseInterface();
        	GameManager.AddControlFrame(newFrame);
        });
        btnNewGame.setFont(new Font("Old English Text MT", Font.BOLD, 35));
        btnNewGame.setBounds(894, 689, 269, 64);
        contentPane.add(btnNewGame);
        
        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, -15, 1920, 1108);
        lblBackground.setIcon(new ImageIcon(MenuInterface.class.getResource("/Img/Menu/Choose/wallpaperMenu.jpg")));
        contentPane.add(lblBackground);
    }
}

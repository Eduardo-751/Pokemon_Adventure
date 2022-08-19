package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class MapInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player Player;
    private final JPanel contentPane;
    private final JLabel lblLocationName = new JLabel("teste");
    private final JButton btnUp = new JButton(""), btnLeft = new JButton(""), btnRight = new JButton(""), btnDown = new JButton("");
    private JLabel lblCurrentLocation = new JLabel("");

    /**
     * Create the frame.
     *
     * @param p the Player Create by the GameManager
     */
    public MapInterface(Player p) {
        Player = p;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                RefreshLocation();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20, 20, 335, 305);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setUndecorated(true);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        lblLocationName.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/WoodPanel.png")));
        lblLocationName.setForeground(Color.BLACK);
        lblLocationName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLocationName.setBackground(Color.WHITE);

        lblLocationName.setHorizontalTextPosition(SwingConstants.CENTER);
        lblLocationName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLocationName.setBounds(80, 280, 159, 25);
        contentPane.add(lblLocationName);

        lblCurrentLocation = new JLabel("");
        lblCurrentLocation.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/Location/Pallet Town.png")));
        lblCurrentLocation.setBounds(70, 71, 192, 145);
        contentPane.add(lblCurrentLocation);

        btnUp.setAlignmentY(Component.TOP_ALIGNMENT);
        btnUp.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/divisa-para-cima.png")));
        btnUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Player.getCurrentLocation().getLocationToNorth() != null) {
                    if (Player.getCurrentLocation().getLocationToNorth().getMove() == null) {
                        Player.setCurrentLocation(Player.getCurrentLocation().getLocationToNorth());
                        RefreshLocation();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You need the move " + Player.getCurrentLocation().getLocationToNorth().getMove().getName() + " to Ascess!");
                    }
                }
            }
        });
        btnUp.setBounds(130, 11, 50, 50);
        contentPane.add(btnUp);

        btnLeft.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/divisa-esquerda.png")));
        btnLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Player.getCurrentLocation().getLocationToWest() != null) {
                    if (Player.getCurrentLocation().getLocationToWest().getMove() == null) {
                        Player.setCurrentLocation(Player.getCurrentLocation().getLocationToWest());
                        RefreshLocation();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You need the move " + Player.getCurrentLocation().getLocationToWest().getMove().getName() + " to Ascess!");
                    }
                }
            }
        });
        btnLeft.setBounds(10, 150, 50, 50);
        contentPane.add(btnLeft);

        btnRight.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/divisa-direita.png")));
        btnRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Player.getCurrentLocation().getLocationToEast() != null) {
                    if (Player.getCurrentLocation().getLocationToEast().getMove() == null) {
                        Player.setCurrentLocation(Player.getCurrentLocation().getLocationToEast());
                        RefreshLocation();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You need the move " + Player.getCurrentLocation().getLocationToEast().getMove().getName() + " to Ascess!");
                    }
                }
            }

        });
        btnRight.setBounds(272, 150, 50, 50);
        contentPane.add(btnRight);

        btnDown.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/divisa-para-baixo.png")));
        btnDown.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Player.getCurrentLocation().getLocationToSouth() != null) {
                    if (Player.getCurrentLocation().getLocationToSouth().getMove() == null) {
                        Player.setCurrentLocation(Player.getCurrentLocation().getLocationToSouth());
                        RefreshLocation();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You need the move " + Player.getCurrentLocation().getLocationToSouth().getMove().getName() + " to Ascess!");
                    }
                }
            }
        });
        btnDown.setBounds(130, 227, 50, 50);
        contentPane.add(btnDown);

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(MapInterface.class.getResource("/Img/Location/MapKanto.png")));
        lblBackground.setBounds(0, 0, 335, 305);
        contentPane.add(lblBackground);
    }

    public void RefreshLocation() {
        if (Player.getCurrentLocation().getLocationToNorth() == null) {
            btnUp.setVisible(false);
        } else {
            btnUp.setVisible(true);
        }
        if (Player.getCurrentLocation().getLocationToSouth() == null) {
            btnDown.setVisible(false);
        } else {
            btnDown.setVisible(true);
        }
        if (Player.getCurrentLocation().getLocationToEast() == null) {
            btnRight.setVisible(false);
        } else {
            btnRight.setVisible(true);
        }

        if (Player.getCurrentLocation().getLocationToWest() == null) {
            btnLeft.setVisible(false);
        } else {
            btnLeft.setVisible(true);
        }

        lblCurrentLocation.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Location/" + Player.getCurrentLocation().getImgUrl() + ".png")));
        lblLocationName.setText(Player.getCurrentLocation().getImgUrl());
    }
}

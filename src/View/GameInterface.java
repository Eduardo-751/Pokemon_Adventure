package View;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.BattleManager;
import Main.GameManager;
import Model.Move;
import Model.Player;
import Model.Pokemon;
import Model.Stat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JProgressBar;
import java.awt.Color;

public final class GameInterface extends JFrame {

	private static final long serialVersionUID = 1L;
    private final Player player;
    private final MapInterface MapUi;
    private final JPanel contentPane;
    private final Container[] container = new Container[6];
    private final JTabbedPane tabbedPane;
    private final JLabel[] lblName = new JLabel[6],
            lblHP = new JLabel[6],
            lblAttack = new JLabel[6],
            lblDefense = new JLabel[6],
            lblSpAttack = new JLabel[6],
            lblSpDefense = new JLabel[6],
            lblSpeed = new JLabel[6],
            lblImg = new JLabel[6];
    private final JProgressBar[] xpBar = new JProgressBar[6];

    /**
     * Create the frame.
     *
     * @param p the Player Create by the GameManager
     */
    public GameInterface(Player p) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                int i = 0;
                for (Pokemon p : player.getParty()) {
                    if (p != null && container[i] == null) {
                        CreateContainer(p, i);
                    } else if (p != null) {
                        player.CheckLvlUp(p);
                        RefreshContainer(player.getParty()[i], i);
                    }
                    i++;
                }
            }
        });

        player = p;
        MapUi = new MapInterface(player);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 760);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JLabel lblAsh = new JLabel("");
        lblAsh.setHorizontalAlignment(SwingConstants.CENTER);
        lblAsh.setVerticalTextPosition(SwingConstants.TOP);
        lblAsh.setVerticalAlignment(SwingConstants.TOP);
        lblAsh.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Ash_Ketchum.png")));
        lblAsh.setBounds(624, 0, 360, 721);
        contentPane.add(lblAsh);

        JPanel panelPokemon = new JPanel();
        panelPokemon.setBounds(10, 213, 605, 497);
        contentPane.add(panelPokemon);

        panelPokemon.setLayout(null);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 605, 497);
        panelPokemon.add(tabbedPane);

        //Button to open the Map Frame
        JButton btnMap = new JButton("Map");
        btnMap.addActionListener((ActionEvent e) -> {
            MapUi.setVisible(true);
        });
        btnMap.setBounds(10, 11, 272, 55);
        contentPane.add(btnMap);

        //Button to Call the frame of the Battle
        JButton btnBattle = new JButton("Battle");
        btnBattle.addActionListener((ActionEvent e) -> {
            
            if (player.getParty()[tabbedPane.getSelectedIndex()].isFainted()) {
                JOptionPane.showMessageDialog(null, "Your Pokemon " + player.getParty()[tabbedPane.getSelectedIndex()].getName() + "is Dead!");
            } else if (player.getCurrentLocation().PokemonsLivingHere()) {
                new BattleManager(player, player.CreateWildPokemon() , tabbedPane.getSelectedIndex());
                GameManager.StopSound();
                GameManager.PlaySound(2);
            } else {
                JOptionPane.showMessageDialog(null, "You Can't Find Pokemons Here!");
            }
        });
        btnBattle.setBounds(10, 77, 272, 55);
        contentPane.add(btnBattle);

        //Button to Heal
        JButton btnHeal = new JButton("Heal");
        btnHeal.addActionListener((ActionEvent e) -> {
            if (player.getCurrentLocation().HasPokeCenter) {
                for (int i = 0; i < player.getParty().length; i++) {
                    if (player.getParty()[i] != null) {
                        player.getParty()[i].Revive();
                        for (Move move : player.getParty()[i].getMoveSet()) {
                            move.resetPP();
                        }
                    }
                    RefreshContainer(player.getParty()[i], i);
                }
                JOptionPane.showMessageDialog(null, "Healing Finish");
            } else {
                JOptionPane.showMessageDialog(null, "You Couldn't Find a Center Pokemon");
            }
        });
        btnHeal.setBounds(10, 143, 272, 55);
        contentPane.add(btnHeal);

        for (int i = 0; i < player.getParty().length; i++) {
            CreateContainer(player.getParty()[i], i);
        }

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/menu_background.png")));
        lblBackground.setBounds(0, 0, 984, 721);
        contentPane.add(lblBackground);
    }

    /**
     * Create the Container.
     *
     * @param poke The Pokemon Choose by the Player
     * @param indice The of the Tabbed Panel
     */
    public void CreateContainer(Pokemon poke, int indice) {
        try {
            container[indice] = new Container();
            tabbedPane.addTab("Pokemon - " + (indice + 1), null, container[indice], null);

            lblName[indice] = new JLabel();
            lblName[indice].setFont(new Font("Tahoma", Font.BOLD, 35));
            lblName[indice].setBounds(10, 11, 500, 58);
            container[indice].add(lblName[indice]);

            lblHP[indice] = new JLabel();
            lblHP[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblHP[indice].setBounds(10, 156, 158, 33);
            container[indice].add(lblHP[indice]);

            lblAttack[indice] = new JLabel();
            lblAttack[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblAttack[indice].setBounds(10, 200, 158, 33);
            container[indice].add(lblAttack[indice]);

            lblDefense[indice] = new JLabel();
            lblDefense[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblDefense[indice].setBounds(10, 244, 158, 33);
            container[indice].add(lblDefense[indice]);

            lblSpAttack[indice] = new JLabel();
            lblSpAttack[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblSpAttack[indice].setBounds(10, 288, 158, 33);
            container[indice].add(lblSpAttack[indice]);

            lblSpDefense[indice] = new JLabel();
            lblSpDefense[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblSpDefense[indice].setBounds(10, 332, 158, 33);
            container[indice].add(lblSpDefense[indice]);

            lblSpeed[indice] = new JLabel();
            lblSpeed[indice].setFont(new Font("Tahoma", Font.PLAIN, 22));
            lblSpeed[indice].setBounds(10, 376, 158, 33);
            container[indice].add(lblSpeed[indice]);

            xpBar[indice] = new JProgressBar();
            xpBar[indice].setStringPainted(true);
            xpBar[indice].setForeground(Color.GREEN);
            xpBar[indice].setBounds(10, 444, 580, 14);
            container[indice].add(xpBar[indice]);

            lblImg[indice] = new JLabel("");
            lblImg[indice].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/" + poke.getSpecie().getDexNumber() + ".png")));
            lblImg[indice].setBounds(326, 190, 238, 238);
            container[indice].add(lblImg[indice]);

            RefreshContainer(poke, indice);
        } catch (Exception e) {
        }
    }

    /**
     * Update the Container.
     *
     * @param poke The Pokemon Choose by the Player
     * @param indice The of the Tabbed Panel
     */
    public void RefreshContainer(Pokemon poke, int indice) {
        lblName[indice].setText(poke.getName() + " Lvl: " + poke.getLevel());
        lblHP[indice].setText("Hp: " + poke.getInBattleStat(Stat.HP));
        lblAttack[indice].setText("Attack: " + poke.getCurrentStat(Stat.ATTACK));
        lblDefense[indice].setText("Defense: " + poke.getCurrentStat(Stat.DEFENSE));
        lblSpAttack[indice].setText("Sp. Attack: " + poke.getCurrentStat(Stat.SP_ATTACK));
        lblSpDefense[indice].setText("Sp. Defense: " + poke.getCurrentStat(Stat.SP_DEFENSE));
        lblSpeed[indice].setText("Speed: " + poke.getCurrentStat(Stat.SPEED));
        xpBar[indice].setMaximum(poke.getExpToNextLvl() - poke.getSpecie().calculateExp(poke.getLevel()));
        xpBar[indice].setValue(poke.getExp() - poke.getSpecie().calculateExp(poke.getLevel()));
        lblImg[indice].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/" + poke.getSpecie().getDexNumber() + ".png")));
    }
}

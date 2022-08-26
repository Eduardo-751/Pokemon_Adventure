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
    private final JPanel contentPane, panelMenu;
    private JTabbedPane tabbedPane;
	private Container containerInfo, containerStatus, containerMove;
	private JLabel lblName;
	private JLabel lblLvl;
	private JLabel lblHP;
	private JLabel lblAttack;
	private JLabel lblDefense;
	private JLabel lblSpAttack;
	private JLabel lblSpDefense;
	private JLabel lblSpeed;
	private JLabel lblImg;
    private JProgressBar xpBar;
    /**
     * Create the frame.
     */
    public GameInterface(Player p) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(player.getParty().length > tabbedPane.getTabCount())
					CreateTabbedPane(tabbedPane.getTabCount());
				RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
			}
        });
        
        player = p;
        player.getCurrentLocation().CreateGridMap();
        MapUi = new MapInterface(player);
        MapUi.setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20, 330, 1000, 720);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        panelMenu = new JPanel();
        panelMenu.setBounds(10, 213, 605, 497);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
    	if(containerStatus == null) {
    		containerStatus = new Container();
    		containerStatus.setBounds(0, 28, 605, 469);
    		panelMenu.add(containerStatus);
    	}
    	
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 605, 497);
        panelMenu.add(tabbedPane);
        
        JLabel lblAsh = new JLabel("");
        lblAsh.setHorizontalAlignment(SwingConstants.CENTER);
        lblAsh.setVerticalTextPosition(SwingConstants.TOP);
        lblAsh.setVerticalAlignment(SwingConstants.TOP);
        lblAsh.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Ash_Ketchum.png")));
        lblAsh.setBounds(624, 0, 360, 721);
        contentPane.add(lblAsh);

        //Button to open the Shop Frame
        JButton btnStore = new JButton("Store");
        btnStore.addActionListener((ActionEvent e) -> {
            
        });
        btnStore.setBounds(10, 11, 272, 55);
        contentPane.add(btnStore);

        //Button to Call the frame of the Battle
        JButton btnBattle = new JButton("Battle");
        btnBattle.addActionListener((ActionEvent e) -> {
            
            if (player.getParty()[tabbedPane.getSelectedIndex()].isFainted()) {
                JOptionPane.showMessageDialog(null, "Your Pokemon " + player.getParty()[tabbedPane.getSelectedIndex()].getName() + "is Dead!");
            } else if (player.getCurrentLocation().PokemonsLivingHere()) {
                new BattleManager(player, player.getParty()[tabbedPane.getSelectedIndex()], player.CreateWildPokemon(), this);
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
                    RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
                }
                JOptionPane.showMessageDialog(null, "Healing Finish");
            } else {
                JOptionPane.showMessageDialog(null, "You Couldn't Find a Center Pokemon");
            }
        });
        btnHeal.setBounds(10, 143, 272, 55);
        contentPane.add(btnHeal);

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/menu_background.png")));
        lblBackground.setBounds(0, 0, 1000, 720);
        contentPane.add(lblBackground);
    }

	/**
     * Create the Tabbed Pane.
     */
    public void CreateTabbedPane(int indice) {
    	
		tabbedPane.addTab("Pokemon - " + (indice + 1), null);
		tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
		    public void stateChanged(javax.swing.event.ChangeEvent evt) {
		    	RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
		    	RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
		    	RefreshContainerMove(player.getParty()[tabbedPane.getSelectedIndex()]);
		    }
		});
		RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
    }
    
    /**
     * Update the Container Status.
     */
    public void RefreshContainerInfo(Pokemon poke) {
    	containerInfo.removeAll();
    	CreateLabelStatus();
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        lblHP.setText(String.valueOf(poke.getInBattleStat(Stat.HP)));
        lblAttack.setText(String.valueOf(poke.getCurrentStat(Stat.ATTACK)));
        lblDefense.setText(String.valueOf(poke.getCurrentStat(Stat.DEFENSE)));
        lblSpAttack.setText(String.valueOf(poke.getCurrentStat(Stat.SP_ATTACK)));
        lblSpDefense.setText(String.valueOf(poke.getCurrentStat(Stat.SP_DEFENSE)));
        lblSpeed.setText(String.valueOf(poke.getCurrentStat(Stat.SPEED)));
        xpBar.setMaximum(poke.getExpToNextLvl() - poke.getSpecie().calculateExp(poke.getLevel()));
        xpBar.setValue(poke.getExp() - poke.getSpecie().calculateExp(poke.getLevel()));
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Info Container.
     */
    public void CreateLabelInfo() {
    	lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		containerInfo.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		containerInfo.add(lblLvl);

		xpBar = new JProgressBar();
		xpBar.setStringPainted(true);
		xpBar.setForeground(Color.GREEN);
		xpBar.setBounds(263, 434, 327, 24);
		containerInfo.add(xpBar);

		lblImg = new JLabel("");
		lblImg.setBounds(41, 157, 184, 184);
		containerInfo.add(lblImg);

		JLabel StatusBackground = new JLabel("");
		StatusBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokegear/bg_1.png")));
		StatusBackground.setBounds(0, 0, 600, 469);
		containerInfo.add(StatusBackground);
    }
    
    /**
     * Update the Container Status.
     */
    public void RefreshContainerStatus(Pokemon poke) {
    	containerStatus.removeAll();
    	CreateLabelStatus();
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        lblHP.setText(String.valueOf(poke.getInBattleStat(Stat.HP)));
        lblAttack.setText(String.valueOf(poke.getCurrentStat(Stat.ATTACK)));
        lblDefense.setText(String.valueOf(poke.getCurrentStat(Stat.DEFENSE)));
        lblSpAttack.setText(String.valueOf(poke.getCurrentStat(Stat.SP_ATTACK)));
        lblSpDefense.setText(String.valueOf(poke.getCurrentStat(Stat.SP_DEFENSE)));
        lblSpeed.setText(String.valueOf(poke.getCurrentStat(Stat.SPEED)));
        xpBar.setMaximum(poke.getExpToNextLvl() - poke.getSpecie().calculateExp(poke.getLevel()));
        xpBar.setValue(poke.getExp() - poke.getSpecie().calculateExp(poke.getLevel()));
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Status Container.
     */
    public void CreateLabelStatus() {
    	lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		containerStatus.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		containerStatus.add(lblLvl);

		lblHP = new JLabel();
		lblHP.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHP.setBounds(451, 93, 113, 33);
		containerStatus.add(lblHP);

		lblAttack = new JLabel();
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAttack.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttack.setBounds(451, 148, 113, 33);
		containerStatus.add(lblAttack);

		lblDefense = new JLabel();
		lblDefense.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefense.setBounds(451, 188, 113, 33);
		containerStatus.add(lblDefense);

		lblSpAttack = new JLabel();
		lblSpAttack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSpAttack.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpAttack.setBounds(451, 227, 113, 33);
		containerStatus.add(lblSpAttack);

		lblSpDefense = new JLabel();
		lblSpDefense.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSpDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpDefense.setBounds(451, 266, 113, 33);
		containerStatus.add(lblSpDefense);

		lblSpeed = new JLabel();
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpeed.setBounds(451, 305, 113, 33);
		containerStatus.add(lblSpeed);

		xpBar = new JProgressBar();
		xpBar.setStringPainted(true);
		xpBar.setForeground(Color.GREEN);
		xpBar.setBounds(263, 434, 327, 24);
		containerStatus.add(xpBar);

		lblImg = new JLabel("");
		lblImg.setBounds(41, 157, 184, 184);
		containerStatus.add(lblImg);

		JLabel StatusBackground = new JLabel("");
		StatusBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokegear/bg_3.png")));
		StatusBackground.setBounds(0, 0, 600, 469);
		containerStatus.add(StatusBackground);
    }
    
    /**
     * Update the Container Status.
     */
    public void RefreshContainerMove(Pokemon poke) {
    	containerMove.removeAll();
    	CreateLabelStatus();
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        lblHP.setText(String.valueOf(poke.getInBattleStat(Stat.HP)));
        lblAttack.setText(String.valueOf(poke.getCurrentStat(Stat.ATTACK)));
        lblDefense.setText(String.valueOf(poke.getCurrentStat(Stat.DEFENSE)));
        lblSpAttack.setText(String.valueOf(poke.getCurrentStat(Stat.SP_ATTACK)));
        lblSpDefense.setText(String.valueOf(poke.getCurrentStat(Stat.SP_DEFENSE)));
        lblSpeed.setText(String.valueOf(poke.getCurrentStat(Stat.SPEED)));
        xpBar.setMaximum(poke.getExpToNextLvl() - poke.getSpecie().calculateExp(poke.getLevel()));
        xpBar.setValue(poke.getExp() - poke.getSpecie().calculateExp(poke.getLevel()));
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Info Container.
     */
    public void CreateLabelMove() {
    	lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		containerMove.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		containerMove.add(lblLvl);

		xpBar = new JProgressBar();
		xpBar.setStringPainted(true);
		xpBar.setForeground(Color.GREEN);
		xpBar.setBounds(263, 434, 327, 24);
		containerMove.add(xpBar);

		lblImg = new JLabel("");
		lblImg.setBounds(41, 157, 184, 184);
		containerMove.add(lblImg);

		JLabel StatusBackground = new JLabel("");
		StatusBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokegear/bg_4.png")));
		StatusBackground.setBounds(0, 0, 600, 469);
		containerStatus.add(containerMove);
    }
}

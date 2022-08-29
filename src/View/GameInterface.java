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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class GameInterface extends JFrame {

	private static final long serialVersionUID = 1L;
    private final Player player;
    private final MapInterface MapUi;
    private final JPanel contentPane, panelMenu;
	private Container containerInfo, containerStatus, containerMove;
	private JLabel btnInfo,btnStatus, btnMove;
	private JLabel lblName, lblLvl, lblHP;
	//Labels Info
	private JLabel lblDexNum, 
				   lblSpecies, 
				   lblType, 
				   lblExpPoint, 
				   lblExpNextLv;
	//Labels Status
	private JLabel lblAttack, 
				   lblDefense, 
				   lblSpAttack, 
				   lblSpDefense, 
				   lblSpeed;
	//Labels Status
	private Container[] listMoves = new Container[4]; 
	private JLabel[] lblMoveName = new JLabel[4], 
				     lblMoveType = new JLabel[4], 
				     lblMovePP = new JLabel[4];
	//Labels Move
	private JLabel lblImg;
    private JProgressBar xpBar, hpBar;
    private JTabbedPane tabbedPane;
    /**
     * Create the frame.
     */
    public GameInterface(Player p) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(player.getParty().length > tabbedPane.getTabCount())
					CreateTabbedPane(tabbedPane.getTabCount());
				RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
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
		
		containerInfo = new Container();
		containerInfo.setBounds(0, 28, 605, 469);
		containerInfo.setVisible(true);
		panelMenu.add(containerInfo);
		
		containerStatus = new Container();
		containerStatus.setBounds(0, 28, 605, 469);
		containerStatus.setVisible(false);
		panelMenu.add(containerStatus);
		
		containerMove = new Container();
		containerMove.setBounds(0, 28, 605, 469);
		containerMove.setVisible(false);
		panelMenu.add(containerMove);
		
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
		RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
    }
    
    /**
     * Update the Container Info.
     */
    public void RefreshContainerInfo(Pokemon poke) {
    	containerInfo.removeAll();
    	CreateLabelInfo();
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        lblDexNum.setText(poke.getSpecie().getDexNumber());
        lblSpecies.setText(poke.getSpecie().getName());
        lblType.setText(poke.getTypeName());
        lblExpPoint.setText(String.valueOf(poke.getExp()));
        lblExpNextLv.setText(String.valueOf(poke.getExpToNextLvl()-poke.getExp()));
        xpBar.setMaximum(poke.getExpToNextLvl() - poke.getSpecie().calculateExp(poke.getLevel()));
        xpBar.setValue(poke.getExp() - poke.getSpecie().calculateExp(poke.getLevel()));
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Info Container.
     */
    public void CreateLabelInfo() {
    	
		btnInfo = new JLabel("");
		btnInfo.setBounds(272, 16, 53, 48);
		btnInfo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(true);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(false);
        		RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerInfo.add(btnInfo);
		
		btnStatus = new JLabel("");
		btnStatus.setBounds(402, 16, 53, 48);
		btnStatus.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(false);
        		containerStatus.setVisible(true);
        		containerMove.setVisible(false);
        		RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerInfo.add(btnStatus);
		
		btnMove = new JLabel("");
		btnMove.setBounds(468, 16, 53, 48);
		btnMove.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(false);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(true);
        		RefreshContainerMove(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerInfo.add(btnMove);
		
    	lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		containerInfo.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		containerInfo.add(lblLvl);

		lblDexNum = new JLabel();
		lblDexNum.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDexNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDexNum.setBounds(432, 100, 151, 33);
		containerInfo.add(lblDexNum);

		lblSpecies = new JLabel();
		lblSpecies.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSpecies.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpecies.setBounds(432, 139, 151, 33);
		containerInfo.add(lblSpecies);

		lblType = new JLabel();
		lblType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(432, 179, 151, 33);
		containerInfo.add(lblType);

		lblExpPoint = new JLabel();
		lblExpPoint.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblExpPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpPoint.setBounds(432, 334, 151, 33);
		containerInfo.add(lblExpPoint);

		lblExpNextLv = new JLabel();
		lblExpNextLv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblExpNextLv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpNextLv.setBounds(432, 412, 151, 33);
		containerInfo.add(lblExpNextLv);
		
		xpBar = new JProgressBar();
		xpBar.setForeground(Color.BLUE);
		xpBar.setBounds(422, 453, 155, 10);
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
        lblHP.setText(String.valueOf(poke.getInBattleStat(Stat.HP) + "/" + poke.getCurrentStat(Stat.HP)));
        lblAttack.setText(String.valueOf(poke.getCurrentStat(Stat.ATTACK)));
        lblDefense.setText(String.valueOf(poke.getCurrentStat(Stat.DEFENSE)));
        lblSpAttack.setText(String.valueOf(poke.getCurrentStat(Stat.SP_ATTACK)));
        lblSpDefense.setText(String.valueOf(poke.getCurrentStat(Stat.SP_DEFENSE)));
        lblSpeed.setText(String.valueOf(poke.getCurrentStat(Stat.SPEED)));
        hpBar.setMaximum(poke.getCurrentStat(Stat.HP));
        hpBar.setValue(poke.getInBattleStat(Stat.HP));
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Status Container.
     */
    public void CreateLabelStatus() {
    	btnInfo = new JLabel("");
		btnInfo.setBounds(272, 16, 53, 48);
		btnInfo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(true);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(false);
        		RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerStatus.add(btnInfo);
		
		btnStatus = new JLabel("");
		btnStatus.setBounds(402, 16, 53, 48);
		btnStatus.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(false);
        		containerStatus.setVisible(true);
        		containerMove.setVisible(false);
        		RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerStatus.add(btnStatus);
		
		btnMove = new JLabel("");
		btnMove.setBounds(468, 16, 53, 48);
		btnMove.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(false);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(true);
        		RefreshContainerMove(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerStatus.add(btnMove);
		
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
		
		hpBar = new JProgressBar();
		hpBar.setForeground(Color.GREEN);
		hpBar.setBounds(422, 133, 115, 10);
		containerStatus.add(hpBar);

		lblImg = new JLabel("");
		lblImg.setBounds(41, 157, 184, 184);
		containerStatus.add(lblImg);

		JLabel StatusBackground = new JLabel("");
		StatusBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokegear/bg_3.png")));
		StatusBackground.setBounds(0, 0, 600, 469);
		containerStatus.add(StatusBackground);
    }
    
    /**
     * Update the Container Move.
     */
    public void RefreshContainerMove(Pokemon poke) {
    	containerMove.removeAll();
    	CreateLabelMove(poke);
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        int i = 0;
        for(Move m : poke.getMoveSet()) {
            lblMoveName[i].setText(m.getName());
            lblMoveType[i].setText(m.getType().name());
            lblMovePP[i].setText("PP    " + m.getCurrentPP() + "/" + m.getTotalPP());
            i++;
        }
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Move Container.
     */
    public void CreateLabelMove(Pokemon poke) {
    	btnInfo = new JLabel("");
		btnInfo.setBounds(272, 16, 53, 48);
		btnInfo.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerInfo.setVisible(true);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(false);
        		RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerMove.add(btnInfo);
		
		btnStatus = new JLabel("");
		btnStatus.setBounds(402, 16, 53, 48);
		btnStatus.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerMove.setVisible(false);
        		containerStatus.setVisible(true);
        		containerMove.setVisible(false);
        		RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerMove.add(btnStatus);
		
		btnMove = new JLabel("");
		btnMove.setBounds(468, 16, 53, 48);
		btnMove.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		containerMove.setVisible(false);
        		containerStatus.setVisible(false);
        		containerMove.setVisible(true);
        		RefreshContainerMove(player.getParty()[tabbedPane.getSelectedIndex()]);
        	}
        });
		containerMove.add(btnMove);
		
    	lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		containerMove.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		containerMove.add(lblLvl);
		
		for(int i = 0; i<4; i++) {
			listMoves[i] = new Container();
			listMoves[i].setBounds(280, 115+(i*80), 290, 80);
			containerMove.add(listMoves[i]);

			lblMoveName[i] = new JLabel();
			lblMoveName[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblMoveName[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoveName[i].setBounds(117, 5, 160, 33);
			listMoves[i].add(lblMoveName[i]);

			lblMoveType[i] = new JLabel();
			lblMoveType[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			lblMoveType[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoveType[i].setBounds(0, 5, 110, 33);
			listMoves[i].add(lblMoveType[i]);

			lblMovePP[i] = new JLabel();
			lblMovePP[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblMovePP[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMovePP[i].setBounds(78, 44, 198, 33);
			listMoves[i].add(lblMovePP[i]);
		}
		
		lblImg = new JLabel("");
		lblImg.setBounds(41, 157, 184, 184);
		containerMove.add(lblImg);

		JLabel MoveBackground = new JLabel("");
		MoveBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokegear/bg_4.png")));
		MoveBackground.setBounds(0, 0, 600, 469);
		containerMove.add(MoveBackground);
    }
}

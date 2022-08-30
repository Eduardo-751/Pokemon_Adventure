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
import java.util.Arrays;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class GameInterface extends JFrame {

	private static final long serialVersionUID = 1L;
    private final Player player;
    private final MapInterface MapUi;
    private final JPanel contentPane, panelMenu;
    private JTabbedPane tabbedPane;
	private Container containerInfo, containerStatus, containerMove, containerNewMove;
	private JLabel btnInfo,btnStatus, btnMove;
	private JLabel lblName, lblLvl, lblHP;
	//Labels Info
	private JLabel lblDexNum, 
				   lblSpecies, 
				   lblExpPoint, 
				   lblExpNextLv;
	private JLabel[] lblType = new JLabel[2]; 
	//Labels Status
	private JLabel lblAttack, 
				   lblDefense, 
				   lblSpAttack, 
				   lblSpDefense, 
				   lblSpeed;
	//Labels Move
	private Container[] listMoves = new Container[4]; 
	private JLabel[] lblMoveName = new JLabel[4], 
				     lblMoveType = new JLabel[4], 
				     lblMovePP = new JLabel[4];
	//Labels New Move
	private Container NewMove = new Container(); 
	private JLabel lblNewMoveName = new JLabel(), 
				   lblNewMoveType = new JLabel(), 
				   lblNewMovePP = new JLabel(),
				   lblNewMoveCategory = new JLabel(),
				   lblNewMovePower = new JLabel(),
				   lblNewMoveAccuracy = new JLabel();	
	private JLabel lblImg;
    private JProgressBar xpBar, hpBar;
    JLabel MenuBackground = new JLabel();
    /**
     * Create the frame.
     */
    public GameInterface(Player p) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(player.getParty().length > tabbedPane.getTabCount()) {
					CreateTabbedPane(tabbedPane.getTabCount());
					RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
				}
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
		
		containerNewMove = new Container();
		containerNewMove.setBounds(0, 28, 605, 469);
		containerNewMove.setVisible(false);
		panelMenu.add(containerNewMove);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 605, 497);
		panelMenu.add(tabbedPane);
        
        JLabel lblAsh = new JLabel("");
        lblAsh.setHorizontalAlignment(SwingConstants.CENTER);
        lblAsh.setVerticalTextPosition(SwingConstants.TOP);
        lblAsh.setVerticalAlignment(SwingConstants.TOP);
        lblAsh.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Ash_Ketchum.png")));
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
                    RefreshContainerInfo(player.getParty()[tabbedPane.getSelectedIndex()]);
    		    	RefreshContainerStatus(player.getParty()[tabbedPane.getSelectedIndex()]);
    		    	RefreshContainerMove(player.getParty()[tabbedPane.getSelectedIndex()]);
                }
                JOptionPane.showMessageDialog(null, "Healing Finish");
            } else {
                JOptionPane.showMessageDialog(null, "You Couldn't Find a Center Pokemon");
            }
        });
        btnHeal.setBounds(10, 143, 272, 55);
        contentPane.add(btnHeal);

        JLabel lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/menu_background.png")));
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
        if(poke.getType().length == 1)
        	lblType[1].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokemon/Type/" + poke.getType()[0].name() + ".png")));
        else{
        	lblType[0].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokemon/Type/" + poke.getType()[0].name() + ".png")));
        	lblType[1].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokemon/Type/" + poke.getType()[1].name() + ".png")));
        }
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
    	
    	CreateMenuButtons(containerInfo);
    	CreateMenuLabels(containerInfo);

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

		lblType[0] = new JLabel();
		lblType[0].setBounds(435, 183, 72, 24);
		containerInfo.add(lblType[0]);
		lblType[1] = new JLabel();
		lblType[1].setBounds(512, 184, 72, 24);
		containerInfo.add(lblType[1]);

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

		MenuBackground = new JLabel();
		MenuBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/bg_1.png")));
		MenuBackground.setBounds(0, 0, 600, 469);
		containerInfo.add(MenuBackground);
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

    	CreateMenuButtons(containerStatus);
    	CreateMenuLabels(containerStatus);

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

		MenuBackground = new JLabel();
		MenuBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/bg_3.png")));
		MenuBackground.setBounds(0, 0, 600, 469);
		containerStatus.add(MenuBackground);
    }
    
    /**
     * Update the Container Move.
     */
    public void RefreshContainerMove(Pokemon poke) {
    	
    	containerMove.removeAll();
    	
    	CreateLabelMove();
    	
        lblName.setText(poke.getName());
        lblLvl.setText(String.valueOf(poke.getLevel()));
        for(int i = 0; i<4; i++) {
        	Move m = poke.getMoveSet()[i];
            lblMoveName[i].setText(m.getName());
        	if(!Move.NULL.equals(m)) {
    			lblMoveType[i].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/" + m.getMoveType().name() + ".png")));
    			lblMovePP[i].setText("PP    " + m.getCurrentPP() + "/" + m.getTotalPP());
        	}
        }
        lblImg.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Icon/" + poke.getSpecie().getDexNumber() + ".png")));
    }
    
    /**
     * Update the Labels of the Move Container.
     */
    public void CreateLabelMove() {
		
    	CreateMenuButtons(containerMove);
    	CreateMenuLabels(containerMove);
		
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
			lblMoveType[i].setBounds(7, 7, 75, 30);
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

		MenuBackground = new JLabel();
		MenuBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/bg_4.png")));
		MenuBackground.setBounds(0, 0, 600, 469);
		containerMove.add(MenuBackground);
    }
    
    /**
     * Update the Container New Move.
     */
    public void RefreshContainerNewMove(Pokemon poke, Move newMove) {
    	
		containerInfo.setVisible(false);
		containerStatus.setVisible(false);
		containerMove.setVisible(false);
		containerNewMove.setVisible(true);
		
    	containerNewMove.removeAll();
    	
		CreateLabelNewMove(poke, newMove);
		
		lblName.setText(poke.getName());
		lblLvl.setText(String.valueOf(poke.getLevel()));
        for(int i = 0; i<4; i++) {
        	Move m = poke.getMoveSet()[i];
            lblMoveName[i].setText(m.getName());
        	if(!Move.NULL.equals(m)) {
    			lblMoveType[i].setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/" + m.getMoveType().name() + ".png")));
    			lblMovePP[i].setText("PP    " + m.getCurrentPP() + "/" + m.getTotalPP());
        	}
        }
		lblNewMoveName.setText(newMove.getName());
		lblNewMoveType.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/" + newMove.getMoveType().name() + ".png")));
		lblNewMovePP.setText("PP    " + newMove.getCurrentPP() + "/" + newMove.getTotalPP());
		lblNewMoveCategory.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokemon/Type/" + newMove.getType().name() + ".png")));
		lblNewMovePower.setText(String.valueOf(newMove.getPower()));
		lblNewMoveAccuracy.setText(newMove.getAccuracy() + "%");
    }
    
    /**
     * Update the Labels of the New Move Container.
     */
    public void CreateLabelNewMove(Pokemon poke, Move newMove) {
    	
    	CreateMenuLabels(containerNewMove);
		
		for(int i = 0; i<4; i++) {
			listMoves[i] = new Container();
			listMoves[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					poke.LearnNewMove(newMove, Arrays.asList(listMoves).indexOf(e.getSource()));
					containerInfo.setVisible(false);
	        		containerStatus.setVisible(false);
	        		containerMove.setVisible(true);
	        		containerNewMove.setVisible(false);
					RefreshContainerMove(poke);
				}
			});
			listMoves[i].setBounds(287, 24+(i*80), 290, 80);
			containerNewMove.add(listMoves[i]);

			lblMoveName[i] = new JLabel();
			lblMoveName[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblMoveName[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoveName[i].setBounds(117, 5, 160, 33);
			listMoves[i].add(lblMoveName[i]);

			lblMoveType[i] = new JLabel();
			lblMoveType[i].setBounds(7, 7, 75, 30);
			listMoves[i].add(lblMoveType[i]);

			lblMovePP[i] = new JLabel();
			lblMovePP[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblMovePP[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMovePP[i].setBounds(78, 44, 198, 33);
			listMoves[i].add(lblMovePP[i]);
		}
		
		NewMove = new Container();
		NewMove.setBounds(287, 362, 290, 80);
		containerNewMove.add(NewMove);
		
		lblNewMoveType = new JLabel();
		lblNewMoveType.setBounds(7, 7, 75, 30);
		NewMove.add(lblNewMoveType);
		
		lblNewMoveName = new JLabel();
		lblNewMoveName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewMoveName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewMoveName.setBounds(117, 5, 160, 33);
		NewMove.add(lblNewMoveName);
		
		lblNewMovePP = new JLabel();
		lblNewMovePP.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewMovePP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewMovePP.setBounds(78, 44, 198, 33);
		NewMove.add(lblNewMovePP);
		
		lblNewMoveCategory = new JLabel();
		lblNewMoveCategory.setBounds(200, 151, 94, 32);
		containerNewMove.add(lblNewMoveCategory);
		
		lblNewMovePower = new JLabel();
		lblNewMovePower.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewMovePower.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewMovePower.setBounds(180, 192, 94, 32);
		containerNewMove.add(lblNewMovePower);
		
		lblNewMoveAccuracy = new JLabel();
		lblNewMoveAccuracy.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewMoveAccuracy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewMoveAccuracy.setBounds(180, 229, 94, 32);
		containerNewMove.add(lblNewMoveAccuracy);
		
		MenuBackground = new JLabel();
		MenuBackground.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Menu/Pokegear/bg_learnmove.png")));
		MenuBackground.setBounds(0, 0, 600, 469);
		containerNewMove.add(MenuBackground);
    }
    
    //Create Buttons to Navegate in to the Menu
    public void CreateMenuButtons(Container container) {
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
		container.add(btnInfo);
		
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
		container.add(btnStatus);
		
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
		container.add(btnMove);
    }
    
    //Create Label Name and Lvl in the Containers
	public void CreateMenuLabels(Container container) {
		lblName = new JLabel();
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblName.setBounds(10, 77, 212, 33);
		container.add(lblName);

		lblLvl = new JLabel();
		lblLvl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLvl.setBounds(59, 116, 52, 33);
		container.add(lblLvl);
	}
}

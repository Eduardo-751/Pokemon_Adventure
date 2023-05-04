package View;

import java.awt.Container;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Main.BattleManager;
import Main.GameManager;
import Model.Move;
import Model.Pokemon;
import Model.Stat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BattleInterface extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final BattleManager battleManager;
	private final Container PokemonStats, EnemyStats;
	private final JPanel contentPane;
	private final JLabel lblPP, lblPower, lblAccuracy;
	private final JLabel lblChangePokemon;
	private final JLabel pokemonName = new JLabel(), enemyName = new JLabel();
	private final JLabel lblPokemonHp = new JLabel();
	private final JProgressBar pokemonHealthBar = new JProgressBar(), 
							   enemyHealthBar = new JProgressBar(),
							   pokemonXpBar = new JProgressBar();
	private JLabel lblEnemySprite = new JLabel(), lblPokeSprite = new JLabel();
	private JButton[] btnMove = new JButton[4];
	public JTextPane txtLog = new JTextPane();
	public Container ContainerMenu = new Container(), 
			 		 ContainerFight = new Container(), 
			 		 ContainerPokemon = new Container();
	private int indice;
	private boolean runAway = false;

	/**
	 * Create the frame.
	 *
	 * @param bm The Class Battle Manager
	 */
	public BattleInterface(BattleManager bm) {
		setBorder(null);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				indice = bm.Indice;
				if (battleManager.getOpponent() != null && battleManager.getPokemon() != null) {
					for (int i = 0; i < battleManager.getPokemon().getMoveSet().length; i++) {
						if (btnMove[i] == null) {
							ContainerFight.add(CreateMoveButtons(i));
						}
					}
					RefreshUI(battleManager.getPokemon(), battleManager.getOpponent());
				}
			}

			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				Pokemon poke = battleManager.getPokemon();
				if (battleManager.getOpponent().isFainted()) {
					int aux = battleManager.calcExp(battleManager.getOpponent());
					poke.AddExp(aux);
					Move newMove = poke.NewMove();
			        if(newMove != null) {
			        	JOptionPane.showMessageDialog(null, "You Can Learning " + newMove.getName() + "!");
			        	battleManager.getGameInterface().RefreshContainerNewMove(poke, newMove);
			        }			
					else {
						battleManager.getGameInterface().RefreshContainerInfo(battleManager.getPokemon());
						battleManager.getGameInterface().RefreshContainerStatus(battleManager.getPokemon());
						battleManager.getGameInterface().RefreshContainerMove(battleManager.getPokemon());
					}
				} else if (battleManager.getPokemon().isFainted()) {
					JOptionPane.showMessageDialog(null, "All your pokemon is Dead!");
				} else if (runAway) {
					JOptionPane.showMessageDialog(null, "Got away safely!");
				}
				battleManager.getGameInterface().CreateTabbedPane();
			}
		});
		battleManager = bm;

		setBounds(460, 180, 1000, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/**
		 * Create the Container Menu.
		 */
		PokemonStats = new Container();
		PokemonStats.setBounds(531, 308, 445, 135);
		contentPane.add(PokemonStats);

		EnemyStats = new Container();
		EnemyStats.setBounds(16, 18, 380, 90);
		contentPane.add(EnemyStats);

		lblPokeSprite = new JLabel("");
		lblPokeSprite.setBounds(71, 283, 160, 160);
		contentPane.add(lblPokeSprite);

		lblEnemySprite = new JLabel("");
		lblEnemySprite.setBounds(762, 67, 160, 160);
		contentPane.add(lblEnemySprite);
		
		CreateUI(bm.getPokemon(), bm.getOpponent());

		/**
		 * Create the Container Fight.
		 */
		ContainerMenu.setEnabled(false);
		ContainerMenu.setBounds(17, 456, 960, 240);
		contentPane.add(ContainerMenu);
		ContainerMenu.setLayout(null);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener((var e) -> {
			runAway = true;
			GameManager.StopSound();
			GameManager.PlaySound(1);
			dispose();
		});
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnRun.setBounds(729, 128, 216, 71);
		ContainerMenu.add(btnRun);

		JButton btnCatch = new JButton("Catch");
		btnCatch.addActionListener((ActionEvent e) -> {
			if (battleManager.getParty().length < 6) {
				if (battleManager.getOpponent().calculateCatchRate(255)) {
					JOptionPane.showMessageDialog(null, "You Capture " + battleManager.getOpponent().getName());
					battleManager.getPlayer().addToParty(battleManager.getOpponent());
				} else {
					JOptionPane.showMessageDialog(null, "The " + battleManager.getOpponent().getName() + " Run away!");
				}
				GameManager.StopSound();
				GameManager.PlaySound(1);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Your Party is Full!");
			}
		});
		btnCatch.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCatch.setBounds(729, 46, 216, 71);
		ContainerMenu.add(btnCatch);

		JButton btnPokemon = new JButton("Pokemon");
		btnPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (battleManager.getParty().length > 1) {
					ContainerMenu.setVisible(false);
					ContainerPokemon.setVisible(true);
					ChangePokemon();
				}
			}
		});
		btnPokemon.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnPokemon.setBounds(502, 129, 216, 71);
		ContainerMenu.add(btnPokemon);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (battleManager.getParty()[indice].getInBattleHp() <= 0) {
					JOptionPane.showMessageDialog(null,
							"Your Pokemon " + battleManager.getParty()[indice].getName() + " is Dead!");
					indice = 0;
					ChangePokemon();
				} else {
					JOptionPane.showMessageDialog(null, "Your Chosse " + battleManager.getParty()[indice].getName() + "!");
					battleManager.setPokemon(battleManager.getParty()[indice]);
					RefreshUI(battleManager.getPokemon(), battleManager.getOpponent());
					ContainerFight.removeAll();
					for (int i = 0; i < 4; i++) {
						if (battleManager.getPokemon().getMoveSet().length > i)
							ContainerFight.add(CreateMoveButtons(i));
					}
					ContainerPokemon.setVisible(false);
					ContainerMenu.setVisible(true);
				}
			}
		});
		btnChoose.setBounds(431, 202, 90, 23);
		ContainerPokemon.add(btnChoose);

		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (indice == battleManager.getParty().length - 1) {
					indice = 0;
				} else {
					indice++;
				}
				ChangePokemon();
			}
		});
		btnNext.setBounds(531, 202, 90, 23);
		ContainerPokemon.add(btnNext);

		JButton btnPrevius = new JButton("btnPrevius");
		btnPrevius.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (indice == 0) {
					indice = battleManager.getParty().length - 1;
				} else {
					indice--;
				}

				ChangePokemon();
			}
		});
		btnPrevius.setBounds(331, 202, 90, 23);
		ContainerPokemon.add(btnPrevius);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener((ActionEvent e) -> {
			ContainerMenu.setVisible(false);
			ContainerFight.setVisible(true);
		});
		btnFight.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnFight.setBounds(502, 47, 216, 71);
		ContainerMenu.add(btnFight);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 20, 471, 199);
		ContainerMenu.add(scrollPane);
		scrollPane.setViewportView(txtLog);

		txtLog.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ContainerFight.setLayout(null);
		ContainerFight.setVisible(false);
		ContainerFight.setVisible(false);
		ContainerFight.setBounds(17, 456, 960, 240);
		contentPane.add(ContainerFight);

		JPanel panelMoveDetails = new JPanel();
		panelMoveDetails.setLayout(null);
		panelMoveDetails.setBackground(Color.WHITE);
		panelMoveDetails.setBounds(501, 21, 449, 198);
		ContainerFight.add(panelMoveDetails);

		lblPP = new JLabel();
		lblPP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPP.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPP.setBounds(269, 137, 170, 50);
		panelMoveDetails.add(lblPP);

		lblPower = new JLabel();
		lblPower.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPower.setBounds(10, 76, 170, 50);
		panelMoveDetails.add(lblPower);

		lblAccuracy = new JLabel();
		lblAccuracy.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAccuracy.setBounds(10, 137, 170, 50);
		panelMoveDetails.add(lblAccuracy);

		JLabel lblDescription = new JLabel();
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDescription.setBounds(10, 11, 429, 54);
		panelMoveDetails.add(lblDescription);
		
		ContainerPokemon.setBounds(17, 456, 960, 240);
		ContainerPokemon.setVisible(false);
		contentPane.add(ContainerPokemon);

		lblChangePokemon = new JLabel("");
		lblChangePokemon.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/Pokemon/Icon/004.png")));
		lblChangePokemon.setBounds(361, 0, 238, 238);
		ContainerPokemon.add(lblChangePokemon);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/Menu/Battle/battlegrass.png")));
		lblBackground.setBounds(16, 18, 960, 425);
		contentPane.add(lblBackground);
	}

	/**
	 * Create the UI Container.
	 *
	 * @param attacking The Pokemon of the Player
	 * @param opponent  The Random Pokemon finded in the Map
	 */
	public void CreateUI(Pokemon attacking, Pokemon opponent) {
		pokemonName.setVerticalAlignment(SwingConstants.TOP);
		pokemonName.setFont(new Font("Tahoma", Font.BOLD, 20));
		pokemonName.setBounds(71, 20, 349, 32);
		PokemonStats.add(pokemonName);
		
		lblPokemonHp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonHp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPokemonHp.setBounds(202, 86, 197, 23);
		PokemonStats.add(lblPokemonHp);
		
		pokemonHealthBar.setForeground(Color.RED);
		pokemonHealthBar.setBounds(227, 60, 173, 18);
		PokemonStats.add(pokemonHealthBar);
		
		enemyName.setFont(new Font("Tahoma", Font.BOLD, 16));
		enemyName.setVerticalAlignment(SwingConstants.TOP);
		enemyName.setBounds(5, 15, 300, 30);
		EnemyStats.add(enemyName);
		
		enemyHealthBar.setForeground(Color.RED);
		enemyHealthBar.setBounds(169, 55, 144, 15);
		EnemyStats.add(enemyHealthBar);
		
		pokemonXpBar.setForeground(Color.BLUE);
		pokemonXpBar.setBounds(67, 118, 333, 9);
		PokemonStats.add(pokemonXpBar);
		
		JLabel pokemonStatsBackground = new JLabel("");
		pokemonStatsBackground.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/Menu/Battle/databox.png")));
		pokemonStatsBackground.setBounds(0, 0, 445, 135);
		PokemonStats.add(pokemonStatsBackground);
		
		JLabel enemyStatsBackground = new JLabel("");
		enemyStatsBackground.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/Menu/Battle/databox_foe.png")));
		enemyStatsBackground.setBounds(0, 0, 380, 90);
		EnemyStats.add(enemyStatsBackground);
	}

	/**
	 * Update the Container.
	 *
	 * @param attacking The Pokemon who Makes the Move
	 * @param opponent  The Target of the Pokemon
	 */
	public void RefreshUI(Pokemon attacking, Pokemon opponent) {
		pokemonName.setText(attacking.getName() + "    Lvl: " + attacking.getLevel());
		lblPokemonHp.setText(attacking.getInBattleHp() + " / " + attacking.getCurrentStat(Stat.HP));
		pokemonHealthBar.setMaximum(attacking.getCurrentStat(Stat.HP));
		pokemonHealthBar.setValue(attacking.getInBattleHp());
        pokemonXpBar.setMaximum(attacking.getExpToNextLvl() - attacking.getSpecie().calculateExp(attacking.getLevel()));
        pokemonXpBar.setValue(attacking.getExp() - attacking.getSpecie().calculateExp(attacking.getLevel()));
		lblPokeSprite.setIcon(new ImageIcon(
				GameInterface.class.getResource("/Img/Pokemon/Back/" + attacking.getSpecie().name() + ".png")));

		enemyName.setText(opponent.getName() + "    Lvl: " + opponent.getLevel());
		enemyHealthBar.setMaximum(opponent.getCurrentStat(Stat.HP));
		enemyHealthBar.setValue(opponent.getInBattleHp());
		lblEnemySprite.setIcon(new ImageIcon(
				GameInterface.class.getResource("/Img/Pokemon/Front/" + opponent.getSpecie().name() + ".png")));
	}

	/**
	 * Create the Moves Button.
	 *
	 * @param indice The Indice to Match the Move if the Button
	 * @return
	 */
	public JButton CreateMoveButtons(int indice) {
		Move move = battleManager.getPokemon().getMoveSet()[indice];
		btnMove[indice] = new JButton(move.getName());
		if(!Move.NULL.equals(move)) {
			btnMove[indice].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ContainerFight.setVisible(false);
					ContainerMenu.setVisible(true);
					battleManager.UseMove(move);
					move.downPP();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					MoveDetails(move);
				}
			});
		}
		btnMove[indice].setFont(new Font("Tahoma", Font.BOLD, 16));
		if (indice < 2) {
			btnMove[indice].setBounds(50 + (226 * indice), 50, 216, 71);
		} else {
			btnMove[indice].setBounds(50 + (226 * (indice - 2)), 130, 216, 71);
		}
		return btnMove[indice];
	}

	/**
	 * Update the Moves Details.
	 *
	 * @param move The Move of the Pokemon
	 */
	public void MoveDetails(Move move) {
		lblPP.setText("PP: " + move.getCurrentPP() + "/" + move.getTotalPP());
		if (move.getPower() > 0) {
			lblPower.setText("Power: " + move.getPower());
		} else {
			lblPower.setText("Power: Buff");
		}
		lblAccuracy.setText("Accuracy:" + move.getAccuracy());
	}

	/**
	 * Create the menu to Choose a new Poke in your Party
	 *
	 * @param pokemon The Current Pokemon
	 */
	public void ChangePokemon() {
		boolean allDead = true;
		for (Pokemon poke : battleManager.getParty()) {
			if (!poke.isFainted()) {
				allDead = false;
			}
		}
		if (allDead) {
			GameManager.StopSound();
			GameManager.PlaySound(1);
			dispose();
		} else {
			lblChangePokemon.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/Pokemon/Icon/" + battleManager.getParty()[indice].getSpecie().getDexNumber() + ".png")));
		}
	}
}

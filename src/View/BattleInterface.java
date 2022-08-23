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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BattleInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private int indice;
	private boolean runAway = false;
	private final Player player;
	private final BattleManager battleManager;
	private final Container PokemonStats, EnemyStats;
	private final JPanel contentPane;
	private final JLabel lblPP, lblPower, lblAccuracy;
	private final JLabel lblChangePokemon;
	private JButton[] btnMove = new JButton[4];
	private final JLabel pokemonName = new JLabel(), enemyName = new JLabel();
	private final JLabel lblPokemonHp = new JLabel(), lblEnemyHp = new JLabel();
	private JLabel lblEnemySprite = new JLabel(), lblPokeSprite = new JLabel();
	private final JProgressBar pokemonHealthBar = new JProgressBar(), enemyHealthBar = new JProgressBar();
	public Container ContainerMenu = new Container(), ContainerFight = new Container(),
			ContainerPokemon = new Container();
	public JTextPane txtLog = new JTextPane();

	/**
	 * Create the frame.
	 *
	 * @param bm The Class Battle Manager
	 */
	public BattleInterface(BattleManager bm) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				indice = bm.Indice;
				if (battleManager.getOpponent() != null && battleManager.getPokemon() != null) {
					RefreshUI(battleManager.getPokemon(), battleManager.getOpponent());
					for (int i = 0; i < battleManager.getPokemon().getMoveSet().length; i++) {
						if (btnMove[i] == null) {
							ContainerFight.add(CreateMoveButtons(i));
						}
					}
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				if (battleManager.getOpponent().isFainted()) {
					int aux = battleManager.calcExp(battleManager.getOpponent());
					JOptionPane.showMessageDialog(null, battleManager.getPokemon().getName() + " gained " + aux + "!");
					battleManager.getPokemon().AddExp(aux);
				} else if (battleManager.getPokemon().isFainted()) {
					JOptionPane.showMessageDialog(null, "All your pokemon is Dead!");
				} else if (runAway) {
					JOptionPane.showMessageDialog(null, "Got away safely!");
				}
			}
		});

		battleManager = bm;
		player = bm.getPlayer();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		/**
		 * Create the Container Menu.
		 */
		PokemonStats = new Container();
		PokemonStats.setBounds(512, 284, 445, 135);
		contentPane.add(PokemonStats);

		EnemyStats = new Container();
		EnemyStats.setBounds(3, 2, 445, 135);
		contentPane.add(EnemyStats);

		lblPokeSprite = new JLabel("");
		lblPokeSprite.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPokeSprite.setBounds(55, 265, 160, 160);
		contentPane.add(lblPokeSprite);

		lblEnemySprite = new JLabel("");
		lblEnemySprite.setBounds(746, 49, 160, 160);
		contentPane.add(lblEnemySprite);

		/**
		 * Create the Container Fight.
		 */
		ContainerMenu.setEnabled(false);
		ContainerMenu.setBounds(0, 425, 960, 240);
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
			if (player.getParty().length < 6) {
				if (battleManager.getOpponent().calculateCatchRate(255)) {
					JOptionPane.showMessageDialog(null, "You Capture " + battleManager.getOpponent().getName());
					player.addToParty(battleManager.getOpponent());
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

		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener((ActionEvent e) -> {
			ContainerMenu.setVisible(false);
			ContainerFight.setVisible(true);
		});
		btnFight.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnFight.setBounds(502, 47, 216, 71);
		ContainerMenu.add(btnFight);

		JButton btnPokemon = new JButton("Pokemon");
		btnPokemon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (battleManager.getPlayer().getParty().length > 1) {
					ContainerMenu.setVisible(false);
					ContainerPokemon.setVisible(true);
					ChangePokemon();
				}
			}
		});
		btnPokemon.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnPokemon.setBounds(502, 129, 216, 71);
		ContainerMenu.add(btnPokemon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 20, 471, 199);
		ContainerMenu.add(scrollPane);
		scrollPane.setViewportView(txtLog);

		txtLog.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ContainerFight.setVisible(false);
		ContainerFight.setBounds(0, 425, 960, 240);
		contentPane.add(ContainerFight);
		ContainerFight.setLayout(null);

		JPanel panelMoveDetails = new JPanel();
		panelMoveDetails.setBackground(Color.WHITE);
		panelMoveDetails.setBounds(501, 21, 449, 198);
		ContainerFight.add(panelMoveDetails);
		panelMoveDetails.setLayout(null);

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
		ContainerPokemon.setVisible(false);
		ContainerPokemon.setBounds(0, 425, 960, 240);
		contentPane.add(ContainerPokemon);

		JButton btnChoose = new JButton("Choose");
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (player.getParty()[indice].getInBattleHp() <= 0) {
					JOptionPane.showMessageDialog(null,
							"Your Pokemon " + player.getParty()[indice].getName() + " is Dead!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Your Chosse " + player.getParty()[indice].getName() + "!");
					battleManager.setPokemon(player.getParty()[indice]);
					RefreshUI(battleManager.getPokemon(), battleManager.getOpponent());
					if (battleManager.getOpponent() != null && battleManager.getPokemon() != null) {
						RefreshUI(battleManager.getPokemon(), battleManager.getOpponent());
						for (int i = 0; i < 4; i++) {
							if (btnMove[i] != null) 
								ContainerFight.remove(btnMove[i]);
							if (battleManager.getPokemon().getMoveSet().length > i)
								ContainerFight.add(CreateMoveButtons(i));
						}
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
				if (indice == player.getParty().length - 1) {
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
					indice = player.getParty().length - 1;
				} else {
					indice--;
				}

				ChangePokemon();
			}
		});
		btnPrevius.setBounds(331, 202, 90, 23);
		ContainerPokemon.add(btnPrevius);

		lblChangePokemon = new JLabel("");
		lblChangePokemon.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/004.png")));
		lblChangePokemon.setBounds(361, 0, 238, 238);
		ContainerPokemon.add(lblChangePokemon);

		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBackground.setIcon(new ImageIcon(BattleInterface.class.getResource("/Img/battlegrass.png")));
		lblBackground.setBounds(0, 0, 960, 425);
		contentPane.add(lblBackground);
	}

	/**
	 * Create the UI Container.
	 *
	 * @param attacking The Pokemon of the Player
	 * @param opponent  The Random Pokemon finded in the Map
	 */
	public void CreateUI(Pokemon attacking, Pokemon opponent) {
		try {
			pokemonHealthBar.setForeground(Color.RED);
			pokemonHealthBar.setBounds(20, 60, 400, 25);
			PokemonStats.add(pokemonHealthBar);

			pokemonName.setVerticalAlignment(SwingConstants.TOP);
			pokemonName.setFont(new Font("Tahoma", Font.BOLD, 20));
			pokemonName.setBounds(20, 20, 400, 40);
			PokemonStats.add(pokemonName);

			lblPokemonHp.setHorizontalAlignment(SwingConstants.LEFT);
			lblPokemonHp.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblPokemonHp.setBounds(10, 160, 178, 32);
			PokemonStats.add(lblPokemonHp);

			enemyHealthBar.setForeground(Color.RED);
			enemyHealthBar.setBounds(20, 60, 400, 25);
			EnemyStats.add(enemyHealthBar);

			enemyName.setFont(new Font("Tahoma", Font.BOLD, 20));
			enemyName.setVerticalAlignment(SwingConstants.TOP);
			enemyName.setBounds(20, 20, 400, 40);
			EnemyStats.add(enemyName);

			lblEnemyHp.setHorizontalAlignment(SwingConstants.LEFT);
			lblEnemyHp.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblEnemyHp.setBounds(10, 160, 178, 32);
			EnemyStats.add(lblEnemyHp);
		} catch (Exception e) {
		}
	}

	/**
	 * Update the Container.
	 *
	 * @param attacking The Pokemon who Makes the Move
	 * @param opponent  The Target of the Pokemon
	 */
	public void RefreshUI(Pokemon attacking, Pokemon opponent) {
		pokemonHealthBar.setMaximum(attacking.getCurrentStat(Stat.HP));
		pokemonHealthBar.setValue(attacking.getInBattleHp());
		pokemonName.setText(attacking.getName() + "    Lvl: " + attacking.getLevel());
		lblPokemonHp.setText(attacking.getInBattleHp() + "/" + attacking.getCurrentStat(Stat.HP));
		lblPokeSprite.setIcon(new ImageIcon(
				GameInterface.class.getResource("/Img/Back/" + attacking.getSpecie().name() + ".png")));

		enemyHealthBar.setMaximum(opponent.getCurrentStat(Stat.HP));
		enemyHealthBar.setValue(opponent.getInBattleHp());
		enemyName.setText(opponent.getName() + "    Lvl: " + opponent.getLevel());
		lblEnemyHp.setText(opponent.getInBattleHp() + "/" + opponent.getCurrentStat(Stat.HP));
		lblEnemySprite.setIcon(new ImageIcon(
				GameInterface.class.getResource("/Img/Front/" + opponent.getSpecie().name() + ".png")));
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
		btnMove[indice].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					battleManager.UseMove(move);
					move.downPP();
					ContainerFight.setVisible(false);
					if (!battleManager.getPokemon().isFainted()) {
						ContainerMenu.setVisible(true);
					}
				} catch (InterruptedException ex) {
					Logger.getLogger(BattleInterface.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				MoveDetails(move);
			}
		});
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
		for (Pokemon poke : battleManager.getPlayer().getParty()) {
			if (!poke.isFainted()) {
				allDead = false;
			}
		}
		if (allDead) {
			GameManager.StopSound();
			GameManager.PlaySound(1);
			dispose();
		} else {
			lblChangePokemon.setIcon(new ImageIcon(GameInterface.class.getResource("/Img/" + player.getParty()[indice].getSpecie().getDexNumber() + ".png")));
		}
	}
}

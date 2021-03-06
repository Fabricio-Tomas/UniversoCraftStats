package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JRadioButton;

import main.App;
import ui.layout.SelectLayout;

public class GameSelect extends JComponent {
	public static final long serialVersionUID = App.serialVersion;

	private JRadioButton[] games = new JRadioButton[17];
	private String gameSelected;

	private ButtonGroup btnGroup;

	public GameSelect() {

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(20, 30, 50, 150), 2, true),
				"Selección de juego"));

		setLayout(new SelectLayout());

		btnGroup = new ButtonGroup();

		games[0] = new JRadioButton("TheBridge");
		games[0].setSelected(true);
		gameSelected = games[0].getActionCommand();
		games[1] = new JRadioButton("Destruye el Nexus");
		games[2] = new JRadioButton("SkyWars");
		games[3] = new JRadioButton("LuckyWars");
		games[4] = new JRadioButton("EggWars");
		games[5] = new JRadioButton("BedWars");
		games[6] = new JRadioButton("TeamSkywars");
		games[7] = new JRadioButton("SpeedBuilders");
		games[8] = new JRadioButton("BuildBattle");
		games[9] = new JRadioButton("Escapa de la bestia");
		games[10] = new JRadioButton("Party games");
		games[11] = new JRadioButton("Juegos del hambre");
		games[12] = new JRadioButton("Skypit");
		games[13] = new JRadioButton("ArenaPvP");
		games[14] = new JRadioButton("UHC");
		games[15] = new JRadioButton("MurderMystery");
		games[16] = new JRadioButton("Captura la lana");

		for (int i = 0; i < games.length; i++) {

			final int I = i;
			games[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameSelected = games[I].getActionCommand();
				}
			});
			btnGroup.add(games[i]);
			games[i].setBackground(App.background);
			add(games[i]);

		}

	}

	public String getSelection() {

		return gameSelected.toUpperCase();

	}

}

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import main.App;
import ui.layout.SelectLayout;

public class GameSelect extends JComponent {
	public static final long serialVersionUID = App.serialVersion;

	private JRadioButton[] games = new JRadioButton[16];
	private String gameSelected;

	private ButtonGroup btnGroup;

	public GameSelect() {

		setBorder(new TitledBorder("Selección del juego"));

		setLayout(new SelectLayout());

		btnGroup = new ButtonGroup();

		games[0] = new JRadioButton("Bedwars");
		games[1] = new JRadioButton("UHC");
		games[2] = new JRadioButton("Party games");
		games[3] = new JRadioButton("ausdgasiudgas");
		games[4] = new JRadioButton("ausdgasiudgas");
		games[5] = new JRadioButton("ausdgasiudgas");
		games[6] = new JRadioButton("ausdgasiudgas");
		games[7] = new JRadioButton("ausdgasiudgas");
		games[8] = new JRadioButton("ausdgasiudgas");
		games[9] = new JRadioButton("ausdgasiudgas");
		games[10] = new JRadioButton("ausdgasiudgas");
		games[11] = new JRadioButton("ausdgasiudgas");
		games[12] = new JRadioButton("ausdgasiudgas");
		games[13] = new JRadioButton("ausdgasiudgas");
		games[14] = new JRadioButton("ausdgasiudgas");
		games[15] = new JRadioButton("ausdgasiudgas");

		for (int i = 0; i < games.length; i++) {

			final int I = i;
			games[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					gameSelected = games[I].getActionCommand();
				}
			});
			btnGroup.add(games[i]);
			add(games[i]);

		}

	}

	public String getSelection() {

		return gameSelected;

	}

}

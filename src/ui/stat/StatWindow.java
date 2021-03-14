package ui.stat;

import java.util.LinkedList;

import javax.swing.JDialog;

import main.App;

public class StatWindow extends JDialog {
	public static final long serialVersionUID = App.serialVersion;

	public StatWindow(String player, String game, LinkedList<String[]> data) {

		setTitle("Stats - " + player);
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(App.app().getSelectWindow());

		StatsComponent stats = new StatsComponent(game, data);
		add(stats);

	}

}

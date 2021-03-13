package ui.stat;

import java.util.LinkedList;

import javax.swing.JDialog;

import main.App;

public class StatWindow extends JDialog {
	public static final long serialVersionUID = App.serialVersion;

	public StatWindow(LinkedList<String[]> data) {

		setTitle("Stats");
		setSize(400, 500);
		setLocationRelativeTo(App.app().getSelectWindow());

//		JPanel panel = new JPanel();
//		add(panel);

		StatsComponent stats = new StatsComponent(data);
//		panel.add(stats);
		add(stats);

	}

}

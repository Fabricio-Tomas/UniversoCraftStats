package ui.stat;

import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;

import main.App;
import ui.layout.StatLayout;

public class StatsComponent extends JComponent {
	public static final long serialVersionUID = App.serialVersion;

	public StatsComponent(String game, LinkedList<String[]> data) {

		setLayout(new StatLayout());

		JLabel gameLabel = new JLabel(game, JLabel.CENTER);
		add(gameLabel);

		while (!data.isEmpty()) {

			String[] stats = data.poll();

			if (stats.length == 1) {

				JLabel error = new JLabel(stats[0], JLabel.CENTER);
				add(error);

				break;

			}

			StatLabel stat = new StatLabel(stats[0], stats[1]);
			add(stat);

		}

	}

}

package ui.stat;

import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JLabel;

import main.App;
import ui.layout.SelectLayout;

public class StatsComponent extends JComponent {
	public static final long serialVersionUID = App.serialVersion;

	public StatsComponent(LinkedList<String[]> data) {

		setLayout(new SelectLayout());

		while (!data.isEmpty()) {

			String[] stats = data.poll();

			JLabel title = new JLabel(stats[0], JLabel.LEFT);
			JLabel count = new JLabel(stats[1], JLabel.RIGHT);

			add(title);
			add(count);

		}

	}

}

package ui.stat;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import main.App;
import ui.layout.LayoutAdapter;

public class StatLabel extends JComponent {
	public static final long serialVersionUID = App.serialVersion;

	JLabel left, right;

	public StatLabel(String txt1, String txt2) {

		setLayout(new LayoutAdapter() {
			@Override
			public void layoutContainer(Container c) {
				c.getComponent(0).setBounds(0, 0, c.getWidth(), c.getHeight());
				c.getComponent(1).setBounds(0, 0, c.getWidth(), c.getHeight());
			}
		});

		left = new JLabel("    " + txt1, JLabel.LEFT);
		right = new JLabel(txt2 + "    ", JLabel.RIGHT);

		add(left);
		add(right);

		setBorder(BorderFactory.createLineBorder(new Color(100, 200, 250), 2, true));

	}

}

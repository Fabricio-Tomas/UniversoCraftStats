package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.App;
import ui.layout.SelectWindowLayout;

public class SelectWindow extends JFrame {
	public static final long serialVersionUID = App.serialVersion;

	public SelectWindow() {

		setTitle("Estadisticas UniversoCraft");
		setSize(450, 580);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new SelectWindowLayout());
		panel.setBackground(App.background);
		add(panel);

		// Creación y añadido de elementos a la ventana
		TextField playerName = new TextField("Name tag");
		JButton submit = new JButton("Buscar");
		GameSelect gameSelect = new GameSelect();

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (playerName.getText().isEmpty()) {
					return;
				}

				App.app().getStats(playerName.getText(), gameSelect.getSelection());

			}
		});

		panel.add(playerName);
		panel.add(submit);
		panel.add(gameSelect);

	}

}

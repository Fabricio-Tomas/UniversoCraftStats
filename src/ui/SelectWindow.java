package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.App;
import ui.layout.SelectWindowLayout;

public class SelectWindow extends JFrame {
	public static final long serialVersionUID = App.serialVersion;

	public SelectWindow() {

		setTitle("Estadisticas UniversoCrafters");
		setSize(450, 580);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new SelectWindowLayout());
		panel.setBackground(new Color(220, 220, 220));
		add(panel);

		// Creación y añadido de elementos a la ventana
		JTextField playerName = new JTextField();
		JButton submit = new JButton("Seleccionar");
		GameSelect gameSelect = new GameSelect();

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (playerName.getText().isEmpty()) {
					System.out.println("Escriba el nombre del usuario");
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

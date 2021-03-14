package ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import main.App;

public class TextField extends JTextField {
	public static final long serialVersionUID = App.serialVersion;

//	private Color normalColor = new Color(0, 0, 0, 0);
//	private Color focusColor = new Color(100, 100, 255, 50);
//	private Color mainColor = normalColor;

	private JLabel placeHolder;

	public TextField(String placeHolderText) {

		placeHolder = new JLabel(placeHolderText, JLabel.LEFT);
		placeHolder.setBounds(5, 0, 100, 50);
		placeHolder.setForeground(new Color(0, 0, 0, 100));
		add(placeHolder);

		Border normalBorder = BorderFactory.createLineBorder(new Color(20, 30, 50, 150), 3, true);
		Border focusBorder = BorderFactory.createLineBorder(new Color(100, 150, 250, 150), 3, true);
		setBorder(normalBorder);

		addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				setBorder(focusBorder);

			}

			@Override
			public void focusLost(FocusEvent e) {

				setBorder(normalBorder);

			}
		});
		addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				if (e.getMark() == 0 && getText().length() == 0)
					placeHolder.setVisible(true);
				else
					placeHolder.setVisible(false);

			}
		});

	}

}

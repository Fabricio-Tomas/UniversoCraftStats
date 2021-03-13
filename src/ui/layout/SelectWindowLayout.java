package ui.layout;

import java.awt.Container;

/*
 * Layout para la ventana de selección del jugador
 */
public class SelectWindowLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container c) {

		int H = c.getHeight();
		int W = c.getWidth();
		int gap = (int) (H * 0.05);// espacios vacíos

		int h2 = (int) (H * 0.6);// altura del seleccionador
		int h = (int) (H * 0.1);// altura del resto de elementos
		int w = (int) (W * 0.8);

		int x = W / 2 - w / 2;
		// TextField
		int y = gap;
		c.getComponent(0).setBounds(x, y, w, h);

		// Button
		y = H - gap - h;
		c.getComponent(1).setBounds(x, y, w, h);

		// GameSelect
		y = gap * 2 + h;
		c.getComponent(2).setBounds(x, y, w, h2);

	}

}

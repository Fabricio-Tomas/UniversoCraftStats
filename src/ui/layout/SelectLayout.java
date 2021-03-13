package ui.layout;

import java.awt.Container;

/*
 * Layout para GameSelect
 */
public class SelectLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container c) {

		int n = c.getComponentCount();

		int H = c.getHeight();
		int W = c.getWidth();

		int gap = (int) (W * 0.05);

		int w = (W - gap * 2) / 2;
		int h = (H - gap * 2) / (n / 2);

		int x = gap;
		int y = gap;

		for (int i = 0; i < n; i++) {

			c.getComponent(i).setBounds(x, y, w, h);

			if (i % 2 == 0) {
				x += w;
			} else {
				x = gap;
				y += h;
			}

		}

	}

}

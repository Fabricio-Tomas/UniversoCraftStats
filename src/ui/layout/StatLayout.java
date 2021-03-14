package ui.layout;

import java.awt.Container;

public class StatLayout extends LayoutAdapter {

	@Override
	public void layoutContainer(Container c) {

		int n = c.getComponentCount() - 1;

		int H = c.getHeight();
		int W = c.getWidth();

		if (n == 1) {
			c.getComponent(0).setBounds(0, 0, W, (int) (H * 0.2));
			c.getComponent(1).setBounds(0, (int) (H * 0.1), W, (int) (H * 0.8));
			return;
		}

		int H2 = H / n;
		int h = (int) (H2 * 0.9);
		int w = (int) (W * 0.9);

		int x = W / 2 - w / 2;
		int y = H2 / 2 - h / 2;

		c.getComponent(0).setBounds(x, y, w, h);
		for (int i = 1; i <= n; i++) {

			y += H2;
			c.getComponent(i).setBounds(x, y, w, h);

		}

	}

}

package main;

import java.awt.Color;

import ui.SelectWindow;
import ui.stat.StatWindow;

public class App {

	public static final long serialVersion = 1l;
	private static App app;

	public static final Color background = new Color(225, 225, 225);

	private Connection connection;

	private SelectWindow window;

	public static void main(String[] args) {

		app = new App();

	}

	public App() {

		window = new SelectWindow();

		window.setDefaultCloseOperation(SelectWindow.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public void getStats(String player, String game) {

		connect(player);

		StatWindow statWindow = new StatWindow(player, game, connection.getGameData(game));
		statWindow.setDefaultCloseOperation(StatWindow.DISPOSE_ON_CLOSE);
		statWindow.setAlwaysOnTop(true);
		statWindow.setVisible(true);

	}

	private void connect(String url) {

		connection = new Connection(url);

	}

	public static App app() {
		return app;
	}

	public SelectWindow getSelectWindow() {
		return window;
	}

}

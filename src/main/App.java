package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ui.SelectWindow;
import ui.stat.StatWindow;

public class App {

	public static final long serialVersion = 1l;
	private static App app;

	private String url = "https://stats.universocraft.com/stats.php?player=";

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

		connect(url + player);

		StatWindow statWindow = new StatWindow(connection.getGameData(game));
		statWindow.setDefaultCloseOperation(StatWindow.DISPOSE_ON_CLOSE);
		statWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				window.setVisible(true);
			}
		});
		statWindow.setVisible(true);

		window.setVisible(false);

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

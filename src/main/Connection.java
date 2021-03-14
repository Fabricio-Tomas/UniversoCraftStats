package main;

import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Connection {

	private String url;
	private String player;

	public Connection(String player) {

		url = "https://stats.universocraft.com/stats.php?player=" + player;
		if (getConnectionStatusCode(url) == 200)
			this.player = player;

	}

	public LinkedList<String[]> getGameData(String game) {

		LinkedList<String[]> data = new LinkedList<String[]>();

		if (url == null)
			return data;

		Document doc = getHtmlDocument();

		Elements games = doc.select("div.game");

		for (Element element : games) {

			String header = element.getElementsByClass("game-header").text();

			if (!header.equalsIgnoreCase(game))
				continue;

			Elements stats = element.getElementsByClass("game-content").get(0).getElementsByClass("game-stat");

			for (Element stat : stats) {

				String[] miniData = new String[2];
				miniData[0] = stat.getElementsByClass("game-stat-title").text();
				miniData[1] = stat.getElementsByClass("game-stat-count").text();

				data.add(miniData);

			}

			return data;// Toda la información ha sido recopilada exitosamente

		}

		data.add(new String[] { player + " NO ESTÁ REGISTRADO O NO TIENE ESTADISTICAS EN '" + game + "'" });
		return data;// No se encontró el modo de juego

	}

	/*
	 * Comprueba el Status code de la respuesta que recibo al hacer la petición
	 * 
	 * 200 OK
	 * 
	 * 300 Multiple Choices
	 * 
	 * 301 Moved Permanently
	 * 
	 * 305 Use Proxy
	 * 
	 * 400 Bad Request
	 * 
	 * 403 Forbidden
	 * 
	 * 404 Not Found
	 * 
	 * 500 Internal Server Error
	 * 
	 * 502 Bad Gateway
	 * 
	 * 503 Service Unavailable
	 * 
	 * 0 Other
	 * 
	 * @param url
	 * 
	 * @return Status Code
	 */
	private int getConnectionStatusCode(String url) {

		Response response = null;

		try {

			response = Jsoup.connect(url).userAgent(HttpConnection.DEFAULT_UA).timeout(100000).ignoreHttpErrors(true)
					.execute();

		} catch (IOException e) {

			e.printStackTrace();

			return 0;

		}

		return response.statusCode();

	}

	private Document getHtmlDocument() {

		Document doc = null;

		try {

			doc = Jsoup.connect(url).userAgent(HttpConnection.DEFAULT_UA).timeout(100000).get();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return doc;

	}

}

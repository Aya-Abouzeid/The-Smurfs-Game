package snapshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import controller.gameOptions;
import player.Player;
import save.save2;
import shape.Shape;

public class Memento {
	private ArrayList<Shape> shapes;
	private int minutes;
	private int seconds;
	private int counter;
	private gameOptions options;
	private LinkedList<Player> players;
	save2 save = new save2();

	public Memento(ArrayList<Shape> shapes, gameOptions options, 
			LinkedList<Player> players, int minutes, int seconds, int counter) {
		// save.save(shapes);
		this.shapes = shapes;
		this.options = options;
		this.players = players;
		this.counter = counter;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	// public Shape[] getSavedshapes() throws IOException {
	// return (Shape[]) save.load();
	// }

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getCounter() {
		return counter;
	}

	public gameOptions getOptions() {
		return options;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}
}

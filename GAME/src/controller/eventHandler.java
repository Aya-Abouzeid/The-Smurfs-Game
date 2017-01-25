package controller;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.input.KeyCode;
import layouts.ExitConfrmationWindow;
import layouts.*;
import layouts.View;
import player.BuildPlayer;
import player.Player;
import player.PlayerProxy;
import save.getarray;
import shape.BuildShape;
import shape.Shape;
import shape.ShapeProxy;
import snapshot.Memento;
import states.PlayerStack;

public class eventHandler {

	private static eventHandler handler;
	private gameController controller;
	private View view;
	private gameOptions gameOptions;
	private Memento snapshot;
	private musicPlayer music;
	private save save1=new save();
    private getarray u=new getarray();

	private eventHandler() {
		gameOptions = new gameOptions();
	}

	public static eventHandler getInstance() {
		if (handler == null)
			handler = new eventHandler();
		return handler;
	}

	public void viewIsReady() throws InterruptedException {
		music = new musicPlayer();
		music.startMusic();
	}

	public void NewGame() {
		Game gameScene = new Game(view.getHeight(), view.getWidth());
		view.setScene(gameScene.getScene());
		controller = new gameController(gameScene, gameOptions);
		Thread game = new Thread(controller, "game begin");
		game.start();
	}

	private void EscapeFromGame() {
		System.out.println("pause");
		view.setScene("pause");
		snapshot = controller.pause();
	}

	public void continueGame() {
		Game gameScene = new Game(view.getHeight(), view.getWidth());
		view.setScene(gameScene.getScene());
		controller = new gameController(gameScene, snapshot);
		Thread game = new Thread(controller, "game begin");
		game.start();
	}

	public void MainMenu() {
		view.setScene("MainMenu");
	}

	public void EndProgram() {
		view.exit();
	}

	public void ExitConfirmation() {
		System.out.println("exit confirmation");
		ExitConfrmationWindow.display();
	}

	public void Instructions() {
		view.setScene("Instructions");
	}

	public void mainOptions() {
		view.setScene("MainOptions");
	}

	public void EndGame(String winnerName) {
		System.out.println("end game winner " + winnerName);
		EndGame scene = new EndGame(view.getHeight(), view.getWidth());
		scene.setWinner(winnerName);
		view.setScene(scene.getScene());
	}

	public void gameOptions() {
		view.setScene("GameOptions");
	}

	public void GameOptionsReturn() {
		view.setScene("pause");
	}

	public void setView(View view) {
		this.view = view;
	}

	public void notifyMouseMoved(double x) {
		controller.notifyMouseMoved(x);
	}

	public void notifyKeyPressed(KeyCode key) {
		if (key == KeyCode.ESCAPE) {
			EscapeFromGame();
		} else {
			controller.notifyKeyPressed(key);
		}
	}

	public void musicButtonPressed() {
		if (music.isPlaying()) {
			music.stopMusic();
		} else {
			music.startMusic();
		}
	}

	public void saveGame() {
		save1.save(this.snapshot);
	}

	public void loadGame() {
		Memento snapshot = null;
		BuildShape v = new BuildShape();
		BuildPlayer v1 = new BuildPlayer();

		ShapeProxy[][] k = (ShapeProxy[][]) save1.load1();
		Shape[][] n = new Shape[5][1];
		for (int i = 0; i < 5; i++) {
			n[i] = v.create(k[i]);
		}
		PlayerProxy[] u = (PlayerProxy[]) save1.load2();
		int[] j = (int[]) save1.load3();
		Player[] n2 = new Player[2];
		for (int i = 0; i < 2; i++) {
			n2[i] = v1.create(u[i]);
		}
		System.out.println(n2[0].getX());
		System.out.println(n[0][0].getState());
		// System.out.println(n[0][0].getX());
		System.out.println(k[0][0].getState());
		Player p1 = n2[0];
		Player p2 = n2[1];
		PlayerStack p31 = new PlayerStack(j[3], p1);
		PlayerStack p32 = new PlayerStack(j[4], p1);
		PlayerStack p41 = new PlayerStack(j[5], p2);
		PlayerStack p42 = new PlayerStack(j[6], p2);
		LinkedList<PlayerStack> p33 = new LinkedList<>();
		LinkedList<PlayerStack> p44 = new LinkedList<>();
		p33.add(p31);
		p33.add(p32);
		p44.add(p41);
		p44.add(p42);
		/////////
		p31.PH.createObserverList(n[1]);
		p32.PH.createObserverList(n[2]);
		p41.PH.createObserverList(n[3]);
		p42.PH.createObserverList(n[4]);
		//////////
		p31.stack = this.u.getShapeStack(n[1]);
		p32.stack = this.u.getShapeStack(n[2]);
		p41.stack = this.u.getShapeStack(n[3]);
		p42.stack = this.u.getShapeStack(n[4]);
		LinkedList<Player> players = this.u.getPlayerList(n2);
		players.get(0).Stacks = p33;
		players.get(1).Stacks = p44;
		ArrayList<Shape> shapes = this.u.getShapeList(n[0]);
		snapshot = new Memento(shapes, gameOptions, players, j[1], j[2], j[0]);

		Game gameScene = new Game(view.getHeight(), view.getWidth());
		view.setScene(gameScene.getScene());
		controller = new gameController(gameScene, snapshot);
		Thread game = new Thread(controller, "game begin");
		game.start();
	}

}

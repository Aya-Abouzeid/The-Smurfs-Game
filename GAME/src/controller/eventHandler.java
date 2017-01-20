package controller;

import javafx.scene.input.KeyCode;
import layouts.ExitConfrmationWindow;
import layouts.Game;
import layouts.View;
import snapshot.Memento;

public class eventHandler {

	private static eventHandler handler;
	private gameController controller;
	private View view;
	private gameOptions gameOptions;
	private Memento snapshot;

	private eventHandler() {
		gameOptions = new gameOptions();
	}

	public static eventHandler getInstance() {
		if (handler == null) {
			handler = new eventHandler();
		}
		return handler;
	}

	public void NewGame() {
		Game gameScene = new Game(view.getHeight(), view.getWidth());
		view.setScene(gameScene.getScene());
		controller = new gameController(gameScene, gameOptions);
		Thread game = new Thread(controller,"game begin");
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
		Thread game = new Thread(controller,"game begin");
		game.start();
	}

	public void MainMenu() {
		view.setScene("MainMenu");
	}

	public void EndProgram() {
		//save last screenshot
		view.exit();
	}
	
	public void ExitConfirmation() {
		System.out.println("exit confirmation");
		ExitConfrmationWindow.display();
	}
	

	public void Instructions() {
		view.setScene("Instructions");
	}

	public void loadGame() {
		////// get load game
	}

	public void mainOptions() {
		view.setScene("MainOptions");
	}
	
	public void EndGame() {
		view.setScene("EndGame");
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
	
	// it is called only from game layout 	
	public void notifyMouseMoved(double x) {
		controller.notifyMouseMoved(x);
	}
	
	// it is called only from game layout 
	public void notifyKeyPressed(KeyCode key) {
		if (key == KeyCode.ESCAPE){
			EscapeFromGame();	
		} else {
			controller.notifyKeyPressed(key);
		}
	}
	
	

}

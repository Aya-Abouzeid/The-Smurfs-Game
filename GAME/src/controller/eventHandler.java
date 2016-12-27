package controller;

import layouts.ExitConfrmationWindow;
import layouts.Game;
import layouts.View;

public class eventHandler {

	private static eventHandler handler;
	private gameController controller;
	private View view;

	private eventHandler() {
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
		controller = new gameController(gameScene);
		Thread game = new Thread(controller,"game begin");
		game.start();
	}

	public void EscapeFromGame() {
		System.out.println("pause");
		view.setScene("pause");
		
	}

	public void continueGame() {
		//// getsnapshot
		view.setScene("Game");
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
	
	

}

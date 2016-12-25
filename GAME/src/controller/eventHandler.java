package controller;

import javafx.application.Application;
import layouts.ExitConfrmationWindow;
import layouts.View;

public class eventHandler {

	private static eventHandler handler;
	private View view;
	private String[] args;

	private eventHandler() {

	}

	public static eventHandler getInstance() {
		if (handler == null) {
			handler = new eventHandler();
		}
		return handler;
	}

	public void NewGame() {
		view.setScene("Game");
	}

	public void EscapeFromGame() {
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
	
	public void setArgs(String[] args) {
		this.args = args;
	}

}

package controller;

import java.util.LinkedList;

import javafx.scene.input.KeyCode;

public class gameOptions {

	private LinkedList<String> characters;
	private LinkedList<Boolean> mouseControl;
	private LinkedList<KeyCode> rightButton;
	private LinkedList<KeyCode> leftButton;
	private LinkedList<Double> startPositionX;
	private static final int Players = 2;
	private double shapeSpeed;

	public gameOptions() {
		shapeSpeed = 4.0;
		characters = new LinkedList<String>();
		mouseControl = new LinkedList<Boolean>();
		rightButton = new LinkedList<KeyCode>();
		leftButton = new LinkedList<KeyCode>();
		startPositionX = new LinkedList<Double>();
		setDefaultOptions();
	}

	public int getNPlayers() {
		return Players;
	}

	private void setDefaultOptions() {
		// player1
		characters.add("smurff");
		mouseControl.add(true);
		rightButton.add(null);
		leftButton.add(null);
		startPositionX.add(0.0);

		// player2
		characters.add("smurfette");
		mouseControl.add(false);
		rightButton.add(KeyCode.RIGHT);
		leftButton.add(KeyCode.LEFT);
		startPositionX.add(1000.0);
	}

	public String getCharacter(int playerIndex) {
		return characters.get(playerIndex);
	}

	public boolean getMouseControl(int playerIndex) {
		return mouseControl.get(playerIndex);
	}

	public KeyCode getLeftButton(int playerIndex) {
		return leftButton.get(playerIndex);
	}

	public KeyCode getrightButton(int playerIndex) {
		return rightButton.get(playerIndex);
	}

	public Double getPositionX(int playerIndex) {
		return startPositionX.get(playerIndex);
	}


	public void setGameSpeed(double x) {
		shapeSpeed = x;
	}

	public double getGameSpeed() {
		return shapeSpeed;
	}
}

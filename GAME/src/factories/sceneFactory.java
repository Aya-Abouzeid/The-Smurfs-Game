package factories;

import button.exitButton;
import button.instructionsButton;
import button.loadGameButton;
import button.mainOptionsButton;
import button.newGameButton;
import javafx.scene.Scene;
import layouts.*;

public class sceneFactory {

	private static sceneFactory sceneFactory;

	private sceneFactory() {

	}

	public static sceneFactory getSceneFactory() {
		if (sceneFactory == null) {
			return sceneFactory = new sceneFactory();
		}

		return sceneFactory;
	}

	public Scene getScene(String name) {

		switch (name) {
		case "Game":
			return new Game().getScene();
		case "MainMenu":
			return new Start().getScene();
		case "pause":
			return new Pause().getScene();
		case "MainOptions":
			return new mainOptions().getScene();
		case "GameOptions":
			return new gameOptions().getScene();
		case "Instructions":
			return new Instructions().getScene();
		case "EndGame":
			return new EndGame().getScene();
		default:
			return null;
		}

	}
}

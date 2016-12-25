package button;

import button.*;

public class buttonFactory {

	private static buttonFactory btnFactory;

	private buttonFactory() {

	}

	public static buttonFactory getButtonFactory() {

		if (btnFactory == null) {
			return btnFactory = new buttonFactory();
		}

		return btnFactory;
	}

	public button getButton(String type) {
	
		switch (type) {
		case "New Game":
			return 	new newGameButton();		
		case "Load Game":
			return 	new loadGameButton();					
		case "Instructions":
			return 	new instructionsButton();		
		case "Exit":
			return 	new exitButton();		
		case "Main Options":
			return new mainOptionsButton();
		case "Continue Game":
			return new ContinueGameButton();
		case "Main Menu":
			return new MainMenuButton();
		case "Game Options Return":
			return new ReturnToPause();
		case "Game Options":
			return new GameOptionsButton();
		default:
			return null;
		}
	}

	
}

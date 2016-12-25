package layouts;


import factories.buttonFactory;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class Game implements layout{
	
	private Scene scene;
	private buttonFactory factory;
	
	public Game() {
		System.out.println("playing");
		StackPane root = new StackPane();
		
		//////add sound button
		scene = new Scene(root,windowWidth, windowHeight);
		setKeyPress();
		
	}
	
	private void setKeyPress() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				System.out.println("escape");
				if (event.getCode() == KeyCode.ESCAPE){
					handler.EscapeFromGame();	
				}
			}
			
		});
	}	

	

	@Override
	public Scene getScene() {
		return scene;
	}

}

package layouts;

import factories.buttonFactory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Pause implements layout{

	private Scene scene;
	private buttonFactory factory;
	
	public Pause() {
		factory = buttonFactory.getButtonFactory();
		VBox vbox = new VBox(30);
		
		vbox.getChildren().add(factory.getButton("Continue Game").getButton());
		vbox.getChildren().add(factory.getButton("Main Menu").getButton());
		vbox.getChildren().add(factory.getButton("Game Options").getButton());
		
		 
		 vbox.setAlignment(Pos.CENTER);
		
		scene = new Scene(vbox,windowWidth, windowHeight);
	}
	
	
	
	
	@Override
	public Scene getScene() {
		
		return scene;
	}

}

package layouts;

import factories.buttonFactory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class gameOptions implements layout{

	private Scene scene;
	private buttonFactory factory;
	
	public gameOptions() {
		factory = buttonFactory.getButtonFactory();
		VBox root = new VBox();
		
		root.getChildren().add(factory.getButton("Game Options Return").getButton());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root,windowWidth, windowHeight);
	}
	
	
	
	
	@Override
	public Scene getScene() {
		
		return scene;
	}
	
}

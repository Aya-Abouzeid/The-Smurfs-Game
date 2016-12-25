package layouts;

import factories.buttonFactory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class mainOptions implements layout{
	private Scene scene;
	private buttonFactory factory;
	
	public mainOptions() {
		factory = buttonFactory.getButtonFactory();
		VBox root = new VBox();
		
		root.getChildren().add(factory.getButton("Main Menu").getButton());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root,windowWidth, windowHeight);
	}
	
	
	
	
	@Override
	public Scene getScene() {
		
		return scene;
	}
}

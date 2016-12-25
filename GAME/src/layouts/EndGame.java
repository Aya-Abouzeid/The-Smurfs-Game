package layouts;

import factories.buttonFactory;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class EndGame implements layout{

	private Scene scene;
	private buttonFactory factory;

	public EndGame() {
		factory = buttonFactory.getButtonFactory();
		StackPane root = new StackPane();
		Node b = factory.getButton("Main Menu").getButton();
		root.getChildren().add(b);
		StackPane.setAlignment(b, Pos.BOTTOM_CENTER);
		scene = new Scene(root,windowWidth, windowHeight);
	}

	@Override
	public Scene getScene() {
		return scene;
	}
	
}

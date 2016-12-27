package layouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Instructions extends layout {

	public Instructions(double height, double width) {
		super(height, width);
		
		VBox root = new VBox();
		root.getChildren().add(factory.getButton("Main Menu").getButton());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root,windowWidth, windowHeight);
	}

}

package layouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class gameOptions extends layout{

	
	public gameOptions(double height, double width) {
		super(height, width);
		VBox root = new VBox();
		
		root.getChildren().add(factory.getButton("Game Options Return").getButton());
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root,windowWidth, windowHeight);
	}
}

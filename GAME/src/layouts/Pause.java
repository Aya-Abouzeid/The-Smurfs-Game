package layouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Pause extends layout{

	
	public Pause(double height, double width) {
		super(height, width);
		VBox vbox = new VBox(30);
		
		vbox.getChildren().add(factory.getButton("Continue Game").getButton());
		vbox.getChildren().add(factory.getButton("Main Menu").getButton());
		vbox.getChildren().add(factory.getButton("Game Options").getButton());
		
		 
		 vbox.setAlignment(Pos.CENTER);
		
		scene = new Scene(vbox,windowWidth, windowHeight);
	}
}

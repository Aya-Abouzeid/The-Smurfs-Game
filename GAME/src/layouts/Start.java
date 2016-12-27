package layouts;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Start extends layout{

	
	public Start(double height, double width) {
		super(height, width);
		VBox vbox = new VBox(30);

		vbox.getChildren().add(factory.getButton("New Game").getButton());
		vbox.getChildren().add(factory.getButton("Load Game").getButton());
		vbox.getChildren().add(factory.getButton("Main Options").getButton());
		vbox.getChildren().add(factory.getButton("Instructions").getButton());
		vbox.getChildren().add(factory.getButton("Exit").getButton());
		
		vbox.setAlignment(Pos.CENTER);
		scene = new Scene(vbox,windowWidth, windowHeight);
		
	}
	
}

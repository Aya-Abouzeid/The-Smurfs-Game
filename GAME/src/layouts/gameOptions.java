package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class gameOptions extends layout{

	Group root;
	
	public gameOptions(double height, double width) {
		super(height, width);
		VBox vbox = new VBox();
		
		vbox.getChildren().add(factory.getButton("Game Options Return").getButton());
		vbox.setAlignment(Pos.CENTER);
		root.getChildren().add(vbox);
		
		setMusicButton();
		
		scene = new Scene(root,windowWidth, windowHeight);
	}
	private void setMusicButton() {
    	Button music = factory.getButton("music").getButton();
    	music.setAlignment(Pos.TOP_LEFT);
		StackPane stackPane = new StackPane(music);
		stackPane.setPadding(new Insets(30, 0, 0, 50));
		root.getChildren().add(stackPane);
	}
	
}

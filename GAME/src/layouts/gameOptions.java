package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logs.Logs;

public class gameOptions extends layout {

	Group root = new Group();

	public gameOptions(double height, double width) {
		super(height, width);
		addBackground();
		StackPane vbox = new StackPane();
		vbox.getChildren().add(factory.getButton("Game Options Return").getButton());
		vbox.setAlignment(Pos.CENTER);
		root.getChildren().add(vbox);
		setMusicButton();
		scene = new Scene(root, windowWidth, windowHeight);
	}

	private void setMusicButton() {
		Button music = factory.getButton("music").getButton();
		music.setAlignment(Pos.TOP_LEFT);
		VBox v = new VBox();
		v.getChildren().add(music);
		v.setPadding(new Insets(30, 0, 0, 50));
		root.getChildren().add(v);
	}

	private void addBackground() {
		Image background = imgFactory.getImage("mainMenu", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
        Logs.log("layout Changed", "debug");
	}

}

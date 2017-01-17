package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Start extends layout {

	private VBox vbox;

	public Start(double height, double width) {
		super(height, width);
		setButtons();
		setBackground();

	}

	private void setButtons() {
		vbox = new VBox(30);

		vbox.getChildren().add(factory.getButton("New Game").getButton());
		vbox.getChildren().add(factory.getButton("Load Game").getButton());
		vbox.getChildren().add(factory.getButton("Main Options").getButton());
		vbox.getChildren().add(factory.getButton("Instructions").getButton());
		vbox.getChildren().add(factory.getButton("Exit").getButton());

		vbox.setAlignment(Pos.CENTER_RIGHT);
		vbox.setPadding(new Insets(10, 50, 50, 50));

		scene = new Scene(vbox, windowWidth, windowHeight);
	}

	private void setBackground() {
		Image img = imgFactory.getImage("main menu background", windowWidth, windowHeight);
//		System.out.println(img.getWidth());
//		BackgroundImage myBI = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
//				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
//		// then you set to your node
//		vbox.setBackground(new Background(myBI));
	}

}

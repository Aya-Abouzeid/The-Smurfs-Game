package layouts;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logs.Logs;

public class mainOptions extends layout{

    private Group root = new Group();


	public mainOptions(double height, double width) {
	    super(height, width);
        addBackground();
        addButton();
        scene = new Scene(root, windowWidth, windowHeight);
	}


    private void addButton() {
      VBox vBox = new VBox();
      vBox.getChildren().add(factory.getButton("Main Menu").getButton());
      vBox.setPadding(new Insets(windowHeight * .8, windowWidth  * .5 , 100, windowWidth / 2 - 140));
      root.getChildren().add(vBox);
    }


    private void addBackground() {
        Logs.log("Options background added", "debug");
        Image background = imgFactory.getImage("mainOptions", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);

    }

}

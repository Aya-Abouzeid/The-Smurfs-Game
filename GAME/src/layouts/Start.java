package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Start extends layout {

    private VBox vbox;
    private Group root = new Group();
    private static final String[] BUTTONS = { "New Game", "Load Game", "Main Options", "Instructions", "Exit" };

    public Start(double height, double width) {
        super(height, width);
        setBackground();
        setButtons();
        scene = new Scene(root, windowWidth, windowHeight);

    }

    private void setButtons() {
        vbox = new VBox(30);
        for (String crnt : BUTTONS)
            vbox.getChildren().add(factory.getButton(crnt).getButton());
        vbox.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(vbox);
        vbox.setPadding(new Insets(windowHeight - 700, 50, 150, windowWidth - 300));
    }

    private void setBackground() {
        Image background = imgFactory.getImage("mainMenu", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
    }

}

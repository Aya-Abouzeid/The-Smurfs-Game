package button;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EasyButton extends button{

    @Override
    public void setName() {
        File file = new File("src\\images\\EASY.png");
        Image img = new Image(file.toURI().toString());
        image = new ImageView(img);

    }

    @Override
    protected void setStyle() {
        image.setFitHeight(40);
        image.setFitWidth(100);
        b.setGraphic(image);
        b.setStyle("-fx-background-color:#ffb833;" + "-fx-background-radius: 10;" + "-fx-padding: 5 5 5 5");
    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub

    }

}

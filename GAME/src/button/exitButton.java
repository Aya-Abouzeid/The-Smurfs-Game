package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class exitButton extends button {

	private final String ButtonName = "Exit";
	private final double coordX = 0;
	private final double coordY = 0;

	@Override
	public void setX() {
		b.setLayoutX(coordX);

	}

	@Override
	public void setY() {
		b.setLayoutY(coordY);

	}

	@Override
	public void setName() {
		File file = new File("src\\images\\EXITGAME.png");
		System.out.println(file.getAbsolutePath());
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);
	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				handler.ExitConfirmation();
			}

		});
	}

}

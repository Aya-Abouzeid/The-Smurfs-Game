package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class newGameButton extends button {

	private final double coordX = 0;
	private final double coordY = 0;
	
	
	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				handler.NewGame();
			}
		
		});
	}

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
		File file = new File("NEWGAME.png");
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);
	}

}

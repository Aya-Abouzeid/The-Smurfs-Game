package button;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class instructionsButton extends button {

	private final String ButtonName = "Instructions";
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
		b.setText(ButtonName);
	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				handler.Instructions();
				
			}

		});
	}

}

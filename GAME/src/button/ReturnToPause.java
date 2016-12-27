package button;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ReturnToPause extends button {

	private final String ButtonName = "Back";
	private final double coordX = 0;
	private final double coordY = 0;

	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				handler.GameOptionsReturn();
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

	///////////////////////////////////////
	@Override
	protected void setStyle() {

	}

	@Override
	public void setName() {
		b.setText(ButtonName);
	}
}

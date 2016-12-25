package button;

import controller.eventHandler;
import javafx.scene.control.Button;

public abstract class button {
	protected Button b;
	eventHandler handler = eventHandler.getInstance();
	
	public button() {
		createButton();
		setStyle();
		setX();
		setY();
		setName();
		setAction();
	}
	
	public Button getButton() {
		return b;
	}
	
	private void createButton() {
		Button newButton = new Button();
		b = newButton;
	}

	private void setStyle() {
		////////////////// styling
	}


	public abstract void setX();
	public abstract void setY();
	public abstract void setName();
	public abstract void setAction();
	
	
//	public boolean isClicked();
//	public void setWidth(int width);
//	public void setHeight(int height);

}

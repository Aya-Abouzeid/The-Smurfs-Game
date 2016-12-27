package button;

import controller.eventHandler;
import factories.imageFactory;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public abstract class button {
	protected Button b;
	protected eventHandler handler = eventHandler.getInstance();
	protected imageFactory imgFactory = imageFactory.getImageFactory();
	protected ImageView image;
	
	public button() {
		createButton();
		setX();
		setY();
		setName();
		setAction();
		setStyle();
	}
	
	public Button getButton() {
		return b;
	}
	
	private void createButton() {
		 b = new Button();
	}

	protected void setStyle() {
		image.setFitHeight(75);
		image.setFitHeight(100);
		b.setGraphic(image);
	}


	public abstract void setX();
	public abstract void setY();
	public abstract void setName();
	public abstract void setAction();
	
	
//	public boolean isClicked();
//	public void setWidth(int width);
//	public void setHeight(int height);

}

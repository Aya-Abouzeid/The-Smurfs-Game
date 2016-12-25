package layouts;

import controller.eventHandler;
import javafx.scene.Scene;

public interface layout {

	public final int windowHeight =  600;
	public final int windowWidth =  1000;
	
	public eventHandler handler = eventHandler.getInstance();
	
	public Scene getScene();
}

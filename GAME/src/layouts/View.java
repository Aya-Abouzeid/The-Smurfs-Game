package layouts;


import factories.sceneFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {

	private Scene scene;
	private static Stage window;
	private static sceneFactory factory;
	

	@Override
	public void start(Stage arg0) throws Exception {
		window = arg0;
		window.setTitle("Game");
		scene = factory.getScene("MainMenu");
		setScene();
		window.show();
	}

	public void setScene(final String name) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				scene = factory.getScene(name);
				window.setScene(scene);
			}

		});
	}
	private void setScene() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (window != null) {
					window.setScene(scene);					
				}
			}
		});
	}
	
	public static void setFactory(sceneFactory scenefactory) {
		factory = scenefactory;
	}
	

}

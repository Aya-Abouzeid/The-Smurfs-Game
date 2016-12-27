package layouts;


import factories.sceneFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class View extends Application {

	private Scene scene;
	private static Stage window;
	private static sceneFactory factory;

	@Override
	public void start(Stage arg0) throws Exception {
		factory = sceneFactory.getSceneFactory();
		window = arg0;
		window.setTitle("Game");
		setDimentions();
		scene = factory.getScene("MainMenu", window.getHeight(), window.getWidth());
		setScene();
		setExitConfirmation();
		
        window.show();
	}
	
	private void setDimentions() {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		window.setX(bounds.getMinX());
		window.setY(bounds.getMinY());
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		
	}

	private void setExitConfirmation() {
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				try {
					ExitConfrmationWindow.display();
				} catch (Exception e) {
					System.out.println("cann't close the program");
					e.printStackTrace();
				}
			}
		});
	}

	public void setScene(final String name) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				scene = factory.getScene(name, window.getHeight(), window.getWidth());
				window.setScene(scene);
			}

		});
	}
	public void setScene(final Scene newScene) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				scene = newScene;
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
	
	public double getWidth() {
		return window.getWidth();
	}
	public double getHeight() {
		return window.getHeight();
	}

	public void exit() {
		System.out.println("bye");
		Platform.exit();
	}

	public static void setFactory(sceneFactory scenefactory) {
		factory = scenefactory;
	}

}

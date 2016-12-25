package layouts;


import factories.sceneFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
		scene = factory.getScene("MainMenu");
		setScene();
		setExitConfirmation();
		window.setFullScreen(false);
        window.setFullScreen(true);
        window.show();
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

	public void exit() {
		System.out.println("bye");
		Platform.exit();
	}

	public static void setFactory(sceneFactory scenefactory) {
		factory = scenefactory;
	}

}

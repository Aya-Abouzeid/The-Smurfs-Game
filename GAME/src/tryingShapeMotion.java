import java.util.ArrayList;
import java.util.Random;
import button.button;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import factories.*;
import shape.*;

public class tryingShapeMotion extends Application {

	private shapePool pool = shapePool.getPoolInstance();

	private ArrayList<shape.Shape> fallingShapes = new ArrayList<shape.Shape>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Timeline Example");

		final Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.WHITE);
		primaryStage.setScene(scene);

		Canvas canvas = new Canvas(500, 500);
		root.getChildren().add(canvas);

		final GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				draw(gc);
			}
		}.start();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void draw(GraphicsContext g) {

		g.clearRect(0, 0, 500, 500);

		fallingShapes.add(pool.borrowObject());
		for (int i = 0; i < fallingShapes.size(); i++) {
			if (fallingShapes.get(i).getY() == 500) {
				pool.returnObject(fallingShapes.get(i));

				fallingShapes.remove(i);
			} else {
				fallingShapes.get(i).setY(fallingShapes.get(i).getY() + 1.0);
				fallingShapes.get(i).drawShape(g);
			}

		}

	}
}

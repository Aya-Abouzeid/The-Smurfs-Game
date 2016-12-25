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
	double x;
	double x2;
	private shapePool pool = shapePool.getPoolInstance();
	shape.Shape newshape;
	int counter2 = 500;
	int counter = 500;
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

	public void draw (GraphicsContext g ){
//			    int  position = Math.abs((rand.nextInt(400)*315123123 + 50)%400);
			    
	            double y = (counter)%500;
	            double y2 = (counter2)%500;

	if(y== 0.0){
		counter = 500; // increment position y by1
//		x = position;
	}
	else if(y2== 0.0){
		counter2 = 500;
//		x2 = position;
	}
	newshape.setX(x);
   newshape.setY(y);
	 g.clearRect(0, 0, 500, 500);
//	 for(int i=0; i<pool.po)
     newshape.drawShape(g);
     //	            g.drawImage(newshape.getShape(), x, y);
				counter++;
				counter2++;

		}
}

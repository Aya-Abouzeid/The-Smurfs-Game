
import java.util.Random;
import button.button;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class tryingImageMotion extends Application {
	double x;
	double x2;
	Image oscar = new Image("file:oscar.png");
	Image oscar2 = new Image("file:oscars.png");
	Image theme = new Image("file:Theme.jpg");

	int counter2 = 500;
	int counter = 500;
	Random rand = new Random();
	long startNanoTime = System.nanoTime();

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle( "Timeline Example" );
	  Thread t = new Thread();
		  t.start();
		    Group root = new Group();
	        Scene scene = new Scene(root, 500, 500, Color.WHITE);
		    primaryStage.setScene( scene );
		 
		    Canvas canvas = new Canvas( 500, 500 );
		    root.getChildren().add( canvas );
		     
		     final GraphicsContext gc = canvas.getGraphicsContext2D();
		

		    new AnimationTimer()
		    {
		        public void handle(long currentNanoTime)
		        {	
		        	
				 
		            draw(gc,currentNanoTime );
		        
		        
		        }
		    }.start();
		    primaryStage.setScene(scene);
		 primaryStage.show();
	}

	public void draw (GraphicsContext g ,long currentNanoTime){
		    int  position = Math.abs((rand.nextInt(400)*315123123 + 1)%400);
//            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
            double y = (counter)%500;
            double y2 = (counter2)%500;

if(y== 0.0){
	counter = 500; // increment position y by1
	x = position;
}
else if(y2== 0.0){
	counter2 = 500;
	x2 = position;
}
//            g.clearRect(0, 0, 500, 500);
            if(counter < 700)
            g.drawImage(oscar, x2, y2);
            else
            {
            g.clearRect(0, 0, 500, 500);
            }
            g.clearRect(0, 0, 500, 500);

            g.drawImage( oscar2, x, y );

			counter++;
			counter2++;

	}
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage.setTitle("Timeline Example");
//		// Thread t = new Thread();
//		// t.start();
//		Group root = new Group();
//		Scene scene = new Scene(root, 500, 500, Color.WHITE);
//		primaryStage.setScene(scene);
//
//		Canvas canvas = new Canvas(500, 500);
//		root.getChildren().add(canvas);
//final GraphicsContext gc = canvas.getGraphicsContext2D();
//        
//        final Image oscar = new Image( "file:oscars.png" );
////        final Image theme = new Image( "file:Theme.jpg" );
//        
//        Timeline gameLoop = new Timeline();
//        gameLoop.setCycleCount( Timeline.INDEFINITE );
//        
//        final long timeStart = System.currentTimeMillis();
//        
//        KeyFrame kf = new KeyFrame(
//            Duration.seconds(0.017),                // 60 FPS
//            new EventHandler<ActionEvent>()
//            {
//                public void handle(ActionEvent ae)
//                {
//                    double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
//                                
//                    double x = 232 + 128 * Math.cos(t);
//                    double y = 232 + 128 * Math.sin(t);
//                    
//                    // Clear the canvas
//                    gc.clearRect(0, 0, 500,500);
//                    
//                    // background image clears canvas
////                    gc.drawImage( theme, 0, 0 );
//                    gc.drawImage( oscar, x, y );
//                }
//            });
//        
//        gameLoop.getKeyFrames().add( kf );
//        gameLoop.play();
//        primaryStage.setScene(scene);
//primaryStage.show();
//}
//	
//
//	public void draw(GraphicsContext g, long currentNanoTime) {
//		int position = Math.abs((rand.nextInt(400) * 315123123 + 1) % 400);
//		// double t = (currentNanoTime - startNanoTime) / 1000000000.0;
//
//		double y = (counter) % 500;
//		double y2 = (counter2) % 500;
//
//		if (y == 0.0) {
//			counter = 500; // increment position y by1
//			x = position;
//		} else if (y2 == 0.0) {
//			counter2 = 500;
//			x2 = position;
//		}
//		// g.clearRect(0, 0, 500, 500);
//		g.drawImage(theme, 0, 0);
//
//		if (counter < 700)
//			g.drawImage(oscar2, x2, y2);
//		else {
//			g.clearRect(0, 0, 500, 500);
//		}
//		g.drawImage(oscar, x, y);
//
//		counter++;
//		counter2++;
//
//	}
	
}

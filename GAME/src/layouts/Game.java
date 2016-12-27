package layouts;



import controller.gameController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Game extends layout{
	
	private GraphicsContext gc;
	private Group root;
	
	public Game(double height, double width) {
		super(height, width);
		Group root = setLayout();
		
		//////add sound button
		scene = new Scene(root, windowWidth, windowHeight, Color.WHITE);
		setKeyPress();
		setMouseMovement();
		
	}
	
	private Group setLayout() {
		Image background = imgFactory.getImage("galaxy");
		ImageView img = new ImageView (background);
		img.setPreserveRatio(true);
		img.setFitHeight(windowWidth);
		
		root = new Group();
		root.getChildren().add(img);

		Canvas canvas = new Canvas(windowWidth, windowHeight);
		root.getChildren().add(canvas);
		//fallingShapes.add(pool.borrowObject(windowWidth));
		 gc = canvas.getGraphicsContext2D();
		// gc.drawImage(galaxy, 0, 0);
		gc.drawImage(imgFactory.getImage("smurfette"), 0, 0);

		gc.setStroke(Color.BLACK);
		
		return root;
	}
	
	
	private void setKeyPress() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				System.out.println("escape");
				if (event.getCode() == KeyCode.ESCAPE){
					handler.EscapeFromGame();	
				} else if (event.getCode() == KeyCode.RIGHT) {
					gameController.setPlayer1Location(true);
				}else if (event.getCode() == KeyCode.LEFT) {
					gameController.setPlayer1Location(false);
				}
			}
			
		});
	}
	
	private void setMouseMovement() {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				gameController.setPlayer2Location(event.getX());
			}
			
		});
	}
	
	public GraphicsContext getGraphicContext() {
		return gc;
	}
	
	public double getWidth() {
		return windowWidth;
	}
	
	public double getHeight() {
		return windowHeight;
	}
	
	public Group getRoot() {
		return root;
	}

}
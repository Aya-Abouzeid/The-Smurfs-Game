package controller;

import java.io.File;
import java.util.ArrayList;

import factories.imageFactory;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import layouts.Game;
import shape.shapePool;

public class gameController implements Runnable {
	private static final int      KEYBOARD_MOVEMENT = 50;
	private GraphicsContext gc;
	private double width;
	private double height;
	private int counter ;
	private ArrayList<shape.Shape> fallingShapes;
	private shapePool pool;
	private imageFactory imgFactory;
	private double shapeSpeed = 3.0;
	private Image playerImg1;
	private static ImageView player1;
	private static ImageView player2;
	private Image playerImg2;
	private Group root;

	
	
	public gameController(Game game) {
		this.gc = game.getGraphicContext();
		this.width = game.getWidth();
		this.height = game.getHeight();
		this.root = game.getRoot();
		 imgFactory = imageFactory.getImageFactory();
		 pool = shapePool.getPoolInstance();
		 fallingShapes = new ArrayList<shape.Shape>();
		 counter = 0;
	}

	@Override
	public void run() {
		setImages();
		setFallingPlates();
		setPlayers();
				
	}
	
	private void setImages() {
		playerImg1 = imgFactory.getImage("smurfette");
		playerImg2 = imgFactory.getImage("smurff");
	}
	
	private void setFallingPlates() {
		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				draw();
			}
		}.start();	
	}
	
	private void draw() {
		gc.clearRect(0, 0, width, height);
		//gc.drawImage(playerImg1, 0, 0);
		counter++;
		if (counter % 30 == 0) {
			fallingShapes.add(pool.borrowObject(width));
		counter =0;	
		}
		for (int i = 0; i < fallingShapes.size(); i++) {
			if (fallingShapes.get(i).getY() >= height) {
				pool.returnObject(fallingShapes.get(i));

				fallingShapes.remove(i);
				i--;
			} else if(fallingShapes.get(i).getX() < 500){ //mafrood tb2a width of (stage/3) msh hardcoded 500
				fallingShapes.get(i).setX(fallingShapes.get(i).getX() + shapeSpeed );
//				fallingShapes.get(i).setY(fallingShapes.get(i).getY() + shapeSpeed); // controls
																				// speed
				fallingShapes.get(i).drawShape(gc);
			}
			else {
			fallingShapes.get(i).setY(fallingShapes.get(i).getY() + shapeSpeed); // controls
				// speed
fallingShapes.get(i).drawShape(gc);	
			}
		}
	}
	
	private void setPlayers(){
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				player1 = new ImageView(playerImg1);
				root.getChildren().add(player1);
				player1.setY(player1.getY() + 700); //'700'should be [stage height - 300 (smurf's height)] to fit while resizing
				player2 = new ImageView(playerImg2);
				root.getChildren().add(player2);
				player2.setY(player2.getY() + 700);				
			}
		});		
	}
	
	
	public static void setPlayer1Location(boolean right){
		if (right) {
			player1.setX(player1.getX() + KEYBOARD_MOVEMENT);
		} else {
			 player1.setX(player1.getX() - KEYBOARD_MOVEMENT);
		}
	}
	
	public static void setPlayer2Location(double x){
		player2.setX(x);
	}
	
	
	
	public void setGameSpeed(double speed) {
		shapeSpeed = speed;
	}
}

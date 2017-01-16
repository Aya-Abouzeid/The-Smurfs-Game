package controller;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import factories.imageFactory;
import layouts.Game;
import player.Player;
import shape.shapePool;

public class gameController implements Runnable {
	private final double characterHeight = 330;
	private final double characterWidth = 100;
	private final int KEYBOARD_MOVEMENT = 70;
	private GraphicsContext gc;
	private AnimationTimer drawingThread;
	private ArrayList<shape.Shape> fallingShapes;
	private shapePool pool;
	private imageFactory imgFactory;
	private TimerThread timer;
	private LinkedList<Player> players;
	private gameOptions gameOptions;
	private Group root;
	private Label timerLabel;
	private double shapeSpeed;
	private int minutesTimer;
	private int SecondsTimer;
	private boolean pause;
	private double width;
	private double height;
	private int counter;

	public gameController(Game game, gameOptions gameOptions) {
		this.gc = game.getGraphicContext();
		this.width = game.getWidth();
		this.height = game.getHeight();
		this.root = game.getRoot();
		this.timerLabel = game.getTimerLabel();
		this.gameOptions = gameOptions;
		imgFactory = imageFactory.getImageFactory();
		pool = shapePool.getPoolInstance();
		fallingShapes = new ArrayList<shape.Shape>();
		players = new LinkedList<Player>();
		counter = 0;
	}

	@Override
	public void run() {
		pause = false;
		setGameSpeed();
		setFallingPlates();
		setPlayers();
		startGameTimer();
	}

	private void setGameSpeed() {
		shapeSpeed = gameOptions.getGameSpeed();
	}

	private void setFallingPlates() {
		drawingThread = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				// stop it when game is paused
				draw();
			}
		};
		drawingThread.start();

	}

	private void draw() {
		System.out.println("drawing");
		gc.clearRect(0, 0, width, height);
		// gc.drawImage(playerImg1, 0, 0);
		counter++;
		if (counter % 30 == 0) {
			fallingShapes.add(pool.borrowObject(width));
			counter = 0;
		}
		for (int i = 0; i < fallingShapes.size(); i++) {
			if (fallingShapes.get(i).getY() >= height) {
				pool.returnObject(fallingShapes.get(i));

				fallingShapes.remove(i);
				i--;
			} else if (fallingShapes.get(i).getX() < 500) { // mafrood tb2a
															// width of
															// (stage/3) msh
															// hardcoded 500
				fallingShapes.get(i).setX(fallingShapes.get(i).getX() + shapeSpeed);
				// fallingShapes.get(i).setY(fallingShapes.get(i).getY() +
				// shapeSpeed); // controls
				// speed
				fallingShapes.get(i).drawShape(gc);
			} else {
				fallingShapes.get(i).setY(fallingShapes.get(i).getY() + shapeSpeed); // controls
				// speed
				fallingShapes.get(i).drawShape(gc);
			}
		}
	}

	private void setPlayers() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int n = gameOptions.getNPlayers();
				boolean mouseCntrl;
				Image img;
				for (int i = 0; i < n; i++) {
					mouseCntrl = gameOptions.getMouseControl(i);
					img = imgFactory.getImage(gameOptions.getCharacter(i));
					Player player = new Player(img, mouseCntrl);
					if (!mouseCntrl) {
						player.setLeftButton(gameOptions.getLeftButton(i));
						player.setRightButton(gameOptions.getrightButton(i));
					}
					player.setX(gameOptions.getPositionX(i));
					player.setY(height - characterHeight);
					root.getChildren().add(player.getImageView());
					players.add(player);
				}
			}
		});
	}

	public void notifyMouseMoved(double x) {
		Player p;
		for (int i = 0; i < players.size(); i++) {
			p = players.get(i);
			if (p.getMouseControl()) {
				p.setX(x);
			}
		}
	}

	public void notifyKeyPressed(KeyCode key) {
		Player p;
		for (int i = 0; i < players.size(); i++) {
			p = players.get(i);
			if (!p.getMouseControl()) {
				if (p.getrightButton() == key) {
					if (p.getX() < width - characterWidth) {
						p.MoveByKey(KEYBOARD_MOVEMENT);
					}
				} else if (p.getLeftButton() == key) {
					if (p.getX() > 0) {
						p.MoveByKey(-1 * KEYBOARD_MOVEMENT);
					}
				}

			}
		}
	}

	private void startGameTimer() {
		timer = new TimerThread(timerLabel, minutesTimer, SecondsTimer);
		Thread t = new Thread(timer);
		t.start();
	}

	// stop runnig threads
	public void pause() {
		pause = true;
		timer.stopTimer();
		drawingThread.stop();
	}

	public void setGameSpeed(double speed) {
		shapeSpeed = speed;
	}
}

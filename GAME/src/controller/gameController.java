package controller;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.imageFactory;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import layouts.Game;
import player.Player;
import shape.Shape;
import shape.shapeInt;
import shape.shapePool;
import states.PlayerStack;

public class gameController implements Runnable {
    private final double characterHeight = 330;
    private final double characterWidth = 100;
    private final int KEYBOARD_MOVEMENT = 70;
    private GraphicsContext gc;
    private AnimationTimer drawingThread;
    private ArrayList<Shape> fallingShapes;
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
            @Override
            public void handle(long currentNanoTime) {
                // stop it when game is paused
                draw();
            }
        };
        drawingThread.start();
    }

    private void draw() {
        gc.clearRect(0, 0, width, height);
        counter++;
        if (counter % 30 == 0) {
            fallingShapes.add(pool.borrowObject(width, height));
            counter = 0;
        }
        for (int i = 0; i < fallingShapes.size(); i++) {
            if (players.size() == 2)
                catchDetection(i);
            if (fallingShapes.get(i).getY() >= height) {
                pool.returnObject(fallingShapes.get(i));
                fallingShapes.remove(i);
                i--;
            } else {
                fallingShapes.get(i).move(gc, shapeSpeed);
            }
        }
        if (players.size() == 2)
            for (int i = 0; i < 2; i++) {
                for (PlayerStack crnt : players.get(i).Stacks) {
                    for (shapeInt x : crnt.stack)
                        x.drawShape(gc);
                }
            }
    }

    private void catchDetection(int obj) {
        Shape object = fallingShapes.get(obj);
        for (int i = 0; i < 2; i++) {
            PlayerStack S1 = players.get(i).Stacks.get(0);
            PlayerStack S2 = players.get(i).Stacks.get(1);
            if (object.getY() == height - S1.getHight() && Math.abs(object.centerX() - players.get(i).getX()) < 15) {
                S1.add(object);
                fallingShapes.remove(obj);
            } else if (object.getY() == height - S2.getHight()
                    && Math.abs(object.centerX() - 100 - characterWidth - players.get(i).getX()) < 15) {
                S2.add(object);
                fallingShapes.remove(obj);

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

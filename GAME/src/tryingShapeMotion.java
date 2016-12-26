import java.util.ArrayList;

import factories.shapeFactory;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import layouts.classLoading;
import player.Player;
import shape.Shape;
import shape.shapePool;

public class tryingShapeMotion extends Application {

    private double screenWidth;
    private shapePool pool = shapePool.getPoolInstance();
    private int counter = 0;
    private ArrayList<shape.Shape> fallingShapes = new ArrayList<shape.Shape>();
    Image galaxy = new Image("file:galaxy2.png");
    Image smurfette = new Image("file:Smurfette-original.png");
    private static ArrayList<Class> loadedShapes;
    private Player player1 = new Player(null); // --- Send a path
    private Player player2 = new Player(null);
    public static void main(String[] args) {
        loadSahpes();
        launch(args);
    }

    private static void loadSahpes() {
        try {
            loadedShapes = classLoading.getInstance().getLoadedShapes();
            shapeFactory.getShapeFactory().setLoadedClasses(loadedShapes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("Game");
        primaryStage.setFullScreen(true);

        ImageView img = new ImageView(galaxy);
        img.setPreserveRatio(true);
        img.fitWidthProperty().bind(primaryStage.widthProperty());

        final Group root = new Group();

        Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight(), Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.getChildren().add(img);

        Canvas canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
        root.getChildren().add(canvas);
        primaryStage.show();
        fallingShapes.add(pool.borrowObject(primaryStage.getWidth()));
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        // gc.drawImage(galaxy, 0, 0);
        gc.drawImage(smurfette, 0, 0);

        gc.setStroke(Color.BLACK);
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                draw(gc, primaryStage.getHeight(), primaryStage.getWidth());
            }
        }.start();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void draw(GraphicsContext gc, double height, double width) {

        gc.clearRect(0, 0, width, height);
        gc.drawImage(smurfette, 0, 0);
        counter++;
        if (counter % 15 == 0)
            fallingShapes.add(pool.borrowObject(width));
        for (int i = 0; i < fallingShapes.size(); i++) {
            if (fallingShapes.get(i).getY() >= height) {
                pool.returnObject(fallingShapes.get(i));
                fallingShapes.remove(i--);
            }else if(fallingShapes.get(i).getX() == player1.getX() || fallingShapes.get(i).getX() == player2.getX()){
                catchDetection(fallingShapes.get(i));
            }
            else {
                fallingShapes.get(i).setY(fallingShapes.get(i).getY() + 4.0);
                fallingShapes.get(i).drawShape(gc);
            }
        }
    }

    private void catchDetection(Shape shape) {


    }
}

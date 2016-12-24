package layouts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Playing extends Application implements layout {

    //Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws URISyntaxException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        BorderPane pane = new BorderPane();

        ImageView player1 = new ImageView(new Image("file:player1.png"));
        player1.setFitHeight(100);
        player1.setPreserveRatio(true);
        pane.setBottom(player1);

        classLoading classloading = new classLoading();
        Constructor<?>[] con = classloading.loadedShapes.get(0).getConstructors();
        con[0].newInstance(Color.AZURE);
        Method m = classloading.loadedShapes.get(0).getMethods()[0];
        classloading.loadedShapes.get(0).getMethod("getShape");
        //pane.setCenter((Node)classloading.loadedShapes.get(0).getMethod("getShape"));
//        final URL resource = getClass().getResource("BBC.mp3");
//        final Media media = new Media(resource.toString());
//        final MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
        //MediaPlayer mediaPlayer = new MediaPlayer(new Media("file:BBC.mp3"));
       // mediaPlayer.play();
        Scene scene = new Scene(pane, 300, 400);

        primaryStage.setTitle("Playing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

package layouts;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        String musicFile = "sound/BBC.mp3";     // For example
        String musicI = "sound/sherlock.mp3";
        final MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(musicFile).toURI().toString()));
        final MediaPlayer media = new MediaPlayer(new Media(new File(musicI).toURI().toString()));
        //mediaPlayer.
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);

            }
        });

        mediaPlayer.play();
        media.play();
        //player1.
        Scene scene = new Scene(pane, 300, 400, Color.BLACK);

        primaryStage.setTitle("Playing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

package supportedShapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class ellipse implements shape{

    private Ellipse ellipse;

    // -- you would send CenterX and CenterY which are generated randomly -- //
    public ellipse(Color color) {

        ellipse = new Ellipse();
        {
            ellipse.setCenterX(50.0f);
            ellipse.setCenterY(50.0f);
            ellipse.setRadiusX(25.0f);
            ellipse.setRadiusY(5.0f);
        }

        ellipse.setStrokeWidth(2);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(color);
    }

    public Ellipse getShape() {
        return ellipse;
    }

}

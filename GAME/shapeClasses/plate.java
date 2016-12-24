package supportedShapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class plate implements shape{

    private Polygon plate;

    // --- you would send me 1 coordinate generated randomly and I should calculate the rest --- //
    public plate(Color color) {
        plate.getPoints().addAll(new Double[] { 0.0, 0.0, 20.0, 10.0, 70.0, 10.0, 90.0, 0.0 });
        plate.setStrokeWidth(2);
        plate.setStroke(Color.BLACK);
        plate.setFill(color);
    }

    public Polygon getShape() {
        return plate;
    }

}

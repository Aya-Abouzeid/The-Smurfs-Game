package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class Caught extends State {

    @Override
    public float setSlope(double screenWidth, double screenheight) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double increaseSlopedY(double oldY, float slope, double width) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getstate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void move(Shape shape, GraphicsContext gc, double shapeSpeed, double width) {
        // TODO Auto-generated method stub

    }
    public void move(Shape shape, double x) {
        shape.setX(x);

    }


}

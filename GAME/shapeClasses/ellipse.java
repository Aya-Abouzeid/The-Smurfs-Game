package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import states.State;
import states.Stored;

public class ellipse extends Shape implements shapeInt {
    private Ellipse ellipseShape;

    public ellipse() {
        Color c = colors[randomize.nextInt(colors.length)];
        this.color = c;
        ellipseShape = new Ellipse();
        ellipseShape.setCenterY(10.0);
        ellipseShape.setCenterX(10.0);
        ellipseShape.setRadiusX(60.0);
        ellipseShape.setRadiusY(15.0);
        ellipseShape.setFill(color);
        this.state = Stored.getStoredInstance();
        this.height = 30.0f;
    }

    @Override
    public void move(GraphicsContext gc, double shapeSpeed) {
        this.state.move(this, gc, shapeSpeed);
    }

    @Override
    public void setSlope(double screenWidth, double screenheight) {
        this.slope = state.setSlope(screenWidth, screenheight);
    }

    @Override
    public void increaseSlopedY() {
        this.setY(this.getY() + 1);
        this.setX(state.increaseSlopedY(this.getY(), this.slope));
    }

    @Override
    public void drawShape(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(x - 25, y - 10.0, 60.0, 25.0f);
    }

    @Override
    public Ellipse getShape() {
        return this.ellipseShape;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
        this.ellipseShape.setCenterX(x);
    }

    @Override
    public void setY(double y) {
        this.y = y;
        this.ellipseShape.setCenterY(y);
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setState(State s) {
        this.state = s;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double centerX() {
        return getX();
    }

    @Override
    public double centerY() {
       return getY();
    }
}

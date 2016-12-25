package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.*;

public abstract class Shape {

	abstract public double getX();

	abstract public double getY();

	abstract public void setX(double x);

	abstract public void setY(double y);

	abstract public State getState();

	abstract public void setState(State s);

	abstract public Color getColor();

	abstract public javafx.scene.shape.Shape getShape();

	abstract public void drawShape(GraphicsContext gc);
}

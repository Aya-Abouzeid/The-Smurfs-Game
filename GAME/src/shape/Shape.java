package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.State;

public abstract class Shape implements shapeIn{

	@Override
    abstract public double getX();

	@Override
    abstract public double getY();

	@Override
    abstract public void setX(double x);

	@Override
    abstract public void setY(double y);

	@Override
    abstract public State getState();

	@Override
    abstract public void setState(State s);

	@Override
    abstract public Color getColor();

	@Override
    abstract public javafx.scene.shape.Shape getShape();

	@Override
    abstract public void drawShape(GraphicsContext gc);
}

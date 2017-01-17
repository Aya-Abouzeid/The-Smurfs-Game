package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.State;

public abstract class Shape implements shapeInt {

    State state;

	@Override
	abstract public double getX();

	@Override
	abstract public void move(GraphicsContext gc , double shapeSpeed);

	@Override
	abstract public double getY();

	@Override
	abstract public void setX(double x);

	@Override
	abstract public void setY(double y);

	@Override
	abstract public State getState();

	@Override
	abstract public void setSlope(double screenWidth, double screenheight);

	@Override
	abstract public void setState(State s);

	@Override
	abstract public Color getColor();

	@Override
	abstract public void increaseSlopedY() ;

	@Override
	abstract public javafx.scene.shape.Shape getShape();

	@Override
	abstract public void drawShape(GraphicsContext gc);

	@Override
	abstract public double getHeight();
}

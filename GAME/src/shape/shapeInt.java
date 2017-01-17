package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import states.State;

public interface shapeInt {
	public void drawShape(GraphicsContext gc);

	public Shape getShape();

	public double getX();

	public void setSlope(double screenWidth, double screenheight);

	public void move(GraphicsContext gc , double shapeSpeed);
	
	public double getY();

	public void setX(double x);

	public void setY(double y);

	public void increaseSlopedY();

	public State getState();

	public void setState(State s);

	public Color getColor();

	public double getHeight();

}

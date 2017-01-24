package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public abstract class State {
	abstract public boolean isCaught();

	abstract public boolean isFalling();

	abstract public boolean isStored();
	// abstract public void dequeue();
	// abstract public void isOnGround();
	// abstract public void checkFalse();
	// abstract public void checkTrue();
	abstract public float setSlope(double screenWidth ,double screenheight);
	abstract public double increaseSlopedY(double oldY ,float slope,double width);
	
	abstract public String getstate();

	abstract public void move(Shape shape ,GraphicsContext gc , double shapeSpeed,double width);
}

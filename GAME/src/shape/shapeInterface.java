package shape;
import states.*;
public interface shapeInterface {

	public double getX();
	public double getY();
	public void setX(double x);
	public void setY(double y);
	public State getState();
	public void setState(State s);

}

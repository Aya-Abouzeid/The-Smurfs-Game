package states;

import factories.sceneFactory;
import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class Caught extends State {

	private static Caught caught = null;

	private Caught() {

	}

	public static Caught getcaughtInstance() {

		if (caught == null) {
			return caught = new Caught();
		}

		return caught;
	}

	@Override
	public boolean isCaught() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isFalling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStored() {
		// TODO Auto-generated method stub
		return false;
	}
	// @Override
	// public void isOnGround() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void checkFalse() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void checkTrue() {
	// // TODO Auto-generated method stub
	//
	// }
	// @Override
	// public void dequeue() {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public float setSlope(double screenWidth, double screenheight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double increaseSlopedY(double oldY, float slope) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(Shape shape, GraphicsContext gc, double shapeSpeed) {
		// TODO Auto-generated method stub

	}
}

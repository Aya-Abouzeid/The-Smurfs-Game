package states;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class FallingFromLeft extends State {
	private static FallingFromLeft fallingFromLeft = null;
	private Random randomize = new Random();

	private FallingFromLeft() {

	}

	public static FallingFromLeft getFallingFromLeftInstance() {

		if (fallingFromLeft == null) {
			return fallingFromLeft = new FallingFromLeft();
		}

		return fallingFromLeft;
	}

	@Override
	public boolean isCaught() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFalling() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isStored() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Shape shape, GraphicsContext gc, double shapeSpeed) {
		// TODO Auto-generated method stub
		if (shape.getX() < 250) {

			shape.setX(shape.getX() + shapeSpeed); // controls speed
			shape.drawShape(gc);
		} else {

			shape.increaseSlopedY();
			shape.drawShape(gc);
		}
	}

	@Override
	public float setSlope(double screenWidth, double screenheight) {
		// TODO Auto-generated method stub
		float r = (randomize.nextInt((int) screenWidth));
		float slope = (float) (screenheight - 150) / (r - 250);
		return (slope > 0) ? slope : -slope;

	}

	@Override
	public double increaseSlopedY(double oldY, float slope) {
		// TODO Auto-generated method stub
		return (oldY - (150 - (slope * 250))) / slope;
	}

	// @Override
	// public void dequeue() {
	// // TODO Auto-generated method stub
	//
	// }
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

}

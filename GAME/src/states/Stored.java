package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class Stored extends State {

	private static Stored stored = null;

	private Stored() {

	}

	public static Stored getStoredInstance() {

		if (stored == null) {
			return stored = new Stored();
		}

		return stored;
	}

	@Override
	public boolean isCaught() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFalling() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStored() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public float setSlope(double screenWidth, double screenheight) {
		// TODO Auto-generated method stub
		return 0;
	}



    @Override
    public double increaseSlopedY(double oldY, float slope, double width, double height) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void move(Shape shape, GraphicsContext gc, double shapeSpeed, double width, double height) {
        // TODO Auto-generated method stub

    }

	// @Override
	// public void isOnGround() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void dequeue() {
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

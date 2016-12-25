package shape;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import factories.shapeFactory;
import states.Falling;
import states.Stored;

public class shapePool {

	// --- Replace every Object with a SHAPE --- //
	private Random rand = new Random();

	private static shapePool shapePoolSinglton = null;
	private shapeFactory factory = shapeFactory.getShapeFactory();
	private ConcurrentLinkedQueue<Shape> pool = new ConcurrentLinkedQueue<Shape>();
	private double y = 0.0;

	private shapePool() {
	}

	public static shapePool getPoolInstance() {
		if (shapePoolSinglton == null)
			shapePoolSinglton = new shapePool();
		return shapePoolSinglton;
	}

	public Shape borrowObject() {
		Shape shape;
		if ((shape = pool.poll()) == null) {
			shape = CreateObject();
		}
		shape.setState(Falling.getFallingInstance());
		int position = Math.abs((rand.nextInt(400) * 315123123 + 50) % 400);
		shape.setX(position);
		shape.setY(y);
		y = y - 20.0;
		return shape;
	}

	public void returnObject(Shape shape) {
		if (shape != null) {
			this.pool.add(shape);
			shape.setState(Stored.getStoredInstance());
		}
	}

	private Shape CreateObject() {
		// Call shapeFactory
		return factory.getShapeInstance();
	}
}

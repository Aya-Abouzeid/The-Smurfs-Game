package shape;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import factories.shapeFactory;
import states.Falling;
import states.Stored;

public class shapePool {

	private Random rand = new Random();
	private int counter = 0;
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

	public Shape borrowObject(double width) {
		Shape shape;

		if ((shape = this.pool.poll()) == null) {
			shape = CreateObject();
		}

		shape.setState(Falling.getFallingInstance());
		int position = Math.abs((rand.nextInt((int) width) * 315123123 + 50) % (int)width);
		shape.setX(position);
		shape.setY(y);
		y = y - 1.0;
		return shape;
	}

	public void returnObject(Shape shape) {
		if (shape != null) {
			this.pool.add(shape);

			shape.setState(Stored.getStoredInstance());
		}
	}

	private Shape CreateObject() {
		return factory.getShapeInstance();
	}
}

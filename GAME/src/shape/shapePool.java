package shape;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import factories.shapeFactory;
import states.Falling;
import states.Stored;

public class shapePool {

	// --- Replace every Object with a SHAPE --- //
	private Random rand = new Random();
int counter =0;
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
		shape = this.pool.poll();
		if (shape == null) {
			shape = CreateObject();
			System.out.println(pool.size());
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
			System.out.println("heree");
			this.pool.add(shape);
			System.out.println(pool.size());

			shape.setState(Stored.getStoredInstance());
		}
	}

	private Shape CreateObject() {
		// Call shapeFactory
		return factory.getShapeInstance();
	}
}

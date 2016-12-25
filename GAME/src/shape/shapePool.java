package shape;
import java.util.concurrent.ConcurrentLinkedQueue;

import factories.shapeFactory;

public class shapePool {

    // --- Replace every Object with a SHAPE --- //

    private static shapePool shapePoolSinglton = null;
	shapeFactory factory = shapeFactory.getShapeFactory();
    private ConcurrentLinkedQueue<Shape> pool = new ConcurrentLinkedQueue<Shape>();

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
        return shape;
    }

    public void returnObject(Shape shape) {
        if (shape != null)
            this.pool.add(shape);
    }

    private Shape CreateObject() {
        // Call shapeFactory
        return factory.getShapeInstance();
    }
}

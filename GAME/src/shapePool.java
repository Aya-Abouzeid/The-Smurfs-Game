import java.util.concurrent.ConcurrentLinkedQueue;

public class shapePool {

    // --- Replace every Object with a SHAPE --- //

    private static shapePool shapePoolSinglton = null;
    private ConcurrentLinkedQueue<Object> pool = new ConcurrentLinkedQueue<Object>();

    private shapePool() {
    }

    public static shapePool getInstance() {
        if (shapePoolSinglton == null)
            shapePoolSinglton = new shapePool();
        return shapePoolSinglton;
    }

    public Object borrowObject() {
        Object object;
        if ((object = pool.poll()) == null) {
            object = CreateObject();
        }
        return object;
    }

    public void returnObject(Object object) {
        if (object != null)
            this.pool.add(object);
    }

    private Object CreateObject() {
        // Call shapeFactory
        return null;
    }
}

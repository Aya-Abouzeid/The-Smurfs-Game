package factories;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

import shape.Shape;
import shape.shapeIn;

public class shapeFactory {
	private Random randomize = new Random();
	private ArrayList<Class> shapeShuffler;

	private static shapeFactory shapeFactory = null;

	private shapeFactory() {

	}

	public static shapeFactory getShapeFactory() {

		if (shapeFactory == null) {
			return shapeFactory = new shapeFactory();
		}

		return shapeFactory;
	}

	public Shape getShapeInstance() {
		Class shuffle = shapeShuffler.get(randomize.nextInt(shapeShuffler.size()));
		Constructor<?>[] con = shuffle.getConstructors();
        shapeIn crnt = null;
        try {
            crnt = (shapeIn) con[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return (Shape) crnt;
//		if (shuffle == 0) {
//			return new ellipse();
//		} else
//			return new plate();
	}

	public void setLoadedClasses(ArrayList<Class> loadedShapes) {
	    this.shapeShuffler = loadedShapes;
	}

}

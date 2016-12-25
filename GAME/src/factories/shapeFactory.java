package factories;

import java.util.Random;
import shape.Shape;
import shape.ellipse;
import shape.plate;
import javafx.scene.paint.Color;

public class shapeFactory {
	private Random randomize = new Random();
	private int[] shapeShuffler = { 0, 1 };

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
		int shuffle = shapeShuffler[randomize.nextInt(shapeShuffler.length)];
		if (shuffle == 0) {
			return new ellipse();
		} else
			return new plate();
	}

}

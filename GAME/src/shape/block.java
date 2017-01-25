package shape;

import factories.imageFactory;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import states.FallingFromLeft;
import states.Stored;

public class block extends Shape {

	private Image image;
	private GraphicsContext gc;

	public block(double width, double heightt, GraphicsContext gc) {
		image = imageFactory.getImageFactory().getImage("rock", 55, 55);
		this.state = Stored.getStoredInstance();
		this.gc = gc;

		setY(100);

		setState(FallingFromLeft.getFallingFromLeftInstance());
		setX(0);

		setSlope(width, heightt);

	}

	@Override
	public double centerX() {
		return x;
	}

	@Override
	public double centerY() {
		return y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		drawShape(gc);
	}

	@Override
	public void setY(double y) {
		this.y = y;
		drawShape(gc);
	}

	@Override
	public void drawShape(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

}
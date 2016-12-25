package shape;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import states.*;

public class ellipse extends Shape {
	private Random randomize = new Random();
	private Ellipse ellipseShape;
	private State state;
	private Color color;
	private double x;
	private double y;
	private Color[] colors = { Color.RED, Color.BLUE, Color.PINK, Color.ORANGE ,Color.GOLD };

	public ellipse() {
		Color c = colors[randomize.nextInt(colors.length)];
		this.color = c;
		ellipseShape = new Ellipse();
		ellipseShape.setCenterY(10.0);
		ellipseShape.setCenterX(10.0);

		ellipseShape.setRadiusX(25.0f);
		ellipseShape.setRadiusY(5.0f);
		ellipseShape.setStrokeWidth(2);
		ellipseShape.setStroke(Color.BLACK);
		ellipseShape.setFill(color);
	}
//
//	public ellipse getEllipse() {
//		return new ellipse();
//	}
	public void drawShape(GraphicsContext gc){
		gc.setFill(this.color);
		gc.fillOval(x - 25, y - 10.0 , 25.0, 5.0f);
	}
	public  Ellipse getShape(){
		return 	this.ellipseShape;
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x = x;
		this.ellipseShape.setCenterX(x);

	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
		this.ellipseShape.setCenterY(y);

	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return this.state;
	}

	@Override
	public void setState(State s) {
		// TODO Auto-generated method stub
		this.state = s;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

}

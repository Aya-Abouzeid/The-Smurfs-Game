package shape;

import java.io.Serializable;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.State;

public abstract class Shape implements shapeInt, Serializable {

	protected State state;
	protected Color color;
	protected int type;
	protected double x;
	protected double y;
	protected double height;
	protected float slope;
	protected Random randomize = new Random();
	protected Color[] colors = { Color.RED, Color.BLUE, Color.PINK, Color.CYAN, Color.GOLD, Color.BLUEVIOLET,
			Color.GREENYELLOW, Color.DEEPPINK, Color.BLACK, Color.DARKGREEN };

	public abstract void setX(double x);

	public abstract void setY(double y);

	public abstract void drawShape(GraphicsContext gc);
	
	public void increaseSlopedY(double width) {
		this.setY(this.getY() + 1);
		this.setX(state.increaseSlopedY(this.getY(), this.slope, width));
	}

	public void setState(State s) {
		this.state = s;
	}

	public void move(GraphicsContext gc, double shapeSpeed, double width) {
		
		this.state.move(this, gc, shapeSpeed, width);
	}

	public void setSlope(double screenWidth, double screenheight) {
		this.slope = state.setSlope(screenWidth, screenheight);
	}

	public int gettype() {
		return type;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public State getState() {
		return this.state;

	}

	public Color getColor() {
		return this.color;

	}

	public double getHeight() {
		return this.height;

	}

	public String getColorname() {
		if (color.equals(Color.RED)) {
			return "RED";
		}
		if (color.equals(Color.BLUE)) {
			return "BLUE";
		}
		if (color.equals(Color.PINK)) {
			return "PINK";
		}
		if (color.equals(Color.CYAN)) {
			return "CYAN";
		}
		if (color.equals(Color.GOLD)) {
			return "GOLD";
		}
		if (color.equals(Color.BLUEVIOLET)) {
			return "BLUEVIOLET";
		}
		if (color.equals(Color.GREENYELLOW)) {
			return "GREENYELLOW";
		}
		if (color.equals(Color.DEEPPINK)) {
			return "DEEPPINK";
		}
		if (color.equals(Color.BLACK)) {
			return "BLACK";
		}
		if (color.equals(Color.DARKGREEN)) {
			return "DARKGREEN";
		}
		return null;
	}

	public void update(double x) {
		setX(x);
	}
}
package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import states.*;


public class plate implements shapeInterface{
    private Polygon plate;
	private State state;
    private double x;
    private double y;
	private Double[] vertices = new Double[8];

    // --- you would send me 1 coordinate generated randomly and I should calculate the rest --- //
    public plate(Color color) {
        plate.getPoints().addAll(vertices);
        plate.setStrokeWidth(2);
        plate.setStroke(Color.BLACK);
        plate.setFill(color);
    }

    public Polygon getPlate() {
        return plate;
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
//	= { x, y, x+20.0, y+10.0, x+70.0, y+10.0, x+90.0, y};

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.vertices[0]= x;
		this.vertices[2]= x + 20.0;
		this.vertices[4]= x + 70.0;
		this.vertices[6]= x + 90.0;
		this.x = x;
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.vertices[1] = y;
		this.vertices[3] = y + 10.0;
		this.vertices[5] = y + 10.0;
		this.vertices[7] = y;
		this.y = y;
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

}

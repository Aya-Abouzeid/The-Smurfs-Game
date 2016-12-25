package shape;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import states.*;

public class plate extends Shape {
	private Random randomize = new Random();
	private Polygon platePolygon;
	private State state;
	private double x;
	private double y;
	private Color color;
	private Double[] vertices = { 0.0, 0.0, 20.0, 10.0, 70.0, 10.0, 90.0, 0.0};
	private double[] xVertices= {vertices[0], vertices[2],vertices[4],vertices[6]};
	private double[] yVertices= {vertices[1], vertices[3],vertices[5],vertices[7]};
	private Color[] colors = { Color.RED, Color.BLUE, Color.PINK, Color.ORANGE, Color.GOLD };

	// --- you would send me 1 coordinate generated randomly and I should
	// calculate the rest --- //
	public plate() {
		Color c = colors[randomize.nextInt(colors.length)];
		this.color = c;
		platePolygon = new Polygon();
		platePolygon.getPoints().addAll(vertices);
		platePolygon.setStrokeWidth(2);
		platePolygon.setStroke(Color.BLACK);
		platePolygon.setFill(color);
	}

//	public plate getPlate() {
//		return new plate();
//	}
	
	public void drawShape(GraphicsContext gc){
		gc.setFill(this.color);
		gc.fillPolygon(xVertices,
                yVertices,
                4);
	}
	public Polygon getShape(){
		return 	this.platePolygon;
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
	// = { x, y, x+20.0, y+10.0, x+70.0, y+10.0, x+90.0, y};

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.vertices[0] = x;
		this.vertices[2] = x + 20.0;
		this.vertices[4] = x + 70.0;
		this.vertices[6] = x + 90.0;
		this.xVertices[0] = x;
		this.xVertices[1] = x + 20.0;
		this.xVertices[2] = x + 70.0;
		this.xVertices[3] = x + 90.0;
		platePolygon.getPoints().addAll(vertices);
		this.x = x;
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.vertices[1] = y;
		this.vertices[3] = y + 10.0;
		this.vertices[5] = y + 10.0;
		this.vertices[7] = y;
		this.yVertices[0] = y;
		this.yVertices[1] = y + 10.0;
		this.yVertices[2] = y + 10.0;
		this.yVertices[3] = y;
		platePolygon.getPoints().addAll(vertices);
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

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

}

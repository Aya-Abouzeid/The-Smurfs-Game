package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import states.*;

public class ellipse implements shapeInterface{

    private Ellipse ellipse;
    private State state;
    private double x;
    private double y;

    // -- you would send CenterX and CenterY which are generated randomly -- //
    public ellipse(Color color) {

        ellipse = new Ellipse();
        {
            ellipse.setRadiusX(25.0f);
            ellipse.setRadiusY(5.0f);
        }

        ellipse.setStrokeWidth(2);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(color);
    }

    public Ellipse getEllipse() {
        return ellipse;
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
        ellipse.setCenterX(x);

	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
        ellipse.setCenterY(y);

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

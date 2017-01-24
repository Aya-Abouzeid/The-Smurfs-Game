package shape;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import states.State;
import states.Stored;

public class ellipse extends Shape implements Serializable,shapeInt  {
   private  Ellipse ellipseShape;
   private int type=1;
    public ellipse() {
        Color c = colors[randomize.nextInt(colors.length)];
        this.color = c;
        ellipseShape = new Ellipse();
        ellipseShape.setCenterY(10.0);
        ellipseShape.setCenterX(10.0);
        ellipseShape.setRadiusX(60.0);
        ellipseShape.setRadiusY(15.0);
        ellipseShape.setFill(color);
        this.state = Stored.getStoredInstance();
        this.height = 28.0f;
    }

    @Override
   public void move(GraphicsContext gc, double shapeSpeed,double width) {
        this.state.move(this, gc, shapeSpeed,width);
   }
    @Override
    public int gettype(){
 	   return type;
    }
    @Override
    public void setSlope(double screenWidth, double screenheight) {
      this.slope = state.setSlope(screenWidth, screenheight);
    }

    @Override
    public void increaseSlopedY(double width) {
        this.setY(this.getY() + 1);
       this.setX(state.increaseSlopedY(this.getY(), this.slope,width));
    }

    @Override
    public void drawShape(GraphicsContext gc) {
      gc.setFill(this.color);
        gc.fillOval(x - 25, y - 10.0, 60.0, 25.0f);
    }

    @Override
    public Ellipse getShape() {
        return this.ellipseShape;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
   this.ellipseShape.setCenterX(x);
    }

    @Override
    public void setY(double y) {
        this.y = y;
   this.ellipseShape.setCenterY(y);
    }

    @Override
   public State getState() {
   return this.state;

    }

    @Override
    public void setState(State s) {
       this.state = s;
    }

    @Override
    public Color getColor() {
       return this.color;

    }

    @Override
    public double getHeight() {
    return this.height;

    }

    @Override
    public double centerX() {
        return getX();
    }

    @Override
    public double centerY() {
       return getY();
    }

	@Override
	public String getColorname() {
		if(color.equals(Color.RED)){
			return "RED";
		}
		if(color.equals(Color.BLUE)){
			return "BLUE";
		}
		if(color.equals(Color.PINK)){
			return "PINK";
		}
		if(color.equals(Color.CYAN)){
			return"CYAN";
		}
		if(color.equals(Color.GOLD)){
			return "GOLD";
		}
		if(color.equals(Color.BLUEVIOLET)){
			return "BLUEVIOLET";
		}
		if(color.equals(Color.GREENYELLOW)){
			return "GREENYELLOW";
		}
		if(color.equals(Color.DEEPPINK)){
			return "DEEPPINK";
		}
		if(color.equals(Color.BLACK)){
			return "BLACK";
		}
		if(color.equals(Color.DARKGREEN)){
			return "DARKGREEN";
		}
		return null;
	}

    @Override
    public void update(double x) {
        setX(x);
    }
}
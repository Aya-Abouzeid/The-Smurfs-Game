package shape;
 
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
 
import factories.imageFactory;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import states.FallingFromLeft;
import states.State;
 
public abstract class Shape implements shapeInt,Serializable  {
 
    protected  State state;
    protected Color color;
    protected double x;
    protected double y;
    protected double height;
    protected float slope;
    protected Random randomize = new Random();
    protected Color[] colors = { Color.RED, Color.BLUE, Color.PINK, Color.CYAN, Color.GOLD, Color.BLUEVIOLET,
            Color.GREENYELLOW, Color.DEEPPINK, Color.BLACK, Color.DARKGREEN };
 
 
	 public abstract double getX();
 
 
	 public abstract void move(GraphicsContext gc , double shapeSpeed,double width);
 
 
	 public abstract  double getY();
 
 
	 public abstract void setX(double x);
 
 
	 public abstract void setY(double y);
 
 
	 public abstract  State getState();
 
	 public abstract  int gettype();
 
	 public abstract  void setSlope(double screenWidth, double screenheight);
 
 
	 public abstract  void setState(State s);
 
 
	 public abstract  Color getColor();
 
	 public abstract  String  getColorname();
 
	 public  abstract void increaseSlopedY(double width) ;
 
 
	 public abstract  javafx.scene.shape.Shape getShape();
 
 
	 public abstract  void drawShape(GraphicsContext gc);
 
 
	 public abstract  double getHeight();
}
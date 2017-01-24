package shape;

import java.io.Serializable;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import observer.observerInterface;
import states.State;

public abstract class Shape implements shapeInt, Serializable, observerInterface {

    protected State state;
    protected Color color;
    protected double x;
    protected double y;
    protected double height;
    protected float slope;
    protected Random randomize = new Random();
    protected Color[] colors = { Color.RED, Color.BLUE, Color.PINK, Color.CYAN, Color.GOLD, Color.BLUEVIOLET,
            Color.GREENYELLOW, Color.DEEPPINK, Color.BLACK, Color.DARKGREEN };

    @Override
    public abstract double getX();

    @Override
    public abstract void move(GraphicsContext gc, double shapeSpeed, double width);

    @Override
    public abstract double getY();

    @Override
    public abstract void setX(double x);

    @Override
    public abstract void setY(double y);

    @Override
    public abstract State getState();

    public abstract int gettype();

    @Override
    public abstract void setSlope(double screenWidth, double screenheight);

    @Override
    public abstract void setState(State s);

    @Override
    public abstract Color getColor();

    public abstract String getColorname();

    @Override
    public abstract void increaseSlopedY(double width);

    @Override
    public abstract javafx.scene.shape.Shape getShape();

    @Override
    public abstract void drawShape(GraphicsContext gc);

    @Override
    public abstract double getHeight();
}
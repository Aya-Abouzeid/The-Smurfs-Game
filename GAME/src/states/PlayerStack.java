package states;

import java.util.Stack;

import shape.Shape;
import shape.shapeInt;

public class PlayerStack {

    private double hight;
    public Stack<shapeInt> stack;

    public PlayerStack(double hight) {
        stack = new Stack<shapeInt>();
        this.hight = hight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public void add(Shape shape) {
        stack.add(shape);
       // setHight(getHight() + shape.getHeight());
    }

}

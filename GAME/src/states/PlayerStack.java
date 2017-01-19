package states;

import java.util.Stack;

import observer.positionHandler;
import shape.Shape;
import shape.shapeInt;

public class PlayerStack {

    private StackState state;
    private double hight;
    public Stack<shapeInt> stack;
   public positionHandler PH = new positionHandler();

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
        stack.push(shape);
        setHight(getHight() + shape.getHeight());
        PH.registerObserver(shape);
    }

    public void removeThree() {
       //remove from stack and from observers --- back to the poll
    }

    public void notifyStacks(){

    }

}

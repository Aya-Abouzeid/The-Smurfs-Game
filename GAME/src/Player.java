import java.util.Stack;

import shape.Shape;

public class Player {

    public String filepath;
    public double hight; // photo Hight
    private double rightStackHight;
    private double leftStackHight;
    private Stack<Shape> rightStack;
    private Stack<Shape> leftStack;

    public Player(String imagePath) {
        this.filepath = imagePath;
        rightStack = new Stack<Shape>();
        leftStack = new Stack<Shape>();
    }

    public void addToRightStack(Shape shape) {
        if (shape != null)
            rightStack.add(shape);
    }

    public void addToLeftStack(Shape shape) {
        if (shape != null)
            leftStack.add(shape);
    }

    public void popLeftStack() {
        for (int i = 0; i < 2; i++)
            leftStack.pop();
    }

    public void popRightStack() {
        for (int i = 0; i < 2; i++)
            rightStack.pop();
    }

    public double getRightStackHight() {
        return rightStackHight;
    }

    public void setRightStackHight(double Hight) {
        this.rightStackHight = Hight;
    }

    public double getLeftStackHight() {
        return leftStackHight;
    }

    public void setLeftStackHight(double Hight) {
        this.leftStackHight = Hight;
    }

}

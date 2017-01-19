package observer;

import java.util.Stack;

import shape.Shape;

public class positionHandler {

    // --- Singleton and send the 4 stacks every time or create 4 position handlers keeping track of the observers

    //private double positionX;
    private Stack<Shape> observers;

    public positionHandler() {
        observers = new Stack<Shape>();
    }

    public void registerObserver(Shape o) {
        observers.push(o);
    }

    public void removeObserver(Shape o) {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

//    public void positionChanged() {
//        notifyObservers();
//    }

    public void notifyObservers(double x, int s) {
        if(s == 0)
            for (Shape crnt : observers)
                crnt.setX(x);
        else
            for (Shape crnt : observers)
                crnt.setX(x + 170);
    }

//    public void setPosition(double newX) {
//        this.positionX = newX;
//        //positionChanged();
//    }
//
//    public double getPositionX() {
//        return positionX;
//    }

}

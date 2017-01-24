package observer;

import java.util.Stack;

import logs.Logs;
import shape.Shape;

public class positionHandler {

    private Stack<Shape> observers;

    public positionHandler() {
        observers = new Stack<Shape>();
    }

    public void registerObserver(Shape o) {
        Logs.log("new shape is added to observers", "debug");
        observers.push(o);
    }

    public void removeObserver(Shape o) {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    public void notifyObservers(double x, int s) {
        Logs.log("observers are moving", "debug");
        if (s == 0)
            for (Shape crnt : observers)
                crnt.update(x);
        else
            for (Shape crnt : observers)
                crnt.update(x + 185);
    }

    public void createObserverList(Shape[] r) {
        for (int i = 0; i < r.length; i++) {
            this.observers.push(r[i]);
        }
    }
}

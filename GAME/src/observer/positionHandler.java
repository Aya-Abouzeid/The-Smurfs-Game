package observer;

import java.util.Stack;

public class positionHandler {

    // --- Singleton and send the 4 stacks every time or create 4 position handlers keeping track of the observers

    private double positionX;
    private Stack<Observer> observers;

    public positionHandler() {
        observers = new Stack<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.push(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    public void positionChanged() {
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer crnt : observers)
            crnt.update(positionX);

    }

    public void setPosition(double newX) {
        this.positionX = newX;
        positionChanged();
    }

    public double getPositionX() {
        return positionX;
    }

}

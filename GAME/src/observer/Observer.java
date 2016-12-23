package observer;

public class Observer implements observerInterface{

    double newX;

    @Override
    public void update(double x) {
        newX = x;
        display();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub

    }

}

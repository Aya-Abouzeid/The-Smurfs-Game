package player;
import java.util.LinkedList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import observer.positionHandler;
import shape.Shape;
import states.PlayerStack;

public class Player {

    public ImageView imageView;
    private static final int CHARHIGHT = 330;
    private double positionX;
    private double positionY;
    public LinkedList<PlayerStack> Stacks;
    private boolean mouseControl;
    private KeyCode leftButton;
    private KeyCode rightButton;
    private positionHandler PH;


    public Player(Image image, boolean mouseControl) {
        imageView = new ImageView(image);
        this.mouseControl = mouseControl;
        Stacks =  new LinkedList<states.PlayerStack>();
        Stacks.add(new PlayerStack(CHARHIGHT));
        Stacks.add(new PlayerStack(CHARHIGHT));
    }

//    public void positionChanged(){
//        notifyStacks();
//    }

    private void notifyStacks(){
        for(PlayerStack crnt : Stacks)
           crnt.PH.notifyObservers(positionX);

    }

    public void addToStacks(Shape shape, int i) {
        if (shape != null)
            Stacks.get(i).add(shape);
    }

//    public void addToLeftStack(Shape shape) {
//        if (shape != null)
//            leftStack.add(shape);
//    }
//
//    public void popLeftStack() {
//        for (int i = 0; i < 2; i++)
//            leftStack.pop();
//    }
//
//    public void popRightStack() {
//        for (int i = 0; i < 2; i++)
//            rightStack.pop();
//    }
//
//    public double getRightStackHight() {
//        return rightStackHight;
//    }
//
//    public void setRightStackHight(double Hight) {
//        this.rightStackHight = Hight;
//    }
//
//    public double getLeftStackHight() {
//        return leftStackHight;
//    }
//
//    public void setLeftStackHight(double Hight) {
//        this.leftStackHight = Hight;
//    }

    public double getX() {
        return positionX;
    }
    public void setX(double x) {
    	imageView.setX(x);
    	positionX = x;
    	notifyStacks();
    }

    public double getY() {
        return positionY;
    }
    public void setY(double y) {
    	imageView.setY(y);
    	positionY = y;
    }

    public void MoveByKey(double speed) {
    	setX(getX() + speed);
    	notifyStacks();
    }

    public void setRightButton(KeyCode button) {
    	this.rightButton = button;
    }

    public void setLeftButton(KeyCode button) {
    	this.leftButton = button;
    }

    public ImageView getImageView() {
    	return imageView;
    }

    public boolean getMouseControl() {
    	return mouseControl;
    }

    public KeyCode getLeftButton() {
    	return leftButton;
    }
    public KeyCode getrightButton() {
    	return rightButton;
    }

}

package states;
import java.util.Stack;

import shape.Shape;


public class myStack {
State2 currentState;
State2 Different;
State2 Same;
Stack shapes =new Stack();
public myStack(Stack stack){
	Different =new Different(this);
	Same=new Same(this);
	this.shapes=stack;
    this.currentState=Different;
}
public void set(State2 newState){
	currentState=newState;
}
public State2 getDifferent(){
	return Different;
}
public State2 getSame(){
	return Same;
}


private boolean sameShapes(Shape shape) {
	Shape shape1=(Shape) shapes.pop();
	Shape shape2=(Shape) shapes.pop();
	shapes.push(shape2);
	shapes.push(shape1);
	if(shape.getColor().equals(shape1.getColor())&&shape.getColor().equals(shape2.getColor())){
		return true;
	}
	return false;
}
public Stack insert(Shape shape){
	if(sameShapes(shape)){
		currentState=Same;
		}
		else{
			currentState=Different;
		}

	return currentState.insert(shape);
}


}

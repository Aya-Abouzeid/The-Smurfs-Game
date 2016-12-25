package states;

import java.util.Stack;

import shape.Shape;

public class Same implements State2{
	myStack stack;
    public Same(myStack stack) {
		this.stack=stack;
	}
	@Override
	public Stack insert(Shape shape) {
		stack.shapes.push(shape);
		for(int i=0;i<3;i++){
		stack.shapes.pop();
		}
		//increase score scene 
		return stack.shapes;
	}

}

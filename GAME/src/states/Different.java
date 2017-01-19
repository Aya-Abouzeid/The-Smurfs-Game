package states;

import java.util.Stack;

import shape.Shape;

public class Different implements StackState {
	myStack stack;
     public Different(myStack stack) {
		this.stack=stack;
	}
	@Override
	public Stack insert(Shape shape) {
		stack.shapes.push(shape);
		return stack.shapes;
	}

}

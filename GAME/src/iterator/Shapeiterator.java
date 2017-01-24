package iterator;
 
import java.util.ArrayList;
 
import shape.Shape;
 
public class Shapeiterator implements Iterator {
   ArrayList<Shape> shapes=new ArrayList<>();
   int current=-1;
    public Shapeiterator( ArrayList<Shape> shape) {
		this.shapes=shape;
	}
	@Override
	public boolean hasNext() {
	    if(current>=shapes.size()-1){
		return false;
		}
	    return true;
 
	}
 
	@Override
	public Object Next() {
 
		current++;
		return shapes.get(current);
	}
 
}
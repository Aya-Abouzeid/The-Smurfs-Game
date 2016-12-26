package snapshot;
import java.io.IOException;
import java.util.ArrayList;

import save.save2;
import shape.Shape;
public class Caretaker {
public ArrayList< Memento> savedShapes=new ArrayList<Memento>();
save2 b=new save2();
public void addMemento (Memento memento){
	savedShapes.add(memento);
}
public Memento getMemento(int index) throws IOException{
	if(this.savedShapes.size()==0||index==-1){

		Shape[] r=(Shape[]) b.load();
        Memento g=new Memento(r);
        savedShapes.add(g);
        index=0;
	}
	return savedShapes.get(index);
}



}

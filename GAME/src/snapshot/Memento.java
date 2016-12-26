package snapshot;

import java.io.IOException;

import save.save2;
import shape.Shape;

public class Memento {
private Shape[] shapes;
save2 save=new save2();
public Memento(Shape[]shapes) throws IOException{
	save.save(shapes);
	this.shapes=shapes;
}
public Shape[] getSavedshapes() throws IOException{

	return (Shape[]) save.load();
}
}

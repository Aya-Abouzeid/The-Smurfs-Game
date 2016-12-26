package snapshot;

import java.io.IOException;

import shape.Shape;

public class Originator {
	private Shape[] shapes;
	public void set(Shape[]shapes){
	this.shapes=shapes;
	}
	public Memento storeInMemento() throws IOException{
		return new Memento(this.shapes);
	}
	public Shape[] restoreFromMemento(Memento memento) throws IOException{
		shapes=memento.getSavedshapes();
		return shapes;

	}
}

package snapshot;

import java.io.IOException;

import shape.Shape;

public class Snapshot {
    private Caretaker p = new Caretaker();
    private Originator b = new Originator();

    public void takeshot(Shape[] v) throws IOException {
        b.set(v);
        p.addMemento(b.storeInMemento());
    }

    public Shape[] getsnapshot() throws IOException {
        return b.restoreFromMemento(p.getMemento(p.savedShapes.size() - 1));
    }

}

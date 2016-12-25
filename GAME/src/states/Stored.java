package states;

public class Stored extends State{

	private static Stored stored = null;

	private Stored() {

	}

	public static Stored getStoredInstance() {

		if (stored == null) {
			return stored = new Stored();
		}

		return stored;
	}
    @Override
    public void dequeue() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCaught() {
        // TODO Auto-generated method stub
    	return false;
    }

    @Override
    public void isOnGround() {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkFalse() {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkTrue() {
        // TODO Auto-generated method stub

    }

}

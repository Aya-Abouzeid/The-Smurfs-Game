package states;

import factories.sceneFactory;

public class Caught extends State {

	private static Caught caught = null;

	private Caught() {

	}

	public static Caught getcaughtInstance() {

		if (caught == null) {
			return caught = new Caught();
		}

		return caught;
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCaught() {
		// TODO Auto-generated method stub
		return true;
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

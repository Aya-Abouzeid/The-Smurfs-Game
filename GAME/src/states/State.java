package states;

public abstract class State {
	abstract public void dequeue();
	abstract public boolean isCaught();
	abstract public void isOnGround();
	abstract public void checkFalse();
	abstract public void checkTrue();
}

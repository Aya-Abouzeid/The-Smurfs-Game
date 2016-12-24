package states;

public interface State {

    public void dequeue();
    public void isCaught();
    public void onGround();
    public void checkFalse();
    public void checkTrue();
}

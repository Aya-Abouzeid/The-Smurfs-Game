package states;

public class Falling extends State{
	private static Falling falling = null;

private Falling(){
		
	}
	
	public static Falling getFallingInstance(){
		
		if(falling == null){
			return falling = new Falling();
		}
		
		return falling;
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

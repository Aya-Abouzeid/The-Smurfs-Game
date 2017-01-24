package iterator;
 
import java.util.ArrayList;
import java.util.LinkedList;
 
import player.Player;
import shape.Shape;
 
public class PlayerIterator implements Iterator {
	LinkedList<Player> players=new LinkedList<>();
	   int current=-1;
	    public PlayerIterator( LinkedList<Player> player) {
			this.players=player;
		}
		@Override
		public boolean hasNext() {
		    if(current>=players.size()-1){
			return false;
			}
		    return true;
 
		}
 
		@Override
		public Object Next() {
 
			current++;
			return players.get(current);
		}
 
}
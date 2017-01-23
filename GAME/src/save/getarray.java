package save;

import java.util.ArrayList;

import player.Player;
import shape.Shape;

public class getarray {
public Shape[] getShapeArray(ArrayList<Shape>shape){
    return (Shape[]) shape.toArray();

}
public Player[] getPlayerArray(ArrayList<Player>player){
    return (Player[]) player.toArray();
}
}

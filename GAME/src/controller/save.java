package controller;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
import player.BuildPlayerProxy;
import player.Player;
import player.PlayerProxy;
import save.getarray;
import shape.BuildShapeProxy;
import shape.ShapeProxy;
import snapshot.Memento;
 
public class save {
	private getarray array=new getarray();
	private BuildShapeProxy r=new BuildShapeProxy();
	private BuildPlayerProxy r2=new BuildPlayerProxy();
	private int time[]=new int[7];
	public void save(Memento snapshot) {
		time[0]=snapshot.getCounter();
		time[1]=snapshot.getMinutes();
		time[2]=snapshot.getSeconds();
		time[3]=(int) snapshot.getPlayers().get(0).Stacks.get(0).getHight();
		time[4]=(int) snapshot.getPlayers().get(0).Stacks.get(1).getHight();
		time[5]=(int) snapshot.getPlayers().get(1).Stacks.get(0).getHight();
		time[6]=(int) snapshot.getPlayers().get(1).Stacks.get(1).getHight();
		try
	      {
	     FileOutputStream fileOut1 = new FileOutputStream("car1");//creates a card serial file in output stream
	     FileOutputStream fileOut2 = new FileOutputStream("car2");
	     FileOutputStream fileOut3 = new FileOutputStream("car3");
	     FileOutputStream fileOut4 = new FileOutputStream("car4");
	     FileOutputStream fileOut5 = new FileOutputStream("car5");
	     FileOutputStream fileOut6 = new FileOutputStream("car6");
	     FileOutputStream fileOut7 = new FileOutputStream("car7");
	     FileOutputStream fileOut8 = new FileOutputStream("car8");
 
//	     FileOutputStream fileOut2 = new FileOutputStream("car2");
	     ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);//routs an object into the output stream.
	     ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
	     ObjectOutputStream out3 = new ObjectOutputStream(fileOut3);
	     ObjectOutputStream out4 = new ObjectOutputStream(fileOut4);
	     ObjectOutputStream out5 = new ObjectOutputStream(fileOut5);
	     ObjectOutputStream out6 = new ObjectOutputStream(fileOut6);
	     ObjectOutputStream out7 = new ObjectOutputStream(fileOut7);
	     ObjectOutputStream out8 = new ObjectOutputStream(fileOut8);
 
//	     ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
	     out1.writeObject(r.create(array.getShapeArray(snapshot.getShapes())));// we designate our array of cards to be routed
	     out2.writeObject(r.create(array.getShape(snapshot.getPlayers().get(0).Stacks.get(0).stack)));
	     out3.writeObject(r.create(array.getShape(snapshot.getPlayers().get(0).Stacks.get(1).stack)));
	     out4.writeObject(r.create(array.getShape(snapshot.getPlayers().get(1).Stacks.get(0).stack)));
	     out5.writeObject(r.create(array.getShape(snapshot.getPlayers().get(1).Stacks.get(1).stack)));
	     out6.writeObject(r2.create(snapshot.getPlayers().get(0),0));
	     out7.writeObject(r2.create(snapshot.getPlayers().get(1),1));
	     out8.writeObject(this.time);
//	     out2.writeObject(snapshot.players.get(1));
	     out1.close();// closes the data paths
	     out2.close();
	     out3.close();
	     out4.close();
	     out5.close();
	     out6.close();
	     out7.close();
	     out8.close();
//	     out2.close();
	     fileOut1.close();// closes the data paths
	     fileOut2.close();
	     fileOut3.close();
	     fileOut4.close();
	     fileOut5.close();
	     fileOut6.close();
	     fileOut7.close();
	     fileOut8.close();
//	     fileOut2.close();
	  }catch(IOException i)//exception stuff
	  {
	      i.printStackTrace();
	}
 
	}
	public Object load1(){
	try// If this doesnt work throw an exception
    {
    FileInputStream fileIn1 = new FileInputStream("car1");// Read serial file.
    FileInputStream fileIn2 = new FileInputStream("car2");
    FileInputStream fileIn3 = new FileInputStream("car3");
    FileInputStream fileIn4 = new FileInputStream("car4");
    FileInputStream fileIn5 = new FileInputStream("car5");
    FileInputStream fileIn6 = new FileInputStream("car6");
    FileInputStream fileIn7 = new FileInputStream("car7");
 
//    FileInputStream fileIn2 = new FileInputStream("car2");
    ObjectInputStream in1 = new ObjectInputStream(fileIn1);// input the read file.
    ObjectInputStream in2 = new ObjectInputStream(fileIn2);
    ObjectInputStream in3 = new ObjectInputStream(fileIn3);
    ObjectInputStream in4 = new ObjectInputStream(fileIn4);
    ObjectInputStream in5 = new ObjectInputStream(fileIn5);
 //   ObjectInputStream in2 = new ObjectInputStream(fileIn2);
    ShapeProxy[][]b=new ShapeProxy[5][1];
    b[0] =(ShapeProxy[]) in1.readObject();// allocate it to the object file already instanciated.
    b[1] =(ShapeProxy[]) in2.readObject();
    b[2] =(ShapeProxy[]) in3.readObject();
    b[3] =(ShapeProxy[]) in4.readObject();
    b[4] =(ShapeProxy[]) in5.readObject();
//    Player b2 =(Player) in2.readObject();
//   Player b[]=new Player[2];
//   b[0]=b1;
//   b[1]=b2;
   in1.close();//closes the input stream.
   in2.close();
   in3.close();
   in4.close();
   in5.close();
 //  in2.close();
   fileIn1.close();//closes the file data stream.
   fileIn2.close();
   fileIn3.close();
   fileIn4.close();
   fileIn5.close();
 //    fileIn2.close();
       return b;
   }catch(IOException i)//exception stuff
   {
       i.printStackTrace();
       return null;
   }catch(ClassNotFoundException c)//more exception stuff
   {
       System.out.println("Error");
       c.printStackTrace();
       return null;
   }
	}
	public Object load2(){
	try// If this doesnt work throw an exception
    {
    FileInputStream fileIn6 = new FileInputStream("car6");// Read serial file.
    FileInputStream fileIn7 = new FileInputStream("car7");
 
//    FileInputStream fileIn2 = new FileInputStream("car2");
    ObjectInputStream in6 = new ObjectInputStream(fileIn6);
    ObjectInputStream in7 = new ObjectInputStream(fileIn7);
 //   ObjectInputStream in2 = new ObjectInputStream(fileIn2);
    PlayerProxy[]b=new PlayerProxy[2];
    b[0] =(PlayerProxy) in6.readObject();// allocate it to the object file already instanciated.
    b[1] =(PlayerProxy) in7.readObject();
 
//    Player b2 =(Player) in2.readObject();
//   Player b[]=new Player[2];
//   b[0]=b1;
//   b[1]=b2;
   in6.close();
   in7.close();
 //  in2.close();
   fileIn6.close();
   fileIn7.close();
 //    fileIn2.close();
       return b;
   }catch(IOException i)//exception stuff
   {
       i.printStackTrace();
       return null;
   }catch(ClassNotFoundException c)//more exception stuff
   {
       System.out.println("Error");
       c.printStackTrace();
       return null;
   }
	}
	public Object load3(){
	try// If this doesnt work throw an exception
    {
    FileInputStream fileIn8 = new FileInputStream("car8");// Read serial file.
 
 
//    FileInputStream fileIn2 = new FileInputStream("car2");
    ObjectInputStream in8 = new ObjectInputStream(fileIn8);
 
 //   ObjectInputStream in2 = new ObjectInputStream(fileIn2);
int[] h=(int[]) in8.readObject();    
//    Player b2 =(Player) in2.readObject();
//   Player b[]=new Player[2];
//   b[0]=b1;
//   b[1]=b2;
   in8.close();
 
 //  in2.close();
   fileIn8.close();
 
 //    fileIn2.close();
       return h;
   }catch(IOException i)//exception stuff
   {
       i.printStackTrace();
       return null;
   }catch(ClassNotFoundException c)//more exception stuff
   {
       System.out.println("Error");
       c.printStackTrace();
       return null;
   }
	}
}
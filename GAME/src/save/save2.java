package save;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shape.Shape;
import snapshot.Memento;

public class save2 {
public void save(Memento snapshot) throws IOException{
	 GsonBuilder builder = new GsonBuilder();
     builder.registerTypeAdapter(Shape.class, new InterfaceAdapter());
     Gson r = builder.create();
    String carsJsonFormat =r.toJson(v, Shape[].class);
	 FileWriter file = null;
	try {

	    switch (type){
	    case 1:
		file = new FileWriter("card1");break;
	    case 2:
	    file = new FileWriter("card2");break;
	    case 3:
	    file = new FileWriter("card3");break;
	    case 4:
	    file = new FileWriter("card4");break;
	    case 5:
	    file = new FileWriter("card5");break;
        default:break;

	    }
	} catch (IOException e) {
		e.printStackTrace();
	}
     file.write(carsJsonFormat);
     file.close();
}

public Object load() throws IOException{
	 GsonBuilder builder = new GsonBuilder();
     builder.registerTypeAdapter(Shape.class, new InterfaceAdapter());
     Gson r = builder.create();
     BufferedReader br=null;
     switch (type){
     case 1:
         br = new BufferedReader(new FileReader("card1"));
     case 2:
         br = new BufferedReader(new FileReader("card2"));
     case 3:
         br = new BufferedReader(new FileReader("card3"));
     case 4:
         br = new BufferedReader(new FileReader("card4"));
     case 5:
         br = new BufferedReader(new FileReader("card5"));
     default:break;

     }

    String carsJsonFormat=br.readLine();
    Shape [] carJsonArray = r.fromJson(carsJsonFormat, Shape[].class);
    return carJsonArray;
}
}

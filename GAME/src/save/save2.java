package save;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shape.Shape;

public class save2 {
public void save(Shape[] v) throws IOException{
	 GsonBuilder builder = new GsonBuilder();
     builder.registerTypeAdapter(Shape.class, new InterfaceAdapter());
     Gson r = builder.create();
    String carsJsonFormat =r.toJson(v, Shape[].class);
	 FileWriter file = null;
	try {
		file = new FileWriter("card");
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
	BufferedReader br = new BufferedReader(new FileReader("card"));
    String carsJsonFormat=br.readLine();
    Shape [] carJsonArray = r.fromJson(carsJsonFormat, Shape[].class);
    return carJsonArray;
}
}

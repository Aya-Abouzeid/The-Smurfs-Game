package factories;

import java.io.File;

import javafx.scene.image.Image;

public class imageFactory {
	
	private static imageFactory imgFactory;

	private imageFactory() {

	}

	public static imageFactory getImageFactory() {

		if (imgFactory == null) {
			return imgFactory = new imageFactory();
		}

		return imgFactory;
	}
	
	public Image getImage(String name) {
		File file;
		switch(name) {
		case "galaxy":
			return new Image("file:try2.png");//galaxy
		case "smurfette":
			 file = new File ("2.png");
			return new Image(file.toURI().toString());//smurfette
		case "new game":
			return new Image("file:NEWGAME");
		case "smurff":
			 file = new File ("1.png");
			return new Image(file.toURI().toString());//smurfette
		default: 
			return null;
		}
	}

}

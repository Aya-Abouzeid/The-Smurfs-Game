package controller;


import javafx.application.Application;
import layouts.View;
public class controllerSingleton {

	private static controllerSingleton controller;
	private String[] args;
	private static View view;
	private eventHandler handler;
	
	private controllerSingleton (String[] args) {
		this.args = args;
		view = new View();
		handler = eventHandler.getInstance();
		handler.setView(view);
	}
	
	public static controllerSingleton getInstance(String[] args) {
		if (controller == null){
			controller = new controllerSingleton(args); 
			return controller;
		}
		return controller;
 	}
	
	
	public void startGame(){
		////Dynamic loading all Classes 
		Application.launch(View.class, args);
				
	}
	
	
	public static void main(String[] args) {
		controllerSingleton.getInstance(args).startGame();
	}
	
}
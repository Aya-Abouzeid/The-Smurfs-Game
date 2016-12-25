package controller;


import factories.sceneFactory;
import javafx.application.Application;
import layouts.View;
import layouts.layout;

public class controllerSingleton {

	private static controllerSingleton controller;
	private String[] args;
	private layout currentLayout;
	private sceneFactory layoutFactory;
	private String layoutName;
	private static View view;
	private eventHandler handler;
	
	private controllerSingleton (String[] args) {
		this.args = args;
		layoutFactory = sceneFactory.getSceneFactory();
		view = new View();
		layoutName = "MainMenu";
		handler = eventHandler.getInstance();
		handler.setView(view);
		handler.setArgs(args);
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

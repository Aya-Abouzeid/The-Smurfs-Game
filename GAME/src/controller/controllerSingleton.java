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
	
	
	private controllerSingleton (String[] args) {
		this.args = args;
		layoutFactory = sceneFactory.getSceneFactory();
		view = new View();
		layoutName = "MainMenu";
	}
	
	public static controllerSingleton getInstance(String[] args) {
		if (controller == null){
			return new controllerSingleton(args);
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

package factories;

import javafx.scene.Scene;

public class sceneFactory {

	private static sceneFactory sceneFactory;
	
	private sceneFactory(){
		
	}
	
	public static sceneFactory getSceneFactory(){
		
		if(sceneFactory == null){
			return sceneFactory = new sceneFactory();
		}
		
		return sceneFactory;
	}
	//not finisheds
	public Scene getScene(String sceneName){
		Scene s = null;
		switch(sceneName){
		
		}
		return s;
	}
	
	
	
}

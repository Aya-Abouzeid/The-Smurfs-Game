package factories;


public class sceneFactory {

	private sceneFactory sceneFactory;
	
	private sceneFactory(){
		
	}
	
	protected sceneFactory getSceneFactory(){
		
		if(sceneFactory == null){
			return sceneFactory = new sceneFactory();
		}
		
		return sceneFactory;
	}
	
//	protected Scene getScene(){
//		
//		return new Scene();
//	}
	
	
	
}

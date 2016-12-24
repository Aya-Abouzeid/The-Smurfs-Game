package factories;

public class shapeFactory {

	private shapeFactory shapeFactory;
	
	private shapeFactory(){
		
	}
	
	protected shapeFactory getShapeFactory(){
		
		if(shapeFactory == null){
			return shapeFactory = new shapeFactory();
		}
		
		return shapeFactory;
	}
	//not finshed
	//will randomize shape


}

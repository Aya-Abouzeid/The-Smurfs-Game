package factories;

import button.button;
public class buttonFactory {

	private buttonFactory btnFactory;

	private buttonFactory(){

	}

	protected buttonFactory getButtonFactory(){

		if(btnFactory == null){
			return btnFactory = new buttonFactory();
		}

		return btnFactory;
	}
	//not finished
	protected button getButton(){

		return new button();
	}

}

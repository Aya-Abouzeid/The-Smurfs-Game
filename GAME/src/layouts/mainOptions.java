package layouts;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class mainOptions extends layout{

	Group root = new Group();
	
	public mainOptions(double height, double width) {
		super(height, width);
		VBox vbox = new VBox();
		vbox.getChildren().add(factory.getButton("Main Menu").getButton());
		vbox.setAlignment(Pos.CENTER);
		root.getChildren().add(vbox);
		addLevel ();
		scene = new Scene(root,windowWidth, windowHeight);
	}
	private void addKeyControls() {
		final ToggleGroup group = new ToggleGroup();
	    RadioButton button1 = new RadioButton("player1 with keyBoard and player2 with mouse");
	    button1.setToggleGroup(group);
	    button1.setSelected(true);
	    RadioButton button2 = new RadioButton("player2 with keyBoard and player1 with mouse");
	    button2.setToggleGroup(group);
	    
	    VBox vbox = new VBox(button1, button2);
	    root.getChildren().add(vbox);
	  }
	private void addLevel() {
		final ToggleGroup group = new ToggleGroup();
		RadioButton button;
		String current = handler.getOptions().getGameStrategy();
		String[] names = {"easy", "medium", "difficult"};
		for (int i = 0; i < 3; i++) {
			String key = names[i];
			 button = new RadioButton("easy");
		    button.setUserData("easy");
		    button.setToggleGroup(group);
		    button.setSelected(current.equals(key));	
		}
	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	        public void changed(ObservableValue<? extends Toggle> ov,
	            Toggle old_toggle, Toggle new_toggle) {
	          if (group.getSelectedToggle() != null) {
	        	  handler.setLevel(group.getSelectedToggle().getUserData().toString());
	          }
	        }
	      });
	    root.getChildren().add(vbox);
	  }

}

package button;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/*
 * LESAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 */
public class ReturnToPause extends button {

    private final String ButtonName = "Back";

    @Override
    public void setAction() {
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                handler.GameOptionsReturn();
            }
        });
    }

    @Override
    public void setName() {
        b.setText(ButtonName);
    }
}

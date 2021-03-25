package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    public TextField msgField;

    public TextArea mainText;

    public void clickBtn() {
        if (!msgField.getText().isEmpty()){
            mainText.appendText(msgField.getText()+"\n");
            msgField.clear();
        }

    }
}

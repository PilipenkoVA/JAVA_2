package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextArea mainText;
    @FXML
    public TextField msgField;


    public void clickBtn() {
        if (!msgField.getText().isEmpty()){
            mainText.appendText(msgField.getText()+"\n");
            msgField.clear();
        }
    }
}

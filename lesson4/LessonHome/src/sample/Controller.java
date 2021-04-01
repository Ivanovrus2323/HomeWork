package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
  @FXML
    TextArea textArea;

  @FXML
    TextField textField;

  @FXML
    void sendMsg() {
      textArea.appendText(" " + textField.getText());
      textField.clear();
      textField.requestFocus();
  }
}

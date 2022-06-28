package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class iterResultController {
    double result;
    @FXML
    private Button homeBtn;
    @FXML
    private TextField iterResult;

    public void transferDate(Double resultIter){
        this.result = resultIter;
        iterResult.setText(String.valueOf(resultIter));
    }
    @FXML
    void initialize(){
        homeBtn.setOnAction(event -> {
            try {
                Main.openAnotherWindow("mainWindow.fxml");
                homeBtn.getScene().getWindow().hide();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

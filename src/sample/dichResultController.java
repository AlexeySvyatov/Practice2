package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class dichResultController {
    double result;
    @FXML
    private Button homeBtn;
    @FXML
    private TextField dichResult;

    public void transferDate(Double resultDich){
        this.result = resultDich;
        dichResult.setText(String.valueOf(resultDich));
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

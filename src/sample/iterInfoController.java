package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class iterInfoController {
    @FXML
    private Button homeBtn;
    @FXML
    private Button iterBackBtn;

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
        iterBackBtn.setOnAction(event -> {
            try {
                Main.openAnotherWindow("iterWindow.fxml");
                iterBackBtn.getScene().getWindow().hide();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

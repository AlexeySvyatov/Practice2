package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class dichInfoController {
    @FXML
    private Button homeBtn;
    @FXML
    private Button dichBackBtn;

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
        dichBackBtn.setOnAction(event -> {
            try {
                Main.openAnotherWindow("dichWindow.fxml");
                dichBackBtn.getScene().getWindow().hide();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

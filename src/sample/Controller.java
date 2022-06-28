package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class Controller {
    @FXML
    private Button iterMethBtn;
    @FXML
    private Button dichMethBtn;

    @FXML
    void initialize(){
        iterMethBtn.setOnAction(event ->{
            try{
                Main.openAnotherWindow("iterWindow.fxml");
            }catch (IOException ex){
                ex.printStackTrace();
            }
            iterMethBtn.getScene().getWindow().hide();
        });
        dichMethBtn.setOnAction(event ->{
            try{
                Main.openAnotherWindow("dichWindow.fxml");
            }catch (IOException ex){
                ex.printStackTrace();
            }
            dichMethBtn.getScene().getWindow().hide();
        });
    }
}

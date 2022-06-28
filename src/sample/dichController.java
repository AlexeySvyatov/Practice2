package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class dichController {
    @FXML
    private Button dichInfoBtn;
    @FXML
    private TextField eps;
    @FXML
    private Button calcBtn;
    @FXML
    private TextField example;
    @FXML
    private Label exceptionDate;
    @FXML
    private TextField minDich;
    @FXML
    private TextField maxDich;
    @FXML
    private TextField varNumbDich;

    @FXML
    void initialize(){
        exceptionDate.setVisible(false);
        ArrayList<Float> dataRecord = new ArrayList<Float>();
        ArrayList<TextField> textFields1 = new ArrayList<TextField>();
        ArrayList<TextField> textFields2 = new ArrayList<TextField>();
        textFields1.add(eps);
        textFields1.add(minDich);
        textFields1.add(maxDich);
        textFields1.add(varNumbDich);
        textFields2.add(example);

        calcBtn.setOnAction(event ->{
            exceptionDate.setVisible(false);
            boolean bool1 = false;
            boolean bool2 = false;
            for (TextField i : textFields1) {
                bool1 = Main.inputValidationNums(i);
                if (bool1) {
                    exceptionDate.setVisible(true);
                    break;
                } else {
                    dataRecord.add(Main.recordNums(i));
                }
            }
            for (TextField j : textFields2) {
                bool2 = Main.inputValidationExpr(j);
                if (bool2) {
                    exceptionDate.setVisible(true);
                    break;
                } else {
                    dataRecord.add(Main.recordExpr(j));
                }
            }

            double resultDich = 0;
            if (dataRecord.get(3) == 4){
                double eps = dataRecord.get(0);
                double min = dataRecord.get(1);
                double max = dataRecord.get(2);
                double a1 = dataRecord.get(4);
                double powA1 = dataRecord.get(5);
                double a2 = dataRecord.get(6);
                double powA2 = dataRecord.get(7);
                double b = dataRecord.get(8);
                double c = dataRecord.get(9);
                double y0,x,y;

                x = y = 0;
                y0 = a1 * Math.pow(min, powA1) + a2 * Math.pow(min, powA2) + b * min + c;
                int i = 0;
                while ( (max - min) >= eps ) {
                    i++;
                    x = (min + max)/2;
                    y = a1 * Math.pow(x, powA1) + a2 * Math.pow(x, powA2) + b * x + c;
                    if(y*y0 > 0){
                        min = x;
                    }else {
                        max = x;
                    }
                }
                resultDich = x;
            }else{
                exceptionDate.setVisible(false);
            }
            FXMLLoader loader = new FXMLLoader(iterController.class.getResource("dichResult.fxml"));
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            dichResultController dichResultController = loader.getController();
            dichResultController.transferDate(resultDich);
            stage.show();
            calcBtn.getScene().getWindow().hide();
        });
        dichInfoBtn.setOnAction(event ->{
            try {
                Main.openAnotherWindow("dichInfo.fxml");
                dichInfoBtn.getScene().getWindow().hide();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

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

public class iterController {
    @FXML
    private Button calcBtn;
    @FXML
    private Button iterInfoBtn;
    @FXML
    private TextField example;
    @FXML
    private TextField eps;
    @FXML
    private Label exceptionDate;
    @FXML
    private TextField derIter;
    @FXML
    private TextField minIter;
    @FXML
    private TextField maxIter;
    @FXML
    private TextField varNumbIter;
    @FXML
    private  TextField znachX;

    @FXML
    void initialize(){
        exceptionDate.setVisible(false);
        ArrayList<Float> dataRecord = new ArrayList<Float>();
        ArrayList<TextField> textFields1 = new ArrayList<TextField>();
        ArrayList<TextField> textFields2 = new ArrayList<TextField>();
        textFields1.add(znachX);
        textFields1.add(eps);
        textFields1.add(minIter);
        textFields1.add(maxIter);
        textFields1.add(varNumbIter);
        textFields2.add(example);
        textFields2.add(derIter);

        calcBtn.setOnAction(event -> {
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

            double resultIter = 0;
            if (dataRecord.get(4) == 4) {
                double znachX = dataRecord.get(0);
                double eps = dataRecord.get(1);
                double min = dataRecord.get(2);
                double max = dataRecord.get(3);
                double a1 = dataRecord.get(5);
                double powA1 = dataRecord.get(6);
                double a2 = dataRecord.get(7);
                double powA2 = dataRecord.get(8);
                double b = dataRecord.get(9);
                double c = dataRecord.get(10);
                double da = dataRecord.get(11);
                double powDA = dataRecord.get(12);
                double db = dataRecord.get(13);
                double dc = dataRecord.get(14);
                double x0;

                double aa = da * Math.pow(min, powDA) - db * min + dc;
                double bb = da * Math.pow(max, powDA) - db * max + dc;
                double cc = da * Math.pow(znachX, powDA) - db * znachX + dc;
                znachX = aa >= bb && aa >= cc ? min : bb >= aa && bb >= cc ? max : znachX;
                double lambda = 1. / (da * Math.pow(znachX, powDA) - db * znachX + dc);
                do {
                    x0 = znachX;
                    znachX = znachX - lambda * (a1 * Math.pow(znachX, powA1) - a2 * Math.pow(znachX, powA2) + b * znachX + c);
                } while (Math.abs(znachX - x0) >= eps);
                resultIter = znachX;
            } else {
                exceptionDate.setVisible(true);
            }
            FXMLLoader loader = new FXMLLoader(iterController.class.getResource("iterResult.fxml"));
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            iterResultController iterResultController = loader.getController();
            iterResultController.transferDate(resultIter);
            stage.show();
            calcBtn.getScene().getWindow().hide();
        });
        iterInfoBtn.setOnAction(event ->{
            try {
                Main.openAnotherWindow("iterInfo.fxml");
                iterInfoBtn.getScene().getWindow().hide();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

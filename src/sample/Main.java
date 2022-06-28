package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Решение уравнений");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static public void openAnotherWindow(String name) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(name));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    static public boolean inputValidationNums(TextField num){
        String text1 = num.getText().trim();
        boolean noNum = false;
        try {
            Float.parseFloat(text1);
        } catch (Exception e) {
            noNum = true;
        }
        if(!text1.matches("-?\\d*.?\\d*") || text1 == "" ) {
            noNum = true;
        }
        return noNum;
    }

    static public boolean inputValidationExpr(TextField expr){
        String textExpr = expr.getText().trim();
        boolean exprError = false;
        try{
            textExpr = textExpr.replace("x", "");
        }catch (Exception ex){
            exprError = true;
        }
        String[] exprSplit = textExpr.split("[+^-]");
        for(int i = 0;i <= exprSplit.length - 1;i++){
            if(exprSplit[i].matches("[A-Za-z]")){
                exprError = true;
            }
        }
        return exprError;
    }

    static public float recordNums(TextField text){
        String textN = text.getText();
        float textNum = Float.parseFloat(textN);
        return textNum;
    }

    static public float recordExpr(TextField text) {
        String textE = text.getText();
        textE = textE.replace("x", "");
        String[] eSplit = textE.split("[+^-]");
        float rZnach = 0;
        for (int i = 0; i <= eSplit.length - 1; i++){
            rZnach = Float.parseFloat(eSplit[i]);
            return rZnach;
        }
        return rZnach;
    }

    public static void main(String[] args) {
        launch();
    }
}

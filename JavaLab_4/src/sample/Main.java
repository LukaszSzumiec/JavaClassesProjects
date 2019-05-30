package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new Controller(primaryStage);
        //new Form(primaryStage, 243);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

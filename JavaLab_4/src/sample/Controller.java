package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
    private TextField textField;
    private Stage primaryStage;
    Stage stage;
    public  Controller(Stage primaryStage){
        this.primaryStage = primaryStage;
        stage = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        Label label = new Label("Set number of points");

        textField = new TextField();
        textField.setText("3686000");

        Button button = new Button("Run");
        button.setOnAction(event -> setTextField());
        Scene scene = new Scene(box, 450,350);

        box.getChildren().add(label);
        box.getChildren().add(textField);

        box.getChildren().add(button);
        stage.setScene(scene);
        stage.show();
    }
    private void setTextField(){
        String val = textField.getText();
        int INTval;
        try {
            INTval = Integer.parseInt(val);
        } catch (NumberFormatException | NullPointerException ignored){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error:");
            alert.setContentText("That is not a natural number");
            alert.show();
            stage.close();
            return;
        }
        try {
            if(INTval <= 0)
                throw new NumberFormatException();
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error:");
            alert.setContentText("Number cannot be less than 0");
            alert.show();
            stage.close();
            return;
        }
            new Form(primaryStage, INTval);
            stage.close();
    }
}

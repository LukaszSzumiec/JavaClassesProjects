package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.Pane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.nio.ByteBuffer;


import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static javafx.scene.paint.Color.rgb;

class Form extends ActionEvent {

    private Button stopButton;
    static double result = 0;

    @FXML
    private EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            AsyncTaskv2.separator = true;
            stopButton.setText("Done");
        }
    };
    private EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            stopButton.setText("Done");
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            if(result == 0){

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Wait for end of calculating");
            }
            else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Result:");
                alert.setContentText("Result: " + result);

            }
            alert.show();
        }
    };

    Form(Stage stage, int numberOfPoints) {
        Canvas canvas = new Canvas(1280, 720);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane root = new Pane();
        stopButton = new Button("Stop");
        Button showResult = new Button("Show result of integral");
        ProgressBar progressBar = new ProgressBar();


        stopButton.setOnAction(event);
        showResult.setOnAction(ev);

        stopButton.setLayoutY(670);
        showResult.setLayoutY(640);
        progressBar.setLayoutY(700);


        root.getChildren().add(canvas);
        root.getChildren().add(showResult);
        root.getChildren().add(stopButton);
        root.getChildren().add(progressBar);


        AsyncTaskv2 task = new AsyncTaskv2(gc, numberOfPoints);
        Thread thread = new Thread(task);
        thread.start();
        progressBar.progressProperty().bind(task.progressProperty());

        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Writing Pixels on a Canvas");
        stage.show();
    }

}

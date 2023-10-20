package lk.ijse.dep11.gayum.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class UiLoadingSceneController {
    public Label lblLoadingUI;
    public AnchorPane root;

    public void initialize(){
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(1000),actionEvent -> {
            lblLoadingUI.setText("Application is being initialized...");
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(2000),actionEvent -> {
            lblLoadingUI.setText("Setting up Tools...");
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(3000),actionEvent -> {
            lblLoadingUI.setText("Setting up UI...");
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(4000),actionEvent -> {
            try {
                AnchorPane rootUi  = FXMLLoader.load(getClass().getResource("/view/ColorCanvasScene.fxml"));
                Scene scene = new Scene(rootUi);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("ColorCanvas V 1.0.0");
                stage.setResizable(false);
                stage.show();
                stage.centerOnScreen();
                Stage primaryStage = (Stage)root.getScene().getWindow();
                primaryStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Timeline timeline = new Timeline(keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        timeline.play();

    }


}

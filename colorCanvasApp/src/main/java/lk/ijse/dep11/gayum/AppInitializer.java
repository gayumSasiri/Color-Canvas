package lk.ijse.dep11.gayum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/UiLoadingScene.fxml"));
        Scene uiLoadScene = new Scene(root);
        primaryStage.setScene(uiLoadScene);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        uiLoadScene.setFill(Color.TRANSPARENT);

        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}

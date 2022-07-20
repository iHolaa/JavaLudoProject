package game.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.Parent;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt"));
        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Wellcome_Page.fxml"));
        Scene firstScene = new Scene(root, 450, 600);
        stage.setTitle("Java Ludo Project");
        stage.setScene(firstScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String fxml ,double height,double width) throws IOException{
        Parent root1 = FXMLLoader.load(getClass().getResource(fxml));
        Scene allScene = new Scene(root1,height,width);
        stg.setScene(allScene);
        stg.show();
        stg.setResizable(false);
    }

}
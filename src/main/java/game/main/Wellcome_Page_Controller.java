package game.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;


public class Wellcome_Page_Controller {
    Main main = new Main();
    @FXML
    Button closeButton , PlayButton , UserButton , SignUpButton ;

    @FXML
    public void Play_Button() {
        try {
            main.changeScene("Select_NumberOf_Players.fxml",450,600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Player_Information_Button(){

        try {
            main.changeScene("Winner_Page.fxml", 800, 600);
        }catch (Exception ex){
            ex.printStackTrace();
        }

   //     try {
     //       main.changeScene("Ludo_Scene.fxml",1280,800);
       // } catch (IOException e) {
         //   e.printStackTrace();
        // }
    }
    public void SignUp_Button(){
        try {
            main.changeScene("SignUp_Page.fxml",450,600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Exit_Button(){
        Ludo_Scene_Controller ld = new Ludo_Scene_Controller();
        ld.stop = true ; // baraye stop kardan thread timer
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    //Button Enter and Exit Mouse Style
    public void playEnter(){
        PlayButton.setStyle("-fx-background-color:green");
    }
    public void playExit(){
        PlayButton.setStyle("-fx-background-color: #e8cc18");
    }
    public void userEnter(){
        UserButton.setStyle("-fx-background-color:green");
    }
    public void userExit(){
        UserButton.setStyle("-fx-background-color: #e8cc18");
    }
    public void signUpEnter(){
        SignUpButton.setStyle("-fx-background-color:green");
    }
    public void signUpExit(){
        SignUpButton.setStyle("-fx-background-color: #e8cc18");
    }
    public void exitEnter(){
        closeButton.setStyle("-fx-background-color:red");
    }
    public void exitExit(){
        closeButton.setStyle("-fx-background-color:#F24848");
    }

}
package game.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Select_NumberOfPlayers_Controller {
    Main main = new Main();
    FileManeger2 fileManeger2 = new FileManeger2();

    @FXML
    Button menu_Button , play_by2 , play_by3 , play_by4;

    public void play_by_2(){
        try {
            fileManeger2.FileWriter("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt","2");
            main.changeScene("Add_Players.fxml",1068,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void play_by_3(){
        try {
            fileManeger2.FileWriter("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt","3");
            main.changeScene("Add_Players.fxml",1068,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void play_by_4(){
        try {
            fileManeger2.FileWriter("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt","4");
            main.changeScene("Add_Players.fxml",1068,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void goToMenu() {
        try {
            main.changeScene("Wellcome_Page.fxml",450,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    // Button Enter and Exit Mouse Style
    public void play2(){
        play_by2.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FF0074");
    }
    public void play2_ex(){
        play_by2.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FEC849 ");
    }
    public void play3(){
        play_by3.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FF0074");
    }
    public void play3_ex(){
        play_by3.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FEC849 ");
    }
    public void play4(){
        play_by4.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FF0074");
    }
    public void play4_ex(){
        play_by4.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FEC849 ");
    }
    public void menu_drag(){
        menu_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #FF0074");
    }
    public void menu_drag_ex(){
        menu_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #090F37");
    }

}

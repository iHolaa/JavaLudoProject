package game.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WinnerPage_Controller implements Initializable {
    Main main = new Main();
    @FXML
    Label winner_Label;
    @FXML
    Button closeButton , menu_Button ;
    FileManeger2 fileManeger2 = new FileManeger2();
    ArrayList<String> winner = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",winner);
        winner_Label.setText(winner.get(0) + " wins ");
    }
    public void goToMenu() {
        try {
            main.changeScene("Wellcome_Page.fxml",450,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    } //end of goToMenu()

    public void Exit_Button(){
        Ludo_Scene_Controller ld = new Ludo_Scene_Controller();
        ld.stop = true ; // baraye stop kardan thread timer
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    // Button Enter and Exit Mouse Style
    public void menu_Enter(){
        menu_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FF0074");
    }
    public void menu_Exit(){
        menu_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #090F37");
    }
    public void exitEnter(){
        closeButton.setStyle("-fx-background-color:black ; -fx-background-radius: 15 ");
    }
    public void exitExit(){
        closeButton.setStyle("-fx-background-color: #55264F ; -fx-background-radius: 15 ");
    }


}

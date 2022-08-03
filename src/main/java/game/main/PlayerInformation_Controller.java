package game.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayerInformation_Controller implements Initializable {
    Main main = new Main();
    FileManeger1 fileManeger1 = new FileManeger1();
    FileManeger2 fileManeger2 = new FileManeger2();
    @FXML
    Button login_Button , menu_Button;
    @FXML
    Label successful_Label ,error_Label;
    @FXML
    TextField usernameTextField , passwordTextField;
    int i = 0 ;
    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Username.txt",username);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Password.txt",password);
    }
    public void login(){
        for ( i = 0; i < username.size(); i++) {
            if (usernameTextField.getText().equals(username.get(i)) && passwordTextField.getText().equals(password.get(i))) {
                fileManeger2.FileWriter("src\\main\\resources\\Files\\Information\\Username_Position.txt",String.valueOf(i));
                try {
                    main.changeScene("Player_Profile.fxml",1100,700);
                    error_Label.setText("");
                    break;
                }catch (Exception ex ){
                    ex.printStackTrace();
                }
            } else if ( ! username.contains(usernameTextField.getText())) {
                error_Label.setText(" Username is not Exist !! ");
            } else {
                error_Label.setText(" Password is Wrong !!");
            }
        }// for
    }
    public void goToMenu() {
        try {
            main.changeScene("Wellcome_Page.fxml",450,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    } //end of goToMenu()

    // Button Enter and Exit Mouse Style
    public void menu_Enter(){
        menu_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #FF0074");
    }
    public void menu_Exit(){
        menu_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #090F37");
    }
    public void login_Enter(){
        login_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #25D120");
    }
    public void login_Exit(){
        login_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color:  green");
    }

}

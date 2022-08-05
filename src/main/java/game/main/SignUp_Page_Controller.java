package game.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SignUp_Page_Controller {
    Main main = new Main();
    FileManeger1 fm = new FileManeger1();
    @FXML
    Button signUp_Button , menu_Button;
    @FXML
    Label successful_Label ,error_Label;
    @FXML
    TextField usernameTextField ,nameTextField ,ageTextField ,passwordTextField;
    ArrayList<String> userName = new ArrayList();

    @FXML
    public void signUp() {

        if(usernameTextField.getText().trim().length() >=4 ){
            if(nameTextField.getText().length() >=3 ){
                try {
                    int age1 = Integer.parseInt(ageTextField.getText());
                    if( age1 >= 1 && age1 <= 150 ){
                        if(passwordTextField.getText().length() >= 4 ){
                            boolean exist = Files.exists(Path.of("src\\main\\resources\\Files\\SignUp\\Username.txt"));
                             if(exist == true) {
                                fm.FileReader("src\\main\\resources\\Files\\SignUp\\Username.txt", userName);

                                 boolean contains = userName.contains(usernameTextField.getText().trim());

                                        if ( contains == false ) {
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Username.txt", usernameTextField.getText().trim());
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Name.txt", nameTextField.getText().trim());
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Age.txt", ageTextField.getText().trim());
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Password.txt", passwordTextField.getText().trim());
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", "0");
                                            fm.FileWriter("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt", "0");
                                            successful_Label.setText(" Player Signed Up Successfully... ");
                                            error_Label.setText("");
                                            signUp_Button.setVisible(false);

                                        } else {
                                            error_Label.setText(" Username is already taken... ");
                                        }//end of else
                                }else{
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Username.txt",usernameTextField.getText().trim());
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Name.txt",nameTextField.getText().trim());
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Age.txt",ageTextField.getText().trim());
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Password.txt",passwordTextField.getText().trim());
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", "0");
                                fm.FileWriter("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt", "0");
                                successful_Label.setText(" Player Signed Up Successfully... ");
                                error_Label.setText("");
                                signUp_Button.setVisible(false);
                            }//else
                        }else{
                            error_Label.setText(" Password must contain at least 4 Characters...");
                        }//esle
                    }else{
                        error_Label.setText(" Invalid Age !!");
                    }//else
                }catch (Exception ex){
                    error_Label.setText(" Invalid Age !!");
                }
            }else{
             error_Label.setText(" Name must contain at least 3 Characters...");
            }//else
        }else{
            error_Label.setText(" Username must contain at least 4 Characters... ");
        }//else

    }// end of SignUp Method

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
    public void signUp_Enter(){
        signUp_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color: #25D120");
    }
    public void signUp_Exit(){
        signUp_Button.setStyle("-fx-background-radius: 10 ; -fx-background-color:  green");
    }

  }// end of Class

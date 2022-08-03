package game.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.annotation.Inherited;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayerProfile_Controller implements Initializable {

   Main main = new Main();
   FileManeger1 fileManeger1 = new FileManeger1();
   FileManeger2 fileManeger2 = new FileManeger2();
   @FXML
   Button edit_Button , save_Button , games_Info_Button , signOut_Button ;
   @FXML
   TextField username_TextField, name_TextField, password_TextField,
       age_TextField, score_TextField, gamesPlayed_TextField ;
   @FXML
   Label successful_Label , error_Label ;

   ArrayList<String> u_Pos = new ArrayList<>();
   ArrayList<String> username = new ArrayList<>();
   ArrayList<String> name = new ArrayList<>();
   ArrayList<String> age = new ArrayList<>();
   ArrayList<String> password = new ArrayList<>();
   ArrayList<String> score = new ArrayList<>();
   ArrayList<String> gamesPlayed = new ArrayList<>();

   int pos;
       @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {

        save_Button.setVisible(false);
        fileManeger1.FileReader("src\\main\\resources\\Files\\Information\\Username_Position.txt",u_Pos);
        pos = Integer.parseInt(u_Pos.get(0));

        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Username.txt",username);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Name.txt",name);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Age.txt",age);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Password.txt",password);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score);
        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt",gamesPlayed);

        username_TextField.setText(username.get(pos));
        name_TextField.setText(name.get(pos));
        age_TextField.setText(age.get(pos));
        password_TextField.setText(password.get(pos));
        score_TextField.setText(score.get(pos));
        gamesPlayed_TextField.setText(gamesPlayed.get(pos));

    }// initialize()
      public void edit(){
        age_TextField.setEditable(true);
        password_TextField.setEditable(true);
        name_TextField.setEditable(true);
        save_Button.setVisible(true);
        successful_Label.setText("");
      }
      public void save(){

        if(name_TextField.getText().length() >= 3 ){
            try {
               int age1 = Integer.parseInt(age_TextField.getText());

                if( age1 >= 1 && age1 <= 150 ){

                    if(password_TextField.getText().length() >= 4 ){

                        Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Name.txt"));
                        Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Age.txt"));
                        Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Password.txt"));
                        name.set( pos , name_TextField.getText().trim());
                        age.set( pos , age_TextField.getText().trim());
                        password.set( pos , password_TextField.getText().trim());

                        for (int i = 0; i < username.size() ; i++) {
                            fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Name.txt",name.get(i));
                            fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Age.txt",age.get(i));
                            fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Password.txt",password.get(i));
                        }
                        age_TextField.setEditable(false);
                        password_TextField.setEditable(false);
                        name_TextField.setEditable(false);
                        successful_Label.setText(" Edited Successfully... ");
                        error_Label.setText("");
                        save_Button.setVisible(false);
                    } else {
                        error_Label.setText(" Password must contain at least 4 Characters...");
                    }
                } else {
                    error_Label.setText(" Invalid Age !!");
                }//else
            }catch (Exception ex){
                error_Label.setText(" Invalid Age !!");
            }
        }else{
            error_Label.setText(" Name must contain at least 3 Characters...");
        }//else
    }// save()
    public void games_Info(){

    }
    public void sign_out(){
        try {
            main.changeScene("Player_Information.fxml",450,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void edit_Enter(){
        edit_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #FF0000");
    }
    public void edit_Exit(){
        edit_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #F56456");
    }
    public void save_Enter(){
        save_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #1A883A");
    }
    public void save_Exit(){
        save_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #34BF5C");
    }
    public void g_Info_Enter(){
        games_Info_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #18548E");
    }
    public void g_Info_Exit(){
        games_Info_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #13B8C2");
    }
    public void signout_Enter(){
        signOut_Button.setStyle("-fx-background-radius: 12 ; -fx-background-color: #18548E");
    }
    public void signout_Exit(){
        signOut_Button.setStyle("-fx-background-radius: 12 ; -fx-background-color: #13B8C2");
    }


}


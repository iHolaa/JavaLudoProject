package game.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Add_Player_Controller implements Initializable {
    Main main = new Main();
    FileManeger2 fileManeger2 = new FileManeger2();
    FileManeger1 fileManeger1 = new FileManeger1();
    @FXML
    Button add_Button_1, add_Button_2, add_Button_3, add_Button_4, start_Button, return_Button;
    @FXML
    Label add_label1 , add_label2 , add_label3 , add_label4;
    @FXML
    Text player1_Text, player2_Text, player3_Text, player4_Text;
    @FXML
    TextField username_TextField1, username_TextField2, username_TextField3 , username_TextField4
            ,password_TextField1, password_TextField2, password_TextField3, password_TextField4;

    ArrayList<String> numberOfPlayer = new ArrayList<>();
    ArrayList<String> userName = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();
    ArrayList<String> gamesPlayed = new ArrayList<>();

    // User Position Counter
    int i = 0 ; //player 1
    int j = 0 ; //player 2
    int k = 0 ; //player 3
    int h = 0 ; //player 4
    int sum_i = 0;
    int sum_j = 0;
    int sum_k = 0;
    int sum_h = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Game_Pos gp = new Game_Pos();
        gp.delete_LastGame_Files();
        if(Files.exists(Path.of("src\\main\\resources\\Files\\SignUp\\Username.txt"))) {
            fileManeger2.FileReader("src\\main\\resources\\Files\\SignUp\\Username.txt", userName);
            fileManeger2.FileReader("src\\main\\resources\\Files\\SignUp\\Password.txt", password);
            fileManeger2.FileReader("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt", gamesPlayed);
        }

        fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt", numberOfPlayer);

        if (numberOfPlayer.contains("2")) {
            username_TextField3.setVisible(false);
            username_TextField4.setVisible(false);
            password_TextField3.setVisible(false);
            password_TextField4.setVisible(false);
            player3_Text.setVisible(false);
            player4_Text.setVisible(false);
            add_Button_3.setVisible(false);
            add_Button_4.setVisible(false);
            add_Button_3.setDisable(true);
            add_Button_4.setDisable(true);
            System.out.println("2 Player");
        }
        else if(numberOfPlayer.contains("3")) {
            username_TextField4.setVisible(false);
            password_TextField4.setVisible(false);
            player4_Text.setVisible(false);
            add_Button_4.setVisible(false);
            add_Button_4.setDisable(true);
            System.out.println("3 Player");
        }
        else if(numberOfPlayer.contains("4")) {
            System.out.println("4 Player");
        }

    }// end of initialize()
    
    public void add_Player1() {

        for ( i = 0; i < userName.size(); i++){
            if (username_TextField1.getText().equals(userName.get(i)) && password_TextField1.getText().equals(password.get(i))) {
                if (!username_TextField1.getText().equals(username_TextField2.getText()) && !username_TextField1.getText().equals(username_TextField3.getText())
                        && !username_TextField1.getText().equals(username_TextField4.getText())) {
                    username_TextField1.setEditable(false);
                    password_TextField1.setEditable(false);
                    add_Button_1.setVisible(false);
                    add_label1.setText(" Player 1 has been added Successfully..");
                    break;
                }// if
                else {
                    add_label1.setText(" This Player has already registered ");
                    break;
                }
            }// if
            else if (!userName.contains(username_TextField1.getText())) {
                add_label1.setText(" Username is not Exist !! ");
            }
            else {
                add_label1.setText(" Password is Wrong !!");
            }
        }// for
        chek_For_Start();
    }// add_Player1()
    public void add_Player2(){

        for ( j = 0; j < userName.size(); j++) {
            if (username_TextField2.getText().equals(userName.get(j)) && password_TextField2.getText().equals(password.get(j))) {
                if (!username_TextField2.getText().equals(username_TextField1.getText()) && !username_TextField2.getText().equals(username_TextField3.getText())
                        && !username_TextField2.getText().equals(username_TextField4.getText())) {
                    username_TextField2.setEditable(false);
                    password_TextField2.setEditable(false);
                    add_Button_2.setVisible(false);
                    add_label2.setText(" Player 2 has been added Successfully..");
                    break;
                }//if
                else {
                    add_label2.setText(" This Player has already registered ");
                    break;
                }
            }//if
            else if (!userName.contains(username_TextField2.getText())) {
                add_label2.setText(" Username does not Exist !! ");
            }
            else {
                add_label2.setText(" Password is Wrong !!");
            }
        }// for
        chek_For_Start();
    }// add_Player2()
    public void add_Player3(){

        for ( k = 0; k < userName.size(); k++) {
            if (username_TextField3.getText().equals(userName.get(k)) && password_TextField3.getText().equals(password.get(k))) {
                if (!username_TextField3.getText().equals(username_TextField1.getText()) && !username_TextField3.getText().equals(username_TextField2.getText())
                        && !username_TextField3.getText().equals(username_TextField4.getText())) {
                    username_TextField3.setEditable(false);
                    password_TextField3.setEditable(false);
                    add_Button_3.setVisible(false);
                    add_label3.setText(" Player 3 has been added Successfully..");
                    break;
                }//if
                else {
                    add_label3.setText(" This Player has already registered ");
                    break;
                }
            }//if
            else if (!userName.contains(username_TextField3.getText())) {
                add_label3.setText(" Username does not Exist !! ");
            }
            else {
                add_label3.setText(" Password is Wrong !!");
            }
        }// for
        chek_For_Start();
    }// add_Player3()
    public void add_Player4(){

        for (h = 0; h < userName.size(); h++) {
            if (username_TextField4.getText().equals(userName.get(h)) && password_TextField4.getText().equals(password.get(h))) {
                if (!username_TextField4.getText().equals(username_TextField1.getText()) && !username_TextField4.getText().equals(username_TextField3.getText())
                        && !username_TextField4.getText().equals(username_TextField2.getText())) {
                    username_TextField4.setEditable(false);
                    password_TextField4.setEditable(false);
                    add_Button_4.setVisible(false);
                    add_label4.setText(" Player 4 has been added Successfully..");
                    break;
                }//if
                else {
                    add_label4.setText(" This Player has already registered ");
                    break;
                }
            }//if
            else if (!userName.contains(username_TextField4.getText())) {
                add_label4.setText(" Username does not Exist !! ");
            }
            else {
                add_label4.setText(" Password is Wrong !!");
            }
        }// for
        chek_For_Start();
    }// add_Player4()

    public void chek_For_Start(){

        if( !add_Button_1.isVisible() && !add_Button_2.isVisible()
                && !add_Button_3.isVisible() && !add_Button_4.isVisible()){
            start_Button.setVisible(true);
        }
        else if(!add_Button_1.isVisible() && !add_Button_2.isVisible()
                && !add_Button_3.isVisible() && add_Button_4.isDisable()){
            start_Button.setVisible(true);
        }
        else if(!add_Button_1.isVisible() && !add_Button_2.isVisible()
                && add_Button_3.isDisable() && add_Button_4.isDisable()){
            start_Button.setVisible(true);
        }
    }// check_For_Start()

    public void start_Game() throws IOException{

        Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt"));

        // baraye bazi 4 nafare
        if( !username_TextField1.isEditable() && !username_TextField2.isEditable()
                && !username_TextField3.isEditable() && !username_TextField4.isEditable()) {

            sum_i = Integer.parseInt(gamesPlayed.get(i)) + 1 ;
            sum_j = Integer.parseInt(gamesPlayed.get(j)) + 1 ;
            sum_k = Integer.parseInt(gamesPlayed.get(k)) + 1 ;
            sum_h = Integer.parseInt(gamesPlayed.get(h)) + 1 ;
            gamesPlayed.set( i , String.valueOf(sum_i));
            gamesPlayed.set( j , String.valueOf(sum_j));
            gamesPlayed.set( k , String.valueOf(sum_k));
            gamesPlayed.set( h , String.valueOf(sum_h));

            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username_TextField1.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username_TextField2.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",username_TextField3.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt",username_TextField4.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt","Unfinished");
            // save to last game played
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",username_TextField1.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",username_TextField2.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",username_TextField3.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4.txt",username_TextField4.getText());

            // save Position of Player in File
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",String.valueOf(i));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",String.valueOf(j));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",String.valueOf(k));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt",String.valueOf(h));

        }// if
        // baraye bazi 3 nafare
        else if( !username_TextField1.isEditable() && !username_TextField2.isEditable()
                && !username_TextField3.isEditable() && username_TextField4.isEditable()){

            sum_i = Integer.parseInt(gamesPlayed.get(i)) + 1 ;
            sum_j = Integer.parseInt(gamesPlayed.get(j)) + 1 ;
            sum_k = Integer.parseInt(gamesPlayed.get(k)) + 1 ;
            gamesPlayed.set( i , String.valueOf(sum_i));
            gamesPlayed.set( j , String.valueOf(sum_j));
            gamesPlayed.set( k , String.valueOf(sum_k));

            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username_TextField1.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username_TextField2.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",username_TextField3.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt"," - ");
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt","Unfinished");
            // save to last game played
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",username_TextField1.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",username_TextField2.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",username_TextField3.getText());
            // save Position of Player in File
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",String.valueOf(i));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",String.valueOf(j));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",String.valueOf(k));

        }// else if
        // baraye bazi 2 nafare
        else if( !username_TextField1.isEditable() && !username_TextField2.isEditable()
                && username_TextField3.isEditable()  &&  username_TextField4.isEditable()){

            sum_i = Integer.parseInt(gamesPlayed.get(i)) + 1 ;
            sum_j = Integer.parseInt(gamesPlayed.get(j)) + 1 ;
            gamesPlayed.set( i , String.valueOf(sum_i));
            gamesPlayed.set( j , String.valueOf(sum_j));
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username_TextField1.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username_TextField2.getText());
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt"," - ");
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt"," - ");
            fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt","Unfinished");
            // save to last game played
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",username_TextField1.getText());
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",username_TextField2.getText());
            // save Position of Player in File
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",String.valueOf(i));
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",String.valueOf(j));
        }// else if

        for (int l = 0; l < gamesPlayed.size() ; l++) {
            fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\GamesPlayed.txt",gamesPlayed.get(l));
        }// for
       try {
           main.changeScene("Ludo_Scene.fxml",1280,800);
       }catch (Exception ex){
            ex.printStackTrace();
       }

    }// start_Game()

    public void return_Scene(){
        try {
            main.changeScene("Select_NumberOf_Players.fxml",450,600);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }// return_Scene()



    // Button Enter and Exit Mouse Style
    public void start_Enter(){
        start_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #26D736");
    }
    public void start_Exit(){
        start_Button.setStyle("-fx-background-radius: 15 ; -fx-background-color: #099215 ");
    }
    public void return_Enter(){
        return_Button.setStyle("-fx-background-radius: 10; -fx-background-color:  #FF0074");
    }
    public void return_Exit(){
        return_Button.setStyle("-fx-background-radius: 10; -fx-background-color:  #090F37");
    }
    public void add_Enter1(){
        add_Button_1.setStyle("-fx-background-radius: 15;-fx-background-color: #FF0074");
    }
    public void add_Exit1(){
        add_Button_1.setStyle("-fx-background-radius: 15;-fx-background-color: #4EFFF7");
    }
    public void add_Enter2(){
        add_Button_2.setStyle("-fx-background-radius: 15;-fx-background-color: #FF0074");
    }
    public void add_Exit2(){
        add_Button_2.setStyle("-fx-background-radius: 15;-fx-background-color: #4EFFF7");
    }
    public void add_Enter3(){
        add_Button_3.setStyle("-fx-background-radius: 15;-fx-background-color: #FF0074");
    }
    public void add_Exit3(){
        add_Button_3.setStyle("-fx-background-radius: 15;-fx-background-color: #4EFFF7");
    }
    public void add_Enter4(){
        add_Button_4.setStyle("-fx-background-radius: 15;-fx-background-color: #FF0074");
    }
    public void add_Exit4(){
        add_Button_4.setStyle("-fx-background-radius: 15;-fx-background-color: #4EFFF7");
    }


}// end of Class

package game.main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class Ludo_Scene_Controller implements Initializable {

    Main main = new Main();
    FileManeger2 fileManeger2 = new FileManeger2();
    Game_Pos game_pos = new Game_Pos();
    protected boolean stop = false ;

@FXML
    protected ImageView  blue_Player1, blue_Player2, blue_Player3, blue_Player4 ,
        red_Player1, red_Player2, red_Player3, red_Player4 ,
        green_Player1, green_Player2, green_Player3, green_Player4 ,
        yellow_Player1, yellow_Player2, yellow_Player3, yellow_Player4 ,
        dice_Image;
    protected ImageView[] blue_Player = { blue_Player1, blue_Player2, blue_Player3 , blue_Player4 };
    protected ImageView[] red_Player = { red_Player1, red_Player2, red_Player3 , red_Player4 };
    protected ImageView[] green_Player = { green_Player1, green_Player2, green_Player3 , green_Player4 };
    protected ImageView[] yellow_Player = { yellow_Player1, yellow_Player2, yellow_Player3 , yellow_Player4 };


    @FXML
    Button dice_Button, move_p1, move_p2, move_p3, move_p4;
    @FXML
    Label time_Label , date_Label ;
    @FXML
    TextField turn_TextField, blue_TextField, red_TextField, green_TextField, yellow_TextField;
    int roll_nuber ;
    int number = 0;
    int count = 0 ;


    ArrayList<String> numberOfPlayers = new ArrayList<>();
    ArrayList<String> player1 = new ArrayList<>();// red
    ArrayList<String> player2 = new ArrayList<>();// blue
    ArrayList<String> player3 = new ArrayList<>();// green
    ArrayList<String> player4 = new ArrayList<>();// yellow


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Players First Position
        game_pos.firstPos();

        // date and time
        timeNow();

        fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

        if(numberOfPlayers.contains("2")){
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            red_TextField.setText(player1.get(0)); blue_TextField.setText(player2.get(0));
            green_TextField.setVisible(false);yellow_TextField.setVisible(false);
            green_Player1.setVisible(false);green_Player2.setVisible(false);green_Player3.setVisible(false);green_Player4.setVisible(false);
            yellow_Player1.setVisible(false);yellow_Player2.setVisible(false);yellow_Player3.setVisible(false);yellow_Player4.setVisible(false);
        }
        else if (numberOfPlayers.contains("3")) {
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",player3);
            red_TextField.setText(player1.get(0)); blue_TextField.setText(player2.get(0));
            green_TextField.setText(player3.get(0));
            yellow_TextField.setVisible(false);
            yellow_Player1.setVisible(false);yellow_Player2.setVisible(false);yellow_Player3.setVisible(false);yellow_Player4.setVisible(false);
        }
        else if (numberOfPlayers.contains("4")) {
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",player3);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4.txt",player4);
            red_TextField.setText(player1.get(0));blue_TextField.setText(player2.get(0));
            green_TextField.setText(player3.get(0));yellow_TextField.setText(player4.get(0));
        }
        turn_TextField.setText("Red");


    }// initialize()

    public void dice() throws FileNotFoundException {

        move_p1.setVisible(true);
        move_p2.setVisible(true);
        move_p3.setVisible(true);
        move_p4.setVisible(true);

        roll_nuber = ThreadLocalRandom.current().nextInt(1 , 6 + 1 );
        checkFirstSix();
        moveButtons_Hide();

        if(roll_nuber == 6){
            number -- ; //  jayze 6 (1 nobat ezafe )
            checkFirstPos();
        }
       System.out.println(roll_nuber);

        // dice picture
       if(roll_nuber == 1 ) {
           InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice1.png");
           Image image = new Image(stream);
           dice_Image.setImage(image);
       }
       else if(roll_nuber == 2 ) {
            InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice2.png");
            Image image = new Image(stream);
            dice_Image.setImage(image);
        }
       else if(roll_nuber == 3 ) {
           InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice3.png");
           Image image = new Image(stream);
           dice_Image.setImage(image);
       }
       else if(roll_nuber == 4 ) {
           InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice4.png");
           Image image = new Image(stream);
           dice_Image.setImage(image);
       }
       else if(roll_nuber == 5 ) {
           InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice5.png");
           Image image = new Image(stream);
           dice_Image.setImage(image);
       }
       else if(roll_nuber == 6 ) {
           InputStream stream = new FileInputStream("src\\main\\resources\\Picture\\dice6.png");
           Image image = new Image(stream);
           dice_Image.setImage(image);
       }
        dice_Image.setVisible(true);
    }// dice()



    public void move_Player1(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
                bluePlayer(0);
        }
        else if (turn_TextField.getText().equals("Red")){
                redPlayer(0);
        }
        else if(turn_TextField.getText().equals("Green")){
                greenPlayer(0);
        }
        else if(turn_TextField.getText().equals("Yellow")){
                yellowPlayer(0);
        }
        turn();
        roll_nuber = 0;
    }
    public void move_Player2(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer(1);
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer(1);
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer(1);
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer(1);
        }
        turn();
        roll_nuber = 0;
    }
    public void move_Player3(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer(2);
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer(2);
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer(2);
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer(2);
        }
        turn();
        roll_nuber = 0;
    }
    public void move_Player4(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer(3);
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer(3);
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer(3);
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer(3);
        }
        turn();
        roll_nuber = 0;
    }
    String[] p_Color = {"Red","Blue","Green","Yellow"};
    public void turn(){

        if(numberOfPlayers.contains("2")){
            number++;
            if(number == 2){
                number = 0;
            }
            String player_Color = p_Color[number];
            turn_TextField.setText(player_Color);
        }
        else if(numberOfPlayers.contains("3")){
            number++;
            if(number == 3){
                number = 0;
            }
            String player_Color = p_Color[number];
            turn_TextField.setText(player_Color);
        }
        else if(numberOfPlayers.contains("4")){
            number++;
            if(number == 4){
                number = 0;
            }
            String player_Color = p_Color[number] ;
            turn_TextField.setText(player_Color);
        }
    }// turn()


    public void moveButtons_Hide(){
        if(turn_TextField.getText().equals("Blue")){

            if(blue_Player1.getLayoutX() == 750 && roll_nuber != 6 ){
                move_p1.setVisible(false);
            }
            if(blue_Player2.getLayoutX() == 800 && roll_nuber != 6 ){
                move_p2.setVisible(false);
            }
            if(blue_Player3.getLayoutX() == 750 && roll_nuber != 6 ){
                move_p3.setVisible(false);
            }
            if(blue_Player4.getLayoutX() == 800 && roll_nuber != 6 ){
                move_p4.setVisible(false);
            }
        }// if Blue
        else if(turn_TextField.getText().equals("Red")){

            if(red_Player1.getLayoutX() == 200 && roll_nuber != 6 ){
                move_p1.setVisible(false);
            }
            if(red_Player2.getLayoutX() == 250 && roll_nuber != 6 ){
                move_p2.setVisible(false);
            }
            if(red_Player3.getLayoutX() == 200 && roll_nuber != 6 ){
                move_p3.setVisible(false);
            }
            if(red_Player4.getLayoutX() == 250 && roll_nuber != 6 ){
                move_p4.setVisible(false);
            }
        }// else if Red
        else if(turn_TextField.getText().equals("Green")){

            if(green_Player1.getLayoutX() == 750 && roll_nuber != 6 ){
                move_p1.setVisible(false);
            }
            if(green_Player2.getLayoutX() == 800 && roll_nuber != 6 ){
                move_p2.setVisible(false);
            }
            if(green_Player3.getLayoutX() == 750 && roll_nuber != 6 ){
                move_p3.setVisible(false);
            }
            if(green_Player4.getLayoutX() == 800 && roll_nuber != 6 ){
                move_p4.setVisible(false);
            }
        }// else if Green
        else if(turn_TextField.getText().equals("Yellow")){

            if(yellow_Player1.getLayoutX() == 200 && roll_nuber != 6 ){
                move_p1.setVisible(false);
            }
            if(yellow_Player2.getLayoutX() == 250 && roll_nuber != 6 ){
                move_p2.setVisible(false);
            }
            if(yellow_Player3.getLayoutX() == 200 && roll_nuber != 6 ){
                move_p3.setVisible(false);
            }
            if(yellow_Player4.getLayoutX() == 250 && roll_nuber != 6 ){
                move_p4.setVisible(false);
            }
        }// else if Yellow

    }// move button Hide
    public void checkFirstSix(){

        if(blue_Player1.getLayoutX() == 750 && blue_Player2.getLayoutX() == 800 && blue_Player3.getLayoutX() == 750
                && blue_Player4.getLayoutX() == 800 && red_Player1.getLayoutX() == 200 && red_Player2.getLayoutX() == 250
                && red_Player3.getLayoutX() == 200 && red_Player4.getLayoutX() == 250 && green_Player1.getLayoutX() == 750
                && green_Player2.getLayoutX() == 800 && green_Player3.getLayoutX() == 750 && green_Player4.getLayoutX() == 800
                && yellow_Player1.getLayoutX() == 200 && yellow_Player2.getLayoutX() == 250 && yellow_Player3.getLayoutX() == 200
                && yellow_Player4.getLayoutX() == 250 && roll_nuber != 6 )
        {
            move_p1.setVisible(false);
            move_p2.setVisible(false);
            move_p3.setVisible(false);
            move_p4.setVisible(false);
            dice_Button.setVisible(true);
            turn();
        } // if
        else if (blue_Player1.getLayoutX() == 750 && blue_Player2.getLayoutX() == 800 && blue_Player3.getLayoutX() == 750
                && blue_Player4.getLayoutX() == 800 && turn_TextField.getText().equals("Blue")  && roll_nuber != 6 ){
            move_p1.setVisible(false);
            move_p2.setVisible(false);
            move_p3.setVisible(false);
            move_p4.setVisible(false);
            dice_Button.setVisible(true);
            turn();
        }
        else if( red_Player1.getLayoutX() == 200 && red_Player2.getLayoutX() == 250 && red_Player3.getLayoutX() == 200
                && red_Player4.getLayoutX() == 250 && turn_TextField.getText().equals("Red") && roll_nuber != 6 ){
            move_p1.setVisible(false);
            move_p2.setVisible(false);
            move_p3.setVisible(false);
            move_p4.setVisible(false);
            dice_Button.setVisible(true);
            turn();
        }
        else if( green_Player1.getLayoutX() == 750 && green_Player2.getLayoutX() == 800 && green_Player3.getLayoutX() == 750
                && green_Player4.getLayoutX() == 800 && turn_TextField.getText().equals("Green") && roll_nuber != 6 ){
            move_p1.setVisible(false);
            move_p2.setVisible(false);
            move_p3.setVisible(false);
            move_p4.setVisible(false);
            dice_Button.setVisible(true);
            turn();
        }
        else if( yellow_Player1.getLayoutX() == 200 && yellow_Player2.getLayoutX() == 250 && yellow_Player3.getLayoutX() == 200
                && yellow_Player4.getLayoutX() == 250 && turn_TextField.getText().equals("Yellow") && roll_nuber != 6 ){
            move_p1.setVisible(false);
            move_p2.setVisible(false);
            move_p3.setVisible(false);
            move_p4.setVisible(false);
            dice_Button.setVisible(true);
            turn();
        }
        else if ( roll_nuber == 6 )
        {
            move_p1.setVisible(true);
            move_p2.setVisible(true);
            move_p3.setVisible(true);
            move_p4.setVisible(true);
            dice_Button.setVisible(false);
        }
        else{
            dice_Button.setVisible(false);
        }
    }// checkFirstSix()

    public void checkFirstPos(){

        if(turn_TextField.getText().equals("Blue")) {

            if (blue_Player1.getLayoutX() == 535 && blue_Player1.getLayoutY() == 45) {
                if (blue_Player2.getLayoutX() == 800 && blue_Player2.getLayoutY() == 80) {
                    move_p2.setVisible(false);
                } if (blue_Player3.getLayoutX() == 750 && blue_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                } if (blue_Player4.getLayoutX() == 800 && blue_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// if
            else if (blue_Player2.getLayoutX() == 535 && blue_Player2.getLayoutY() == 45) {
                if (blue_Player1.getLayoutX() == 750 && blue_Player1.getLayoutY() == 80) {
                    move_p1.setVisible(false);
                } if (blue_Player3.getLayoutX() == 750 && blue_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                } if (blue_Player4.getLayoutX() == 800 && blue_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// else if
           else if (blue_Player3.getLayoutX() == 535 && blue_Player3.getLayoutY() == 45) {
                if (blue_Player1.getLayoutX() == 750 && blue_Player1.getLayoutY() == 80) {
                    move_p1.setVisible(false);
                } if (blue_Player2.getLayoutX() == 800 && blue_Player2.getLayoutY() == 80) {
                    move_p2.setVisible(false);
                } if (blue_Player4.getLayoutX() == 800 && blue_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (blue_Player4.getLayoutX() == 535 && blue_Player4.getLayoutY() == 45) {
                if (blue_Player1.getLayoutX() == 750 && blue_Player1.getLayoutY() == 80) {
                    move_p1.setVisible(false);
                } if (blue_Player2.getLayoutX() == 800 && blue_Player2.getLayoutY() == 80) {
                    move_p2.setVisible(false);
                } if (blue_Player3.getLayoutX() == 750 && blue_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                }
            }// else if
        }// blue if

        else if(turn_TextField.getText().equals("Red")){

            if (red_Player1.getLayoutX() == 175 && red_Player1.getLayoutY() == 285 ) {
                if (red_Player2.getLayoutX() == 250 && red_Player2.getLayoutY() == 80 ) {
                    move_p2.setVisible(false);
                } if (red_Player3.getLayoutX() == 200 && red_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                } if (red_Player4.getLayoutX() == 250 && red_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// if
            else if (red_Player2.getLayoutX() == 175 && red_Player2.getLayoutY() == 285 ) {
                if (red_Player1.getLayoutX() == 200 && red_Player1.getLayoutY() == 80 ) {
                    move_p1.setVisible(false);
                } if (red_Player3.getLayoutX() == 200 && red_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                } if (red_Player4.getLayoutX() == 250 && red_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (red_Player3.getLayoutX() == 175 && red_Player3.getLayoutY() == 285 ) {
                if (red_Player1.getLayoutX() == 200 && red_Player1.getLayoutY() == 80 ) {
                    move_p1.setVisible(false);
                } if (red_Player2.getLayoutX() == 250 && red_Player2.getLayoutY() == 80 ) {
                    move_p2.setVisible(false);
                } if (red_Player4.getLayoutX() == 250 && red_Player4.getLayoutY() == 130) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (red_Player4.getLayoutX() == 175 && red_Player4.getLayoutY() == 285 ) {
                if (red_Player1.getLayoutX() == 200 && red_Player1.getLayoutY() == 80 ) {
                    move_p1.setVisible(false);
                } if (red_Player2.getLayoutX() == 250 && red_Player2.getLayoutY() == 80 ) {
                    move_p2.setVisible(false);
                } if (red_Player3.getLayoutX() == 200 && red_Player3.getLayoutY() == 130) {
                    move_p3.setVisible(false);
                }
            }// else if
        }// red else if

        else if(turn_TextField.getText().equals("Green")){

            if (green_Player1.getLayoutX() == 775 && green_Player1.getLayoutY() == 405 ) {
                if (green_Player2.getLayoutX() == 800 && green_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (green_Player3.getLayoutX() == 750 && green_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                } if (green_Player4.getLayoutX() == 800 && green_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// if
            else if (green_Player2.getLayoutX() == 775 && green_Player2.getLayoutY() == 405 ) {
                if (green_Player1.getLayoutX() == 750 && green_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (green_Player3.getLayoutX() == 750 && green_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                } if (green_Player4.getLayoutX() == 800 && green_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (green_Player3.getLayoutX() == 775 && green_Player3.getLayoutY() == 405 ) {
                if (green_Player1.getLayoutX() == 750 && green_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (green_Player2.getLayoutX() == 800 && green_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (green_Player4.getLayoutX() == 800 && green_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (green_Player4.getLayoutX() == 775 && green_Player4.getLayoutY() == 405 ) {
                if (green_Player1.getLayoutX() == 750 && green_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (green_Player2.getLayoutX() == 800 && green_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (green_Player3.getLayoutX() == 750 && green_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                }
            }// else if
        }// green else if

        else if(turn_TextField.getText().equals("Yellow")){

            if (yellow_Player1.getLayoutX() == 415 && yellow_Player1.getLayoutY() == 645 ) {
                if (yellow_Player2.getLayoutX() == 250 && yellow_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (yellow_Player3.getLayoutX() == 200 && yellow_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                } if (yellow_Player4.getLayoutX() == 250 && yellow_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// if
            else if (yellow_Player2.getLayoutX() == 415 && yellow_Player2.getLayoutY() == 645 ) {
                if (yellow_Player1.getLayoutX() == 200 && yellow_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (yellow_Player3.getLayoutX() == 200 && yellow_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                } if (yellow_Player4.getLayoutX() == 250 && yellow_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (yellow_Player3.getLayoutX() == 415 && yellow_Player3.getLayoutY() == 645 ) {
                if (yellow_Player1.getLayoutX() == 200 && yellow_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (yellow_Player2.getLayoutX() == 250 && yellow_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (yellow_Player4.getLayoutX() == 250 && yellow_Player4.getLayoutY() == 680) {
                    move_p4.setVisible(false);
                }
            }// else if
            else if (yellow_Player4.getLayoutX() == 415 && yellow_Player4.getLayoutY() == 645 ) {
                if (yellow_Player1.getLayoutX() == 200 && yellow_Player1.getLayoutY() == 630 ) {
                    move_p1.setVisible(false);
                } if (yellow_Player2.getLayoutX() == 250 && yellow_Player2.getLayoutY() == 630 ) {
                    move_p2.setVisible(false);
                } if (yellow_Player3.getLayoutX() == 200 && yellow_Player3.getLayoutY() == 680) {
                    move_p3.setVisible(false);
                }
            }// else if
        }// yellow else if

    }// checkSix()
  public void checkScore(){



  }//checkScore()


    public void timeNow() {

        LocalDate date = LocalDate.now();
        Thread thread = new Thread(()->{
          SimpleDateFormat date_time = new SimpleDateFormat("hh : mm : ss");

          while ( ! stop ){
              try {
                  Thread.sleep(1000);
              }catch (Exception ex){
                  ex.printStackTrace();
              }
              String timeNow = date_time.format(new Date());
              Platform.runLater(()->{
                  date_Label.setText("Date   " + date );
                  time_Label.setText("Time   " + timeNow );
              });
          }
      });
      thread.start();
    }// timeNow()





    // Players Movement
    public void bluePlayer(int blueNumber) {

        blue_Player[0] = blue_Player1;
        blue_Player[1] = blue_Player2;
        blue_Player[2] = blue_Player3;
        blue_Player[3] = blue_Player4;

        count = blueNumber ;
        System.out.println(count);
        System.out.println(blue_Player[count]);
        ArrayList<String>[] blue = new ArrayList[4];
        blue[0] = new ArrayList<String>();// player 1
        blue[1] = new ArrayList<String>();// player 2
        blue[2] = new ArrayList<String>();// player 3
        blue[3] = new ArrayList<String>();// player 4

        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt", blue[0]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt", blue[1]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt", blue[2]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt", blue[3]);

        for (int i = 0; i < roll_nuber; i++) {

            if(count == 0 && blue_Player[count].getLayoutX() == 750 && blue_Player[count].getLayoutY() == 80 && roll_nuber == 6 ){
                blue_Player[count].setLayoutX(535);
                blue_Player[count].setLayoutY(45);
                safeForBlue();
                break;
            }
            else if(count == 1 && blue_Player[count].getLayoutX() == 800 && blue_Player[count].getLayoutY() == 80 && roll_nuber == 6 ){
                blue_Player[count].setLayoutX(535);
                blue_Player[count].setLayoutY(45);
                safeForBlue();
                break;
            }
            else if(count == 2 && blue_Player[count].getLayoutX() == 750 && blue_Player[count].getLayoutY() == 130 && roll_nuber == 6 ){
                blue_Player[count].setLayoutX(535);
                blue_Player[count].setLayoutY(45);
                safeForBlue();
                break;
            }
            else if(count == 3 && blue_Player[count].getLayoutX() == 800 && blue_Player[count].getLayoutY() == 130 && roll_nuber == 6 ){
                blue_Player[count].setLayoutX(535);
                blue_Player[count].setLayoutY(45);
                safeForBlue();
                break;
            }
            else if (blue_Player[count].getLayoutY() == 285 && blue_Player[count].getLayoutX() >= 535 && blue_Player[count].getLayoutX() <= 715) {
                blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
            } else if (blue_Player[count].getLayoutX() == 535 && blue_Player[count].getLayoutY() >= 45 && blue_Player[count].getLayoutY() <= 225) {
                blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60);
            } else if (blue_Player[count].getLayoutX() == 775 && blue_Player[count].getLayoutY() >= 285 && blue_Player[count].getLayoutY() <= 345) {
                blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60);
            } else if (blue_Player[count].getLayoutY() == 405 && blue_Player[count].getLayoutX() <= 775 && blue_Player[count].getLayoutX() >= 595) {
                blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() - 60);
            } else if (blue_Player[count].getLayoutX() == 535 && blue_Player[count].getLayoutY() >= 405 && blue_Player[count].getLayoutY() <= 585) {
                blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60);
            } else if (blue_Player[count].getLayoutY() == 645 && blue_Player[count].getLayoutX() <= 535 && blue_Player[count].getLayoutX() >= 475) {
                blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() - 60);
            } else if (blue_Player[count].getLayoutX() == 415 && blue_Player[count].getLayoutY() >= 465 && blue_Player[count].getLayoutY() <= 645) {
                blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60);
            } else if (blue_Player[count].getLayoutY() == 405 && blue_Player[count].getLayoutX() <= 415 && blue_Player[count].getLayoutX() >= 235) {
                blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() - 60);
            } else if (blue_Player[count].getLayoutX() == 175 && blue_Player[count].getLayoutY() >= 345 && blue_Player[count].getLayoutY() <= 405) {
                blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60);
            } else if (blue_Player[count].getLayoutY() == 285 && blue_Player[count].getLayoutX() <= 355 && blue_Player[count].getLayoutX() >= 175) {
                blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
            }
            else if (blue_Player[count].getLayoutX() == 415 && blue_Player[count].getLayoutY() == 285) {

                if( blue[count].contains("415,285") && roll_nuber == 6
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 180 );
                }
                else if (blue[count].contains("415,285") && roll_nuber == 5){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 240 );
                }
                else if (blue[count].contains("415,285") && roll_nuber == 4){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 240 );
                }
                else if (blue[count].contains("415,285") && roll_nuber == 3){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 180 );
                }
                else {
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }
            }
            else if (blue_Player[count].getLayoutX() == 415 && blue_Player[count].getLayoutY() == 225) {
                if( blue[count].contains("415,225") && roll_nuber == 6
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 )) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }
                else if( blue[count].contains("415,225") && roll_nuber == 5
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 120 );
                }
                else if (blue[count].contains("415,225") && roll_nuber == 4){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 180 );
                }
                else {
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }
            }
            else if (blue_Player[count].getLayoutX() == 415 && blue_Player[count].getLayoutY() == 165) {
                if( blue[count].contains("415,165") && roll_nuber == 6
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 )  ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                else if( blue[count].contains("415,165") && roll_nuber == 5
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 0 );
                }
                else if( blue[count].contains("415,165") && roll_nuber == 4
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }
                else {
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }
            }
            else if (blue_Player[count].getLayoutX() == 415 && blue_Player[count].getLayoutY() == 105) {
                if( blue[count].contains("415,105") &&  roll_nuber == 6
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 )  ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 180 );
                }
                else if( blue[count].contains("415,105") && roll_nuber == 5
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 120 );
                }
                else if( blue[count].contains("415,105") && roll_nuber == 4
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                else if( blue[count].contains("415,105") && roll_nuber == 3
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 0 );
                }
                else if( blue[count].contains("415,105") && roll_nuber == 2) {
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60 );
                }

                else {
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() - 60);
                }
            }
            if ( blue[count].contains("415,45") && roll_nuber <= 5) {

                if( roll_nuber == 5
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 )  ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 240 );
                }
                else if( roll_nuber == 4
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 ) ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 180 );
                }
                else if( roll_nuber == 3
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 ) ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 120 );
                }
                else if( roll_nuber == 2
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60);
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                else if(roll_nuber == 1 ){
                    blue_Player[count].setLayoutX(blue_Player[count].getLayoutX() + 60 );
                }
                break;
            }
            if ( blue[count].contains("475,45") ) {

                if( roll_nuber == 4
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && (blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 240 );
                }
                else if( roll_nuber == 3
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 180 );
                }
                else if( roll_nuber == 2
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 120 );
                }
                else if ( roll_nuber == 1
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 105 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 105 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 105 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 105 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
            }
            if ( blue[count].contains("475,105") ) {

                if( roll_nuber == 3
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 180 );
                }
                else if( roll_nuber == 2
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 120 );
                }
                else if ( roll_nuber == 1
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 165 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 165 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 165 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 165 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                break;
            }
             if ( blue[count].contains("475,165") ) {

                if(  roll_nuber == 2
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 120 );
                }
                else if ( roll_nuber == 1
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 225 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 225 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 225 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 225 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                break;
            }
             if ( blue[count].contains("475,225") ) {

                if ( roll_nuber == 1
                        && ( blue_Player1.getLayoutX() != 475 || blue_Player1.getLayoutY() != 285 )
                        && ( blue_Player2.getLayoutX() != 475 || blue_Player2.getLayoutY() != 285 )
                        && ( blue_Player3.getLayoutX() != 475 || blue_Player3.getLayoutY() != 285 )
                        && ( blue_Player4.getLayoutX() != 475 || blue_Player4.getLayoutY() != 285 ) ){
                    blue_Player[count].setLayoutY(blue_Player[count].getLayoutY() + 60 );
                }
                break;
            }//final for blue
        }// for

        int x = (int) blue_Player[count].getLayoutX();
        int y = (int) blue_Player[count].getLayoutY();

        if (count == 0)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt", x + "," + y);
        else if(count == 1)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt", x + "," + y);
        else if(count == 2)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt", x + "," + y);
        else if(count == 3)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt", x + "," + y);

    }// bluePlayer()



    public void redPlayer(int redNumber){

        red_Player[0] = red_Player1;
        red_Player[1] = red_Player2;
        red_Player[2] = red_Player3;
        red_Player[3] = red_Player4;

        count = redNumber ;
        System.out.println(count);
        System.out.println(red_Player[count]);

        ArrayList<String>[] red = new ArrayList[4];
        red[0] = new ArrayList<String>();// player 1
        red[1] = new ArrayList<String>();// player 2
        red[2] = new ArrayList<String>();// player 3
        red[3] = new ArrayList<String>();// player 4

        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt", red[0]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt", red[1]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt", red[2]);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt", red[3]);

        for (int i = 0; i < roll_nuber; i++) {

            if(red_Player[count].getLayoutX() == 200 && red_Player[count].getLayoutY() == 80 && roll_nuber == 6 ){
                red_Player[count].setLayoutX(175);
                red_Player[count].setLayoutY(285);
                safeForRed();
                break;
            }
            else if(red_Player[count].getLayoutX() == 250 && red_Player[count].getLayoutY() == 80 && roll_nuber == 6 ){
                red_Player[count].setLayoutX(175);
                red_Player[count].setLayoutY(285);
                safeForRed();
                break;
            }
            else if(red_Player[count].getLayoutX() == 200 && red_Player[count].getLayoutY() == 130 && roll_nuber == 6 ){
                red_Player[count].setLayoutX(175);
                red_Player[count].setLayoutY(285);
                safeForRed();
                break;
            }
            else if(red_Player[count].getLayoutX() == 250 && red_Player[count].getLayoutY() == 130 && roll_nuber == 6 ){
                red_Player[count].setLayoutX(175);
                red_Player[count].setLayoutY(285);
                safeForRed();
                break;
            }
            else if (red_Player[count].getLayoutY() == 285 && red_Player[count].getLayoutX() >= 175 && red_Player[count].getLayoutX() <= 355) {
                red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
            } else if (red_Player[count].getLayoutX() == 415 && red_Player[count].getLayoutY() >= 105 && red_Player[count].getLayoutY() <= 285) {
                red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60);
            } else if (red_Player[count].getLayoutY() == 45 && red_Player[count].getLayoutX() >= 415 && red_Player[count].getLayoutX() <= 475) {
                red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
            } else if (red_Player[count].getLayoutY() == 285 && red_Player[count].getLayoutX() >= 535 && red_Player[count].getLayoutX() <= 715) {
                red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
            } else if (red_Player[count].getLayoutX() == 535 && red_Player[count].getLayoutY() >= 45 && red_Player[count].getLayoutY() <= 225) {
                red_Player[count].setLayoutY(red_Player[count].getLayoutY() + 60);
            } else if (red_Player[count].getLayoutX() == 775 && red_Player[count].getLayoutY() >= 285 && red_Player[count].getLayoutY() <= 345) {
                red_Player[count].setLayoutY(red_Player[count].getLayoutY() + 60);
            } else if (red_Player[count].getLayoutY() == 405 && red_Player[count].getLayoutX() <= 775 && red_Player[count].getLayoutX() >= 595) {
                red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60);
            } else if (red_Player[count].getLayoutX() == 535 && red_Player[count].getLayoutY() >= 405 && red_Player[count].getLayoutY() <= 585) {
                red_Player[count].setLayoutY(red_Player[count].getLayoutY() + 60);
            } else if (red_Player[count].getLayoutY() == 645 && red_Player[count].getLayoutX() <= 535 && red_Player[count].getLayoutX() >= 475) {
                red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60);
            } else if (red_Player[count].getLayoutX() == 415 && red_Player[count].getLayoutY() >= 465 && red_Player[count].getLayoutY() <= 645) {
                red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60);
            }
            else if (red_Player[count].getLayoutX() == 415 && red_Player[count].getLayoutY() == 405 ) {

                    if( red[count].contains("415,405") && roll_nuber == 6
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 180 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if (red[count].contains("415,405") && roll_nuber == 5){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 240 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if (red[count].contains("415,405") && roll_nuber == 4){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - -240 );
                    }
                    else if (red[count].contains("415,405") && roll_nuber == 3){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 180 );
                    }
                    else {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60);
                    }
                break;
            }
            else if (red_Player[count].getLayoutX() == 355 && red_Player[count].getLayoutY() == 405) {
                    if( red[count].contains("355,405") && roll_nuber == 6
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && (red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 )) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("355,405") && roll_nuber == 5
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && (red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 120 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if (red[count].contains("355,405") && roll_nuber == 4){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 180 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if (red[count].contains("355,405") && roll_nuber == 3){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 180 );
                    }
                    else if (red[count].contains("355,405") && roll_nuber == 2){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 120 );
                    }
                    else {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60);
                    }
                    break;
                }
            else if (red_Player[count].getLayoutX() == 295 && red_Player[count].getLayoutY() == 405) {
                    if( red[count].contains("295,405") && roll_nuber == 6
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && (red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 )  ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("295,405") && roll_nuber == 5
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("295,345") && roll_nuber == 4
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if (red[count].contains("295,345") && roll_nuber == 3){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 120 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60);
                    }
                break;
                }
            else if (red_Player[count].getLayoutX() == 235 && red_Player[count].getLayoutY() == 405) {
                    if( red[count].contains("235,405") &&  roll_nuber == 6
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 )  ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 180 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("235,405") && roll_nuber == 5
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && (red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 120 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("235,405") && roll_nuber == 4
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("235,405") && roll_nuber == 3
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 0 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( red[count].contains("235,405") && roll_nuber == 2) {
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() - 60 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else {
                        red_Player[count].setLayoutY(red_Player[count].getLayoutX() - 60);
                    }
                break;
                }
            if ( red[count].contains("175,405") && roll_nuber <= 5 ) {

                    if( roll_nuber == 5
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 240 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( roll_nuber == 4
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 180 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( roll_nuber == 3
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 120 );
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if( roll_nuber == 2
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60);
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    else if(roll_nuber == 1 ){
                        red_Player[count].setLayoutY(red_Player[count].getLayoutY() - 60 );
                    }
                    break;
                }
            if ( red[count].contains("175,345") ) {

                    if( roll_nuber == 4
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 240 );
                    }
                    else if( roll_nuber == 3
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 180 );
                    }
                    else if( roll_nuber == 2
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 120 );
                    }
                    else if ( roll_nuber == 1
                            && ( red_Player1.getLayoutX() != 235 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 235 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 235 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 235 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60 );
                    }
                break;
            }
            if ( red[count].contains("235,345") ) {

                    if( roll_nuber == 3
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 180 );
                    }
                    else if( roll_nuber == 2
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 120 );
                    }
                    else if ( roll_nuber == 1
                            && ( red_Player1.getLayoutX() != 295 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 295 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 295 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 295 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60 );
                    }
                    break;
                }
            if ( red[count].contains("295,345") ) {

                    if(  roll_nuber == 2
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 120 );
                    }
                    else if ( roll_nuber == 1
                            && ( red_Player1.getLayoutX() != 355 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 355 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 355 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 355 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60 );
                    }
                    break;
                }
                if ( red[count].contains("355,345") ) {

                    if ( roll_nuber == 1
                            && ( red_Player1.getLayoutX() != 415 || red_Player1.getLayoutY() != 345 )
                            && ( red_Player2.getLayoutX() != 415 || red_Player2.getLayoutY() != 345 )
                            && ( red_Player3.getLayoutX() != 415 || red_Player3.getLayoutY() != 345 )
                            && ( red_Player4.getLayoutX() != 415 || red_Player4.getLayoutY() != 345 ) ){
                        red_Player[count].setLayoutX(red_Player[count].getLayoutX() + 60 );
                    }
                    break;
                }//final for blue
            }// for

        int x = (int) red_Player[count].getLayoutX();
        int y = (int) red_Player[count].getLayoutY();

        if (count == 0)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt", x + "," + y);
        else if(count == 1)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt", x + "," + y);
        else if(count == 2)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt", x + "," + y);
        else if(count == 3)
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt", x + "," + y);

    }// redPlayer()






    public void greenPlayer(int greenNumber) {
        for (int k = 0; k < roll_nuber; k++) {

            if(green_Player1.getLayoutX() == 750 && green_Player1.getLayoutY() == 630 && roll_nuber == 6 ){
                green_Player1.setLayoutX(775);
                green_Player1.setLayoutY(405);
                safeForGreen();
                break;
            }
            else if (green_Player1.getLayoutY() == 405 && green_Player1.getLayoutX() <= 775 && green_Player1.getLayoutX() >= 595) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() - 60);
            } else if (green_Player1.getLayoutX() == 535 && green_Player1.getLayoutY() >= 405 && green_Player1.getLayoutY() <= 585) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() + 60);
            } else if (green_Player1.getLayoutY() == 645 && green_Player1.getLayoutX() <= 535 && green_Player1.getLayoutX() >= 475) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() - 60);
            } else if (green_Player1.getLayoutX() == 415 && green_Player1.getLayoutY() >= 465 && green_Player1.getLayoutY() <= 645) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
            } else if (green_Player1.getLayoutY() == 405 && green_Player1.getLayoutX() <= 415 && green_Player1.getLayoutX() >= 235) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() - 60);
            } else if (green_Player1.getLayoutX() == 175 && green_Player1.getLayoutY() >= 345 && green_Player1.getLayoutY() <= 405) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
            } else if (green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() <= 355 && green_Player1.getLayoutX() >= 175) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() + 60);
            } else if (green_Player1.getLayoutX() == 415 && green_Player1.getLayoutY() >= 105 && green_Player1.getLayoutY() <= 285) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
            } else if (green_Player1.getLayoutY() == 45 && green_Player1.getLayoutX() >= 415 && green_Player1.getLayoutX() <= 475) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() + 60);
            } else if (green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() >= 535 && green_Player1.getLayoutX() <= 715) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() + 60);
            } else if (green_Player1.getLayoutX() == 535 && green_Player1.getLayoutY() >= 45 && green_Player1.getLayoutY() <= 225) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() + 60);
            } else if (green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() == 775) {
                green_Player1.setLayoutY(green_Player1.getLayoutY() + 60);
            } else if (green_Player1.getLayoutY() == 345 && green_Player1.getLayoutX() <= 775 && green_Player1.getLayoutX() >= 595) {
                green_Player1.setLayoutX(green_Player1.getLayoutX() - 60);
            }//final for green
        }// for

        int x = (int) green_Player1.getLayoutX();
        int y = (int) green_Player1.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt", x + "," + y);

    }// greenPlayer()




    public void yellowPlayer(int yellowNumber){
        for (int h = 0; h < roll_nuber; h++) {

            if(yellow_Player1.getLayoutX() == 200 && yellow_Player1.getLayoutY() == 630 && roll_nuber == 6 ){
                yellow_Player1.setLayoutX(415);
                yellow_Player1.setLayoutY(645);
                safeForYellow();
                break;
            }
            else if (yellow_Player1.getLayoutX() == 415 && yellow_Player1.getLayoutY() >= 465 && yellow_Player1.getLayoutY() <= 645) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
            } else if (yellow_Player1.getLayoutY() == 405 && yellow_Player1.getLayoutX() <= 415 && yellow_Player1.getLayoutX() >= 235) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60);
            } else if (yellow_Player1.getLayoutX() == 175 && yellow_Player1.getLayoutY() >= 345 && yellow_Player1.getLayoutY() <= 405) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
            } else if (yellow_Player1.getLayoutY() == 285 && yellow_Player1.getLayoutX() <= 355 && yellow_Player1.getLayoutX() >= 175) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60);
            } else if (yellow_Player1.getLayoutX() == 415 && yellow_Player1.getLayoutY() >= 105 && yellow_Player1.getLayoutY() <= 285) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
            } else if (yellow_Player1.getLayoutY() == 45 && yellow_Player1.getLayoutX() >= 415 && yellow_Player1.getLayoutX() <= 475) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60);
            } else if (yellow_Player1.getLayoutY() == 285 && yellow_Player1.getLayoutX() >= 535 && yellow_Player1.getLayoutX() <= 715) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60);
            } else if (yellow_Player1.getLayoutX() == 535 && yellow_Player1.getLayoutY() >= 45 && yellow_Player1.getLayoutY() <= 225) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
            } else if (yellow_Player1.getLayoutX() == 775 && yellow_Player1.getLayoutY() >= 285 && yellow_Player1.getLayoutY() <= 345) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
            } else if (yellow_Player1.getLayoutY() == 405 && yellow_Player1.getLayoutX() <= 775 && yellow_Player1.getLayoutX() >= 595) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60);
            } else if (yellow_Player1.getLayoutX() == 535 && yellow_Player1.getLayoutY() >= 405 && yellow_Player1.getLayoutY() <= 585) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
            } else if (yellow_Player1.getLayoutY() == 645 && yellow_Player1.getLayoutX() == 535) {
                yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60);
            } else if (yellow_Player1.getLayoutX() == 475 && yellow_Player1.getLayoutY() <= 645 && yellow_Player1.getLayoutY() >= 465) {
                yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
            }//final for yellow
        }// for

        int x = (int) yellow_Player1.getLayoutX();
        int y = (int) yellow_Player1.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt", x + "," + y);

    }// yellowPlayer()





     // First Spot is Safe For all Players ..
    public void safeForBlue(){

        if(red_Player1.getLayoutX() == 535 && red_Player1.getLayoutY() == 45 ){
            red_Player1.setLayoutX(200);
            red_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt","200,80");
        }
        else if(red_Player2.getLayoutX() == 535 && red_Player2.getLayoutY() == 45 ){
            red_Player2.setLayoutX(250);
            red_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt","250,80");
        }
        else if(red_Player3.getLayoutX() == 535 && red_Player3.getLayoutY() == 45 ){
            red_Player3.setLayoutX(200);
            red_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt","200,130");
        }
        else if(red_Player4.getLayoutX() == 535 && red_Player4.getLayoutY() == 45 ){
            red_Player4.setLayoutX(250);
            red_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt","250,130");
        }
        else if(green_Player1.getLayoutX() == 535 && green_Player1.getLayoutY() == 45 ){
            green_Player1.setLayoutX(750);
            green_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt","750,630");
        }
        else if(green_Player2.getLayoutX() == 535 && green_Player2.getLayoutY() == 45 ){
            green_Player2.setLayoutX(800);
            green_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt","800,630");
        }
        else if(green_Player3.getLayoutX() == 535 && green_Player3.getLayoutY() == 45 ){
            green_Player3.setLayoutX(750);
            green_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt","750,680");
        }
        else if(green_Player4.getLayoutX() == 535 && green_Player4.getLayoutY() == 45 ){
            green_Player4.setLayoutX(800);
            green_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt","800,680");
        }
        else if(yellow_Player1.getLayoutX() == 535 && yellow_Player1.getLayoutY() == 45 ){
            yellow_Player1.setLayoutX(200);
            yellow_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt","200,630");
        }
        else if(yellow_Player2.getLayoutX() == 535 && yellow_Player2.getLayoutY() == 45 ){
            yellow_Player2.setLayoutX(250);
            yellow_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt","250,630");
        }
        else if(yellow_Player3.getLayoutX() == 535 && yellow_Player3.getLayoutY() == 45 ){
            yellow_Player3.setLayoutX(200);
            yellow_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt","200,680");
        }
        else if(yellow_Player4.getLayoutX() == 535 && yellow_Player4.getLayoutY() == 45 ){
            yellow_Player4.setLayoutX(250);
            yellow_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt","250,680");
        }

    }// safeForBlue()


    public void safeForRed(){

        if(blue_Player1.getLayoutX() == 175 && blue_Player1.getLayoutY() == 285 ){
            blue_Player1.setLayoutX(750);
            blue_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt","750,80");
        }
        else if(blue_Player2.getLayoutX() == 175 && blue_Player2.getLayoutY() == 285 ){
            blue_Player2.setLayoutX(800);
            blue_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt","800,80");
        }
        else if(blue_Player3.getLayoutX() == 175 && blue_Player3.getLayoutY() == 285 ){
            blue_Player3.setLayoutX(750);
            blue_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt","750,130");
        }
        else if(blue_Player4.getLayoutX() == 175 && blue_Player4.getLayoutY() == 285 ){
            blue_Player4.setLayoutX(800);
            blue_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt","800,130");
        }
        else if(green_Player1.getLayoutX() == 175 && green_Player1.getLayoutY() == 285 ){
            green_Player1.setLayoutX(750);
            green_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt","750,630");
        }
        else if(green_Player2.getLayoutX() == 175 && green_Player2.getLayoutY() == 285 ){
            green_Player2.setLayoutX(800);
            green_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt","800,630");
        }
        else if(green_Player3.getLayoutX() == 175 && green_Player3.getLayoutY() == 285 ){
            green_Player3.setLayoutX(750);
            green_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt","750,680");
        }
        else if(green_Player4.getLayoutX() == 175 && green_Player4.getLayoutY() == 285 ){
            green_Player4.setLayoutX(800);
            green_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt","800,680");
        }
        else if(yellow_Player1.getLayoutX() == 175 && yellow_Player1.getLayoutY() == 285 ){
            yellow_Player1.setLayoutX(200);
            yellow_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt","200,630");
        }
        else if(yellow_Player2.getLayoutX() == 175 && yellow_Player2.getLayoutY() == 285 ){
            yellow_Player2.setLayoutX(250);
            yellow_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt","250,630");
        }
        else if(yellow_Player3.getLayoutX() == 175 && yellow_Player3.getLayoutY() == 285 ){
            yellow_Player3.setLayoutX(200);
            yellow_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt","200,680");
        }
        else if(yellow_Player4.getLayoutX() == 175 && yellow_Player4.getLayoutY() == 285 ){
            yellow_Player4.setLayoutX(250);
            yellow_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt","250,680");
        }

    }// safeForRed()

    public void safeForGreen(){

        if(red_Player1.getLayoutX() == 775 && red_Player1.getLayoutY() == 405 ){
            red_Player1.setLayoutX(200);
            red_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt","200,80");
        }
        else if(red_Player2.getLayoutX() == 775 && red_Player2.getLayoutY() == 405 ){
            red_Player2.setLayoutX(250);
            red_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt","250,80");
        }
        else if(red_Player3.getLayoutX() == 775 && red_Player3.getLayoutY() == 405 ){
            red_Player3.setLayoutX(200);
            red_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt","200,130");
        }
        else if(red_Player4.getLayoutX() == 775 && red_Player4.getLayoutY() == 405 ){
            red_Player4.setLayoutX(250);
            red_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt","250,130");
        }
        else if(blue_Player1.getLayoutX() == 775 && blue_Player1.getLayoutY() == 405 ){
            blue_Player1.setLayoutX(750);
            blue_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt","750,80");
        }
        else if(blue_Player2.getLayoutX() == 775 && blue_Player2.getLayoutY() == 405 ){
            blue_Player2.setLayoutX(800);
            blue_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt","800,80");
        }
        else if(blue_Player3.getLayoutX() == 775 && blue_Player3.getLayoutY() == 405 ){
            blue_Player3.setLayoutX(750);
            blue_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt","750,130");
        }
        else if(blue_Player4.getLayoutX() == 775 && blue_Player4.getLayoutY() == 405 ){
            blue_Player4.setLayoutX(800);
            blue_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt","800,130");
        }
        else if(yellow_Player1.getLayoutX() == 775 && yellow_Player1.getLayoutY() == 405 ){
            yellow_Player1.setLayoutX(200);
            yellow_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt","200,630");
        }
        else if(yellow_Player2.getLayoutX() == 775 && yellow_Player2.getLayoutY() == 405 ){
            yellow_Player2.setLayoutX(250);
            yellow_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt","250,630");
        }
        else if(yellow_Player3.getLayoutX() == 775 && yellow_Player3.getLayoutY() == 405 ){
            yellow_Player3.setLayoutX(200);
            yellow_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt","200,680");
        }
        else if(yellow_Player4.getLayoutX() == 775 && yellow_Player4.getLayoutY() == 405 ){
            yellow_Player4.setLayoutX(250);
            yellow_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt","250,680");
        }

    }// safeForBlue()

    public void safeForYellow(){

        if(red_Player1.getLayoutX() == 415 && red_Player1.getLayoutY() == 645 ){
            red_Player1.setLayoutX(200);
            red_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt","200,80");
        }
        else if(red_Player2.getLayoutX() == 415 && red_Player2.getLayoutY() == 645 ){
            red_Player2.setLayoutX(250);
            red_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt","250,80");
        }
        else if(red_Player3.getLayoutX() == 415 && red_Player3.getLayoutY() == 645 ){
            red_Player3.setLayoutX(200);
            red_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt","200,130");
        }
        else if(red_Player4.getLayoutX() == 415 && red_Player4.getLayoutY() == 645 ){
            red_Player4.setLayoutX(250);
            red_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt","250,130");
        }
        else if(green_Player1.getLayoutX() == 415 && green_Player1.getLayoutY() == 645 ){
            green_Player1.setLayoutX(750);
            green_Player1.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt","750,630");
        }
        else if(green_Player2.getLayoutX() == 415 && green_Player2.getLayoutY() == 645 ){
            green_Player2.setLayoutX(800);
            green_Player2.setLayoutY(630);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt","800,630");
        }
        else if(green_Player3.getLayoutX() == 415 && green_Player3.getLayoutY() == 645 ){
            green_Player3.setLayoutX(750);
            green_Player3.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt","750,680");
        }
        else if(green_Player4.getLayoutX() == 415 && green_Player4.getLayoutY() == 645 ){
            green_Player4.setLayoutX(800);
            green_Player4.setLayoutY(680);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt","800,680");
        }
        else if(blue_Player1.getLayoutX() == 415 && blue_Player1.getLayoutY() == 645 ){
            blue_Player1.setLayoutX(750);
            blue_Player1.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt","750,80");
        }
        else if(blue_Player2.getLayoutX() == 415 && blue_Player2.getLayoutY() == 645 ){
            blue_Player2.setLayoutX(800);
            blue_Player2.setLayoutY(80);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt","800,80");
        }
        else if(blue_Player3.getLayoutX() == 415 && blue_Player3.getLayoutY() == 645 ){
            blue_Player3.setLayoutX(750);
            blue_Player3.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt","750,130");
        }
        else if(blue_Player4.getLayoutX() == 415 && blue_Player4.getLayoutY() == 645 ){
            blue_Player4.setLayoutX(800);
            blue_Player4.setLayoutY(130);
            fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt","800,130");
        }

    }// safeForYellow()



} // end of class

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
    Game_Methods game_methods = new Game_Methods();
    protected boolean stop = false ;

@FXML
    protected ImageView  blue_Player1, blue_Player2, blue_Player3, blue_Player4 ,
        red_Player1, red_Player2, red_Player3, red_Player4 ,
        green_Player1, green_Player2, green_Player3, green_Player4 ,
        yellow_Player1, yellow_Player2, yellow_Player3, yellow_Player4 ,
        dice_Image;
    @FXML
    Button dice_Button, move_p1, move_p2, move_p3, move_p4;
    @FXML
    Label time_Label , date_Label ;
    @FXML
    TextField turn_TextField, blue_TextField, red_TextField, green_TextField, yellow_TextField;
    int roll_nuber = 0 ;
    int number = 0 ;
    int randomNum;


    ArrayList<String> numberOfPlayers = new ArrayList<>();
    ArrayList<String> player1 = new ArrayList<>();
    ArrayList<String> player2 = new ArrayList<>();
    ArrayList<String> player3 = new ArrayList<>();
    ArrayList<String> player4 = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Players First Position
        game_methods.firstPos();

        fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

        if(numberOfPlayers.contains("2")){
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            red_TextField.setText(player1.get(0));
            blue_TextField.setText(player2.get(0));
            green_TextField.setVisible(false);
            yellow_TextField.setVisible(false);
            green_Player1.setVisible(false);
            green_Player2.setVisible(false);
            green_Player3.setVisible(false);
            green_Player4.setVisible(false);
            yellow_Player1.setVisible(false);
            yellow_Player2.setVisible(false);
            yellow_Player3.setVisible(false);
            yellow_Player4.setVisible(false);
        }
        else if (numberOfPlayers.contains("3")) {
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",player3);
            red_TextField.setText(player1.get(0));
            blue_TextField.setText(player2.get(0));
            green_TextField.setText(player3.get(0));
            yellow_TextField.setVisible(false);
            yellow_Player1.setVisible(false);
            yellow_Player2.setVisible(false);
            yellow_Player3.setVisible(false);
            yellow_Player4.setVisible(false);
        }
        else if (numberOfPlayers.contains("4")) {
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt",player1);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt",player2);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt",player3);
            fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4.txt",player4);
            red_TextField.setText(player1.get(0));
            blue_TextField.setText(player2.get(0));
            green_TextField.setText(player3.get(0));
            yellow_TextField.setText(player4.get(0));
        }
        turn_TextField.setText("Blue");
        timeNow();

    }// initialize()

    public void dice() throws FileNotFoundException {
        move_p1.setVisible(true);
        move_p2.setVisible(true);
        move_p3.setVisible(true);
        move_p4.setVisible(true);


        roll_nuber = roll_Dice();
        checkFirstSix();

        if(roll_nuber == 6){
            number --; // baraye jayze 6
            checkFirstPos();
        }
       System.out.println(roll_nuber);
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
    public int roll_Dice(){
        randomNum = ThreadLocalRandom.current().nextInt(1 , 6 + 1);
        return randomNum;
    }// roll_Dice()

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


    public void move_Player1(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
                bluePlayer1();
        }
        else if (turn_TextField.getText().equals("Red")){
                redPlayer1();
        }
        else if(turn_TextField.getText().equals("Green")){
                greenPlayer1();
        }
        else if(turn_TextField.getText().equals("Yellow")){
                yellowPlayer1();
        }
        turn();

    }
    public void move_Player2(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer2();
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer2();
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer2();
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer2();
        }
        turn();

    }
    public void move_Player3(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer3();
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer3();
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer3();
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer3();
        }
        turn();

    }
    public void move_Player4(){

        dice_Image.setVisible(false);
        dice_Button.setVisible(true);
        if(turn_TextField.getText().equals("Blue")) {
            bluePlayer4();
        }
        else if (turn_TextField.getText().equals("Red")){
            redPlayer4();
        }
        else if(turn_TextField.getText().equals("Green")){
            greenPlayer4();
        }
        else if(turn_TextField.getText().equals("Yellow")){
            yellowPlayer4();
        }
        turn();

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
    public void bluePlayer1(){
        for (int i = 0; i < roll_nuber; i++) {

            if(blue_Player1.getLayoutX() == 750 && blue_Player1.getLayoutY() == 80 && roll_nuber == 6 ){
                blue_Player1.setLayoutX(535);
                blue_Player1.setLayoutY(45);
                safeForBlue();
                break;
            }
            else if (blue_Player1.getLayoutY() == 285 && blue_Player1.getLayoutX() >= 535 && blue_Player1.getLayoutX() <= 715) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60);
            } else if (blue_Player1.getLayoutX() == 535 && blue_Player1.getLayoutY() >= 45 && blue_Player1.getLayoutY() <= 225) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
            } else if (blue_Player1.getLayoutX() == 775 && blue_Player1.getLayoutY() >= 285 && blue_Player1.getLayoutY() <= 345) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
            } else if (blue_Player1.getLayoutY() == 405 && blue_Player1.getLayoutX() <= 775 && blue_Player1.getLayoutX() >= 595) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60);
            } else if (blue_Player1.getLayoutX() == 535 && blue_Player1.getLayoutY() >= 405 && blue_Player1.getLayoutY() <= 585) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
            } else if (blue_Player1.getLayoutY() == 645 && blue_Player1.getLayoutX() <= 535 && blue_Player1.getLayoutX() >= 475) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60);
            } else if (blue_Player1.getLayoutX() == 415 && blue_Player1.getLayoutY() >= 465 && blue_Player1.getLayoutY() <= 645) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
            } else if (blue_Player1.getLayoutY() == 405 && blue_Player1.getLayoutX() <= 415 && blue_Player1.getLayoutX() >= 235) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60);
            } else if (blue_Player1.getLayoutX() == 175 && blue_Player1.getLayoutY() >= 345 && blue_Player1.getLayoutY() <= 405) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
            } else if (blue_Player1.getLayoutY() == 285 && blue_Player1.getLayoutX() <= 355 && blue_Player1.getLayoutX() >= 175) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60);
            } else if (blue_Player1.getLayoutX() == 415 && blue_Player1.getLayoutY() >= 105 && blue_Player1.getLayoutY() <= 285) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
            } else if (blue_Player1.getLayoutY() == 45 && blue_Player1.getLayoutX() == 415) {
                blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60);
            } else if (blue_Player1.getLayoutX() == 475 && blue_Player1.getLayoutY() >= 45 && blue_Player1.getLayoutY() <= 225) {
                blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
            }//final for blue
        }// for

        int x = (int) blue_Player1.getLayoutX();
        int y = (int) blue_Player1.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt", x + "," + y);

    }// bluePlayer1()
    public void bluePlayer2(){
        for (int i = 0; i < roll_nuber; i++) {

            if(blue_Player2.getLayoutX() == 800 && blue_Player2.getLayoutY() == 80 && roll_nuber == 6 ){
                blue_Player2.setLayoutX(535);
                blue_Player2.setLayoutY(45);
                safeForBlue();
                break;
            }
            else if (blue_Player2.getLayoutY() == 285 && blue_Player2.getLayoutX() >= 535 && blue_Player2.getLayoutX() <= 715) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() + 60);
            } else if (blue_Player2.getLayoutX() == 535 && blue_Player2.getLayoutY() >= 45 && blue_Player2.getLayoutY() <= 225) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() + 60);
            } else if (blue_Player2.getLayoutX() == 775 && blue_Player2.getLayoutY() >= 285 && blue_Player2.getLayoutY() <= 345) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() + 60);
            } else if (blue_Player2.getLayoutY() == 405 && blue_Player2.getLayoutX() <= 775 && blue_Player2.getLayoutX() >= 595) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() - 60);
            } else if (blue_Player2.getLayoutX() == 535 && blue_Player2.getLayoutY() >= 405 && blue_Player2.getLayoutY() <= 585) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() + 60);
            } else if (blue_Player2.getLayoutY() == 645 && blue_Player2.getLayoutX() <= 535 && blue_Player2.getLayoutX() >= 475) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() - 60);
            } else if (blue_Player2.getLayoutX() == 415 && blue_Player2.getLayoutY() >= 465 && blue_Player2.getLayoutY() <= 645) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() - 60);
            } else if (blue_Player2.getLayoutY() == 405 && blue_Player2.getLayoutX() <= 415 && blue_Player2.getLayoutX() >= 235) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() - 60);
            } else if (blue_Player2.getLayoutX() == 175 && blue_Player2.getLayoutY() >= 345 && blue_Player2.getLayoutY() <= 405) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() - 60);
            } else if (blue_Player2.getLayoutY() == 285 && blue_Player2.getLayoutX() <= 355 && blue_Player2.getLayoutX() >= 175) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() + 60);
            } else if (blue_Player2.getLayoutX() == 415 && blue_Player2.getLayoutY() >= 105 && blue_Player2.getLayoutY() <= 285) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() - 60);
            } else if (blue_Player2.getLayoutY() == 45 && blue_Player2.getLayoutX() == 415) {
                blue_Player2.setLayoutX(blue_Player2.getLayoutX() + 60);
            } else if (blue_Player2.getLayoutX() == 475 && blue_Player2.getLayoutY() >= 45 && blue_Player2.getLayoutY() <= 225) {
                blue_Player2.setLayoutY(blue_Player2.getLayoutY() + 60);
            }//final for blue
        }// for
        int x = (int) blue_Player2.getLayoutX();
        int y = (int) blue_Player2.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt", x + "," + y);

    }// bluePlayer2()

    public void bluePlayer3(){
        for (int i = 0; i < roll_nuber; i++) {

            if(blue_Player3.getLayoutX() == 750 && blue_Player3.getLayoutY() == 130 && roll_nuber == 6 ){
                blue_Player3.setLayoutX(535);
                blue_Player3.setLayoutY(45);
                safeForBlue();
                break;
            }
            else if (blue_Player3.getLayoutY() == 285 && blue_Player3.getLayoutX() >= 535 && blue_Player3.getLayoutX() <= 715) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() + 60);
            } else if (blue_Player3.getLayoutX() == 535 && blue_Player3.getLayoutY() >= 45 && blue_Player3.getLayoutY() <= 225) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() + 60);
            } else if (blue_Player3.getLayoutX() == 775 && blue_Player3.getLayoutY() >= 285 && blue_Player3.getLayoutY() <= 345) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() + 60);
            } else if (blue_Player3.getLayoutY() == 405 && blue_Player3.getLayoutX() <= 775 && blue_Player3.getLayoutX() >= 595) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() - 60);
            } else if (blue_Player3.getLayoutX() == 535 && blue_Player3.getLayoutY() >= 405 && blue_Player3.getLayoutY() <= 585) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() + 60);
            } else if (blue_Player3.getLayoutY() == 645 && blue_Player3.getLayoutX() <= 535 && blue_Player3.getLayoutX() >= 475) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() - 60);
            } else if (blue_Player3.getLayoutX() == 415 && blue_Player3.getLayoutY() >= 465 && blue_Player3.getLayoutY() <= 645) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() - 60);
            } else if (blue_Player3.getLayoutY() == 405 && blue_Player3.getLayoutX() <= 415 && blue_Player3.getLayoutX() >= 235) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() - 60);
            } else if (blue_Player3.getLayoutX() == 175 && blue_Player3.getLayoutY() >= 345 && blue_Player3.getLayoutY() <= 405) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() - 60);
            } else if (blue_Player3.getLayoutY() == 285 && blue_Player3.getLayoutX() <= 355 && blue_Player3.getLayoutX() >= 175) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() + 60);
            } else if (blue_Player3.getLayoutX() == 415 && blue_Player3.getLayoutY() >= 105 && blue_Player3.getLayoutY() <= 285) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() - 60);
            } else if (blue_Player3.getLayoutY() == 45 && blue_Player3.getLayoutX() == 415) {
                blue_Player3.setLayoutX(blue_Player3.getLayoutX() + 60);
            } else if (blue_Player3.getLayoutX() == 475 && blue_Player3.getLayoutY() >= 45 && blue_Player3.getLayoutY() <= 225) {
                blue_Player3.setLayoutY(blue_Player3.getLayoutY() + 60);
            }//final for blue
        }// for

        int x = (int) blue_Player3.getLayoutX();
        int y = (int) blue_Player3.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt", x + "," + y);

    }// bluePlayer3()

    public void bluePlayer4(){
        for (int i = 0; i < roll_nuber; i++) {

            if(blue_Player4.getLayoutX() == 800 && blue_Player4.getLayoutY() == 130 && roll_nuber == 6 ){
                blue_Player4.setLayoutX(535);
                blue_Player4.setLayoutY(45);
                safeForBlue();
                break;
            }
            else if (blue_Player4.getLayoutY() == 285 && blue_Player4.getLayoutX() >= 535 && blue_Player4.getLayoutX() <= 715) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() + 60);
            } else if (blue_Player4.getLayoutX() == 535 && blue_Player4.getLayoutY() >= 45 && blue_Player4.getLayoutY() <= 225) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() + 60);
            } else if (blue_Player4.getLayoutX() == 775 && blue_Player4.getLayoutY() >= 285 && blue_Player4.getLayoutY() <= 345) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() + 60);
            } else if (blue_Player4.getLayoutY() == 405 && blue_Player4.getLayoutX() <= 775 && blue_Player4.getLayoutX() >= 595) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() - 60);
            } else if (blue_Player4.getLayoutX() == 535 && blue_Player4.getLayoutY() >= 405 && blue_Player4.getLayoutY() <= 585) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() + 60);
            } else if (blue_Player4.getLayoutY() == 645 && blue_Player4.getLayoutX() <= 535 && blue_Player4.getLayoutX() >= 475) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() - 60);
            } else if (blue_Player4.getLayoutX() == 415 && blue_Player4.getLayoutY() >= 465 && blue_Player4.getLayoutY() <= 645) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() - 60);
            } else if (blue_Player4.getLayoutY() == 405 && blue_Player4.getLayoutX() <= 415 && blue_Player4.getLayoutX() >= 235) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() - 60);
            } else if (blue_Player4.getLayoutX() == 175 && blue_Player4.getLayoutY() >= 345 && blue_Player4.getLayoutY() <= 405) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() - 60);
            } else if (blue_Player4.getLayoutY() == 285 && blue_Player4.getLayoutX() <= 355 && blue_Player4.getLayoutX() >= 175) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() + 60);
            } else if (blue_Player4.getLayoutX() == 415 && blue_Player4.getLayoutY() >= 105 && blue_Player4.getLayoutY() <= 285) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() - 60);
            } else if (blue_Player4.getLayoutY() == 45 && blue_Player4.getLayoutX() == 415) {
                blue_Player4.setLayoutX(blue_Player4.getLayoutX() + 60);
            } else if (blue_Player4.getLayoutX() == 475 && blue_Player4.getLayoutY() >= 45 && blue_Player4.getLayoutY() <= 225) {
                blue_Player4.setLayoutY(blue_Player4.getLayoutY() + 60);
            }//final for blue
        }// for

        int x = (int) blue_Player4.getLayoutX();
        int y = (int) blue_Player4.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt", x + "," + y);

    }// bluePlayer4()
    public void redPlayer1(){
        for (int i = 0; i < roll_nuber; i++) {

            if(red_Player1.getLayoutX() == 200 && red_Player1.getLayoutY() == 80 && roll_nuber == 6 ){
                red_Player1.setLayoutX(175);
                red_Player1.setLayoutY(285);
                safeForRed();
                break;
            }
            else if (red_Player1.getLayoutY() == 285 && red_Player1.getLayoutX() >= 175 && red_Player1.getLayoutX() <= 355) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() + 60);
            } else if (red_Player1.getLayoutX() == 415 && red_Player1.getLayoutY() >= 105 && red_Player1.getLayoutY() <= 285) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() - 60);
            } else if (red_Player1.getLayoutY() == 45 && red_Player1.getLayoutX() >= 415 && red_Player1.getLayoutX() <= 475) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() + 60);
            } else if (red_Player1.getLayoutY() == 285 && red_Player1.getLayoutX() >= 535 && red_Player1.getLayoutX() <= 715) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() + 60);
            } else if (red_Player1.getLayoutX() == 535 && red_Player1.getLayoutY() >= 45 && red_Player1.getLayoutY() <= 225) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
            } else if (red_Player1.getLayoutX() == 775 && red_Player1.getLayoutY() >= 285 && red_Player1.getLayoutY() <= 345) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
            } else if (red_Player1.getLayoutY() == 405 && red_Player1.getLayoutX() <= 775 && red_Player1.getLayoutX() >= 595) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() - 60);
            } else if (red_Player1.getLayoutX() == 535 && red_Player1.getLayoutY() >= 405 && red_Player1.getLayoutY() <= 585) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
            } else if (red_Player1.getLayoutY() == 645 && red_Player1.getLayoutX() <= 535 && red_Player1.getLayoutX() >= 475) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() - 60);
            } else if (red_Player1.getLayoutX() == 415 && red_Player1.getLayoutY() >= 465 && red_Player1.getLayoutY() <= 645) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() - 60);
            } else if (red_Player1.getLayoutY() == 405 && red_Player1.getLayoutX() <= 415 && red_Player1.getLayoutX() >= 235) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() - 60);
            } else if (red_Player1.getLayoutY() == 405 && red_Player1.getLayoutX() == 175) {
                red_Player1.setLayoutY(red_Player1.getLayoutY() - 60);
            } else if (red_Player1.getLayoutY() == 345 && red_Player1.getLayoutX() >= 175 && red_Player1.getLayoutX() <= 355) {
                red_Player1.setLayoutX(red_Player1.getLayoutX() + 60);
            }//final for red
        }// for

        int x = (int) red_Player1.getLayoutX();
        int y = (int) red_Player1.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt", x + "," + y);

    }// redPlayer1()

    public void redPlayer2(){
        for (int i = 0; i < roll_nuber; i++) {

            if(red_Player2.getLayoutX() == 250 && red_Player2.getLayoutY() == 80 && roll_nuber == 6 ){
                red_Player2.setLayoutX(175);
                red_Player2.setLayoutY(285);
                safeForRed();
                break;
            }
            else if (red_Player2.getLayoutY() == 285 && red_Player2.getLayoutX() >= 175 && red_Player2.getLayoutX() <= 355) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() + 60);
            } else if (red_Player2.getLayoutX() == 415 && red_Player2.getLayoutY() >= 105 && red_Player2.getLayoutY() <= 285) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() - 60);
            } else if (red_Player2.getLayoutY() == 45 && red_Player2.getLayoutX() >= 415 && red_Player2.getLayoutX() <= 475) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() + 60);
            } else if (red_Player2.getLayoutY() == 285 && red_Player2.getLayoutX() >= 535 && red_Player2.getLayoutX() <= 715) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() + 60);
            } else if (red_Player2.getLayoutX() == 535 && red_Player2.getLayoutY() >= 45 && red_Player2.getLayoutY() <= 225) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() + 60);
            } else if (red_Player2.getLayoutX() == 775 && red_Player2.getLayoutY() >= 285 && red_Player2.getLayoutY() <= 345) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() + 60);
            } else if (red_Player2.getLayoutY() == 405 && red_Player2.getLayoutX() <= 775 && red_Player2.getLayoutX() >= 595) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() - 60);
            } else if (red_Player2.getLayoutX() == 535 && red_Player2.getLayoutY() >= 405 && red_Player2.getLayoutY() <= 585) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() + 60);
            } else if (red_Player2.getLayoutY() == 645 && red_Player2.getLayoutX() <= 535 && red_Player2.getLayoutX() >= 475) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() - 60);
            } else if (red_Player2.getLayoutX() == 415 && red_Player2.getLayoutY() >= 465 && red_Player2.getLayoutY() <= 645) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() - 60);
            } else if (red_Player2.getLayoutY() == 405 && red_Player2.getLayoutX() <= 415 && red_Player2.getLayoutX() >= 235) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() - 60);
            } else if (red_Player2.getLayoutY() == 405 && red_Player2.getLayoutX() == 175) {
                red_Player2.setLayoutY(red_Player2.getLayoutY() - 60);
            } else if (red_Player2.getLayoutY() == 345 && red_Player2.getLayoutX() >= 175 && red_Player2.getLayoutX() <= 355) {
                red_Player2.setLayoutX(red_Player2.getLayoutX() + 60);
            }//final for red
        }// for

        int x = (int) red_Player2.getLayoutX();
        int y = (int) red_Player2.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt", x + "," + y);

    }// redPlayer2()

    public void redPlayer3(){
        for (int i = 0; i < roll_nuber; i++) {

            if(red_Player3.getLayoutX() == 200 && red_Player3.getLayoutY() == 130 && roll_nuber == 6 ){
                red_Player3.setLayoutX(175);
                red_Player3.setLayoutY(285);
                safeForRed();
                break;
            }
            else if (red_Player3.getLayoutY() == 285 && red_Player3.getLayoutX() >= 175 && red_Player3.getLayoutX() <= 355) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() + 60);
            } else if (red_Player3.getLayoutX() == 415 && red_Player3.getLayoutY() >= 105 && red_Player3.getLayoutY() <= 285) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() - 60);
            } else if (red_Player3.getLayoutY() == 45 && red_Player3.getLayoutX() >= 415 && red_Player3.getLayoutX() <= 475) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() + 60);
            } else if (red_Player3.getLayoutY() == 285 && red_Player3.getLayoutX() >= 535 && red_Player3.getLayoutX() <= 715) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() + 60);
            } else if (red_Player3.getLayoutX() == 535 && red_Player3.getLayoutY() >= 45 && red_Player3.getLayoutY() <= 225) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() + 60);
            } else if (red_Player3.getLayoutX() == 775 && red_Player3.getLayoutY() >= 285 && red_Player3.getLayoutY() <= 345) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() + 60);
            } else if (red_Player3.getLayoutY() == 405 && red_Player3.getLayoutX() <= 775 && red_Player3.getLayoutX() >= 595) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() - 60);
            } else if (red_Player3.getLayoutX() == 535 && red_Player3.getLayoutY() >= 405 && red_Player3.getLayoutY() <= 585) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() + 60);
            } else if (red_Player3.getLayoutY() == 645 && red_Player3.getLayoutX() <= 535 && red_Player3.getLayoutX() >= 475) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() - 60);
            } else if (red_Player3.getLayoutX() == 415 && red_Player3.getLayoutY() >= 465 && red_Player3.getLayoutY() <= 645) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() - 60);
            } else if (red_Player3.getLayoutY() == 405 && red_Player3.getLayoutX() <= 415 && red_Player3.getLayoutX() >= 235) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() - 60);
            } else if (red_Player3.getLayoutY() == 405 && red_Player3.getLayoutX() == 175) {
                red_Player3.setLayoutY(red_Player3.getLayoutY() - 60);
            } else if (red_Player3.getLayoutY() == 345 && red_Player3.getLayoutX() >= 175 && red_Player3.getLayoutX() <= 355) {
                red_Player3.setLayoutX(red_Player3.getLayoutX() + 60);
            }//final for red
        }// for

        int x = (int) red_Player3.getLayoutX();
        int y = (int) red_Player3.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt", x + "," + y);

    }// redPlayer3()

    public void redPlayer4(){
        for (int i = 0; i < roll_nuber; i++) {

            if(red_Player4.getLayoutX() == 250 && red_Player4.getLayoutY() == 130 && roll_nuber == 6 ){
                red_Player4.setLayoutX(175);
                red_Player4.setLayoutY(285);
                safeForRed();
                break;
            }
            else if (red_Player4.getLayoutY() == 285 && red_Player4.getLayoutX() >= 175 && red_Player4.getLayoutX() <= 355) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() + 60);
            } else if (red_Player4.getLayoutX() == 415 && red_Player4.getLayoutY() >= 105 && red_Player4.getLayoutY() <= 285) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() - 60);
            } else if (red_Player4.getLayoutY() == 45 && red_Player4.getLayoutX() >= 415 && red_Player4.getLayoutX() <= 475) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() + 60);
            } else if (red_Player4.getLayoutY() == 285 && red_Player4.getLayoutX() >= 535 && red_Player4.getLayoutX() <= 715) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() + 60);
            } else if (red_Player4.getLayoutX() == 535 && red_Player4.getLayoutY() >= 45 && red_Player4.getLayoutY() <= 225) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() + 60);
            } else if (red_Player4.getLayoutX() == 775 && red_Player4.getLayoutY() >= 285 && red_Player4.getLayoutY() <= 345) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() + 60);
            } else if (red_Player4.getLayoutY() == 405 && red_Player4.getLayoutX() <= 775 && red_Player4.getLayoutX() >= 595) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() - 60);
            } else if (red_Player4.getLayoutX() == 535 && red_Player4.getLayoutY() >= 405 && red_Player4.getLayoutY() <= 585) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() + 60);
            } else if (red_Player4.getLayoutY() == 645 && red_Player4.getLayoutX() <= 535 && red_Player4.getLayoutX() >= 475) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() - 60);
            } else if (red_Player4.getLayoutX() == 415 && red_Player4.getLayoutY() >= 465 && red_Player4.getLayoutY() <= 645) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() - 60);
            } else if (red_Player4.getLayoutY() == 405 && red_Player4.getLayoutX() <= 415 && red_Player4.getLayoutX() >= 235) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() - 60);
            } else if (red_Player4.getLayoutY() == 405 && red_Player4.getLayoutX() == 175) {
                red_Player4.setLayoutY(red_Player4.getLayoutY() - 60);
            } else if (red_Player4.getLayoutY() == 345 && red_Player4.getLayoutX() >= 175 && red_Player4.getLayoutX() <= 355) {
                red_Player4.setLayoutX(red_Player4.getLayoutX() + 60);
            }//final for red
        }// for

        int x = (int) red_Player4.getLayoutX();
        int y = (int) red_Player4.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt", x + "," + y);

    }// redPlayer4()

    public void greenPlayer1() {
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

    }// greenPlayer1()

    public void greenPlayer2() {
        for (int k = 0; k < roll_nuber; k++) {

            if(green_Player2.getLayoutX() == 800 && green_Player2.getLayoutY() == 630 && roll_nuber == 6 ){
                green_Player2.setLayoutX(775);
                green_Player2.setLayoutY(405);
                safeForGreen();
                break;
            }
            else if (green_Player2.getLayoutY() == 405 && green_Player2.getLayoutX() <= 775 && green_Player2.getLayoutX() >= 595) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() - 60);
            } else if (green_Player2.getLayoutX() == 535 && green_Player2.getLayoutY() >= 405 && green_Player2.getLayoutY() <= 585) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() + 60);
            } else if (green_Player2.getLayoutY() == 645 && green_Player2.getLayoutX() <= 535 && green_Player2.getLayoutX() >= 475) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() - 60);
            } else if (green_Player2.getLayoutX() == 415 && green_Player2.getLayoutY() >= 465 && green_Player2.getLayoutY() <= 645) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() - 60);
            } else if (green_Player2.getLayoutY() == 405 && green_Player2.getLayoutX() <= 415 && green_Player2.getLayoutX() >= 235) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() - 60);
            } else if (green_Player2.getLayoutX() == 175 && green_Player2.getLayoutY() >= 345 && green_Player2.getLayoutY() <= 405) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() - 60);
            } else if (green_Player2.getLayoutY() == 285 && green_Player2.getLayoutX() <= 355 && green_Player2.getLayoutX() >= 175) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() + 60);
            } else if (green_Player2.getLayoutX() == 415 && green_Player2.getLayoutY() >= 105 && green_Player2.getLayoutY() <= 285) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() - 60);
            } else if (green_Player2.getLayoutY() == 45 && green_Player2.getLayoutX() >= 415 && green_Player2.getLayoutX() <= 475) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() + 60);
            } else if (green_Player2.getLayoutY() == 285 && green_Player2.getLayoutX() >= 535 && green_Player2.getLayoutX() <= 715) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() + 60);
            } else if (green_Player2.getLayoutX() == 535 && green_Player2.getLayoutY() >= 45 && green_Player2.getLayoutY() <= 225) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() + 60);
            } else if (green_Player2.getLayoutY() == 285 && green_Player2.getLayoutX() == 775) {
                green_Player2.setLayoutY(green_Player2.getLayoutY() + 60);
            } else if (green_Player2.getLayoutY() == 345 && green_Player2.getLayoutX() <= 775 && green_Player2.getLayoutX() >= 595) {
                green_Player2.setLayoutX(green_Player2.getLayoutX() - 60);
            }//final for green
        }// for

        int x = (int) green_Player2.getLayoutX();
        int y = (int) green_Player2.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt", x + "," + y);

    }// greenPlayer2()

    public void greenPlayer3() {
        for (int k = 0; k < roll_nuber; k++) {

            if(green_Player3.getLayoutX() == 750 && green_Player3.getLayoutY() == 680 && roll_nuber == 6 ){
                green_Player3.setLayoutX(775);
                green_Player3.setLayoutY(405);
                safeForGreen();
                break;
            }
            else if (green_Player3.getLayoutY() == 405 && green_Player3.getLayoutX() <= 775 && green_Player3.getLayoutX() >= 595) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() - 60);
            } else if (green_Player3.getLayoutX() == 535 && green_Player3.getLayoutY() >= 405 && green_Player3.getLayoutY() <= 585) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() + 60);
            } else if (green_Player3.getLayoutY() == 645 && green_Player3.getLayoutX() <= 535 && green_Player3.getLayoutX() >= 475) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() - 60);
            } else if (green_Player3.getLayoutX() == 415 && green_Player3.getLayoutY() >= 465 && green_Player3.getLayoutY() <= 645) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() - 60);
            } else if (green_Player3.getLayoutY() == 405 && green_Player3.getLayoutX() <= 415 && green_Player3.getLayoutX() >= 235) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() - 60);
            } else if (green_Player3.getLayoutX() == 175 && green_Player3.getLayoutY() >= 345 && green_Player3.getLayoutY() <= 405) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() - 60);
            } else if (green_Player3.getLayoutY() == 285 && green_Player3.getLayoutX() <= 355 && green_Player3.getLayoutX() >= 175) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() + 60);
            } else if (green_Player3.getLayoutX() == 415 && green_Player3.getLayoutY() >= 105 && green_Player3.getLayoutY() <= 285) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() - 60);
            } else if (green_Player3.getLayoutY() == 45 && green_Player3.getLayoutX() >= 415 && green_Player3.getLayoutX() <= 475) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() + 60);
            } else if (green_Player3.getLayoutY() == 285 && green_Player3.getLayoutX() >= 535 && green_Player3.getLayoutX() <= 715) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() + 60);
            } else if (green_Player3.getLayoutX() == 535 && green_Player3.getLayoutY() >= 45 && green_Player3.getLayoutY() <= 225) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() + 60);
            } else if (green_Player3.getLayoutY() == 285 && green_Player3.getLayoutX() == 775) {
                green_Player3.setLayoutY(green_Player3.getLayoutY() + 60);
            } else if (green_Player3.getLayoutY() == 345 && green_Player3.getLayoutX() <= 775 && green_Player3.getLayoutX() >= 595) {
                green_Player3.setLayoutX(green_Player3.getLayoutX() - 60);
            }//final for green
        }// for

        int x = (int) green_Player3.getLayoutX();
        int y = (int) green_Player3.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt", x + "," + y);

    }// greenPlayer3()

    public void greenPlayer4() {
        for (int k = 0; k < roll_nuber; k++) {

            if(green_Player4.getLayoutX() == 800 && green_Player4.getLayoutY() == 680 && roll_nuber == 6 ){
                green_Player4.setLayoutX(775);
                green_Player4.setLayoutY(405);
                safeForGreen();
                break;
            }
            else if (green_Player4.getLayoutY() == 405 && green_Player4.getLayoutX() <= 775 && green_Player4.getLayoutX() >= 595) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() - 60);
            } else if (green_Player4.getLayoutX() == 535 && green_Player4.getLayoutY() >= 405 && green_Player4.getLayoutY() <= 585) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() + 60);
            } else if (green_Player4.getLayoutY() == 645 && green_Player4.getLayoutX() <= 535 && green_Player4.getLayoutX() >= 475) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() - 60);
            } else if (green_Player4.getLayoutX() == 415 && green_Player4.getLayoutY() >= 465 && green_Player4.getLayoutY() <= 645) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() - 60);
            } else if (green_Player4.getLayoutY() == 405 && green_Player4.getLayoutX() <= 415 && green_Player4.getLayoutX() >= 235) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() - 60);
            } else if (green_Player4.getLayoutX() == 175 && green_Player4.getLayoutY() >= 345 && green_Player4.getLayoutY() <= 405) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() - 60);
            } else if (green_Player4.getLayoutY() == 285 && green_Player4.getLayoutX() <= 355 && green_Player4.getLayoutX() >= 175) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() + 60);
            } else if (green_Player4.getLayoutX() == 415 && green_Player4.getLayoutY() >= 105 && green_Player4.getLayoutY() <= 285) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() - 60);
            } else if (green_Player4.getLayoutY() == 45 && green_Player4.getLayoutX() >= 415 && green_Player4.getLayoutX() <= 475) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() + 60);
            } else if (green_Player4.getLayoutY() == 285 && green_Player4.getLayoutX() >= 535 && green_Player4.getLayoutX() <= 715) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() + 60);
            } else if (green_Player4.getLayoutX() == 535 && green_Player4.getLayoutY() >= 45 && green_Player4.getLayoutY() <= 225) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() + 60);
            } else if (green_Player4.getLayoutY() == 285 && green_Player4.getLayoutX() == 775) {
                green_Player4.setLayoutY(green_Player4.getLayoutY() + 60);
            } else if (green_Player4.getLayoutY() == 345 && green_Player4.getLayoutX() <= 775 && green_Player4.getLayoutX() >= 595) {
                green_Player4.setLayoutX(green_Player4.getLayoutX() - 60);
            }//final for green
        }// for

        int x = (int) green_Player4.getLayoutX();
        int y = (int) green_Player4.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt", x + "," + y);

    }// greenPlayer4()

    public void yellowPlayer1(){
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

    }// yellowPlayer1()

    public void yellowPlayer2(){
        for (int h = 0; h < roll_nuber; h++) {

            if(yellow_Player2.getLayoutX() == 250 && yellow_Player2.getLayoutY() == 630 && roll_nuber == 6 ){
                yellow_Player2.setLayoutX(415);
                yellow_Player2.setLayoutY(645);
                safeForYellow();
                break;
            }
            else if (yellow_Player2.getLayoutX() == 415 && yellow_Player2.getLayoutY() >= 465 && yellow_Player2.getLayoutY() <= 645) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() - 60);
            } else if (yellow_Player2.getLayoutY() == 405 && yellow_Player2.getLayoutX() <= 415 && yellow_Player2.getLayoutX() >= 235) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() - 60);
            } else if (yellow_Player2.getLayoutX() == 175 && yellow_Player2.getLayoutY() >= 345 && yellow_Player2.getLayoutY() <= 405) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() - 60);
            } else if (yellow_Player2.getLayoutY() == 285 && yellow_Player2.getLayoutX() <= 355 && yellow_Player2.getLayoutX() >= 175) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() + 60);
            } else if (yellow_Player2.getLayoutX() == 415 && yellow_Player2.getLayoutY() >= 105 && yellow_Player2.getLayoutY() <= 285) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() - 60);
            } else if (yellow_Player2.getLayoutY() == 45 && yellow_Player2.getLayoutX() >= 415 && yellow_Player2.getLayoutX() <= 475) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() + 60);
            } else if (yellow_Player2.getLayoutY() == 285 && yellow_Player2.getLayoutX() >= 535 && yellow_Player2.getLayoutX() <= 715) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() + 60);
            } else if (yellow_Player2.getLayoutX() == 535 && yellow_Player2.getLayoutY() >= 45 && yellow_Player2.getLayoutY() <= 225) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() + 60);
            } else if (yellow_Player2.getLayoutX() == 775 && yellow_Player2.getLayoutY() >= 285 && yellow_Player2.getLayoutY() <= 345) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() + 60);
            } else if (yellow_Player2.getLayoutY() == 405 && yellow_Player2.getLayoutX() <= 775 && yellow_Player2.getLayoutX() >= 595) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() - 60);
            } else if (yellow_Player2.getLayoutX() == 535 && yellow_Player2.getLayoutY() >= 405 && yellow_Player2.getLayoutY() <= 585) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() + 60);
            } else if (yellow_Player2.getLayoutY() == 645 && yellow_Player2.getLayoutX() == 535) {
                yellow_Player2.setLayoutX(yellow_Player2.getLayoutX() - 60);
            } else if (yellow_Player2.getLayoutX() == 475 && yellow_Player2.getLayoutY() <= 645 && yellow_Player2.getLayoutY() >= 465) {
                yellow_Player2.setLayoutY(yellow_Player2.getLayoutY() - 60);
            }//final for yellow
        }// for

        int x = (int) yellow_Player2.getLayoutX();
        int y = (int) yellow_Player2.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt", x + "," + y);

    }// yellowPlayer2()

    public void yellowPlayer3(){
        for (int h = 0; h < roll_nuber; h++) {

            if(yellow_Player3.getLayoutX() == 200 && yellow_Player3.getLayoutY() == 680 && roll_nuber == 6 ){
                yellow_Player3.setLayoutX(415);
                yellow_Player3.setLayoutY(645);
                safeForYellow();
                break;
            }
            else if (yellow_Player3.getLayoutX() == 415 && yellow_Player3.getLayoutY() >= 465 && yellow_Player3.getLayoutY() <= 645) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() - 60);
            } else if (yellow_Player3.getLayoutY() == 405 && yellow_Player3.getLayoutX() <= 415 && yellow_Player3.getLayoutX() >= 235) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() - 60);
            } else if (yellow_Player3.getLayoutX() == 175 && yellow_Player3.getLayoutY() >= 345 && yellow_Player3.getLayoutY() <= 405) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() - 60);
            } else if (yellow_Player3.getLayoutY() == 285 && yellow_Player3.getLayoutX() <= 355 && yellow_Player3.getLayoutX() >= 175) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() + 60);
            } else if (yellow_Player3.getLayoutX() == 415 && yellow_Player3.getLayoutY() >= 105 && yellow_Player3.getLayoutY() <= 285) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() - 60);
            } else if (yellow_Player3.getLayoutY() == 45 && yellow_Player3.getLayoutX() >= 415 && yellow_Player3.getLayoutX() <= 475) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() + 60);
            } else if (yellow_Player3.getLayoutY() == 285 && yellow_Player3.getLayoutX() >= 535 && yellow_Player3.getLayoutX() <= 715) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() + 60);
            } else if (yellow_Player3.getLayoutX() == 535 && yellow_Player3.getLayoutY() >= 45 && yellow_Player3.getLayoutY() <= 225) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() + 60);
            } else if (yellow_Player3.getLayoutX() == 775 && yellow_Player3.getLayoutY() >= 285 && yellow_Player3.getLayoutY() <= 345) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() + 60);
            } else if (yellow_Player3.getLayoutY() == 405 && yellow_Player3.getLayoutX() <= 775 && yellow_Player3.getLayoutX() >= 595) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() - 60);
            } else if (yellow_Player3.getLayoutX() == 535 && yellow_Player3.getLayoutY() >= 405 && yellow_Player3.getLayoutY() <= 585) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() + 60);
            } else if (yellow_Player3.getLayoutY() == 645 && yellow_Player3.getLayoutX() == 535) {
                yellow_Player3.setLayoutX(yellow_Player3.getLayoutX() - 60);
            } else if (yellow_Player3.getLayoutX() == 475 && yellow_Player3.getLayoutY() <= 645 && yellow_Player3.getLayoutY() >= 465) {
                yellow_Player3.setLayoutY(yellow_Player3.getLayoutY() - 60);
            }//final for yellow
        }// for

        int x = (int) yellow_Player3.getLayoutX();
        int y = (int) yellow_Player3.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt", x + "," + y);

    }// yellowPlayer3()

    public void yellowPlayer4(){
        for (int h = 0; h < roll_nuber; h++) {

            if(yellow_Player4.getLayoutX() == 250 && yellow_Player4.getLayoutY() == 680 && roll_nuber == 6 ){
                yellow_Player4.setLayoutX(415);
                yellow_Player4.setLayoutY(645);
                safeForYellow();
                break;
            }
            else if (yellow_Player4.getLayoutX() == 415 && yellow_Player4.getLayoutY() >= 465 && yellow_Player4.getLayoutY() <= 645) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() - 60);
            } else if (yellow_Player4.getLayoutY() == 405 && yellow_Player4.getLayoutX() <= 415 && yellow_Player4.getLayoutX() >= 235) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() - 60);
            } else if (yellow_Player4.getLayoutX() == 175 && yellow_Player4.getLayoutY() >= 345 && yellow_Player4.getLayoutY() <= 405) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() - 60);
            } else if (yellow_Player4.getLayoutY() == 285 && yellow_Player4.getLayoutX() <= 355 && yellow_Player4.getLayoutX() >= 175) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() + 60);
            } else if (yellow_Player4.getLayoutX() == 415 && yellow_Player4.getLayoutY() >= 105 && yellow_Player4.getLayoutY() <= 285) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() - 60);
            } else if (yellow_Player4.getLayoutY() == 45 && yellow_Player4.getLayoutX() >= 415 && yellow_Player4.getLayoutX() <= 475) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() + 60);
            } else if (yellow_Player4.getLayoutY() == 285 && yellow_Player4.getLayoutX() >= 535 && yellow_Player4.getLayoutX() <= 715) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() + 60);
            } else if (yellow_Player4.getLayoutX() == 535 && yellow_Player4.getLayoutY() >= 45 && yellow_Player4.getLayoutY() <= 225) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() + 60);
            } else if (yellow_Player4.getLayoutX() == 775 && yellow_Player4.getLayoutY() >= 285 && yellow_Player4.getLayoutY() <= 345) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() + 60);
            } else if (yellow_Player4.getLayoutY() == 405 && yellow_Player4.getLayoutX() <= 775 && yellow_Player4.getLayoutX() >= 595) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() - 60);
            } else if (yellow_Player4.getLayoutX() == 535 && yellow_Player4.getLayoutY() >= 405 && yellow_Player4.getLayoutY() <= 585) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() + 60);
            } else if (yellow_Player4.getLayoutY() == 645 && yellow_Player4.getLayoutX() == 535) {
                yellow_Player4.setLayoutX(yellow_Player4.getLayoutX() - 60);
            } else if (yellow_Player4.getLayoutX() == 475 && yellow_Player4.getLayoutY() <= 645 && yellow_Player4.getLayoutY() >= 465) {
                yellow_Player4.setLayoutY(yellow_Player4.getLayoutY() - 60);
            }//final for yellow
        }// for

        int x = (int) yellow_Player4.getLayoutX();
        int y = (int) yellow_Player4.getLayoutY();
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt", x + "," + y);

    }// yellowPlayer4()








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

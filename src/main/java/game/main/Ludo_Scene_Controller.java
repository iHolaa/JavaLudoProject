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
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Ludo_Scene_Controller extends Game_Methods implements Initializable {

    Main main = new Main();
    FileManeger2 fileManeger2 = new FileManeger2();
    protected boolean stop = false ;

@FXML
    private ImageView  blue_Player1, blue_Player2, blue_Player3, blue_Player4 ,
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
    int roll_nuber = 0 , number = 0 ;
    ArrayList<String> numberOfPlayers = new ArrayList<>();
    ArrayList<String> player1 = new ArrayList<>();
    ArrayList<String> player2 = new ArrayList<>();
    ArrayList<String> player3 = new ArrayList<>();
    ArrayList<String> player4 = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        } else if (numberOfPlayers.contains("3")) {
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

        timeNow();
        blue_Player1.setLayoutX(535);
        blue_Player1.setLayoutY(45);
        red_Player1.setLayoutX(175);
        red_Player1.setLayoutY(285);
        green_Player1.setLayoutX(775);
        green_Player1.setLayoutY(405);
        yellow_Player1.setLayoutX(415);
        yellow_Player1.setLayoutY(645);
    }
    public void dice() throws FileNotFoundException {

       roll_nuber = roll_Dice();
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

    }
    public void move_Player1(){

    }
    public void move_Player2(){

    }
    public void move_Player3(){

    }
    public void move_Player4(){

    }


  public void Move(){



      String player_Color = player_Turn(number);
      number++;
      if(number == 4){
          number = 0;
      }
      System.out.println(player_Color);


      for (int i = 0; i < roll_nuber ; i++) {
          if(blue_Player1.getLayoutY() == 285 && blue_Player1.getLayoutX() >= 535 && blue_Player1.getLayoutX() <= 715){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60 );
          }
          else if (blue_Player1.getLayoutX() == 535 && blue_Player1.getLayoutY() >= 45 && blue_Player1.getLayoutY() <= 225) {
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
          }
          else if(blue_Player1.getLayoutX() == 775 && blue_Player1.getLayoutY() >= 285 && blue_Player1.getLayoutY() <= 345){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
          }
          else if(blue_Player1.getLayoutY() == 405 && blue_Player1.getLayoutX() <= 775 && blue_Player1.getLayoutX() >= 595 ){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60 );
          }
          else if(blue_Player1.getLayoutX() == 535 && blue_Player1.getLayoutY() >= 405 && blue_Player1.getLayoutY() <= 585){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60);
          }
          else if(blue_Player1.getLayoutY() == 645 && blue_Player1.getLayoutX() <= 535 && blue_Player1.getLayoutX() >= 475 ){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60 );
          }
          else if(blue_Player1.getLayoutX() == 415 && blue_Player1.getLayoutY() >= 465 && blue_Player1.getLayoutY() <= 645){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
          }
          else if(blue_Player1.getLayoutY() == 405 && blue_Player1.getLayoutX() <= 415 && blue_Player1.getLayoutX() >= 235 ){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() - 60 );
          }
          else if(blue_Player1.getLayoutX() == 175 && blue_Player1.getLayoutY() >= 345 && blue_Player1.getLayoutY() <= 405){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
          }
          else if(blue_Player1.getLayoutY() == 285 && blue_Player1.getLayoutX() <= 355 && blue_Player1.getLayoutX() >= 175 ){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60 );
          }
          else if(blue_Player1.getLayoutX() == 415 && blue_Player1.getLayoutY() >= 105 && blue_Player1.getLayoutY() <= 285){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() - 60);
          }
          else if(blue_Player1.getLayoutY() == 45 && blue_Player1.getLayoutX() == 415 ){
              blue_Player1.setLayoutX(blue_Player1.getLayoutX() + 60 );
          }
          else if(blue_Player1.getLayoutX() == 475 && blue_Player1.getLayoutY() >= 45 && blue_Player1.getLayoutY() <= 225 ){
              blue_Player1.setLayoutY(blue_Player1.getLayoutY() + 60 );
          }//final for blue
      }
      for (int j = 0; j < roll_nuber; j++) {
          if(red_Player1.getLayoutY() == 285 && red_Player1.getLayoutX() >= 175 && red_Player1.getLayoutX() <= 355 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() + 60 );
          }
          else if(red_Player1.getLayoutX() == 415 && red_Player1.getLayoutY() >= 105 && red_Player1.getLayoutY() <= 285 ){
              red_Player1.setLayoutY(red_Player1.getLayoutY() - 60 );
          }
          else if(red_Player1.getLayoutY() == 45 && red_Player1.getLayoutX() >= 415 && red_Player1.getLayoutX() <= 475 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() + 60 );
          }
          else if(red_Player1.getLayoutY() == 285 && red_Player1.getLayoutX() >= 535 && red_Player1.getLayoutX() <= 715){
              red_Player1.setLayoutX(red_Player1.getLayoutX() + 60 );
          }
          else if (red_Player1.getLayoutX() == 535 && red_Player1.getLayoutY() >= 45 && red_Player1.getLayoutY() <= 225) {
              red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
          }
          else if(red_Player1.getLayoutX() == 775 && red_Player1.getLayoutY() >= 285 && red_Player1.getLayoutY() <= 345){
              red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
          }
          else if(red_Player1.getLayoutY() == 405 && red_Player1.getLayoutX() <= 775 && red_Player1.getLayoutX() >= 595 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() - 60 );
          }
          else if(red_Player1.getLayoutX() == 535 && red_Player1.getLayoutY() >= 405 && red_Player1.getLayoutY() <= 585){
              red_Player1.setLayoutY(red_Player1.getLayoutY() + 60);
          }
          else if(red_Player1.getLayoutY() == 645 && red_Player1.getLayoutX() <= 535 && red_Player1.getLayoutX() >= 475 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() - 60 );
          }
          else if(red_Player1.getLayoutX() == 415 && red_Player1.getLayoutY() >= 465 && red_Player1.getLayoutY() <= 645){
              red_Player1.setLayoutY(red_Player1.getLayoutY() - 60);
          }
          else if(red_Player1.getLayoutY() == 405 && red_Player1.getLayoutX() <= 415 && red_Player1.getLayoutX() >= 235 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() - 60 );
          }
          else if(red_Player1.getLayoutY() == 405&& red_Player1.getLayoutX() == 175 ){
              red_Player1.setLayoutY(red_Player1.getLayoutY() - 60 );
          }
          else if(red_Player1.getLayoutY() == 345 && red_Player1.getLayoutX() >= 175 && red_Player1.getLayoutX() <= 355 ){
              red_Player1.setLayoutX(red_Player1.getLayoutX() + 60 );
          }//final for red
      }

      for (int k = 0; k < roll_nuber; k++) {
          if(green_Player1.getLayoutY() == 405 && green_Player1.getLayoutX() <= 775 && green_Player1.getLayoutX() >= 595 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() - 60 );
          }
          else if(green_Player1.getLayoutX() == 535 && green_Player1.getLayoutY() >= 405 && green_Player1.getLayoutY() <= 585){
              green_Player1.setLayoutY(green_Player1.getLayoutY() + 60);
          }
          else if(green_Player1.getLayoutY() == 645 && green_Player1.getLayoutX() <= 535 && green_Player1.getLayoutX() >= 475 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() - 60 );
          }
          else if(green_Player1.getLayoutX() == 415 && green_Player1.getLayoutY() >= 465 && green_Player1.getLayoutY() <= 645){
              green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
          }
          else if(green_Player1.getLayoutY() == 405 && green_Player1.getLayoutX() <= 415 && green_Player1.getLayoutX() >= 235 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() - 60 );
          }
          else if(green_Player1.getLayoutX() == 175 && green_Player1.getLayoutY() >= 345 && green_Player1.getLayoutY() <= 405){
              green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
          }
          else if(green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() <= 355 && green_Player1.getLayoutX() >= 175 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() + 60 );
          }
          else if(green_Player1.getLayoutX() == 415 && green_Player1.getLayoutY() >= 105 && green_Player1.getLayoutY() <= 285){
              green_Player1.setLayoutY(green_Player1.getLayoutY() - 60);
          }
          else if(green_Player1.getLayoutY() == 45 && green_Player1.getLayoutX() >= 415 && green_Player1.getLayoutX() <= 475 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() + 60 );
          }
          else if(green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() >= 535 && green_Player1.getLayoutX() <= 715){
              green_Player1.setLayoutX(green_Player1.getLayoutX() + 60 );
          }
          else if (green_Player1.getLayoutX() == 535 && green_Player1.getLayoutY() >= 45 && green_Player1.getLayoutY() <= 225) {
              green_Player1.setLayoutY(green_Player1.getLayoutY() + 60);
          }
          else if(green_Player1.getLayoutY() == 285 && green_Player1.getLayoutX() == 775 ){
              green_Player1.setLayoutY(green_Player1.getLayoutY() + 60 );
          }
          else if(green_Player1.getLayoutY() == 345 && green_Player1.getLayoutX() <= 775 && green_Player1.getLayoutX() >=595 ){
              green_Player1.setLayoutX(green_Player1.getLayoutX() - 60 );
          }//final for green
      }
      for (int h = 0; h < roll_nuber; h++) {

          if(yellow_Player1.getLayoutX() == 415 && yellow_Player1.getLayoutY() >= 465 && yellow_Player1.getLayoutY() <= 645){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
          }
          else if(yellow_Player1.getLayoutY() == 405 && yellow_Player1.getLayoutX() <= 415 && yellow_Player1.getLayoutX() >= 235 ){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60 );
          }
          else if(yellow_Player1.getLayoutX() == 175 && yellow_Player1.getLayoutY() >= 345 && yellow_Player1.getLayoutY() <= 405){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
          }
          else if(yellow_Player1.getLayoutY() == 285 && yellow_Player1.getLayoutX() <= 355 && yellow_Player1.getLayoutX() >= 175 ){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60 );
          }
          else if(yellow_Player1.getLayoutX() == 415 && yellow_Player1.getLayoutY() >= 105 && yellow_Player1.getLayoutY() <= 285){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60);
          }
          else if(yellow_Player1.getLayoutY() == 45 && yellow_Player1.getLayoutX() >= 415 && yellow_Player1.getLayoutX() <= 475 ){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60 );
          }
          else if(yellow_Player1.getLayoutY() == 285 && yellow_Player1.getLayoutX() >= 535 && yellow_Player1.getLayoutX() <= 715){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() + 60 );
          }
          else if (yellow_Player1.getLayoutX() == 535 && yellow_Player1.getLayoutY() >= 45 && yellow_Player1.getLayoutY() <= 225) {
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
          }
          else if(yellow_Player1.getLayoutX() == 775 && yellow_Player1.getLayoutY() >= 285 && yellow_Player1.getLayoutY() <= 345){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
          }
          else if(yellow_Player1.getLayoutY() == 405 && yellow_Player1.getLayoutX() <= 775 && yellow_Player1.getLayoutX() >= 595 ){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60 );
          }
          else if(yellow_Player1.getLayoutX() == 535 && yellow_Player1.getLayoutY() >= 405 && yellow_Player1.getLayoutY() <= 585){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() + 60);
          }
          else if(yellow_Player1.getLayoutY() == 645 && yellow_Player1.getLayoutX() == 535 ){
              yellow_Player1.setLayoutX(yellow_Player1.getLayoutX() - 60 );
          }
          else if(yellow_Player1.getLayoutX() == 475 && yellow_Player1.getLayoutY() <= 645 && yellow_Player1.getLayoutY() >= 465 ){
              yellow_Player1.setLayoutY(yellow_Player1.getLayoutY() - 60 );
          }//final for green
      }


  }// Move()


    public void timeNow(){
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
    }

}

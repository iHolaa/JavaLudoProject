package game.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game_Pos {


    Main main = new Main();
    FileManeger1 fileManeger1 = new FileManeger1();
    FileManeger2 fileManeger2 = new FileManeger2();



    public void delete_LastGame_Files() {
        try {
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt"));
            Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // Players First Position
    public void firstPos(){

        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt","750,80");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt","800,80");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt","750,130");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt","800,130");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt","200,80");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt","250,80");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt","200,130");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt","250,130");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt","750,630");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt","800,630");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt","750,680");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt","800,680");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt","200,630");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt","250,630");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt","200,680");
        fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt","250,680");
    }// firstPos()




    public void checkScore() {

        ArrayList<String> score_File = new ArrayList<>();
        ArrayList<String> numberOfPlayers = new ArrayList<>();
        ArrayList<String> winner = new ArrayList<>();
        ArrayList<String> username = new ArrayList<>();
        // blue
        int blue_Score = 0;
        ArrayList<String> blue_P1 = new ArrayList<>();
        ArrayList<String> blue_P2 = new ArrayList<>();
        ArrayList<String> blue_P3 = new ArrayList<>();
        ArrayList<String> blue_P4 = new ArrayList<>();
        ArrayList<String> bluePlayer_Pos = new ArrayList<>();
        // red
        int red_Score = 0;
        ArrayList<String> red_P1 = new ArrayList<>();
        ArrayList<String> red_P2 = new ArrayList<>();
        ArrayList<String> red_P3 = new ArrayList<>();
        ArrayList<String> red_P4 = new ArrayList<>();
        ArrayList<String> redPlayer_Pos = new ArrayList<>();
        // green
        int green_Score = 0;
        ArrayList<String> green_P1 = new ArrayList<>();
        ArrayList<String> green_P2 = new ArrayList<>();
        ArrayList<String> green_P3 = new ArrayList<>();
        ArrayList<String> green_P4 = new ArrayList<>();
        ArrayList<String> greenPlayer_Pos = new ArrayList<>();
        // yellow
        int yellow_Score = 0;
        ArrayList<String> yellow_P1 = new ArrayList<>();
        ArrayList<String> yellow_P2 = new ArrayList<>();
        ArrayList<String> yellow_P3 = new ArrayList<>();
        ArrayList<String> yellow_P4 = new ArrayList<>();
        ArrayList<String> yellowPlayer_Pos = new ArrayList<>();


        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_1.txt",blue_P1);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_2.txt",blue_P2);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_3.txt",blue_P3);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Blue_4.txt",blue_P4);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_1.txt",red_P1);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_2.txt",red_P2);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_3.txt",red_P3);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Red_4.txt",red_P4);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_1.txt",green_P1);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_2.txt",green_P2);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_3.txt",green_P3);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Green_4.txt",green_P4);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_1.txt",yellow_P1);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_2.txt",yellow_P2);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_3.txt",yellow_P3);
        fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Player Positions\\Yellow_4.txt",yellow_P4);

        if (  (blue_P1.contains("475,105") || blue_P1.contains("475,165") || blue_P1.contains("475,225") || blue_P1.contains("475,285"))
                && (blue_P2.contains("475,105") || blue_P2.contains("475,165") || blue_P2.contains("475,225") || blue_P2.contains("475,285"))
                && (blue_P3.contains("475,105") || blue_P3.contains("475,165") || blue_P3.contains("475,225") || blue_P3.contains("475,285"))
                && (blue_P4.contains("475,105") || blue_P4.contains("475,165") || blue_P4.contains("475,225") || blue_P4.contains("475,285"))){

               blue_Score += 100 ;

            if(red_P1.contains("235,345") || red_P1.contains("295,345") || red_P1.contains("355,345") || red_P1.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P2.contains("235,345") || red_P2.contains("295,345") || red_P2.contains("355,345") || red_P2.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P3.contains("235,345") || red_P3.contains("295,345") || red_P3.contains("355,345") || red_P3.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P4.contains("235,345") || red_P4.contains("295,345") || red_P4.contains("355,345") || red_P4.contains("415,345")){
                red_Score += 10 ;
            }
            if(green_P1.contains("715,345") || green_P1.contains("655,345") || green_P1.contains("595,345") || green_P1.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P2.contains("715,345") || green_P2.contains("655,345") || green_P2.contains("595,345") || green_P2.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P3.contains("715,345") || green_P3.contains("655,345") || green_P3.contains("595,345") || green_P3.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P4.contains("715,345") || green_P4.contains("655,345") || green_P4.contains("595,345") || green_P4.contains("535,345")){
                green_Score += 10 ;
            }
            if(yellow_P1.contains("475,585") || yellow_P1.contains("475,525") || yellow_P1.contains("475,465") || yellow_P1.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P2.contains("475,585") || yellow_P2.contains("475,525") || yellow_P2.contains("475,465") || yellow_P2.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P3.contains("475,585") || yellow_P3.contains("475,525") || yellow_P3.contains("475,465") || yellow_P3.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P4.contains("475,585") || yellow_P4.contains("475,525") || yellow_P4.contains("475,465") || yellow_P4.contains("475,405")){
                yellow_Score += 10 ;
            }


            fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

            // 4 nafare
            if(numberOfPlayers.contains("4")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt",yellowPlayer_Pos);
                // shomare fard sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));
                int yellow_pos = Integer.parseInt(yellowPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));
                int old_Score_Yellow = Integer.parseInt(score_File.get(yellow_pos));
                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;
                yellow_Score += old_Score_Yellow;
                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                score_File.set(yellow_pos, String.valueOf(yellow_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            // 3 nafare
            else if (numberOfPlayers.contains("3")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            // 2 nafare
            else if (numberOfPlayers.contains("2")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));

                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1 , username.get( username.size() - 1 ) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }// else if --> numberOfPlayers = 2
        }// if blue complete


        else if (  (red_P1.contains("235,345") || red_P1.contains("295,345") || red_P1.contains("355,345") || red_P1.contains("415,345"))
                && (red_P2.contains("235,345") || red_P2.contains("295,345") || red_P2.contains("355,345") || red_P2.contains("415,345"))
                && (red_P3.contains("235,345") || red_P3.contains("295,345") || red_P3.contains("355,345") || red_P3.contains("415,345"))
                && (red_P4.contains("235,345") || red_P4.contains("295,345") || red_P4.contains("355,345") || red_P4.contains("415,345"))){

            red_Score += 100 ;

            if(blue_P1.contains("475,105") || blue_P1.contains("475,165") || blue_P1.contains("475,225") || blue_P1.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P2.contains("475,105") || blue_P2.contains("475,165") || blue_P2.contains("475,225") || blue_P2.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P3.contains("475,105") || blue_P3.contains("475,165") || blue_P3.contains("475,225") || blue_P3.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P4.contains("475,105") || blue_P4.contains("475,165") || blue_P4.contains("475,225") || blue_P4.contains("475,285")){
                blue_Score += 10 ;
            }
            if(green_P1.contains("715,345") || green_P1.contains("655,345") || green_P1.contains("595,345") || green_P1.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P2.contains("715,345") || green_P2.contains("655,345") || green_P2.contains("595,345") || green_P2.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P3.contains("715,345") || green_P3.contains("655,345") || green_P3.contains("595,345") || green_P3.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P4.contains("715,345") || green_P4.contains("655,345") || green_P4.contains("595,345") || green_P4.contains("535,345")){
                green_Score += 10 ;
            }
            if(yellow_P1.contains("475,585") || yellow_P1.contains("475,525") || yellow_P1.contains("475,465") || yellow_P1.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P2.contains("475,585") || yellow_P2.contains("475,525") || yellow_P2.contains("475,465") || yellow_P2.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P3.contains("475,585") || yellow_P3.contains("475,525") || yellow_P3.contains("475,465") || yellow_P3.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P4.contains("475,585") || yellow_P4.contains("475,525") || yellow_P4.contains("475,465") || yellow_P4.contains("475,405")){
                yellow_Score += 10 ;
            }


            fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

            if(numberOfPlayers.contains("4")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt",yellowPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));
                int yellow_pos = Integer.parseInt(yellowPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));
                int old_Score_Yellow = Integer.parseInt(score_File.get(yellow_pos));
                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;
                yellow_Score += old_Score_Yellow;
                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                score_File.set(yellow_pos, String.valueOf(yellow_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("3")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("2")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));

                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1 , username.get( username.size() - 1 ) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }// else if --> numberOfPlayers = 2

        }// else if red complete
        else if (  (green_P1.contains("715,345") || green_P1.contains("655,345") || green_P1.contains("595,345") || green_P1.contains("535,345"))
                && (green_P2.contains("715,345") || green_P2.contains("655,345") || green_P2.contains("595,345") || green_P2.contains("535,345"))
                && (green_P3.contains("715,345") || green_P3.contains("655,345") || green_P3.contains("595,345") || green_P3.contains("535,345"))
                && (green_P4.contains("715,345") || green_P4.contains("655,345") || green_P4.contains("595,345") || green_P4.contains("535,345"))){

            green_Score += 100 ;

            if(red_P1.contains("235,345") || red_P1.contains("295,345") || red_P1.contains("355,345") || red_P1.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P2.contains("235,345") || red_P2.contains("295,345") || red_P2.contains("355,345") || red_P2.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P3.contains("235,345") || red_P3.contains("295,345") || red_P3.contains("355,345") || red_P3.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P4.contains("235,345") || red_P4.contains("295,345") || red_P4.contains("355,345") || red_P4.contains("415,345")){
                red_Score += 10 ;
            }
            if(blue_P1.contains("475,105") || blue_P1.contains("475,165") || blue_P1.contains("475,225") || blue_P1.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P2.contains("475,105") || blue_P2.contains("475,165") || blue_P2.contains("475,225") || blue_P2.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P3.contains("475,105") || blue_P3.contains("475,165") || blue_P3.contains("475,225") || blue_P3.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P4.contains("475,105") || blue_P4.contains("475,165") || blue_P4.contains("475,225") || blue_P4.contains("475,285")){
                blue_Score += 10 ;
            }
            if(yellow_P1.contains("475,585") || yellow_P1.contains("475,525") || yellow_P1.contains("475,465") || yellow_P1.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P2.contains("475,585") || yellow_P2.contains("475,525") || yellow_P2.contains("475,465") || yellow_P2.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P3.contains("475,585") || yellow_P3.contains("475,525") || yellow_P3.contains("475,465") || yellow_P3.contains("475,405")){
                yellow_Score += 10 ;
            }
            if(yellow_P4.contains("475,585") || yellow_P4.contains("475,525") || yellow_P4.contains("475,465") || yellow_P4.contains("475,405")){
                yellow_Score += 10 ;
            }


            fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

            if(numberOfPlayers.contains("4")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt",yellowPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));
                int yellow_pos = Integer.parseInt(yellowPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));
                int old_Score_Yellow = Integer.parseInt(score_File.get(yellow_pos));
                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;
                yellow_Score += old_Score_Yellow;
                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                score_File.set(yellow_pos, String.valueOf(yellow_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("3")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("2")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));

                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1 , username.get( username.size() - 1 ) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }// else if --> numberOfPlayers = 2

        }// else if green complete
        else if (  (yellow_P1.contains("475,585") || yellow_P1.contains("475,525") || yellow_P1.contains("475,465") || yellow_P1.contains("475,405"))
                && (yellow_P2.contains("475,585") || yellow_P2.contains("475,525") || yellow_P2.contains("475,465") || yellow_P2.contains("475,405"))
                && (yellow_P3.contains("475,585") || yellow_P3.contains("475,525") || yellow_P3.contains("475,465") || yellow_P3.contains("475,405"))
                && (yellow_P4.contains("475,585") || yellow_P4.contains("475,525") || yellow_P4.contains("475,465") || yellow_P4.contains("475,405"))){

            yellow_Score += 100 ;

            if(red_P1.contains("235,345") || red_P1.contains("295,345") || red_P1.contains("355,345") || red_P1.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P2.contains("235,345") || red_P2.contains("295,345") || red_P2.contains("355,345") || red_P2.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P3.contains("235,345") || red_P3.contains("295,345") || red_P3.contains("355,345") || red_P3.contains("415,345")){
                red_Score += 10 ;
            }
            if(red_P4.contains("235,345") || red_P4.contains("295,345") || red_P4.contains("355,345") || red_P4.contains("415,345")){
                red_Score += 10 ;
            }
            if(green_P1.contains("715,345") || green_P1.contains("655,345") || green_P1.contains("595,345") || green_P1.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P2.contains("715,345") || green_P2.contains("655,345") || green_P2.contains("595,345") || green_P2.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P3.contains("715,345") || green_P3.contains("655,345") || green_P3.contains("595,345") || green_P3.contains("535,345")){
                green_Score += 10 ;
            }
            if(green_P4.contains("715,345") || green_P4.contains("655,345") || green_P4.contains("595,345") || green_P4.contains("535,345")){
                green_Score += 10 ;
            }
            if(blue_P1.contains("475,105") || blue_P1.contains("475,165") || blue_P1.contains("475,225") || blue_P1.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P2.contains("475,105") || blue_P2.contains("475,165") || blue_P2.contains("475,225") || blue_P2.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P3.contains("475,105") || blue_P3.contains("475,165") || blue_P3.contains("475,225") || blue_P3.contains("475,285")){
                blue_Score += 10 ;
            }
            if(blue_P4.contains("475,105") || blue_P4.contains("475,165") || blue_P4.contains("475,225") || blue_P4.contains("475,285")){
                blue_Score += 10 ;
            }


            fileManeger2.FileReader("src\\main\\resources\\Files\\Number Of Players\\Number_Of_Players.txt",numberOfPlayers);

            if(numberOfPlayers.contains("4")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player4_Pos.txt",yellowPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));
                int yellow_pos = Integer.parseInt(yellowPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));
                int old_Score_Yellow = Integer.parseInt(score_File.get(yellow_pos));
                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;
                yellow_Score += old_Score_Yellow;
                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                score_File.set(yellow_pos, String.valueOf(yellow_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("3")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player3_Pos.txt",greenPlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));
                int green_pos = Integer.parseInt(greenPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));
                int old_Score_Green = Integer.parseInt(score_File.get(green_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;
                green_Score += old_Score_Green ;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));
                score_File.set(green_pos, String.valueOf(green_Score));
                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1  , username.get(username.size() - 1) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if (numberOfPlayers.contains("2")){

                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player1_Pos.txt",redPlayer_Pos);
                fileManeger2.FileReader("src\\main\\resources\\Files\\All Games\\Last_Game\\Player2_Pos.txt",bluePlayer_Pos);
                // shomare shakhs sign up shode dar file
                int blue_pos = Integer.parseInt(bluePlayer_Pos.get(0));
                int red_pos = Integer.parseInt(redPlayer_Pos.get(0));

                fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Score.txt",score_File);
                // emtiaz har bazikon ghabl az in bazi
                int old_Score_blue = Integer.parseInt(score_File.get(blue_pos));
                int old_Score_Red = Integer.parseInt(score_File.get(red_pos));

                // jam emtiaz ba meghdar ghabli dar file
                blue_Score += old_Score_blue;
                red_Score += old_Score_Red;

                // zakhire meghdar jadid dar file
                score_File.set(blue_pos, String.valueOf(blue_Score));
                score_File.set(red_pos, String.valueOf(red_Score));

                // save winner name
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt",username);
                fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
                winner.set( username.size() - 1 , username.get( username.size() - 1 ) );
                try {
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\SignUp\\Score.txt"));
                    Files.deleteIfExists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt"));
                }catch (IOException ex ){
                    ex.printStackTrace();
                }
                for (int i = 0; i < score_File.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\SignUp\\Score.txt", score_File.get(i));
                }
                for (int i = 0; i < winner.size(); i++) {
                    fileManeger1.FileWriter("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt", winner.get(i));
                }
                fileManeger2.FileWriter("src\\main\\resources\\Files\\All Games\\Last_Game\\Winner.txt",username.get(username.size() - 1));
                try {
                    main.changeScene("Winner_Page.fxml", 800, 600);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }// else if --> numberOfPlayers = 2
        }// else if yellow complete


    }//checkScore()

}

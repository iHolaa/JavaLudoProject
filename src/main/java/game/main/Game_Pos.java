package game.main;

import java.util.concurrent.ThreadLocalRandom;

public class Game_Pos {
    FileManeger2 fileManeger2 = new FileManeger2();

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
    }
}

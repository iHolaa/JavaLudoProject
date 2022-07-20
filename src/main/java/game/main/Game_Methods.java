package game.main;

import java.util.concurrent.ThreadLocalRandom;

public class Game_Methods {
    String[] player_Color = {"Red","Blue","Green","Yellow"};
    int randomNum;

    public String player_Turn(int number){
        String x = player_Color[number];
        return x;
    }

    public int roll_Dice(){
        randomNum = ThreadLocalRandom.current().nextInt(1 , 6 + 1);
        return randomNum;
    }

}

package game.main;

import java.io.*;
import java.util.ArrayList;

public class FileManeger2 {
    public void FileWriter(String filePath, String data) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Read
    public static void FileReader(String fileName, ArrayList data){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line ;
            while( (line = br.readLine()) != null ){
                data.add(line);
            }
            br.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

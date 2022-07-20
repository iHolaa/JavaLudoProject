package game.main;

import java.io.*;
import java.util.ArrayList;

public class FileManeger1 {
    //Write
    public void FileWriter(String filePath, String data) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Read
    public static void FileReader(String fileName, ArrayList<String> data){
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




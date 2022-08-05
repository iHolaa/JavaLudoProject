package game.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class RecentGames_Controller implements Initializable {
    Main main = new Main();
    FileManeger1 fileManeger1 = new FileManeger1();
    @FXML
    Button back_Button ;
    @FXML
    private TableView <Games_Played> table;
    @FXML
    TableColumn <Games_Played ,String> player1_Column;
    @FXML
    TableColumn <Games_Played ,String> player2_Column;
    @FXML
    TableColumn <Games_Played ,String> player3_Column;
    @FXML
    TableColumn <Games_Played ,String> player4_Column;
    @FXML
    TableColumn <Games_Played ,String> winner_Column;
    @FXML
    TableColumn <Games_Played ,String> date_Column;

    ArrayList<String> player1 = new ArrayList<>();
    ArrayList<String> player2 = new ArrayList<>();
    ArrayList<String> player3 = new ArrayList<>();
    ArrayList<String> player4 = new ArrayList<>();
    ArrayList<String> winner = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();

    ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> pos = new ArrayList<>();
        ArrayList<String> username = new ArrayList<>();
        fileManeger1.FileReader("src\\main\\resources\\Files\\Information\\Username_Position.txt",pos);
        int position = Integer.parseInt(pos.get(0));

        fileManeger1.FileReader("src\\main\\resources\\Files\\SignUp\\Username.txt",username);
        String user = username.get(position);

        if(Files.exists(Path.of("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt"))){

            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player1.txt",player1);
            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player2.txt",player2);
            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player3.txt",player3);
            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Player4.txt",player4);
            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Winner.txt",winner);
            fileManeger1.FileReader("src\\main\\resources\\Files\\All Games\\4 Player\\Date.txt",date);
            for (int i = 0; i < player1.size() ; i++) {
                if(player1.get(i).equals(user) || player2.get(i).equals(user) || player3.get(i).equals(user) || player4.get(i).equals(user)){
                    list.addAll(new Games_Played(player1.get(i),player2.get(i),player3.get(i),player4.get(i),winner.get(i),date.get(i)));
                }
            }// for
        }


        player1_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("player1"));
        player2_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("player2"));
        player3_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("player3"));
        player4_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("player4"));
        winner_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("winner"));
        date_Column.setCellValueFactory(new PropertyValueFactory<Games_Played ,String>("date"));

        table.setItems(list);
    }

    public void back(){
        try {
            main.changeScene("Player_Profile.fxml",1100,700);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }// back()
    public void back_Enter(){
        back_Button.setStyle("-fx-background-radius: 12 ; -fx-background-color: #18548E");
    }
    public void back_Exit(){
        back_Button.setStyle("-fx-background-radius: 12 ; -fx-background-color: #13B8C2");
    }


}

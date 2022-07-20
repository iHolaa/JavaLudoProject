module game.main {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.main to javafx.fxml;
    exports game.main;
}
module game.vulntracker.final329project {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.vulntracker to javafx.fxml;
    exports game.vulntracker;
}
module game.vulntracker.final329project {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;


    opens game.vulntracker to javafx.fxml;
    exports game.vulntracker;
}
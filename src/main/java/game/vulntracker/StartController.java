package game.vulntracker;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class StartController {
    @FXML
    private Button buttonAbout;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonHowto;

    @FXML
    private Button buttonStart;

    @FXML
    private TextArea startScreen;

    @FXML
    void aboutButtonClicked(ActionEvent event) {
        Alert about = new Alert(AlertType.INFORMATION);
        about.setTitle("About Project");
        about.setHeaderText("CPSC 329 Fall 2022 Final Project: Security Simulator");
        about.setContentText("This game has you play as an employee at a tech company and it is your job to make decisions to protect the company's data. It aims to teach the player about the many vulnerabilities your data can face and how to prevent attacks.\nThis project was made by:\nJustin Clibbett\nShaheryar Syed\nDevon Harstrom\nSean Anselmo\nAreez Nadeem");
        about.showAndWait();
    }

    @FXML
    void exitButtonClicked(ActionEvent event) {
        Alert exit = new Alert(AlertType.CONFIRMATION);
        exit.setTitle("Exit Program");
        exit.setHeaderText("Would you like to exit the program?");
        exit.setContentText("Click 'OK' to exit.");
        Optional<ButtonType> result = exit.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    @FXML
    void howtoButtonClicked(ActionEvent event) {
        Alert howto = new Alert(AlertType.INFORMATION);
        howto.setTitle("How to Play");
        howto.setHeaderText("How to play Security Simulator");
        howto.setContentText("1. You will be presented with a question and 4 answers. You must try to pick the correct answer. There are a total of 15 questions you must answer to complete the game.\n\n2. After picking an answer, you will be given feedback for that question. Press 'Next' to advance to the next question.\n\n3. A Threat Meter is displayed at the bottom of the screen and will be empty when you start the game. It will rise every time a question is answered incorrectly, and some answers may raise it more than others. If the Threat Meter is completely filled, you will lose the game.\n\n4. You can also press 'Back' to go to the previous question and try again. Be careful, because if you get it wrong again, it will still increase the Threat Meter.\n\nGood luck!");
        howto.showAndWait();
    }


    @FXML
    public void startButtonClicked(ActionEvent event) throws IOException {
        Parent gameViewParent = FXMLLoader.load(getClass().getResource("game-screen.fxml"));
        Scene gameViewScene = new Scene(gameViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameViewScene);
    }
}

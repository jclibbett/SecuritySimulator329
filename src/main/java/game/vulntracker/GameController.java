package game.vulntracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import game.vulntracker.GameApplication.*;

public class GameController {
    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

    @FXML
    private Button buttonNext;

    // Text box that contains the question/feedback
    @FXML
    private TextArea questionScreen;

    @FXML
    private ProgressBar threatBar;

    @FXML
    private ImageView pictureScreen;

    // Function when an answer button is clicked, should check which button is clicked and determine if the answer was right or wrong
    @FXML
    void buttonAClicked(ActionEvent event) {

    }


    // Function for when Back button is clicked, should cycle to previous question with its feedback
    @FXML
    void goBack(ActionEvent event) {

    }

    // Function for when Next button is clicked, should cycle to next question
    @FXML
    void goNext(ActionEvent event) {

    }
}
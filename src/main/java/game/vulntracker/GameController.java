package game.vulntracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

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
    
    private int currentQuestion = 0;
    

    // Function when an answer button is clicked, should check which button is clicked and determine if the answer was right or wrong
    void answerSelected(Integer i) {
    	
    	GameApplication.questionList.get(currentQuestion).checkAnswer(i);

    }

    // Function for when Back button is clicked, should cycle to previous question with its feedback
    @FXML
    void goBack(ActionEvent event) {

    	currentQuestion += -1;
    }

    // Function for when Next button is clicked, should cycle to next question
    @FXML
    void goNext(ActionEvent event) {

    	currentQuestion += 1;
    	questionScreen.setText(GameApplication.questionList.get(currentQuestion).getQuestion());
    	
    }
    
    @FXML
    void buttonAClick(ActionEvent event) {
    	System.out.println("TEST A Button");
    	int i; 
    	i = 0;
    	answerSelected(i);
    }
    
    
    
    
}
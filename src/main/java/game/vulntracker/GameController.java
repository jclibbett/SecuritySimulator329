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
    private int btnNumber;
    private String whichButton;
    private double totalrisk = 0;

    

    // Function when an answer button is clicked, should check which button is clicked and determine if the answer was right or wrong
    void answerSelected(Integer i) {
    	
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	
    	String userAnswer;
    	userAnswer = GameApplication.questionList.get(currentQuestion).checkAnswer(i);
    	
    	String[] feedbackT;
    	feedbackT = GameApplication.questionList.get(currentQuestion).getFeedback();
    	String feedbackText;
    	feedbackText = feedbackT[btnNumber];
    	
    	int isCorrect;
    	if (userAnswer.contains("The answer is correct.")) {
    		isCorrect = 1;
    	}
    	else {
    		isCorrect = 0;
    	}
    	
    	int[] riskLevel;
    	riskLevel = GameApplication.questionList.get(currentQuestion).getThreatLevel();
    	int riskLevelInt;
    	riskLevelInt = riskLevel[btnNumber];
    	
    	totalrisk += (double)riskLevelInt;
    	
    	threatBar.setProgress(totalrisk);
    	
    	switch (i) {
    	
    	case 0:
    		whichButton = "A";
    	case 1:
    		whichButton = "B";
    	case 2:
    		whichButton = "C";
    	case 3:
    		whichButton = "D";
    	}
  
    	switch(isCorrect) {
    	case 1:
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected:" + whichButton + System.lineSeparator() + userAnswer);
    	case 0:
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected:" + whichButton + System.lineSeparator() + userAnswer + feedbackText);
    	}
    	 		
    		
    }

    // Function for when Back button is clicked, should cycle to previous question with its feedback
    @FXML
    void goBack(ActionEvent event) {

    	currentQuestion -= 1;
    	
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	questionScreen.setText(question);
    	
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);
    	
    }

    // Function for when Next button is clicked, should cycle to next question
    @FXML
    void goNext(ActionEvent event) {

    	currentQuestion += 1;
    	
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	questionScreen.setText(question);
    	
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);
    	
    }
    
    @FXML
    void buttonAClick(ActionEvent event) {
    	System.out.println("TEST A Button");
    	this.btnNumber = 0;
    	answerSelected(btnNumber);
    }
    
    @FXML
    void buttonBClick(ActionEvent event) {
    	System.out.println("TEST B Button");
    	this.btnNumber = 1;
    	answerSelected(btnNumber);
    }
    
    @FXML
    void buttonCClick(ActionEvent event) {
    	System.out.println("TEST C Button");
    	this.btnNumber = 2;
    	answerSelected(btnNumber);
    }
    
    @FXML
    void buttonDClick(ActionEvent event) {
    	System.out.println("TEST D Button");
    	this.btnNumber = 3;
    	answerSelected(btnNumber);
    }
    
    
    
    
}
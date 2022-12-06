package game.vulntracker;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
    private double totalrisk = 0.0;
	private int totalCorrect = 0;

	static DoubleProperty riskUpdate = new SimpleDoubleProperty(.0);

    

    // Function when an answer button is clicked, should check which button is clicked and determine if the answer was right or wrong
    void answerSelected(Integer i) {

		answersOff();
		nextbackOn();

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
    	double riskLevelInt;
    	riskLevelInt = riskLevel[btnNumber];

    	totalrisk += riskLevelInt/100;

		System.out.printf("Current risk level: %,.0f percent", totalrisk*100);

		threatBar.setProgress(totalrisk);
    	
    	switch (i) {
    	
    	case 0:
    		whichButton = "A";
			break;
    	case 1:
    		whichButton = "B";
			break;
    	case 2:
    		whichButton = "C";
			break;
    	case 3:
    		whichButton = "D";
			break;
    	}
  
    	switch(isCorrect) {
    	case 1:
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected: " + whichButton + System.lineSeparator() + userAnswer);
			totalCorrect += 1;
			break;
    	case 0:
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected: " + whichButton + System.lineSeparator() + userAnswer + feedbackText);
			break;
    	}
    	
    	if (totalrisk >= 1) {
    		Alert end = new Alert(AlertType.WARNING);
    		end.setTitle("Game Over");
    		end.setHeaderText("Oh no! Your Threat Level has reached 100%.");
    		end.setContentText("Your company's security systems were breached by hackers and your data was compromised. Program now exit.");
			end.showAndWait();

    		try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.exit(0);
    	}
    	 		
    		
    }

    // Function for when Back button is clicked, should cycle to previous question with its feedback
    @FXML
    void goBack(ActionEvent event) {
		buttonNext.setText("Next");

		answersOn();

    	currentQuestion -= 1;

		if (currentQuestion == 0) {
			buttonBack.setVisible(false);
		}
    	
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	questionScreen.setText(question);
    	
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);

		nextbackOff();
    	
    }

    // Function for when Next button is clicked, should cycle to next question
    @FXML
    void goNext(ActionEvent event) {
		buttonBack.setVisible(true);
		answersOn();

    	currentQuestion += 1;


		if (currentQuestion == GameApplication.questionList.size()-1) {
			buttonNext.setText("End");
		}

		if (currentQuestion == GameApplication.questionList.size()) {
			Alert end = new Alert(AlertType.INFORMATION);
			end.setTitle("Congratulations!");
			end.setHeaderText("Good job! You have completed all questions and successfully kept your company secure.");
			String content = String.format("Your final threat level was %,.0f percent, and you answered %d questions correctly!", totalrisk*100, totalCorrect);
			end.setContentText(content);
			end.showAndWait();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
    	
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	questionScreen.setText(question);
    	
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);

		nextbackOff();
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


	private void answersOff() {
		buttonA.setDisable(true);
		buttonB.setDisable(true);
		buttonC.setDisable(true);
		buttonD.setDisable(true);
	}

	private void answersOn() {
		buttonA.setDisable(false);
		buttonB.setDisable(false);
		buttonC.setDisable(false);
		buttonD.setDisable(false);
	}

	private void nextbackOff() {
		buttonNext.setDisable(true);
		buttonBack.setDisable(true);
	}

	private void nextbackOn() {
		buttonNext.setDisable(false);
		buttonBack.setDisable(false);
	}
    
    public void initialized(URL url, ResourceBundle rb) {
		threatBar.progressProperty().bind(riskUpdate);
	}
}
package game.vulntracker;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
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
    
    @FXML
    private ImageView image;
    
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
    	
    	String feedbackText;
    	feedbackText = GameApplication.questionList.get(currentQuestion).getFeedback();
    	
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
    	
    	Image picture = new Image(getClass().getResourceAsStream("/images/image.png"));
    	image.setImage(picture);
    	
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

	@FXML
	void aboutClicked(ActionEvent event){
		Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("About Project");
		about.setHeaderText("CPSC 329 Fall 2022 Final Project: Company Vulnerabilities Quiz");
		about.setContentText("This game has you play as an employee at a tech company and it is your job to make decisions to protect the company's data. It aims to teach the player about the many vulnerabilities your data can face and how to prevent attacks.\nThis project was made by:\nJustin Clibbett\nShaheryar Syed\nDevon Harstrom\nSean Anselmo\nAreez Nadeem");
		about.showAndWait();
	}

	@FXML
	void howtoplayClicked(ActionEvent event) {
		Alert howto = new Alert(AlertType.INFORMATION);
		howto.setTitle("How to Play");
		howto.setHeaderText("How to play Company Vulnerabilities Quiz");
		howto.setContentText("You will be presented with a question and 4 answers. You must try to pick the correct answer. There are a total of 15 questions you must answer to complete the game.\nAfter picking an answer, you will be given feedback for that question. Press 'Next' to advance to the next question.\nA Threat Meter is displayed at the bottom of the screen and will be empty when you start the game. It will rise every time a question is answered incorrectly, and some answers may raise it more than others. If the Threat Meter is completely filled, you will lose the game.\nGood luck!");
		howto.showAndWait();
	}

	@FXML
	void exitClicked(ActionEvent event) {
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
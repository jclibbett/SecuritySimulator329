// CPSC329 Fall 2022 Final Project: Security Simulator
// A question and answers game where the player works at a company and must make decisions to protect the company's data
// Group Members:
// Justin Clibbett
// Devon Harstrom
// Shaheryar Syed
// Sean Anselmo
// Areez Nadeem

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
	
	// Option A Button
    @FXML
    private Button buttonA;

    // Option B Button
    @FXML
    private Button buttonB;

    // Back Button
    @FXML
    private Button buttonBack;

    // Option C Button
    @FXML
    private Button buttonC;

    // Option D Button
    @FXML
    private Button buttonD;

    // Next Button
    @FXML
    private Button buttonNext;

    // Text box that contains the question/feedback
    @FXML
    private TextArea questionScreen;

    // Progress bar that tracks the threat level
    @FXML
    private ProgressBar threatBar;
    
    // Image container 
    @FXML
    private ImageView image;
    
    // Current question counter
    private int currentQuestion = 0;
    
    // Button number (returned from buttons on click)
    private int btnNumber;
    
    // Which Button (Ex. A, B...) used in answerSelected
    private String whichButton;
    
    // Total Risk Value
    private double totalrisk = 0.0;
    
    // Correct responses tracker
	private int totalCorrect = 0;
	
	// Risk value updater
	static DoubleProperty riskUpdate = new SimpleDoubleProperty(.0);

    
	/**
	 * Function when an answer button is clicked, should check which button is clicked and determine if the answer was right or wrong
	 * @param Takes in an integer from the answer buttons evaluates user answer, and updates the feedback, and threat level.
	 */
    void answerSelected(Integer i) {

    	// Disable answer selection & next/forward buttons
		answersOff();
		nextbackOn();

		// Get Current Question
    	String question;
    	question = GameApplication.questionList.get(currentQuestion).getQuestion();
    	
    	// Get User answer
    	String userAnswer;
    	userAnswer = GameApplication.questionList.get(currentQuestion).checkAnswer(i);
    	
    	// Get the feedback
    	String feedbackText;
    	feedbackText = GameApplication.questionList.get(currentQuestion).getFeedback();
    	
    	// Move isCorrect depending on if user answer is correct
    	int isCorrect;
    	if (userAnswer.contains("The answer is correct.")) {
    		isCorrect = 1;
    	}
    	else {
    		isCorrect = 0;
    	}
    	
    	// Get Risk level depending which answer the user selects
    	int[] riskLevel;
    	riskLevel = GameApplication.questionList.get(currentQuestion).getThreatLevel();
    	double riskLevelInt;
    	riskLevelInt = riskLevel[btnNumber];

    	// Update the total risk based on answer selection
    	totalrisk += riskLevelInt/100;

    	// Print the risk percent to console
		System.out.printf("Current risk level: %,.0f percent", totalrisk*100);

		// Display the current risk level after answer selection
		threatBar.setProgress(totalrisk);
    	
		// Assign whichButton a string value based on what button was clicked, i is returned from each button
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
  
    	// Which line should be displayed based on if the answer was correct as there is no feedback if the answer was correct.
    	switch(isCorrect) {
    	case 1:
    		// Dont display feedback as user got the question correct
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected: " + whichButton + System.lineSeparator() + userAnswer);
			totalCorrect += 1;
			break;
    	case 0:
    		// Display feedback as user got the question wrong
    		questionScreen.setText("The question was:" + System.lineSeparator() + question + System.lineSeparator() + "You selected: " + whichButton + System.lineSeparator() + userAnswer + feedbackText);
			break;
    	}
    	
    	// What to do once total risk reaches 100%
    	if (totalrisk >= 1.00) {
    		
    		// Form an alert and display it to the user
    		Alert end = new Alert(AlertType.WARNING);
    		end.setTitle("Game Over");
    		end.setHeaderText("Oh no! Your Threat Level has reached 100%.");
    		end.setContentText("Your company's security systems were breached by hackers and your data was compromised. Program will now exit.");
			end.showAndWait();
			
			// On OK click, exit

    		try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.exit(0);
    	}
    	 		
    		
    }

    /**
     *  Function for when Back button is clicked, should cycle to previous question with its feedback
     * @param Back button event, gets the previous question with it's text, answer values, and image allowing the user to retry the question
     */
    @FXML
    void goBack(ActionEvent event) {
    	
    	// Set next button text
		buttonNext.setText("Next");

		// Enable answer selection
		answersOn();

		// Go back to the previous question
    	currentQuestion -= 1;

    	// If on first question, disable the back button
		if (currentQuestion == 0) {
			buttonBack.setVisible(false);
		}
    	
		// Get the previous question and display it on the screen
    	String questionString;
    	questionString = GameApplication.questionList.get(currentQuestion).getQuestion();
		String question = String.format("Question #%d\n"+questionString, currentQuestion+1);
    	questionScreen.setText(question);
    	
    	// Get the answer options for the previous question
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	// Set the answer options for the previous question
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);

    	// Set the image for the previous question and change it's dimensions
		Image picture = new Image(getClass().getResourceAsStream(GameApplication.questionList.get(currentQuestion).getImage()));
		image.setFitWidth(612);
		image.setFitHeight(408);
		image.setPreserveRatio(true);
		image.setImage(picture);

		// Disable next & back button
		nextbackOff();
    	
    }

    /**
     * Function for when Next button is clicked, should cycle to next question
     * @param Next button event, gets the next question with it's text, answer values, and image allowing the user to move forward
     */
    @FXML
    void goNext(ActionEvent event) {
    	
    	// Enable the back button
		buttonBack.setVisible(true);
		answersOn();

		// Increment current question by +1
    	currentQuestion += 1;

    	// If at the 15th question change text value
		if (currentQuestion == GameApplication.questionList.size()-1) {
			buttonNext.setText("End");
		}
		
		// Once the user has answered all 15 questions show a message box with the final threat percentage and the total correct answers
		if (currentQuestion == GameApplication.questionList.size()) {
			Alert end = new Alert(AlertType.INFORMATION);
			end.setTitle("Congratulations!");
			end.setHeaderText("Good job! You have completed all questions and successfully kept your company secure.");
			String content = String.format("Your final threat level was %,.0f percent, and you answered %d questions correctly!", totalrisk*100, totalCorrect);
			end.setContentText(content);
			end.showAndWait();
			
			// Exit once user presses ok

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}

		// Get the next question and update it on screen
		String questionString;
		questionString = GameApplication.questionList.get(currentQuestion).getQuestion();
		String question = String.format("Question #%d\n"+questionString, currentQuestion+1);
		questionScreen.setText(question);
    	
		// Get the next set of answers and update it on screen
    	String[] options;
    	options = GameApplication.questionList.get(currentQuestion).getAnswers();
    	
    	buttonA.setText(options[0]);
    	buttonB.setText(options[1]);
    	buttonC.setText(options[2]);
    	buttonD.setText(options[3]);
    	
    	// Get the next image and update it on screen
    	Image picture = new Image(getClass().getResourceAsStream(GameApplication.questionList.get(currentQuestion).getImage()));
		image.setFitWidth(612);
		image.setFitHeight(408);
		image.setPreserveRatio(true);
    	image.setImage(picture);
    	
    	// Disable next & back button
		nextbackOff();
    }
    
    /**
     * Button A click
     * @param First Button A on click event
     */
    @FXML
    void buttonAClick(ActionEvent event) {
    	this.btnNumber = 0;
    	answerSelected(btnNumber);
    }
    
    /**
     * Button B click
     * @param Button B on click event
     */
    @FXML
    void buttonBClick(ActionEvent event) {
    	this.btnNumber = 1;
    	answerSelected(btnNumber);
    }
    
    /**
     * Button C click
     * @param Button C on click event
     */
    @FXML
    void buttonCClick(ActionEvent event) {
    	this.btnNumber = 2;
    	answerSelected(btnNumber);
    }
    
    /** 
     * Button C click
     * @param Button D on click event
     */
    @FXML
    void buttonDClick(ActionEvent event) {
    	this.btnNumber = 3;
    	answerSelected(btnNumber);
    }

    /**
     * About menu listing details
     * @param Opens an about menu that displays the details of the game and the authors
     */
	@FXML
	void aboutClicked(ActionEvent event){
		Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("About Project");
		about.setHeaderText("CPSC 329 Fall 2022 Final Project: Security Simulator");
		about.setContentText("This game has you play as an employee at a tech company and it is your job to make decisions to protect the company's data. It aims to teach the player about the many vulnerabilities your data can face and how to prevent attacks.\nThis project was made by:\nJustin Clibbett\nShaheryar Syed\nDevon Harstrom\nSean Anselmo\nAreez Nadeem");
		about.showAndWait();
	}

	/**
	 * Game tutorial
	 * @param Opens a tutorial menu that lists the steps required to play the game
	 */
	@FXML
	void howtoplayClicked(ActionEvent event) {
		Alert howto = new Alert(AlertType.INFORMATION);
		howto.setTitle("How to Play");
		howto.setHeaderText("How to play Security Simulator");
		howto.setContentText("1. You will be presented with a question and 4 answers. You must try to pick the correct answer. There are a total of 15 questions you must answer to complete the game.\n\n2. After picking an answer, you will be given feedback for that question. Press 'Next' to advance to the next question.\n\n3. A Threat Meter is displayed at the bottom of the screen and will be empty when you start the game. It will rise every time a question is answered incorrectly, and some answers may raise it more than others. If the Threat Meter is completely filled, you will lose the game.\n\n4. You can also press 'Back' to go to the previous question and try again. Be careful, because if you get it wrong again, it will still increase the Threat Meter.\n\nGood luck!");
		howto.showAndWait();
	}

	/**
	 * Exit button
	 * @param Prompts the user to exit the program if they desire to do so
	 */
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

	/**
	 * Disable all answer selections
	 * @param Disables all answer selections
	 */
	private void answersOff() {
		buttonA.setDisable(true);
		buttonB.setDisable(true);
		buttonC.setDisable(true);
		buttonD.setDisable(true);
	}

	/**
	 * Enable all answer selections
	 * @param Enables all answer selections
	 */
	private void answersOn() {
		buttonA.setDisable(false);
		buttonB.setDisable(false);
		buttonC.setDisable(false);
		buttonD.setDisable(false);
	}

	/**
	 * Disable the next & back buttons
	 * @param Disables the Back button & Next button
	 */
	private void nextbackOff() {
		buttonNext.setDisable(true);
		buttonBack.setDisable(true);
	}

	/**
	 * Enable the next and back buttons
	 * @param Enables the back button & the next button
	 */
	private void nextbackOn() {
		buttonNext.setDisable(false);
		buttonBack.setDisable(false);
	}
	

	/**
	 * Events to take place on load
	 * @param On application load, load the first question, its set of answer options and it's image
	 */
	@FXML
	public void initialize() {
		
		// Format Button values to hold text
		buttonA.setWrapText(true);
		buttonB.setWrapText(true);
		buttonC.setWrapText(true);
		buttonD.setWrapText(true);

		// Get the first question and set it on the screen
		String questionString;
		questionString = GameApplication.questionList.get(currentQuestion).getQuestion();
		String question = String.format("Question #%d\n"+questionString, currentQuestion+1);
		questionScreen.setText(question);

		// Get the first question answer options and update the buttons
		String[] options;
		options = GameApplication.questionList.get(currentQuestion).getAnswers();
		buttonA.setText(options[0]);
		buttonB.setText(options[1]);
		buttonC.setText(options[2]);
		buttonD.setText(options[3]);

		// Get the first question image and update it on screen
		Image picture = new Image(getClass().getResourceAsStream(GameApplication.questionList.get(currentQuestion).getImage()));
		image.setFitWidth(612);
		image.setFitHeight(408);
		image.setPreserveRatio(true);
		image.setImage(picture);

		// Hide the back button
		buttonBack.setVisible(false);
	}
}
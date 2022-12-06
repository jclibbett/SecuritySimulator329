package game.vulntracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 990, 730);
        stage.setTitle("CPSC329 Final Project: How Vulnerable Are You?");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<Question> questionList;

    public static void main(String[] args) {
        questionList = new ArrayList();

        // Add a question format
        String[] f1 = {" ", " ", " ", " "};
        String[] a1 = {"A. ", "B. ", "C. ", "D. "};
        // Risk factor per question
        int[] r1 = {0, 5, 25, 50};
        Question q1 = new Question("question?", f1, a1, r1, 0);
        questionList.add(q1);

        String[] f2 = {"Feedback A ", "Feedback B ", "Feedback C ", "Feedback D"};
        String[] a2 = {"A. question 2 test", "B. question 2 test", "C. question 2 test", "D. question 2 test"};
        // Risk factor per question
        int[] r2 = {25, 5, 0, 50};
        Question q2 = new Question("Test question 2", f2, a2, r2, 2);
        questionList.add(q2);

        Collections.shuffle(questionList);
        for (int i = questionList.size(); i > 14; i--) {
            questionList.remove(i);
        }

        launch();
    }
}
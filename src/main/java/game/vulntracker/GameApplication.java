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
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 990, 730);
        stage.setTitle("CPSC329 Final Project: Security Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<Question> questionList;

    public static void main(String[] args) {
        questionList = new ArrayList();

        // Add a question format
        // A = 0, B = 1, C = 2, D = 3
        String qs1 = "question?";
        String f1 = "Feedback";
        String[] a1 = {"A. ", "B. ", "C. ", "D. "};
        int[] r1 = {25, 25, 25, 25};
        Question q1 = new Question(qs1, f1, a1, r1, 0); // args (Question, Feedback, Answers, Risks, Correct Answer)
        questionList.add(q1);


        Collections.shuffle(questionList);
        for (int i = questionList.size(); i > 14; i--) {
            questionList.remove(i);
        }

        launch();
    }
}
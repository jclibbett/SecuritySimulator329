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
        Scene scene = new Scene(fxmlLoader.load(), 1000, 720);
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

        Collections.shuffle(questionList);
        for (int i = questionList.size(); i > 14; i--) {
            questionList.remove(i);
        }

        launch();
    }
}
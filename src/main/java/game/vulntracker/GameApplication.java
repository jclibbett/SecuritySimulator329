package game.vulntracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 720);
        stage.setTitle("CPSC329 Final Project: How Vulnerable Are You?");
        stage.setScene(scene);
        stage.show();
    }

    private static ArrayList<Question> questionList;

    public static void main(String[] args) {
        questionList = new ArrayList();
        String[] f1 = {" ", " ", " ", " "};
        String[] a1 = {"A. ", "B. ", "C. ", "D. "};
        int[] r1 = {0, 0, 0, 0};
        Question q1 = new Question("question?", f1, a1, r1, 0);
        questionList.add(q1);

        launch();
    }
}
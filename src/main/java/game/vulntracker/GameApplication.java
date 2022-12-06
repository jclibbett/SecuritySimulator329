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

        String qs1 = "You’ve been tasked with creating certain requirements for setting company passwords. What requirements offer the best security?";
        String f1 = "Setting no requirement is a risk as this means passwords could be common passwords. Thus adding requirements similar to the NIST password guidelines such as minimum password length as well as this having a combination of numbers, capital/lower case letters and symbols will increase attack time.";
        String[] a1 = {"A. No requirements are needed to offer security ", "B. Set the recruitment to have at least one number and one Capital letter ", "C. Set the recruitment to have the password length of at least 12 letters as well as at least one number, one Capital letter and one symbol. Requirements similar to the NIST password guidelines ", "D. Set the recruitment to have the password length of at least 12 letters "};
        int[] r1 = {20, 10, 0, 10}; // risk values
        Question q1 = new Question(qs1, f1, a1, r1, 2);
        questionList.add(q1);

        String qs2 = "You’ve been tasked with storing created passwords on the company server. What is your method for encrypting passwords?";
        String f2 = "Plaintext involves no encryption so is very easy to access if hacked. MD-5 has been cracked, so it is easy to decrypt, which is unsafe. SHA-256 is currently the best and most common hash function used. Salting the passwords before hashing using SHA-256 is the best option as salting ensures that if two people use the same passwords, the passwords will be stored as two different strings of characters rather than the same ones.";
        String[] a2 = {"A. No method, just store the passwords as plaintext.", "B. You could hash the passwords using the SHA-256 hash function ", "C. You could hash the passwords using the MD5 hash function. ", "D. You could hash the passwords using the SHA-256 hash function with salt "};
        int[] r2 = {20, 10, 10, 0}; // risk values
        Question q2 = new Question(qs2, f2, a2, r2, 3);
        questionList.add(q2);

        String qs3 = "Your company plans to introduce measures to authenticate users before they access the company’s systems. What methods do you take to authenticate users?";
        String f3 = "All 3 of the measures above are valid authentication methods. However, it is best to combine multiple different authentication methods to ensure maximum security.";
        String[] a3 = {"A. Passwords", "B. Location of the device", "C. Biometrics (ex: facial recognition)", "D. All of the above"};
        int[] r3 = {10, 20, 10, 0}; // risk values
        Question q3 = new Question(qs3, f3, a3, r3, 3);
        questionList.add(q3);

        String qs4 = "What group of people should have access to sensitive company data?";
        String f4 = "No one outside the company should be given sensitive company data. People at the company may seem trustworthy, however there is still a risk that the information could be altered or leaked. That's why none of the above mentioned groups should have access to sensitive data. Only people like the CEO should have access to sensitive data.";
        String[] a4 = {"A. Your team leader", "B. Fellow employees", "C. People outside the company", "D. None of the above"};
        int[] r4 = {10, 10, 20, 0}; // risk values
        Question q4 = new Question(qs4, f4, a4, r4, 3);
        questionList.add(q4);

        String qs5 = "The company accountant is requesting permission for a budget file containing employee salary. What type of permissions should you give them?";

        String f5 = "You should not allow someone at that position to alter salary pay, therefore they should not be able to have “write” permissions for the budget file as this could lead to fraud when audited. The “create” permission is a trick question as there's no permission called create. While not posing a threat, it shows a lack of knowledge in file permissions. “Read” is the best choice as it allows them to access the information they need without giving more control than necessary.";

        String[] a5 = {"A. Write", "B. Read", "C. Create", "D. Both read and write"};
        int[] r5 = {20, 0, 10, 20}; // risk values
        Question q5 = new Question(qs5, f5, a5, r5, 1);
        // args (Question, Feedback, Answers, Risks, Correct Answer)
        questionList.add(q5);


        Collections.shuffle(questionList);
        for (int i = questionList.size(); i > 14; i--) {
            questionList.remove(i);
        }

        launch();
    }
}
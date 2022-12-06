package game.vulntracker;

public class Question {
    private String question;
    private String[] feedback;
    private String[] answerList;
    private int[] risks;
    private int answerIndex;

    public Question(String q, String[] f, String[] answers, int[] r, int correctAnswer){
        this.question = q;
        this.feedback = f;
        this.answerList = answers;
        this.risks = r;
        this.answerIndex = correctAnswer;
    }

    public String getQuestion() {return this.question;}

    public String getFeedback(int i) {return this.feedback[i];}

    public String getAnswer(int i) {return this.answerList[i];}

    public int getRisk(int i) {return this.risks[i];}

    public String checkAnswer(int i) {
        if (i == this.answerIndex) {
            return "That is correct!";
        } else {
            return "That is incorrect.";
        }
    }
}

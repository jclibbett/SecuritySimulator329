package game.vulntracker;

public class Question {
    private String question;
    private String feedback;
    private String[] answerList;
    private int[] risks;
    private int answerIndex;

    public Question(String q, String f, String[] answers, int[] r, int correctAnswer){
        this.question = q;
        this.feedback = f;
        this.answerList = answers;
        this.risks = r;
        this.answerIndex = correctAnswer;
    }

    public String getQuestion() {return this.question;}

    public String getFeedback() {return this.feedback;}

    public String[] getAnswers() {return this.answerList;}
    
    public int[] getThreatLevel() {return this.risks;}

    public String checkAnswer(int i) {
        if (i == this.answerIndex) {
            return "The answer is correct.";
        } else {
            return "The answer is incorrect because: ";
        }
    }
}

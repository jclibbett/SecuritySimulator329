// CPSC329 Fall 2022 Final Project: Security Simulator
// A question and answers game where the player works at a company and must make decisions to protect the company's data
// Group Members:
// Justin Clibbett
// Devon Harstrom
// Shaheryar Syed
// Sean Anselmo
// Areez Nadeem

package game.vulntracker;

public class Question {

    // Initializing fields for Question
    private String question; // The question
    private String feedback; // The feedback
    private String[] answerList; // List of strings containing the possible answers
    private int[] risks; // List of integers that represent the risk level of each question (higher integer is more risky)
    private int answerIndex; // Integer that represents the index of the correct answer in the answerList
    private String image; // String that contains the filepath to an image

    /**
     * Constructor for a Question
     *
     * @param q = question string input
     * @param f = feedback string input
     * @param answers = answer array input
     * @param r = risk array input
     * @param correctAnswer = correct answer index input
     * @param image = image path string input
     */
    public Question(String q, String f, String[] answers, int[] r, int correctAnswer, String image){
        this.question = q;
        this.feedback = f;
        this.answerList = answers;
        this.risks = r;
        this.answerIndex = correctAnswer;
        this.image = image;
    }

    /**
     * Returns the question string for this question
     *
     * @return = a question string
     */
    public String getQuestion() {return this.question;}

    /**
     * Returns the feedback string for this question
     *
     * @return = a feedback string
     */
    public String getFeedback() {return this.feedback;}

    /**
     * Returns the filepath string for the image for this question
     *
     * @return = a image filepath string
     */
    public String getImage() {return this.image;}


    /**
     * Returns the answer array for this question
     *
     * @return = an array of answer strings
     */
    public String[] getAnswers() {return this.answerList;}

    /**
     * Returns the threat level array for this question
     *
     * @return = an array of risk integers
     */
    public int[] getThreatLevel() {return this.risks;}

    /**
     * Checks if the input i matches the correct answer index, then returns a string
     *
     * @param i = input integer
     * @return = returns a string that says correct or incorrect
     */
    public String checkAnswer(int i) {
        if (i == this.answerIndex) {
            return "The answer is correct."; // Returns if answer matches i
        } else {
            return "The answer is incorrect because: "; // Returns if answer does not match i
        }
    }
}

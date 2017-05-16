/**
 * This class needs a better description //TODO
 * @Author: Mirja Johnsson
 */
public class Question {

    private String question;
    private String correctAnswer;
    private String category;
    private String[] answerAlternatives;

    /**
     * Initialise a new Question for the game!
     * @param question The Question that the player will see.
     * @param correctAnswer The correct answer to the question, only used internally in the game.
     * @param category Not used right now, might get displayed later... //TODO decide if keeping this.
     * @param answer1 These three are the different choices that the player will decide from
     * @param answer2 -""-
     * @param answer3 -""-
     */
    public Question(String question, String correctAnswer, String category, String answer1, String answer2, String answer3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;
        answerAlternatives = new String[3];
        answerAlternatives[0] = answer1;
        answerAlternatives[1] = answer2;
        answerAlternatives[2] = answer3;

    }

    /**
     * Gives access to the question
     * @return A String
     */
    public String showQuestion() {
        return question;
    }

    /**
     * Gives access to the answer
     * @return A String
     */
    public String showAnswer() {
        return correctAnswer;
    }

    /**
     * Gives access to the category
     * @return A String
     */
    public String showCategory() {
        return category;
    }

    /**
     * Gives the different answer options for the question.
     * @return An array of Strings
     */
    public String[] showAnswerAlternatives() {
        return answerAlternatives;
    }
}
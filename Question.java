/**
 * @Author: Mirja Johnsson
 */
public class Question extends Application implements EventHandler<ActionEvent> {

    private String question;
    private String correctAnswer;
    private String category;
    private Button button1;
    private Button button2;
    private Button button3;

    public Question(String question, String correctAnswer, String category, String opt1, String opt2, String opt3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;

    }

    public String showQuestion() {
        return question;
    }

    public String showAnswer() {
        return correctAnswer;
    }
}

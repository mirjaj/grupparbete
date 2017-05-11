import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @Author: Mirja Johnsson
 */
public class Game extends Application {

    private ArrayList<String> categories;
    private ArrayList<Question> questions;
    private Player player1;
    private Random random;
    private int questionCounter;
    private Question currentQuestion;
    private Scene scene;
    private Stage window;
    private Button button;
    private String[] answerAlternatives;


    /**
     * Start anew game!
     */
    public Game() {

        player1 = new Player();
        random = new Random();
        categories = new ArrayList<>(5);
        categories.add("Java");
        categories.add("Go");
        categories.add("Body Building");
        categories.add("Cat4");
        categories.add("Cat5");
        questions = new ArrayList<>(10);
        answerAlternatives = new String[3];
        questionCounter = 0;

    }

    /**
     * Here we write our questions for the game.
     */
    private void initialiseQuestions() {

        Question q1 = new Question("How many times did Jon Pall Sigmarsson win a big championship?", "4", "Pumping Iron", "1","4","5");
        Question q2 = new Question("How many times did Arnold win Mr Olympia?", "6", "Pumping Iron", "4", "5", "6");
        questions.add(q1);
        questions.add(q2);
    }


    private int rollDice() {

        return 1 + random.nextInt(6);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        initialiseQuestions();
        int size =  questions.size();
        int i = 0;


            if (i < size) {
                openWindow(i, primaryStage);
                i++;
            } else {
                System.out.println("Well now we're here."); //Debug helper
            }

    }

    /**
     * //TODO Find better way to display the question, and use the category as window title instead
     * //TODO make the questions appear in random order. Also make sure they never appear twice in the same game.
     * This method open a new question window to the player.
     * @param i
     * @param primaryStage
     */
    private void openWindow(int i, Stage primaryStage) {


        currentQuestion = questions.get(i);
        window = primaryStage;
        window.setTitle(currentQuestion.showQuestion());
        answerAlternatives = currentQuestion.showAnswerAlternatives();

        // Sets the answer options with the answer alternatives from the question. Only one can be chosen.
        final ToggleGroup group = new ToggleGroup();
        RadioButton alt1 = new RadioButton(answerAlternatives[0]);
        RadioButton alt2 = new RadioButton(answerAlternatives[1]);
        RadioButton alt3 = new RadioButton(answerAlternatives[2]);
        alt1.setToggleGroup(group);
        alt2.setToggleGroup(group);
        alt3.setToggleGroup(group);

        // When the answer button is clicked this checks whether it was the correct answer.
        button = new Button("This is my final answer!");
        button.setOnAction(e -> handleAnswer(i, primaryStage, alt1, alt2, alt3));


        VBox layout = new VBox(20);
        layout.setPadding(new Insets(50, 50, 50, 50));

        layout.getChildren().addAll(alt1, alt2, alt3);
        layout.getChildren().add(button);

        scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();



    }


    /**
     * Finds out if the player checked the box with the correct answer. If they did their points are increased.
     * For now it
     * //TODO What to do if the player just closes the window without answering?
     * @param alt1 RadioButton 1 These display the different answer alternatives
     * @param alt2 RadioButton 2
     * @param alt3 RadioButton 3
     */
    private void handleAnswer(int i, Stage primaryStage, RadioButton alt1, RadioButton alt2, RadioButton alt3) {
        questionCounter++;
        String correctAnswer = currentQuestion.showAnswer();

        if (alt1.isSelected() && alt1.getText().equalsIgnoreCase(correctAnswer)) {
            player1.increasePoints();
        }
        else if (alt2.isSelected() && alt2.getText().equalsIgnoreCase(correctAnswer)) {
            player1.increasePoints();
        }
        else if (alt3.isSelected() && alt3.getText().equalsIgnoreCase(correctAnswer)) {
            player1.increasePoints();
        }

        window.close();

        // the size check is a temporary fix to avoid a nullPointer. Will probably change when questions get randomized.
        if (!player1.isFinished() && questionCounter < questions.size()) {
            openWindow(i+1, primaryStage);
        }
        else {
            System.out.println("HEJ!"); //Debug helper
        }

    }


    public static void main(String[] args) {

        Game game = new Game();
        launch(args);
    }

}

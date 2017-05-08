import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;
/**
 * @Author: Mirja Johnsson
 */
public class Game extends Application{
    private int players;
    private ArrayList<String> categories;
    private ArrayList<Question> questions;
    private ArrayList<Boolean> turn;
    private Player player1;
    private Random random;
    private HashMap<Integer, Square> positions;
    private Scanner scanner;
//    private HashMap<> questions;


    public Game(int players) {
        player1 = new Player();
        random = new Random();
        this.players = players;
        categories = new ArrayList<>(5);
        categories.add("Java");
        categories.add("Go");
        categories.add("Discrete Mathematics");
        categories.add("Linear Algebra");
        categories.add("Numerical Analysis");
        positions = new HashMap<>(24);
        questions = new ArrayList<>(10);
        scanner = new Scanner(System.in);

    }

    private void initialiseQuestions() {

    }

    private void initialiseBoard() {
        for (int i = 0; i < 24; i++) {
            Square square = new Square(i);
            positions.put(i, square);
        }
    }

    private void placeHolderForQuestionInitialisation() {
        for (int i = 0; i < 10; i++) {
            Question q = new Question("Will this compile?", "Yes", "Go", "No", "Don't know", "Yes");
            questions.add(q);
        }
    }


    public void play() {
        initialiseQuestions();
        initialiseBoard();
        placeHolderForQuestionInitialisation();
        boolean finished = false;
        int counter = 0;
        while (!finished) {
            if (player1.isFinished()) {
                finished = true;
                System.out.println("Well done, you completed the game!");
                break;
            }

            else if (counter < 10){

                int steps = rollDice();
                System.out.println("You moved " + steps + " steps.");
                Question q = getQuestionPlaceHolder();
                System.out.println("Question: " + q.showQuestion());
                Boolean correct = answerPlaceHolder(q);

                if (correct) {
                    System.out.println("Correct, go on to the next question");
//                    System.out.println(rollDice());
                    counter++;
                }
                else {

                    System.out.println("Incorrect I'm afraid.");
                    counter++;
                }
            }
        }
    }

    public Question getQuestionPlaceHolder() {

        return questions.get(random.nextInt(questions.size()));
    }

    public Boolean answerPlaceHolder(Question q) {
        String answer = scanner.next();
        return answer.equalsIgnoreCase(q.showAnswer());
    }

    public int rollDice() {

        return 1 + random.nextInt(6);
    }

    public static void main(String[] args) {
        Game game = new Game(1);
        game.play();
        for (int i = 0; i < game.players; i++) {

        }
        return;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("");
    }
}
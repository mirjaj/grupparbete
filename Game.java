import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * @Author: Mirja Johnsson
 */
public class Game extends Application{
    private int players;
    private ArrayList<String> categories;
    private ArrayList<Boolean> turn;


    public Game(int players) {
        this.players = players;
        categories = new ArrayList<>(5);
        categories.add("Java");
        categories.add("Go");
        categories.add("Discrete Mathematics");
        categories.add("Linear Algebra");
        categories.add("Numerical Analysis");

    }


    public static void main(String[] args) {
        Game game = new Game(1);
        for (int i = 0; i < game.players; i++) {

        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("");
    }
}

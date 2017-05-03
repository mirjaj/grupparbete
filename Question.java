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
        button1 = new Button(opt1);
        button2= new Button(opt2);
        button3 = new Button(opt3);
    }
    public static void main(String[] args) {
        launch(args);
        Question q1 = new Question("Will this cause a deadlock?", "Yes", "Go","Yes.", "No.", "Impossible to tell.");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(category);
        
        button1.setOnAction(this);
        button2.setOnAction(this);
        button3.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button1);

        Scene scene = new Scene(layout, 260,260);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if(clickedButton.getText().equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct");
            //TODO figure out how to return true to the player so the player score gets updated!
        }
    }
}

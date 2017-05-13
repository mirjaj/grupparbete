import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * The main class of the game. It displays the gameboard, a button and the players current score.
 * @version 2017-05-13
 * @author Claudia Berlin
 * //TODO Find a way to display the questions and checkboxes.
 * //TODO Create a better system that updates the players score.
 * //TODO Be able to close the program properly, for example have a pop-up window which asks the user if they are sure they want to exit the game.
 */

public class Main extends Application {

    Button button;
    Gameboard gb;
    Canvas canvas;
    Label score;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create new player
        Player player1 = new Player("player1");

        //Get the image from a specific filepath and resize it.
        FileInputStream imageOfADice = new FileInputStream("C:\\Users\\Claudia\\IdeaProjects\\theGame\\src\\White_Dice.png");
        ImageView dice = new ImageView(new Image(imageOfADice));
        dice.setFitHeight(100);
        dice.setFitWidth(100);


        //Create a button with text and an image.
        button = new Button("Throw dice", dice);
        button.setLayoutX(1025);
        button.setLayoutY(400);
        button.setContentDisplay(ContentDisplay.TOP);
        button.setFont(Font.font("Calisto MT", 18));

        //Create a label which displays the players score.
        score = new Label();
        score.setFont(Font.font("Calisto MT", 32));
        score.setLayoutX(1020);
        score.setLayoutY(30);
        score.setText("Score \n" + player1.getName() + ":  " + String.valueOf(player1.getScore()) );


        //event action for button
        button.setOnAction(e -> {
            player1.rollDiceAndMove();
            gb.movePiece(player1.getPreviousSquare(), player1.getCurrentSquare());
            primaryStage.show();
            player1.setScore();
            score.setText("Score \n" + player1.getName() + ":  " + String.valueOf(player1.getScore()) );
        });

        //Initialize canvas
        canvas = new Canvas(1200, 1024);
        gb = new Gameboard();
        gb.setCanvas(canvas);
        gb.start(primaryStage);
        canvas = gb.getCanvas();

        Group root = new Group();

        root.getChildren().add(canvas);
        root.getChildren().add(button);
        root.getChildren().add(score);
        primaryStage.setScene(new Scene(root)); //byt den till root eller pane
        primaryStage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}

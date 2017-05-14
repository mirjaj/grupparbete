import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;

/**
 * The main class of the game. It starts the game.
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
    Player player1;
    Stage window;
    Scene mainMenu, theGame;
    MenuButtons startGame, changeDifficulty, exitGame, easy, medium, hard, back;

    /**
     * Creates a player, the game board and canvas.
     */
    public Main() {
        player1 = new Player();
        canvas = new Canvas(1150, 950);
        gb = new Gameboard();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        //Get the images from specific filepath and resize it.
        FileInputStream imageOfADice = new FileInputStream("C:\\Users\\Claudia\\IdeaProjects\\theGame\\Images\\White_Dice.png");
        FileInputStream background = new FileInputStream("C:\\Users\\Claudia\\IdeaProjects\\theGame\\Images\\cool-background.jpg");
        ImageView dice = new ImageView(new Image(imageOfADice));
        ImageView backgroundMenu = new ImageView(new Image(background));
        dice.setFitHeight(100);
        dice.setFitWidth(100);
        backgroundMenu.setFitWidth(1150);
        backgroundMenu.setFitHeight(950);

        /**
         * Main menu for the game.
         * Created by Claudia Berlin, 2017-05-14.
         */
         Pane layout = new Pane();
         layout.setPrefSize(1150,950);

         //Create a VBox layout with spacing 10 and give it a specific position.
         VBox menu1 = new VBox(10);
         menu1.setLayoutX(400);
         menu1.setLayoutY(250);

        //Create a second VBox layout for when you hit change difficulty.
        VBox menu2 = new VBox(10);
        menu2.setLayoutX(400);
        menu2.setLayoutY(250);

        //Create buttons from the class MenuButtons.
        startGame = new MenuButtons("Start Game");
        changeDifficulty = new MenuButtons("Difficulty");
        exitGame = new MenuButtons("Exit");
        easy = new MenuButtons("Easy");
        medium = new MenuButtons("Medium");
        hard = new MenuButtons("Hard");
        back = new MenuButtons("Back");

        //Add the buttons to the different VBox layouts.
        menu1.getChildren().addAll(startGame, changeDifficulty, exitGame);
        menu2.getChildren().addAll(easy,medium,hard, back);

        //Events for the menu buttons.
        startGame.setOnMouseClicked(e -> window.setScene(theGame));
        exitGame.setOnMouseClicked(e-> System.exit(0));
        changeDifficulty.setOnMouseClicked(e -> {
            layout.getChildren().remove(menu1);
            layout.getChildren().add(menu2);

        });

        back.setOnMouseClicked(e -> {
            layout.getChildren().remove(menu2);
            layout.getChildren().add(menu1);
        });

        //Add buttons and background picture to the main menu.
         layout.getChildren().addAll(backgroundMenu, menu1);
         mainMenu = new Scene(layout);
         window.setScene(mainMenu);

        /**
         * The actual game.
         */
        //Create a button with text with an image.
        button = new Button("Throw dice", dice);
        button.setLayoutX(980);
        button.setLayoutY(350);
        button.setContentDisplay(ContentDisplay.TOP);
        button.setFont(Font.font(null, FontWeight.BOLD, 18));

        //Create a label which displays the players score.
        score = new Label();
        score.setFont(Font.font(null, FontWeight.BOLD, 24));
        score.setLayoutX(980);
        score.setLayoutY(30);
        score.setText("Score \n" + player1.getName() + ":  " + String.valueOf(player1.getScore()) );

        //Event action for buttons
        button.setOnAction(e -> {
            player1.rollDiceAndMove();
            gb.movePiece(player1.getPreviousSquare(), player1.getCurrentSquare());
            player1.setScore(5);
            score.setText("Score \n" + player1.getName() + ":  " + String.valueOf(player1.getScore()) );
        });

        //Initialize canvas with piece
        gb.setCanvas(canvas);
        gb.start(window);
        canvas = gb.getCanvas();
        gb.movePiece(player1.getPreviousSquare(), player1.getCurrentSquare());

        //Set layout and add the components.
        Group layout2 = new Group();
        layout2.getChildren().add(canvas);
        layout2.getChildren().add(button);
        layout2.getChildren().add(score);

        //Display the scenes
        theGame = new Scene(layout2);
        window.show();
    }


    public static void main(String[]args) {
        launch(args);
    }

}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The main class of the game. It starts the game.
 * @version 2017-05-13
 * @author Claudia Berlin, Mirja Johnsson, August Danell Håkansson
 * //TODO Be able to close the program properly, for example have a pop-up window which asks the user if they are sure they want to exit the game.
 */

public class Main extends Application {
    private Button buttonA, buttonD ;
    private Gameboard gb;
    private Canvas canvas;
    private Label score;
    private Player player1, player2, player3, player4;
    private Stage window, qWindow;
    private Scene mainMenu, theGame, questionScene;
    private MenuButtons startGame, changeDifficulty, exitGame, easy, medium, hard, back;
    private ArrayList<Question> questions;
    private Question currentQuestion;
    private String[] answerAlternatives;
    private int questionCounter;
    private int difficulty;

    /**
     * Creates a player, the game board and canvas.
     */
    public Main() {
        player1 = new Player("Player1");
        player2 = new Player("NPC1");
        player3 = new Player("NPC2");
        player4 = new Player("NPC3");
        canvas = new Canvas(1150, 950);
        gb = new Gameboard();
        difficulty = 2; //default difficulty is medium.
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        questions = new ArrayList<>(10);
        answerAlternatives = new String[3];
        initialiseQuestions();
        questionCounter = 0;

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
        easy.setOnMouseClicked(e -> difficulty = 1);
        medium.setOnMouseClicked(e -> difficulty = 2);
        hard.setOnMouseClicked(e -> difficulty = 3);

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
        buttonD  = new Button("Throw dice", dice);
        buttonD.setLayoutX(980);
        buttonD.setLayoutY(350);
        buttonD.setContentDisplay(ContentDisplay.TOP);
        buttonD.setFont(Font.font(null, FontWeight.BOLD, 18));

        //Create a label which displays the players score.
        score = new Label();
        score.setFont(Font.font(null, FontWeight.BOLD, 24));
        score.setLayoutX(980);
        score.setLayoutY(30);
        score.setText("Score \n" + player1.getName() + ":  " + String.valueOf(player1.getScore()) );

        //Event action for buttons
        buttonD.setOnAction(e -> {
            player1.rollDiceAndMove();
            player2.rollDiceAndMove();
            player3.rollDiceAndMove();
            player4.rollDiceAndMove();
            gb.movePlayer(player1.getPreviousSquare(), player1.getCurrentSquare());
            gb.moveAIOne(player2.getPreviousSquare(), player2.getCurrentSquare());
            gb.moveAITwo(player3.getPreviousSquare(), player3.getCurrentSquare());
            gb.moveAIThree(player4.getPreviousSquare(), player4.getCurrentSquare());
            openWindow(questionCounter,primaryStage);
            npcScore();
            score.setText("Score \n" +
                    player1.getName() + ":  " + String.valueOf(player1.getScore()) + "\n" +
                    player2.getName() + ":  " + String.valueOf(player2.getScore()) + "\n" +
                    player3.getName() + ":  " + String.valueOf(player3.getScore()) + "\n" +
                    player4.getName() + ":  " + String.valueOf(player4.getScore()));
        });

        //Initialize canvas with piece
        gb.setCanvas(canvas);
        gb.start(window);
        canvas = gb.getCanvas();
        gb.movePlayer(player1.getPreviousSquare(), player1.getCurrentSquare());

        //Update the NPC:s pieces position so that they start on the right block.
        player2.setPositionNPC(7);
        player3.setPositionNPC(13);
        player4.setPositionNPC(19);

        //Set layout and add the components.
        Group layout2 = new Group();
        layout2.getChildren().add(canvas);
        layout2.getChildren().add(buttonD);
        layout2.getChildren().add(score);

        //Display the scenes
        theGame = new Scene(layout2);
        window.show();
    }

    /**
     * This method opens a new question window to the player.
     * @param i
     * @param primaryStage
     */
    private void openWindow(int i, Stage primaryStage) {

        if (player1.isFinished()) {
            gb.gameOver(player1);
        }

        else if(player2.isFinished()) {
            gb.gameOver(player2);
        }

        else if(player3.isFinished()) {
            gb.gameOver(player3);
        }

        else if(player4.isFinished()) {
            gb.gameOver(player4);
        }

        else if (i >= questions.size()) {
            gb.gameOver();
        }

        else {
            qWindow = new Stage();
            qWindow.initModality(Modality.APPLICATION_MODAL);
            currentQuestion = questions.get(i);
            qWindow.setTitle(currentQuestion.showCategory());
            answerAlternatives = currentQuestion.showAnswerAlternatives();

            // Sets the answer options with the answer alternatives from the question. Only one can be chosen.
            final ToggleGroup group = new ToggleGroup();
            RadioButton alt1 = new RadioButton(answerAlternatives[0]);
            RadioButton alt2 = new RadioButton(answerAlternatives[1]);
            RadioButton alt3 = new RadioButton(answerAlternatives[2]);
            alt1.setToggleGroup(group);
            alt2.setToggleGroup(group);
            alt3.setToggleGroup(group);

            // When the answer buttonD is clicked this checks whether it was the correct answer.
            buttonA = new Button("This is my final answer!");
            buttonA.setOnAction(e -> handleAnswer(i, primaryStage, alt1, alt2, alt3));


            VBox layout = new VBox(20);
            layout.setPadding(new Insets(50, 50, 50, 50));
            Label label = new Label(currentQuestion.showQuestion());
            layout.getChildren().add(label);
            layout.getChildren().addAll(alt1, alt2, alt3);
            layout.getChildren().add(buttonA);

            questionScene = new Scene(layout, 700, 350);
            qWindow.setScene(questionScene);

            qWindow.showAndWait();
        }
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
            player1.setScore();
        }
        else if (alt2.isSelected() && alt2.getText().equalsIgnoreCase(correctAnswer)) {
            player1.setScore();

        }
        else if (alt3.isSelected() && alt3.getText().equalsIgnoreCase(correctAnswer)) {
            player1.setScore();

        }

        qWindow.close();

        window.setScene(theGame);

    }

    /**
     * Here we write our questions for the game.
     */
    private void initialiseQuestions() {

        Question q1 = new Question("How many times did Jon Pall Sigmarsson win the 'World's Strongest Man' competition?", "4", "Pumping Iron", "1","4","5");
        Question q2 = new Question("How many times did Arnold win Mr Olympia?", "6", "Pumping Iron", "4", "5", "6");
        questions.add(q1);
        questions.add(q2);
        Collections.shuffle(questions);
    }

    /**
     * A method that sets the score of the NPC:s depending on if the answer right.
     * If the difficulty is higher than the NPC:s have a higher chance of answering right.
     */
    public void npcScore() {
        if (difficulty == 1 && player2.easyNPC()) {
            player2.setScore();
        }
        else if (difficulty == 1 && player3.easyNPC()) {
            player3.setScore();
        }
        else if (difficulty == 1 && player4.easyNPC()) {
            player4.setScore();
        }
        else if(difficulty == 2 && player2.mediumNPC()) {
            player2.setScore();
        }
        else if(difficulty == 2 && player3.mediumNPC()) {
            player3.setScore();
        }
        else if(difficulty == 2 && player4.mediumNPC()) {
            player4.setScore();
        }
        else if(difficulty == 3 && player2.hardNPC()) {
            player2.setScore();
        }
        else if(difficulty == 3 && player3.hardNPC()) {
            player3.setScore();
        }
        else if(difficulty == 3 && player4.hardNPC()) {
            player4.setScore();
        }
    }

    public static void main(String[]args) {
        launch(args);
    }
}

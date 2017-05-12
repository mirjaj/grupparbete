import  java.util.Random;
/**
 * The class Player represents a player in the trivia game.
 * It keeps track of the players score in the game and current position.
 * @version 2017-05-08.
 * @author Claudia Berlin
 */
public class Player  {
    private int score; //Players score
    private String name; //Name of the player
    private int currentSquare; //the square where the players piece is to be redrwan.
    private int previousSquare; //the square where the players piece was on the board.

    /**
     * Creates a player with a name of your choosing and starts with the score 0.
     * It also positions the players piece on square one.
     * @param playerName sets the name of the player.
     */
    public Player(String playerName) {
        score = 0; //initial score
        name = playerName; //The given name of the player
        previousSquare = 1;
        currentSquare = 1;
    }

    /**
     * Generates a random number between 1 and 6.
     * It also updates the players location on the board depending on the
     * number that was generated.
     * @return A random number from 1 to 6
     */
    public int rollDiceAndMove() {
        previousSquare = currentSquare;
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(6) + 1;
        int theSum = currentSquare + number;
        if(theSum > 24) {
            currentSquare = theSum%24;
        }
        else {
            currentSquare += number;
        }
        return number;
    }

    /**
     * Returns the players position on the board.
     * @return the current position of the players piece.
     */
    public int getCurrentSquare() {
        return currentSquare;
    }

    /**
     * Returns the players previous position on the board.
     * @return the previous position of the players piece.
     */
    public int getPreviousSquare() {
        return previousSquare;
    }

    /**
     * Returns the players name.
     * @return Players name.
     */
    public String getName() {
        return name;
    }

    /**
     * Rreturns the players current score.
     * @return Return players score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Increment the players score by 5.
     */
    public void setScore() {
            score += 5;
        }

    /**
     * Checks if the player has reached maximum score.
     * @return True if player has reached the score 20 or higher.
     */
    public boolean isFinished() {
        return score >=20;
     }
    }

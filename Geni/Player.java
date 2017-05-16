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
    private int currentSquare; //The current position of the players piece.
    private int previousSquare; //The previous position of the players piece.

    /**
     * Creates a player with a name of your choosing and starts with the score 0.
     * It also positions the players piece on square one.
     */
    public Player() {
        score = 0; //initial score.
        name = "Player"; //The default name of the player.
        previousSquare = 1;
        currentSquare = 1; //Initial position of the players piece.
    }

    public Player(String playerName) {
        score = 0; //initial score.
        name = playerName;
        previousSquare = 1;
        currentSquare = 1; //Initial position of the players piece.
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
    /*
     * Sets the currentSquare to be a pre-specified square
     */
    public void setCurrentSquare(int square){
        currentSquare = square;
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
     * Change the default name of the player.
     * @param playerName Choose a name to the player.
     */
    public void setName(String playerName){
        name = playerName;
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
     * Increment the players score by a chosen number.
     */
    public void setScore(int number) {
        score += number;
    }

    /**
     * Checks if the player has reached maximum score.
     * @return True if player has reached the score 20 or higher.
     */
    public boolean isFinished() {
        return score >=50;
    }

    /**
     * Represents an NPC that has a low chance of giving the right answer in the trivia game.
     * @return True if the random number generator returns the number 2.
     */
    public boolean easyNPC() {
        Random random = new Random();
        int number = random.nextInt(5);
        return number == 2;
    }

    /**
     * Represents an NPC that has a better chance of giving the right answer, compared to the easy NPC, in the trivia game.
     * @return True if the random number generator returns the number 3 or 4.
     */
    public boolean mediumNPC() {
        Random random = new Random();
        int number = random.nextInt(5);
        return number >= 3;
    }

    /**
     * Represents an NPC that has a high chance of giving the right answer in the trivia game.
     * @return True if the random number generator returns the number 2, 3 or 4.
     */
    public boolean hardNPC() {
        Random random = new Random();
        int number = random.nextInt(5);
        return number >= 2;
    }
}
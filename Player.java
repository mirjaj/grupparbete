import  java.util.Random;
/**
 * The class Player represents a player in the trivia game.
 * It keeps track of the players score in the game, among other things.
 * @version 2017-05-06
 * @author Claudia Berlin
 */
public class Player  {
    private int score; //Players score
    private String name; //Name of the player

    /**
     * Creates a player with a name of your choosing and starts with the score 0.
     * @param playerName sets the name of the player.
     */
    public Player(String playerName) {
        score = 0; //current score
        name = playerName;

    }

    /**
     * Generates a random number between 1 and 6.
     * @return A random number from 1 to 6
     */
    public int rollDice() {
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(6) + 1;
        return number;
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
     * Increment the players score by 5 if the player gives the right answer.
     */

    public void setScore() {
    if(rightAnswer) { //If your answer to the question is correct (have method in Question class that checks if correct).
           score += 5;
       }
    }

    public static void main(String[] args) {

    }
}

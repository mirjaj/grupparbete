/**
 * Temporary class. I needed a player to work on my question logic.
 * @Author: Mirja Johnsson
 */
public class Player {

    private int points;


    public Player() {
        points = 0;
    }


    public boolean isFinished() {
        return points >= 10;
    }

    public void increasePoints() {
        points+=5;
    }
}

import java.util.ArrayList;
/**
 * @Author: Mirja Johnsson
 */
public class Player {

    private ArrayList<Boolean> answers;
    public boolean finished;

    public Player() {
        answers = new ArrayList<>(7);
        finished = false;
    }


    public boolean isFinished() {
        return finished;
    }
}

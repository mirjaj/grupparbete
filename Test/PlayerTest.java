import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test for the Player class.
 * @author Claudia Berlin
 * @version 2017-05-14.
 */
class PlayerTest {
    private Player player = new Player("Player");

    /**
     * Tests if the getCurrentSquare method.
     */
    @Test
    void getCurrentSquare() {
        assertEquals(1, player.getCurrentSquare());
    }

    /**
     * Tests if the getPreviousSquare method.
     */
    @Test
    void getPreviousSquare() {
        assertEquals(1, player.getPreviousSquare());
    }

    /**
     * Tests the getName method.
     */
    @Test
    void getName() {
        assertEquals("Player", player.getName());
    }

    /**
     * Tests the setName method.
     */
    @Test
    void setName() {
        player.setName("Jack");
        assertEquals("Jack", player.getName());
    }

    /**
     * Tests if the getScore method and setScore method works.
     */
    @Test
    void getScore() {
        assertEquals(0, player.getScore());
        player.setScore();
        assertEquals(5, player.getScore());
    }

    /**
     * Tests the isFinished method.
     */
    @Test
    void isFinished() {
      assertFalse(player.isFinished());
      player.setScore();
      player.setScore();
      player.setScore();
      player.setScore();
      assertTrue(player.isFinished());
    }
}

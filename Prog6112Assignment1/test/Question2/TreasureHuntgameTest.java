/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Question2;


import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author musankosi
 */
public class TreasureHuntgameTest {
    
   private TreasureHunt game;

   
    public void setUp() {
        game = new TreasureHunt(5, 5, 20);
    }

    @Test
    public void testInitialPlayerPosition() {
        assertEquals(0, game.getPlayerRow());
        assertEquals(0, game.getPlayerCol());
    }

    @Test
    public void testTreasurePlacement() throws NoSuchFieldException, IllegalAccessException {
        Field treasureRowField = TreasureHunt.class.getDeclaredField("treasureRow");
        treasureRowField.setAccessible(true);
        int treasureRow = (int) treasureRowField.get(game);

        Field treasureColField = TreasureHunt.class.getDeclaredField("treasureCol");
        treasureColField.setAccessible(true);
        int treasureCol = (int) treasureColField.get(game);

        assertTrue(treasureRow >= 0 && treasureRow < 5);
        assertTrue(treasureCol >= 0 && treasureCol < 5);
    }

    @Test
    public void testPlayerMovement() {
        game.makeMove('d');
        assertEquals(0, game.getPlayerRow());
        assertEquals(1, game.getPlayerCol());

        game.makeMove('s');
        assertEquals(1, game.getPlayerRow());
        assertEquals(1, game.getPlayerCol());

        game.makeMove('a');
        assertEquals(1, game.getPlayerRow());
        assertEquals(0, game.getPlayerCol());

        game.makeMove('w');
        assertEquals(0, game.getPlayerRow());
        assertEquals(0, game.getPlayerCol());
    }

    @Test
    public void testMoveOutOfBounds() {
        for (int i = 0; i < 5; i++) {
            game.makeMove('s'); // Move down
        }
        assertEquals(4, game.getPlayerRow()); // Player should be at the bottom row
        assertTrue(game.makeMove('s') == false); // Move down should be invalid now
    }

    @Test
    public void testMoveInvalidInput() {
        assertFalse(game.makeMove('x')); // Invalid move should return false
    }

    @Test
    public void testFindTreasure() {
        // To test finding treasure, we need to set a specific treasure location
        try {
            Field treasureRowField = TreasureHunt.class.getDeclaredField("treasureRow");
            treasureRowField.setAccessible(true);
            treasureRowField.set(game, 0);

            Field treasureColField = TreasureHunt.class.getDeclaredField("treasureCol");
            treasureColField.setAccessible(true);
            treasureColField.set(game, 1);

            Field playerRowField = TreasureHunt.class.getDeclaredField("playerRow");
            playerRowField.setAccessible(true);
            playerRowField.set(game, 0);

            Field playerColField = TreasureHunt.class.getDeclaredField("playerCol");
            playerColField.setAccessible(true);
            playerColField.set(game, 1);

            assertTrue(game.getPlayerRow() == game.getTreasureRow() && game.getPlayerCol() == game.getTreasureCol());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Error occurred while testing treasure finding.");
        }
    }
}
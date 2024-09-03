/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Question2;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author musankosi
 */
public class TreasureHuntgame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Creates an instance of TreasureHunt with a 5x5 grid and 20 moves allowed
        TreasureHunt game = new TreasureHunt(5, 5, 20); // 5x5 grid, 10 moves allowed
        game.start(); //Starts the game
    }
    
}
    
   // Base class representing the game grid
class Grid {
    private int rows;//Number of rows in the grid
    private int columns;//Number of columns in the grid
    protected char[][] grid;//2D array to represent the grid

    //Constructor to initialize the grid with specified rows and columns.
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
        initializeGrid();//Initialize the grid with default values
    }
//Method to initialize the grid with '-' to represent empty spaces.
    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = '-';//Fill the grid with dashes
            }
        }
    }

    //Method to display the grid to the player.
    public void displayGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");//Print each cell in the grid
            }
            System.out.println();//Move to the next line after each row
        }
    }
}

// Derived class that manages the treasure hunt game logic
class TreasureHunt extends Grid {
    private int playerRow;//Player's current row position
    private int playerCol;//Player's current column position
    private int treasureRow;//Row position of the treasure
    private int treasureCol;//Column position of the treasure
    private int movesLeft;//Number of moves left for the player
    
//Constructor to initialize the treasure hunt game.
    public TreasureHunt(int rows, int columns, int maxMoves) {
        super(rows, columns);// Call the constructor of the base class (Grid)
        this.movesLeft = maxMoves;//Set the maximum number of moves
        placeTreasure();//Randomly place the treasure on the grid
        placePlayer();// Place the player at the starting position
    }

    // Method to randomly place the treasure on the grid.
    private void placeTreasure() {
        Random rand = new Random();
        treasureRow = rand.nextInt(super.grid.length);// Random row for treasure
        treasureCol = rand.nextInt(super.grid[0].length);// Random column for treasure
    }

    //Method to place the player at the starting position (top-left corner).
    private void placePlayer() {
        playerRow = 0;
        playerCol = 0;
        super.grid[playerRow][playerCol] = 'P';// Mark player's position with 'P'
    }

    //Method to start the treasure hunt game.
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (movesLeft > 0) {//Method to start the treasure hunt game.
            displayGrid();// Display the current state of the grid
            System.out.println("Moves left: " + movesLeft);
            System.out.print("Move (w=up, s=down, a=left, d=right): ");
            char move = scanner.next().charAt(0);// Capture the player's move
            if (makeMove(move)) {// Attempt to make the move
                
                 // Check if the player has found the treasure
                if (playerRow == treasureRow && playerCol == treasureCol) {
                    System.out.println("Congratulations! You've found the treasure!");
                    return;// End the game if treasure is found
                }
                movesLeft--;// Reduce the number of moves left
            } else {
                System.out.println("Invalid move!");
            }
        }
        System.out.println("Game Over! You've run out of moves.");
    }

    //Method to move the player on the grid.
    boolean makeMove(char move) {
        super.grid[playerRow][playerCol] = '-';
        switch (move) {
            case 'w':
                if (playerRow > 0) playerRow--;
                break;
            case 's':
                if (playerRow < super.grid.length - 1) playerRow++;
                break;
            case 'a':
                if (playerCol > 0) playerCol--;
                break;
            case 'd':
                if (playerCol < super.grid[0].length - 1) playerCol++;
                break;
            default:
                return false;// Return false if the move is invalid
        }
        super.grid[playerRow][playerCol] = 'P';// Mark the new position with 'P'
        return true;// Return true if the move is successful
    }
    //methods to retrieve the player's and treasure's positions 
    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public int getTreasureRow() {
        return treasureRow;
    }

    public int getTreasureCol() {
        return treasureCol;
    }
} 


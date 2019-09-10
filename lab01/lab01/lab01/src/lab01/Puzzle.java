/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;
import java.util.*;

/**
 * The class describe a n-puzzle. The class has methods for showing the puzzle
 * mixing the tiles of the puzzle and move a tile.
 * 
 * @author Phillip Hölscher
 */
public class Puzzle {
    private int rowAndColumnSize = 4;
    private int[][] board;
    private Scanner keyboard = new Scanner(System.in);
    private int spaceRow = 0, spaceColumn = 0;
    private Random randomGenerator = new Random();
    
    
    /**
     * The constructor initiate a puzzle that has number number of tiles.
     * The number of tiles must be 3, 8 or 15. If any other value is given
     * the number of tiles will be set to 8.
     * 
     * @param numberOfTiles the number of tiles that the puzzle shall have
     */
    public Puzzle(int numberOfTiles){
        if (numberOfTiles == 3)
            rowAndColumnSize = 2;
        else if (numberOfTiles == 15)
            rowAndColumnSize = 4;
        else
            rowAndColumnSize = 3;
        
        board = new int[rowAndColumnSize][];
        
        for(int i=0; i<rowAndColumnSize; i++)
            board[i] = new int[rowAndColumnSize];
        
        int tileNumber = 1;
        for (int i=0; i<rowAndColumnSize; i++)
            for(int j=0; j<rowAndColumnSize; j++)
                board[i][j] = tileNumber++;
        
        spaceRow = rowAndColumnSize - 1;
        spaceColumn = rowAndColumnSize - 1;
        board[spaceRow][spaceColumn] = 0;
    }
    
    /**
     * The method print out the board of tiles
     */
    public void show(){
        for (int i=0; i<rowAndColumnSize; i++)
        {
            for(int j=0; j<rowAndColumnSize; j++){
                if (board[i][j] == 0)
                    System.out.print("  _");
                else if (board[i][j] <= 9)
                    System.out.print("  " + board[i][j]);
                else
                    System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * The method makes it possible for a person to move around tiles
     */
    public void solveByHuman() {
        String prompt = "Move the space, 0 left, 1 up, 2 right, 3 down, 10 quit: ";
        System.out.print(prompt);
        int direction = keyboard.nextInt();
        
        while (direction != 10){
            moveSpace(direction);
            show();
            System.out.print(prompt);
            direction = keyboard.nextInt();            
        } 
    }

    /**
     * The method move the space on step in the direction that is sent to the
     * method. The parameter direction can have for different values;
     * 0 moves the space one step left if it is possible.
     * 1 moves the space one step up if it is possible.
     * 2 moves the space one step right if it is possible.
     * 3 moves the space one step down if it is possible.
     * A number outside the interval [0,3] will not move the space.
     * 
     * @param direction the direction to move 
     */
    private void moveSpace(int direction){
    	
    	int number;
    	Scanner keyboard = new Scanner(System.in);
    	number = keyboard.nextLine();
    	switch (number){
    	case 0:
    		System.out.println("move the space to the left if it´s possible");
    		break;
    	case 1:
    		System.out.println("move the space to the up if it´s possible");
    		break;
    	case 2:
    		System.out.println("move the space to the right if it´s possible");
    		break;
    	case 3:
    		System.out.println("move the space to the down if it´s possible");
    		break;
    	default:
            System.out.println("The command number " + command + " is unknown.");
    	}
         return number
    }

    /**
     * The method swap the value of board[i][j] with the value of board[k][l].
     * 
     * @param i row index for one element of the board.
     * @param j column index for one element of the board.
     * @param k row index for another element of the board.
     * @param l column index for another element of the board.
     */
    private void swap(int i, int j, int k, int l) {
        int number = board[i][j];
        board[i][j] = board[k][l];
        board[k][l] = number;
    }
}

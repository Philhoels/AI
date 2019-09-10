/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;
import java.util.*;

/**
 * The class describe a n-puzzle. The class has methods for showing the puzzle
 * mixing the tiles of the puzzle and move a tile. The class implements the
 * methods that are declared in the interface ITraverse
 * @author Please, enter your name instead of this sentence if you do any changes.
 */
public class Puzzle extends State {
    private int rowAndColumnSize = 4;
    private final int[][] board;
    private final Scanner keyboard = new Scanner(System.in);
    private int spaceRow = 0, spaceColumn = 0;
    private final Random randomGenerator = new Random();
    
    
    /**
     * The constructor initiate a puzzle that has number of tiles.
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
     * The constructor initiate a puzzle with the content that are read in
     * via the scanner.
     * @param scanner The scanner has to be connected to source that contains
     * the state of a puzzle.
     */
    public Puzzle(Scanner scanner) {                    
        int numberOfTiles = scanner.nextInt();

        if (numberOfTiles == 3)
            rowAndColumnSize = 2;
        else if (numberOfTiles == 15)
            rowAndColumnSize = 4;
        else
            rowAndColumnSize = 3;

        board = new int[rowAndColumnSize][];

        for(int i=0; i<rowAndColumnSize; i++)
            board[i] = new int[rowAndColumnSize];

        for (int i=0; i<rowAndColumnSize; i++) {
            for(int j=0; j<rowAndColumnSize; j++){
                int tileNumber = scanner.nextInt();
                board[i][j] = tileNumber;

                if (tileNumber == 0){
                    spaceRow = i;
                    spaceColumn = j;
                }
            }
        }
    }

    /**
     * The constructor initiate a puzzle to be a copy of the original.
     * @param original The original to the new puzzle. 
     */
    private Puzzle(Puzzle original) {
        this.rowAndColumnSize = original.rowAndColumnSize;
        
        board = new int[rowAndColumnSize][];
        
        for(int i=0; i<rowAndColumnSize; i++)
            board[i] = new int[rowAndColumnSize];
        
        for (int i=0; i<rowAndColumnSize; i++)
            for(int j=0; j<rowAndColumnSize; j++)
                board[i][j] = original.board[i][j];
        
        spaceRow = original.spaceRow;
        spaceColumn = original.spaceColumn;
        parent = original.parent;
        depth = original.depth;
    }
    
   /**
     * The method return true if two puzzle object have equal boards, otherwise false.
     * @param anObject The object that this object shall be compered with
     * @return true if this object is equal to anObject, otherwise false.
     */
    @Override
    public boolean equals(Object anObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is needed if you use a HashTable
     * @return The hash code for this puzzle.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }
    
    /**
     * The method print out the board of tiles
     */
    @Override
    public void show(){
        System.out.println("Depth = " + depth + " Heuristic value = " + heuristicValue);
        
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
     * 
     * @param direction the direction to move 
     */
    private void moveSpace(int direction){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    /**
     * The method shuffle the tiles of the puzzle.
     */
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }

   /**
     * The method create the children and return the references to them in a
     * array with 4 element. Some of the elements can have the value null if
     * it not was possible to create all children. 
     * @return An array with children, some of the elements can be null. 
     */
    @Override
    public IState[] createChildren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }

    /**
     * The method check if it is possible to move the space in a direction.
     * @param direction The direction to move the space.
     * @return true if it possible to move the space, otherwise false.
     */
    private boolean isSpacePossibleToMove(int direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }
    
    /**
     * calculate a heuristic value and assign it to this object.
     * @param goal The goal state that is searched.
     */
    @Override
    public void calculateHeuristicValue(IState goal){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.     
    }
}

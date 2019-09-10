/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;
import java.util.*;

/**
 * The class is a menu-system. To run the system call the method run.
 * 
 * @author Please, enter your name instead of this sentence!
 */
public class Menu {
    private Scanner keyboard = new Scanner(System.in);
    private Puzzle puzzle = null;

    /**
     * The method print out the command that is available. The user can choose
     * among the commands. A selected command will be executed.
     */
    public void run(){
        int command = 0;
        
        do {
            command = chooseCommand();
            
            switch(command){
                case 10:
                    System.out.println("Bye!");
                    break;
                case 1:
                    System.out.print("The size of the puzzle, 3, 8 or 15 tiles? ");
                    int size = keyboard.nextInt();
                    puzzle = new Puzzle(size);
                    puzzle.show();
                    break;
                case 2:
                    if (puzzle == null)
                        break;
                    puzzle.show();
                    puzzle.solveByHuman();
                    break;
                case 3:
                	System.out.println("Mix the puzzle.");
                default:
                    System.out.println("The command number " + command + " is unknown.");
            }
            
        } while (command != 10);
    }
    
    /**
     * The method print out available commands and return the number for the
     * command that is selected.
     * @return number for the selected command
     */
    private int chooseCommand() {
        System.out.println("");
        System.out.println("10. Quit the program");
        System.out.println("1. Create a new puzzle.");
        
        if (puzzle != null){
            System.out.println("2. Manually move the tiles");
            System.out.println("3. Mix the puzzle.");
        }
        
        System.out.print("Your choice: ");
        return keyboard.nextInt();
    }
}

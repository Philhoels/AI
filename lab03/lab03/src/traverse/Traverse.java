/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traverse;
import state.IState;

/**
 * This class is the base class to subclasses BestFirst, BredthFirst and DepthFirst.
 * The purpose of the class is to have the definition of members that shall
 * be visible in all the tree subclasses, in one place. The subclasses inherit
 * and can use everything that are visible and not private in this base class.
 * This class implements some of the methods that are declared in the interface
 * ITraverse. The methods that are not implemented in this class are implemented
 * in the subclasses to this class.
 * @author Please, enter your name instead of this sentence if you do any changes.
 */
public abstract class Traverse implements ITraverse {
    protected IState start, goal;
    protected int iteration = 0;
    protected boolean verbose = false;
    
    /**
     * The method return the number of iterations that has been done
     * to find the goal state.
     * @return the number of iterations
     */
    @Override
    public int getIterations() {
        return iteration;
    }
    
    /**
     * The method print out the content of the both list open and closed.
     * @param label A label that is printed out at the beginning of the first row
     * @param open A list with all the nodes that are discovered but not visited.
     * @param closed A list with all the nodes that are visited.
     * @param iteration The count of iterations, for each iteration a node was visited.
     */
    protected void showStatus(String label, Iterable<IState> open, Iterable<IState> closed, int iteration) {
        if (verbose){
            System.out.print(label + ", iteration: " + iteration);
            
            System.out.println(" *****************");

            System.out.println("OPEN NODES");
            open.forEach(savedState -> savedState.show());
            System.out.println();

            System.out.println("CLOSED NODES");
            closed.forEach(savedState -> savedState.show());
            System.out.println();

            System.out.println("----------------------------------------------");
        }
    } 
}

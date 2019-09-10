/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traverse;
import java.util.*;
import state.IState;

/**
 * The class search for a solution with help of an breadth first traversal.
 * The class inherit from the base class Traverse and implements some of the
 * methods that are declared in the interface ITraverse.
 * @author Please, enter your name instead of this sentence!
 */
public class BreadthFirst extends Traverse {
    /**
     * The constructor saves the start and goal states.
     * @param startState The start state from which the search of a solution begins.
     * @param goalState The goal state which the solver search for. 
     * @param verbose If true the content of open and closed is printed out.
     */
    public BreadthFirst(IState startState, IState goalState, boolean verbose) {
        start = startState;
        goal = goalState;
        this.verbose = verbose;
    }
    
    /**
     * This is an implementation of the breadth first algorithm that can be
     * find in the textbook chapter 3.
     * The method does a breath first traversal to find the goal state. If the
     * goal is found the trace from start down to the goal is returned. If the
     * goal is not found the method return null
     * @return the trace from start to goal or null if the goal is not found.
     */
    @Override
    public IState search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

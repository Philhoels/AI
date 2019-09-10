/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 * This interface is the facade to the package state. Use the interface to
 * access methods needed for the menu and the solver.
 * @author Please, enter your name instead of this sentence if you do any changes.
 */
public interface IState {
    /**
     * The method shall print out the state of the node.
     */
    void show();
    
    /**
     * The method shall create the children of a node and return the
     * references to them in a array with 4 element. Some of the elements
     * can have the value null if it not was possible to create all children.
     * @return An array with children, some of the elements can be null.
     */
    IState[] createChildren();
    
    /**
     * Any children will not be created if the parents depth is equal to
     * depthBound
     * @param depthBound Maximal depth for any state.
     * @return the created children
     */
    IState[] createChildren(int depthBound);
    
    /**
     * The method shall return the depth of the node.
     * @return Current depth.
     */
    IState getParent();
}

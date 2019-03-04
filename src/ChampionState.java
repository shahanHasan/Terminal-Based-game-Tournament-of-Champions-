package toc;

import java.io.*;
/**
 * Enumeration class ChampionState 
 * Specifies all possible states of a champion
 * 
 * @author A.Marczyk
 * @version 12/09/2018
 */
public enum ChampionState implements Serializable
{

    /**
     * champion currrent state  
     */
    WAITING(" In reserve"),

    /**
     * champion current state
     */
    ENTERED(" Entered"),

    /**
     * champion current state
     */
    DEAD (" Dead");
    private String state;
    /**
     * 
     * Constructor 
     */
    private ChampionState(String st)
    {
        state = st;
    }
    /**
     * String representation of the class
     * 
     * @param no parameter
     * @return String 
     */
    public String toString()
    {
        return state;
    }
}

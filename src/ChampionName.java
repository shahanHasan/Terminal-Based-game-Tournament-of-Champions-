/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package toc;
import java.io.* ;
/**
 *
 *@author Md Mohidul Hasan
 *@version 01.12.2018
 */

public enum ChampionName implements Serializable
{
    
    /**
     * Champion Name    
     */
    MIMSI("Mimsi"),
    /**
     * Champion Name    
     */
    FRODER("Froder"),
    /**
     * Champion Name    
     */
    GANFRANK("Ganfrank"),

    /**
     * Champion Name
     */
    RUDOLF("Rudolf"),

    /**
     * Champion Name
     */
    ELBLOND("Elblond"),

    /**
     * Champion Name
     */
    FLIMSI("Flimsi"),

    /**
     * Champion Name
     */
    DRABINA("Drabina"),

    /**
     * Champion Name
     */
    GOLUM("Golum"),

    /**
     * Champion Name
     */
    ARGON("Argon"),

    /**
     * Champion Name
     */
    NEON("Neon"),

    /**
     * Champion Name
     */
    XENON("Xenon");
    private String ChampionName;
    /**
     * 
     * Constructor 
     */

    ChampionName (String fn)
    {
            this.ChampionName = fn;
    }

    /**
     * String representation of the class
     * 
     * @param no parameter
     * @return String
     */
    public String toString() 
    {
        return this.ChampionName;
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toc;
import java.io.*;

/**
 *
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */

public enum ChampionReference implements Serializable
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
     * Champion name
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
 
    private String reference;
    /**
     * Constructor 
     */
    private ChampionReference (String reference){
            this.reference = reference;
    }

    @Override
    /**
     * String representation of the class 
     * 
     * @param no parameter 
     * @return return String 
     * 
     */
    public String toString() {
        return reference;
    }
}

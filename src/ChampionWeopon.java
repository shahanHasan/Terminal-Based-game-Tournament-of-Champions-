
package toc;
import java.io.*;
/**
 * Enumeration class ChampionWeopon - 
 * specifies all possible types of Champion Weopon
 * 
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public enum ChampionWeopon implements Serializable
{

    /**
     * champion weapon name
     */
    SWORD(" Sword"),

    /**
     * champion weapon name
     */
    BOW(" Bow"),

    /**
     * champion weapon name
     */
    MACE(" Mace");
    private String weopon;
    /**
     * 
     * constructor  
     */
    private ChampionWeopon(String wp)
    {
        weopon = wp;
    }
    /**
     * String representation of the class
     * 
     * @param no parameter
     * @return String 
     */
    public String toString()
    {
        return weopon;
    }
}

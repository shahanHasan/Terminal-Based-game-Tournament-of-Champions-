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
public enum ChampionType implements Serializable
{

    /**
     * champion type 
     */
    WARRIOR("Warrior"),

    /**
     * champion type
     */
    WIZARD("Wizard"),

    /**
     * champion type
     */
    DRAGON("Dragon");
    
    private String type;
    /**
     * 
     * Constructor 
     */
    private ChampionType(String t)//
    {
    this.type = t;
    }
    /**
     * String representation of the class
     * 
     * @param no parameter
     * @return String 
     */
    @Override
    public String toString() 
    {
        return type;
    }
}

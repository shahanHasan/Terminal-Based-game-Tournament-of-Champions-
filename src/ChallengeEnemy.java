/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.io.*;

/**
 *Names of enemy challenges
 * 
 *@author Md Mohidul Hasan
 *@version 01.12.2018
 */
public enum ChallengeEnemy implements Serializable 
{
    /**
     * enemy name
     */
    VIKINGS(" Vikings"),
    /**
     * enemy name
     */
    BORG(" Borg"),

    /**
     * enemy name
     */
    CARDASSIANS(" Cardashian"),

    /**
     * enemy name
     */
    FERENGI("Ferengi"),

    /**
     * enemy name
     */
    HUNS(" Huns"),

    /**
     * enemy name
     */
    VANDAL(" Vandal"),

    /**
     * enemy name
     */
    GOTH("Goth"),

    /**
     * enemy name
     */
    SITH(" Sith"),

    /**
     * enemy name
     */
    FRANK("Frank");
    
    private String enemyName;
    /**
    * Constructor
    */
    private ChallengeEnemy(String e)
    {
        this.enemyName= e;
    }
    /**
    * returns a string representation of the class
    */
    @Override
    
    public String toString() 
    {
        return enemyName ;
    }
}

package toc;

import java.io.*;
/**
 * Enumeration class ChallengeType - write a description of the enum class here
 * 
 * @author Md Mohidul Hasan
 * @version 01.12.2018
 */
public enum ChallengeType implements Serializable
{

    /**
     * type of challenge        
     */
    MAGIC(" Magic"),

    /**
     * type of challenge           
     */
    FIGHT("Fight"),

    /**
     * type of challenge
     */
    MYSTERY ("Mystery");
    private String type;
    /**
     * 
     * Constructor 
     */
    private ChallengeType(String ty)
    {
        type = ty;
    }
    /**
     * returns a string representation of the class
     * 
     * @return String representation of the class
     * @param no parameter 
     * 
     */
    public String toString()
    {
        return type;
    }
}

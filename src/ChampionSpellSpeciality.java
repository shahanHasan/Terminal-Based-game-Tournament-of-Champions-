
package toc;
import java.io.*;
/**
 * Enumeration class ChampionSpellSpeciality - 
 * specifies all possible speciality of champion spells
 * 
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public enum ChampionSpellSpeciality implements Serializable
{

    /**
     * champions spell speciality
     */
    TRANSMUTAION(" Transmutaion"),

    /**
     * champions spell speciality
     */
    INVISIBILITY(" Invisibility"),

    /**
     * champions spell speciality
     */
    TRANSLOCATION(" Translocation");
    private String SpellSpeciality;
    /**
     * 
     * Constructor 
     */
    private  ChampionSpellSpeciality (String spellS)
    {
        SpellSpeciality = spellS;
    }
    /**
     * String representation
     * 
     * @return String
     * @param no parameter
     */
    public String toString()
    {
        return SpellSpeciality;
    }
}

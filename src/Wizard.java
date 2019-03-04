package toc;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
/**
 * type of champion class
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public class Wizard extends Champion implements Serializable
{
    private ChampionSpellSpeciality SpellS ;
    private boolean isMagic, isFight, isMystery , necromencer;
    private int skillLevel, entryFee;
    private String ChampionName,status ,reference;
    private Map<String,String> weapon = new HashMap<String, String>();
    
    /**
     *
     * @param reference
     * @param ChampionName
     * @param skillLevel
     * @param entryFee
     * @param isMa
     * @param isF
     * @param isMy
     * @param SpellS
     * @param necromencer
     */
    public Wizard(String reference,String ChampionName,int skillLevel,int entryFee,boolean isMa,boolean isF,boolean isMy,ChampionSpellSpeciality SpellS,boolean necromencer)
    {
    super(reference,ChampionName,skillLevel,entryFee,isMa,isF,isMy);
    this.reference = reference ;
    this.ChampionName = ChampionName;
    this.entryFee = entryFee;
    this.skillLevel = skillLevel ;
    this.isMagic = isMa;
    this.isFight = isF;
    this.isMystery = isMy ;
    this.necromencer=necromencer;
    this.SpellS=SpellS ;
        
    this.status = ChampionState.WAITING.toString();
    }

    /**
     *
     * @return boolean if it is necro or not
     */
    public boolean isNecro()
    {
        return necromencer ;
    }

    /**
     *
     */
    public void setNecro()
    {
        this.necromencer=necromencer ;
    }
    
    /**
     *
     * @return return whether is magic or not
     */
    public boolean isISMagic() 
    {
        return isMagic;
    }

    /**
     *
     * @param isMagic
     */
    public void setisISMagic(boolean isMagic) 
    {
        this.isMagic = isMagic;
    }

    /**
     *
     * @return return whether is fight or not
     */
    public boolean isISFight() 
    {
        return isFight;
    }

    /**
     *
     * @param isFight
     */
    public void isISFight(boolean isFight) {
        this.isFight = isFight;
    }

    /**
     *
     * @return return whether is mystery or not
     */
    public boolean isISMystery() {
        return isMystery;
    }

    /**
     *
     * @param isMystery
     */
    public void isISMystery(boolean isMystery) {
        this.isMystery = isMystery;
    }

    /**
     *
     * @return return skill level
     */
    public int getskillLevel() {
        return skillLevel;
    }

    /**
     *
     * @param strength
     */
    public void setskillLevel(int strength) {
        this.skillLevel = skillLevel;
    }

    /**
     *
     * @return returns entry fee
     */
    public int getentryFee() {
        return entryFee;
    }

    /**
     *
     * @param entryFee
     */
    public void setentryFee(int entryFee)
    {
        if(this.necromencer)
        {
        this.entryFee = 400;
        }
        else
        {
        this.entryFee = 300 ;
        }
    }

    /**
     *
     * @return returns reference
     */
    public String getReference() {
        return reference;
    }

    /**
     *
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     *
     * @return returns champion name
     */
    public String getChampionName() {
        return ChampionName;
    }

    /**
     *
     * @param ChampionName
     */
    public void setChampionName(String ChampionName) {
        this.ChampionName = ChampionName;
    }

    /**
     *
     */
    public void setEntered()
    {
    this.status = ChampionState.ENTERED.toString();
    }

    /**
     *
     */
    public void setDead()
    {
    this.status = ChampionState.DEAD.toString();
    }

    /**
     *
     */
    public void setWaiting()
    {
    this.status = ChampionState.WAITING.toString();
    }
    
    /**
     *
     * @return returns status
     */
    public String getStatus()
    {
    return this.status ;
    }
    
    @Override
    Map<String, String> getWeapon() 
    {

        String toHash = String.valueOf(this.SpellS);
        String toHash1= String.valueOf(this.necromencer);
        weapon.put("Necromancer", toHash1);
        weapon.put("Spell Speciality ", toHash);
       
        return weapon; 
        
        
    }

    @Override
    boolean hasSpecial() 
    {
    return necromencer;
    }
    
    ChampionSpellSpeciality SpecialSpells()
    {
    return SpellS ;
    }
}

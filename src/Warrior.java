 package toc;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public class Warrior extends Champion implements Serializable
{
    private ChampionWeopon Weopon; 
    private boolean isMagic, isFight, isMystery , necromencer;
    private int skillLevel, entryFee;
    private String ChampionName,status , reference ;
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
     * @param Weopon
     */
    public Warrior(String reference,String ChampionName,int skillLevel,int entryFee,boolean isMa,boolean isF,boolean isMy,ChampionWeopon Weopon)
    {
    super(reference,ChampionName,skillLevel,entryFee,isMa,isF,isMy);
    this.reference = reference ;
    this.ChampionName = ChampionName;
    this.entryFee = entryFee;
    this.skillLevel = skillLevel ;
    this.isMagic = isMa;
    this.isFight = isF;
    this.isMystery = isMy ;
    
    this.Weopon= Weopon;
    
        
    this.status = ChampionState.WAITING.toString();
    }
    
    /**
     *
     * @param entryFee
     */
    public void setentryFee(int entryFee)
    {
        //this.entryFee = entryFee;
        if(weapon.equals(ChampionWeopon.BOW))
        {
        entryFee=200;
        }
        else if (weapon.equals(ChampionWeopon.SWORD))
        {
        entryFee=150 ;
        }
        else if(weapon.equals(ChampionWeopon.MACE))
        {
        entryFee=900; 
        }
    }

    /**
     *
     * @return entry fee
     */
    public int getentryFee()
    {
        return entryFee ; 
    }
    
    /**
     *
     * @return is magic
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
     * @return returns whether is fight or not
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
     * @return returns whether is mystery or not
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
     * @return returns skill level
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

        String toHash = String.valueOf(this.Weopon);
        weapon.put("Weapon ", toHash);
       
        return weapon; 
        
        
    }

    @Override
    boolean hasSpecial() 
    {
    return false;
    }  
    
}

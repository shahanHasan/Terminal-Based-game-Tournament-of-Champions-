/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.io.Serializable;
import java.util.Map;


/**
 *@author Md Mohidul Hasan
 *@version 01.12.2018
 */
public abstract class Champion implements Serializable
{
   private boolean isMagic,isFight,isMystery ;
   //private String nme;
   private int skillLevel,entryFee ;
   private String ChampionName, status ,reference ;
    
    /**
     *
     * @param reference ref       
     * @param ChampionName  champ name 
     * @param skillLevel  skill level  
     * @param entryFee  entry fee
     * @param isMa  is magic    
     * @param isF is fight
     * @param isMy is mystery
     */
    public Champion(String reference,String ChampionName,int skillLevel,int entryFee,boolean isMa,boolean isF,boolean isMy)
    {
       
     this.reference = reference ;
     this.ChampionName = ChampionName;
     this.entryFee = entryFee;
     this.skillLevel = skillLevel ;
     this.isMagic = isMa;
     this.isFight = isF;
     this.isMystery = isMy ;
    
     
    }

    /**
     *
     * @return return boolean true or false for magic
     */
    public boolean isISMagic() 
    {
        return isMagic;
    }

    /**
     *
     * @param isMagic is magic  
     */
    public void setisISMagic(boolean isMagic) 
    {
        this.isMagic = isMagic;
    }

    /**
     *
     * @return return boolean is fight
     */
    public boolean isISFight() 
    {
        return isFight;
    }

    /**
     *
     * @param isFight input is fight
     */
    public void isISFight(boolean isFight) {
        this.isFight = isFight;
    }

    /**
     *
     * @return returns is my mystery
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
     * @return skill level
     */
    public int getskillLevel() {
        return skillLevel;
    }

    /**
     *
     * @param skillLevel
     */
    public void setskillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     *
     * @return
     * @param skillLevel
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
        this.entryFee = entryFee;
    }

    /**
     *
     * @return reference 
     */
    public String getReference() 
    {
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
     * List of abstract methods to be used by tournament class,Player Champion Team
     */
    abstract void setEntered();
    abstract void setDead();
    abstract void setWaiting();
    abstract boolean hasSpecial();
    abstract String getStatus();
    abstract Map<String , String> getWeapon();
   
}

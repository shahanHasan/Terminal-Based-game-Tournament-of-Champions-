/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
/**
 *
 * @author mh16adk
 */
public class Dwarf extends Champion implements Serializable
{
    private boolean isMagic, isFight, isMystery, chieftain;
    private int skillLevel, entryFee  ;
    private String ChampionName,status , reference, Homename ;
    
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
     * @param talks
     * @param Homename
     * @param chieftain
     */
    public Dwarf(String reference ,String ChampionName,int skillLevel,int entryFee,boolean isMa,boolean isF,boolean isMy,boolean chieftain,String Homename)
    {
    super(reference,ChampionName,skillLevel,entryFee,isMa,isF,isMy);
    this.reference = reference ;
    this.ChampionName = ChampionName;
    this.entryFee = entryFee;
    this.skillLevel = skillLevel ;
    this.isMagic = isMa;
    this.isFight = isF;
    this.isMystery = isMy ;
    this.chieftain=chieftain;
    this.Homename=Homename;
        
    this.status = ChampionState.WAITING.toString();
    }

    /**
     *
     * @return returns talking ability
     */
    public boolean ischieftain()
    {
        return chieftain ;
    }

    /**
     *
     */
    public void setchieftain()
    {
        this.chieftain=chieftain ;
    }
    
    /**
     *
     * @return whether it has magic ability
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
     * @return return if it can fight
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
     * @return returns if it is mystery 
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
     * @return returns dragon skill level
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
     * @return return entry fee
     */
    public int getentryFee() {
        return entryFee;
    }

    /**
     *
     * @param entryFee
     */
    public void setentryFee(int skillLevel) {
        this.entryFee = skillLevel*100 ;
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
     * @return returns Home name
     */
    public String getHomename() {
        return Homename;
    }

    /**
     *
     * @param Home name 
     */
    public void setHomename(String Homename) {
        this.Homename = Homename;
    }

    /**
     *
     * @return champion name
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

        String toHash = String.valueOf(chieftain);
        weapon.put("chief tain ", toHash);
       
        return weapon; 
        
        
    }

    @Override
    boolean hasSpecial() 
    {
    return chieftain;
    }
}

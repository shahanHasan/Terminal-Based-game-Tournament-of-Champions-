/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.util.* ;
import java.io.*;
/**
 *
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public class ChampionWaitingList implements MethodList,Serializable
{

    public Map<String , Champion> allWaitinglist = new HashMap<String , Champion>();//Collection of Champions in reserve
    private Map<String , String> allChampion = new HashMap<String,String>();//All champions listed 
    ChampionWaitingList(){} //Empty constructor
   
    /**
     *
     * @param reference
     * @return boolean
     */
    public boolean checkIfExist(String reference)
   { // True if reference/name of champion is inside Champion hashmap : allWaitinglist
   return true;
   }
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

    /**
     *
     * @param reference
     * @return champion
     */


   public Champion getObj(String reference){ 

       Champion found = null;
       
       if(allWaitinglist.containsKey(reference)){
           System.out.println("found");
           System.out.println(allWaitinglist.get(reference));
           return allWaitinglist.get(reference);}
       else
       {
       return null;
       }
   }
   
    /**
     *
     * @param reference
     * @return boolean
     */
    public boolean checkBool(String reference)
   {
   
   if(allWaitinglist.containsKey(reference))
   {
       return true;
   }
   else
   {
       return false;
   }
   
   }
   
    /**
     *
     * @param name
     * @param champion
     */
    public void addTo(String name, Champion champion)
   {
   
    
    allWaitinglist.put(name, champion);
    
    System.out.println("Champion " + name + " added to the Game.");
   }

    /**
     *
     * @param name
     * @param challenge
     * @return no return
     */
    @Override
    public void addChallenge(String name, Challenge challenge) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    /**
     *
     * @return String 
     */
    public String getAllItems()
    {
    StringBuilder sb = new StringBuilder();
    String line = "";
//    Iterator it = allWaitinglist.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
////        line = pair.getValue().toString();
//        
//        //Champion getC1 = (Champion)allWaitinglist.get("Wing");
//        //sb.append(getC1.getReference());
//        
//        it.remove(); // avoids a ConcurrentModificationException
//    }
    for(Champion c:allWaitinglist.values())
    {
        System.out.println(c.getChampionName());
       
        sb.append
        (
                "Champion Name: " + c.getReference()
                + " " 
                + "SkillLevel: " + c.getskillLevel() 
                + " " 
                + "Weapons " + c.getWeapon().toString() 
                + " " 
                + "State:" + c.getStatus() 
                + "\n"
        );

    }

    return sb.toString();
    
    }

    /**
     *
     * @param reference
     * @return string
     */
    @Override
    public String searchItem(String reference) {
        
        StringBuilder sa = new StringBuilder();
        
        
               if(allWaitinglist.containsKey(reference))
        {
        sa.append(allWaitinglist.get(reference).getChampionName());
        sa.append(allWaitinglist.get(reference).getReference());
        sa.append(allWaitinglist.get(reference).getentryFee());
        sa.append(allWaitinglist.get(reference).getWeapon().toString());
        sa.append(allWaitinglist.get(reference).getskillLevel());
        sa.append(allWaitinglist.get(reference).getStatus());
        
        }else{sa.append("No such Champion");}
        
        
     return sa.toString();
        
        
    }

    /**
     *
     * @param reference
     * @return object of type challenge
     */
    @Override
    public Challenge getChallengeObj(String reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param value
     * @return challenge type  
     */
    @Override
    public ChallengeType getType(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

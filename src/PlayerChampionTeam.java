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
public class PlayerChampionTeam implements MethodList,Serializable
{

    /**
     *
     */
    public Map<String, Champion> allEnteredChampion = new HashMap();

    /**
     *
     * @param reference
     * @return returns boolean value
     */
    public boolean checkIfExist(String reference)  // True if reference/Champion name = Champion 
   {
        return true;
   }
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

    /**
     *
     * @param reference
     * @return 
     */


   public Champion getObj(String reference)
   { 

       Champion found = null;
       
       if(allEnteredChampion.containsKey(reference))
       {
           System.out.println("found");
           System.out.println(allEnteredChampion.get(reference));
           return allEnteredChampion.get(reference);
       }
       else
       {
       return null;
       }
   }
   
    /**
     *
     * @param reference
     * @return boolean value
     */
    public boolean checkBool(String reference)
   {
   if(allEnteredChampion.containsKey(reference))
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
   
    allEnteredChampion.put(name, champion);
    System.out.println("Champion " + name + " added to the Game.");
    
    }

    /**
     *
     * @param name
     * @param challenge
     */
    @Override
    public void addChallenge(String name, Challenge challenge) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public String getAllItems() 
    {
        StringBuilder sa = new StringBuilder();
        
        for(Champion c:allEnteredChampion.values())
    {
        System.out.println(c.getReference());
       
        sa.append("Champion Name : " + c.getReference()
                + " " 
                + "Skill Level : " + c.getskillLevel() 
                + " " 
                + "Weapons : " + c.getWeapon().toString() 
                + " " 
                + "State : " + c.getStatus() 
                + "\n"
                );

    }
        
        
        return sa.toString();
        
    }

    /**
     *
     * @param reference
     * @return search item
     */
    @Override
    public String searchItem(String reference) 
    {
        StringBuilder sa = new StringBuilder();
        
        
        if(allEnteredChampion.containsKey(reference))
        {
            sa.append(allEnteredChampion.get(reference).getChampionName());
            sa.append(allEnteredChampion.get(reference).getReference());
            sa.append(allEnteredChampion.get(reference).getentryFee());
            sa.append(allEnteredChampion.get(reference).getWeapon().toString());
            sa.append(allEnteredChampion.get(reference).getskillLevel());
            sa.append(allEnteredChampion.get(reference).getStatus());
        
        }
        else
        {
            sa.append("No such Champion");
        }
        
        
     return sa.toString();


    }

    /**
     *
     * @param reference
     * @return 
     */
    @Override
    public Challenge getChallengeObj(String reference) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public ChallengeType getType(int value) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @param type
     * @return boolean value 
     */
    public boolean validateType(String type)
    {
    boolean forceFound = false;
        
        for(Champion champion : allEnteredChampion.values())
    {
            if(champion.isISMagic() && type.equals(ChallengeType.MAGIC.toString()))
        {
                forceFound = true;
        }
            else if(champion.isISFight()&& type.equals(ChallengeType.FIGHT.toString()))
        {
                forceFound = true;
        }
            else if(champion.isISMystery() && type.equals(ChallengeType.MYSTERY.toString()) && champion.getStatus().equals(ChampionState.ENTERED.toString()))
        {
                forceFound = true;
        }
    }
        return forceFound;
        
    }
    
    /**
     *
     * @param type
     * @return
     */
    public Champion validatedType(String type)
    {
    
        
    try
    {
    if(validateType(type))
    {
        
    for(Champion champion : allEnteredChampion.values())
    {
            if((champion.isISMagic() || champion.hasSpecial()) && (type.equals(ChallengeType.MAGIC.toString()) && champion.getStatus().equals(ChampionState.ENTERED.toString())))
        {
                return champion;
        }
            else if((champion.isISMystery() || champion.hasSpecial()) && type.equals(ChallengeType.MYSTERY.toString()) && champion.getStatus().equals(ChampionState.ENTERED.toString()))
        {
                return champion;
        }
            else if((champion.isISFight() || champion.hasSpecial()) && type.equals(ChallengeType.FIGHT.toString()) && champion.getStatus().equals(ChampionState.ENTERED.toString()))
        {
                return champion;
        }
    }
    }
    }
    
    catch (NullPointerException e)
    {
        System.out.print("You have a null pointer");    
    }
        
    return null;
    }
    
    /**
     *
     * @return 
     */
    public boolean isEmpty()
    {
        return allEnteredChampion.isEmpty();
    }
    
    /**
     *
     * @param reference
     * @param champion
     */
    public void deleteChampion(String reference,Champion champion)
    {
        allEnteredChampion.remove(reference, champion);    
    }
}

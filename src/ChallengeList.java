/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.util.* ;
//import java.util.*;
import java.io.*;
/**
 *List of all challenges 
 * 
 *@author Md Mohidul Hasan
 *@version 01.12.2018
 */
public class ChallengeList implements MethodList,Serializable 
{
    Map<String,Challenge> allChallenges = new HashMap();

    /**
     * checks if champion or challenge exist
     * 
     * @param reference input reference
     * @return return true or false
     */
    @Override
    public boolean checkIfExist(String reference) 
    {
       if(allChallenges.containsKey(reference))
       {
           return true;
       }
       else
       {
           return false;
       }

    }

    /**
     * gets the challenge object
     * 
     * @param reference input ref
     * @return returns challenge objects
     */
    public Challenge getChallengeObj(String reference) 
    {
        
    
    Challenge found = null;
       
    try
    {
       if(allChallenges.containsKey(reference))
       {
           System.out.println("found");
           System.out.println(allChallenges.get(reference));
           return allChallenges.get(reference);
           
       }
     
       }
    catch(NullPointerException e)
    {
        System.out.println("A Challenge NullPointer");
        
    }
    return null;
    }

    /**
     * adds champion or challenge
     * 
     * @param name input name
     * @param champion input champion
     * @return no return
     */
    @Override
    public void addTo(String name, Champion champion) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * adds challenge 
     * @param name input name   
     * @param challenge input challenge
     * @return no return
     */
    @Override
    public void addChallenge(String name, Challenge challenge) 
    {
        allChallenges.put(name, challenge);
    }

    /**
     * Gets all items in the hash map collections
     * 
     * @param no parameter
     * @return String
     */
    @Override
    public String getAllItems() 
    { 
    StringBuilder sq = new StringBuilder();
    for(Challenge c : allChallenges.values())
    {
        System.out.println(c.getChallengeNo());
       
        sq.append(
                  "Challenge No : " + c.getChallengeNo() + " " 
                + "Enemy Name : " + c.getEnemyName() + " " 
                + "Fight Type : " + c.getType() + " "
                + "rewards : " + c.getReward() + " " 
                + "Loses : " + c.getLoses() + " " 
                + "Enemy Skill required : " + c.getSkillRequired() + "\n"
                );

    }

    return sq.toString();    }

    /**
     * Search throw collections/ Error handling / Exception dealing
     * 
     * @param reference input ref
     * @return returns searched item 
     */
    @Override
    public String searchItem(String reference) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * takes challenge number as parameter and returns challenge type
     * 
     * @param ChallengeNo input challenge no
     * @return returns challenge type
     */
    public ChallengeType getType(int ChallengeNo)
    {
    
        String ChallengeToString = String.valueOf(ChallengeNo);
        
        ChallengeType challengeType = getChallengeObj(ChallengeToString).getType(); // Type of Challenge found

        return challengeType;
    }

    /**
     * takes in String reference/name as parameter
     * 
     * @param reference input reference     
     * @return error handling
     */
    @Override
    public Champion getObj(String reference) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.io.*;
/**
 *
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public interface MethodList extends Serializable
{

    /**
     *
     * @param ChampionName
     * @return
     */
    public boolean checkIfExist(String ChampionName); // True if ref = force

   
    
   /* pre-condition checkIfExist 
   
   If True, return the object
   */

    /**
     *
     * @param reference
     * @return
     */


   public Champion getObj(String reference);

    /**
     *
     * @param reference
     * @return 
     */
    public Challenge getChallengeObj(String reference);

    /**
     *
     * @param value
     * @return
     */
    public ChallengeType getType(int value);
   
    /**
     *
     * @param name
     * @param champion
     */
    public void addTo(String name, Champion champion);
   
    /**
     *
     * @param name
     * @param challenge
     */
    public void addChallenge(String name, Challenge challenge);

    /**
     *
     * @return
     */
    public String getAllItems();
   
    /**
     *
     * @param reference
     * @return
     */
    public String searchItem(String reference);
}

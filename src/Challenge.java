/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.util.*;
import java.io.*;
/**
 *A Class Challenge with appropriate fields and methods
 *It consists of Challenge number,enemyName,type ,reward,
 *loses,ChallengeNo,SkillRequired,special
 * 
 * @author Md Mohidul Hasan
 * @version 01.12.2018
 */
public class Challenge implements Serializable
{
    private String enemyName ;
    //private String enemyName ;
    private ChallengeType type;
    private int reward,loses,ChallengeNo, SkillRequired;
    boolean special;
    private String Ctype ;
    /**
     * Constructor objects of Class Challenge
     */
    Challenge(int ChallengeNo , String Ctype, String enemyName, int SkillRequired,int loses, int reward)
    {
        
        this.ChallengeNo = ChallengeNo;
        this.enemyName = enemyName;
        this.SkillRequired = SkillRequired;
        this.reward = reward;
        this.loses = loses;
        this.type = type;
    }
    /**
     *return challenge 
     * 
     *@param no parameter
     *@return Challenge Type
     */
    public ChallengeType getType() 
    {
        return type;
    }
    /**
     *sets challenge type 
     * 
     *@param type requires input for type of challenge
     *@return no return 
     */
    public void setType(ChallengeType type)
    {
        this.type = type;
    }
    
    /**
     *returns challenge number
     * 
     *@param no parameter
     *@return returns the no of challenges 
     */

    public int getChallengeNo()
    {
        return ChallengeNo;
    }
    /**
     *sets value to challenge number
     * 
     *@param ChallengeNo requires input for challenge no
     *@return no return
     */
    public void setChallengeNo(int ChallengeNo)
    {
        this.ChallengeNo = ChallengeNo;
    }
    /**
     *returns skill required
     * 
     *@parameter no parameter
     *@return returns what skill is required
     */
    public int getSkillRequired()
    {
        return SkillRequired;
    }
    /**
     * sets value to skill required
     * 
     * @param SkillRequired input for skill required
     * @return no return
     */
    public void setSkillRequired(int SkillRequired) 
    {
        this.SkillRequired = SkillRequired;
    }
    /**
     *gets enemy name
     * 
     *@parameter no parameter
     *@return returns enemy name
     */
    public String getEnemyName()
    {
        return enemyName;
    }
    /**
     *sets value to enemy name
     * 
     *@parameter enemyName input enemy name
     *@return no return 
     */
    public void setEnemyName(String enemyName) 
    {
        this.enemyName = enemyName;
    }
    /**
     *return reward
     * 
     *@parameter  no parameter
     *@return returns the rewards
     */
    public int getReward() 
    {
        return reward;
    }
    /**
     *sets value to reward
     * 
     *@parameter reward input the reward
     *@return no return 
     */
    public void setReward(int reward) 
    {
        this.reward = reward;
    }
    /**
     *returns reward
     * 
     *@parameter no parameter
     *@return returns loses
     */
    public int getLoses() {
        return reward;
    }
    /**
     *sets value to reward
     * 
     *@parameter reward input reward
     *@return no return 
     */
    public void setLoses(int reward) 
    {
        this.reward = reward;
    }
    /**
     *method to get value for variable Special
     * 
     *@parameter  no parameter 
     *@return return true or false
     */
    public boolean isSpecial() 
    {
        return special;
    }
    /**
     * method to set a value to variable special 
     * 
     *@parameter special input special
     *@return no return
     */
    public void setSpecial(boolean special) 
    {
        this.special = special;
    }
}

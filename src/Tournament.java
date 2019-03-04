package toc;
import java.util.*;
import java.util.HashMap;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * This class implements the behaviour expected from the WAM
 * system as required for 6COM1037 - Oct 2018
 * 
 * @author A.A.Marczyk 
 * @version 16/10/18
 */

public class Tournament implements TOC,Serializable
{
    // fields
    Treasury money = new Money() ;
    PlayerChampionTeam playerTeam = new PlayerChampionTeam() ;
    ChampionWaitingList championsWaiting = new ChampionWaitingList() ;
    ChallengeList AllChallenges = new ChallengeList() ;
    
    //ChampionSubName championnme ;
    ChampionReference championref ;
    ChampionName ChampionName ;
    ChallengeEnemy Enemynme ; 
    ChallengeType challenget ;
    String team ;
    String fname;
    //String name;
    HashMap<String, Challenge> AllChallenges2 = new HashMap<String,Challenge>();
    
    
    
    
//**************** TOC ************************** 
    /** Constructor requires the name of the player
     * @param player the name of the player
     */  
    
    public Tournament(String team)
    {
        setupChampions() ;
        setupChallenges() ;
        setupTreasury();
        this.team = team ;
        readChallenges("olenka.txt");

    }
    
    /** Constructor requires the name of the player and the
     * name of the file storing challenges
     * @param player the nme of the player
     * @param filename name of file storing challenges
     */  
    
    public Tournament(String team,String fname)  //Task 3
    {
        this.team = team  ;
        //this.fname = fname ;
        readChallenges(fname);
        setupChampions() ;
        setupChallenges() ;
        setupTreasury();
        this.team = team ;
        
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    
    {
      String treasuryState = String.valueOf(money.getValue());
      
      return team + treasuryState ;
    }
    
    
    /** returns true if Treasury <=0 and the player's team has no champions 
     * which can be reentered. 
     * @return true if Treasury <=0 and the player's team has no champions 
     * which can be retired. 
     */
    public boolean isDefeated()
    {
        if(money.getValue() <= 0 && playerTeam.isEmpty() )
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney()
    {
        return money.getValue();
    }
    
    public void setupTreasury()
    {
        
    money.setValue(1000);    
    System.out.println("Loading Treasury with a " + 1000 + " guldens" );
    
    }
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {    
        return championsWaiting.getAllItems();
    }
    
    /** Returns details of champion in reserves with the given name
     * @return details of champion in reserves with the given name
     **/
    public String findChampionInReserve(String reference)
    {
         return championsWaiting.searchItem(reference);
         
    }
    
    
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String reference)
    {
        if(championsWaiting.checkBool(reference))
        {
            return championsWaiting.searchItem(reference);
        }
        else
        {
            return playerTeam.searchItem(reference);
        }    
    }     
    
     /** Returns whether champion exists, or not
     * @param champion's name
     * @return true if champion in the game, false otherwise
     */
    public boolean isChampion(String reference)
    {
        return championsWaiting.checkBool(reference);
    }
 
    // ***************** Team champions ************************   
    /** Allows a champion to be entered for the player's team, if there 
     * is enough money in the Treasury for the commission fee.The champion's 
     * state is set to "active"
     * @param nme represents the name of the champion
     * @return 0 if champion is entered in the player's team, 1 if champion 
     * is not in reserve, 2 if not enough money in the treasury, -1 if there
     * is no such champion 
     **/       
    public int enterChampion(String reference)
    {
            if(!championsWaiting.checkBool(reference) && isInPlayersTeam(reference))
        {
                return 1;
        }
            if(championsWaiting.checkBool(reference))
            {
                int toDeduct = championsWaiting.allWaitinglist.get(reference).getentryFee();
                if(toDeduct <= money.getValue())
                {
                
                    money.deductValue(toDeduct);
                    championsWaiting.allWaitinglist.get(reference).setEntered();
                    playerTeam.addTo(reference, championsWaiting.getObj(reference));
                    championsWaiting.allWaitinglist.remove(reference);
                    return 0 ;
                    
                }
                else
                {
                
                    return 2;
                }
            }
            else
            {
            return -1 ;
            }
    
    }
        
    /** Returns true if the champion with the name is in 
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String reference)
    {
        return playerTeam.checkBool(reference);
    }
    
    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is withdrawn to reserves
     * 1 - if champion not withdrawn because dead
     * 2 - if champion not withdrawn because not in team
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int withdrawChampion(String reference)
    {
        if(isInPlayersTeam(reference))
        {
            if(playerTeam.getObj(reference).getStatus().equals(ChampionState.ENTERED.toString()))
            {
            int toAdd = playerTeam.getObj(reference).getentryFee();
            System.out.println("to add : " + toAdd);
            money.addValue(toAdd/2);
            playerTeam.getObj(reference).setWaiting();
            
            championsWaiting.addTo(reference, playerTeam.getObj(reference));
            //playerTeam.allEnteredChampion.remove(ChampionName);
            playerTeam.deleteChampion(reference,playerTeam.getObj(reference));
            //playerTeam.deleteChampion(obj);
            return 0;
            }
            else //if(playerTeam.getObj(reference).getStatus().equals(ChampionState.DEAD.toString()))
            {
            System.out.println("Champion is dead and cant be withdrwan");
            return 1 ;
            }
            //else
            //{
            //return 1;
            //}
            
        }
        else
        {
            System.out.println("No such Champion");
            return 2;
        }
    }
    
   
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam()
    {
        return playerTeam.getAllItems();
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the  number of the challenge
     * @return true if the  number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         String toString = String.valueOf(num);
         return AllChallenges.checkIfExist(toString);
     }
     
    /** Retrieves the challenge represented by the challenge 
      * number.Finds a champion from the team which can challenge the 
      * challenge. The results of fighting an challenge will be 
      * one of the following:  
      * 0 - challenge won, add challenge reward to the treasury, 
      * 1 - challenge lost as no suitable champion is  available, deduct
      * the challenge reward from treasury 
      * 2 - challenge lost on battle skills  - deduct challenge reward from
      * treasury and record champion as "dead"
      * 3 - If a challenge is lost and player completely defeated (no money and 
      * no champions to withdraw) 
      * -1 - no such challenge 
      * @param chalNo is the number of the challenge
      * @return an int showing the result(as above) of fighting the challenge
      */  
    public int fightChallenge(int chalNo)
    {
        String FighttoString = String.valueOf(chalNo);
        String FightChallengeType = AllChallenges.getType(chalNo).toString();
        
        int result = -1;
        if(isChallenge(chalNo) && playerTeam.validateType(FightChallengeType))
        {
        
                Champion champtouse = playerTeam.validatedType(FightChallengeType);
                Champion toRemove   = playerTeam.validatedType(FightChallengeType);
        
                if(AllChallenges.getChallengeObj(FighttoString).getSkillRequired() < champtouse.getskillLevel() )
                    {
                        money.addValue(AllChallenges.getChallengeObj(FighttoString).getReward());
                        result = 0 ;
                    }
                else if (champtouse.getskillLevel() < AllChallenges.getChallengeObj(FighttoString).getSkillRequired() && isDefeated())   
                    {
                        result = 3 ;
                    }
                else if (champtouse.getskillLevel() < AllChallenges.getChallengeObj(FighttoString).getSkillRequired() && !isDefeated() )
                    {
                        System.out.println(playerTeam.isEmpty());
                        money.deductValue(AllChallenges.getChallengeObj(FighttoString).getLoses());
                        champtouse.setDead();
                        playerTeam.allEnteredChampion.remove(toRemove.getChampionName()) ;
                        result = 2 ;
                    }
        else if (isChallenge(chalNo))
        {
                       money.deductValue(AllChallenges.getChallengeObj(FighttoString).getLoses());
                       result = 1 ;
        }
        else
        {
        
             result = -1 ;   
        }
        }
        return result;
    }

    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {
        Challenge challenge = AllChallenges2.get(num);
        return challenge.toString();
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        return AllChallenges.getAllItems();
    }
    

    //****************** private methods *******************
    //*******************************************************************************
    private void setupChampions()
    {
        championsWaiting.addTo(ChampionName.ARGON.toString(),new Warrior(championref.ARGON.toString(),ChampionName.ARGON.toString(),9,900,false,true,false,ChampionWeopon.MACE));
        championsWaiting.addTo(ChampionName.FLIMSI.toString(),new Warrior(championref.FLIMSI.toString(),ChampionName.FLIMSI.toString(),2,200,false,true,false,ChampionWeopon.BOW));
        championsWaiting.addTo(ChampionName.ELBLOND.toString(),new Warrior(championref.ELBLOND.toString(),ChampionName.ELBLOND.toString(),9,900,false,true,false,ChampionWeopon.SWORD));
        championsWaiting.addTo(ChampionName.GANFRANK.toString(),new Wizard(championref.GANFRANK.toString(),ChampionName.GANFRANK.toString(),7,400,true,true,true,ChampionSpellSpeciality.TRANSMUTAION,true));
        championsWaiting.addTo(ChampionName.RUDOLF.toString(),new Wizard(championref.RUDOLF.toString(),ChampionName.RUDOLF.toString(),6,400,true,true,true,ChampionSpellSpeciality.INVISIBILITY,true));
        championsWaiting.addTo(ChampionName.NEON.toString(),new Wizard(championref.NEON.toString(),ChampionName.NEON.toString(),2,300,true,true,true,ChampionSpellSpeciality.TRANSLOCATION,true));
        championsWaiting.addTo(ChampionName.DRABINA.toString(),new Dragon(championref.DRABINA.toString(),ChampionName.DRABINA.toString(),7,500,false,true,false,false));
        championsWaiting.addTo(ChampionName.GOLUM.toString(),new Dragon(championref.GOLUM.toString(),ChampionName.GOLUM.toString(),7,500,false,true,true,true));
        championsWaiting.addTo(ChampionName.XENON.toString(),new Dragon(championref.XENON.toString(),ChampionName.XENON.toString(),7,500,false,true,true,true));
        championsWaiting.addTo(ChampionName.FRODER.toString(),new Dragon(championref.FRODER.toString(),ChampionName.FRODER.toString(),7,500,false,true,true,true));
        championsWaiting.addTo(ChampionName.MIMSI.toString(),new Dwarf(championref.MIMSI.toString(),ChampionName.MIMSI.toString(),3,300,false,true,true,false,"Morva"));   
    }
     
    private void setupChallenges()
    {
      AllChallenges.addChallenge( "1",new Challenge(1 ,ChallengeType.MAGIC.toString(),Enemynme.BORG.toString(),3,100,100));
      AllChallenges.addChallenge( "2",new Challenge(2 ,ChallengeType.FIGHT.toString(), Enemynme.HUNS.toString(),3, 120, 120));
      AllChallenges.addChallenge( "3",new Challenge(3 ,ChallengeType.MYSTERY.toString(),Enemynme.FERENGI.toString(),3,150,150));
    
      AllChallenges.addChallenge( "4",new Challenge(4 ,ChallengeType.MAGIC.toString(),Enemynme.VANDAL.toString(),9,200,200));
      AllChallenges.addChallenge( "5",new Challenge(5 ,ChallengeType.MYSTERY.toString(),Enemynme.BORG.toString(),7,90,90));
      AllChallenges.addChallenge( "6",new Challenge(6 ,ChallengeType.FIGHT.toString(),Enemynme.GOTH.toString(),8,45,45));
      
      AllChallenges.addChallenge( "7",new Challenge(7 ,ChallengeType.MAGIC.toString() , Enemynme.FRANK.toString(),10,200, 200));
      AllChallenges.addChallenge( "8",new Challenge(8 ,ChallengeType.FIGHT.toString() , Enemynme.BORG.toString(),10,170,170));
      AllChallenges.addChallenge( "9",new Challenge(9 ,ChallengeType.MYSTERY.toString(),Enemynme.CARDASSIANS.toString(),10,300,300));
      AllChallenges.addChallenge("10",new Challenge(10,ChallengeType.MYSTERY.toString(),Enemynme.VIKINGS.toString(),5,70,70));
        
    }
        
   
//    // These methods are not needed until Task 4.4
//    // ***************   file write/read  *********************
//     /** Writes whole game to the specified file using serialisation
//      * @param fname name of file to which game is saved
//      */
    public static void saveGame(Tournament tournament,String fname) 
         {    // use serialisation
        
        try 
		{
			FileOutputStream fos = new FileOutputStream (fname);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
		
			oos.writeObject (tournament);
			System.out.println ("Object successfully written.");
			
						
		}
	catch (Exception e) 
                {
			e.printStackTrace();
		}
        
        }
//     
//     /** reads all information about the game from the specified file 
//      * and returns 
//      * @param fname name of file storing the game
//      * @return the game (as an Player object)
//      */
     public static Tournament loadGame(String fname) 
         {   // uses object serialisation 
         
        try 
        {
            FileInputStream fis = new FileInputStream (fname);
            ObjectInputStream ois = new ObjectInputStream (fis);
            
            Tournament tournament =(Tournament) ois.readObject ();
            System.out.println ("Object successfully read:");
                                   
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null ;
        }
//     
//     /** reads information about challenges from the specified file
//      * and stores them 
//      * @param fileName name of file storing challenges
//      */
    public void readChallenges(String fname)
    {
        {
        
        try
        {
            BufferedReader inf  = new BufferedReader (new FileReader(fname));
            String fline;
            while((fline = inf.readLine()) != null)
            {
                String[] info = fline.split(",");
                
                AllChallenges2.put(info[0], new Challenge(Integer.parseInt(info[0]),info[1],info[2],Integer.parseInt(info[3]),Integer.parseInt(info[4]),Integer.parseInt(info[5]) ));
                
            }
        }
        catch (IOException e) {System.out.println("No such file");}   
        
        String s = "************ All Challenges ********";
        Collection<Challenge> chalg = AllChallenges2.values();
        for(Challenge c: chalg)
        {
            System.out.println(c.toString());
        } 
    }
    }
    
}




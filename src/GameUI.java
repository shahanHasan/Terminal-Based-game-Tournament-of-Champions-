package toc;
import java.io.*;
import java.util.*;
import java.nio.*;
/**
 * Task 2 - provide command line interface for testing
 * 
 * @author A.A.Marczyk
 * @version 20/10/18
 */
public class GameUI implements Serializable
{
    private static Tournament tr ;
    private static Scanner myIn = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice;
        String playerName;
        String output = "";
        int result = -1; 
        try
        {
            System.out.println("Enter player's name");
            String s = myIn.nextLine();
            //myIn.nextLine();
            tr = new Tournament(s); // create
            choice = 100;
            while (choice != 0 )
            {
                choice = getMenuItem();
                if (choice == 1)
                {
                    System.out.println(tr.getReserve());//returns all champioms
                }
                else if (choice == 2)
                {
                    System.out.println(tr.getTeam());//returns all champions in the team
                }
                else if (choice == 3)
                {
                    System.out.println("View a champion");
                    String nme=(myIn.nextLine()).trim();
                    System.out.println(tr.getChampionDetails(nme));// champion details
                } 
                else if (choice == 4)
                {   
                    System.out.println("Enter Champion name");
                    String nme = (myIn.nextLine()).trim();
                    result = tr.enterChampion(nme);
                    if (result ==0)
                    {
                        output = nme + " entered in team";
                    }
                    else if (result ==1)
                    {
                        output = nme + " not in reserve";
                    }
                    else if (result ==2)
                    {
                        output = "Not enough money in treasury ";
                    }
                    else
                    {
                        output = "No such champion";
                    }
                    System.out.println("\n" + output + "\nTreasury = �" + tr.getMoney());
                }
                else if (choice == 5)
                {
                    System.out.println("Enter number of the challenge");
                    String chal = myIn.nextLine();
                    int number = Integer.parseInt(chal);
                    if (tr.isChallenge(number))
                    {
                        result = tr.fightChallenge(number);
                    }
                    if (result ==0)
                    {
                        output = "Challenge won";
                    }
                    else if (result ==1)
                    {
                        output = "Challenge lost as no champion available";
                    }
                    else if (result ==2)
                    {
                        output = "Challenge lost on battle skill";
                    }
                    else if (result ==3)
                    {
                        output = "Challenge lost. You lose the game ";
                    }
                    else 
                    {
                        output = "No such challenge";
                    }
                    System.out.println("\n" + output + "\nTreasury = �" + tr.getMoney());
                }
                else if (choice==6)
                {
                    System.out.println("Enter Champion name");
                    String nme = (myIn.nextLine()).trim();
                    if(tr.isChampion(nme)) //responsible client
                    {
                        result = tr.withdrawChampion(nme);
                    }
                    else if (result ==0)
                    {
                        output = "Champion withdrawn";
                    }
                    else if (result ==1)
                    {
                        output = "Champion can't be withdrawn because dead";
                    }
                    else if(result == 2)
                    {
                        output = "\nChampion can't be withdrawn because not in team";
                    }
                    else
                    {
                    output = "\nNo such champion" ;
                    }    
                    System.out.println(output+"\nTreasury = " + tr.getMoney());
                }  
                else if (choice==7)
                {
                    System.out.println(tr.toString());
                }
                 else if (choice == 8) // Task 4.4 only
                 {
                    
                     
                     System.out.println("Write to file");
                     tr.saveGame(tr,"save");
                     
                    
                 }
                 else if (choice == 9) // Task 4.4 only
                 {
                     
                     
                         
                     System.out.println("Restore from file");
                     Tournament tr2 = (Tournament)tr.loadGame("save");
                     System.out.println(tr2.toString());  
                     
                     
                     
                     
                 }
                else if (choice == 10) // Task 4.4 only
                 {
                     
                     
                         
                     System.out.println("See Challenge");
                     System.out.println("Input number from 1 to 10");
                     int num = myIn.nextInt();
                     tr.getChallenge(num);
                     System.out.println(tr.getChallenge(num));  
                     
                     
                     
                     
                 }
            }     
        }
        catch (IOException e) {System.out.println (e);}   
        System.out.println("Thank-you");
    }
    
    private static int getMenuItem()throws IOException
    {   int choice = 100;  
        System.out.println("\nMain Menu");
        System.out.println("0. Quit");
        System.out.println("1. List champions in reserve");
        System.out.println("2. List champions in players team"); 
        System.out.println("3. View a champion");
        System.out.println("4. Enter champion into player's team");
        System.out.println("5. Fight a challenge");
        System.out.println("6. Withdraw a champion");
        System.out.println("7. View game state");
        System.out.println("8. Save this game");
        System.out.println("9. Load this game");
        System.out.println("10. View a challenge");
       
        
        while (choice < 0 || choice  > 9)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        myIn.nextLine();
        return choice;        
    }  
}
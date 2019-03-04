/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

/**
 *
 * @author MD Mohidul Hasan 15071717
 * @author Wenda Ruan 
 */
public class DemoA 

{
    public static void main(String[] args)
    {
    TOC king = new Tournament ("Mary");// creates an object king of type tournament
        king.getAllChallenges();// gets a list of all the challenges
    System.out.println("*********************");
    king.enterChampion("Elblond");
        king.getReserve();
        king.getTeam();
    king.enterChampion("Rudolf");
        king.getReserve();
        king.getTeam();
    king.enterChampion("Xenon");
        king.getReserve();
        king.getTeam();
    king.enterChampion("Marge");
        king.getReserve();
        king.getTeam();
    king.toString();
    king.getReserve();
    king.fightChallenge(2);
        king.getMoney();
        king.getTeam();
        king.isDefeated();
    king.fightChallenge(4);
        king.getMoney();
        king.getTeam();
        king.isDefeated();
    king.fightChallenge(5);
        king.getMoney();
        king.getTeam();
        king.isDefeated();
    king.withdrawChampion("Xenon");
        king.getMoney();
    king.enterChampion("Morva");
        king.fightChallenge(4);
            king.getMoney();
            king.getTeam();
            king.isDefeated();
        king.fightChallenge(9);
            king.getMoney();
            king.getTeam();
            king.isDefeated();
    
    }
}

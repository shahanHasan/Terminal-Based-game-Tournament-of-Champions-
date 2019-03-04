/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aam
 */
public class Test425FightChallenge {
    TOC game;
    
    public Test425FightChallenge() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Jean");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
//Wizards    
    // Wizard facing magic
    @Test
    public void wizardFacingMagicWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicWinsMoney() {
        int expected = 1000-400+100;
        game.enterChampion("Ganfrank");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
      
    @Test
    public void wizardLosingIsDead() {
        game.enterChampion("Neon");
        game.fightChallenge(1);
        boolean actual = game.getChampionDetails("Neon").toLowerCase().contains("dead");
        assertTrue(actual);
    }
    
    //checking withdrawal of dead champion
    @Test
    public void cantWithdrawDead() {
        int expected = 1;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual= game.withdrawChampion("Neon");
        assertEquals(actual,expected);
    }
    
    @Test
    public void cantWithdrawDeadMoneyNotAffected() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        game.withdrawChampion("Neon");
        int actual= game.getMoney();
        assertEquals(actual,expected);
    }

    @Test
    public void wizardFacingNoSuchMagic() {
        int expected = -1;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(10);
        assertEquals(expected, actual);
    } 
    
    // Wizard facing fight
    @Test
    public void wizardFacingFightWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingFightWinsMoneyAdded() {
        int expected = 1000-400+120;
        game.enterChampion("Ganfrank");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingFightLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingFightLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    // Wizard facing mystery
    @Test
    public void wizardFacingMysteryWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(3);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingMysteryWinsMoneyAdded() {
        int expected = 1000-400+150;
        game.enterChampion("Ganfrank");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingMysteryLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMysteryLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-150;
        game.enterChampion("Neon");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
   
//Warriors
    //Warrior facing magic - not allowed
    @Test
    public void warriorFacingMagicNotAllowed() {
        int expected = 1;
        game.enterChampion("Argon");
        game.fightChallenge(1);
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMagicNotAllowedMoneyDeducted() {
        int expected = 0;
        game.enterChampion("Argon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
  
    //Warrior facing fight
    @Test
    public void warriorFacingFightAllowedWins() {
        int expected = 0;
        game.enterChampion("Argon");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
      
    @Test
    public void warriorFacingFightAllowedWinsMoneyAdded() {
        int expected = 220;
        game.enterChampion("Argon");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Flimsi");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesMoneyDeducted() {
        int expected = 680;
        game.enterChampion("Flimsi");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    //Warrior facing mystery - not allowed
    @Test
    public void warriorFacingMysteryNotAllowed() {
        int expected = 1;
        game.enterChampion("Argon");
        game.fightChallenge(3);
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMysteryNotAllowedMoneyDeducted() {
        int expected = -50;
        game.enterChampion("Argon");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    //Dragons - write your own tests
    
  
    
    

}

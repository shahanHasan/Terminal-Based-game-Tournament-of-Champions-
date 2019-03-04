/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jp14adn
 */
public class Test423ChampionEntered {
    TOC game;
    
    public Test423ChampionEntered() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Olenka");
    }
    
    @After
    public void tearDown() {
    }

    
    // TODO add test methods here.
    
     @Test
    public void checkOneChampionEnteredResult0() {
        int expected = 0;
        int actual= game.enterChampion("Flimsi");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkOneChampionEnteredTreasuryDeducted() {
        int expected = 800;
        game.enterChampion("Flimsi"); //don't store return
        int actual= game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkOneChampionEnteredInTeam() {
        game.enterChampion("Flimsi"); 
        boolean actual= game.isInPlayersTeam("Flimsi");
        assertTrue(actual);
    }
    
    @Test
    public void checkOneChampionNotInReserve() {
        game.enterChampion("Flimsi");
        String zz = game.findChampionInReserve("Flimsi"); ;
        boolean actual = !zz.contains("Flimsi");
        assertFalse(actual);
    }
    
    @Test
    public void checkOneChampionEnteredResult1() {
        int expected = 1;
        game.enterChampion("Flimsi");
        int actual = game.enterChampion("Flimsi"); // already entered
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkTwoChampionsEnteredMoney() {
        int expected = 400;
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        assertEquals(expected, game.getMoney());
    }
    
    @Test
    public void checkTwoChampionsInTeam() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        String team = game.getTeam();
        boolean result = team.contains("Flimsi")&& team.contains("Ganfrank");
        assertTrue(result);
    }
    
    @Test
    public void checkTwoChampionsNotInReserve() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        String reserve = game.getReserve();
        boolean result = reserve.contains("Flimsi")||reserve.contains("Ganfrank");
        assertFalse(result);
    }
    
    @Test
    public void checkNotEnoughMoneyResult2() {
        int expected = 2;
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        int actual = game.enterChampion("Argon");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotEnoughMoneySoNotInTeam() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        boolean actual = !game.isInPlayersTeam("Argon");
        assertTrue(actual);
    }
    
    @Test
    public void checkInTeam() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        String result = game.getTeam();
        boolean actual = result.contains("Flimsi") && result.contains("Ganfrank")&& !result.contains("Argon");
        assertTrue(actual);
    }
    
    @Test
    public void checkNotEnoughMoneySoStaysInReserve2() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        boolean actual = (game.getReserve()).contains("Argon");
        assertTrue(actual);
    }
    
    @Test
    public void checkNoSuchChampionEntered() {
        int expected = -1;
        int actual= game.enterChampion("Boggle");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNoSuchChampionEnteredNoDeduction() {
        int expected = 1000;
        game.enterChampion("Boggle");
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNoSuchChampionInTeam() {
        game.enterChampion("Boggle");
        boolean result = (game.getTeam()).contains("Boggle");
        assertFalse(result);
    }
    
    @Test
    public void checkNoSuchChampionInReserve() {
        game.enterChampion("Boggle");
        boolean result = (game.getReserve()).contains("Boggle");
        assertFalse(result);
    }

}

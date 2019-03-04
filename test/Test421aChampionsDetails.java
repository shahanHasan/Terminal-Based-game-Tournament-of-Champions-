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
 * @author aam
 */
public class Test421aChampionsDetails {
    TOC game;
    
    public Test421aChampionsDetails() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Ola");
    }
    
    @After
    public void tearDown() {
    }

     
    //a local method to check a String for contents - not a test as no @test
    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }
    
    @Test
    public void isChampionTest()
    {
        boolean actual = game.isChampion("Flimsi");
        assertTrue(actual);
    }
    
     @Test
    public void isNotChampionTest()
    {
        boolean actual = game.isChampion("Alan");
        assertFalse(actual);
    }
    
    @Test
    public void getChampionDetailsTest(){
        String details = game.getChampionDetails("Argon");
        String[] xx = {"Argon","9", "900", "mace","Warrior"};
        boolean actual = containsText(details,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveNeon() {
        String result = game.getReserve();
        boolean actual = result.contains("Neon");
        assertTrue(actual);
    }

}

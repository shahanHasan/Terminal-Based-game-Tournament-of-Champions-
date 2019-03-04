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
public class Test421bChampionsDetails {
    TOC game;
    
    public Test421bChampionsDetails() {
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
    public void ChampionInReserveGolumSomeDetails() {
        String result = game.getReserve();
        String[] xx = {"Golum", "7", "500","true"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void championInReserveGanfrankDetails() {
        String result = game.getReserve();
        String[] xx = {"Ganfrank","true", "7", "400","transmutation", "Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveRudolfDetails() {
        String result = game.getReserve();
        String[] xx = {"Rudolf", "true", "6", "400","invisibility","Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveElblondDetails() {
        String result = game.getReserve();
        String[] xx = {"Elblond", "1", "150","sword", "Warrior"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }    
    
    @Test
    public void ChampionInReserveDrabinaDetails() {
        String result = game.getReserve();
        String[] xx = {"Drabina", "7", "500","false", "Dragon"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveNeonDetails() {
        String result = game.getReserve();
        String[] xx = {"Neon","2", "false", "300","translocation", "Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    

}

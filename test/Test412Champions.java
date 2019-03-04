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
public class Test412Champions {
    TOC game;
    
    public Test412Champions() {
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
            result = result && (text.toLowerCase().contains(temp.toLowerCase()));
        }
        return result;
    }
    
   
    
    @Test
    public void getReserveTest(){
        String[] xx = {"Ganfrank","Rudolf","Elblond","Flimsi","Drabina","Golum","Argon","Neon","Xenon"};
        String details = game.getReserve();
        boolean actual = containsText(details,xx );
        assertTrue(actual);
    }

}

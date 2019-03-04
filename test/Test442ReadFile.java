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
 * @author comqaam
 */
public class Test442ReadFile {

    
    public Test442ReadFile() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void checkRead1() {
        TOC game = new Tournament("Fred","olenka.txt");
         String result = game.getChallenge(1);
         boolean actual = result.contains("Borg");
         assertTrue(actual);
     }
     
     
     @Test
     public void checkRead9() {
         TOC game2 = new Tournament("Fred","olenka.txt");
         String result = game2.getChallenge(9);
         boolean actual = result.contains("Cardashian");
         assertTrue(actual);
     }
    
     @Test
     public void checkReadNoFile() {
         TOC game3 = new Tournament("Fred","fred.txt");
         String result = game3.getChallenge(1);
         boolean actual = result.contains("");
         assertTrue(actual);
     }

}

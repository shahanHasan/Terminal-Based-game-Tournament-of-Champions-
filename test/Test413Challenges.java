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
public class Test413Challenges {
    TOC game;
    
    public Test413Challenges() {
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

     /** Testing Strings is not pleasant. These are not very good tests as the 
     * take no account of capital/lower case, spaces etc.You could use trim() 
     * & toLowerCase().They also don't check the order of String components 
     * (do we care?). But they are enough
     */
     
     
    //just a local method to check a String for contents
    private boolean containsText(String text, String[] s) {
        boolean check = true;
        for(int i=0; i < s.length; i++)
        check = check && text.contains(s[i]);
        return check;
    }
    
    
    @Test
    public void challengeMagicDisplayed() {
        boolean actual = false;
        String result = game.getAllChallenges();
        String[] xx = {"1","Magic","Borg","3","100"};
        actual = containsText(result, xx);
        assertTrue(actual);
    }
    
    @Test
    public void challengeFightDisplayed() {
        boolean actual = false;
        String result = game.getAllChallenges();
        String[] xx = {"2", "Fight", "Huns", "3","120"};
        actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void challengeMysteryDisplayed() {
        boolean actual = false;
        String result = game.getAllChallenges();
        String[] xx = {"3", "Mystery", "Ferengi", "3","150"};
        actual = containsText(result, xx);
        assertTrue(actual);
    }
    
    @Test
    public void challengeEndMysteryDisplayed() {
        boolean actual = false;
        String result = game.getAllChallenges();
        String[] xx = {"9", "Mystery", "Cardashian", "9","300"};
        actual = containsText(result, xx);
        assertTrue(actual);
    }

    // You can add more but is it worth it ?


}

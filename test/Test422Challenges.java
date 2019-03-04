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
public class Test422Challenges {
    TOC game;
    
    public Test422Challenges() {
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

    // You can add more but is it worth it ?
   
    @Test
    public void isChallengeTestMidRange(){
        boolean result = game.isChallenge(3);
        assertTrue(result);
    }
    
    @Test
    public void isChallengeTestStartRange(){
        boolean result = game.isChallenge(1);
        assertTrue(result); 
    }
    
    @Test
    public void isChallengeTestEndRange(){
        boolean result = game.isChallenge(9);
        assertTrue(result); 
    }
    
    @Test
    public void isChallengeTestOverEndRange(){
        boolean result = game.isChallenge(10);
        assertFalse(result); 
    }
    
    @Test
    public void isChallengeTestUnderStartRange(){
        boolean result = game.isChallenge(0);
        assertFalse(result); 
    }
    @Test
    public void getChallengeTest(){
        String result = game.getChallenge(3);
        boolean actual = result.contains("Mystery")&& result.contains("Ferengi");
        assertTrue(actual); 
    }
    @Test
    public void getChallengeTest2(){
        String result = game.getChallenge(1);
        boolean actual = result.contains("Magic")&& result.contains("Borg");
        assertTrue(actual); 
    }
    
    @Test
    public void getChallengeTest3(){
        String result = game.getChallenge(9);
        boolean actual = result.contains("Mystery") && result.contains("Cardashian");
        assertTrue(actual); 
    }
    
    @Test
    public void getChallengeTest4(){
        String result = game.getChallenge(0);
        boolean actual = result.contains("No") ;
        assertTrue(actual); 
    }
    
    @Test
    public void getChallengeTest5(){
        String result = game.getChallenge(10);
        boolean actual = result.contains("No") ;
        assertTrue(actual); 
    }

}

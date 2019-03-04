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
public class Test441Persistence {
    TOC game;
    
    public Test441Persistence() {
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
    public void persistenceTest()
    {
        game.enterChampion("Flimsi");
        game.saveGame(game,"Testing.dat");
        game.enterChampion("Ganfrank");
        TOC game2 = game.loadGame("Testing.dat");
        boolean result = game2.isInPlayersTeam("Ganfrank");
        assertFalse(result);
    }
    
    @Test
    public void persistenceTest2()
    {
        game.enterChampion("Flimsi");
        game.saveGame(game,"Testing.dat");
        game.enterChampion("Ganfrank");
        TOC game2 = game.loadGame("Testing.dat");
        boolean result = game2.isInPlayersTeam("Flimsi");
        assertTrue(result);
    }
    
    @Test
    public void persistenceTest3()
    {
        game.enterChampion("Flimsi");
        game.saveGame(game,"Testing.dat");
        game.enterChampion("Ganfrank");
        int game1Money = game.getMoney();
        TOC game2 = game.loadGame("Testing.dat");
        int game2Money = game2.getMoney();
        boolean result = game1Money < game2Money;
        assertTrue(result);
    }

}

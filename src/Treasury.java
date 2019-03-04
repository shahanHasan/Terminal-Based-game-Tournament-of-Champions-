/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

/**
 *treasury keeps certain amount of money
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public interface Treasury 
{
    public int getValue(); // get the treasury value
    
    public void setValue(int m); // set the initial value of treasury
    
    public void addValue(int m); // add money to treasury 
    
    public void deductValue(int m); // deduct  money from treasury
}

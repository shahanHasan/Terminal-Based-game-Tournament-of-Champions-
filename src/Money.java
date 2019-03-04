/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;
import java.io.*;
/**
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public class Money implements Treasury,Serializable
{
    private int value = 1000 ;
    
    /**
     *
     * @return returns value 
     */
    @Override
    public int getValue() 
    {
        return value;
    }

    /**
     *
     * @param m
     */
    @Override
    public void setValue(int m) 
    {
        this.value = m;
    }

    /**
     *
     * @param m
     */
    @Override
    public void addValue(int m) 
    {
        this.value = this.value + m;
    }

    /**
     *
     * @param m
     */
    @Override
    public void deductValue(int m) 
    {
        this.value = this.value - m;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.util.Random; 

/**
 *
 * @author carmitnaor
 */


public class Cube {
    private int roll1;
    private int roll2; 
    private boolean isdoble;


    public Cube() {
        roll1 = roll();
        roll2 = roll();
        boolean isdoble = IsDouble();
    }

    public int getRoll1() {
        return roll1;
    }

    public int getRoll2() {
        return roll2;
    }

    public boolean isIsdoble() {
        return isdoble;
    }

    public Cube(int roll1, int roll2, boolean isdoble) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.isdoble = isdoble;
    }

    

  
    
    

    
    
    public int roll(){
        Random cube = new Random();
        int min = 1;
        int max = 6;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return random_int;
    }
    
    public boolean IsDouble(){
        
        if(roll1 == roll2){
            return true;
        }
        
        return false;
        
      
    }
    
    
    
}

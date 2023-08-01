/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.io.Serializable;

/**
 *
 * @author manske_905351
 */
public class Other extends Type implements Serializable {
    
    int location;
    String name;
    boolean isInJail;
    Player playerPassingorJail;
        private String typeName = "Other";

    public String getTypeName() {
        return typeName;
    }


        public Other(int location, String name, boolean isInJail, Player playerPassingorJail) {
        this.location = location;
        this.name = name;
        this.isInJail = isInJail;
        this.playerPassingorJail = playerPassingorJail;
    }
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsInJail() {
        return isInJail;
    }

    public void setIsInJail(boolean isInJail) {
        this.isInJail = isInJail;
    }

    public Player getPlayerPassingorJail() {
        return playerPassingorJail;
    }

    public void setPlayerPassingorJail(Player playerPassingorJail) {
        this.playerPassingorJail = playerPassingorJail;
    }

    @Override
    public String toString() {
        return "Other{" + "location=" + location + ", name=" + name + ", isInJail=" + isInJail + ", playerPassingorJail=" + playerPassingorJail + '}';
    }

    

    
    
    
    
            
         
           
    
   
}

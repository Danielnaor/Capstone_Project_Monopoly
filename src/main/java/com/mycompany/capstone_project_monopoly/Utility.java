/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

/**
 *
 * @author manske_905351
 */
public class Utility extends Type{
    private int cost = 150;
    private int mortgage = 75;
    private int[] rentRate = {4, 10};
    private boolean isMortgaged;
    private Player owner;

    public int getCost() {
        return cost;
    }

    public int getMortgage() {
        return mortgage;
    }

    public int getRentRate(int num) {
        return rentRate[num];
    }

    public boolean isIsMortgaged() {
        return isMortgaged;
    }

    public Player getOwner() {
        return owner;
    }

    public Utility(boolean isMortgaged, Player owner) {
        this.isMortgaged = isMortgaged;
        this.owner = owner;
    }

    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
}

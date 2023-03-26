/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

/**
 *
 * @author manske_905351
 */
public class Railroad extends Type{
    private int location;
    private String name;
    private int cost;
    private int[] rent;
    private int mortgage;
    private boolean isMortgaged;
    private Player owner;

    public Railroad(int location, String name, int cost, int[] rent, int mortgage, boolean isMortgaged, Player owner) {
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.mortgage = mortgage;
        this.isMortgaged = isMortgaged;
        this.owner = owner;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getRent() {
        return rent;
    }

    public void setRent(int[] rent) {
        this.rent = rent;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public boolean isIsMortgaged() {
        return isMortgaged;
    }

    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Railroad{" + "location=" + location + ", name=" + name + ", cost=" + cost + ", rent=" + rent + ", mortgage=" + mortgage + ", isMortgaged=" + isMortgaged + ", owner=" + owner + '}';
    }


    
            
}

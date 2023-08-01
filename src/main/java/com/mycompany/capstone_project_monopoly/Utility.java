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
public class Utility extends Type implements Serializable {

    //stores the data for a given utility
    private int location;
    private String name;
    private int cost;
    private int mortgage;
    private int[] rentRate;
    private boolean isMortgaged;
    private Player owner;
    private String typeName = "Utility";

    public String getTypeName() {
        return typeName;
    }

    public Utility(int location, String name, int cost, int mortgage, int[] rentRate, boolean isMortgaged, Player owner) {
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.mortgage = mortgage;
        this.rentRate = rentRate;
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

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getRentRate(int num) {
        int rent_Rate = MainWindow.lastRoll * rentRate[num];
        return rent_Rate;
    }

    public void setRentRate(int[] rentRate) {
        this.rentRate = rentRate;
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
        return "Utility";
    }

}

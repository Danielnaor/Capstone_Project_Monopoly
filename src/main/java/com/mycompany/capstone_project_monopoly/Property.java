/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;

/**
 *
 * @author manske_905351
 */
public class Property extends Type{
        private int location;
    private String name;
    private int cost;
    private int[] rent;
    private Color color;
    private int Mortgage;
    private boolean isMortgaged;
    private int upgradeLevel;
    private int upgradeCost;
    private Player owner;

    public Property(int location, String name, int cost, int[] rent, Color color, int Mortgage, boolean isMortgaged, int upgradeLevel, int upgradeCost, Player owner) {
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.color = color;
        this.Mortgage = Mortgage;
        this.isMortgaged = isMortgaged;
        this.upgradeLevel = upgradeLevel;
        this.upgradeCost = upgradeCost;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMortgage() {
        return Mortgage;
    }

    public void setMortgage(int Mortgage) {
        this.Mortgage = Mortgage;
    }

    public boolean isIsMortgaged() {
        return isMortgaged;
    }

    public void setIsMortgaged(boolean isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(int upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Property{" + "location=" + location + ", name=" + name + ", cost=" + cost + ", rent=" + rent + ", color=" + color + ", Mortgage=" + Mortgage + ", isMortgaged=" + isMortgaged + ", upgradeLevel=" + upgradeLevel + ", upgradeCost=" + upgradeCost + ", owner=" + owner + '}';
    }

    
  
}

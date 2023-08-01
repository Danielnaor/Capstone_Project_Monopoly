/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author manske_905351
 */
public class Property extends Type implements Serializable {

    //Stores information for a given property
    private int location;
    private String name;
    private int cost;
    private int[] rent;//Array with values pulled from file, selected based on upgrade level
    private Color color;
    private String ColorName;
    private int Mortgage;
    private boolean isMortgaged;
    private int upgradeLevel;
    private int upgradeCost;
    private Player owner;
    private String typeName = "Property";

    public String getTypeName() {
        return typeName;
    }

    public Property(int location, String name, int cost, int[] rent, Color color, String ColorName, int Mortgage, boolean isMortgaged, int upgradeLevel, int upgradeCost, Player owner) {
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.color = color;
        this.ColorName = ColorName;
        this.Mortgage = Mortgage;
        this.isMortgaged = isMortgaged;
        this.upgradeLevel = upgradeLevel;
        this.upgradeCost = upgradeCost;
        this.owner = owner;
    }

    public int getLocation() {
        return location;
    }

    public String getColorName() {
        return ColorName;
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

    public int getRent(int num) {
        return rent[num];
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

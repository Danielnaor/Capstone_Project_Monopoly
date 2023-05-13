/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author manske_905351
 */
class Player {
    private int playerNum;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int balance;
    private int location;
    private int previousLocation = 0;
    private int getOutOfJailCards = 0;
    private boolean bankrupt;
    private boolean inJail;
    private int jailRoll;
    private Color color;
  

    public Player(int playerNum, ArrayList<Tile> tiles, int balance, int location, boolean bankrupt, boolean inJail, int jailRoll,Color color) {
        this.playerNum = playerNum;
        this.tiles = tiles;
        this.balance = balance;
        this.location = location;
        this.bankrupt = bankrupt;
        this.inJail = inJail;
        this.jailRoll = jailRoll;
        this.color = color;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getGetOutOfJailCards() {
        return getOutOfJailCards;
    }

    public void setGetOutOfJailCards(int getOutOfJailCards) {
        this.getOutOfJailCards = getOutOfJailCards;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getJailRoll() {
        return jailRoll;
    }

    public void setJailRoll(int jailRoll) {
        this.jailRoll = jailRoll;
    }
    
    public int getPreviousLocation(){
        
        return previousLocation;
        
    }

    public void setPreviousLocation(int previousLocation) {
        this.previousLocation = previousLocation;
    }
    
    public int changeBalance(int num){
                              
             
        balance += num;
                        
                       

        return balance;
        
    }
    
    public int changeJailRoll(int num){
        
        return jailRoll + num;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
   
    
}

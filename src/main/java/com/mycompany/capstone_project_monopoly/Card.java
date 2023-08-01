/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

/**
 *
 * @author manske_905351
 */
class Card {

    /*
        Defines the cards for the game
     */
    private String text;
    private boolean getOutOfJailCard;
    private int location;
    private int money;

    public Card(String text, boolean getOutOfJailCard, int location, int money) {
        this.text = text;
        this.getOutOfJailCard = getOutOfJailCard;
        this.location = location;
        this.money = money;
    }

    public String getText() {
        //returns the text of the card
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isGetOutOfJailCard() {
        //returns whether or not the card is a get out of jail free card
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(boolean getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }

    public int getLocation() {
        //returns the location associated with the card
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMoney() {
        //returns the quantity of money tied to the card
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

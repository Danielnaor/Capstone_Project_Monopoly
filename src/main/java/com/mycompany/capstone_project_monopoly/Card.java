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
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(boolean getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

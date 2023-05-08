/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

/**
 *
 * @author manske_905351
 */
public class Chance extends Type{
    private Card[] cards;
   private String typeName = "Chance";


    public Chance(Card[] cards) {
        this.cards = cards;
    }
     public Card getCard(int num) {
        return cards[num];
    }

    public String getTypeName() {
        return typeName;
    }
     
    @Override
    public String toString() {
        return "Chance";
    }
}
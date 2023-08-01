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
public class Tax extends Type implements Serializable {

    //stores information for a given tax tile
    private int location;
    private String name;
    private int taxValue;
    private String typeName = "Tax";

    public Tax(int location, String name, int taxValue) {
        this.location = location;
        this.name = name;
        this.taxValue = taxValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public int getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(int taxValue) {
        this.taxValue = taxValue;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "Tax";
    }

}

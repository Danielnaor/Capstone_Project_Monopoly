/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

/**
 *
 * @author manske_905351
 */
class Tile {
    private int location;
    private Type type;
    String name;
    int x;
    int y;
    int width;
    int height;
    Integer numTileOccupied;
    Integer[] PlayerOccupying;
    
    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Type getType() {
        return type;
    }
    public String getTypeName(){
        
        return "" + type;
        
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tile(int location, Type type, String name) {
        this.location = location;
        this.type = type;
        this.name = name;
    }

    
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    

    public Integer[] getPlayerOccupying() {
        return PlayerOccupying;
    }

    public void setPlayerOccupying(Integer[] PlayerOccupying) {
        this.PlayerOccupying = PlayerOccupying;
    }

    public Integer getNumTileOccupied() {
        return numTileOccupied;
    }

    public void setNumTileOccupied(Integer numTileOccupied) {
        this.numTileOccupied = numTileOccupied;
    }

    
    
    

    

    
    
}
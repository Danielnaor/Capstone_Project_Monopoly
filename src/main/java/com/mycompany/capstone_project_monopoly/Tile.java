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
        
        String typenameFull = "" + type;
        
        
        try{
            int index = typenameFull.indexOf("{");
            return typenameFull.substring(0,index);
        }catch (Exception e){
            return  "" + type;

        }
        
        
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author carmitnaor
 */
public class Datafactory {
    private HashMap<Integer, Tile> tiles;
    private HashMap<Integer, Property> Properties;
    private HashMap<Integer, Tax> Taxes;
    private HashMap<Integer, Railroad> Railroads;
        private HashMap<Integer, Utility> Utilities;

    

    public Datafactory() {
        BuildProperties();
        BuildTaxes();
        BuildRailroads();
        BuildUtility();
        
    }
    
    
    public void BuildProperties(){
        try{
                        Properties = new HashMap<Integer, Property>();
                        Scanner file = new Scanner(new File("data" + File.separator + "properties.txt"));
                        file.nextLine();
                        while (file.hasNextLine()) {
                
                        String lineData = file.nextLine();
               
                        Scanner line = new Scanner(lineData);
                        line.useDelimiter("\t");
                
                      
                        int location = Integer.parseInt(line.next()); 
                        String name = line.next(); 
                        int cost = Integer.parseInt(line.next());
                        
                        int[] rent = new int[6];
                        
                        rent[0] = Integer.parseInt(line.next()); 
                        rent[1] = Integer.parseInt(line.next());
                        rent[2] = Integer.parseInt(line.next()); 
                        rent[3] = Integer.parseInt(line.next()); 
                        rent[4] = Integer.parseInt(line.next()); 
                        rent[5] = Integer.parseInt(line.next()); 

                Color color = Color.decode("#" + line.next()); 
                int Mortgage = Integer.parseInt(line.next()); 
                String isMortgagedString =  line.next();  
                boolean isMortgaged;
                if (isMortgagedString.toUpperCase().equals("FALSE")){
                          isMortgaged = false;

                }
                else{
                      isMortgaged = true;

                }
                    System.out.println(isMortgaged);
                     int upgradeLevel = Integer.parseInt(line.next()); 
                     int upgradeCost = Integer.parseInt(line.next());
                     String ownerString = line.next();
                     
                     
                    Player owner =null;

               //int location, String name, int cost, int[] rent, Color color, int Mortgage, boolean isMortgaged, int upgradeLevel, int upgradeCost, Player owner
               Property property  = new Property(location, name,  cost, rent,  color,  Mortgage,  isMortgaged,  upgradeLevel,  upgradeCost,  owner);
                     
                Properties.put(location, property);
    
                
            }
                        
            for(Entry<Integer, Property> entry: Properties.entrySet()) {
                      System.out.println(entry);

            }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }

    public void BuildTaxes(){
        try{
                        Taxes = new  HashMap<Integer,Tax>() ;

                        Scanner file = new Scanner(new File("data" + File.separator + "taxes.txt"));
                        file.nextLine();
                        while (file.hasNextLine()) {
                
                        String lineData = file.nextLine();
               
                        Scanner line = new Scanner(lineData);
                        line.useDelimiter("\t");
                
                      
                        int location = Integer.parseInt(line.next()); 
                        String name = line.next(); 
                        int taxValue = Integer.parseInt(line.next());
                        
                        
                
                
                 

               //int location, String name, int cost, int[] rent, Color color, int Mortgage, boolean isMortgaged, int upgradeLevel, int upgradeCost, Player owner
               Tax tax  = new Tax(location, name, taxValue);
                     
                Taxes.put(location, tax);
    
                
            }
                        
            for(Entry<Integer, Tax> entry: Taxes.entrySet()) {
                      System.out.println(entry);

            }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }
    
        public void BuildRailroads(){
        try{
                        Railroads = new HashMap<Integer, Railroad>();
                        Scanner file = new Scanner(new File("data" + File.separator + "Railroad.txt"));
                        file.nextLine();
                        while (file.hasNextLine()) {
                
                            String lineData = file.nextLine();
               
                            Scanner line = new Scanner(lineData);
                            line.useDelimiter("\t");
                
                      
                            int location = Integer.parseInt(line.next()); 
                            String name = line.next(); 
                            int cost = Integer.parseInt(line.next());
                        
                        int[] rent = new int[4];
                        
                        rent[0] = Integer.parseInt(line.next()); 
                        rent[1] = Integer.parseInt(line.next());
                        rent[2] = Integer.parseInt(line.next()); 
                        rent[3] = Integer.parseInt(line.next()); 
                       

                int Mortgage = Integer.parseInt(line.next()); 
                String isMortgagedString =  line.next();  
                boolean isMortgaged;
                if (isMortgagedString.toUpperCase().equals("FALSE")){
                          isMortgaged = false;

                }
                else{
                      isMortgaged = true;

                }
                    System.out.println(isMortgaged);
                     String ownerString = line.next();
                     
                     
                    Player owner =null;

               //int location, String name, int cost, int[] rent, Color color, int Mortgage, boolean isMortgaged, int upgradeLevel, int upgradeCost, Player owner
               Railroad railroad  = new Railroad(location, name,  cost, rent,  Mortgage,  isMortgaged,  owner);
                     
                Railroads.put(location, railroad);
    
                
            }
                        
            for(Entry<Integer, Railroad> entry: Railroads.entrySet()) {
                      System.out.println(entry);

            }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }

    
        public void BuildUtility(){
        try{
                        Utilities = new HashMap<Integer, Utility>();
                        Scanner file = new Scanner(new File("data" + File.separator + "Utility.txt"));
                        file.nextLine();
                        while (file.hasNextLine()) {
                
                        String lineData = file.nextLine();
               
                        Scanner line = new Scanner(lineData);
                        line.useDelimiter("\t");
                
                      
                        int location = Integer.parseInt(line.next()); 
                        String name = line.next(); 
                        int cost = Integer.parseInt(line.next());
                        int Mortgage = Integer.parseInt(line.next()); 

                        int[] rentRate = new int[2];
                        
                        rentRate[0] = Integer.parseInt(line.next()); 
                        rentRate[1] = Integer.parseInt(line.next());
                                        String isMortgagedString =  line.next();  
                boolean isMortgaged;
                if (isMortgagedString.toUpperCase().equals("FALSE")){
                          isMortgaged = false;

                }
                else{
                      isMortgaged = true;

                }
                    System.out.println(isMortgaged);
                     
                     String ownerString = line.next();
                     
                     
                    Player owner =null;

               Utility utility  = new Utility( location,  name,  cost,  Mortgage, rentRate,  isMortgaged,  owner);
                     
                Utilities.put(location, utility);
    
                
            }
                        
            for(Entry<Integer, Utility> entry: Utilities.entrySet()) {
                      System.out.println(entry);

            }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }

    
    }


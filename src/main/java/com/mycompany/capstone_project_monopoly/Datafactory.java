/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private HashMap<Integer, Other> OtherTempo;
    private HashMap<Integer, Chance> Chance; //AndCommunityChest
     private HashMap<Integer, CommunityChest> CommunityChest;
        private Card[] chancecards;
    private Card[] cChestCards;

  


    
    public Datafactory(Card[] chancecards, Card[] cChestCards) {
        this.chancecards = chancecards;
        this.cChestCards = cChestCards;
        BuildProperties();
        BuildTaxes();
        BuildRailroads();
        BuildUtility();
        BuildOther();
        BuildChance();
        BuildCommunityChest();
        BuildTiles();
        
        
        
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
        //            System.out.println(isMortgaged);
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
        //            System.out.println(isMortgaged);
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
            //        System.out.println(isMortgaged);
                     
                     String ownerString = line.next();
                     
                     
                    Player owner =null;

               Utility utility  = new Utility( location,  name,  cost,  Mortgage, rentRate,  isMortgaged,  owner);
                     
                Utilities.put(location, utility);
    
                
            }
                        
 //           for(Entry<Integer, Utility> entry: Utilities.entrySet()) {
   //                   System.out.println(entry);

     //       }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }
        
    public void BuildOther(){
         try{
             //        private HashMap<Integer, Other> OtherTempo;

                        OtherTempo = new  HashMap<Integer, Other>();

                        Scanner file = new Scanner(new File("data" + File.separator + "otherTEMPO.txt"));
                        file.nextLine();
                        while (file.hasNextLine()) {
                
                        String lineData = file.nextLine();
               
                        Scanner line = new Scanner(lineData);
                        line.useDelimiter("\t");
                
                      
                        int location = Integer.parseInt(line.next()); 
                        String name = line.next(); 
                        String isInJailString =  line.next();  
                boolean isInJail;
                if (isInJailString.toUpperCase().equals("FALSE")){
                          isInJail = false;

                }
                else{
                      isInJail = true;

                }
                //    System.out.println(isInJail);
                     String playerString = line.next();                          
                     Player player =null;
                
                Other othertempoitem  = new Other(location, name,isInJail,player);
                OtherTempo.put(location, othertempoitem);
                 

                     
    
                
            }
                        
           for(Entry<Integer, Other> entry: OtherTempo.entrySet()) {
                      System.out.println(entry);

            }
                        
                        
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: tiles dat file not found");
            
        }
    }

    public void BuildChance(){
        // 8 , 23, 37
        
              Chance = new HashMap<Integer, Chance>();
              
              ArrayList<Integer> tilenums = new ArrayList<Integer>();
              tilenums.add(8);
            tilenums.add(23);
              tilenums.add(37);
              
              String name = "chanceCards";
              //chanceCards
              
              for(int index:tilenums){
                                Chance chance = new Chance(chancecards);
                                Chance.put(index,chance); 
              }
                            



    }
    
     public void BuildCommunityChest(){
        // 3 , 18, 34
        
              CommunityChest = new HashMap<Integer, CommunityChest>();
              
              ArrayList<Integer> tilenums = new ArrayList<Integer>();
              tilenums.add(3);
            tilenums.add(18);
              tilenums.add(34);
              
              String name = "CommunityChest";
              //CommunityChest
              
              for(int index:tilenums){
                                CommunityChest communityChest = new CommunityChest(cChestCards);
                                
                                
                                
                                CommunityChest.put(index,communityChest); 
              }
                            



    }
    
    
    
    
    
    
    
    
    
    public void BuildTiles(){
           tiles = new HashMap<Integer, Tile>();
  
        
        for(int searchKey = 1; searchKey < 41; searchKey++){
            System.out.println(searchKey);
            Type type = null;
            String Name ="";
     

        // check if any of the HashMaps contains the key
        boolean keyFound = false;
                   

        if (Properties.containsKey(searchKey) || Taxes.containsKey(searchKey) || Railroads.containsKey(searchKey) || Utilities.containsKey(searchKey) || OtherTempo.containsKey(searchKey) ||  CommunityChest.containsKey(searchKey) || Chance.containsKey(searchKey)) {
            keyFound = true;
        }

// print the result
if (keyFound) {
    //System.out.println("At least one HashMap contains the key " + searchKey);
    
            if (Properties.containsKey(searchKey)) {
                type = Properties.get(searchKey);
                Name = Properties.get(searchKey).getName();
              //  // System.out.println(Name);
              //// System.out.println(Name);
            } else if (Taxes.containsKey(searchKey)) {
                type = Taxes.get(searchKey);
                Name = Taxes.get(searchKey).getName();
              // // System.out.println(Name);
                //              // System.out.println(Name);

            } else if (Railroads.containsKey(searchKey)) {
                type = Railroads.get(searchKey);
                Name = Railroads.get(searchKey).getName();
                // System.out.println(Name);
                              // System.out.println(Name);

            } else if (Utilities.containsKey(searchKey)) {
                type = Utilities.get(searchKey);
                Name = Utilities.get(searchKey).getName();
                // System.out.println(Name);
                              // System.out.println(Name);

            } else if (OtherTempo.containsKey(searchKey)) {
                type = OtherTempo.get(searchKey);
                Name = OtherTempo.get(searchKey).getName();
                // System.out.println(Name);
                              // System.out.println(Name);

            }
            
            
            // || Chance.containsKey(searchKey)
            else if (CommunityChest.containsKey(searchKey)){
                type = CommunityChest.get(searchKey);
                Name = "CommunityChest";
                // System.out.println(Name);
                              // System.out.println(Name);
            }
            
            else if (Chance.containsKey(searchKey)){
                type = Chance.get(searchKey);
                Name = "Chance";
                // System.out.println(Name);
              // System.out.println(Name);
            }
                     Tile tile = new Tile(searchKey, type, Name );
                     tiles.put(searchKey,tile);
            
} else {
    System.out.println("None of the HashMaps contains the key " + searchKey);
}

     
     
     
            
            
            
        }
        
        for(Entry<Integer, Tile> entry: tiles.entrySet()) {
                      System.out.println(entry);

            }
    }
           
    public HashMap<Integer, Tile> getTiles() {
        return tiles;
    }
}


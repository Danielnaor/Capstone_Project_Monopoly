/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author manske_905351
 */
public class GraphicPanel extends JPanel {

    private HashMap<Integer, Player> players;

    private HashMap<Integer, Tile> tiles;
    
    
    
    
    private int PlayerChangingLocation;
    public void processData(HashMap<Integer, Player> Players, HashMap<Integer, Tile> tiles) {

        this.players = Players;
        this.tiles = tiles;
        PlayerChangingLocation = -1;
        // Call repaint to call paint, update, and paintComponent methods
        System.out.println("GraphicPanel");
        repaint();
    }
    

    
    public void processData(HashMap<Integer, Player> Players, HashMap<Integer, Tile> tiles, int PlayerChangingLocation) {

        this.players = Players;
        this.tiles = tiles;
        this.PlayerChangingLocation = PlayerChangingLocation;
        // Call repaint to call paint, update, and paintComponent methods
        System.out.println("GraphicPanel");
        repaint();
    }

    
 /*   @Override

   protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.setColor(RED);
              // g.drawRect(getWidth()-10, 0, 100, 100);
             
             Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(10));
                
   }
    */
    
    
    
    
   
   
    @Override

   protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        // the dimensions of the game board from CSV 
        double gameBoardWidth = 2600.0;
        double gameBoardHeight = 2600.0;

        // the dimensions of the JPanel 
        double panelWidth = (double) getWidth();
        double panelHeight = (double) getHeight();

        
        
      
        // the scale factor to scale the game board to the JPanel
        double scaleFactor = Math.min(panelWidth / gameBoardWidth, panelHeight / gameBoardHeight);

        boolean train = false;
        boolean go = false;
        boolean chance = false;

        try {
            Scanner file = new Scanner(new File("data" + File.separator + "graphiclocations.txt"));

            file.nextLine(); // skip the first line of the file

            // loop while the file has more lines
            while (file.hasNextLine()) {

                String lineData = file.nextLine(); // the next line of the file
                Scanner line = new Scanner(lineData); //   scanner within the line
                line.useDelimiter("\t");

                // read the data from the line and get the values for the variables: name, x, y, width, height, and color
                int tileNum = Integer.parseInt(line.next());
                String name = line.next();
                int x = Integer.parseInt(line.next());
                int y = Integer.parseInt(line.next());
                int width = Integer.parseInt(line.next());
                int height = Integer.parseInt(line.next());
                Color colortile = Color.decode("#" + line.next());
                int coloredPartX = Integer.parseInt(line.next());
                int coloredPartY = Integer.parseInt(line.next());
                int coloredwidth = Integer.parseInt(line.next());
                int coloredheight = Integer.parseInt(line.next());
                Color color = Color.decode("#" + line.next());

                if (((x == 1200 && y == 2200) || (x == 0 && y == 1200) || (x == 1200 && y == 0) || (x == 2200 && y == 1200)) && (tileNum == 6 || tileNum == 16 || tileNum == 26 || tileNum == 36)) {
                    train = true;
                }

                // if the tile is the go tile then boolean go = true
                if (x == 2200 && y == 2200 && tileNum == 1) {
                    go = true;
                }

                // if the tile is a chance tile then boolean chance = true    2200	1400
                if (((x == 800 && y == 2200) || (x == 600 && y == 0) || (x == 2200 && y == 1400)) && (tileNum == 8 || tileNum == 23 || tileNum == 37)) {
                    chance = true;
                }

                // scale the x, y, width, and height values
                x = (int) (x * scaleFactor);
                y = (int) (y * scaleFactor);
                width = (int) (width * scaleFactor);
                height = (int) (height * scaleFactor);
                coloredPartX = (int) (coloredPartX * scaleFactor);
                coloredPartY = (int) (coloredPartY * scaleFactor);
                coloredwidth = (int) (coloredwidth * scaleFactor);
                coloredheight = (int) (coloredheight * scaleFactor);

                // create a new Graphics2D object based on the Graphics object
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.scale(scaleFactor, scaleFactor);
                // set the color of the Graphics2D object
                g2d.setColor(colortile);

                // draw the tiles
                g2d.fillRect(x, y, width, height);

                g2d.setColor(color);

                g2d.fillRect(coloredPartX, coloredPartY, coloredwidth, coloredheight);

                if (train) {
                    Image trainSymbol = getToolkit().getImage("symbols" + File.separator + "trainmenopoly.png");
                    // scale the image and put it in the middle of the rectangle which drawned with the coordinates x and y and the width and height
                    if (tileNum == 6) {
                        g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                    } // else if the tile is 16 then rotate the image 90 degrees and draw it in the middle of the rectangle
                    else if (tileNum == 16) {
                        g2d.rotate(Math.toRadians(90), x + width / 2, y + height / 2);
                        g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                        g2d.rotate(Math.toRadians(-90), x + width / 2, y + height / 2);
                    } // else if the tile is 26 then rotate the image 180 degrees and draw it in the middle of the rectangle
                    else if (tileNum == 26) {
                        g2d.rotate(Math.toRadians(180), x + width / 2, y + height / 2);
                        g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                        g2d.rotate(Math.toRadians(-180), x + width / 2, y + height / 2);
                    } // else if the tile is 36 then rotate the image 270 degrees and draw it in the middle of the rectangle
                    else if (tileNum == 36) {
                        g2d.rotate(Math.toRadians(270), x + width / 2, y + height / 2);
                        // the image will be a rectangle as well and will be drawn in the middle of the rectangle drawen with the coordinates x and y and the width and height

                        g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                        g2d.rotate(Math.toRadians(-270), x + width / 2, y + height / 2);
                    }

                    train = false;
                } else if (chance) {

                    Image chanceSymbol = getToolkit().getImage("symbols" + File.separator + "chance.png");

                    if (tileNum == 8) {

                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 47, (y) + height / 2 - 100, (int) (173 * scaleFactor), (int) (347 * scaleFactor), this);

                    } // else if the tile is 23 then rotate the image 180 degrees and draw it in the middle of the rectangle
                    else if (tileNum == 23) {
                        g2d.rotate(Math.toRadians(180), x + width / 2, y + height / 2);

                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 45, (y) + height / 2 - 100, (int) (173 * scaleFactor), (int) (347 * scaleFactor), this);

                        g2d.rotate(Math.toRadians(-180), x + width / 2, y + height / 2);
                    } else if (tileNum == 37) {
                        g2d.rotate(Math.toRadians(270), x + width / 2, y + height / 2);

                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 45, (y) + height / 2 - 100, (int) (173 * scaleFactor), (int) (347 * scaleFactor), this);

                        g2d.rotate(Math.toRadians(-270), x + width / 2, y + height / 2);
                    }

                    chance = false;

                } else if (go) {
                    Image goSymbol = getToolkit().getImage("symbols" + File.separator + "go.png");

                    g2d.drawImage(goSymbol, (int) (2179.18065 * scaleFactor), y + height / 2 - 125, (int) (433.3333 * scaleFactor), (int) (433.3333 * scaleFactor), this);

                    go = false;
                }

                // draw the outline of the tiles
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(x, y, width, height);

                
               
                Tile tileBuild = tiles.get(tileNum);
                if(tileBuild.getNumTileOccupied()==null){
                    
                    tileBuild.setNumTileOccupied(0);
                    
                }
                else{
                  //  System.out.println(tileBuild.getNumTileOccupied());
                }
                
                if(tileBuild.getPlayerOccupying() == null ){
                    Integer[] PlayerOccupyingTemp = {-1,-1,-1,-1};
                    tileBuild.setPlayerOccupying(PlayerOccupyingTemp);
                }
                
                tileBuild.setX(x);
                tileBuild.setY(y);
                tileBuild.setHeight(height);
                tileBuild.setWidth(width);
                
                
                tiles.put(tileNum, tileBuild);
                
                
                
                
                
                
               
                g2d.dispose();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
       
        
        if (players != null && players.keySet() != null ) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.scale(scaleFactor, scaleFactor);
            
            int xOffsetsCornor[] = {0, 0, -50, -50};
            int yOffsetsCornor[] = {0, -50, 0, -50};
            
            int[] xOffsetSides = new int[]{0,-50,50};
            int[] yOffsetSides = new int[]{0,0,0}; ;
            
            int[] xOffsetsTopButtom = new int[]{0,0,0};
            int[] yOffsetsTopButtom = new int[]{0,-50,50};
            
            

               
                
                
                
               
            
            
            for(Integer key: players.keySet()){
               
                Player currentPlayer = players.get(key);
            
                int currentPlayerLocation = currentPlayer.getLocation();
                
                Tile tile = tiles.get(currentPlayer.getLocation());
                
               
                int i = tile.getNumTileOccupied();
            
                  
              
                    
                    System.out.println("i is " + i);
                    
                    
                    int x = tile.getX();
                    int y = tile.getY();
                    int width = tile.getWidth();
                    int height = tile.getHeight();
                    
                    // thats spaicel case;
               if(i == 4){
                    System.out.println("i is 4 for tile: " + currentPlayer.getLocation());
                    xOffsetSides = new int[]{-50,-50,50,50};
                     yOffsetSides = new int[]{-22,22,-22,22};


                    xOffsetsTopButtom = new int[]{-22,22,-22,22};
                    yOffsetsTopButtom = new int[]{-50,-50,50,50};

                   if(x==y){    
                        for (i = 0; i < 4; i++) {
                            g2d.setColor(players.get(i+1).getColor());
                            g2d.setPaint(players.get(i+1).getColor());

                           // System.out.println("color is" + players.get(i+1).getColor());

                            g2d.fillOval(x + width / 2 - 25 + xOffsetsCornor[i], y + height / 2 - 25 + yOffsetsCornor[i], 50, 50);
                        }
                        
                       
                   }
                   else if(width>height){
                    
                       for (i = 0; i < 4; i++) {
                            g2d.setColor(players.get(i+1).getColor());
                            g2d.setPaint(players.get(i+1).getColor());

                         //   System.out.println("color is" + players.get(i+1).getColor());

                            g2d.fillOval(x + width / 2 - 25 + xOffsetSides[i], y + height / 2 - 25 + yOffsetSides[i], 50, 50);
                        }  
                       
                       
                       
                       
                   }
                   
                   else if(width<height){
                       System.out.println(x<y);
                   }
                   else{
                       System.out.println("error with 4 on same tile");
                   }
                   break;
               }
               
               else if(i == 0){
                   System.out.println("i = 0");
                int numOccuping = tile.getNumTileOccupied() + 1;
                tile.setNumTileOccupied(numOccuping);

                Integer[] playerOccupying = tile.getPlayerOccupying();
                playerOccupying[0] = key;
                tile.setPlayerOccupying(playerOccupying);
                tiles.put(currentPlayerLocation, tile);
                
                g2d.setColor(players.get(key).getColor());
                g2d.setPaint(players.get(key).getColor());
                
                g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);


                
               }
               else if( i == 2 || i == 1 || i == 3){
                   
                    int numOccuping = tile.getNumTileOccupied() + 1;
                    tile.setNumTileOccupied(numOccuping);
                    Integer[] playerOccupying = tile.getPlayerOccupying();
                    System.out.println("playerOccuping arrayb when i = 1 or i = 2 " + Arrays.toString(playerOccupying));

                playerOccupying[i] = key;
                                    System.out.println("playerOccuping array when i = 1 or i = 2" + Arrays.toString(playerOccupying));

                tile.setPlayerOccupying(playerOccupying);
                tiles.put(currentPlayerLocation, tile);
                
                g2d.setColor(players.get(key).getColor());
                g2d.setPaint(players.get(key).getColor());
                if(i == 3){
                    i--;
                    g2d.fillOval(x + width / 2 - 25 + xOffsetsTopButtom[i], y + height / 2 - 25 + yOffsetsTopButtom[i], 50, 50);
                    i++;
                }
                else{
                g2d.fillOval(x + width / 2 - 25 + xOffsetsTopButtom[i], y + height / 2 - 25 + yOffsetsTopButtom[i], 50, 50);
                }
               }
                
                
               else{
                   System.out.println("error with 4 on same tile");

                     

                  
               }
                    
                
                
                
                
                
                
            }
  
           
  
  
  
  
  
  
  
  
            /*        boolean doublePairs;
            for (Integer key : players.keySet()) {
                int x;
                int y;
                int width;
                int height;

                Integer[] Locations = new Integer[players.size()];
                for (int key2 : players.keySet()) {
                    Locations[key2 - 1] = (players.get(key2).getLocation());
                }
                Set<Integer> locations = new HashSet<Integer>(Arrays.asList(Locations));
                // logic to move the draw if there are multiple players on the same one
                // this will determine if the any players are on the same tile

                if (locations.size() == Locations.length) {
                    g2d.setPaint(players.get(key).getColor());
                    x = tilelocationsXYandSize.get(players.get(key).getLocation()).getX();
                    y = tilelocationsXYandSize.get(players.get(key).getLocation()).getY();
                    width = tilelocationsXYandSize.get(players.get(key).getLocation()).getWidth();
                    height = tilelocationsXYandSize.get(players.get(key).getLocation()).getHeight();
                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);
                }
                else{
                    int playerLocation = players.get(key).getLocation();
                    boolean[] AreasOccupiedOnBlock = tilelocationsXYandSize.get(playerLocation).getTileOccupied();
                    
                    int i =0;
                    while(!AreasOccupiedOnBlock[i] ){
                        numocuping++;
                        
                    }
                        
                }

            }
            
                ArrayList<Integer> OnSameOnes;
                int numOnSameOne;
                Integer[] Locations = new Integer[players.size()];

                for (int key2 : players.keySet()) {
                    Locations[key2 - 1] = (players.get(key2).getLocation());

                }

                Set<Integer> locations = new HashSet<Integer>(Arrays.asList(Locations));
                // logic to move the draw if there are multiple players on the same one

                if (locations.size() == Locations.length) {
                    g2d.setPaint(players.get(key).getColor());
                    x = tilelocationsXYandSize.get(players.get(key).getLocation()).getX();
                    y = tilelocationsXYandSize.get(players.get(key).getLocation()).getY();
                    width = tilelocationsXYandSize.get(players.get(key).getLocation()).getWidth();
                    height = tilelocationsXYandSize.get(players.get(key).getLocation()).getHeight();
                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);
                } else {
                    numOnSameOne = (players.size() - locations.size()) + 1;

                    // this will only be true if it is a cornor
                    for (int tileindex = 0; tileindex < Locations.length; tileindex++) {
                        x = tilelocationsXYandSize.get(Locations[tileindex]).getX();
                        y = tilelocationsXYandSize.get(Locations[tileindex]).getY();
                        width = tilelocationsXYandSize.get(Locations[tileindex]).getWidth();
                        height = tilelocationsXYandSize.get(Locations[tileindex]).getHeight();
                        if (x == y) {
                            // if it is 2 player on the same tile
                            if (numOnSameOne == 2) {
                                // if it is 2 player on the same tile and there is only 2 players 
                                if (players.size() == 2) {
                                    System.out.println("size == 2");
                                    g2d.setPaint(players.get(key).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(players.get(1).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25 - 50, 50, 50);
                                    break;

                                } // if there are mote then 2 players 
                                else {
                                    int numPlayerMatch1 = 0;
                                    int numPlayerMatch2 = 0;
                                    boolean found = false;
                                    for (int index = 0; index < Locations.length; index++) {

                                        for (int index2 = index + 1; index2 < Locations.length; index2++) {
                                            //System.out.print(index);
                                            //  System.out.print( " " + index2);
                                            //  System.out.println(" " +( Locations[index] == Locations[index2]) + Locations[index] + " " + Locations[index2]);

                                            if (Locations[index] == Locations[index2]) {
                                                numPlayerMatch1 = index;
                                                numPlayerMatch2 = index2;

                                                found = true;
                                                break;

                                            }

                                        }
                                        if (found) {
                                            break;
                                        }

                                    }

                                    g2d.setColor(players.get(numPlayerMatch1).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(players.get(numPlayerMatch2).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25 - 50, 50, 50);
                                     HashMap<Integer, Player> newPlayers = new HashMap<Integer, Player>();
                                    for (int keyNew : players.keySet()) {
                                        System.out.println(numPlayerMatch1 + "\t" + numPlayerMatch2);
                                        
                                        if (((keyNew - 1) != numPlayerMatch1) && ((keyNew - 1) != numPlayerMatch2)) {
                                            System.out.println(keyNew);

                                            //g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                        }

                                    }

                                }

                            } else if (numOnSameOne == 3) {
                                System.out.println("3 on the same one");
                                if (players.size() == 3) {
                                    int yOffsets[] = {0, -50, 50};
                                    for (int i = 0; i < 3; i++) {
                                        g2d.setColor(players.get(i+1).getColor());
                                        g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25 + yOffsets[i], 50, 50);
                                    }

                                } // if there are mote then 2 players 
                                else {
                                    int numPlayerMatch1 = 0;
                                    int numPlayerMatch2 = 0;
                                    int numPlayerMatch3 = 0;
                                    boolean found = false;
                                    for (int index = 0; index < Locations.length; index++) {

                                        for (int index2 = index + 1; index2 < Locations.length; index2++) {
                                            for (int index3 = index2 + 1; index3 < Locations.length; index3++) {

                                                if (Locations[index] == Locations[index2] && Locations[index3] == Locations[index2]) {
                                                    numPlayerMatch1 = index;
                                                    numPlayerMatch2 = index2;
                                                    numPlayerMatch3 = index3;

                                                    found = true;
                                                    break;

                                                }
                                            }
                                        }
                                        if (found) {
                                            break;
                                        }

                                    }
            
            
                                    g2d.setColor(players.get(numPlayerMatch1).getColor());


                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(players.get(numPlayerMatch2).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25 - 50, 50, 50);

                                    g2d.setColor(players.get(numPlayerMatch3).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25 + 50, 50, 50);

                                    for (int keyNew : players.keySet()) {

                                        if (((keyNew - 1) != numPlayerMatch1) && ((keyNew - 1) != numPlayerMatch2) && ((keyNew - 1) != numPlayerMatch3)) {
                                            System.out.print("key" + (keyNew - 1));
                                            g2d.setColor(players.get(keyNew).getColor());
                                            x = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).x;
                                            y = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).y;
                                            width = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).width;
                                            height = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).height;

                                            g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                        }

                                    }

                                }

                            } else if (numOnSameOne == 4) {
                                System.out.println("4 on the same one - cornor");
                                if (players.size() == 4) {
                                    for (int i = 0; i < 4; i++) {
                                        g2d.setColor(players.get(i+1).getColor());
                                        g2d.setPaint(players.get(i+1).getColor());
                                        
                                        System.out.println("color is" + players.get(i+1).getColor());
                                        
                                        g2d.fillOval(x + width / 2 - 25 + xOffsets[i], y + height / 2 - 25 + yOffsets[i], 50, 50);
                                    }

                                    break;

                                } // if there are mote then 2 players 
                                else {

                                    System.out.println("error with size");

                                }

                            }

                        } 






                        // else (it is not a cornor)
                        else {
                            // if x > y we would modify x 
                            if (x > y) {
                                if (numOnSameOne == 2) {
                                // if it is 2 player on the same tile and there is only 2 players 
                                if (players.size() == 2) {
                                    System.out.println("size == 2");
                                    g2d.setColor(players.get(1).getColor());

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(players.get(2).getColor());

                                    g2d.fillOval(x + width / 2 - 25-50, y + height / 2 - 25 , 50, 50);
                                    break;

                                } // if there are mote then 2 players 
                                else {
                                    int numPlayerMatch1 = 0;
                                    int numPlayerMatch2 = 0;
                                    boolean found = false;
                                    for (int index = 0; index < Locations.length; index++) {

                                        for (int index2 = index + 1; index2 < Locations.length; index2++) {
                                                                                      if (Locations[index] == Locations[index2]) {
                                                numPlayerMatch1 = index;
                                                numPlayerMatch2 = index2;

                                                found = true;
                                                break;

                                            }

                                        }
                                        if (found) {
                                            break;
                                        }

                                    }

                                    g2d.setColor(players.get(numPlayerMatch1).getColor());

                                    g2d.fillOval(x + width / 2 - 25 , y + height / 2 - 25, 50, 50);

                                    g2d.setColor(players.get(numPlayerMatch2).getColor());

                                    g2d.fillOval(x + width / 2 - 25 -50, y + height / 2 - 25 , 50, 50);

                                    for (int keyNew : players.keySet()) {

                                      /*  if (((keyNew - 1) != numPlayerMatch1) && ((keyNew - 1) != numPlayerMatch2)) {
                                            System.out.print("key" + (keyNew - 1));
                                            g2d.setColor(colorPlayers.get(keyNew - 1));
                                            x = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).x;
                                            y = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).y;
                                            width = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).width;
                                            height = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).height;

                                            g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                        //}

                                    }

                                }

                            } else if (numOnSameOne == 3) {
                                System.out.println("3 on the same one");
                                if (players.size() == 3) {
                                   /* g2d.setColor(colorPlayers.get(0));

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(colorPlayers.get(1));

                                    g2d.fillOval(x + width / 2 - 25 -50, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(colorPlayers.get(2));

                                    g2d.fillOval(x + width / 2 - 25 + 50, y + height / 2 - 25, 50, 50);
                                    break;

                                } // if there are mote then 3 players 
                                else {
                                    int numPlayerMatch1 = 0;
                                    int numPlayerMatch2 = 0;
                                    int numPlayerMatch3 = 0;
                                    boolean found = false;
                                    for (int index = 0; index < Locations.length; index++) {

                                        for (int index2 = index + 1; index2 < Locations.length; index2++) {
                                            for (int index3 = index2 + 1; index3 < Locations.length; index3++) {

                                                if (Locations[index] == Locations[index2] && Locations[index3] == Locations[index2]) {
                                                    numPlayerMatch1 = index;
                                                    numPlayerMatch2 = index2;
                                                    numPlayerMatch3 = index3;

                                                    found = true;
                                                    break;

                                                }
                                            }
                                        }
                                        if (found) {
                                            break;
                                        }

                                    }

                              /*      g2d.setColor(colorPlayers.get(numPlayerMatch1));

                                    g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(colorPlayers.get(numPlayerMatch2));

                                    g2d.fillOval(x + width / 2 - 25 -50, y + height / 2 - 25, 50, 50);

                                    g2d.setColor(colorPlayers.get(numPlayerMatch3));

                                    g2d.fillOval(x + width / 2 - 25 +50, y + height / 2 - 25, 50, 50); */

                          //          for (int keyNew : players.keySet()) {

                                /*        if (((keyNew - 1) != numPlayerMatch1) && ((keyNew - 1) != numPlayerMatch2) && ((keyNew - 1) != numPlayerMatch3)) {
                                            System.out.println("key" + (keyNew - 1));
                                            g2d.setColor(colorPlayers.get(keyNew - 1));
                                            x = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).x;
                                            y = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).y;
                                            width = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).width;
                                            height = tilelocationsXYandSize.get(players.get(keyNew).getLocation()).height;

                                            g2d.fillOval(x + width / 2 - 25, y + height / 2 - 25, 50, 50);

                                      //  }

                                    }

                                }

                            } else if (numOnSameOne == 4) {
                                System.out.println("4 on the same one");
                              if (players.size() == 4) {
                                    int xOffsets[] = {0, 0, -50, -50};
                                    int yOffsets[] = {0, -50, 0, -50};
                                    for (int i = 0; i < 4; i++) {
                                        g2d.setColor(players.get(i+1).getColor());
                                        
                                        g2d.fillOval(x + width / 2 - 25 + xOffsets[i], y + height / 2 - 25 + yOffsets[i], 50, 50);
                                    }

                                    

                                    break;

                                } // if there are mote then 2 players 
                                else {

                                    System.out.println("error with size");

                                }

                            }
                            }
                           else if(x<y){
                            

                                
                            }
                            else{
                                System.out.println("error with x and y");
                            }
                        }
                    }

                }
            }
        }
       }*/

   //}
}
        

}

    

    public void setPlayerChangingLocation(int PlayerChangingLocation) {
        this.PlayerChangingLocation = PlayerChangingLocation;
    }

    public HashMap<Integer, Tile> getTiles() {
        return tiles;
    }

    public void setTiles(HashMap<Integer, Tile> tiles) {
        this.tiles = tiles;
    }
    
     
    
    
}
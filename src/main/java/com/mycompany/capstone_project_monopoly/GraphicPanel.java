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
public class GraphicPanel extends JPanel{

    private HashMap<Integer, Player> players;
    
   
    private final ArrayList<Color> colorPlayers = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW));
   
    public void processData(HashMap<Integer, Player> Players) {
       
       this.players = Players;
        // Call repaint to call paint, update, and paintComponent methods
        System.out.println("GraphicPanel");
            repaint();
    }
    
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

                            
                            if(((x ==1200 && y == 2200) || (x==0 && y == 1200) || (x==1200 && y == 0) || (x==2200 && y==1200)) && (tileNum == 6 || tileNum == 16 || tileNum == 26 || tileNum == 36) ){
                                train = true;
                            }
                            
                            // if the tile is the go tile then boolean go = true
                            if(x == 2200 && y == 2200 && tileNum == 1){
                                go = true;
                            }
                            
                            // if the tile is a chance tile then boolean chance = true    2200	1400
                            if(((x ==800 && y == 2200) || (x==600 && y == 0) || (x==2200 && y == 1400)) && (tileNum == 8 || tileNum == 23 || tileNum == 37) ){
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
                            
                            
                            g2d.fillRect(coloredPartX,coloredPartY,coloredwidth,coloredheight);
                            

                            if(train){
                                Image trainSymbol = getToolkit().getImage("symbols" + File.separator + "trainmenopoly.png");
                                // scale the image and put it in the middle of the rectangle which drawned with the coordinates x and y and the width and height
                                if(tileNum == 6){
                                g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                                }  

                                // else if the tile is 16 then rotate the image 90 degrees and draw it in the middle of the rectangle

                                else if(tileNum == 16){
                                    g2d.rotate(Math.toRadians(90), x + width / 2, y + height / 2);
                                    g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                                    g2d.rotate(Math.toRadians(-90), x + width / 2, y + height / 2);
                                }

                                // else if the tile is 26 then rotate the image 180 degrees and draw it in the middle of the rectangle

                                else if(tileNum == 26){
                                    g2d.rotate(Math.toRadians(180), x + width / 2, y + height / 2);
                                    g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                                    g2d.rotate(Math.toRadians(-180), x + width / 2, y + height / 2);
                                }

                                // else if the tile is 36 then rotate the image 270 degrees and draw it in the middle of the rectangle

                                else if(tileNum == 36){
                                    g2d.rotate(Math.toRadians(270), x + width / 2, y + height / 2);
                                    // the image will be a rectangle as well and will be drawn in the middle of the rectangle drawen with the coordinates x and y and the width and height
                                    
                                    g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                                    g2d.rotate(Math.toRadians(-270), x + width / 2, y + height / 2);
                                }

                            train = false;
                            }
                           
                            else if(chance){
                                
                                
                                
                                
                                
                                Image chanceSymbol = getToolkit().getImage("symbols" + File.separator + "chance.png");

                                if(tileNum == 8){
                                    
                                    

                                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 47 , (y ) + height / 2 - 100, (int)(173*scaleFactor), (int)(347*scaleFactor), this);
                                        
                                         
                               
                                }

                                // else if the tile is 23 then rotate the image 180 degrees and draw it in the middle of the rectangle
                                    
                                    else if(tileNum == 23){
                                        g2d.rotate(Math.toRadians(180), x + width / 2, y + height / 2);

                                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 45 , (y ) + height / 2 - 100, (int)(173*scaleFactor), (int)(347*scaleFactor), this);
                                        
                                        
                                      
                                        
                                        
                                        
                                        g2d.rotate(Math.toRadians(-180), x + width / 2, y + height / 2);
                                    }
                                    else if(tileNum == 37){
                                        g2d.rotate(Math.toRadians(270), x + width / 2, y + height / 2);

                                        g2d.drawImage(chanceSymbol, (x) + width / 2 - 45 , (y ) + height / 2 - 100, (int)(173*scaleFactor), (int)(347*scaleFactor), this);
                                        
                                        
                                      
                                        
                                        
                                        
                                        g2d.rotate(Math.toRadians(-270), x + width / 2, y + height / 2);
                                    }
                                
                                
                                
                                
                                chance = false;
                                

                            }












                            else if(go){
                                Image goSymbol = getToolkit().getImage("symbols" + File.separator + "go.png");

                                 g2d.drawImage(goSymbol, (int)(2179.18065*scaleFactor), y + height / 2 - 125, (int)(433.3333*scaleFactor), (int)(433.3333*scaleFactor), this);

                               
                            
                         
                            
                                go = false;
                            }

                            
                            
                                          
                            
                           // draw the outline of the tiles

                             g2d.setPaint(Color.BLACK);
                            g2d.setStroke(new BasicStroke(3));
                            g2d.drawRect(x, y, width, height);
                            
                            
                            
                            

                            if(players != null && players.keySet() != null){
                                
                                
                                
                                
                                
                                for (int key : players.keySet()) {
                                    
                                     if(tileNum == players.get(key).getLocation()){
                                         boolean MultipleOnSameBlock = false;
                                         int numOnSameOne = 0;
                                         Integer[] Locations = null;

                                         for (int key2 : players.keySet()) {
                                             Locations[key2] = (players.get(key2).getLocation());
                                         }
                                         
                                        Set<Integer> locations =  new HashSet<Integer>(Arrays.asList(Locations));                                       
                                         // logic to move the draw if there are multiple players on the same one
                                         
                                         
                                         if(locations.size() == Locations.length){
                                             g2d.setPaint(colorPlayers.get(key-1));
                                             g2d.fillOval(x + width / 2 - 25, y + height /2 -25 , 50, 50);  
                                         }
                                         
                                         else{
                                             if(players.size() == 2){
                                                 
                                             }
                                         }


                                         
                                     }
                                }
                            }

                           
                            
                            g2d.dispose(); 

                }
                                                       // g2d.scale(scaleFactor, scaleFactor);


        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
}














        
        
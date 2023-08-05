/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.SANS_SERIF;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.floor;
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

    public void processData(HashMap<Integer, Player> Players, HashMap<Integer, Tile> tiles) {
        // print what method called processData
        System.out.println("GraphicPanel processData was called by " + Thread.currentThread().getStackTrace()[2].getMethodName());
        this.players = Players;
        this.tiles = tiles;

        // Call repaint to call paint, update, and paintComponent methods
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

        // the scale factor for the game board
        double scaleFactor = Math.min(panelWidth / gameBoardWidth, panelHeight / gameBoardHeight); // scale factor to fit the game board to the JPanel

        // boolean variables for the different tiles
        boolean train = false;
        boolean go = false;
        boolean chance = false;
        boolean freeParking = false;
        boolean communityChest = false;
        boolean getOutOfJail = false;
        boolean jail = false;
        boolean waterUtility = false;
        boolean electricUtility = false;
        boolean luxuryTax = false;
        boolean IncomeTax = false;

        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        try {
            // read the data to draw the game board from the file graphiclocations.txt 
            Scanner file = new Scanner(new File("data" + File.separator + "graphiclocations.txt"));

            file.nextLine(); // skip the first line of the file

            // loop while the file has more lines
            while (file.hasNextLine()) {

                String lineData = file.nextLine(); // the next line of the file
                Scanner line = new Scanner(lineData); //   scanner within the line
                line.useDelimiter("\t");

                // read the data from the line and get the values for the variables: name, x, y, width, height, and color, and rotate degrees
                int tileNum = Integer.parseInt(line.next());
                line.next();
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
                int RotateDegrees = Integer.parseInt(line.next());

                // if the tile is one of the train tile then boolean train = true
                if (((x == 1200 && y == 2200) || (x == 0 && y == 1200) || (x == 1200 && y == 0) || (x == 2200 && y == 1200)) && (tileNum == 6 || tileNum == 16 || tileNum == 26 || tileNum == 36)) {
                    train = true;
                } // if the tile is the go tile then boolean go = true
                else if (x == 2200 && y == 2200 && tileNum == 1) {
                    go = true;
                } // if the tile is a chance tile then boolean chance = true    2200	1400
                else if (((x == 800 && y == 2200) || (x == 600 && y == 0) || (x == 2200 && y == 1400)) && (tileNum == 8 || tileNum == 23 || tileNum == 37)) {
                    chance = true;
                } // if the tile is the free parking tile then boolean freeParking = true
                else if (x == 0 && y == 0 && tileNum == 21) {
                    freeParking = true;
                } // if the tile is a community chest tile then boolean communityChest = true
                else if (((x == 1800 && y == 2200) || (x == 0 && y == 800) || (x == 2200 && y == 800)) && (tileNum == 3 || tileNum == 18 || tileNum == 34)) {
                    communityChest = true;
                } else if ((x == 2200 && y == 0) && tileNum == 31) { // if the tile is the get out of jail tile then boolean getOutOfJail = true
                    getOutOfJail = true;
                } else if ((x == 0 && y == 2200) && tileNum == 11) { // if the tile is the jail tile then boolean jail = true 
                    jail = true;
                } else if ((x == 1800 && y == 0) && tileNum == 29) { // if the tile is the water utility tile then boolean waterUtility = true
                    waterUtility = true;
                } else if ((x == 0 && y == 1800) && tileNum == 13) { // if the tile is the electric utility tile then boolean electricUtility = true
                    electricUtility = true;
                } else if ((x == 2200 && y == 1800) && tileNum == 39) { // if the tile is the luxury tax tile then boolean luxuryTax = true
                    luxuryTax = true;
                } else if ((x == 1400 && y == 2200) && tileNum == 5) { // if the tile is the income tax tile then boolean IncomeTax = true
                    IncomeTax = true;
                }

                // scale the x, y, width, and height values
                x = (int) (Math.ceil(x * scaleFactor));
                y = (int) (Math.ceil(y * scaleFactor));
                width = (int) (Math.ceil(width * scaleFactor));
                height = (int) (Math.ceil(height * scaleFactor));
                coloredPartX = (int) (Math.ceil(coloredPartX * scaleFactor));
                coloredPartY = (int) (Math.ceil(coloredPartY * scaleFactor));
                coloredwidth = (int) (Math.ceil(coloredwidth * scaleFactor));
                coloredheight = (int) (Math.ceil(coloredheight * scaleFactor));

                // create a new Graphics2D object based on the Graphics object
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.scale(scaleFactor, scaleFactor);

                // draw the outline of the tiles
                g2d.setColor(Color.black);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(x, y, width, height);

                g2d.setColor(colortile);

                // draw the tiles
                g2d.fillRect(x, y, width, height);

                g2d.setColor(color);

                g2d.fillRect(coloredPartX, coloredPartY, coloredwidth, coloredheight);

                // draw the images on the tiles if the tile is train, go, chance, free parking, community chest, get out of jail, jail, water utility, electric utility, luxury tax, or income tax
                if (train) {
                    Image trainSymbol = getToolkit().getImage("symbols" + File.separator + "trainmenopoly.png");
                    // scale the image and put it in the middle of the rectangle which drawned with the coordinates x and y and the width and height

                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                    g2d.drawImage(trainSymbol, x + width / 2 - 50, y + height / 2 - 50, 100, 100, this);
                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);

                    train = false;
                } else if (chance) {

                    Image chanceSymbol = getToolkit().getImage("symbols" + File.separator + "chance.png");

                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(chanceSymbol, (x) + width / 2 - ((int) ((200 * scaleFactor) / 2)), (y) + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);

                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    chance = false;

                } else if (go) {
                    Image goSymbol = getToolkit().getImage("symbols" + File.separator + "go.png");

                    g2d.drawImage(goSymbol, x + width / 2 - ((int) ((400 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (400 * scaleFactor), (int) (400 * scaleFactor), this);

                    go = false;
                } else if (freeParking) {
                    Image freeParkingSymbol = getToolkit().getImage("symbols" + File.separator + "freeParkingSymbol.png");

                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(freeParkingSymbol, (x) + width / 2 - ((int) ((400 * scaleFactor) / 2)), (y) + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (400 * scaleFactor), (int) (400 * scaleFactor), this);
                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    freeParking = false;

                } else if (communityChest) {

                    Image communityChestSymbol = getToolkit().getImage("symbols" + File.separator + "communityChestSymbol.png");

                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(communityChestSymbol, (x) + width / 2 - ((int) ((200 * scaleFactor) / 2)), (y) + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);
                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    communityChest = false;

                } else if (getOutOfJail) {
                    Image getOutOfJailSymbol = getToolkit().getImage("symbols" + File.separator + "getOutOfJailSymbol.png");

                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                    g2d.drawImage(getOutOfJailSymbol, x + width / 2 - ((int) ((400 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (400 * scaleFactor), (int) (400 * scaleFactor), this);
                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);

                    getOutOfJail = false;
                } else if (jail) {
                    Image JailSymbol = getToolkit().getImage("symbols" + File.separator + "JailSymbol.png");
                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(JailSymbol, x + width / 2 - ((int) ((400 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (400 * scaleFactor), (int) (400 * scaleFactor), this);
                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    jail = false;

                } else if (waterUtility) {

                    Image waterUtilitySymbol = getToolkit().getImage("symbols" + File.separator + "WaterWorksSymbol.png");
                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(waterUtilitySymbol, x + width / 2 - ((int) ((200 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);

                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    waterUtility = false;

                } else if (electricUtility) {

                    Image electricUtilitySymbol = getToolkit().getImage("symbols" + File.separator + "ElectricCompanySymbol.png");
                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                    g2d.drawImage(electricUtilitySymbol, x + width / 2 - ((int) ((200 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);

                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    electricUtility = false;

                } else if (luxuryTax) {

                    Image luxuryTaxSymbol = getToolkit().getImage("symbols" + File.separator + "LuxuryTaxSymbol.png");
                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(luxuryTaxSymbol, x + width / 2 - ((int) ((200 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);

                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    luxuryTax = false;
                } else if (IncomeTax) {

                    Image incomeTaxSymbol = getToolkit().getImage("symbols" + File.separator + "IncomeTaxSymbol.png");
                    g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);
                    g2d.drawImage(incomeTaxSymbol, x + width / 2 - ((int) ((200 * scaleFactor) / 2)), y + height / 2 - ((int) ((400 * scaleFactor) / 2)), (int) (200 * scaleFactor), (int) (400 * scaleFactor), this);

                    g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    IncomeTax = false;

                }
                // sabes the values of the tile to the tiles hashmap
                Tile tileBuild = tiles.get(tileNum);
                if (tileBuild.getNumTileOccupied() == null) {

                    tileBuild.setNumTileOccupied(0);
                }

                if (tileBuild.getPlayerOccupying() == null) {
                    Integer[] PlayerOccupyingTemp = {-1, -1, -1, -1};
                    tileBuild.setPlayerOccupying(PlayerOccupyingTemp);

                }

                tileBuild.setX(x);
                tileBuild.setY(y);
                tileBuild.setHeight(height);
                tileBuild.setWidth(width);
                tiles.put(tileNum, tileBuild);

                //draws the prices and houses 
                String tileGetTypeName = tileBuild.getTypeName();
                if (tileGetTypeName.indexOf("{") != -1) {
                    tileGetTypeName = tileGetTypeName.substring(0, tileGetTypeName.indexOf("{"));
                }

                switch (tileGetTypeName) {

                    case "Property" -> {
                        Tile CurrentTile = tiles.get(tileNum);

                        Property currentProperty = (Property) CurrentTile.getType();
                        g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                        Font font;
                        // chcek if font exists
                        if (Font.getFont("Trebuchet MS") != null) {
                            // set font to Trebuchet MS
                            font = new Font("Trebuchet MS", Font.PLAIN, 20);

                        } else {
                            // set font to default
                            font = new Font("Arial", Font.PLAIN, 20);

                        }

                        FontMetrics metrics = g.getFontMetrics(font);

                        String cost = "$" + currentProperty.getCost();

                        // Set the font
                        g2d.setFont(font);
                        // Draw the String
                        if (width > height) {

                            g2d.setColor(color.black);
                            // draw the string in the bottom middle of the tile

                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height + metrics.getHeight() + 20);

                            if (currentProperty.getUpgradeLevel() != 0) {
                                if (currentProperty.getUpgradeLevel() < 5) {
                                    String upgrade = currentProperty.getUpgradeLevel() + " houses";
                                    g2d.setFont(font);
                                    g2d.drawString(upgrade, (x + (width - metrics.stringWidth(upgrade)) / 2), y + metrics.getHeight() + 20);

                                } else if (currentProperty.getUpgradeLevel() == 5) {
                                    //Prints the number of upgrades a player has on a given property
                                    String upgrade = "1 hotel";
                                    g2d.setFont(font);
                                    g2d.drawString(upgrade, (x + (width - metrics.stringWidth(upgrade)) / 2), y + metrics.getHeight() + 20);
                                }
                            }
                        } else if (height > width) {
                            // draw the string in the bottom middle of the tile
                            g2d.setColor(color.black);
                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height - metrics.getHeight() + 10);

                            if (currentProperty.getUpgradeLevel() != 0) {
                                if (currentProperty.getUpgradeLevel() < 5) {
                                    String upgrade = currentProperty.getUpgradeLevel() + " houses";
                                    g2d.setFont(font);
                                    g2d.drawString(upgrade, (x + (width - metrics.stringWidth(cost)) / 2), y + metrics.getHeight() + 10);

                                } else if (currentProperty.getUpgradeLevel() == 5) {
                                    String upgrade = "1 hotel";
                                    g2d.setFont(font);
                                    g2d.drawString(upgrade, (x + (width - metrics.stringWidth(cost)) / 2), y + metrics.getHeight() + 10);
                                }
                            }
                        }

                        g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    }
                    case "Railroad" -> {
                        Tile CurrentTile = tiles.get(tileNum);
                        Railroad currentRailRoad = (Railroad) CurrentTile.getType();
                        g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                        Font font;

                        if (Font.getFont("Trebuchet MS") != null) {
                            font = new Font("Trebuchet MS", Font.PLAIN, 20);

                        } else {
                            // set font to default
                            font = new Font("Arial", Font.PLAIN, 20);

                        }

                        FontMetrics metrics = g.getFontMetrics(font);

                        String cost = "$" + currentRailRoad.getCost();

                        // Set the font
                        g2d.setFont(font);
                        // Draw the String
                        if (width > height) {

                            g2d.setColor(color.black);
                            // draw the string in the bottom middle of the tile

                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height + metrics.getHeight() + 20);
                        } else if (height > width) {
                            // draw the string in the bottom middle of the tile
                            g2d.setColor(color.black);
                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height - metrics.getHeight() + 10);
                        }

                        g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);
                    }
                    case "Utility" -> {
                        Tile CurrentTile = tiles.get(tileNum);

                        Utility currentUtility = (Utility) CurrentTile.getType();
                        g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                        Font font;

                        if (Font.getFont("Trebuchet MS") != null) {
                            font = new Font("Trebuchet MS", Font.PLAIN, 20);

                        } else {
                            // set font to default
                            font = new Font("Arial", Font.PLAIN, 20);

                        }

                        FontMetrics metrics = g.getFontMetrics(font);

                        String cost = "$" + currentUtility.getCost();

                        // Set the font
                        g2d.setFont(font);
                        // Draw the String
                        if (width > height) {

                            g2d.setColor(color.black);
                            // draw the string in the bottom middle of the tile

                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height + metrics.getHeight() + 20);
                        } else if (height > width) {
                            // draw the string in the bottom middle of the tile
                            g2d.setColor(color.black);
                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height - metrics.getHeight() + 10);
                        }

                        g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);

                    }
                    case "Tax" -> {
                        Tile CurrentTile = tiles.get(tileNum);

                        Tax currentTax = (Tax) CurrentTile.getType();
                        g2d.rotate(Math.toRadians(RotateDegrees), x + width / 2, y + height / 2);

                        Font font;

                        if (Font.getFont("Trebuchet MS") != null) {
                            font = new Font("Trebuchet MS", Font.PLAIN, 20);

                        } else {
                            // set font to default
                            font = new Font("Arial", Font.PLAIN, 20);

                        }

                        FontMetrics metrics = g.getFontMetrics(font);

                        String cost = "Pay $" + currentTax.getTaxValue();

                        // Set the font
                        g2d.setFont(font);
                        // Draw the String
                        if (width > height) {

                            g2d.setColor(color.black);
                            // draw the string in the bottom middle of the tile

                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height + metrics.getHeight() + 20);
                        } else if (height > width) {
                            // draw the string in the bottom middle of the tile
                            g2d.setColor(color.black);
                            g2d.drawString(cost, (x + (width - metrics.stringWidth(cost)) / 2), y + height - metrics.getHeight() + 10);
                        }

                        g2d.rotate(Math.toRadians(-RotateDegrees), x + width / 2, y + height / 2);

                    }

                }

                g2d.dispose();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        if (players != null && players.keySet() != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.scale(scaleFactor, scaleFactor);

            for (int i : tiles.keySet()) {

                Tile tile = tiles.get(i);
                Integer[] playersOnTile = tile.getPlayerOccupying();
                int numOccupied = 0;

                for (int j = 0; j < playersOnTile.length; j++) {
                    if (playersOnTile[j] >= 0) {
                        // calculate the position of the player

                        int x = tile.getX(); // the x coordinate of the tile
                        int y = tile.getY(); // the y coordinate of the tile 
                        int width = tile.getWidth(); // the width of the tile
                        int height = tile.getHeight(); // the height of the tile 
                        int centerX = x + width / 2; // the x coordinate of the center of the tile
                        int centerY = y + height / 2; // the y coordinate of the center of the tile

                        if (tile.getNumTileOccupied() == 4 && (width != height)) {
                            numOccupied = 3; // if the tile has 3 players on it alreay.
                        } else {
                            numOccupied = j; // if the tile has less than 3 players on it already.
                        }
                        g2d.setColor(players.get(playersOnTile[j]).getColor());
                        // adjust the position based on the number of players on the tile
                        // if there are no players on the tile

                        if (numOccupied == 0) {
                            // if it is the jail tile 
                            if (tile.getLocation() == 11 && !(players.get(playersOnTile[j]).isInJail())) {
                                g2d.fillOval(0, centerY, 50, 50);

                            } else {
                                // the tile is not jail
                                g2d.fillOval(centerX - 25, centerY - 25, 50, 50);
                            }
                        } else if (numOccupied == 1) { // if there is one player on the tile
                            if (width > height) {
                                g2d.fillOval(centerX - 75, centerY - 25, 50, 50);
                            } else if (height > width) {
                                g2d.fillOval(centerX - 25, centerY - 75, 50, 50);
                            } else {
                                if (tile.getLocation() == 11 && !(players.get(playersOnTile[j]).isInJail())) {
                                    g2d.fillOval(0, centerY - 50, 50, 50);

                                } else {
                                    g2d.fillOval(centerX - 75, centerY - 25, 50, 50);
                                }
                            }

                        } else if (numOccupied == 2) { // if there are two players on the tile
                            if (width > height) {
                                g2d.fillOval(centerX + 25, centerY - 25, 50, 50);
                            } else if (height > width) {
                                g2d.fillOval(centerX - 25, centerY + 25, 50, 50);
                            } else {
                                if (tile.getLocation() == 11 && !(players.get(playersOnTile[j]).isInJail())) {
                                    System.out.println("test 3");
                                    g2d.fillOval(0, centerY + 50, 50, 50);

                                } else {
                                    g2d.fillOval(centerX - 25, centerY - 75, 50, 50);
                                }
                            }

                        } else if (numOccupied == 3) { // if there are three players on the tile
                            if (width > height) {

                                int[] LocationX = {x + 10, x + width - 60, x + 10, x + width - 60};
                                int[] LocationY = {y + 5, y + 5, y + height - 55, y + height - 55};

                                for (int p = 0; p < playersOnTile.length; p++) {
                                    g2d.setColor(players.get(playersOnTile[p]).getColor());

                                    g2d.fillOval(LocationX[p], LocationY[p], 50, 50);

                                }
                                break;

                            } else if (height > width) {
                                // this should draw 4 circles surounding the center of the tile

                                int[] LocationX = {x + 5, x + width - 55, x + 5, x + width - 55};
                                int[] LocationY = {y + 10, y + 10, y + height - 60, y + height - 60};

                                for (int p = 0; p < playersOnTile.length; p++) {
                                    g2d.setColor(players.get(playersOnTile[p]).getColor());
                                    g2d.fillOval(LocationX[p], LocationY[p], 50, 50);
                                }

                                break;
                            } else {
                                if (tile.getLocation() == 11 && !(players.get(playersOnTile[j]).isInJail())) {
                                    g2d.fillOval(50, centerY + 60, 50, 50);

                                } else {
                                    // this will draw it if it is a cornor tile
                                    g2d.fillOval(centerX - 25 - 50, centerY - 25 - 50, 50, 50);
                                }
                            }
                        }

                    }

                }
            }

            g2d.dispose();

        }

    }

    public HashMap<Integer, Tile> getTiles() {
        return tiles;
    }

    public void setTiles(HashMap<Integer, Tile> tiles) {
        this.tiles = tiles;
    }

}

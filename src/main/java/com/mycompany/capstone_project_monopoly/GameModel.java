/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author carmitnaor
 */
public class GameModel implements Serializable {

     HashMap<Integer, Tile> tiles; // will hold all the tiles in the game, the key is the location of the tile on the board
     HashMap<Integer, Player> players; // will hold all the players in the game, the key is the player number min 2 max 4
     HashMap<String, Integer> fullsets; // will hold the full sets of properties, the key is the color of the set
     int currentPlayer = 1; // will hold the current player number
     int numPlayers; // will hold the number of players in the game
     int defaultMoney = 1500; // will hold the default money for the players
     int consecutive_doubles; // will hold the number of consecutive doubles
     int upgrades; // will hold the number of upgrades

    public GameModel(HashMap<Integer, Tile> tiles, HashMap<Integer, Player> players, HashMap<String, Integer> fullsets, int currentPlayer, int numPlayers, int defaultMoney, int consecutive_doubles, int upgrades) {
        this.tiles = tiles;
        this.players = players;
        this.fullsets = fullsets;
        this.currentPlayer = currentPlayer;
        this.numPlayers = numPlayers;
        this.defaultMoney = defaultMoney;
        this.consecutive_doubles = consecutive_doubles;
        this.upgrades = upgrades;
    }
}

// GameModel class, will store all the data for the game so taht it can be saved and can be loaded from a file
// we can assume that the game will be saved and loaded from a file, and the file will be updated after every turn
// the GameModel class will have the following instance variables
// private HashMap<Integer, Tile> tiles; // will hold all the tiles in the game, the key is the location of the tile on the board
// private HashMap<Integer, Player> players; // will hold all the players in the game, the key is the player number min 2 max 4
// private HashMap<String, Integer> fullsets; // will hold the full sets of properties, the key is the color of the set
// wont need to save cards since they will be loaded (they are the same for every game)
// private int currentPlayer = 1; // will hold the current player number
// dont need to save the last roll since it doesnt metter because the players turn is over
// public static int numPlayers; // will hold the number of players in the game
// dont need to save the cube since it doesnt metter because the players turn is over
// private int defaultMoney = 1500; // will hold the default money for the players
// wont need to save the graphics panel since it will be loaded with the tiles and players
// wond need to save the gotoJail since it will be loaded with the players
// wont need to save the selectedMortgage since it will be loaded later on. 
// wont need to save the selectedUpgrade since it will be loaded later on.
// public int consecutive_doubles; // will hold the number of consecutive doubles
// wont need to save the screen dimension since it will be loaded with the graphics panel
// private int upgrades; // will hold the number of upgrades

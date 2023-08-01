/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.capstone_project_monopoly;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manske_905351
 */
public class MainWindow extends javax.swing.JFrame {
    
    private HashMap<Integer, Tile> tiles;
    private HashMap<Integer, Player> players;
    private HashMap<String, Integer> fullsets;
    public Card[] cChestCards = new Card[15];
    public Card[] chanceCards = new Card[13];
    private int currentPlayer = 1;
    public static int lastRoll;
    public static int numPlayers;
    private Cube roll;
    private int defaultMoney = 1500;
    private GraphicPanel graphicsPanel;
    private boolean gotoJail = false;
    private String selectedMortgage = "";
    private String selectedUpgrade = "";
    public int consecutive_doubles;
    public static Dimension dim;
    private int upgrades;
    private boolean backwards;
    private boolean changed = false;
    private String currentFile;
    private boolean reloadFromFile;

//drive
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        this.roll = new Cube();
        
        
        initComponents();
        //loadCards();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width, screenSize.height);

        // dim = bounds.getSize();
        dim = screenSize;
        
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        Rectangle bounds = environment.getMaximumWindowBounds();

        //dim = bounds.getSize();
        //dim = Toolkit.getDefaultToolkit().getScreenSize();
        jInternalFrameMainMenu.setPreferredSize(dim);
        jInternalFrameGameBoardProperties.setPreferredSize(dim);
        jInternalFrameOptionsMenu.setPreferredSize(dim);
        jInternalFrameGameBoard.setPreferredSize(dim);
        
        changeToGraphicPanelSize();
          
        roll = roll();
        
        reloadFromFile = true;
        createPreferancesFile();
        
        
        // check if preferences file exists
        // if it does, load it
        File preferencesFile = new File("preferences.txt");
        if (preferencesFile.exists()) {
            boolean isModelEmpty = true;
            File modelFile = new File(currentFile);
            
            if(modelFile.exists()){
                if(modelFile.length() > 0){
                    isModelEmpty = false;
                }
            }
            
            //GameModel model = readModel();

            if(isModelEmpty || !reloadFromFile){
                System.out.println("model is null or reload from file is null");
                        Datafactory df = new Datafactory(chanceCards, cChestCards);
                        tiles = df.getTiles();
                        
                        players = new HashMap<Integer, Player>();
                        
                        jTextFieldCurrentPlayer.setText("1");
                        jTextFieldBalance.setText("1500");
                        jTextField_Upgrade_Cost.setText("0");
                        jTextField_MortgageValue.setText("0");
            }

        } else {
            // show options menu
        }
        

        //Sets the default state of all GUI elements
        jInternalFrameGameBoardProperties.setVisible(false);
        jInternalFrameMainMenu.setVisible(true);
        jInternalFrameOptionsMenu.setVisible(false);
        jInternalFrameGameBoard.setVisible(false);
        jDialog_GameOver.setVisible(false);
        
        
        
        jButtonEndTurn.setEnabled(false);
        jButtonPurchase.setEnabled(false);
        jDialog_Upgrade.setVisible(false);
        jButton_Properties.setEnabled(false);
        graphicsPanel = (GraphicPanel) jPanelGameBoard;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog_Upgrade = new javax.swing.JDialog();
        jComboBox_Upgrades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Upgrade_Cost = new javax.swing.JTextField();
        jButtonBuyUpgrade = new javax.swing.JButton();
        jButtonSellUpgrade = new javax.swing.JButton();
        jDialog_Mortgage = new javax.swing.JDialog();
        jComboBox_Mortgage = new javax.swing.JComboBox<>();
        jButton_Mortgage_Property = new javax.swing.JButton();
        jButton_Unmortgage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_MortgageValue = new javax.swing.JTextField();
        jDialog_GameOver = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabelWinner = new javax.swing.JLabel();
        jLabelFinalBalance = new javax.swing.JLabel();
        jLabelFinalBalanceValue = new javax.swing.JLabel();
        jInternalFrameMainMenu = new javax.swing.JInternalFrame();
        jLabelHeader = new javax.swing.JLabel();
        jButtonOptions = new javax.swing.JButton();
        jButtonStartGame = new javax.swing.JButton();
        jRadioButton4Players = new javax.swing.JRadioButton();
        jRadioButton3Players = new javax.swing.JRadioButton();
        jRadioButton2Players = new javax.swing.JRadioButton();
        jLabelNumberOfPlayers = new javax.swing.JLabel();
        jInternalFrameGameBoard = new javax.swing.JInternalFrame();
        jButtonRoll = new javax.swing.JButton();
        jButtonPurchase = new javax.swing.JButton();
        jButtonEndTurn = new javax.swing.JButton();
        jLabelCurrentTurn = new javax.swing.JLabel();
        jTextFieldCurrentPlayer = new javax.swing.JTextField();
        jButton_Properties = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBalance = new javax.swing.JTextField();
        jButtonMortgage = new javax.swing.JButton();
        jButtonUpgrade = new javax.swing.JButton();
        jPanelGameBoard = new GraphicPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLocation = new javax.swing.JTextField();
        jButtonGetOutOfJail = new javax.swing.JButton();
        jInternalFrameOptionsMenu = new javax.swing.JInternalFrame();
        jLabelOptions = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTextFieldStartingBalance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrameGameBoardProperties = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        GameBoard_jTable_Properties = new javax.swing.JTable();

        jDialog_Upgrade.setMinimumSize(new java.awt.Dimension(500, 500));

        jComboBox_Upgrades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));
        jComboBox_Upgrades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_UpgradesItemStateChanged(evt);
            }
        });

        jLabel3.setText("cost");

        jTextField_Upgrade_Cost.setMinimumSize(new java.awt.Dimension(100, 22));
        jTextField_Upgrade_Cost.setPreferredSize(new java.awt.Dimension(50, 22));

        jButtonBuyUpgrade.setText("Upgrade");
        jButtonBuyUpgrade.setEnabled(false);
        jButtonBuyUpgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyUpgradeActionPerformed(evt);
            }
        });

        jButtonSellUpgrade.setText("Sell Upgrade");
        jButtonSellUpgrade.setEnabled(false);
        jButtonSellUpgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSellUpgradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog_UpgradeLayout = new javax.swing.GroupLayout(jDialog_Upgrade.getContentPane());
        jDialog_Upgrade.getContentPane().setLayout(jDialog_UpgradeLayout);
        jDialog_UpgradeLayout.setHorizontalGroup(
            jDialog_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_UpgradeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_Upgrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Upgrade_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jDialog_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBuyUpgrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSellUpgrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialog_UpgradeLayout.setVerticalGroup(
            jDialog_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_UpgradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_UpgradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Upgrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Upgrade_Cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuyUpgrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSellUpgrade)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jDialog_Mortgage.setMinimumSize(new java.awt.Dimension(500, 500));

        jComboBox_Mortgage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));
        jComboBox_Mortgage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_MortgageItemStateChanged(evt);
            }
        });

        jButton_Mortgage_Property.setText("Mortgage");
        jButton_Mortgage_Property.setEnabled(false);
        jButton_Mortgage_Property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Mortgage_PropertyActionPerformed(evt);
            }
        });

        jButton_Unmortgage.setText("Unmortgage");
        jButton_Unmortgage.setEnabled(false);
        jButton_Unmortgage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UnmortgageActionPerformed(evt);
            }
        });

        jLabel5.setText("Value");

        jTextField_MortgageValue.setMinimumSize(new java.awt.Dimension(100, 22));
        jTextField_MortgageValue.setPreferredSize(new java.awt.Dimension(100, 22));

        javax.swing.GroupLayout jDialog_MortgageLayout = new javax.swing.GroupLayout(jDialog_Mortgage.getContentPane());
        jDialog_Mortgage.getContentPane().setLayout(jDialog_MortgageLayout);
        jDialog_MortgageLayout.setHorizontalGroup(
            jDialog_MortgageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_MortgageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_Mortgage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_MortgageValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jDialog_MortgageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Unmortgage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Mortgage_Property, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jDialog_MortgageLayout.setVerticalGroup(
            jDialog_MortgageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_MortgageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_MortgageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Mortgage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton_Mortgage_Property)
                    .addComponent(jTextField_MortgageValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Unmortgage)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jDialog_GameOver.setMinimumSize(new java.awt.Dimension(413, 348));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setText("Game Over");

        jLabelWinner.setText("Player 1 Wins!");

        jLabelFinalBalance.setText("Final Balance:");

        jLabelFinalBalanceValue.setText("jLabel7");

        javax.swing.GroupLayout jDialog_GameOverLayout = new javax.swing.GroupLayout(jDialog_GameOver.getContentPane());
        jDialog_GameOver.getContentPane().setLayout(jDialog_GameOverLayout);
        jDialog_GameOverLayout.setHorizontalGroup(
            jDialog_GameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_GameOverLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(jDialog_GameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_GameOverLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_GameOverLayout.createSequentialGroup()
                        .addComponent(jLabelWinner)
                        .addGap(166, 166, 166))))
            .addGroup(jDialog_GameOverLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabelFinalBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFinalBalanceValue)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_GameOverLayout.setVerticalGroup(
            jDialog_GameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_GameOverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWinner)
                .addGap(18, 18, 18)
                .addGroup(jDialog_GameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFinalBalance)
                    .addComponent(jLabelFinalBalanceValue))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jInternalFrameMainMenu.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrameMainMenu.setVisible(true);

        jLabelHeader.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelHeader.setForeground(new java.awt.Color(255, 0, 51));
        jLabelHeader.setText("Monopoly");

        jButtonOptions.setText("Options");
        jButtonOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOptionsActionPerformed(evt);
            }
        });

        jButtonStartGame.setText("Start Game");
        jButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGameActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4Players);
        jRadioButton4Players.setText("4");

        buttonGroup1.add(jRadioButton3Players);
        jRadioButton3Players.setText("3");

        buttonGroup1.add(jRadioButton2Players);
        jRadioButton2Players.setText("2");

        jLabelNumberOfPlayers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNumberOfPlayers.setText("Number of Players");

        javax.swing.GroupLayout jInternalFrameMainMenuLayout = new javax.swing.GroupLayout(jInternalFrameMainMenu.getContentPane());
        jInternalFrameMainMenu.getContentPane().setLayout(jInternalFrameMainMenuLayout);
        jInternalFrameMainMenuLayout.setHorizontalGroup(
            jInternalFrameMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameMainMenuLayout.createSequentialGroup()
                .addGap(720, 720, 720)
                .addGroup(jInternalFrameMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                    .addGroup(jInternalFrameMainMenuLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jInternalFrameMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonStartGame)
                            .addComponent(jButtonOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumberOfPlayers)))
                    .addGroup(jInternalFrameMainMenuLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jInternalFrameMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4Players)
                            .addComponent(jRadioButton3Players)
                            .addComponent(jRadioButton2Players))))
                .addContainerGap())
        );
        jInternalFrameMainMenuLayout.setVerticalGroup(
            jInternalFrameMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameMainMenuLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabelHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumberOfPlayers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2Players)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3Players)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4Players)
                .addGap(18, 18, 18)
                .addComponent(jButtonOptions)
                .addGap(18, 18, 18)
                .addComponent(jButtonStartGame)
                .addContainerGap(4490, Short.MAX_VALUE))
        );

        jInternalFrameGameBoard.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrameGameBoard.setPreferredSize(new java.awt.Dimension(1911, 2465));
        jInternalFrameGameBoard.setVisible(true);

        jButtonRoll.setText("Roll");
        jButtonRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRollActionPerformed(evt);
            }
        });

        jButtonPurchase.setText("Purchase");
        jButtonPurchase.setEnabled(false);
        jButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPurchaseActionPerformed(evt);
            }
        });

        jButtonEndTurn.setText("End Turn");
        jButtonEndTurn.setEnabled(false);
        jButtonEndTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndTurnActionPerformed(evt);
            }
        });

        jLabelCurrentTurn.setText("Current Turn");

        jTextFieldCurrentPlayer.setEditable(false);

        jButton_Properties.setText("Properties");
        jButton_Properties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PropertiesActionPerformed(evt);
            }
        });

        jLabel2.setText("Balance");

        jTextFieldBalance.setEditable(false);

        jButtonMortgage.setText("Mortgage");
        jButtonMortgage.setEnabled(false);
        jButtonMortgage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMortgageActionPerformed(evt);
            }
        });

        jButtonUpgrade.setText("Upgrade");
        jButtonUpgrade.setEnabled(false);
        jButtonUpgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpgradeActionPerformed(evt);
            }
        });

        jPanelGameBoard.setEnabled(false);

        javax.swing.GroupLayout jPanelGameBoardLayout = new javax.swing.GroupLayout(jPanelGameBoard);
        jPanelGameBoard.setLayout(jPanelGameBoardLayout);
        jPanelGameBoardLayout.setHorizontalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1564, Short.MAX_VALUE)
        );
        jPanelGameBoardLayout.setVerticalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1248, Short.MAX_VALUE)
        );

        jLabel4.setText("Location");

        jTextFieldLocation.setEditable(false);

        jButtonGetOutOfJail.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButtonGetOutOfJail.setText("Out of Jail ($50)");
        jButtonGetOutOfJail.setEnabled(false);
        jButtonGetOutOfJail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetOutOfJailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrameGameBoardLayout = new javax.swing.GroupLayout(jInternalFrameGameBoard.getContentPane());
        jInternalFrameGameBoard.getContentPane().setLayout(jInternalFrameGameBoardLayout);
        jInternalFrameGameBoardLayout.setHorizontalGroup(
            jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                        .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonEndTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Properties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                                .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelCurrentTurn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldCurrentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonGetOutOfJail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUpgrade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMortgage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41)
                .addComponent(jPanelGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrameGameBoardLayout.setVerticalGroup(
            jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRoll)
                    .addComponent(jTextFieldCurrentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCurrentTurn))
                .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPurchase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Properties)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMortgage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpgrade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGetOutOfJail)
                        .addGap(93, 93, 93)
                        .addComponent(jButtonEndTurn))
                    .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrameGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(2100, Short.MAX_VALUE))
            .addGroup(jInternalFrameGameBoardLayout.createSequentialGroup()
                .addComponent(jPanelGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jInternalFrameOptionsMenu.setPreferredSize(new java.awt.Dimension(1911, 2465));
        jInternalFrameOptionsMenu.setVisible(true);

        jLabelOptions.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelOptions.setForeground(new java.awt.Color(255, 0, 51));
        jLabelOptions.setText("Options");

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jTextFieldStartingBalance.setText("1500");
        jTextFieldStartingBalance.setMinimumSize(new java.awt.Dimension(100, 22));
        jTextFieldStartingBalance.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel1.setText("Starting Money");

        javax.swing.GroupLayout jInternalFrameOptionsMenuLayout = new javax.swing.GroupLayout(jInternalFrameOptionsMenu.getContentPane());
        jInternalFrameOptionsMenu.getContentPane().setLayout(jInternalFrameOptionsMenuLayout);
        jInternalFrameOptionsMenuLayout.setHorizontalGroup(
            jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameOptionsMenuLayout.createSequentialGroup()
                .addGap(746, 746, 746)
                .addGroup(jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jInternalFrameOptionsMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldStartingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrameOptionsMenuLayout.createSequentialGroup()
                            .addComponent(jButtonSave)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonCancel))
                        .addComponent(jLabelOptions)))
                .addContainerGap(4520, Short.MAX_VALUE))
        );
        jInternalFrameOptionsMenuLayout.setVerticalGroup(
            jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameOptionsMenuLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabelOptions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStartingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(126, 126, 126)
                .addGroup(jInternalFrameOptionsMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(2076, Short.MAX_VALUE))
        );

        jInternalFrameGameBoardProperties.setClosable(true);
        jInternalFrameGameBoardProperties.setPreferredSize(new java.awt.Dimension(1911, 2465));
        jInternalFrameGameBoardProperties.setVisible(true);
        jInternalFrameGameBoardProperties.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrameGameBoardPropertiesInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrameGameBoardPropertiesInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 500));

        GameBoard_jTable_Properties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Color", "Rent", "Upgrade Level", "Upgrade Cost", "Mortgage value"
            }
        ));
        GameBoard_jTable_Properties.setMinimumSize(new java.awt.Dimension(500, 500));
        GameBoard_jTable_Properties.setPreferredSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setViewportView(GameBoard_jTable_Properties);

        javax.swing.GroupLayout jInternalFrameGameBoardPropertiesLayout = new javax.swing.GroupLayout(jInternalFrameGameBoardProperties.getContentPane());
        jInternalFrameGameBoardProperties.getContentPane().setLayout(jInternalFrameGameBoardPropertiesLayout);
        jInternalFrameGameBoardPropertiesLayout.setHorizontalGroup(
            jInternalFrameGameBoardPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameGameBoardPropertiesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(870, Short.MAX_VALUE))
        );
        jInternalFrameGameBoardPropertiesLayout.setVerticalGroup(
            jInternalFrameGameBoardPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrameGameBoardPropertiesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrameMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3554, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jInternalFrameOptionsMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 5465, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrameGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1665, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrameGameBoardProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrameMainMenu)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jInternalFrameOptionsMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 4906, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrameGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 4894, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jInternalFrameGameBoardProperties, javax.swing.GroupLayout.DEFAULT_SIZE, 4894, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOptionsActionPerformed
        // adds functionality for switching to the options menu
        if (jTextFieldStartingBalance.getText().equals("")) {
            JOptionPane.showMessageDialog(MainWindow.this, "PleasJOptionPanee Enter a Balance");
            return;
        }
        jInternalFrameMainMenu.setVisible(false);
        jInternalFrameOptionsMenu.setVisible(true);
    }//GEN-LAST:event_jButtonOptionsActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // leaves the options menu without saving
        jTextFieldStartingBalance.setText(defaultMoney + "");
        jInternalFrameMainMenu.setVisible(true);
        jInternalFrameOptionsMenu.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGameActionPerformed
        //Starts the game with the correct number of players and starting cash based on the options menu

        if (jRadioButton2Players.isSelected()) {
            Player player = new Player(1, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.BLUE);
            
            Player player2 = new Player(2, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.RED);
            
            players.put(player.getPlayerNum(), player);
            players.put(player2.getPlayerNum(), player2);
            numPlayers = 2;
            
        } else if (jRadioButton3Players.isSelected()) {
            Player player = new Player(1, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.BLUE);
            
            Player player2 = new Player(2, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.RED);
            
            Player player3 = new Player(3, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.GREEN);
            
            players.put(player.getPlayerNum(), player);
            players.put(player2.getPlayerNum(), player2);
            players.put(player3.getPlayerNum(), player3);
            numPlayers = 3;
            
        } else if (jRadioButton4Players.isSelected()) {
            Player player = new Player(1, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.BLUE);
            
            Player player2 = new Player(2, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.RED);
            
            Player player3 = new Player(3, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.GREEN);
            
            Player player4 = new Player(4, null, Integer.parseInt(jTextFieldStartingBalance.getText()),
                    1, false, false, 0, Color.YELLOW);
            
            players.put(player.getPlayerNum(), player);
            players.put(player2.getPlayerNum(), player2);
            players.put(player3.getPlayerNum(), player3);
            players.put(player4.getPlayerNum(), player4);
            numPlayers = 4;
            
        } else {
            JOptionPane.showMessageDialog(MainWindow.this, "Please Select The Number of Players");
            return;
        }
        jInternalFrameMainMenu.setVisible(false);
        jInternalFrameGameBoard.setVisible(true);
        currentPlayer = 1;
        jTextFieldBalance.setText(players.get(currentPlayer).getBalance() + "");
        
        Integer[] PlayerOccupying = new Integer[numPlayers];
        Integer numTileOccupied = 0;
        for (int i = 0; i < numPlayers; i++) {
            PlayerOccupying[i] = (i + 1);
            numTileOccupied++;
        }
        
        Tile newTile1 = tiles.get(1);
        
        newTile1.setPlayerOccupying(PlayerOccupying);
        newTile1.setNumTileOccupied(numTileOccupied);
        
        tiles.put(1, newTile1);
        
        graphicsPanel.setTiles(tiles);
        graphicsPanel.processData(players, tiles);
        
        tiles = graphicsPanel.getTiles();
        
        
        writeModel();

    }//GEN-LAST:event_jButtonStartGameActionPerformed

    private void jButtonRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRollActionPerformed
        // rolls the dice for moving in the game
        // dice rolls are randomly generated
        roll = roll();
        lastRoll = roll.getRoll1() + roll.getRoll2();
        int location = players.get(currentPlayer).getLocation();
        
        players.get(currentPlayer).setPreviousLocation(location);

        //Checks if a double is rolled for a player who is in jail
        //Keeps track of the number of rolls to allow a player to pay to get out of jail after 3 turns
        if (players.get(currentPlayer).isInJail()) {
            
            if (roll.IsDouble() || players.get(currentPlayer).getJailRoll() == 3) {
                
                players.get(currentPlayer).setInJail(false);
                jButtonGetOutOfJail.setEnabled(false);
                players.get(currentPlayer).setJailRoll(0);
            } else {
                players.get(currentPlayer).setJailRoll(players.get(currentPlayer).getJailRoll() + 1);
            }
        } else if (roll.getRoll1() + roll.getRoll2() + players.get(currentPlayer).getLocation() > 40) {
            players.get(currentPlayer).setLocation(roll.getRoll1() + roll.getRoll2() + players.get(currentPlayer).getLocation() - 40);
        } else {
            players.get(currentPlayer).setLocation(roll.getRoll1() + roll.getRoll2() + players.get(currentPlayer).getLocation());
            jButtonRoll.setEnabled(false);
        }
        
        if (gotoJail) {
            players.get(currentPlayer).setLocation(31);
            gotoJail = false;
            
        }
        
        UpdateTiles();
        graphicsPanel.processData(players, tiles);
        
        jTextFieldBalance.setText(players.get(currentPlayer).getBalance() + "");
        jTextFieldLocation.setText(tiles.get(players.get(currentPlayer).getLocation()).getName() + "");
        jButtonEndTurn.setEnabled(true);
        if (players.get(currentPlayer).getJailRoll() >= 3 && (players.get(currentPlayer).getGetOutOfJailCards() > 1 || players.get(currentPlayer).getBalance() >= 50)) {
            jButtonGetOutOfJail.setEnabled(true);
        }
        tileInteraction();
        jButtonRoll.setEnabled(false);
        graphicsPanel.processData(players, tiles);
        
        tiles = graphicsPanel.getTiles();

    }//GEN-LAST:event_jButtonRollActionPerformed

    private void jButtonEndTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndTurnActionPerformed
        // Ends the turn, switching to the next player
        // Makes sure the right buttons are on and off when switching players
        int length = players.size();
        if (currentPlayer == length) {
            
            currentPlayer = 1;
            
        } else {
            currentPlayer++;
        }
        jTextFieldCurrentPlayer.setText("" + currentPlayer);
        jTextFieldBalance.setText(players.get(currentPlayer).getBalance() + "");
        jTextFieldLocation.setText(tiles.get(players.get(currentPlayer).getLocation()).getName() + "");
        jButtonRoll.setEnabled(true);
        jButtonEndTurn.setEnabled(false);
        Player nextPlayer = players.get(currentPlayer);
        ArrayList<Tile> playerTiles = nextPlayer.getTiles();
        if (playerTiles != null) {
            jButton_Properties.setEnabled(true);
            jButtonMortgage.setEnabled(true);
            for (Tile tile : playerTiles) {
                if (tile.getTypeName().contains("Property")) {
                    jButtonUpgrade.setEnabled(true);
                }
            }
        } else {
            jButton_Properties.setEnabled(false);
            jButtonMortgage.setEnabled(false);
            jButtonUpgrade.setEnabled(false);
        }

        //Checks to see if the purchase property button should be enabled
        Tile tile = tiles.get(nextPlayer.getLocation());
        
        if (tile.getTypeName().contains("Property")) {
            
            Property property = (Property) tile.getType();
            if (property.getOwner() == null && nextPlayer.getBalance() >= property.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else {
                jButtonPurchase.setEnabled(false);
            }
        } else if (tile.getTypeName().contains("Utility")) {
            Utility utility = (Utility) tile.getType();
            if (utility.getOwner() == null && nextPlayer.getBalance() >= utility.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else {
                jButtonPurchase.setEnabled(false);
            }
        } else if (tile.getTypeName().contains("Railroad")) {
            Railroad railroad = (Railroad) tile.getType();
            if (railroad.getOwner() == null && nextPlayer.getBalance() >= railroad.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else {
                jButtonPurchase.setEnabled(false);
            }
        } else {
            jButtonPurchase.setEnabled(false);
        }
        if (players.get(currentPlayer).isInJail()) {
            jButtonPurchase.setEnabled(false);
        }

    }//GEN-LAST:event_jButtonEndTurnActionPerformed

    private void jButton_PropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PropertiesActionPerformed
        // Opens the properties table
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tileArray = player.getTiles();
        
        players.get(currentPlayer).setTiles(tileArray);
        
        GameBoard_jTable_Properties.setVisible(true);
        
        jInternalFrameGameBoard.setVisible(false);
        buildPropertiesTable();
        jInternalFrameGameBoardProperties.setVisible(true);
        checkSets();
    }//GEN-LAST:event_jButton_PropertiesActionPerformed

    private void jButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPurchaseActionPerformed
        // TODO add your handling code here:
        /*
            Implements the purchase button
            updates the players balance and the tiles owner
         */
        Player player = players.get(currentPlayer);
        Tile tile = tiles.get(player.getLocation());
        String place = tiles.get(player.getLocation()).getTypeName();
        Scanner breaker = new Scanner(place);
        breaker.useDelimiter("l");
        place = breaker.next();
        //System.out.println(place); 
        if (place.equals("Property{")) {
            Property property = (Property) tile.getType();
            //    player.setBalance(player.getBalance() - property.getCost());
            int costofproperty = 0 - property.getCost();
            player.changeBalance(costofproperty);
            // System.out.println(player.getBalance());
            property.setOwner(player);
            tile.setType(property);
            tiles.replace(tile.getLocation(), tile);
            if (player.getTiles() != null) {
                player.getTiles().add(tile);
            } else {
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(tile);
                player.setTiles(tiles);
            }
        }
        
        if (place.equals("Uti")) {
            Utility utility = (Utility) tile.getType();
            player.changeBalance(-1 * utility.getCost());
            utility.setOwner(player);
            tile.setType(utility);
            tiles.replace(tile.getLocation(), tile);
            if (player.getTiles() != null) {
                player.getTiles().add(tile);
            } else {
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(tile);
                player.setTiles(tiles);
            }
        }
        
        if (place.equals("Rai")) {
            Railroad railroad = (Railroad) tile.getType();
            player.changeBalance(-1 * railroad.getCost());
            railroad.setOwner(player);
            tile.setType(railroad);
            tiles.replace(tile.getLocation(), tile);
            if (player.getTiles() != null) {
                player.getTiles().add(tile);
            } else {
                ArrayList<Tile> tiles = new ArrayList<Tile>();
                tiles.add(tile);
                player.setTiles(tiles);
            }
        }
        players.replace(currentPlayer, player);
        jButtonPurchase.setEnabled(false);
        jTextFieldBalance.setText("" + player.getBalance());
        checkSets();
        jButton_Properties.setEnabled(true);
        jButtonUpgrade.setEnabled(true);
        jButtonMortgage.setEnabled(true);
    }//GEN-LAST:event_jButtonPurchaseActionPerformed

    private void jButtonUpgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpgradeActionPerformed

        /*
            opens the upgrades menu
            fills in the drop down menu
            with only properties, not
            other types of tiles, the player
            owns
         */
        jDialog_Upgrade.setVisible(true);
        jComboBox_Upgrades.removeAllItems();
        jComboBox_Upgrades.addItem("NONE");
        jTextField_Upgrade_Cost.setText("0");
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        //makes sure only tiles that can be upgraded are included in the menu
        for (Tile tile : tiles) {
            if (tile.getTypeName().contains("Property")) {
                jComboBox_Upgrades.addItem(tile.getName());
            }
        }
    }//GEN-LAST:event_jButtonUpgradeActionPerformed

    private void jComboBox_UpgradesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_UpgradesItemStateChanged
        // TODO add your handling code here:
        /*
            activates or deactivates the buy and sell upgrade
            buttons based on the upgrade level of the selected
            property
         */
        jButtonBuyUpgrade.setEnabled(false);
        jButtonSellUpgrade.setEnabled(false);
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        
        for (Tile tile : tiles) {
            //Checks to see if the given tile is availble for upgrading
            if (tile.getName().equals(jComboBox_Upgrades.getSelectedItem())) {
                Property property = (Property) tile.getType();
                if (fullsets.get(property.getColorName()) == currentPlayer) {
                    jButtonBuyUpgrade.setEnabled(true);
                    if (property.getUpgradeLevel() == 5) {
                        jButtonBuyUpgrade.setEnabled(false);
                    }
                    if (property.getUpgradeLevel() > 0) {
                        jButtonSellUpgrade.setEnabled(true);
                    } else {
                        jButtonSellUpgrade.setEnabled(false);
                    }
                }
                jTextField_Upgrade_Cost.setText(property.getUpgradeCost() + "");
                return;
            }
            
        }
        
        changed = true;
        selectedUpgrade = jComboBox_Upgrades.getSelectedItem() + "";
    }//GEN-LAST:event_jComboBox_UpgradesItemStateChanged

    private void jButtonBuyUpgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyUpgradeActionPerformed
        // TODO add your handling code here:
        /*
            Implements the buy upgrade button 
            charges the player and upgrade cost
            based on the property to upgrade it
            if the upgrade level reaches 5 it no longer
            allows upgrades to be purchased
            automatically enables the sell upgrade button
         */
        selectedUpgrade = jComboBox_Upgrades.getSelectedItem() + "";
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        //out.println("Hello");
        int index = 0;
        for (Tile tile : tiles) {
            //out.println(tile.getName());
            
            if (tile.getName().contains(selectedUpgrade)) {
                
                Property property = (Property) tile.getType();
                property.setUpgradeLevel(property.getUpgradeLevel() + 1);
                if (property.getUpgradeLevel() == 5) {
                    jButtonBuyUpgrade.setEnabled(false);
                }
                tile.setType(property);
                tiles.set(index, tile);
                player.setBalance(player.getBalance() - property.getUpgradeCost());
            } else {
                index++;
            }
        }
        player.setTiles(tiles);
        players.replace(currentPlayer, player);
        jTextFieldBalance.setText(player.getBalance() + "");
        jButtonSellUpgrade.setEnabled(true);
    }//GEN-LAST:event_jButtonBuyUpgradeActionPerformed

    private void jInternalFrameGameBoardPropertiesInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrameGameBoardPropertiesInternalFrameClosing
        // TODO add your handling code here:
        jInternalFrameGameBoard.setVisible(true);
        jInternalFrameGameBoardProperties.setVisible(false);
    }//GEN-LAST:event_jInternalFrameGameBoardPropertiesInternalFrameClosing

    private void jInternalFrameGameBoardPropertiesInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrameGameBoardPropertiesInternalFrameClosed
        // TODO add your handling code here:
        /*
            closes the properties table window and brings the gameboard back up
         */
        jInternalFrameGameBoard.setVisible(true);
        jInternalFrameGameBoardProperties.setVisible(false);

    }//GEN-LAST:event_jInternalFrameGameBoardPropertiesInternalFrameClosed

    private void jButtonMortgageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMortgageActionPerformed
        // TODO add your handling code here:
        /*
            Opens the mortgage menu
            fills in the drop box using all
            of the players owned tiles
         */
        jDialog_Mortgage.setVisible(true);
        jComboBox_Mortgage.removeAllItems();
        Player player = players.get(currentPlayer);
        jTextField_MortgageValue.setText("0");
        ArrayList<Tile> tiles = player.getTiles();
        jComboBox_Mortgage.addItem("NONE");
        for (Tile tile : tiles) {
            
            jComboBox_Mortgage.addItem(tile.getName());
        }
    }//GEN-LAST:event_jButtonMortgageActionPerformed

    private void jComboBox_MortgageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_MortgageItemStateChanged
        // TODO add your handling code here:
        /*
            updates which tile is selected for mortgage
            if the tile is type property, it will check
            to make sure the property has no upgrades before
            allowing it to be mortgaged
         */
        jButton_Unmortgage.setEnabled(false);
        jButton_Mortgage_Property.setEnabled(false);
        Player player = players.get(currentPlayer);
        
        ArrayList<Tile> tiles = player.getTiles();
        for (Tile tile : tiles) {
            
            if (tile.getName().equals(jComboBox_Mortgage.getSelectedItem())) {
                if (tile.getTypeName().contains("Property")) {
                    Property property = (Property) tile.getType();
                    if (property.isIsMortgaged()) {
                        jButton_Unmortgage.setEnabled(true);
                    } else {
                        if (property.getUpgradeLevel() == 0) {
                            jButton_Mortgage_Property.setEnabled(true);
                        } else {
                            jButton_Mortgage_Property.setEnabled(false);
                        }
                        //out.println("testing");
                    }
                    jTextField_MortgageValue.setText(property.getMortgage() + "");
                } else if (tile.getTypeName().contains("Utility")) {
                    Utility utility = (Utility) tile.getType();
                    if (utility.isIsMortgaged()) {
                        jButton_Unmortgage.setEnabled(true);
                    } else {
                        jButton_Mortgage_Property.setEnabled(true);
                    }
                    jTextField_MortgageValue.setText(utility.getMortgage() + "");
                } else if (tile.getTypeName().contains("Railroad")) {
                    Railroad railroad = (Railroad) tile.getType();
                    if (railroad.isIsMortgaged()) {
                        jButton_Unmortgage.setEnabled(true);
                    } else {
                        jButton_Mortgage_Property.setEnabled(true);
                    }
                    jTextField_MortgageValue.setText(railroad.getMortgage() + "");
                    
                }
                
            }
            
        }
        selectedMortgage = jComboBox_Mortgage.getSelectedItem() + "";
    }//GEN-LAST:event_jComboBox_MortgageItemStateChanged

    private void jButton_Mortgage_PropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Mortgage_PropertyActionPerformed
        // TODO add your handling code here:
        /*
            Implements the mortgage property button
            Allows players to recieve money for their
            properties in exchange for deactivating it
         */
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        int index = 0;
        for (Tile tile : tiles) {
            if (tile.getName().equals(selectedMortgage)) {
                
                if (tile.getTypeName().contains("Property")) {
                    //out.println("testing");
                    Property property = (Property) tile.getType();
                    property.setIsMortgaged(true);
                    player.setBalance(player.getBalance() + property.getMortgage());
                    tile.setType(property);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(false);
                    jButton_Unmortgage.setEnabled(true);
                    
                } else if (tile.getTypeName().contains("Utility")) {
                    
                    Utility utility = (Utility) tile.getType();
                    utility.setIsMortgaged(true);
                    player.setBalance(player.getBalance() + utility.getMortgage());
                    tile.setType(utility);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(false);
                    jButton_Unmortgage.setEnabled(true);
                    
                } else if (tile.getTypeName().contains("Railroad")) {
                    
                    Railroad railroad = (Railroad) tile.getType();
                    railroad.setIsMortgaged(true);
                    player.setBalance(player.getBalance() + railroad.getMortgage());
                    tile.setType(railroad);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(false);
                    jButton_Unmortgage.setEnabled(true);
                    
                }
                
            } else {
                index++;
            }
        }
        player.setTiles(tiles);
        players.replace(currentPlayer, player);
        jTextFieldBalance.setText(player.getBalance() + "");
    }//GEN-LAST:event_jButton_Mortgage_PropertyActionPerformed

    private void jButton_UnmortgageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UnmortgageActionPerformed
        // TODO add your handling code here:
        /*
            Implements the unmortgage button
            allows players to spend money to reacitvate 
            a property that has been mortgaged
         */
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        int index = 0;
        for (Tile tile : tiles) {
            
            if (tile.getName().equals(selectedMortgage)) {
                if (tile.getTypeName().contains("Property")) {
                    
                    Property property = (Property) tile.getType();
                    property.setIsMortgaged(false);
                    player.setBalance(player.getBalance() - property.getMortgage());
                    tile.setType(property);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(true);
                    jButton_Unmortgage.setEnabled(false);
                    
                } else if (tile.getTypeName().contains("Utility")) {
                    
                    Utility utility = (Utility) tile.getType();
                    utility.setIsMortgaged(false);
                    player.setBalance(player.getBalance() - utility.getMortgage());
                    tile.setType(utility);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(true);
                    jButton_Unmortgage.setEnabled(false);
                    
                } else if (tile.getTypeName().contains("Railroad")) {
                    
                    Railroad railroad = (Railroad) tile.getType();
                    railroad.setIsMortgaged(false);
                    player.setBalance(player.getBalance() - railroad.getMortgage());
                    tile.setType(railroad);
                    tiles.set(index, tile);
                    jButton_Mortgage_Property.setEnabled(true);
                    jButton_Unmortgage.setEnabled(false);
                    
                }
                
            } else {
                index++;
            }
        }
        player.setTiles(tiles);
        players.replace(currentPlayer, player);
        jTextFieldBalance.setText(player.getBalance() + "");
        if (player.getBalance() > 0)
            jButtonEndTurn.setEnabled(true);
    }//GEN-LAST:event_jButton_UnmortgageActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        /*
            Leaves the options menu without resetting the values
         */
        jInternalFrameOptionsMenu.setVisible(false);
        jInternalFrameMainMenu.setVisible(true);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonGetOutOfJailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetOutOfJailActionPerformed
        // TODO add your handling code here:
        /*
            Implenets the get out of jail button
            If the player has a get out of jail card
            then he is eligible to use the button immediately
            if not then he may use it for $50 after 3 failed doubles rolls
         */
        
        Player player = players.get(currentPlayer);
        player.setInJail(false);
        if (player.getGetOutOfJailCards() > 0) {
            player.setGetOutOfJailCards(player.getGetOutOfJailCards() - 1);
        } else {
            player.setBalance(player.getBalance() - 50);
        }
        players.replace(currentPlayer, player);
        jButtonGetOutOfJail.setEnabled(false);
        jTextFieldBalance.setText(player.getBalance() + "");
    }//GEN-LAST:event_jButtonGetOutOfJailActionPerformed

    private void jButtonSellUpgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSellUpgradeActionPerformed
        // TODO add your handling code here:
        /*
            Implements the button to sell upgrades off properties
            Makes sure that the property is eligbile for upgrade sale
            by checking its upgrade level
            Checks see if the player's balance is positive after sale
            to allow turn to end
            Updates the buy and sell upgrade buttons as appropriate
         */
        selectedUpgrade = jComboBox_Upgrades.getSelectedItem() + ""; 
        Player player = players.get(currentPlayer);
        ArrayList<Tile> tiles = player.getTiles();
        int index = 0;
        
        for (Tile tile : tiles) {
            
            if (tile.getName().equals(selectedUpgrade)) {
                Property property = (Property) tile.getType();
                property.setUpgradeLevel(property.getUpgradeLevel() - 1);
                if (property.getUpgradeLevel() == 0) {
                    jButtonSellUpgrade.setEnabled(false);
                }
                tile.setType(property);
                tiles.set(index, tile);
                player.setBalance(player.getBalance() + property.getUpgradeCost());
            } else {
                index++;
            }
        }
        player.setTiles(tiles);
        players.replace(currentPlayer, player);
        jButtonBuyUpgrade.setEnabled(true);
        jTextFieldBalance.setText(player.getBalance() + "");
        if (player.getBalance() > 0)
            jButtonEndTurn.setEnabled(true);
    }//GEN-LAST:event_jButtonSellUpgradeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("ending");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    public void loadCards() {
        /*
            Creates and loads all of the chance cards for the game
         */
        
        Card chance1 = new Card("Go to Illinois Avenue", false, 25, 0);
        Card chance2 = new Card("Pay Poor Tax of $15", false, 0, -15);
        Card chance3 = new Card("Go Back 3 Spaces", false, players.get(currentPlayer).getLocation() - 3, 0);
        Card chance4 = new Card("Advance to go", false, 1, 0);
        Card chance5 = new Card("TAKE A RIDE ON THE READING IF YOU PASS GO COLLECT $200", false, 6, 0);
        Card chance6 = new Card("Get out of Jail Free", true, 0, 0);
        Card chance7 = new Card("Go Directly to Jail", false, 11, 0); // modofiy so screen only go to move to jail.
        Card chance8 = new Card("Your Building And Loan Matures", false, 0, 150);
        Card chance9 = new Card("Take a Walk on the Boardwalk", false, 40, 0);
        Card chance10 = new Card("Bank Pays You Dividend of $50", false, 0, 50);
        
        Card chance11 = new Card("Make General Repairs On All Your Property", false, 0, 50 * getUpgrades());
        
        Card chance12 = new Card("You Have Been Elected Chairman of the Board Pay Each Player $50", false, 0, -1 * (50 * (numPlayers - 1)));
        
        Card chance13 = new Card("ADVANCE TO ST. CHARLES PLACE IF YOU PASS GO COLLECT $200", false, 12, 0);
        chanceCards[0] = chance1;
        chanceCards[1] = chance2;
        chanceCards[2] = chance3;
        chanceCards[3] = chance4;
        chanceCards[4] = chance5;
        chanceCards[5] = chance6;
        chanceCards[6] = chance7;
        chanceCards[7] = chance8;
        chanceCards[8] = chance9;
        chanceCards[9] = chance10;
        chanceCards[10] = chance11;
        chanceCards[11] = chance12;
        chanceCards[12] = chance13;

        //Creates and loads all of the Community Chest Cards for the game
        Card cChest1 = new Card("Advance to Go", false, 1, 0);
        Card cChest2 = new Card("Collect $50 From Every Player", false, 0, 50 * (numPlayers - 1));
        Card cChest3 = new Card("Pay Hospital $100", false, 0, -100);
        Card cChest4 = new Card("From Sale of Stock You Get $45", false, 0, 45);
        Card cChest5 = new Card("Xmas Fund Matures, Collect $100", false, 0, 100);
        Card cChest6 = new Card("Life Insurance Matures Collect $100", false, 0, 100);
        Card cChest7 = new Card("Bank Error in Your Favor Collect $200", false, 0, 200);
        Card cChest8 = new Card("Go To Jail", false, 11, 0);
        Card cChest9 = new Card("Recieve For Services $25", false, 0, 25);
        Card cChest10 = new Card("You Inherit $100", false, 0, 100);
        Card cChest11 = new Card("Doctor's Fee Pay $50", false, 0, -50);
        Card cChest12 = new Card("Get Out Of Jail Free", true, 0, 0);
        Card cChest13 = new Card("Income Tax Refund Collect $20", false, 0, 20);
        Card cChest14 = new Card("Pay School Tax of $150", false, 0, -150);
        Card cChest15 = new Card("You Have Won Second Prize In a Beauty Contest Collect $10", false, 0, 10);
        cChestCards[0] = cChest1;
        cChestCards[1] = cChest2;
        cChestCards[2] = cChest3;
        cChestCards[3] = cChest4;
        cChestCards[4] = cChest5;
        cChestCards[5] = cChest6;
        cChestCards[6] = cChest7;
        cChestCards[7] = cChest8;
        cChestCards[8] = cChest9;
        cChestCards[9] = cChest10;
        cChestCards[10] = cChest11;
        cChestCards[11] = cChest12;
        cChestCards[12] = cChest13;
        cChestCards[13] = cChest14;
        cChestCards[14] = cChest15;
        
    }

    //Returns the total number of upgrades a player has purchased on all properties
    public int getUpgrades() {
        
        Player temp = players.get(currentPlayer);
        int upgrades1 = 0;
        if (temp.getTiles() != null) {
            for (Tile tile : temp.getTiles()) {
                if (tile.getTypeName().equals("Property")) {
                    Property property = (Property) tile.getType();
                    upgrades1 += property.getUpgradeLevel();
                }
            }
        }
        //loadCards();
        //chanceCards[11].setMoney(upgrades * 50);
        upgrades = upgrades1;
        return upgrades1;
        
    }
    
    public Cube roll() {
        //Randomises the dice roll for the game
        Cube ref = new Cube();
        int roll1 = ref.getRoll1();
        int roll2 = ref.getRoll2();
        boolean isDouble = ref.IsDouble();
        Cube fullroll = new Cube(roll1, roll2, isDouble);
        
        return fullroll;
        
    }
    
    public void tileInteraction() {
        jButtonPurchase.setEnabled(false);
        Player player = players.get(currentPlayer);
        String finalPlace = "";
        try {
            String place = tiles.get(player.getLocation()).getTypeName();
            //System.out.println(place);
            Scanner breaker = new Scanner(place);
            breaker.useDelimiter("l");
            finalPlace = breaker.next();
            //System.out.println(tiles.get(player.getLocation()).getName());
            //System.out.println(finalPlace);
        } catch (Exception ex) {
            System.out.println("Not Implemented");
        }
        //Manages the interaction for chance cards
        if (player.getLocation() == 8 || player.getLocation() == 23 || player.getLocation() == 37) {
            
            loadCards();
            int min = 0;
            int max = 12;
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            Card card = chanceCards[random_int];
            
            JOptionPane.showMessageDialog(MainWindow.this, card.getText());
            if (card.getLocation() != 0) {
                player.setPreviousLocation(player.getLocation());
                
                if (card.getLocation() == 11) {
                    player.setLocation(11);
                    player.setInJail(true);
                } else {
                    int lastLocation = player.getLocation();
                    
                    player.setPreviousLocation(lastLocation);
                    
                    player.setLocation(card.getLocation());
                    
                }
                if (card.getLocation() < 0) {
                    backwards = true;
                    
                }
                jTextFieldLocation.setText(tiles.get(players.get(currentPlayer).getLocation()).getName() + "");
                UpdateTiles();
                graphicsPanel.processData(players, tiles);
                tileInteraction();
                
                return;
            }
            if (card.getMoney() != 0) {
                player.setBalance(player.getBalance() + card.getMoney());
                if (card.getText().contains("Chairman")) {
                    for (int key : players.keySet()) {
                        if (!(players.get(key) == player)) {
                            Player differentPlayer = players.get(key);
                            differentPlayer.setBalance(differentPlayer.getBalance() + 50);
                            players.replace(key, differentPlayer);
                        }
                    }
                }
                jTextFieldBalance.setText(player.getBalance() + "");
            }
            
            if (card.isGetOutOfJailCard()) {
                player.setGetOutOfJailCards(player.getGetOutOfJailCards() + 1);
            }
            
        }
        //Manages the interaction with the Community Chest tiles
        if (player.getLocation() == 3 || player.getLocation() == 18 || player.getLocation() == 34) {
            
            loadCards();
            int min = 0;
            int max = 14;
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            Card card = cChestCards[random_int];
            
            JOptionPane.showMessageDialog(MainWindow.this, card.getText());
            if (card.getLocation() != 0) {
                player.setPreviousLocation(player.getLocation());
                if (card.getLocation() == 11) {
                    player.setLocation(11);
                    player.setInJail(true);
                } else {
                    int lastLocation = player.getLocation();
                    player.setPreviousLocation(lastLocation);
                    player.setLocation(card.getLocation());
                    
                }
                if (card.getLocation() < 0) {
                    backwards = true;
                }
                UpdateTiles();
                graphicsPanel.processData(players, tiles);
                jTextFieldLocation.setText(tiles.get(players.get(currentPlayer).getLocation()).getName() + "");
                players.replace(currentPlayer, player);
                tileInteraction();
                return;
            }
            if (card.getMoney() != 0) {
                player.setBalance(player.getBalance() + card.getMoney());
                if (card.getText().contains("Every")) {
                    for (int key : players.keySet()) {
                        if (!(players.get(key) == player)) {
                            Player differentPlayer = players.get(key);
                            differentPlayer.setBalance(differentPlayer.getBalance() - 50);
                            players.replace(key, differentPlayer);
                        }
                    }
                }
                jTextFieldBalance.setText(player.getBalance() + "");
            }
            
            if (card.isGetOutOfJailCard()) {
                player.setGetOutOfJailCards(player.getGetOutOfJailCards() + 1);
            }
            
        }
        
        if (player.getLocation() >= 1 && player.getLocation() < player.getPreviousLocation()
                && player.getPreviousLocation() != 31
                && backwards != true) {//Manages the Go square
            player.setBalance(200 + player.getBalance());
            //System.out.println(player.getBalance());
        }
        
        if (player.getLocation() == 11) {//Manages Jail Square
            if (player.isInJail()) {
                
                if (roll.IsDouble()) {
                    player.setInJail(false);
                    player.setJailRoll(0);
                } else {
                    player.changeJailRoll(1);
                }
                
            }
        } else if (player.getLocation() == 31) {//Manages Go To Jail
            player.setPreviousLocation(31);
            player.setLocation(11);
            
            player.setInJail(true);
            jButtonPurchase.setEnabled(false);
            UpdateTiles();
            //System.out.println(player.isInJail());
            //System.out.println(player.getLocation());
        } //Manages interaction with the tax tiles
        else if (player.getLocation() == 5 || player.getLocation() == 39) {
            Tax tax = (Tax) tiles.get(player.getLocation()).getType();
            player.setBalance(player.getBalance() - tax.getTaxValue());
            
        }
        
        if (finalPlace.equals("Rai")) {//Manages Railroad interactions including purchasing and rent
            Railroad railroad = (Railroad) tiles.get(player.getLocation()).getType();
            if (railroad.getOwner() == null && player.getBalance() >= railroad.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else if (railroad.getOwner().getPlayerNum() != player.getPlayerNum()
                    && !railroad.getOwner().isInJail()
                    && !railroad.isIsMortgaged()) {
                
                int count = 0;
                for (Tile key : railroad.getOwner().getTiles()) {
                    if (key.getTypeName().equals("Railroad")) {
                        count++;
                    }
                }
                player.setBalance(player.getBalance() - railroad.getRent(count - 1));
                
                Player owner = players.get(railroad.getOwner().getPlayerNum());
                owner.setBalance(owner.getBalance() + railroad.getRent(count - 1));
                players.replace(owner.getPlayerNum(), owner);
                
            } else {
                jButtonEndTurn.setEnabled(true);
            }
            
        }
        
        if (finalPlace.equals("Uti")) {//Manages interaction with utility tiles including purchasing and rent

            Utility utility = (Utility) tiles.get(player.getLocation()).getType();
            if (utility.getOwner() == null && player.getBalance() >= utility.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else if (utility.getOwner().getPlayerNum() != player.getPlayerNum()
                    && !utility.getOwner().isInJail()
                    && !utility.isIsMortgaged()) {
                int count = 0;
                for (Tile key : utility.getOwner().getTiles()) {
                    
                    if (key.getTypeName().equals("Utility")) {
                        count++;
                    }
                    if (count == 1) {
                        player.setBalance(player.getBalance() - (4 * lastRoll));
                        Player owner = players.get(utility.getOwner().getPlayerNum());
                        owner.setBalance(owner.getBalance() + (4 * lastRoll));
                        players.replace(owner.getPlayerNum(), owner);
                        
                    } else if (count == 2) {
                        player.setBalance(player.getBalance() - (10 * lastRoll));
                        Player owner = players.get(utility.getOwner().getPlayerNum());
                        owner.setBalance(owner.getBalance() + (10 * lastRoll));
                        players.replace(owner.getPlayerNum(), owner);
                        
                    }
                    
                }
                
            } else {
                jButtonEndTurn.setEnabled(true);
            }
            
        }
        
        if (finalPlace.equals("Property{")) {//Manages interaction with property tiles including purchasing and rent

            Property property = (Property) tiles.get(player.getLocation()).getType();
            
            if (property.getOwner() == null && player.getBalance() >= property.getCost()) {
                jButtonPurchase.setEnabled(true);
            } else if (property.getOwner() != null
                    && property.getOwner().getPlayerNum() != player.getPlayerNum()
                    && !property.getOwner().isInJail()
                    && !property.isIsMortgaged()) {
                
                player.setBalance(player.getBalance() - property.getRent(property.getUpgradeLevel()));
                Player owner = players.get(property.getOwner().getPlayerNum());
                owner.setBalance(owner.getBalance() + property.getRent(property.getUpgradeLevel()));
                players.replace(owner.getPlayerNum(), owner);
                
            } else {
                jButtonEndTurn.setEnabled(true);
            }
            
        }
        
        jTextFieldBalance.setText(player.getBalance() + "");
        players.replace(currentPlayer, player);
        //Checks if the player is bankrupt, if true, checks to see if there are enough players to continue the game
        if (!isBankrupt()) {
            jButtonEndTurn.setEnabled(true);
        } else {
            player.setBankrupt(true);
            for (Tile tile : player.getTiles()) {
                if (tile.getTypeName().contains("Property")) {
                    Property property = (Property) tile.getType();
                    property.setOwner(null);
                    for (int key : tiles.keySet()) {
                        if (tiles.get(key).getName().equals(tile.getName())) {
                            tiles.replace(key, tile);
                        }
                    }
                }
                if (tile.getTypeName().contains("Railroad")) {
                    Railroad railroad = (Railroad) tile.getType();
                    railroad.setOwner(null);
                    for (int key : tiles.keySet()) {
                        if (tiles.get(key).getName().equals(tile.getName())) {
                            tiles.replace(key, tile);
                        }
                    }
                }
                if (tile.getTypeName().contains("Utility")) {
                    Utility utility = (Utility) tile.getType();
                    utility.setOwner(null);
                    for (int key : tiles.keySet()) {
                        if (tiles.get(key).getName().equals(tile.getName())) {
                            tiles.replace(key, tile);
                        }
                    }
                }
                
            }
            players.remove(currentPlayer);
            if (players.size() < 2) {
                jDialog_GameOver.setVisible(true);

                jInternalFrameGameBoard.setVisible(false);
                // call delete of gameProgressFile
            }
            
        }
        players.replace(currentPlayer, player);
        int count = 0;
        int index = 0;
        for (int test : players.keySet()) {
            
            if (!players.get(test).isBankrupt()) {
                count++;
                index = test;
            }
        }
        if (count == 1) {
            jDialog_GameOver.setVisible(true);
            //jLabel6.setVisible(true);
            jInternalFrameGameBoard.setVisible(false);
            jLabelWinner.setText("Player " + players.get(index).getPlayerNum() + " Wins!");
        }
        backwards = false;
        if (player.isInJail() && player.getGetOutOfJailCards() > 0) {
            jButtonGetOutOfJail.setEnabled(true);
        }
        
        if (player.getBalance() >= 0) {
            jButtonEndTurn.setEnabled(true);
        }
    }
    
    private void buildPropertiesTable() {
        try {
            Player player = players.get(currentPlayer);
            ArrayList<Tile> playerTiles = new ArrayList<Tile>();
            
            playerTiles = player.getTiles();

            //System.out.println("Player has: " + playerTiles.size() + "Players tiles: are ");
            for (Tile item : playerTiles) {
                //System.out.println(item.getTypeName() );

            }
            
            Object[][] data = new Object[playerTiles.size()][6];
            String[] columnHeaders = {"Name", "Color", "Rent", "Upgrade Level", "Upgrade Cost", "Mortgage value"};

            // Get the Tables Cell renderer to change the background color of the 
            // schedule field to match the color
            //build the table
            int row = 0;
            
            ArrayList<Integer> locations = new ArrayList<Integer>();
            for (Tile tile : playerTiles) {
                locations.add(tile.getLocation());
            }
            
            Collections.sort(locations);
            
            int numUtilities = getNumUtilities(locations);
            int numRailroads = getNumRailroads(locations);
            //Builds the properties table, including, name, color, rent, upgrade level, upgrade cost, and mortgage value
            for (int item : locations) {
                Tile tile = tiles.get(item);
                String place = whatType(tile.getTypeName()); // will be  Property  , Railroad  , Utility  , Other  , Tax  , Chance  , CommunityChest        
                if (place.equals("Property")) {
                    Property property = (Property) tiles.get(item).getType();
                    property.setOwner(player);
                    //.out.println(property);
                    data[row][0] = property.getName();
                    Color color = property.getColor();
                    data[row][1] = String.format("%d, %d, %d", color.getRed(), color.getGreen(), color.getBlue());
                    int upgradeLevel = property.getUpgradeLevel();
                    int currentRent = property.getRent()[upgradeLevel]; //rent
                    data[row][2] = currentRent;
                    
                    data[row][3] = upgradeLevel;

                    //Upgrade Cost	
                    data[row][4] = property.getUpgradeCost();
                    data[row][5] = property.getMortgage();
                    row++;
                } else if (place.equals("Utility")) {
                    Utility utility = (Utility) tile.getType();
                    utility.setOwner(player);
                    data[row][0] = utility.getName();
                    data[row][1] = "";
                    
                    if (numUtilities == 1) {
                        data[row][2] = "4X the roll";
                    } else if (numUtilities == 2) {
                        data[row][2] = "10X the roll";
                    } else {
                        data[row][2] = "";
                    }
                    
                    data[row][3] = " - ";
                    data[row][4] = " - ";
                    data[row][5] = utility.getMortgage();
                    
                    row++;
                    
                } else if (place.equals("Railroad")) {
                    Railroad railroad = (Railroad) tile.getType();
                    railroad.setOwner(player);
                    data[row][0] = railroad.getName();
                    data[row][1] = "";
                    
                    if (numRailroads >= 0) {
                        data[row][2] = railroad.getRent(numRailroads - 1);
                        
                    } else {
                        data[row][2] = "";
                    }
                    
                    data[row][3] = " - ";
                    data[row][4] = " - ";
                    data[row][5] = railroad.getMortgage();
                    
                    row++;
                    
                } else {
                    System.out.println("ERROR: buildTable - wrong type failed");
                    
                }
                
            }
            
            DefaultTableModel dfm = (DefaultTableModel) GameBoard_jTable_Properties.getModel();
            dfm.setDataVector(data, columnHeaders);
            //System.out.println("122222");
            CellColorRenderer cellRenderer = new CellColorRenderer();
            GameBoard_jTable_Properties.setDefaultRenderer(Object.class, cellRenderer);
            //add code to remove numebr in color column 

        } catch (Exception ex) {
            System.out.println("ERROR: buildTable failed");
        }
        
    }

    //returns the number of railroads owned by the player
    private int getNumRailroads(ArrayList<Integer> locations) {
        
        int count = 0;
        for (int item : locations) {
            String typename = tiles.get(item).getTypeName();
            if (typename.equals("Railroad")) {
                count++;
            }
        }
        
        return count;
    }

    //returns the number of utilities owned by the player
    private int getNumUtilities(ArrayList<Integer> locations) {
        
        int count = 0;
        for (int item : locations) {
            String typename = tiles.get(item).getTypeName();
            if (typename.equals("Utility")) {
                count++;
            }
        }
        return count;
    }

    //can return the following values:
    // Property
    // Railroad
    // Utility
    // Other
    // Tax
    // Chance
    // CommunityChest
    private String whatType(String teststring) {
        // Property
        if (teststring.equals("Property") || teststring.contains("Property{")) {
            return "Property";
        } // Railroad
        else if (teststring.equals("Railroad") || teststring.contains("Railroad{")) {
            return "Railroad";
        } // Chance
        else if (teststring.equals("Chance") || teststring.contains("Chance{")) {
            return "Chance";
        } // Community Chest  
        else if (teststring.equals("CommunityChest") || teststring.contains("CommunityChest{")) {
            return "CommunityChest";
        } // Utility
        else if (teststring.equals("Utility") || teststring.contains("Utility{")) {
            return "Utility";
        } // Tax
        else if (teststring.equals("Tax") || teststring.contains("Tax{")) {
            return "Tax";
        } // Other
        else if (teststring.equals("Other") || teststring.contains("Other{")) {
            return "Other";
        } else {
            //System.out.println("missed one in whatType");
        }
        
        return "";
    }

    //checks if the player is bankrupt, factoring in sale of all upgrades and mortgage of all properties
    private boolean isBankrupt() {
        /*
            Checks if the player is bankrupt by checking if the player's total assets
            (upgrades, mortgage values) are greater than the negative balance
            in the player's account
         */
        Player player = players.get(currentPlayer);
        int total = 0;
        if (player.getBalance() < 0) {
            ArrayList<Tile> tiles = player.getTiles();
            if (tiles != null) {
                for (Tile tile : tiles) {
                    
                    if (tile.getTypeName().equals("Property")) {
                        Property property = (Property) tile.getType();
                        int num = property.getUpgradeLevel();
                        while (num > 0) {
                            total += property.getUpgradeCost();
                            num--;
                        }
                        total += property.getMortgage();
                    } else if (tile.getTypeName().equals("Utility")) {
                        
                        Utility utility = (Utility) tile.getType();
                        total += utility.getMortgage();
                        
                    } else if (tile.getTypeName().equals("Railroad")) {
                        
                        Railroad railroad = (Railroad) tile.getType();
                        total += railroad.getMortgage();
                        
                    }
                    
                }
            }
            if (total + player.getBalance() > 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GameBoard_jTable_Properties;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBuyUpgrade;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEndTurn;
    private javax.swing.JButton jButtonGetOutOfJail;
    private javax.swing.JButton jButtonMortgage;
    private javax.swing.JButton jButtonOptions;
    private javax.swing.JButton jButtonPurchase;
    private javax.swing.JButton jButtonRoll;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSellUpgrade;
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JButton jButtonUpgrade;
    private javax.swing.JButton jButton_Mortgage_Property;
    private javax.swing.JButton jButton_Properties;
    private javax.swing.JButton jButton_Unmortgage;
    private javax.swing.JComboBox<String> jComboBox_Mortgage;
    private javax.swing.JComboBox<String> jComboBox_Upgrades;
    private javax.swing.JDialog jDialog_GameOver;
    private javax.swing.JDialog jDialog_Mortgage;
    private javax.swing.JDialog jDialog_Upgrade;
    private javax.swing.JInternalFrame jInternalFrameGameBoard;
    private javax.swing.JInternalFrame jInternalFrameGameBoardProperties;
    private javax.swing.JInternalFrame jInternalFrameMainMenu;
    private javax.swing.JInternalFrame jInternalFrameOptionsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCurrentTurn;
    private javax.swing.JLabel jLabelFinalBalance;
    private javax.swing.JLabel jLabelFinalBalanceValue;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelNumberOfPlayers;
    private javax.swing.JLabel jLabelOptions;
    private javax.swing.JLabel jLabelWinner;
    private javax.swing.JPanel jPanelGameBoard;
    private javax.swing.JRadioButton jRadioButton2Players;
    private javax.swing.JRadioButton jRadioButton3Players;
    private javax.swing.JRadioButton jRadioButton4Players;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBalance;
    private javax.swing.JTextField jTextFieldCurrentPlayer;
    private javax.swing.JTextField jTextFieldLocation;
    private javax.swing.JTextField jTextFieldStartingBalance;
    private javax.swing.JTextField jTextField_MortgageValue;
    private javax.swing.JTextField jTextField_Upgrade_Cost;
    // End of variables declaration//GEN-END:variables
private void changeToGraphicPanelSize() {

        /// jButtonRoll;
        int panelLeftBorder = jPanelGameBoard.getX();
        
        int height = dim.height;

        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  // Get the screen dimension
        Dimension size = new Dimension(jPanelGameBoard.getWidth() + 200, jPanelGameBoard.getHeight() + 200);
        //Dimension size = new Dimension(dim.width,height);

        jPanelGameBoard.setSize(size);
        jPanelGameBoard.setPreferredSize(size);
        
    }
    
    private void checkSets() {
        HashMap<String, Integer> colors = new HashMap<>();
        fullsets = new HashMap<>();
        
        colors.put("brown", 0); //2
        colors.put("lightBlue", 0); //3
        colors.put("pink", 0); //3
        colors.put("orange", 0); //3
        colors.put("red", 0); //3
        colors.put("yellow", 0); //3 
        colors.put("green", 0); //3 
        colors.put("blue", 0); //2 
//Make more effecient
        fullsets.put("brown", 0);
        fullsets.put("lightBlue", 0);
        fullsets.put("pink", 0);
        fullsets.put("orange", 0);
        fullsets.put("red", 0);
        fullsets.put("yellow", 0);
        fullsets.put("green", 0);
        fullsets.put("blue", 0);
        
        for (int playerNum : players.keySet()) {
            ArrayList<Tile> tiles = players.get(playerNum).getTiles();
            if (!(tiles == null)) {
                for (Tile tile : tiles) {
                    if (tile.getTypeName().contains("Property")) {
                        
                        Property property = (Property) tile.getType();
                        if (property.getColorName().equals("brown")) {
                            colors.put("brown", colors.get("brown") + 1);
                            if (colors.get("brown") == 2) {
                                fullsets.put("brown", playerNum);
                            }
                        } else if (property.getColorName().equals("lightBlue")) {
                            colors.put("lightBlue", colors.get("lightBlue") + 1);
                            if (colors.get("lightBlue") == 3) {
                                fullsets.put("lightBlue", playerNum);
                            }
                        } else if (property.getColorName().equals("pink")) {
                            colors.put("pink", colors.get("pink") + 1);
                            if (colors.get("pink") == 3) {
                                fullsets.put("pink", playerNum);
                            }
                        } else if (property.getColorName().equals("orange")) {
                            colors.put("orange", colors.get("orange") + 1);
                            if (colors.get("orange") == 3) {
                                fullsets.put("orange", playerNum);
                            }
                        } else if (property.getColorName().equals("red")) {
                            colors.put("red", colors.get("red") + 1);
                            if (colors.get("red") == 3) {
                                fullsets.put("red", playerNum);
                            }
                        } else if (property.getColorName().equals("yellow")) {
                            colors.put("yellow", colors.get("yellow") + 1);
                            if (colors.get("yellow") == 3) {
                                fullsets.put("yellow", playerNum);
                            }
                        } else if (property.getColorName().equals("green")) {
                            colors.put("green", colors.get("green") + 1);
                            if (colors.get("green") == 3) {
                                fullsets.put("green", playerNum);
                            }
                        } else if (property.getColorName().equals("blue")) {
                            colors.put("blue", colors.get("blue") + 1);
                            if (colors.get("blue") == 2) {
                                fullsets.put("blue", playerNum);
                            }
                        }
                        
                    }
                    
                }
            }
        }
    }
    
    public void UpdateTiles() {
        /*
         * This method will update the tiles to show the players on the tiles
         */
        
        int Oldlocation = players.get(currentPlayer).getPreviousLocation();
        Tile oldtile = tiles.get(Oldlocation);
        for (int j = 0; j < oldtile.getPlayerOccupying().length; j++) {
            if (oldtile.getPlayerOccupying()[j] == currentPlayer) {
                Integer[] PlayerOccupying = oldtile.getPlayerOccupying().clone();
                PlayerOccupying[j] = -1;
                
                oldtile.setPlayerOccupying(PlayerOccupying);
                
                int numOccuping = oldtile.getNumTileOccupied();
                numOccuping--;
                
                oldtile.setNumTileOccupied(numOccuping);
                
                break;
            }
            
        }
        
        Integer[] tempPlayerOccupying = {-1, -1, -1, -1};

        // if there a -1 before any other player it will remove the -1 so the players are always beofre the -1
        for (int j = 0; j < oldtile.getPlayerOccupying().length; j++) {
            if (oldtile.getPlayerOccupying()[j] != -1) {
                for (int t = 0; t < tempPlayerOccupying.length; t++) {
                    if (tempPlayerOccupying[t] == -1) {
                        tempPlayerOccupying[t] = oldtile.getPlayerOccupying()[j];
                        break;
                    }
                }
            }
            
        }
        //System.out.println("\t" + Arrays.toString(tempPlayerOccupying));

        oldtile.setPlayerOccupying(tempPlayerOccupying);
        graphicsPanel.setTiles(tiles);
        
        tiles.put(Oldlocation, oldtile);

        // System.out.println("\t" + tiles.get(Oldlocation).getNumTileOccupied());
        int location = players.get(currentPlayer).getLocation();
        Tile Newtile = tiles.get(location);

//        System.out.println(Newtile.getPlayerOccupying().length + Arrays.toString(Newtile.getPlayerOccupying()));
        for (int j = 0; j < Newtile.getPlayerOccupying().length; j++) {
            if (Newtile.getPlayerOccupying()[j] == -1) {
                
                Integer[] PlayerOccupying = Newtile.getPlayerOccupying().clone();
                PlayerOccupying[j] = currentPlayer;
                
                Newtile.setPlayerOccupying(PlayerOccupying);
                
                int numOccuping = Newtile.getNumTileOccupied();
                numOccuping++;
                
                Newtile.setNumTileOccupied(numOccuping);
                
                break;
            }
            
        }
        tiles.put(location, Newtile);
        graphicsPanel.setTiles(tiles);
        
    }


    // writeModel
    private void writeModel(GameModel model) throws IOException{
        // Writes the model as an object to disk
       
        try {
            
            FileOutputStream    fos = new FileOutputStream(new File(currentFile));
            ObjectOutputStream  oos = new ObjectOutputStream(fos);
            
            oos.writeObject(model);
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    // readModel
    private GameModel readModel() {
    // Reads the model from disk and returns it as an object
    GameModel model = null;
    
    try {
        File file = new File(currentFile);

        // Check if the file is empty
        if (file.length() == 0) {
            System.out.println("model file is null");
            return null;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        model = (GameModel) ois.readObject();
        ois.close();
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
    } 
    
    return model;
}

    
    

    private String getCurrentFileLocation() {
        
        try
        {
        Scanner file = new Scanner(new File("preferences.txt"));
        return file.nextLine();
        }
        
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void writeCurrentFileLocaitonToPreferences() {
        try{
            
            FileWriter writer = new FileWriter("preferences.txt");
            writer.write(currentFile);
            writer.close();
        }
        catch(IOException ex){
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void createPreferancesFile(){
       
            System.out.println("createPreferancesFile");
        try{
            
            
            
            File preferencesFile = new File("preferences.txt");
            if(preferencesFile.exists()){
                preferencesFile.delete();
            }
           preferencesFile.createNewFile();
            
           
            FileWriter writer = null;
            // if currentFile is not null then write it to the file
            if(currentFile != null){
                            writeCurrentFileLocaitonToPreferences();
            }

            else {
                writer = new FileWriter("preferences.txt");
                // create a new file
                try{
                                System.out.println("createPreferancesFile2");

                File modelFile = new File("model");
                modelFile.createNewFile();
                System.out.println(modelFile.getAbsolutePath());
                currentFile = modelFile.getAbsolutePath();
                writer.write(currentFile);
                writer.close();
                } catch(IOException ex){
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            writer.close();
        }
        catch(IOException ex){
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    private void writeModel(){
        // Writes the model as an object to disk
        System.out.println("Written Model");
        GameModel model = new GameModel(tiles,players, fullsets, currentPlayer, numPlayers, defaultMoney, consecutive_doubles, upgrades);
       
        try {
            
            FileOutputStream    fos = new FileOutputStream(new File(currentFile));
            ObjectOutputStream  oos = new ObjectOutputStream(fos);
            
            oos.writeObject(model);
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
}


// the MainWindow class has the following instance variables; 
// private HashMap<Integer, Tile> tiles; // will hold all the tiles in the game, the key is the location of the tile on the board
// private HashMap<Integer, Player> players; // will hold all the players in the game, the key is the player number min 2 max 4
// private HashMap<String, Integer> fullsets; // will hold the full sets of properties, the key is the color of the set
// public Card[] cChestCards = new Card[15]; // will hold all the community chest cards
// public Card[] chanceCards = new Card[13]; // will hold all the chance cards
// private int currentPlayer = 1; // will hold the current player number
// public static int lastRoll; // will hold the last roll of the dice
// public static int numPlayers; // will hold the number of players in the game
// private Cube roll; // will hold the dice roll
// private int defaultMoney = 1500; // will hold the default money for the players
// private GraphicPanel graphicsPanel; // will hold the graphics panel 
// private boolean gotoJail = false; // will hold if the player is going to jail
// private String selectedMortgage = ""; // will hold the selected mortgage 
// private String selectedUpgrade = ""; // will hold the selected upgrade 
// public int consecutive_doubles; // will hold the number of consecutive doubles
// public static Dimension dim; // will hold the screen dimension
// private int upgrades; // will hold the number of upgrades
// private boolean backwards; // will hold if the player is moving backwards
// private boolean changed = false; // will hold if the player has changed

// GameModel class, will store all the data for the game so taht it can be saved and can be loaded from a file
// we can assume that the game will be saved and loaded from a file, and the file will be updated after every turn
// the GameModel class will have the following instance variables
// private HashMap<Integer, Tile> tiles; // will hold all the tiles in the game, the key is the location of the tile on the board
// private HashMap<Integer, Player> players; // will hold all the players in the game, the key is the player number min 2 max 4
// private HashMap<String, Integer> fullsets; // will hold the full sets of properties, the key is the color of the set
// public Card[] cChestCards = new Card[15]; // will hold all the community chest cards
// public Card[] chanceCards = new Card[13]; // will hold all the chance cards
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
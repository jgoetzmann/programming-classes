/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 * Jack Goetzmann
 * November 22
 * Programming 2 - final project
 * 
 * Static class that holds static JFrame used for game and holds methods to 
 * update the visuals of the JFrame and second half of placing units on the grid
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.nio.*;

public class Display {
    
    //// data
    
    // JFrame
    public static JFrame displayJFrame = new JFrame("Game Display");
    
    // "ally" images (idx 1-8)
    private static Image aimg1;
    private static Image aimg2;
    private static Image aimg3;
    private static Image aimg4;
    private static Image aimg5;
    private static Image aimg6;
    private static Image aimg7;
    private static Image aimg8;
    
    // "enemy images" (idx 9-16)
    private static Image eimg1;
    private static Image eimg2;
    private static Image eimg3;
    private static Image eimg4;
    private static Image eimg5;
    private static Image eimg6;
    private static Image eimg7;
    private static Image eimg8;
    
    // "neutral images"
    private static Image neutralimg; // idx 0
    private static Image defaultimg; // idx -1
    
    // relative path for images
    private static String pathToImage;
    
    // global variables
    public static JLabel labelAllyHealth = new JLabel(); // 0
    public static JLabel labelEnemyHealth = new JLabel(); // 1
    public static JLabel labelMoney = new JLabel(); // 2
    public static JLabel labelShields = new JLabel(); // 3
    public static JLabel labelTurn = new JLabel(); // 4
    
    // image placing variables
    public static boolean isPrimed = false; // is searching for a button click
    public static int primedID = -1; // if button clicked found what id to send
    public static boolean isAcceptingActions = true; // will act if click found
        
    //// constructors
    
    public Display() throws IOException {
                       
        pathToImage = System.getProperty("user.dir");
        
        // image declaration
        aimg1 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyShooterUnit.jpg"));
        aimg2 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyProtectorUnit.jpg"));
        aimg3 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyWizardUnit.jpg"));
        aimg4 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyLancerUnit.jpg"));
        aimg5 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllySenatorUnit.jpg"));
        aimg6 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyLobberUnit.jpg"));
        aimg7 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyQueenUnit.jpg"));
        aimg8 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\AllyShieldUnit.jpg"));

        eimg1 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyShooterUnit.jpg"));
        eimg2 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyProtectorUnit.jpg"));
        eimg3 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyWizardUnit.jpg"));
        eimg4 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyLancerUnit.jpg"));
        eimg5 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemySenatorUnit.jpg"));
        eimg6 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyLobberUnit.jpg"));
        eimg7 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyQueenUnit.jpg"));
        eimg8 = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EnemyShieldUnit.jpg"));
        
        neutralimg = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\NeutralUnit.jpg"));
        defaultimg = ImageIO.read(new File(pathToImage + "\\src\\main\\java\\FinalProject\\Assets\\EmptyUnit.jpg"));    
        
        // creates actions buttons
        for (int i = 0; i <= 8; i++) {
            switch (i) {
                case 0 -> {
                    ActionButton toAdd = new ActionButton(680, 
                            500, i);
                    displayJFrame.add(toAdd.getJButton());                    
                }
                case 1, 3, 5, 7 -> {
                    int offSetVal = i / 2;
                    ActionButton toAdd = new ActionButton(680, 
                            20 + offSetVal * 120, i);
                    displayJFrame.add(toAdd.getJButton());                    
                }
                case 2, 4, 6, 8 -> {
                    int offSetVal = (i / 2 - 1);
                    ActionButton toAdd = new ActionButton(800,
                            20 + offSetVal * 120, i);
                    displayJFrame.add(toAdd.getJButton());    
                }
            }
        }

        // creaes labels for global variables that update
        labelAllyHealth.setText("Health: " + Board.globalAllyHealth);
        labelAllyHealth.setBounds(940, 20, 160, 20);
        displayJFrame.add(labelAllyHealth);
        labelEnemyHealth.setText("Enemy Health: " + Board.globalEnemyHealth);
        labelEnemyHealth.setBounds(940, 40, 160, 20);
        displayJFrame.add(labelEnemyHealth);
        labelMoney.setText("Money: " + Board.globalMoney);
        labelMoney.setBounds(940, 60, 160, 20);
        displayJFrame.add(labelMoney);
        labelShields.setText("Free Shields Left: " + Board.globalShields);
        labelShields.setBounds(940, 80, 160, 20);
        displayJFrame.add(labelShields);
        labelTurn.setText("Turn: " + Board.globalTurn);
        labelTurn.setBounds(940, 100, 160, 20);
        displayJFrame.add(labelTurn);
                      
        // default JFrame settings
        displayJFrame.setSize(1280,720);
        displayJFrame.setLayout(null);
        displayJFrame.setVisible(true);
        displayJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    //// accessors and mutators
    
    //// other methods
    
    // takes image number and returns image based on its number (indexing)
    public static Image getImage(int imgNum) {
        switch(imgNum) {
            case 0 -> {return neutralimg;}
            case 1 -> {return aimg1;}
            case 2 -> {return aimg2;}
            case 3 -> {return aimg3;}
            case 4 -> {return aimg4;}
            case 5 -> {return aimg5;}
            case 6 -> {return aimg6;}
            case 7 -> {return aimg7;}
            case 8 -> {return aimg8;}
            case 9 -> {return eimg1;}
            case 10 -> {return eimg2;}
            case 11 -> {return eimg3;}
            case 12 -> {return eimg4;}
            case 13 -> {return eimg5;}
            case 14 -> {return eimg6;}
            case 15 -> {return eimg7;}
            case 16 -> {return eimg8;}
            default -> {return defaultimg;}
        }
    }
        
    // a method that updates global variable labels
    public static void updateGlobalVariableUI() {
        labelAllyHealth.setText("Health: " + Board.globalAllyHealth);
        labelEnemyHealth.setText("Enemy Health: " + Board.globalEnemyHealth);
        labelMoney.setText("Money: " + Board.globalMoney);
        labelShields.setText("Free Shields Left: " + Board.globalShields);
        labelTurn.setText("Turn: " + Board.globalTurn);
    }
    
    // a method that constructs JButtons with action listeners
    public static Component createButton(int x, int y, int imgNum) {
        JButton toAdd = new JButton("x:" + x + " y:" + y);
        int xPos = 20 + (80 * x); // finds x position using x
        int yPos = 20 + (80 * y); // finds y position using y
        toAdd.setBounds(xPos, yPos, 80, 80);
        toAdd.setIcon(new ImageIcon(getImage(imgNum)));
        toAdd.addActionListener(new ActionListener() {
            // sets sendx and sendy to x and y so when clicked it can send data
            final int sendX = x;
            final int sendY = y;
            // anonymous method that onclick sends values to a unit creator                   
            @Override
            public void actionPerformed(ActionEvent e) { 
                placeUnit(sendX, sendY); // sends data 
//                System.out.println(sendX + "," + sendY); // prints cord pair
            }
        });
        return toAdd; // returns button to be added
    }
    
    // a method that removes and replaces a button at x,y using img
    public static void replaceButton(int x, int y, int imgNum) {
        int xPos = 20 + (80 * x); // finds x position using x
        int yPos = 20 + (80 * y); // finds y position using y
        // gets content jframe content pane and removes the button at xpos,ypox
        displayJFrame.getContentPane().remove(displayJFrame.
                getContentPane().getComponentAt(xPos, yPos));
        // creates new button and adds it to the JFrame
        displayJFrame.add(createButton(x, y, imgNum));
//        System.out.println("replaced button " + x + "," + y + " w:" + imgNum);
        displayJFrame.getContentPane().setVisible(false); // force updates UI
        displayJFrame.getContentPane().setVisible(true); // force updates UI
    }
    
    // on grid button click tries to place unit
    public static void placeUnit(int primedX, int primedY) {
        if (isPrimed && // if primed is true
                isAcceptingActions && // if the grid is accepting actions
                // if board tile is empty
                Board.unitGrid[primedY][primedX].getUnitID() == -1
                && primedY > 3) { // if on ally side
            System.out.println("placement success @ " +
                    primedX + "," + primedY);
            // replaces button at x,y with prime id
            replaceButton(primedX, primedY, primedID);
            Board.addUnit(primedX, primedY, primedID);
            // subtracts resource cost after successful place
            switch (primedID) {
                case 1, 2 -> {Board.globalMoney -= 1;}
                case 3 -> {Board.globalMoney -= 2;}
                case 4 -> {Board.globalMoney -= 3;}
                case 5, 6 -> {Board.globalMoney -= 4;}
                case 7 -> {Board.globalMoney -= 5;}
                case 8 -> {Board.globalShields -= 1;}
            }
            updateGlobalVariableUI(); // refreshes resource UI
            isPrimed = false; // refreshes primed variable
            primedID = -1; // refreshed primed variable
        } else { // log data fell
            System.out.println("placement failed @" + primedX + "," + primedY);
        }
    }
    
    // to string (self explanatory)
    @Override
    public String toString() {
        String str = "";
        str += "JFrame: " + displayJFrame.getContentPane() + "\n";
        str += "JFrame comp count: " + displayJFrame.getContentPane().
                getComponentCount() + "\n";
        str += "JFrame comps: " + Arrays.toString(displayJFrame.
                getContentPane().getComponents()) + "\n";
        return str;
    }
    
}
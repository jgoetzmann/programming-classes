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
 * Object that holds a JButton and uses a constructor to create it so it can be
 * added to a button grid easily
 */

import java.awt.event.*;
import javax.swing.*;

public class ActionButton {
    
    //// data
    
    // JButton
    private JButton button;
    
    // location variables
    private int xPosition;
    private int yPosition;
    private int buttonID;
        
    // constructor
    public ActionButton(int xPosition, int yPosition, int buttonID) {
        
        // initializes location variables
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.buttonID = buttonID;
        
        // creates a new JButton and sets it position, width, and height
        button = new JButton("ID: " + buttonID);
        button.setBounds(xPosition, yPosition, 120, 120);
        
        // places actionlistener and sets text and size for each button 
        // based on button ID
        switch (buttonID) {
            case 0 -> { // end turn
                button.setBounds(xPosition, yPosition,
                        240, 120);
                button.setText("end turn");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.endTurn();
                });
            }            
            case 1 -> { // shooter
                button.setText("1$ - Shooter");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action1();
                });
            }
            case 2 -> { // protector
                button.setText("1$ - Protector");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action2();
                });
            }
            case 3 -> { // wizard
                button.setText("2$ - Wizard");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action3();
                });
            }
            case 4 -> { // lancer
                button.setText("3$ - Lancer");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action4();
                });
            }
            case 5 -> { // senator
                button.setText("4$ - Senator");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action5();
                });
            }
            case 6 -> { // lobber
                button.setText("4$ - Lobber");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action6();
                });
            }
            case 7 -> { // queen
                button.setText("5$ - Queen");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action7();
                });
            }
            case 8 -> { // shield
                button.setText("Free - Shield");
                button.addActionListener((ActionEvent e) -> {
                    ActionButtonLogic.action8();
                });
            }
        }
    }
    
    //// accessors and mutators
        
    public JButton getJButton() {
        return button;
    }
    
    //// other methods
    
    // to string
    @Override
    public String toString() {
        String str = "";
        str += "xPosition: " + xPosition + "\n";
        str += "yPosition: " + yPosition + "\n";
        str += "buttonID: " + buttonID + "\n";
        return str;
    }
    
}

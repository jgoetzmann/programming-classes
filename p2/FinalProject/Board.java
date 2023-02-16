/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.awt.event.*;
import java.util.Arrays; // avoids overlap with javax.swing.timer
import javax.swing.*;

/**
 * Jack Goetzmann
 * November 22
 * Programming 2 - final project
 * 
 * Static class that holds static unit grid used for game and holds methods to 
 * update the internals of the game and holds the main end turn method
 */

public class Board {
    
    //// data
    
    // global/game variables
    public static int globalAllyHealth = 25; // ally health
    public static int globalEnemyHealth = 25; // enemy health
    public static int globalMoney = 1; // money
    public static int globalShields = 1; // num of shields
    public static int globalTurn = 1; // turn
//    public static boolean globalIsAlive = true;
    
    public static int moveOrderIteration = 1; // used for end turn updates
    
    public static Unit[][] unitGrid = new Unit[8][8];    
    
    //// constructor
    
    public Board() {
        // fills board half with empty and half with black units
        for (int i = 0; i < unitGrid.length; i++) { // y array
            for (int j = 0; j < unitGrid.length; j++) { // x array
                if (j < 4) {
                    unitGrid[i][j] = new EmptyUnit(j, i);                    
                } else if (j < 8) {
                    unitGrid[i][j] = new NeutralUnit(j, i);
                }
            }
        }    
    }
    
    //// accessors and mutators
    
    //// other methods
    
    // method that add a unit
    public static void addUnit(int xPos, int yPos, int unitID) {
        Unit toAdd = unitIDtoUnit(xPos, yPos, unitID);
        unitGrid[yPos][xPos] = toAdd;
        System.out.println("Placed: " + toAdd);
    }
         
    // method that increaments a turn on internal board and updates external to
    // match that change. This is the "main" method that makes the game function
    public static void endTurnUpdate() {
        System.out.println("\n\nTurn Start n:" + globalTurn); // document start
        Display.isAcceptingActions = false; // stop user from editing board
        int delay = 1000; // 1 sec delay
        EnemySpawnData.spawnEnemyUnits(globalTurn); // spawn enemy units
        updateDisplayUI(); // updates grid ui after seeing enemies
        ActionListener taskPerformer = (ActionEvent e) -> {
            System.out.println("Action Phase: " + moveOrderIteration);
            if (moveOrderIteration > 5) { // after all action phases are coded
                prepareForNextTurn(); // gets new global variables
                updateDisplayUI(); // updates grid ui
                Display.updateGlobalVariableUI(); // upates global vaiables
                for (Unit[] arr : unitGrid) {
                    System.out.println(Arrays.toString(arr));
                }
                ((Timer)e.getSource()).stop(); // end timer
                moveOrderIteration = 1; // resets action phase
                Display.isAcceptingActions = true; // allow user to edit board
                // document end
                System.out.println("Turn End n:" + (globalTurn - 1) + "\n\n");
            } else {
                // calls units to attack
                attackBoardUpdate(moveOrderIteration);
                updateDisplayUI(); // updates ui
                moveOrderIteration++; // increaments by 1          
            }
        };
        // creates a timer to better show the progression of a turn
        Timer timer = new Timer(delay, taskPerformer);
        timer.setInitialDelay(delay);
        timer.start();
    }
    
    // a method that changes global variables in prep for next turn
    public static void prepareForNextTurn() {
        
        globalTurn++; // increaments round num
        
        // checks for win/loss
        if (globalAllyHealth <= 0) {
            // lose
        } else if (globalEnemyHealth <= 0) {
            // win
        }

        // gives money and shields for next round
        if (globalTurn >= 10) { // caps money at 10 and sields at 5
            globalMoney = 10; // money = 10
            globalShields = 5; // shields = 5
        } else { 
            globalMoney = globalTurn; // money for turn = turn number         
            globalShields = (globalTurn / 2); // shields for turn = turn number
        }
        
        // removes neutral units with empty units
        if (globalTurn <= 5) {
            for (int i = 0; i < unitGrid.length; i++) { // y array
                addUnit(globalTurn + 2, i, -1);
            }
        } 
    }
    
    // loops through grid and updates the displayUI based on the unit ID
    public static void updateDisplayUI() {
        for (int i = 0; i < unitGrid.length; i++) { // y array
            for (int j = 0; j < unitGrid.length; j++) { // x array
                Display.replaceButton(j, i, // replaces display button
                        unitGrid[i][j].getUnitID());
            }
        }
    }
    
    // clears any units with less than 1 hp and are not neutral
    public static void clearDeadUnits() {
        for (int i = 0; i < unitGrid.length; i++) { // y array
            for (int j = 0; j < unitGrid.length; j++) { // x array
                if (unitGrid[i][j].getHealth() <= 0 &&
                        !unitGrid[i][j].getIsNeutral()) { // if unit is dead
                    // replace with empty tile
                    unitGrid[i][j].death(); 
                }
            }
        }
    }    
    
    // calculates damage for a singular point
    public static void damagePoint(int xPos, int yPos, boolean isAlly,
            int attackValue) {
        if (isAlly) { // ally
            if (!unitGrid[yPos][xPos].getIsAlly() && !unitGrid[yPos][xPos].
                    getIsNeutral()) { // if enemy and not neutral
                unitGrid[yPos][xPos].setHealth(attackValue);
            }
        } else { // enemy
            if (unitGrid[yPos][xPos].getIsAlly() && !unitGrid[yPos][xPos].
                    getIsNeutral()) { // if ally and not neutral
                unitGrid[yPos][xPos].setHealth(attackValue);
            }
        }       
    }
    
    // calculates damage for a unit on a vertical line
    public static void damageVeritcalLane(int xAxis, boolean isAlly,
            int attackValue) {
//        System.out.println("vert line attack");
        boolean targetFound = false;
        if (isAlly) { // if ally is attacking
            for (int i = (unitGrid.length - 1); i >= 0; i--) { // x axis
                if (!unitGrid[i][xAxis].getIsAlly() && !unitGrid[i][xAxis].
                        getIsNeutral()) { // if enemy and not neutral
                    unitGrid[i][xAxis].setHealth(attackValue);
                    targetFound = true; // found target so dont player hp
                    i = -1; // breaks for loop
                }
            }
            if (!targetFound) { // if target has not been found
                globalEnemyHealth -= attackValue;
            }
        } else { // if enemy is attacking
            for (int i = 0; i < unitGrid.length; i++) { // x axis
                if (unitGrid[i][xAxis].getIsAlly() && !unitGrid[i][xAxis].
                        getIsNeutral()) { // if ally and not neutral
                    unitGrid[i][xAxis].setHealth(attackValue);
                    targetFound = true; // found target so dont player hp
                    i = unitGrid.length; // breaks for loop
                }
            }
            if (!targetFound) { // if target has not been found
                globalAllyHealth -= attackValue;
            }        
        }
    }
        
    // a method that loops through board and calls attack for each capable unit
    public static void attackBoardUpdate(int currentMoveOrder) {
        for (int j = unitGrid.length-1; j >= 0; j--) { // x array
            for (int i = unitGrid.length - 1; i >= 0; i--) { // y array
                // if not neutral and move order is equal to move order
                if (unitGrid[i][j].getMoveOrder() == currentMoveOrder &&
                        !unitGrid[i][j].isNeutral) { // not empty or black unit
                    unitGrid[i][j].unitAction(); // calls unit to attack
                    clearDeadUnits(); // removes any dead units
                }
            }
        }
    }
    
    // takes a unitID and a x and y and returns a unit based of the values
    public static Unit unitIDtoUnit(int xPos, int yPos, int unitID) {
        switch (unitID) {
            // black unit
            case 0 -> {return new NeutralUnit(xPos, yPos);}
            // ally units
            case 1 -> {return new ShooterUnit(xPos, yPos, true, unitID);}
            case 2 -> {return new ProtectorUnit(xPos, yPos,
                    true, unitID);}
            case 3 -> {return new WizardUnit(xPos, yPos, true, unitID);}
            case 4 -> {return new LancerUnit(xPos, yPos, true, unitID);}
            case 5 -> {return new SenatorUnit(xPos, yPos, true, unitID);}
            case 6 -> {return new LobberUnit(xPos, yPos, true, unitID);}
            case 7 -> {return new QueenUnit(xPos, yPos, true, unitID);}
            case 8 -> {return new ShieldUnit(xPos, yPos, true, unitID);}
            // enemy units
            case 9 -> {return new ShooterUnit(xPos, yPos,
                    false, unitID);}
            case 10 -> {return new ProtectorUnit(xPos, yPos,
                    false, unitID);}
            case 11 -> {return new WizardUnit(xPos, yPos, false, unitID);}
            case 12 -> {return new LancerUnit(xPos, yPos, false, unitID);}
            case 13 -> {return new SenatorUnit(xPos, yPos,
                    false, unitID);}
            case 14 -> {return new LobberUnit(xPos, yPos, false, unitID);}
            case 15 -> {return new QueenUnit(xPos, yPos, false, unitID);}
            case 16 -> {return new ShieldUnit(xPos, yPos, false, unitID);}
            // empty unit (-1)
            default -> {return new EmptyUnit(xPos, yPos);}
        }
    }
    
    // to string
    @Override
    public String toString() {
        String str = "";
        for (Unit[] arr : unitGrid) {
            System.out.println(Arrays.toString(arr));
        }
        return str;
    }
    
}

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
 * Unit that deals medium damage in adjacent lanes
 */

public class SenatorUnit extends Unit {
    
    public SenatorUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Senator";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 3;
        moveOrder = 3;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        if (xPos > 0) { // (avoid index out of bounds error)
            Board.damageVeritcalLane(xPos - 1, isAlly, 2);
        }
        if (xPos < 7) { // (avoid index out of bounds error)
            Board.damageVeritcalLane(xPos + 1, isAlly, 2);
        }
    }
}

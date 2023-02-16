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
 * Unit that attacks in a straight line
 */

public class ShooterUnit extends Unit {
    
    public ShooterUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Shooter";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 1;
        moveOrder = 3;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        Board.damageVeritcalLane(xPos, isAlly, 1);
    }
}

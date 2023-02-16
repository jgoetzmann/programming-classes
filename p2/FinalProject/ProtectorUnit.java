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
 * Unit that can does nothing then dies at the end of a turn
 */

public class ProtectorUnit extends Unit {
           
    public ProtectorUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Protector";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 1;
        moveOrder = 1;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        if (isAlly) { // if ally
            if (xPos < 7) { // if not on edge
                // tile placement is blank
                if (Board.unitGrid[yPos][xPos+1].getUnitID() == -1) {
                    Board.addUnit(xPos+1, yPos, 8);
                }
            }
        } else { // if not ally
            if (xPos < 7) { // if not on edge
                // tile placement is blank
                if (Board.unitGrid[yPos][xPos+1].getUnitID() == -1) {
                    Board.addUnit(xPos+1, yPos, 16);                    
                }
            }
        }
    }
    
}

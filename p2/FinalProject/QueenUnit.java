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
 * Unit that spawns units in front of it to attack
 */

public class QueenUnit extends Unit {
           
    public QueenUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Queen";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 3;
        moveOrder = 1;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        for (int i = -1; i <= 1; i++) {
            if (isAlly) { // if ally
                if (!(xPos + i < 0) && !(xPos + i > 7)) { // checks out of grid
                    if (Board.unitGrid[yPos-1][xPos+i].getUnitID() == -1) {
                        Board.addUnit(xPos+i, yPos-1, 1);
                    }
                }
            } else { // if not ally
                if (!(xPos + i < 0) && !(xPos + i > 7)) { // checks out of grid
                    if (Board.unitGrid[yPos+1][xPos+i].getUnitID() == -1) {
                        Board.addUnit(xPos+i, yPos+1, 9);
                    }
                }
            }               
        }
    }
}

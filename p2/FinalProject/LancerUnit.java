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
 * Unit that attacks up to three tiles in front dealing decreasing damage
 */

public class LancerUnit extends Unit {
           
    public LancerUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Lancer";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 2;
        moveOrder = 2;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        for (int i = 1; i <= 3; i++) { // 3 iterations
            if (isAlly) { // if ally
                Board.damagePoint(xPos, yPos-i, true, 4-i);
            } else { // if not ally
                Board.damagePoint(xPos, yPos+i, false, 4-i);
            }               
        }
    }
    
}

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
 * Empty unit that units cannot be placed on
 */

public class NeutralUnit extends Unit {    
   
    public NeutralUnit(int xPos, int yPos) {
        
        name = "Neutral";
        unitID = 0;
        isNeutral = true;
        isAlly = false;
        this.xPos = xPos;
        this.yPos = yPos;
        health = -1;
        moveOrder = -1;
        
    }

    @Override
    public void unitAction() {}
}

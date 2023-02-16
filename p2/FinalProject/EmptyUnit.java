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
 * Empty unit that units can be placed on
 */

public class EmptyUnit extends Unit {
    
    public EmptyUnit(int xPos, int yPos) {
        
        name = "Empty";
        unitID = -1;
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

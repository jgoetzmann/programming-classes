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
 * Unit that deals damage from far distances
 */

public class LobberUnit extends Unit {
        
    public LobberUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Lobber";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 2;
        moveOrder = 3;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        if (isAlly) { // if ally
            if ((xPos - 1 >= 0) && (yPos - 5 >= 0)) { // left of target
                Board.damagePoint(xPos-1, yPos-5, isAlly, 1);                                    
            }
            if (yPos - 4 >= 0) { // down of target
                Board.damagePoint(xPos, yPos-4, isAlly, 1);                                                    
            }
            if (yPos - 6 >= 0) { // up of target
                Board.damagePoint(xPos, yPos-6, isAlly, 1);                                                                    
            }
            if ((xPos + 1 <= 7) && (yPos - 5 >= 0)) { // right of target
                Board.damagePoint(xPos+1, yPos-5, isAlly, 1);                                    
            }
            if (yPos - 5 >= 0) { // target
                Board.damagePoint(xPos, yPos-5, isAlly, 3);                                                                    
            }            
            if (yPos - 5 < 0) { // checks if target clips enemy
                Board.globalEnemyHealth -= 3;
            } else if (yPos - 6 < 0) { // checks if up target clips enemy
                Board.globalEnemyHealth -= 1;
            }
        } else { // if not ally
            if ((xPos - 1 >= 0) && (yPos + 5 <= 7)) { // left of target
                Board.damagePoint(xPos-1, yPos+5, isAlly, 1);                                    
            }
            if (yPos + 4 <= 7) { // down of target
                Board.damagePoint(xPos, yPos+4, isAlly, 1);                                                    
            }
            if (yPos + 6 <= 7) { // up of target
                Board.damagePoint(xPos, yPos+6, isAlly, 1);                                                                    
            }
            if ((xPos + 1 <= 7) && (yPos + 5 <= 7)) { // right of target
                Board.damagePoint(xPos+1, yPos+5, isAlly, 1);                                    
            }
            if (yPos + 5 <= 7) { // target
                Board.damagePoint(xPos, yPos+5, isAlly, 3);                                                                    
            }            
            if (yPos + 5 > 7) { // checks if target clips enemy
                Board.globalAllyHealth -= 3;
            } else if (yPos + 6 > 7) { // checks if up target clips enemy
                Board.globalAllyHealth -= 1;
            }            
        }               
    }
    
}

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
 * Unit that attacks diagonally dealing massive damage
 */

public class WizardUnit extends Unit{
           
    public WizardUnit(int xPos, int yPos, boolean isAlly, int unitID) {
        
        name = "Wizard";
        this.unitID = unitID;
        isNeutral = false;        
        this.isAlly = isAlly;
        this.xPos = xPos;
        this.yPos = yPos;
        health = 1;
        moveOrder = 4;
        
    }

    @Override
    public void unitAction() {
        System.out.println("unit @" + xPos + "," + yPos + " attacking");
        if (isAlly) { // if ally
            // projectile 1
            for (int i = 1; i <= 7; i++) {
                // if in bounds and enemy that isnt neutral
                if (!(xPos - i < 0) && !(yPos - i < 0)
                        && !(Board.unitGrid[yPos-i][xPos-i].isAlly)
                        && !(Board.unitGrid[yPos-i][xPos-i].isNeutral)) {
                    Board.damagePoint(xPos-i, yPos-i, isAlly, 3);
                    i = 8; // breaks loop
                } // if in x bounds but out of y bounds
                else if (!(xPos - i < 0) && (yPos - i < 0)) {
                    Board.globalEnemyHealth -= 3;
                    i = 8; // breaks loop
                }
            } 
            // projectile 2
            for (int i = 1; i <= 7; i++) {
                // if in bounds and enemy that isnt neutral
                if (!(xPos + i > 7) && !(yPos - i < 0)
                        && !(Board.unitGrid[yPos-i][xPos+i].isAlly)
                        && !(Board.unitGrid[yPos-i][xPos+i].isNeutral)) {
                    Board.damagePoint(xPos+i, yPos-i, isAlly, 3);
                    i = 8; // breaks loop
                } // if in x bounds but out of y bounds
                else if (!(xPos + i > 7) && (yPos - i < 0)) {
                    Board.globalEnemyHealth -= 3;
                    i = 8; // breaks loop
                }
            }             
        } else { // if not ally
            // projectile 1
            for (int i = 1; i <= 7; i++) {
                // if in bounds and enemy that isnt neutral
                if (!(xPos - i < 0) && !(yPos + i > 7)
                        && (Board.unitGrid[yPos+i][xPos-i].isAlly)
                        && !(Board.unitGrid[yPos+i][xPos-i].isNeutral)) {
                    Board.damagePoint(xPos-i, yPos+i, isAlly, 3);
                    i = 8; // breaks loop
                } // if in x bounds but out of y bounds
                else if (!(xPos - i < 0) && (yPos + i > 7)) {
                    Board.globalAllyHealth -= 3;
                    i = 8; // breaks loop
                }
            } 
            // projectile 2
            for (int i = 1; i <= 7; i++) {
                // if in bounds and enemy that isnt neutral
                if (!(xPos + i > 7) && !(yPos + i > 7)
                        && (Board.unitGrid[yPos+i][xPos+i].isAlly)
                        && !(Board.unitGrid[yPos+i][xPos+i].isNeutral)) {
                    Board.damagePoint(xPos+i, yPos+i, isAlly, 3);
                    i = 8; // breaks loop
                } // if in x bounds but out of y bounds
                else if (!(xPos + i > 7) && (yPos + i > 7)) {
                    Board.globalAllyHealth -= 3;
                    i = 8; // breaks loop
                }
            }             
        }               
    }    
}

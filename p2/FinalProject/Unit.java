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
 * Abstract class that is inherited by all units
 */

public abstract class Unit {
    
    //// data
    
    // identifying data
    protected String name; // helps debug
    protected int unitID; // determines what the unit see below
    /*
     -1 -> empty
     0 -> blocker/black/neutral tile
     1 -> ally shooter
     2 -> ally protector
     3 -> ally wizard
     4 -> ally lancer
     5 -> ally senator
     6 -> ally lobber
     7 -> ally queen
     8 -> ally shield
     9 -> enemy shooter
     10 -> enemy protector
     11 -> enemy wizard
     12 -> enemy lancer
     13 -> enemy senator 
     14 -> enemy lobber 
     15 -> enemy queen
     16 -> enemy shield
    */
    protected boolean isAlly; // determines attack logic
    protected boolean isNeutral; // if neutral wont be considered in attacks
  
    // changable data
    protected int xPos; // x position
    protected int yPos; // y position
    protected int health; // health 
    protected int moveOrder; // determines when the unit attacks see below
    /*
     units attack moveOrder 1-5 then x 0->7 then y 7->0
     1 -> summoners (protector, queen)
     2 -> first strike attacks (lancer)
     3 -> normal attacks (shooter, senator, lobber)
     4 -> slow attacks (wizard)
     5 -> shields (they destroy themselves)
    */
    
    //// accessor and mutators
    
    public int getUnitID() {
        return unitID;
    }
    
    public boolean getIsNeutral() {
        return isNeutral;
    }
    
    public boolean getIsAlly() {
        return isAlly;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMoveOrder() {
        return moveOrder;
    }
    
    public void setHealth(int healthLost) {
        health -= healthLost;
    }
    
    // if not neutral and health < 0 then replaces itself with a empty tile
    public void death() {
        Board.addUnit(xPos, yPos, -1);
    };
    
    // determines unique attacking behavior
    public abstract void unitAction();
    
    // to string
    @Override
    public String toString() {
        String outputStr = name + "(" + unitID + ") @" + xPos + "," + yPos 
                + " a:" + isAlly + "(" + health + ")";
        return outputStr;
    }
}

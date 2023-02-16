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
 * File that holds methods that can randomly spawn units 
 */

public class EnemySpawnData {
    
    // the turn and call other methods to fill the board based off of that
    public static void spawnEnemyUnits(int turn) {
        switch (turn) {
            case 1 -> { // 3 -3 
                hardCodedPlace(0, 3, 16); // shield
                tryToPlace(0, 0, 10, 1); // protector
                tryToPlace(0, 1, 9, 1); // shooter
                tryToPlace(2, 3, 9, 1); // shooter
            }
            case 2 -> {
                tryToPlace(0, 4, 9, 1); // shooter
                tryToPlace(0, 4, 11, 2); // wizard
            }
            case 3 -> {
                tryToPlace(0, 5, 10, 1); // protector
                tryToPlace(0, 5, 12, 3); // lancer
            }
            case 4 -> {
                tryToPlace(0, 6, 9, 4); // shooter
                tryToPlace(0, 5, 10, 4); // protector
            }
            case 5 -> {
                tryToPlace(7, 7, 11, 1); // wizard    
                hardCodedPlace(7, 0, 11); // wizard
                tryToPlace(1, 4, 14, 1); // lobber    
                tryToPlace(1, 6, 12, 2); // lancer    
            }
            case 6, 7 -> {
                tryToPlace(1, 6, 13, 1); // senator
                tryToPlace(0, 5, 9, 3); // shooter
                tryToPlace(0, 4, 10, 3); // protector
            }
            case 8, 9 -> {
                tryToPlace(1, 6, 15, 1); // queen
                tryToPlace(0, 2, 11, 2); // wizard
                tryToPlace(0, 7, 12, 2); // lancer
                tryToPlace(0, 7, 9, 3); // shooter
            }
            case 10 -> { // 16 - 7
                hardCodedPlace(0, 3, 16); // shield
                hardCodedPlace(1, 3, 16); // shield
                hardCodedPlace(2, 3, 16); // shield
                hardCodedPlace(6, 3, 16); // shield
                hardCodedPlace(7, 3, 16); // shield
                hardCodedPlace(4, 0, 15); // queen
                hardCodedPlace(4, 2, 15); // queen
                tryToPlace(3, 5, 13, 4); // senator
                tryToPlace(0, 2, 14, 2); // lobber
                tryToPlace(6, 7, 14, 1); // lobber
            }
            default -> {
                if (turn % 5 == 0) { // every 5 (15, 20, 25...)
                    tryToPlace(0, 7, 15, (turn/5) - 1); // queen
                }
                if (turn % 2 == 1) { // every odd (11, 13, 15...)
                    tryToPlace(0, 7, 13, (turn/3)-2); // senator 
                    tryToPlace(0, 7, 12, (turn/3)-1); // lancer
                    tryToPlace(0, 6, 10, (turn/3)); // protector   
                }
                if (turn % 2 == 0) { // every even (12, 14, 16...)
                    tryToPlace(0, 7, 14, (turn/3)-2); // lobber
                    tryToPlace(0, 7, 11, (turn/3)-1); // wizard
                    tryToPlace(0, 7, 9, (turn/3)); // shooter                    
                }
            }
        }
    }
    
    // takes x and y locations and a unit ID and places a unit there
    public static void hardCodedPlace(int xPos, int yPos, int unitID) {
        Board.addUnit(xPos, yPos, unitID);
    }
    
    // takes a range of locations an ID and a amount and places that many units
    public static void tryToPlace(int minX, int maxX, int unitID, int amount) {
        for (int i = 0; i < amount; i++) { // loops through based on amount
            for (int j = 0; j < 1000; j++) { // tries 1000 times to place
                int randomX = getRandomNum(minX, maxX); // gets randomX
                int randomY = getRandomNum(0, 3); // gets randomY
                // if tile isnt filled at that location add the unit
                if (Board.unitGrid[randomY][randomX].getUnitID() == -1) {
                    Board.addUnit(randomX, randomY, unitID);
                    j = 1000; // breaks loop
                }
            }
        }
    }
    
    // takes a min and max value and generates a val between them
    public static int getRandomNum(int min, int max) {
        int range = max - min + 1; // finds range
        return (int)(Math.random() * range) + min; // returns num (inclusive)
    }
}

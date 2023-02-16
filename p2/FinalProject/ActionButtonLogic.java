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
 * File that holds methods that are called by the first step of action buttons
 */

public class ActionButtonLogic {

    // calls endturnupdate on click
    public static void endTurn() {
        Board.endTurnUpdate();
//        System.out.println("End turn");
    }
    
    //// methods below are first part of the user placing unit process 
    
    // shooter
    public static void action1() {
        System.out.println("Action 1"); // records click
        if (Board.globalMoney >= 1) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 1; // records ID of what to add            
        }
    }
    
    // protector
    public static void action2() {
        System.out.println("Action 2"); // records click
        if (Board.globalMoney >= 1) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 2; // records ID of what to add            
        }
    }
    
    // wizard
    public static void action3() {
        System.out.println("Action 3"); // records click
        if (Board.globalMoney >= 2) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 3; // records ID of what to add            
        }   
    }
    
    // lancer
    public static void action4() {
        System.out.println("Action 4"); // records click
        if (Board.globalMoney >= 3) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 4; // records ID of what to add            
        }   
    }
    
    // senator
    public static void action5() {
        System.out.println("Action 5"); // records click
        if (Board.globalMoney >= 4) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 5; // records ID of what to add            
        }    
    }
    
    // lobber
    public static void action6() {
        System.out.println("Action 6"); // records click
        if (Board.globalMoney >= 4) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 6; // records ID of what to add            
        } 
    }
    
    // queen
    public static void action7() {
        System.out.println("Action 7"); // records click
        if (Board.globalMoney >= 5) { // if not enough money
            Display.isPrimed = true; // primes place action
            Display.primedID = 7; // records ID of what to add            
        }   
    }
    
    // shield (unique uses shield count instead of money)
    public static void action8() {
        System.out.println("Action 8"); // records click
        if (Board.globalShields >= 1) { // if not enough shields
            Display.isPrimed = true; // primes place action
            Display.primedID = 8; // records ID of what to add            
        }      
    }
        
}

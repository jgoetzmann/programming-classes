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
 * Class that calls upon other classes to run a game
 */

import java.io.*;

public class Antumbra {
        
    public static void main(String[] args) throws IOException {
         
        // initalizes game
        Display display = new Display(); 
        Board board = new Board();
        Board.updateDisplayUI(); 

    }
}

/* Output
*/
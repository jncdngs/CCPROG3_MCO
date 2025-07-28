/*******************************************************************************

This is to certify that this project is my own work, based on my personal 
efforts in studying and applying the concepts learned. I have constructed the 
functions and their respective algorithms and corresponding code by myself. The
program was run, tested, and debugged by my own efforts. I further certify that 
I have not copied in part or whole or otherwise plagiarized the work of other 
students and/or persons.

                                    Jon Chester C. Donguines, DLSU ID# 12413933

*******************************************************************************/

/**
 * Main driver for the game.
 * <p>
 * Contains the main method (starting point) of the program.
 */
public class Driver {

    /**
     * Main method for the game.
     * <p>
     * Instantiates a GUI object and creates a Controller using the GUI object.
     */
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        new Controller(gui);

    }
    
}

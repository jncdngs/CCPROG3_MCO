/*******************************************************************************

This is to certify that this project is my own work, based on my personal 
efforts in studying and applying the concepts learned. I have constructed the 
functions and their respective algorithms and corresponding code by myself. The
program was run, tested, and debugged by my own efforts. I further certify that 
I have not copied in part or whole or otherwise plagiarized the work of other 
students and/or persons.

                                    Jon Chester C. Donguines, DLSU ID# 12413933

*******************************************************************************/

import java.util.Scanner;

/**
 * Main driver for the game.
 * <p>
 * Contains the main method (starting point) of the program.
 */
public class Driver {

    /**
     * Main method for the game.
     * <p>
     * Displays the main menu and asks the user to play or exit.
     */
    public static void main(String[] args) {
        
        int menuOpt;
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        System.out.printf("\033[H\033[J\033[3J");
        
        do {
            System.out.println(">>==WARRIOR==<<\n");
            System.out.println("[1] Play game");
            System.out.println("[2] Exit game\n");
            System.out.print("Enter option: ");
            menuOpt = sc.nextInt();
            sc.nextLine();

            switch(menuOpt) {
                case 1:
                    game.setup(sc);
                    game.start(sc);
                    System.out.print("Press enter to return to main menu... ");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.printf("\033[H\033[J\033[3J");
                    break;
                case 2:
                    System.out.printf("\033[H\033[J\033[3J");
                    System.out.println("Exiting game...\n");
                    break;
                default:
                    System.out.printf("\033[H\033[J\033[3J");
            }
        } while(menuOpt != 2);
    }
    
}

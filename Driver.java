import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        
        int menuOpt;
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        System.out.printf("\033[H\033[J\033[3J");
        
        do {
            System.out.println("\n[1] Play game");
            System.out.println("[2] Exit game\n");
            System.out.print("Enter option: ");
            menuOpt = sc.nextInt();
            sc.nextLine();

            switch(menuOpt) {
                case 1:
                    game.setup();
                    break;

                case 2:
                    System.out.printf("\033[H\033[J\033[3J");
                    System.out.println("Exiting game...\n");
                    break;

                default:
                    System.out.printf("\033[H\033[J\033[3J");
                    System.out.println("ERROR: Invalid input!");
            }
        }
        while(menuOpt != 2);

    }
}

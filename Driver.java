import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        
        String playerName;
        int menuOpt;
        int armorOpt;
        int weaponOpt;
        int envOpt;
        int oppOpt;

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
                    System.out.printf("\033[H\033[J\033[3J");
                    System.out.print("Enter name of player: ");
                    playerName = sc.nextLine();

                    do {
                        System.out.printf("\033[H\033[J\033[3J");
                        System.out.println("\nName\t\t\tDefense\t\tSpeed");
                        System.out.println("[1] Light Armor\t\t+20\t\t-5");
                        System.out.println("[2] Medium Armor\t+30\t\t-15");
                        System.out.println("[3] Heavy Armor\t\t+40\t\t-25\n");
                        System.out.print("Choose an armor: ");
                        armorOpt = sc.nextInt();
                    }
                    while(armorOpt < 1 || armorOpt > 3);

                    do {
                        System.out.printf("\033[H\033[J\033[3J");
                        System.out.println("\nName\t\t\tDefense\t\tSpeed");
                        System.out.println("[1] Dagger\t\t+20\t\t0");
                        System.out.println("[2] Sword\t\t+30\t\t-10");
                        System.out.println("[3] Battle Axe\t\t+40\t\t-20\n");
                        System.out.print("Choose a weapon: ");
                        weaponOpt = sc.nextInt();
                    }
                    while(weaponOpt < 1 || weaponOpt > 3);

                    do {
                        System.out.printf("\033[H\033[J\033[3J");
                        System.out.println("\nName\t\t\tPlayer\t\tOpponent");
                        System.out.println("[1] Arena\t\tNone\t\tNone");
                        System.out.println("[2] Swamp\t\t-1 dmg/turn\t+1 atk/turn");
                        System.out.println("[3] Colosseum\t\t+1 atk/turn\t-1 def/turn\n");
                        System.out.print("Choose an environment: ");
                        envOpt = sc.nextInt();
                    }
                    while(envOpt < 1 || envOpt > 3);

                    do {
                        System.out.printf("\033[H\033[J\033[3J");
                        System.out.println("\nName\t\t\tHP\t\tAttack\t\tDefense\t\tSpeed");
                        System.out.println("[1] Thief\t\t150\t\t20\t\t20\t\t40");
                        System.out.println("[2] Viking\t\t250\t\t30\t\t30\t\t30");
                        System.out.println("[3] Minotaur\t\t350\t\t40\t\t40\t\t20\n");
                        System.out.print("Choose an opponent: ");
                        oppOpt = sc.nextInt();
                    }
                    while(oppOpt < 1 || oppOpt > 3);

                    game.setup(playerName, armorOpt, weaponOpt, envOpt, oppOpt);
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

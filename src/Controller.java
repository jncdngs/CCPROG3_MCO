import javax.swing.*;
import java.awt.event.*;

/**
 * Main controller for the game.
 * <p>
 * Contains and manages the GUI, player, opponent, and environment objects, and runs the main game loop.
 * Handles all game logic including setup, turn order, action execution, buffs, and penalties.
 * 
 * @author Jon Chester Donguines
 */
public class Controller implements ActionListener {

    private GUI gui;
    // private Scanner sc;
    private Player player;
    private Environment env;
    private Opponent opp;
    
    // private int menuOpt;
    // private int playerAction;
    private int oppAction;
    private int moveCounter = 1;
    private boolean isPlayersTurn;
    private String winner;

    public Controller(GUI gui) {
        this.gui = gui;

        // sc = new Scanner(System.in);
        gui.setActionListeners(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gui.getBtnPlay()) {
            System.out.println("[LOG] Play button pressed");

            gui.getMainLayout().show(gui.getMainPanel(), "namePanel");
            // gui.getMainLayout().show(gui.getMainPanel(), "gamePanel");
            System.out.println("[LOG] Switched to name selection panel");
        }
        else if(e.getSource() == gui.getBtnQuit()) {
            System.out.println("[LOG] Quit button pressed");

            int result = JOptionPane.showConfirmDialog(
                gui, 
                "Are you sure you want to quit the game?", 
                "Exit Confirmation", 
                JOptionPane.YES_NO_OPTION);

            if(result == JOptionPane.YES_OPTION) {
                System.out.println("[LOG] Program exited");
                System.exit(0);
            }
        }
        else if(e.getSource() == gui.getBtnName()) {
            System.out.println("[LOG] Enter button pressed");

            if(!(gui.getNameField().getText().trim().equals(""))) {   
                player = new Player(gui.getNameField().getText());

                gui.getMainLayout().show(gui.getMainPanel(), "armorPanel");
                System.out.println("[LOG] Switched to armor selection panel");
            }

        }
        else if(e.getSource() == gui.getBtnLight() ||
                e.getSource() == gui.getBtnMedium() ||
                e.getSource() == gui.getBtnHeavy() ||
                e.getSource() == gui.getBtnNoArmor()) {

            Armor armor = null;
            
            if(e.getSource() == gui.getBtnLight())
                armor = new Armor("Light", 20, 5);
            else if(e.getSource() == gui.getBtnMedium())
                armor = new Armor("Medium", 30, 15);
            else if(e.getSource() == gui.getBtnHeavy())
                armor = new Armor("Heavy", 40, 25);
            else if(e.getSource() == gui.getBtnNoArmor())
                armor = new Armor("None", 0, 0);
            
            player.setArmor(armor);
            System.out.println("[LOG] Set player armor to \"" + player.getArmor().getName() + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "weaponPanel");
            System.out.println("[LOG] Switched to weapon selection panel");
        }
        else if(e.getSource() == gui.getBtnDagger() ||
                e.getSource() == gui.getBtnSword() ||
                e.getSource() == gui.getBtnAxe() ||
                e.getSource() == gui.getBtnNoWeapon()) {

            Weapon weapon = null;
            
            if(e.getSource() == gui.getBtnDagger())
                weapon = new Dagger();
            else if(e.getSource() == gui.getBtnSword())
                weapon = new Sword();
            else if(e.getSource() == gui.getBtnAxe())
                weapon = new BattleAxe();
            else if(e.getSource() == gui.getBtnNoWeapon())
                weapon = new Weapon("None", 0, 0);
            
            player.setWeapon(weapon);
            System.out.println("[LOG] Set player weapon to \"" + player.getWeapon().getName() + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "oppPanel");
            System.out.println("[LOG] Switched to opponent selection panel");
        }
        else if(e.getSource() == gui.getBtnThief() ||
                e.getSource() == gui.getBtnViking() ||
                e.getSource() == gui.getBtnMinotaur()) {
            
            if(e.getSource() == gui.getBtnThief())
                opp = new Thief();
            else if(e.getSource() == gui.getBtnViking())
                opp = new Viking();
            else if(e.getSource() == gui.getBtnMinotaur())
                opp = new Minotaur();

            String oppName = opp.getName() + ".png";
            gui.setOppFileName(oppName);
            System.out.println("[LOG] Set opponent sprite to \"" + oppName + "\"");

            gui.getMainLayout().show(gui.getMainPanel(), "envPanel");
            System.out.println("[LOG] Switched to environment selection panel");
        }
        else if(e.getSource() == gui.getBtnArena() ||
                e.getSource() == gui.getBtnSwamp() ||
                e.getSource() == gui.getBtnColosseum()) {
            
            if(e.getSource() == gui.getBtnArena())
                env = new Environment("Arena", 0, 0, 0, 0);
            else if(e.getSource() == gui.getBtnSwamp())
                env = new Environment("Swamp", 0, 1, 1, 0);
            else if(e.getSource() == gui.getBtnColosseum())
                env = new Environment("Colosseum", 1, 0, 0, 1);
            
            System.out.println("[LOG] Set environment to \"" + env.getName() + "\"");

            String envName = env.getName() + ".png";
            gui.setEnvironment(envName);
            System.out.println("[LOG] Set game background to \"" + envName + "\"");
            
            // gui.addGameToMainPanel();
            // gui.updateGamePanel();
            gui.addGamePanel(player, opp);
            gui.getMainPanel().add(gui.getGamePanel(), "gamePanel");

            gui.getMainLayout().show(gui.getMainPanel(), "gamePanel");
            System.out.println("[LOG] Switched to main game panel");

            gui.getBtnAttack().addActionListener(this);
            gui.getBtnDefend().addActionListener(this);
            gui.getBtnCharge().addActionListener(this);
            gui.getBtnReturn().addActionListener(this);

            displayStats();
            gui.revalidate();
            gui.repaint();
        }
        else if(e.getSource() == gui.getBtnAttack() ||
                e.getSource() == gui.getBtnDefend() ||
                e.getSource() == gui.getBtnCharge()) {
            if(e.getSource() == gui.getBtnAttack()) {
                System.out.println("[LOG] Attack pressed");
                nextTurn(1);
                gui.revalidate();
                gui.repaint();
            }
            else if(e.getSource() == gui.getBtnDefend()) {
                System.out.println("[LOG] Defend pressed");
                nextTurn(2);
                gui.revalidate();
                gui.repaint();
            }
            else if(e.getSource() == gui.getBtnCharge()) {
                System.out.println("[LOG] Charge pressed");
                nextTurn(3);
                gui.revalidate();
                gui.repaint();
            }
        }
        else if(e.getSource() == gui.getBtnReturn()) {            
            // Remove the old frame
            gui.dispose();
            
            // Create a new GUI object
            gui = new GUI();
            
            // Reset action listeners
            gui.setActionListeners(this);

            System.out.println("[LOG] Returned to start screen");
        }
    }



    /**
     * Displays the stats for the current turn.
     * <p>
     * Displays the actions executed on the previous turn (except during the first turn), 
     * the current stats of the player, and the current stats of the opponent.
     */
    private void displayStats() {
        String[] action = new String[] {"attacked", "defended", "charged"};
        
        // System.out.printf("\033[H\033[J\033[3J");
        System.out.println();

        // Display previous actions executed
        if(player.getPrevAction() != 0 || opp.getPrevAction() != 0) {
            if(compareSpeed(player, opp)) {
                System.out.println("[LOG] " + player.getName() + " " + action[player.getPrevAction() - 1] + "!");
                System.out.println("[LOG] " + opp.getName() + " " + action[opp.getPrevAction() - 1] + "!\n");
            } else {
                System.out.println("[LOG] " + opp.getName() + " " + action[opp.getPrevAction() - 1] + "!");
                System.out.println("[LOG] " + player.getName() + " " + action[player.getPrevAction() - 1] + "!\n");
            }
        }

        System.out.println("[LOG] ===================================\n");

        // Display player stats
        player.displayStats();
        // Display opponent stats
        opp.displayStats();

        System.out.println("=========================================\n");
    }

    // /** 
    //  * Displays the name of the winner and the number of moves taken.
    //  * 
    //  * @param winner        the name of the winner
    //  * @param moveCounter   the number of moves taken
    //  */
    // private void displayWinner(String winner, int moveCounter) {
    //     System.out.println(winner + " won the game in " + moveCounter + " moves!\n");
    // }

    /** 
     * Checks if the game is over by checking the hit points of the player and opponent.
     * 
     * @return true if either player or opponent's hit points are zero,
     *         false if both player and opponent's hit points are not zero
     */
    private boolean isGameOver() {
        return player.getHp() == 0 || opp.getHp() == 0;
    }

    /** 
     * Compares speed of player and opponent to determine whose action executes first.
     * 
     * @param player    the player object to compare
     * @param opp       the opponent object to compare
     * @return          true if the player's speed is higher than the opponent's,
     *                  false if the opponent's speed is lower than or equal to the player's
     */
    private boolean compareSpeed(Player player, Opponent opp) {
        return player.getSpd() > opp.getSpd();
    }

    /** 
     * Applies buffs and penalties to the player and opponent from the chosen environment.
     */
    private void applyEnvEffects() {
        player.loseHp(env.getPlayerDmg());
        player.gainAtk(env.getPlayerAtk());
        opp.gainAtk(env.getOppAtk());
        opp.loseDef(env.getOppDef());
    }

    // /** 
    //  * Asks the player/opponent to choose an action.
    //  * 
    //  * @param currentTurn   the name of the player/opponent to choose
    //  * @param sc            the scanner object for user input
    //  * @return              corresponding number for the action:
    //  *                      1 for Attack, 2 for Defend, 3 for Charge
    //  */
    // private int askAction(String currentTurn, Scanner sc) {
    //     int action;
    //     int chargeFlag = 0;

    //     if(this.player.getIsAtkCharged())
    //         chargeFlag = 1;

    //     do {
    //         displayStats();
    //         System.out.println(currentTurn + "'s turn!\n");
    //         System.out.println("[1] Attack");
    //         System.out.println("[2] Defend");
            
    //         if(chargeFlag == 0)
    //             System.out.println("[3] Charge\n");
    //         else
    //             System.out.println();
            
    //         System.out.print("Choose an action: ");
    //         action = sc.nextInt();
    //     }
    //     while(action < 1 || action > 3 - chargeFlag);

    //     return action;
    // }

    // public void menu() {
    //     // System.out.printf("\033[H\033[J\033[3J");
    //     System.out.println();
            
    //     do {
    //         System.out.println(">>==WARRIOR==<<\n");
    //         System.out.println("[1] Play game");
    //         System.out.println("[2] Exit game\n");
    //         System.out.print("Enter option: ");
    //         menuOpt = sc.nextInt();
    //         sc.nextLine();

    //         switch(menuOpt) {
    //             case 1:
    //                 setup();
    //                 // start();
    //                 System.out.print("Press enter to return to main menu... ");
    //                 sc.nextLine();
    //                 sc.nextLine();
    //                 // System.out.printf("\033[H\033[J\033[3J");
    //                 System.out.println();
    //                 break;
    //             case 2:
    //                 // System.out.printf("\033[H\033[J\033[3J");
    //                 System.out.println();
    //                 break;
    //             default:
    //                 // System.out.printf("\033[H\033[J\033[3J");
    //                 System.out.println();
    //         }
    //     } while(menuOpt != 2);
    // }
    
    // /** 
    //  * Sets up the game by asking the player for their name, armor, weapon, environment, and opponent.
    //  * <p>
    //  * Armor, Weapon, Environment, and Opponent objects are only created after user input.
    //  */
    // public void setup() {
    //     Armor armor = null;
    //     Weapon weapon = null;
    //     String playerName = null;
    //     int armorOpt, weaponOpt, envOpt, oppOpt;
        
    //     // // System.out.printf("\033[H\033[J\033[3J");
    //     System.out.println();
    //     System.out.print("Enter name of player: ");
    //     playerName = sc.nextLine();
        
    //     player = new Player(playerName);
        
    //     do {
    //         // System.out.printf("\033[H\033[J\033[3J");
    //         System.out.println();
    //         System.out.println("Name\t\t\tDefense\t\tSpeed");
    //         System.out.println("[1] Light Armor\t\t+20\t\t-5");
    //         System.out.println("[2] Medium Armor\t+30\t\t-15");
    //         System.out.println("[3] Heavy Armor\t\t+40\t\t-25");
    //         System.out.println("[4] None\t\t0\t\t0\n");
    //         System.out.print("Choose an armor: ");
    //         armorOpt = sc.nextInt();
    //     } while(armorOpt < 1 || armorOpt > 4);

    //     switch(armorOpt) {
    //         case 1:
    //         armor = new Armor("Light", 20, 5);
    //         break;
    //         case 2:
    //         armor = new Armor("Medium", 30, 15);
    //         break;
    //         case 3:
    //         armor = new Armor("Heavy", 40, 25);
    //         break;
    //         case 4:
    //         armor = new Armor("None", 0, 0);
    //         break;
    //     }
    //     player.setArmor(armor);
        
    //     do {
    //         // System.out.printf("\033[H\033[J\033[3J");
    //         System.out.println();
    //         System.out.println("Name\t\t\tAttack\t\tSpeed");
    //         System.out.println("[1] Dagger\t\t+20\t\t0");
    //         System.out.println("[2] Sword\t\t+30\t\t-10");
    //         System.out.println("[3] Battle Axe\t\t+40\t\t-20");
    //         System.out.println("[4] None\t\t0\t\t0\n");
    //         System.out.print("Choose a weapon: ");
    //         weaponOpt = sc.nextInt();
    //     } while(weaponOpt < 1 || weaponOpt > 4);

    //     switch(weaponOpt) {
    //         case 1:
    //             weapon = new Dagger();
    //             break;
    //         case 2:
    //             weapon = new Sword();
    //             break;
    //         case 3:
    //             weapon = new BattleAxe();
    //             break;
    //             case 4:
    //             weapon = new Weapon("None", 0, 0);
    //             break;
    //     }
    //     player.setWeapon(weapon);

    //     do {
    //         // System.out.printf("\033[H\033[J\033[3J");
    //         System.out.println();
    //         System.out.println("Name\t\t\tHP\t\tAttack\t\tDefense\t\tSpeed");
    //         System.out.println("[1] Thief\t\t150\t\t20\t\t20\t\t40");
    //         System.out.println("[2] Viking\t\t250\t\t30\t\t30\t\t30");
    //         System.out.println("[3] Minotaur\t\t350\t\t40\t\t40\t\t20\n");
    //         System.out.print("Choose an opponent: ");
    //         oppOpt = sc.nextInt();
    //     } while(oppOpt < 1 || oppOpt > 3);

    //     switch(oppOpt) {
    //         case 1:
    //             opp = new Thief();
    //             break;
    //         case 2:
    //             opp = new Viking();
    //             break;
    //         case 3:
    //             opp = new Minotaur();
    //             break;
    //     }

    //     do {
    //         // System.out.printf("\033[H\033[J\033[3J");
    //         System.out.println();
    //         System.out.println("Name\t\t\tPlayer\t\tOpponent");
    //         System.out.println("[1] Arena\t\tNone\t\tNone");
    //         System.out.println("[2] Swamp\t\t-1 dmg/turn\t+1 atk/turn");
    //         System.out.println("[3] Colosseum\t\t+1 atk/turn\t-1 def/turn\n");
    //         System.out.print("Choose an environment: ");
    //         envOpt = sc.nextInt();
    //     } while(envOpt < 1 || envOpt > 3);

    //     switch(envOpt) {
    //         case 1:
    //             env = new Environment("Arena", 0, 0, 0, 0);
    //             break;
    //         case 2:
    //             env = new Environment("Swamp", 0, 1, 1, 0);
    //             break;
    //         case 3:
    //             env = new Environment("Colosseum", 1, 0, 0, 1);
    //             break;
    //     }
    // }

    /** 
     * Starts the main game loop.
     * <p>
     * The game starts by comparing the speeds of the player and the opponent. 
     * Afterwards, it asks them which action to execute in order. Then the game 
     * checks if someone chose to defend. If so, the defender will have action 
     * execution priority. If someone chose charge, their next attack will be 
     * flagged as charged. If someone currently has a charged attack, the flag 
     * will be set to uncharged for the next turn. The game then checks if the 
     * game is over. If so, check for the winner. If not, apply the environmental 
     * effects and increment move counter by 1. Repeat.
     */
    public void nextTurn(int playerAction) {
        
        displayStats();
        gui.revalidate();
        gui.repaint();

        // Compare speed of player and opponent
        isPlayersTurn = compareSpeed(player, opp);
        
        // Determine opponent's action
        // this.playerAction = playerAction;
        oppAction = opp.think(moveCounter);

        // Check if someone defended
        if(playerAction == 2)
            isPlayersTurn = true;
        else if(oppAction == 2)
            isPlayersTurn = false;

        // Execute actions in order
        if(isPlayersTurn) {
            switch(playerAction) {
                case 1:
                    player.attack(opp);
                    break;
                case 2:
                    player.defend(opp);
                    break;
                case 3:
                    player.charge();
                    break;
            }

            switch(oppAction) {
                case 1:
                    opp.attack(player);
                    break;
                case 2:
                    opp.defend(player);
                    break;
                case 3:
                    opp.charge();
                    break;
            }

            player.setPrevAction(playerAction);
            opp.setPrevAction(oppAction);
            opp.resetAtkMult();
        } else {
            switch(oppAction) {
                case 1:
                    opp.attack(player);
                    break;
                case 2:
                    opp.defend(player);
                    break;
                case 3:
                    opp.charge();
                    break;
            }

            switch(playerAction) {
                case 1:
                    player.attack(opp);
                    break;
                case 2:
                    player.defend(opp);
                    break;
                case 3:
                    player.charge();
                    break;
            }

            player.setPrevAction(playerAction);
            opp.setPrevAction(oppAction);
            player.resetAtkMult();
        }

        // If player selected charge, set flag to true
        if(player.getIsAtkCharged()) {
            player.setAtk(player.getAtk() / 3);
            gui.setIsAtkCharged(false);
            player.setIsAtkCharged(false);

            if(player.getWeapon().isBattleAxe()) {
                player.loseSpd(5);
                player.loseAtk(5);

                System.out.println("[LOG] Temporary battle axe buff removed");
            }
        }
        if(player.getIsNextCharged()) {
            player.setIsAtkCharged(true);
            gui.setIsAtkCharged(true);
            player.setIsNextCharged(false);
            
            if(player.getWeapon().isBattleAxe()) {
                player.gainSpd(5);
                player.gainAtk(5);

                System.out.println("[LOG] Temporary battle axe buff applied");
            }
        }

        // If opponent selected charge, set flag to true
        if(opp.getIsAtkCharged()) {
            opp.setAtk(opp.getAtk() / 3);
            opp.setIsAtkCharged(false);
        }
        if(opp.getIsNextCharged()) {
            opp.setIsAtkCharged(true);
            opp.setIsNextCharged(false);
        }
        
        // If player defend is evade, set flag to true
        if(player.getIsDefEvade()) {
            opp.resetAtkMult();
            player.setIsDefEvade(false);
        }
        if(player.getIsNextNotEvade()) {
            player.setIsDefEvade(true);
            player.setIsNextNotEvade(false);
        }

        // If game is over, check winner based on turn order
        if(isGameOver()) {
            if(compareSpeed(player, opp)) {
                if(opp.getHp() == 0)
                    winner = player.getName();
                else if(player.getHp() == 0)
                    winner = opp.getName();
            } else {
                if(player.getHp() == 0)
                    winner = opp.getName();
                else if(opp.getHp() == 0)
                    winner = player.getName();
            }
            
            System.out.println("[LOG] Final stats below");
            gui.displayWinPanel(winner, moveCounter);
            gui.getBtnReturn().addActionListener(this);
            gui.revalidate();
            gui.repaint();
        } else {
            // Apply environment effects
            applyEnvEffects();
            System.out.println("[LOG] " + env.getName() + " effects applied");
            
            // Increment move counter
            moveCounter++;
            System.out.println("[LOG] Updated move count: " + moveCounter);
        }

        displayStats();
        gui.updateStats(player, opp, isGameOver());
        gui.updateButtons(player);
        gui.revalidate();
        gui.repaint();
    }

}

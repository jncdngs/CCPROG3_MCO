/**
 * Character controlled by the opponent.
 * <p>
 * Stores the opponent's name, armor, weapon, and stats. 
 * Handles the actions made by the opponent and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public abstract class Opponent extends Character {

    /**
     * Constructs a character for the opponent with given stats.
     * 
     * @param name  the name of the opponent
     * @param hp    the hit points of the opponent
     * @param atk   the attack of the opponent
     * @param def   the defense of the opponent
     * @param spd   the speed of the opponent
     */
    public Opponent(String name, int hp, int atk, int def, int spd) {
        super(name, hp, atk, def, spd);
    }



    /** 
     * Deducts hit points from the player. 
     * <p>
     * The damage to be dealt is calculated by multiplying the current attack
     * points of the opponent with the attack multiplier (0.5 if the player 
     * defended, 1 otherwise) and subtracting the current defense points of the 
     * player.
     * 
     * @param player the player object to be attacked
     */
    public void attack(Player player) {
        int dmg = (int)(atk * atkMult - player.getDef());

        if(dmg < 0)
            dmg = 0;
        
        player.loseHp(dmg);
    }

    /** 
     * Multiply player's attack by half.
     * 
     * @param player the player object to defend from
     */
    public void defend(Player player) {
        player.setAtkMult(0.5f);
    }
    
    /**
     * Determines the action of the opponent (Faux-AI).
     * <p>
     * Checks the current move number and the name of the opponent and returns 
     * the corresponding action based on a predetermined sequence.
     * 
     * @param moveCounter   the current move number of the game
     * @return              corresponding number for the action:
     *                      1 for Attack, 2 for Defend, 3 for Charge
     */
    public abstract int think(int moveCounter);



    /**
     * Displays the current opponent stats.
     * <p>
     * Displays the opponent's name, hit points, attack, defense, and speed.
     */
    public void displayStats() {
        System.out.println("========== Opponent ==========");
        System.out.println("Name:    " + getName());
        System.out.println("HP:      " + getHp());
        System.out.println("Attack:  " + getAtk());
        System.out.println("Defense: " + getDef());
        System.out.println("Speed:   " + getSpd());
        System.out.println();
    }

}

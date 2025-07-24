/**
 * Character controlled by the player.
 * <p>
 * Stores the character's name, armor, weapon, and stats. 
 * Handles the actions made by the player and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

public class Player extends Character {
    
    private Armor armor;
    private Weapon weapon;
    private boolean isDefEvade = false;
    private boolean isNextNotEvade = false;

    /**
     * Constructs a character for the player with given base stats.
     * 
     * @param name the name of the player
     */
    public Player(String name) {
        super(name, 100, 1, 1, 50);
        System.out.println("[LOG] Player \"" + this.name + "\" created");
    }

    /**
     * Returns the current armor of the player.
     * 
     * @return the current armor
     */
    public Armor getArmor() {
        return this.armor;
    }

    /**
     * Returns the current weapon of the player.
     * 
     * @return the current weapon
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    public boolean getIsDefEvade() {
        return this.isDefEvade;
    }

    public boolean getIsNextNotEvade() {
        return this.isNextNotEvade;
    }


    
    /** 
     * Sets the current armor of the player.
     * 
     * @param armor the armor object to be set
     */
    public void setArmor(Armor armor) {
        this.armor = armor;
        gainDef(armor.getDefBuff());
        loseSpd(armor.getSpdPen());
    }

    /** 
     * Sets the current weapon of the player.
     * 
     * @param weapon the weapon object to be set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        gainAtk(weapon.getAtkBuff());
        loseSpd(weapon.getSpdPen());
    }

    public void setIsDefEvade(boolean isDefEvade) {
        this.isDefEvade = isDefEvade;
    }

    public void setIsNextNotEvade(boolean isNextNotEvade) {
        this.isNextNotEvade = isNextNotEvade;
    }



    /** 
     * Deducts hit points from the opponent. 
     * <p>
     * The damage to be dealt is calculated by multiplying the current attack
     * points of the player with the attack multiplier (0.5 if the opponent 
     * defended, 1 otherwise) and subtracting the current defense points of the 
     * opponent.
     * 
     * @param opp the opponent object to be attacked
     */
    public void attack(Opponent opp) {
        int swordBuff = 0;
        int dmg;

        if(weapon.isSword()) {
            swordBuff = 10;
            System.out.println("[LOG] Sword ability applied (+10 attack)");
        }
        
        dmg = ((int)(atk * atkMult - opp.getDef())) + swordBuff;

        if(dmg < 0)
            dmg = 0;
        
        opp.loseHp(dmg);
    }

    /** 
     * Multiply opponent's attack by half.
     * 
     * @param opp the opponent object to defend from
     */
    public void defend(Opponent opp) {
        if(weapon.isDagger() && !isDefEvade) {
            opp.setAtkMult(0.0);
            isNextNotEvade = true;
            System.out.println("[LOG] Dagger ability applied");
        }
        else {
            opp.setAtkMult(0.5);
        }

        System.out.println("[LOG] " + name + " defended");

        // if(!isAtkCharged) {
        //     atk *= 3;
        //     isNextCharged = true;
        // }
    }



    /**
     * Displays the current player stats.
     * <p>
     * Displays the player's name, armor name, weapon name, hit points, attack, 
     * defense, and speed.
     */
    public void displayStats() {
        System.out.println("Player");
        System.out.println("Name:    " + getName());
        System.out.println("Armor:   " + getArmor().getName());
        System.out.println("Weapon:  " + getWeapon().getName());
        System.out.println("HP:      " + getHp());
        System.out.println("Attack:  " + getAtk());
        System.out.println("Defense: " + getDef());
        System.out.println("Speed:   " + getSpd());
        System.out.println();
    }

}

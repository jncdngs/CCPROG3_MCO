/**
 * Character controlled by the player.
 * <p>
 * Stores the character's name, armor, weapon, and stats. 
 * Handles the actions made by the player and adjustments to the stats
 * 
 * @author Jon Chester Donguines
 */

 public class Player {
    
    private String name;
    private Armor armor;
    private Weapon weapon;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float atkMult = 1;
    private boolean isAttackCharged = false;
    private boolean isNextCharged = false;
    private int prevAction = 0;

    public Player(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /** @return the name of the player */
    public String getName() {
        return this.name;
    }

    /** @return the current armor of the player */
    public Armor getArmor() {
        return this.armor;
    }

    /** @return the current weapon of the player */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /** @return the current hit points of the player */
    public int getHp() {
        return this.hp;
    }

    /** @return the current attack points of the player */
    public int getAtk() {
        return this.atk;
    }

    /** @return the current defense points of the player */
    public int getDef() {
        return this.def;
    }

    /** @return the current speed points of the player */
    public int getSpd() {
        return this.spd;
    }

    /** @return the current attack multiplier of the player */
    public float getAtkMult() {
        return this.atkMult;
    }

    /** 
     * @return true if the current attack of the player is charged,
     *         false if the current attack of the player is not charged
     */
    public boolean getIsAttackCharged() {
        return this.isAttackCharged;
    }

    /** 
     * @return true if the next attack of the player is charged,
     *         false if the next attack of the player is not charged
     */
    public boolean getIsNextCharged() {
        return this.isNextCharged;
    }

    /** 
     * @return the corresponding number for the previously chosen action:
     *         1 for Attack, 2 for Defend, 3 for Charge
     */
    public int getPrevAction() {
        return this.prevAction;
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

    /** 
     * Sets the current attack points of the player.
     * 
     * @param atk the attack points to be set
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /** 
     * Sets the current attack multiplier of the player.
     * 
     * @param atkMult the multiplier to be applied to the current attack points
     */
    public void setAtkMult(float atkMult) {
        this.atkMult = atkMult;
    }

    /** 
     * Sets the flag indicating if the current attack of the player is charged.
     * 
     * @param isAttackCharged the flag to indicate if the current attack is charged
     */
    public void setIsAttackCharged(boolean isAttackCharged) {
        this.isAttackCharged = isAttackCharged;
    }

    /** 
     * Sets the flag indicating if the next attack of the player is charged.
     * 
     * @param isNextCharged the flag to indicate if the next attack if charged
     */
    public void setIsNextCharged(boolean isNextCharged) {
        this.isNextCharged = isNextCharged;
    }

    /** 
     * Sets the corresponding number for the previously chosen action by the player:
     * 1 for Attack, 2 for Defend, 3 for Charge
     * 
     * @param prevAction the previously chosen action
     */
    public void setPrevAction(int prevAction) {
        this.prevAction = prevAction;
    }



    /** 
     * Deducts hit points from the player.
     * 
     * @param hp the number of hit points to be deducted
     */
    public void loseHp(int hp) {
        if(hp >= this.hp)
            this.hp = 0;
        else
            this.hp -= hp;
    }

    /** 
     * Adds attack points to the player.
     * 
     * @param atk the number of attack points to be added
     */
    public void gainAtk(int atk) {
        this.atk += atk;
    }

    /** 
     * Deducts attack points from the player.
     * 
     * @param atk the number of attack points to be deducted
     */
    public void loseAtk(int atk) {
        if(atk >= this.atk)
            this.atk = 0;
        else
            this.atk -= atk;
    }

    /** 
     * Adds defense points to the player.
     * 
     * @param def the number of defense points to be added
     */
    public void gainDef(int def) {
        this.def += def;
    }

    /** 
     * Deducts defense points from the player.
     * 
     * @param def the number of defense points to be deducted
     */
    public void loseDef(int def) {
        if(def >= this.def)
            this.def = 0;
        else
            this.def -= def;
    }
    
    /** 
     * Adds speed points to the player.
     * 
     * @param spd the number of speed points to be added
     */
    public void gainSpd(int spd) {
        this.spd += spd;
    }

    /** 
     * Deducts speed points from the player.
     * 
     * @param spd the number of speed points to be deducted
     */
    public void loseSpd(int spd) {
        if(spd >= this.spd)
            this.spd = 0;
        else
            this.spd -= spd;
    }

    /** 
     * Resets the attack multiplier of the player to 1.
     */
    public void resetAtkMult() {
        this.atkMult = 1;
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
        int dmg = (int)(atk * atkMult - opp.getDef());
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
        opp.setAtkMult(0.5f);
    }

    /** 
     * Charge the player's next attack.
     * <p>
     * Checks first if the current attack is charged. If not, the attack points 
     * are multiplied by 3 and the next attack charged flag is set to true.
     */
    public void charge() {
        if(!isAttackCharged) {
            atk *= 3;
            isNextCharged = true;
        }
    }



    /**
     * Displays the current player stats.
     * <p>
     * Displays the player's name, armor name, weapon name, hit points, attack, 
     * defense, and speed.
     */
    public void displayStats() {
        System.out.println("=========== Player ===========");
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

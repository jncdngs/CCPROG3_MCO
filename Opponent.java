public class Opponent {
    
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private float atkMult = 1;
    private boolean isAttackCharged = false;
    private boolean isNextCharged = false;
    private int prevAction = 0;

    public Opponent(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /** 
     * @return the name of the opponent
     */
    public String getName() {
        return this.name;
    }

    /** 
     * @return the current hit points of the opponent
     */
    public int getHp() {
        return this.hp;
    }

    /** 
     * @return the current attack points of the opponent
     */
    public int getAtk() {
        return this.atk;
    }

    /** 
     * @return the current defense points of the opponent
     */
    public int getDef() {
        return this.def;
    }

    /** 
     * @return the current speed points of the opponent
     */
    public int getSpd() {
        return this.spd;
    }

    /** 
     * @return the current attack multiplier of the opponent
     */
    public float getAtkMult() {
        return this.atkMult;
    }

    /** 
     * @return true if the current attack of the opponent is charged,
     *         false if the current attack of the opponent is not charged
     */
    public boolean getIsAttackCharged() {
        return this.isAttackCharged;
    }

    /** 
     * @return true if the next attack of the opponent is charged,
     *         false if the next attack of the opponent is not charged
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



    // /** 
    //  * @param hp    
    //  */
    // public void setHp(int hp) {
    //     this.hp = hp;
    // }

    /** 
     * Sets the current attack points of the opponent.
     * 
     * @param atk the attack points to be set
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    // /** 
    //  * @param def
    //  */
    // public void setDef(int def) {
    //     this.def = def;
    // }

    // /** 
    //  * @param spd
    //  */
    // public void setSpd(int spd) {
    //     this.spd = spd;
    // }

    /** 
     * Sets the current attack multiplier of the opponent.
     * 
     * @param atkMult the multiplier to be applied to the current attack points
     */
    public void setAtkMult(float atkMult) {
        this.atkMult = atkMult;
    }

    /** 
     * Sets the flag indicating if the current attack of the opponent is charged.
     * 
     * @param isAttackCharged the flag to indicate if the current attack is charged
     */
    public void setIsAttackCharged(boolean isAttackCharged) {
        this.isAttackCharged = isAttackCharged;
    }

    /** 
     * Sets the flag indicating if the next attack of the opponent is charged.
     * 
     * @param isNextCharged the flag to indicate if the next attack if charged
     */
    public void setIsNextCharged(boolean isNextCharged) {
        this.isNextCharged = isNextCharged;
    }

    /** 
     * Sets the corresponding number for the previously chosen action by the opponent:
     * 1 for Attack, 2 for Defend, 3 for Charge
     *         
     * @param prevAction the previously chosen action
     */
    public void setPrevAction(int prevAction) {
        this.prevAction = prevAction;
    }



    /** 
     * Deducts hit points from the opponent.
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
     * Adds attack points to the opponent.
     * 
     * @param atk the number of attack points to be added
     */
    public void gainAtk(int atk) {
        this.atk += atk;
    }

    /** 
     * Deducts defense points from the opponent.
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
     * Resets the attack multiplier of the opponent to 1.
     */
    public void resetAtkMult() {
        this.atkMult = 1;
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
     * Charge the opponent's next attack.
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

}

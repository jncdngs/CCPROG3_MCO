public class Player {
    
    private String name;
    private Armor armor;
    private Weapon weapon;
    private int hp;
    private int atk;
    private int def;
    private int spd;

    public Player(String name, int hp, int atk, int def, int spd) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    public String getName() {
        return this.name;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getSpd() {
        return this.spd;
    }


    
    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }



    public void attack(Opponent opponent) {

    }

    public void defend() {

    }

    public void charge() {

    }



    public void loseHp(int hp) {
        this.hp -= hp;
    }

    public void gainAtk(int atk) {
        this.atk += atk;
    }

    public void loseAtk(int atk) {

    }

    public void gainDef(int def) {
        this.def += def;
    }

    public void loseDef(int def) {

    }
    
}

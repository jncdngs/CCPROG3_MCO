public class Weapon {

    private String name;
    private int atkBuff;
    private int spdPen;

    public Weapon(String name, int atkBuff, int spdPen) {
        this.name = name;
        this.atkBuff = atkBuff;
        this.spdPen = spdPen;
    }

    public String getName() {
        return this.name;
    }

    public int getAtkBuff() {
        return this.atkBuff;
    }

    public int getSpdPen() {
        return this.spdPen;
    }

}

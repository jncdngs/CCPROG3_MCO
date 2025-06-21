public class Armor {

    private String name;
    private int defBuff;
    private int spdPen;

    public Armor(String name, int defBuff, int spdPen) {
        this.name = name;
        this.defBuff = defBuff;
        this.spdPen = spdPen;
    }

    public String getName() {
        return this.name;
    }

    public int getDefBuff() {
        return this.defBuff;
    }

    public int getSpdPen() {
        return this.spdPen;
    }

}

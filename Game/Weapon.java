package Game;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int prize;


    public Weapon(int id, String name, int damage, int prize) {
        this.name = name;
        this.damage = damage;
        this.prize = prize;
        this.id = id;
    }
    public static Weapon[] weapons(){
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon(1,"Tabanca",2,25);
        weapons[1] = new Weapon(2,"Kılıç",3,35);
        weapons[2] = new Weapon(3,"Tüfek",7,45);
        return weapons;
    }
    public static Weapon getWeaponById(int id){
        Weapon selectedWeapon = null;
        for (Weapon w: weapons()){
            if (w.getId() == id){
                selectedWeapon = w;
            }
        }
        return selectedWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package Game;

import java.util.Scanner;

public class Player {
    private Inventory inventory = new Inventory();
    private int id;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private int maxHealth;
    Player(String name){
        this.name = name;
    }
    private Scanner input = new Scanner(System.in);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar(){
        String menu = "1.Samuray => Hasar: 5, Sağlık: 21, Para: 15\n"+
                "2.Okçu    => Hasar: 7, Sağlık: 18, Para: 20\n"+
                "3.Şovalye => Hasar: 8, Sağlık: 24, Para: 5";

        int choose;
        while (true){
            System.out.println("--------------------Karakterler-------------------");
            System.out.println(menu);
            System.out.println("--------------------------------------------------");
            System.out.print("Karekterlerden birini seçiniz(1,2,3):");
            choose = input.nextInt();
            if (choose <= 3 && choose >= 1){
                break;
            }
        }
        if (choose == 1){
            setId(1);
            setCharName("Samuray");
            setDamage(5);
            setHealth(21);
            setMoney(15);
        } else if (choose == 2) {
            setId(2); setMoney(20); setHealth(18); setDamage(7); setCharName("Okçu");
        }else {
            setId(3); setMoney(5); setDamage(8); setHealth(24); setCharName("Şovalye");
        }
        setMaxHealth(getHealth());
    }


    @Override
    public String toString() {
        return "karakterin hasarı=" + damage +
                ", karakterin sağlığı=" + health +
                ", karakterin parası=" + money +
                ", 1.sürpriz ödül="+ inventory.getFood().isOwnership()+
                ", 2.sürpriz ödül="+ inventory.getFirewood().isOwnership()+
                ", 3.sürpriz ödül="+ inventory.getWater().isOwnership()+
                "\nkalkan adı="+ inventory.getArmor().getName()+
                ", kalkan koruması="+inventory.getArmor().getBlock()+
                ", silah adı=" + inventory.getWeapon().getName() +
                ", silah hasarı="+inventory.getWeapon().getDamage();

    }
}

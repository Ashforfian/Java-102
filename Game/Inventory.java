package Game;

public class Inventory {
    private Armor armor;
    private Weapon weapon;
   private Food food = new Food() ;
   private Water water = new Water();
   private Firewood firewood = new Firewood();
    Inventory(){
        weapon = new Weapon(0,"Yumruk",0,0);
        armor = new Armor(0,"Deri ceket",0,0);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public Firewood getFirewood() {
        return firewood;
    }

    public void setFirewood(Firewood firewood) {
        this.firewood = firewood;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

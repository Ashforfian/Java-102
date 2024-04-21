package Game;

import java.util.Random;

public class Obstacle {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int money;
    private int boundObstacle;

    public Obstacle(int id, String name, int health, int damage, int money, int boundObstacle) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
        this.boundObstacle = boundObstacle;

    }

    public static int obstacleNumber(int bound){
        Random random = new Random();
        return random.nextInt(1,bound);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBoundObstacle() {
        return boundObstacle;
    }

    public void setBoundObstacle(int boundObstacle) {
        this.boundObstacle = boundObstacle;
    }
}

package Game;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    Award award;
    Random random = new Random();
    int obstacleNumber;
    BattleLoc(Player player, String name, Obstacle obstacle, Award award) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.obstacleNumber = random.nextInt(1, getObstacle().getBoundObstacle() + 1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("\n---------------------" + getName() + "---------------------");
        System.out.println("Şu an " + getName() + " içinde bulunuyorsun!! Dikkatli ol buranın sahibi " + getObstacle().getName() + "'dır.");
        System.out.println("Yani " + obstacleNumber + " tane " + getObstacle().getName() + " ile hayati tehlikedesin!");
        System.out.print("Savaş(s) veya Kaç(k): ");
        String initial = input.next();
        String lowerInitial = initial.toLowerCase();
        if (lowerInitial.equals("s")) {
            System.out.println("Savaş Başlıyor!!");
            getPlayer().setHealth(combat());
            if (getPlayer().getHealth() == 0){
                System.out.println("---------------------GAME OVER!!---------------------");
                System.out.println(getObstacle().getName()+" tarafından öldürüldün!!");
                return false;
            }
        } else {
            return true;
        }
        return true;
    }

    public int combat() {
        int randNum = random.nextInt(1, 3);
        int playerHealth = getPlayer().getHealth();
        int playerDamage = getPlayer().getDamage();
        int weaponDamage = getPlayer().getInventory().getWeapon().getDamage();
        int obsDamage = getObstacle().getDamage();
        int playerArmor = getPlayer().getInventory().getArmor().getBlock();
        int counter = 1;
        while (counter<=obstacleNumber && playerHealth > 0){
            int obsHealth = getObstacle().getHealth();
            if (randNum == 1) {
                System.out.println(counter+"."+getObstacle().getName()+" ile savaşıyorsun!");
                System.out.println(getPlayer().getName() + ": " + playerHealth + "\t" + getObstacle().getName() + ": " + obsHealth);
                while ((playerHealth > 0) && (obsHealth > 0)) {
                    System.out.println("Sen vurdun!");
                    obsHealth -= playerDamage + weaponDamage;
                    if (obsHealth < 0) {
                        obsHealth = 0;
                    } printInfo(playerHealth,obsHealth);
                    if (obsHealth == 0){
                        break;
                    }
                    if (obsDamage >= playerArmor) {
                        playerHealth -= obsDamage - playerArmor;
                        if (playerHealth < 0) {
                            playerHealth = 0;
                        }
                    }System.out.println(obstacle.getName()+" vurdu:");
                    printInfo(playerHealth,obsHealth);

                }
            } else {
                System.out.println(counter+"."+getObstacle().getName()+" ile savaşıyorsun!");
                System.out.println(getPlayer().getName() + ": " + playerHealth + "\t" + getObstacle().getName() + ": " + obsHealth);
                while ((obsHealth > 0)) {
                    System.out.println(obstacle.getName()+" vurdu:");
                    if (obsDamage >= playerArmor) {
                        playerHealth -= obsDamage - playerArmor;
                        if (playerHealth <= 0) {
                            playerHealth = 0;
                        }printInfo(playerHealth,obsHealth);
                        if (playerHealth == 0){
                            break;
                        }
                    }
                    System.out.println("Sen vurdun:");
                    obsHealth -= playerDamage + weaponDamage;
                    if (obsHealth < 0) {
                        obsHealth = 0;
                    }
                    printInfo(playerHealth,obsHealth);



                }
            }
            counter++;
        }
        if (playerHealth>0){
            if (getName().equals("Maden")){
                int oddWin = random.nextInt(0,101);
                if (oddWin <= 15){
                    int oddType = random.nextInt(0,101);
                    Weapon[] weapons = Weapon.weapons();
                    if (oddType <= 20){
                        getPlayer().getInventory().setWeapon(weapons[2]);
                        System.out.println("Tüfek kazandınız!!");
                    } else if (oddType <= 50 && weapons[1].getDamage() >= getPlayer().getInventory().getWeapon().getDamage()) {
                        getPlayer().getInventory().setWeapon(weapons[1]);
                        System.out.println("Kılıç kazandınız!!");
                    }else if (weapons[0].getDamage() > getPlayer().getInventory().getWeapon().getDamage()) {
                        getPlayer().getInventory().setWeapon(weapons[0]);
                        System.out.println("Tabanca kazandınız!!");
                    }
                } else if (oddWin <= 30) {
                    int oddType = random.nextInt(0,101);
                    Armor[] armors = Armor.armores();
                    if (oddType <= 20 ){
                        getPlayer().getInventory().setArmor(armors[2]);
                        System.out.println("Ağır armor kazandınız!!");
                    } else if (oddType <= 50 && armors[1].getBlock() >= getPlayer().getInventory().getArmor().getBlock() ) {
                        getPlayer().getInventory().setArmor(armors[1]);
                        System.out.println("Orta armor kazandınız!!");
                    } else if (armors[0].getBlock() >= getPlayer().getInventory().getArmor().getBlock()) {
                        getPlayer().getInventory().setArmor(armors[0]);
                        System.out.println("Hafif armor kazandınız!!");
                    }
                } else if ( oddWin <= 55) {
                    int oddType = random.nextInt(0,101);
                    if (oddType <= 20 ){
                        getPlayer().setMoney(getPlayer().getMoney()+10);
                        System.out.println("10 para kazandınız!!");
                    } else if (oddType <= 50) {
                        getPlayer().setMoney(getPlayer().getMoney()+5);
                        System.out.println("5 para kazandınız!!");
                    } else {
                        getPlayer().setMoney(getPlayer().getMoney()+1);
                        System.out.println("1 para kazandınız!!");
                    }
                } else {
                    System.out.println("Hiçbir şey kazanamadın bir dahaki sefere!");
                }
            } else{
                int earnMoney = getObstacle().getMoney()*obstacleNumber;
                int totalMoney = getPlayer().getMoney() + (earnMoney);
                System.out.println(getObstacle().getName()+" başına "+getObstacle().getMoney()+" para kazandınız. Toplam: "+earnMoney);
                getPlayer().setMoney(totalMoney);
                System.out.println(getName()+"'den sürpriz ödülün: "+getAward().getName());
                if (getName().equals("Orman")){
                    getPlayer().getInventory().getFirewood().setOwnership(true);
                } else if (getName().equals("Nehir")) {
                    getPlayer().getInventory().getWater().setOwnership(true);
                } else {
                    getPlayer().getInventory().getFood().setOwnership(true);
                }
            }
        }
        return playerHealth;
    }
    public void printInfo(int playerHealth, int obsHealth){
        System.out.println(getPlayer().getName() + ": " + playerHealth + "\t" + getObstacle().getName() + ": " + obsHealth);
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }
}

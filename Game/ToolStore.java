package Game;

public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "İtem mağazası");
    }

    @Override
    public boolean onLocation() {
        String menu = "1.Silah Alma  => Vurduğunuz hasarı arttırır.\n" +
                "2.Kalkan Alma => Yediğiniz hasarı azaltır.\n" +
                "0.Çıkış       => Item mağazasından çıkış yaparsınız ";
        System.out.println("\n____________Item mağzasına Hoşgeldiniz!___________");
        System.out.println(menu);
        System.out.println("--------------------------------------------------");
        int select;
        while (true) {
            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            select = input.nextInt();
            if (select < 3 && select >= 0)
                break;
            else
                System.out.println("Lütfen geçerli bir değer giriniz!");
        }

        if (select == 1) {
            System.out.println("\n$$$$$$$$$$$$$ Silahlar $$$$$$$$$$$$$");
            printWeapons();
            buyWeapon();
        } else if (select == 2) {
            System.out.println("\n$$$$$$$$$$$$$ Zırhlar $$$$$$$$$$$$$$");
            printArmor();
            buyArmor();
        }
        return true;
    }

    private void printArmor() {
        Armor[] armorList = Armor.armores();
        for (Armor a : armorList) {
            System.out.println(a.getId() + "." + a.getName() + " => Koruması: " + a.getBlock() + ", Parası: " + a.getPrize());
        }
        System.out.println("0.Çıkış yap => Item ana menüsüne geri dönersiniz.");
    }

    private void buyArmor() {
        int select;
        Armor[] armorList = Armor.armores();
        while (true) {
            System.out.print("Almak istediğiniz korumayı seçiniz: ");
            select = input.nextInt();
            if (select >= 0 && select <= armorList.length) {
                break;
            }
            System.out.println("Lütfen geçerli bir değer giriniz!!");
        }
        if (select != 0) {
            Armor selectedArmor = armorList[select - 1];
            int armorPrice = selectedArmor.getPrize();

            if (getPlayer().getMoney() >= armorPrice) {
                getPlayer().getInventory().setArmor(selectedArmor);
                int balance = getPlayer().getMoney() - armorPrice;
                getPlayer().setMoney(balance);
            } else {
                System.out.println("Bakiyeniz yetersiz!!");
            }
        }else {
            onLocation();
        }
    }

    private void printWeapons() {
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "." + w.getName() + " => Hasarı: " + w.getDamage() + ", Parası: " + w.getPrize());
        }
        System.out.println("0.Çıkış yap => Item ana menüsüne geri dönersiniz.");

    }

    private void buyWeapon() {
        Weapon[] weaponList = Weapon.weapons();
        Weapon selectedWeapon = null;
        int select = 0;
        while (true) {
            System.out.print("Seçmek istediğiniz silahı seçiniz: ");
            select = input.nextInt();
            if (select >= 0 && select <= weaponList.length) {
                break;
            } else {
                System.out.println("Lütfen geçerli bir değer giriniz!!");
            }
        }
        if (select != 0){
            selectedWeapon = weaponList[select-1];
            int weaponPrize = selectedWeapon.getPrize();
            if (getPlayer().getMoney() >= weaponPrize){
                int balance = getPlayer().getMoney() - weaponPrize;
                getPlayer().getInventory().setWeapon(selectedWeapon);
                getPlayer().setMoney(balance);
            }else {
                System.out.println("Bakiyeniz yetersiz!!");
            }
        } else {
            onLocation();
        }
    }
}

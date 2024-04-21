package Game;

import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.print("İsminizi giriniz: ");
        String playerName = input.next();
        System.out.println("Macera oyununa hoşgeldin "+ playerName+" !!");
        Player player = new Player(playerName);
        player.selectChar();
        Location location = null;
        boolean food = player.getInventory().getFood().isOwnership();
        boolean water = player.getInventory().getWater().isOwnership();
        boolean fireWood = player.getInventory().getFirewood().isOwnership();
        while (!food || !fireWood || !water) {
            String menu = "1.Güvenli ev    => Canınız fullenir \n" +
                    "2.Item Mağazası => Item alabilirsiniz\n" +
                    "3.Mağara        => Zombilerle savaşıp sürpriz ödülü kazanmalısın\n" +
                    "4.Orman         => Vampirlerle savaşıp sürpriz ödülü kazanmalısın\n" +
                    "5.Nehir         => Ayılarla savaşıp sürpriz ödülü kazanmalısın\n" +
                    "6.Maden         => Yılanlarla savaşıp sürpriz itemler düşürebilirsin\n" +
                    "7.Info          => Karekterinin özelliklerini görebilirsin\n" +
                    "0.Çıkış         => Oyunu sonlandırır";
            int select;
            System.out.println("---------------------Bölgeler---------------------");
            System.out.println(menu);
            System.out.println("--------------------------------------------------");
            while (true) {
                System.out.print("Gitmek istediğiniz yeri seçiniz: ");
                select = input.nextInt();
                if (select < 8 && select >= 0)
                    break;
                System.out.println("Lütfen geçerli bir değer giriniz!!");
            }
            if (select == 0){
                System.out.println("Çıkış yapılıyor!!!");
                break;
            }else if (select == 1){
                location = new SafeHouse(player);
            }else if (select == 2) {
                location = new ToolStore(player);
            }else if (select == 3){
                if (food){
                    System.out.println("Mağaradan yemek ödülünü kazandınız bir daha giremezsiniz!!");
                    location = new NormalLoc(player,"Boşluk");
                }else{
                    location = new Cave(player);
                }
            } else if (select == 4) {
                if (fireWood){
                    System.out.println("Ormandan odun ödülünü kazandın bir daha giremezsin!!");
                    location = new NormalLoc(player,"Boşluk");
                }else {
                    location = new Forest(player);
                }
            } else if (select == 5) {
                if (water){
                    System.out.println("Nehirden su odülünü kazandın bir daha giremezsin!!");
                    location = new NormalLoc(player,"Boşluk");
                }else {
                    location = new River(player);
                }


            } else if (select == 6) {
                location = new Mine(player);

            } else {
                System.out.println("-----------------------Info-----------------------");
                System.out.println(player);
                location = new NormalLoc(player,"Boşluk");
            }

            if (!location.onLocation()){
                break;
            }
            food = player.getInventory().getFood().isOwnership();
            water = player.getInventory().getWater().isOwnership();
            fireWood = player.getInventory().getFirewood().isOwnership();
            System.out.println();
        }
        if (food && water && fireWood){
            System.out.println("------------------TEBRİKLER!!------------------");
            System.out.println("Tebrikler adadan kaçabildiniz!!");
        }

    }
}

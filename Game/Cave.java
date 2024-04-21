package Game;

public class Cave extends BattleLoc {

    Cave(Player player) {
        super(player, "Mağara", new Zombie(), new Award("yemek"));
    }

}

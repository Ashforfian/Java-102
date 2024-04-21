package Game;

public class Forest extends BattleLoc{
    Forest(Player player) {
        super(player, "Orman", new Vampire(), new Award("Odun"));
    }
}

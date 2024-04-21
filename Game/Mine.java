package Game;

public class Mine extends BattleLoc {
    Mine(Player player) {
        super(player, "Maden", new Snake(), new Award("Şans"));
    }
}

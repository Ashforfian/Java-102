package Game;

public class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    private void refreshHealth(){
        if (getPlayer().getHealth() < getPlayer().getMaxHealth()) {
            getPlayer().setHealth(getPlayer().getMaxHealth());
        }
    }
    @Override
    public boolean onLocation() {
        refreshHealth();
        System.out.println("Canınız yenilendi! Sağlık: "+ getPlayer().getHealth());
        return true;
    }
}

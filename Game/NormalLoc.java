package Game;

public  class NormalLoc extends Location{
    NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
package Game;
import java.util.Random;
public class Snake extends Obstacle{
    public Snake(){
        super(4,"Yılan",12,randomNumber(),0,5);
    }
    private static int randomNumber(){
        Random random = new Random();
        return random.nextInt(3,7);
    }
}

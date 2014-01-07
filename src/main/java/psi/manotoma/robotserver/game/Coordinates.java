package psi.manotoma.robotserver.game;

import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import static psi.manotoma.robotserver.game.CitySize.MAX;
import static psi.manotoma.robotserver.game.CitySize.MIN;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Coordinates {

    private int x;
    private int y;
    private static RandomData gen = new RandomDataImpl();

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Coordinates generateRandom() {
        return new Coordinates(gen.nextInt(MIN.size() - 1, MAX.size() - 1), 
                               gen.nextInt(MIN.size() - 1, MAX.size() - 1));
    }
    
    public String print(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}

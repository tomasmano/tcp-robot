package psi.manotoma.robotserver.game;

import static psi.manotoma.robotserver.game.CitySize.MAX;
import static psi.manotoma.robotserver.game.CitySize.MIN;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Coordinates {

    private int x;
    private int y;

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

    public Coordinates setX(int x) {
        if (x > MAX.size()) {
            throw new IllegalArgumentException(String.format("Cannot set x. Arg [%s] is higher than max [%s]", x, MAX.size()));
        }
        if (x < MIN.size()) {
            throw new IllegalArgumentException(String.format("Cannot set x. Arg [%s] is lower than min [%s]", x, MIN.size()));
        }
        this.x = x;
        return this;
    }

    public Coordinates setY(int y) {
        if (y > MAX.size()) {
            throw new IllegalArgumentException(String.format("Cannot set y. Arg [%s] is higher than max [%s]", y, MAX.size()));
        }
        if (y < MIN.size()) {
            throw new IllegalArgumentException(String.format("Cannot set y. Arg [%s] is lower than min [%s]", y, MIN.size()));
        }
        this.y = y;
        return this;
    }

    /**
     * Generates random coordinates in default interval lowered by n
     * @param n
     */
    public static Coordinates generateRandom(int n) {
        if (n < MIN.size() || n > MAX.size()) {
            throw new IllegalArgumentException(String.format("n is too low or high. min: [%s], max: [%s]", MIN.size(), MAX.size()));
        }
        return new Coordinates(RandomUtils.nextInt(MIN.size() + n, MAX.size() - n), 
                               RandomUtils.nextInt(MIN.size() + n, MAX.size() - n));
    }

    public static Coordinates generateRandom() {
        return new Coordinates(RandomUtils.nextInt(MIN.size() - 1, MAX.size() - 1), 
                               RandomUtils.nextInt(MIN.size() - 1, MAX.size() - 1));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinates other = (Coordinates) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }
    
    public String print(){
        return "(" + x + "," + y + ")";
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}

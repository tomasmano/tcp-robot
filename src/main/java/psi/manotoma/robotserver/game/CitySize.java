    package psi.manotoma.robotserver.game;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public enum CitySize {
    
    MAX(18), MIN(-18);
    
    private int size;

    private CitySize(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
    
}

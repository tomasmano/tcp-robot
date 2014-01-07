package psi.manotoma.robotserver.game;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Robot {
    
    private String name;
    private Coordinates coordinates;
    
    private Robot(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    public static Robot generate(){
        return new Robot(RandomStringUtils.randomAlphabetic(8), Coordinates.generateRandom());
    }

    @Override
    public String toString() {
        return "Robot{" + "name=" + name + ", coordinates=" + coordinates + '}';
    }
    
    
}

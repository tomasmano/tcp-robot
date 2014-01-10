package psi.manotoma.robotserver.game;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Robot {
    
    private String name;
    private StepDirection dir;
    private Coordinates coor;
    
    private Robot(String name, Coordinates coordinates, StepDirection dir) {
        this.name = name;
        this.coor = coordinates;
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StepDirection getDirection() {
        return dir;
    }

    public void setDirection(StepDirection direction) {
        this.dir = direction;
    }

    public Coordinates getCoordinates() {
        return coor;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coor = coordinates;
    }
    
    public static Robot generate(){
        return new Robot(RandomStringUtils.randomAlphabetic(8), Coordinates.generateRandom(1), StepDirection.generate());
    }

    public void step(){
        this.coor.setX(coor.getX() + dir.x()).setY(coor.getY() + dir.y());
    }

    public void turnLeft(){
        this.dir = StepDirection.turnLeft(this.dir);
    }

    @Override
    public String toString() {
        return "Robot{" + "name=" + name + ", dir=" + dir + ", coor=" + coor + '}';
    }
    
}

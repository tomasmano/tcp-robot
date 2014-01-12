package psi.manotoma.robotserver.game;

import org.apache.commons.lang3.RandomStringUtils;
import psi.manotoma.robotserver.robot.StepsController;
import psi.manotoma.robotserver.robot.state.RobotBrokenProcessorState;
import psi.manotoma.robotserver.robot.state.RobotNormalState;
import psi.manotoma.robotserver.robot.state.RobotState;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Robot {
    
    private String name;
    private StepDirection dir;
    private Coordinates coor;
    
    private RobotState robotState;
    private StepsController stepsController;
    
    private Robot(String name, Coordinates coordinates, StepDirection dir) {
        this.name = name;
        this.coor = coordinates;
        this.dir = dir;
        this.robotState = new RobotNormalState();
        this.stepsController = new StepsController();
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
        if (!stepsController.validateSteps()) {
            robotState = new RobotBrokenProcessorState();
        }
        robotState.step(this);
        stepsController.incrementSteps();
    }

    public void turnLeft(){
        robotState.turnLeft(this);
        stepsController.resetSteps();
    }

    @Override
    public String toString() {
        return "Robot{" + "name=" + name + ", dir=" + dir + ", coor=" + coor + ", state=" + robotState + ", steps=" + stepsController + '}';
    }
    
}

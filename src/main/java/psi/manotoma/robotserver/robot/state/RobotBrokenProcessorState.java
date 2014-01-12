package psi.manotoma.robotserver.robot.state;

import psi.manotoma.robotserver.exception.RobotBrokenProcessorException;
import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.game.StepDirection;

/**
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotBrokenProcessorState implements RobotState {

    public void step(Robot r) {
        throw new RobotBrokenProcessorException(String.format("Cannot perform step on [%s], processor is broken.", r));
    }

    public void turnLeft(Robot r) {
        r.setDirection(
                StepDirection
                    .turnLeft(r.getDirection())
                );
    }

    @Override
    public String toString() {
        return "BrokenProcessorState";
    }
    
}

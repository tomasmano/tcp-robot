package psi.manotoma.robotserver.robot.state;

import psi.manotoma.robotserver.game.Robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface RobotState {

    public void step(Robot robot);

    public void turnLeft(Robot robot);
}

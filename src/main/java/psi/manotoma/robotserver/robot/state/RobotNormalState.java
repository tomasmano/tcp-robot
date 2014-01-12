package psi.manotoma.robotserver.robot.state;

import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.game.StepDirection;

public class RobotNormalState implements RobotState {

    public void step(Robot r) {
        r.getCoordinates()
                .setX(r.getCoordinates().getX() + r.getDirection().x())
                .setY(r.getCoordinates().getY() + r.getDirection().y());
    }

    public void turnLeft(Robot r) {
        r.setDirection(
                StepDirection.turnLeft(r.getDirection()));
    }

    @Override
    public String toString() {
        return "NormalState";
    }
}

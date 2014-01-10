package psi.manotoma.robotserver.robot;

import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.server.model.Request;

public class RobotRequest implements Request {

    private Command command;
    
    private Robot robot;

    public RobotRequest(String inputCommand, Robot robot) {
        this.command = Command.valueOf(inputCommand);
        this.robot = robot;
    }

    public Command getCommand() {
        return command;
    }

    public Robot getRobot() {
        return robot;
    }

    @Override
    public String toString() {
        return "RobotRequest{'" + command + "', " + robot + "}";
    }

    //////////  Inner Class  //////////
    
    public enum Command {

        KROK, VLEVO, ZVEDNI, OPRAVIT;
    }
}

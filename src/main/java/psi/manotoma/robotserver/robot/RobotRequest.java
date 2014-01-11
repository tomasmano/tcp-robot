package psi.manotoma.robotserver.robot;

import psi.manotoma.robotserver.exception.BadSyntaxException;
import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.server.model.Request;
import psi.manotoma.robotserver.server.support.RobotRequestParser;

public class RobotRequest implements Request {

    private Command command;
    
    private Robot robot;

    public RobotRequest(String input, Robot robot) {
        String[] line = RobotRequestParser.parse(input);
        if (!line[0].equals(robot.getName())) {
            throw new BadSyntaxException(String.format("Invalid name [%s] for robot [%s]", line[0], robot));
        }
        this.command = Command.valueOf(line[1]);
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

package psi.manotoma.robotserver.robot;

import psi.manotoma.robotserver.exception.BadSyntaxException;
import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.server.model.Request;
import static psi.manotoma.robotserver.server.support.RobotRequestParser.parseForCommand;
import static psi.manotoma.robotserver.server.support.RobotRequestParser.parseLine;
import static psi.manotoma.robotserver.server.support.RobotRequestParser.parseRepairCommand;

public class RobotRequest implements Request {

    private Command cmd;
    private int nProc = -1;
    
    private Robot robot;

    public RobotRequest(String input, Robot robot) {
        String[] line = parseLine(input);
        if (!line[0].equals(robot.getName())) {
            throw new BadSyntaxException(String.format("Invalid name [%s] for robot [%s]", line[0], robot));
        }
        this.cmd = parseForCommand(line[1]);
        if (cmd.equals(Command.OPRAVIT)) {
            nProc = parseRepairCommand(line[1]);
        }
        this.robot = robot;
    }

    public Command getCommand() {
        return cmd;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getnProc() {
        return nProc;
    }

    @Override
    public String toString() {
        return "RobotRequest{" + "cmd=" + cmd + ", robot=" + robot + ", nProc=" + nProc + '}';
    }
    
    //////////  Inner Class  //////////
    
    public enum Command {

        KROK, VLEVO, ZVEDNI, OPRAVIT;
    }
}

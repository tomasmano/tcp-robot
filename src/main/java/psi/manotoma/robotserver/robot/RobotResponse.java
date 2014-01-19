package psi.manotoma.robotserver.robot;

import psi.manotoma.robotserver.game.Coordinates;
import psi.manotoma.robotserver.game.GameContext;
import psi.manotoma.robotserver.server.model.Response;
import static psi.manotoma.robotserver.robot.StatusUtils.isConnectionAcknwledgment;
import static psi.manotoma.robotserver.robot.StatusUtils.isConnectionTerminated;
import static psi.manotoma.robotserver.robot.StatusUtils.hasError;
import static psi.manotoma.robotserver.robot.StatusUtils.isSecretFound;
import static psi.manotoma.robotserver.robot.StatusUtils.isBrokenProcessor;


public class RobotResponse implements Response {
    
    private Status status;
    private String responseLine;
    private String robotName;
    private Coordinates coordinates;
    private GameContext ctx;
    private int nProc;
    
    private final static String CRLF = "\r\n"; // TERMINATOR

    public RobotResponse(Status status, String robotName, Coordinates coordinates) {
        this.status = status;
        this.robotName = robotName;
        this.coordinates = coordinates;
    }

    public RobotResponse(Status status, String robotName, Coordinates coordinates, GameContext ctx) {
        this.status = status;
        this.robotName = robotName;
        this.coordinates = coordinates;
        this.ctx = ctx;
    }

    public RobotResponse(Status status, String robotName, Coordinates coordinates, GameContext ctx, int nProc) {
        this.status = status;
        this.robotName = robotName;
        this.coordinates = coordinates;
        this.ctx = ctx;
        this.nProc = nProc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResponseLine() {
        if (isConnectionAcknwledgment(status)) {
            responseLine = Status._210.qName() + " " + robotName + ".";
            return responseLine + CRLF;
        }
        if (isBrokenProcessor(status)) {
            responseLine = status.qName() + " " + nProc + CRLF;
            return responseLine;
        }
        if (hasError(status)) {
            responseLine = status.qName() + CRLF;
            return responseLine;
        }
        if (isSecretFound(status)) {
            responseLine = status.qName() + " " + ctx.getSecretText() + CRLF;
            return responseLine;
        }
        if (isConnectionTerminated(status)) {
            responseLine = status.qName() + CRLF;
            return responseLine;
        }
        responseLine = status.qName() + " " + coordinates.print() + CRLF;
        return responseLine;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "RobotResponse{" + "responseLine=" + responseLine + ", robotName=" + robotName + '}';
    }
    
}

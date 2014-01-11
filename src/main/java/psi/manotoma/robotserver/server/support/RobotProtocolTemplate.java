package psi.manotoma.robotserver.server.support;

import psi.manotoma.robotserver.io.RequestReader;
import psi.manotoma.robotserver.io.RobotRequestReader;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotRequest;
import psi.manotoma.robotserver.robot.RobotResponse;
import java.io.InputStream;
import java.io.OutputStream;
import psi.manotoma.robotserver.exception.UnknownCommandException;
import psi.manotoma.robotserver.game.GameController;
import psi.manotoma.robotserver.robot.Status;
import psi.manotoma.robotserver.server.support.sender.RobotResponseSender;

public class RobotProtocolTemplate extends ProtocolTemplate<RobotRequest, RobotResponse> {
    
    public RobotProtocolTemplate(InputStream input, OutputStream output) {
        super(new RobotRequestReader(input), output);
    }

    @Override
    public RobotRequest parse(RequestReader source) {
        RobotRequest req = RobotMsgsFactory.createRequest(source, robot);
        return req;
    }

    @Override
    public void preProcess(RobotRequest req) {
        // nothing
    }

    @Override
    public RobotResponse serve(RobotRequest req) {
        if (req.getCommand().equals(RobotRequest.Command.KROK)) {
            GameController.step(robot, ctx);
            return RobotMsgsFactory.createResponse(Status._240, robot);
        }
        if (req.getCommand().equals(RobotRequest.Command.VLEVO)) {
            GameController.turnLeft(robot, ctx);
            return RobotMsgsFactory.createResponse(Status._240, robot);
        }
        if (req.getCommand().equals(RobotRequest.Command.OPRAVIT)) {
            GameController.repair(robot, ctx);
        }
        if (req.getCommand().equals(RobotRequest.Command.ZVEDNI)) {
            GameController.pickup(robot, ctx);
            return RobotMsgsFactory.createResponseSecretFound(Status._260, robot, ctx);
        }
        throw new UnknownCommandException(String.format("Unknown command [%s]", req.getCommand()));
    }

    @Override
    public void postProcess(RobotRequest req, RobotResponse res) {
        RobotResponseSender.getInstance().send(res, getOutputStream());
    }
}

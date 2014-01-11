package psi.manotoma.robotserver.exception.handler;

import psi.manotoma.robotserver.exception.BadSyntaxException;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotResponse;
import psi.manotoma.robotserver.robot.Status;
import psi.manotoma.robotserver.server.support.sender.RobotResponseSender;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robotserver.exception.NoSecretException;
import psi.manotoma.robotserver.exception.RobotCrashedException;
import psi.manotoma.robotserver.exception.UnknownCommandException;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotExceptionVisitor {

    public static final Logger LOG = LoggerFactory.getLogger(RobotExceptionVisitor.class);

    public RobotResponse handle(BadSyntaxException ex, OutputStream os) {
        LOG.debug("Request had bad syntax, creating 500 response...");
        RobotResponse res = RobotMsgsFactory.createErrorResponse(Status._500);
        RobotResponseSender.getInstance().send(res, os);
        return res;
    }

    public RobotResponse handle(UnknownCommandException ex, OutputStream os) {
        LOG.debug("Request had unknown command [{}], creating 500 response...", ex.getMessage());
        RobotResponse res = RobotMsgsFactory.createErrorResponse(Status._500);
        RobotResponseSender.getInstance().send(res, os);
        return res;
    }

    public RobotResponse handle(NoSecretException ex, OutputStream os) {
        LOG.debug("{}, creating 550 response...", ex.getMessage());
        RobotResponse res = RobotMsgsFactory.createErrorResponse(Status._550);
        RobotResponseSender.getInstance().send(res, os);
        return res;
    }

    public RobotResponse handle(RobotCrashedException ex, OutputStream os) {
        LOG.debug("{}, creating 530 response...", ex.getMessage());
        RobotResponse res = RobotMsgsFactory.createErrorResponse(Status._530);
        RobotResponseSender.getInstance().send(res, os);
        return res;
    }

}

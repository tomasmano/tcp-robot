package psi.manotoma.robotserver.exception.handler;

import psi.manotoma.robotserver.exception.BadSyntaxException;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotResponse;
import psi.manotoma.robotserver.robot.Status;
import psi.manotoma.robotserver.server.support.sender.RobotResponseSender;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotExceptionVisitor {

    public static final Logger LOG = LoggerFactory.getLogger(RobotExceptionVisitor.class);

    /**
     * Handles code 400.
     */
    public RobotResponse handle(BadSyntaxException ex, OutputStream os) {
        LOG.debug("Request had bad syntax, creating 500 response...");
        RobotResponse res = RobotMsgsFactory.createErrorResponse(Status._500);
        RobotResponseSender.getInstance().send(res, os);
        return res;
    }

}
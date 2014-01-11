package psi.manotoma.robotserver.exception;

import psi.manotoma.robotserver.exception.handler.RobotExceptionVisitor;
import psi.manotoma.robotserver.robot.RobotRequest;
import psi.manotoma.robotserver.robot.RobotResponse;
import java.io.OutputStream;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotCrashedException extends RobotException {
    
    public RobotCrashedException() {
    }

    public RobotCrashedException(RobotRequest request) {
        super(request);
    }

    public RobotCrashedException(String message) {
        super(message);
    }

    public RobotCrashedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RobotCrashedException(Throwable cause) {
        super(cause);
    }

    public RobotCrashedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public RobotResponse accept(RobotExceptionVisitor visitor, OutputStream os) {
        return visitor.handle(this, os);
    }
    
}

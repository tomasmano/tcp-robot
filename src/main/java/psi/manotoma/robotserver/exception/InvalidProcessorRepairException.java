package psi.manotoma.robotserver.exception;

import psi.manotoma.robotserver.exception.handler.RobotExceptionVisitor;
import psi.manotoma.robotserver.robot.RobotRequest;
import psi.manotoma.robotserver.robot.RobotResponse;
import java.io.OutputStream;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class InvalidProcessorRepairException extends RobotException {
    
    public InvalidProcessorRepairException() {
    }

    public InvalidProcessorRepairException(RobotRequest request) {
        super(request);
    }

    public InvalidProcessorRepairException(String message) {
        super(message);
    }

    public InvalidProcessorRepairException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProcessorRepairException(Throwable cause) {
        super(cause);
    }

    public InvalidProcessorRepairException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public RobotResponse accept(RobotExceptionVisitor visitor, OutputStream os) {
        return visitor.handle(this, os);
    }
    
}

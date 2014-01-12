package psi.manotoma.robotserver.exception;

import psi.manotoma.robotserver.exception.handler.RobotExceptionVisitor;
import psi.manotoma.robotserver.robot.RobotRequest;
import psi.manotoma.robotserver.robot.RobotResponse;
import java.io.OutputStream;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ProcessorFailureException extends RobotException {
    
    private int nProc;
    
    public ProcessorFailureException() {
    }

    public ProcessorFailureException(RobotRequest request) {
        super(request);
    }

    public ProcessorFailureException(int nProc) {
        this.nProc = nProc;
    }

    public ProcessorFailureException(String message) {
        super(message);
    }

    public ProcessorFailureException(String message, int nProc) {
        super(message);
        this.nProc = nProc;
    }

    public ProcessorFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessorFailureException(Throwable cause) {
        super(cause);
    }

    public ProcessorFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public RobotResponse accept(RobotExceptionVisitor visitor, OutputStream os) {
        return visitor.handle(this, os);
    }

    public int getnProc() {
        return nProc;
    }

    public void setnProc(int nProc) {
        this.nProc = nProc;
    }
    
}

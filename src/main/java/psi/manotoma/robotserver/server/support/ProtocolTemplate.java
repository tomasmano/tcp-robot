package psi.manotoma.robotserver.server.support;

import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.server.model.Response;
import psi.manotoma.robotserver.server.model.Request;
import psi.manotoma.robotserver.exception.handler.RobotExceptionHandler;
import psi.manotoma.robotserver.exception.RobotException;
import psi.manotoma.robotserver.io.RequestReader;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robotserver.game.GameContext;

/**
 * Protocol template. Example of Template Method pattern. Also the reciever of
 * command object. Knows how to perform the operations associated with carrying
 * out a request.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public abstract class ProtocolTemplate<RQ extends Request, RSP extends Response> {

    public static final Logger LOG = LoggerFactory.getLogger(ProtocolTemplate.class);
    private RequestReader parser;
    private OutputStream os;
    protected Robot robot;
    protected GameContext ctx;

    public ProtocolTemplate(RequestReader parser, OutputStream os) {
        this.parser = parser;
        this.os = os;
    }

    //////////  Template method (general workflow structure)  //////////
    
    public RSP doTemplate() {
        RQ req = null;
        RSP res = null;
        try {
            req = parse(parser);
            LOG.info("{}", req);
            preProcess(req);
            res = serve(req);
            postProcess(req, res);
        } catch (RobotException e) {
            res = (RSP) RobotExceptionHandler.getInstance().handle(e, os);
        } finally {
            LOG.debug("Steps done.");
            return res;
        }
    }

    //////////  Individual steps (placeholders)  //////////
    
    /**
     * Parse the given reader.
     *
     * @param source the given source
     * @return request
     */
    public abstract RQ parse(RequestReader source);

    /**
     * Do custom preprocessing.
     *
     * @param req request to be preprocessed
     */
    public abstract void preProcess(RQ req);

    /**
     * Serve the given request.
     *
     * @param req
     * @return
     */
    public abstract RSP serve(RQ req);

    /**
     * Do custom postprocessing.
     *
     * @param res response to be postprocessed
     */
    public abstract void postProcess(RQ req, RSP res);

    //////////  Getters / Setters  //////////
    
    public OutputStream getOutputStream() {
        return os;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
        LOG.info("Using {}", robot);
    }

    public void setContext(GameContext ctx) {
        this.ctx = ctx;
        LOG.info("Using {}", ctx);
    }
}

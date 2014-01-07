package psi.manotoma.robotserver.server.support;

import psi.manotoma.robotserver.io.RequestReader;
import psi.manotoma.robotserver.io.RobotRequestReader;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotRequest;
import psi.manotoma.robotserver.robot.RobotResponse;
import java.io.InputStream;
import java.io.OutputStream;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void postProcess(RobotRequest req, RobotResponse res) {
        // nothing
    }
}

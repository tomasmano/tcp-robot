package psi.manotoma.robotserver.server.support;

import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotResponse;
import psi.manotoma.robotserver.robot.StatusUtils;
import psi.manotoma.robotserver.server.support.sender.RobotResponseSender;
import java.io.IOException;
import java.net.Socket;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robotserver.game.Coordinates;

/**
 * Server task. Command object.
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotServerTask implements Runnable {
    
    public static final Logger LOG = LoggerFactory.getLogger(RobotServerTask.class);
    
    private RobotProtocolTemplate template;
    private Socket client;
    
    private Robot robot;
    
    private Coordinates secret;

    public RobotServerTask(RobotProtocolTemplate template, Socket client) {
        robot = Robot.generate();
        secret = Coordinates.generateRandom();
        this.template = template;
        this.client = client;
        this.template.setRobot(robot);
        this.template.setSecret(secret);
    }
    
    public void run() {
        process();
    }

    public void process() {
        long start = System.currentTimeMillis();
        
        ack();
        
        RobotResponse res = template.doTemplate();
        
        while(!StatusUtils.hasError(res.getStatus())){
            res = template.doTemplate();
        }
        IOUtils.closeQuietly(client);
        long end = System.currentTimeMillis();
        long diff = end - start;
        
        LOG.info("Finished [{} ms]: {}", diff, res);
    }

    private void ack() {
        try {
            RobotResponseSender.getInstance().send(RobotMsgsFactory.createAcknowledgmentResponse(robot), client.getOutputStream());
        } catch (IOException ex) {
            LOG.error("An exception occured: {}", ex);
            IOUtils.closeQuietly(client);
        }
        
    }
    
}

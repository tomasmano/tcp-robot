package psi.manotoma.robotserver.server.support;

import psi.manotoma.robotserver.game.Robot;
import psi.manotoma.robotserver.robot.RobotMsgsFactory;
import psi.manotoma.robotserver.robot.RobotResponse;
import psi.manotoma.robotserver.robot.StatusUtils;
import psi.manotoma.robotserver.server.support.sender.RobotResponseSender;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robotserver.game.Coordinates;
import psi.manotoma.robotserver.game.GameContext;

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
    
    public RobotServerTask(RobotProtocolTemplate template, Socket client) {
        robot = Robot.generate();
        this.template = template;
        this.client = client;
        this.template.setRobot(robot);
        this.template.setContext(new GameContext(Coordinates.generateRandom(), GameContext.generateSecretText()));
        
    }
    
    public void run() {
        process();
    }

    public void process() {
        long startSession = System.currentTimeMillis();
        
        ack();
        
        RobotResponse res = template.doTemplate();
        
        while (!StatusUtils.isCloseConnection(res.getStatus())) {
            long start = System.currentTimeMillis();
            res = template.doTemplate();
            long end = System.currentTimeMillis();
            long diff = end - start;
            LOG.info("Finished [{} ms]: {}", diff, res);
        }
//        try {
//            IOUtils.closeQuietly(client.getOutputStream());
//        } catch (IOException ex) {
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//        }
//        try {
//            IOUtils.closeQuietly(client.getInputStream());
//        } catch (IOException ex) {
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//            System.err.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//        }
        IOUtils.closeQuietly(client);
        
        long endSession = System.currentTimeMillis();
        long diffSession = endSession - startSession;
        LOG.info("Session finished [{} ms]: {}", diffSession, res);

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

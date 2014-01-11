package psi.manotoma.robotserver.game;

import psi.manotoma.robotserver.exception.NoSecretException;
import psi.manotoma.robotserver.exception.RobotCrashedException;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameController {
    
    public static void step(Robot robot, GameContext ctx){
        try {
            robot.step();
        } catch (IllegalArgumentException e) {
            throw new RobotCrashedException(String.format("Step was out of the accepted coordinates. Robot [%s] has been destroyed.", robot));
        }
    }
    
    public static void turnLeft(Robot robot, GameContext ctx){
        robot.turnLeft();
    }
    
    public static void repair(Robot robot, GameContext ctx){
        
    }
    
    public static void pickup(Robot robot, GameContext ctx){
        if (!robot.getCoordinates().equals(ctx.getSecret())) {
            throw new NoSecretException(String.format("No secret at the given coordinates %s", robot.getCoordinates()));
        }
        // win
    }
    
}

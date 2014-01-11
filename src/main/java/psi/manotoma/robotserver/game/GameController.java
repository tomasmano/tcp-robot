package psi.manotoma.robotserver.game;

import psi.manotoma.robotserver.exception.NoSecretException;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameController {
    
    public static void step(Robot robot, GameContext ctx){
        robot.step();
    }
    
    public static void turnLeft(Robot robot, GameContext ctx){
        robot.turnLeft();
    }
    
    public static void repair(Robot robot, GameContext ctx){
        
    }
    
    public static void pickup(Robot robot, GameContext ctx){
        if (!robot.getCoordinates().equals(ctx.getSecret())) {
            throw new NoSecretException(String.format("No secret at given coordinates %s", robot.getCoordinates()));
        }
        // win
    }
    
}

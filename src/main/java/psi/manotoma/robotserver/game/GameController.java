package psi.manotoma.robotserver.game;

import psi.manotoma.robotserver.exception.NoSecretException;
import psi.manotoma.robotserver.exception.OutOfCoordinatesException;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameController {
    
    public static void step(Robot robot, GameContext ctx){
        try {
            robot.step();
        } catch (IllegalArgumentException e) {
            throw new OutOfCoordinatesException(String.format("Step was out of the accepted coordinates. Robot [%s] has been destroyed.", robot));
        }
    }
    
    public static void turnLeft(Robot robot, GameContext ctx){
        robot.turnLeft();
    }
    
    public static void repair(Robot robot, int nProcessor, GameContext ctx){
        RepairService.repairProcessor(robot, nProcessor);
    }
    
    public static void pickup(Robot robot, GameContext ctx){
        if (!robot.getCoordinates().equals(ctx.getSecret())) {
            throw new NoSecretException(String.format("No secret at the given coordinates %s", robot.getCoordinates()));
        }
        // win
    }
    
}

package psi.manotoma.robotserver.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class StepsController {

    private int stepsCount = 0;

    public void incrementSteps() {
            stepsCount++;
    }

    public void resetSteps() {
        this.stepsCount = 0;
    }

    public boolean validateSteps() {
        if (stepsCount > 10) {
            return false;
        }
        return true;    
    }

    @Override
    public String toString() {
        return "stepsCount=" + stepsCount + '}';
    }
    
}

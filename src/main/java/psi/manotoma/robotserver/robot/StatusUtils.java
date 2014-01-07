package psi.manotoma.robotserver.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class StatusUtils {
    
    public static boolean isConnectionAcknwledgment(Status status) {
        return status.equals(Status._210);
    }
    
    public static boolean hasError(Status status) {
        return status.qName().startsWith("5");
    }
}

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
        return status.code().startsWith("5");
    }

    public static boolean isCloseConnection(Status status) {
        return hasError(status) && !status.isSameAs(Status._500, Status._580);
    }

}

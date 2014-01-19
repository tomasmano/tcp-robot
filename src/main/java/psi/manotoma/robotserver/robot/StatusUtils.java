package psi.manotoma.robotserver.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class StatusUtils {
    
    public static boolean isConnectionAcknwledgment(Status status) {
        return status.equals(Status._210);
    }

    public static boolean isConnectionTerminated(Status status) {
        return status.equals(Status._599);
    }
    
    public static boolean hasError(Status status) {
        return status.code().startsWith("5");
    }

    public static boolean isCloseConnection(Status status) {
        return !status.isSameAs(Status._500, Status._580, Status._240, Status._210);
    }

    public static boolean isSecretFound(Status status) {
        return status.isSameAs(Status._260);
    }

    public static boolean isBrokenProcessor(Status status) {
        return status.isSameAs(Status._580);
    }

}

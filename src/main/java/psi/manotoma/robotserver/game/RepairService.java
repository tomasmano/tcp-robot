package psi.manotoma.robotserver.game;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RepairService {

    public static void repairProcessor(Robot r, int nProcessor) {
        r.repair(nProcessor);
    }
}

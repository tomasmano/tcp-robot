package psi.manotoma.robotserver.robot;

import psi.manotoma.robotserver.exception.InvalidProcessorRepairException;
import psi.manotoma.robotserver.game.RandomUtils;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class ProcessorEngine {
    
    private static final int MAX_INTERVAL = 15;
    
    private boolean isWorking = true;
    private int brokenCPU = -1;

    public void repair(int n){
        if (n < 0 || n >= 10) {
            throw new InvalidProcessorRepairException(String.format("Attempt to repair working processor %s", n));
        }
        if (n != brokenCPU) {
            throw new InvalidProcessorRepairException(String.format("Attempt to repair working processor %s", n));
        }
        brokenCPU = -1;
        isWorking = true;
    }
    
    public boolean isWorking(){
        return isWorking;
    }
    
    public void compute() {
        // do 'nothing'
        int r = RandomUtils.nextInt(1, MAX_INTERVAL);
        if (r <= 9) {
            brokenCPU = r;
            isWorking = false;
        }
    }

    public int getBrokenCPU() {
        return brokenCPU;
    }

    @Override
    public String toString() {
        return "ProcessorEngine{" + "isWorking=" + isWorking + ", brokenCPU=" + brokenCPU + '}';
    }
    
}

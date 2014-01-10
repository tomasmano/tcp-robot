package psi.manotoma.robotserver.game;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public enum StepDirection {
    
    N(0, 1), W(1, 0), S(0, -1), E(-1, 0);

    private int x;
    private int y;

    private StepDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    
    public static StepDirection turnLeft(StepDirection dir){
        if (dir.equals(StepDirection.N)) {
            return StepDirection.W;
        }
        if (dir.equals(StepDirection.W)) {
            return StepDirection.S;
        }
        if (dir.equals(StepDirection.S)) {
            return StepDirection.E;
        }
        // if (dir.equals(StepDirection.E))
        return StepDirection.N;
    }
    
    public static StepDirection generate(){
        return StepDirection.values()[RandomUtils.nextInt(0, 3)];
    }
   
}

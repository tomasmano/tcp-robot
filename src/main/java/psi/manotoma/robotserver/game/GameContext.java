package psi.manotoma.robotserver.game;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameContext {
    
    private final Coordinates secret;

    public GameContext(Coordinates secret) {
        this.secret = secret;
    }

    public Coordinates getSecret() {
        return secret;
    }
    
    
}

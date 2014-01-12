package psi.manotoma.robotserver.game;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameContext {
    
    private final Coordinates secret;
    private final String secretText;
    
    public GameContext(Coordinates secret, String secretText) {
        this.secret = secret;
        this.secretText = secretText;
    }

    public Coordinates getSecret() {
        return secret;
    }

    public String getSecretText() {
        return secretText;
    }
    
    public static String generateSecretText(){
        return RandomStringUtils.randomAlphabetic(32);
    }
    
    @Override
    public String toString() {
        return "GameContext{" + "secret=" + secret + ", secretText=" + secretText + '}';
    }
    
}

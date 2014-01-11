package psi.manotoma.robotserver.server.support;

import java.util.Scanner;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotRequestParser {

    public static String[] parse(String line){
        Scanner sc = new Scanner(line);
        String name = sc.next();
        String command = sc.next();
        sc.close();
        return new String[]{name, command};
    }
}

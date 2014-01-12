package psi.manotoma.robotserver.server.support;

import java.util.Scanner;
import psi.manotoma.robotserver.robot.RobotRequest;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotRequestParser {

    public static String[] parseLine(String line){
        Scanner sc = new Scanner(line);
        String name = sc.next();
        String command = sc.nextLine().trim();
        sc.close();
        return new String[]{name, command};
    }

    public static RobotRequest.Command parseForCommand(String cmdPart){
        int end = cmdPart.indexOf(" ");
        String cmd = cmdPart.substring(0, end == -1 ? cmdPart.length() : end);
        return RobotRequest.Command.valueOf(cmd.trim());
    }

    public static int parseRepairCommand(String repairCmd){
        int medzeraaaa = repairCmd.indexOf(" ") + 1;
        String cisiiisllooo = repairCmd.substring(medzeraaaa).trim();
        return Integer.parseInt(cisiiisllooo);
    }

}

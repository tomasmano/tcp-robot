package psi.manotoma.robotserver.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public enum Status {
    
    _210("210 Oslovuj mne"),
    _240("240 OK"),
    _260("260 USPECH"), //TODO + Text tajemství ??
    _500("500 NEZNAMY PRIKAZ "),
    _530("530 HAVARIE"),
    _550("550 NELZE ZVEDNOUT ZNACKU"),
    _571("571 PROCESOR FUNGUJE "),
    _572("572 ROBOT SE ROZPADL"),
    _580("580 SELHANI PROCESORU"); //TODO + x (cis. procesoru) ??
    
    private String qName;

    private Status(String qName) {
        this.qName = qName;
    }

    public String qName() {
        return qName;
    }
}

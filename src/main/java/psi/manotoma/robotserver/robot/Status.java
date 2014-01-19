package psi.manotoma.robotserver.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public enum Status {
    
    _210("210 Oslovuj mne", "210"),
    _240("240 OK", "240"),
    _260("260 USPECH", "260"), //TODO + Text tajemství ??
    _500("500 NEZNAMY PRIKAZ ", "500"),
    _530("530 HAVARIE", "530"),
    _550("550 NELZE ZVEDNOUT ZNACKU", "550"),
    _571("571 PROCESOR FUNGUJE ", "571"),
    _572("572 ROBOT SE ROZPADL", "572"),
    _580("580 SELHANI PROCESORU", "580"), //TODO + x (cis. procesoru) ??
    _599("599 KLIENT UKONCIL SPOJENI", "599"); //TODO + x (cis. procesoru) ??
    
    private String qName;
    private String code;

    private Status(String qName, String code) {
        this.qName = qName;
        this.code = code;
    }

    public String qName() {
        return qName;
    }

    public String code() {
        return code;
    }
    
    public boolean isSameAs(Status status){
        return this.equals(status);
    }

    public boolean isSameAs(Status... sts){
        for (Status s : sts) {
            if (this.equals(s)) {
                return true;
            }
        }
        return false;
    }
    
}

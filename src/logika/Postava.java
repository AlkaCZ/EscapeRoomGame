package logika;
/**
 *  Třída pro předpis postavy.
 */

public class Postava {

    /**
     *  Vlastnost postavy - Jméno
     */

    private String jmeno;
    /**
     *  Vlastnost postavy - Interakce
     *  To co postava řekne když jí potkáte.
     */
    private String interakce;
    /**
     *  Konstruktor postavy
     */
    public Postava(String jmeno, String interakce) {
        this.jmeno = jmeno;
        this.interakce = interakce;
    }
    /**
     *  Metoda na vrácení jména postavy
     */
    public String getNazev() {
        return jmeno;
    }

    public String getInterakce(){return interakce;}

}

package logika;
/**
 *  Třída PrikazCarymaryfuk implementuje pro hru příkaz carymaryfuk.
 *  Tato třída je součástí jednoduché textové hry.
 */

public class PrikazCarymaryfuk implements IPrikaz{
    /**
     Nastavení toho jak se bude příkaz volat jako příkaz
     */
    private static final String NAZEV = "carymaryfuk";
    /**
     Vytvoření instance planu, holder
     */
    private HerniPlan plan;
    /**
     Vytvoření instance hry, holder
     */
    private Hra hra;
    /**
     * Vytvoření konstruktoru příkazu
     */
    public PrikazCarymaryfuk(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().getNazev() != "Místnost2"){
            Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor("Místnost2");
        plan.setAktualniProstor(sousedniProstor);
        hra.setHadanka(true);
        return sousedniProstor.dlouhyPopis() + "\n" + "Ahoj, já jsem " + plan.getAktualniProstor().vratPostavu("Hádankář").getNazev() + plan.getAktualniProstor().vratPostavu("Hádankář").getInterakce();
    }
        else {
            plan.setAktualniProstor(plan.getZacatecniProstor());
            return "Kouzlo se nějak pokazilo a vrátilo tě na začátek hry :(" + "\n" + plan.getAktualniProstor().dlouhyPopis() ;
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

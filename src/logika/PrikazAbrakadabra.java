package logika;
/**
 *  Třída PrikazAbrakadabra implementuje pro hru příkaz abrakadabra.
 *  Tato třída je součástí jednoduché textové hry.
 */

public class PrikazAbrakadabra implements IPrikaz{

    /**
     Nastavení toho jak se bude příkaz volat jako příkaz
     */
    private static final String NAZEV = "abrakadabra";
    /**
     Vytvoření instance planu, holder
     */
    private HerniPlan plan;
    /**
     * Vytvoření konstruktoru příkazu
     */
    public PrikazAbrakadabra(HerniPlan plan) {

        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getAktualniProstor().getNazev() != "Místnost1") {
            Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor("Místnost1");
            plan.setAktualniProstor(sousedniProstor);

            return sousedniProstor.dlouhyPopis() + "\n" + "Ahoj, já jsem " + plan.getAktualniProstor().vratPostavu("Zadavatel").getNazev() + plan.getAktualniProstor().vratPostavu("Zadavatel").getInterakce();
        }
        else {
            plan.setAktualniProstor(plan.getZacatecniProstor());
            return "Kouzlo se nějak pokazilo a vrátilo tě na začátek hry :(" +"\n" + plan.getAktualniProstor().dlouhyPopis();
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

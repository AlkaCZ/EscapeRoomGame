package logika;
/**
 *  Třída PrikazPredat implementuje pro hru příkaz předat.
 *  Tato třída je součástí jednoduché textové hry.
 */

public class PrikazPredat implements IPrikaz{
    /**
     Nastavení toho jak se bude příkaz volat jako příkaz
     */
    private static final String NAZEV = "předat";
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
    public PrikazPredat(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Musíš zadat věc kterou chceš předat";
        }
        String nazevVeci = parametry[0];
        if (hra.getHadankaInProgress() == false && plan.getKosicek().obsahujeVec("Kniha") && plan.getAktualniProstor().getNazev() == "Místnost1" && nazevVeci.equals("Kniha") ){
            hra.setKonecHry(true);
            return "Gratulace, předal jsi knihu a ukončil tak quest";
        }
        else if (plan.getAktualniProstor().existencePostav()){
            return "Tato postava nic nechce";

        }
        return "Zde nejsou žádné postavy, kterým by jsi mohl něco dát.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

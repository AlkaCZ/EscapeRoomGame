package logika;

/**
 *  Třída PrikazHadanka implementuje pro hru příkaz hádanka.
 *  Tato třída je součástí jednoduché textové hry.
 */


public class PrikazHadanka implements IPrikaz{
    /**
     Nastavení toho jak se bude příkaz volat jako příkaz
     */
    private static final String NAZEV = "hádanka";
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
    public PrikazHadanka(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Musíš zadat odpověď na otázku";
        }

        String odpoved = parametry[0];
        if (plan.getAktualniProstor().getNazev() == "Místnost2" && hra.getHadankaInProgress()){
            if (odpoved.equals("díra")){
                plan.getKosicek().vlozDoKosicku(new Vec("Kniha",true,false,false,false));
                hra.setHadanka(false);
                return "Správně, tady máš knihu";
            }
            else {
                hra.setKonecHry(true);
                return "Špatně, bohužel znovu už to nezkusíš :)";
            }

        }
        else {
            return "Nejsi u hádankáře, nebo ti hádanku nikdo nedal";
        }

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

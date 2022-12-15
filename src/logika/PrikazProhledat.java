package logika;

public class PrikazProhledat implements IPrikaz{
    private static final String NAZEV = "prohledat";
    private HerniPlan plan;

    public PrikazProhledat(HerniPlan plan){
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0){
            return "Můžeš prohledat jen jednu věc najednou!";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniMistnost = plan.getAktualniProstor();

        if (aktualniMistnost.obsahujeVec(nazevVeci)) {
            Vec pozadovanaVec = aktualniMistnost.vyberVec(nazevVeci);
            if (pozadovanaVec.jeProhledatelna()) {
                return "prohledal jsi" + nazevVeci;
            }

            }

        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}

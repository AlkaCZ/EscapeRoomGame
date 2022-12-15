package logika;

public class PrikazPoloz implements IPrikaz{

    private static final String NAZEV = "polož";

    private HerniPlan plan;

    public PrikazPoloz(HerniPlan plan){
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0){
            return "Musíš zadat co chceš použít!";
        }

        String nazevVeci = parametry[0];

        if(plan.getKosicek().obsahujeVec(nazevVeci)) {
          Vec vecKPolozeni = plan.getKosicek().vyndejZKosiku(nazevVeci);
          plan.getAktualniProstor().vlozVec(vecKPolozeni);
          return  nazevVeci + "  jsi položil do prostoru " + plan.getAktualniProstor().getNazev();
        }

        return nazevVeci + " věc neni v košíčku";
    }



    @Override
    public String getNazev() {
        return NAZEV;
    }
}

package logika;

public class PrikazRozeber implements IPrikaz{

    private static final String NAZEV = "rozeber";

    private HerniPlan plan;

    public PrikazRozeber(HerniPlan plan){
        this.plan = plan;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Můžeš rozebrat jen jednu věc najednou!";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniMistnost = plan.getAktualniProstor();


        if (plan.getKosicek().obsahujeVec(nazevVeci)) {
            Vec pozadovanaVec = plan.getKosicek().vyndejZKosiku(nazevVeci);
            if (pozadovanaVec.jeRozebiratelna()){
                switch (pozadovanaVec.getNazev()){

                    case "doutník se zapalovačem":
                        plan.getKosicek().vlozDoKosicku(new Vec("doutník",true, false, false, false));
                        plan.getKosicek().vlozDoKosicku(new Vec("zapalovač",true, true, false, false));
                  break;
                }
            }
            else {
                plan.getKosicek().vlozDoKosicku(pozadovanaVec);
                return pozadovanaVec.getNazev() + "nejde rozebrat";
            }
        }
        return "Abys mohl něco rozebrat tak si věc musíš nejdříve vložit do inventáře";
    }

    @Override
    public String getNazev() {
        return null;
    }
}

package logika;

public class PrikazBatoh implements IPrikaz{
    private static final String NAZEV = "batoh";
    private HerniPlan plan;

    public PrikazBatoh(HerniPlan plan){
        this.plan = plan;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getKosicek().seznamVeci().isEmpty()){
           return "Batoh je prázdný!";
        }
        else {
            return plan.getKosicek().seznamVeci();
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

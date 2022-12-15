package logika;

public class PrikazRozeber implements IPrikaz{

    private static final String NAZEV = "rozeber";

    private HerniPlan plan;

    public PrikazRozeber(HerniPlan plan){
        this.plan = plan;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}

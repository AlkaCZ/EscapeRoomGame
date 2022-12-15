package logika;

public class PrikazOdemkni implements IPrikaz{

    private static final String NAZEV = "odemkni";

    private HerniPlan plan;

    public PrikazOdemkni(HerniPlan plan){
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

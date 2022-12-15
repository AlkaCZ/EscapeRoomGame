package logika;
// Příkaz pro použití vybrané věci z inventáře
public class PrikazPouzit implements IPrikaz{

    private static final String NAZEV = "pouzit";

    private HerniPlan plan;

    public PrikazPouzit(HerniPlan plan){
        this.plan = plan;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0){
            return "Musíš zadat co chceš položit!";
        }
        String nazevVeci = parametry[0];
        //Přidat ještě kontrolu toho jestli daná věc má vlastnost
        Vec v = plan.getKosicek().vyndejZKosiku(nazevVeci);
       if (plan.getKosicek().obsahujeVec(nazevVeci) && v.jePrenositelna()){
    //Použití speciální vlastnosti
           plan.getKosicek().vlozDoKosicku(v);
        }
       else {
           return "Věc není v inventáři";
       }


        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}

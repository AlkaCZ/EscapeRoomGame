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
            return "Musíš zadat co chceš použít!";
        }
        String nazevVeci = parametry[0];
  if (plan.getKosicek().obsahujeVec(nazevVeci)){
        Vec v = plan.getKosicek().vyndejZKosiku(nazevVeci);
        if (v.maSpecialniVlastnost()){
            switch (v.getNazev())
            {
                case "Baterka":
                    //Přidat kontrolu pokud už je rozsvíceno, možná prostě odebrat baterku
                    System.out.printf("Rozsvítil jsi " + v.getNazev());
                    if (plan.getAktualniProstor().getNazev() == "Osobní Pokoj"){
                        plan.getAktualniProstor().vlozVec(new Vec("Postel", false, false, true, false));
                        plan.getAktualniProstor().vlozVec(new Vec("Noční stolek", false, false, true, false));
                        System.out.printf("Rozsvítil jsi v celém pokoji a díky tomu ho konečně můžeš pořádně prohledat");

                    }
                case "Zapalovač":
                    System.out.printf("Rozsvítil jsi " + v.getNazev());
                    //Nastavení konce hry pokud jsi v Tajné

            }

        }
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

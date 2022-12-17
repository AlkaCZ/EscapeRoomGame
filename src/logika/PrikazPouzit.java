package logika;

// Příkaz pro použití vybrané věci z inventáře
public class PrikazPouzit implements IPrikaz{

    private static final String NAZEV = "použít";

    private HerniPlan plan;
    private IHra hra;


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
                    System.out.printf("Rozsvítil jsi " + v.getNazev() + ".  ");
                    if (plan.getAktualniProstor().obsahujeVec("Postel") && plan.getAktualniProstor().obsahujeVec("Noční stolek")){
                        return null;
                    }


                   else if (plan.getAktualniProstor().getNazev() == "Osobní_pokoj"){
                        plan.getAktualniProstor().vlozVec(new Vec("Postel", false, false, true, false));
                        plan.getAktualniProstor().vlozVec(new Vec("Noční_stolek", false, false, true, false));
                        System.out.printf("Rozsvítil jsi v celém pokoji a díky tomu ho konečně můžeš pořádně prohledat");

                    }
                   break;
                case "Zapalovač":
                    System.out.printf("Rozsvítil jsi " + v.getNazev());
                    //Nastavení konce hry pokud jsi v Tajné
                    if (plan.getAktualniProstor().getNazev() == "Skrytá_místnost"){
                        plan.setVyherniProstor(plan.getAktualniProstor());
                        System.out.printf( " a zničil jsi nebezpečnou zkoumanou látku");
                        System.out.printf( "  pro konec hry napiš  'Konec'");
                    }
                    break;

            }

        }
           plan.getKosicek().vlozDoKosicku(v);
        }
       else {
           return "Věc není v inventáři";
       }


        return "";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

package logika;
/**
 *  Třída PrikazOdemkni implementuje pro hru příkaz odemkni.
 *  Tato třída je součástí jednoduché textové hry.
 *  Tento příkaz přidává možnost ve hře odemikat předměty
 *
 */

public class PrikazOdemkni implements IPrikaz{

    private static final String NAZEV = "odemkni";

    private HerniPlan plan;

    public PrikazOdemkni(HerniPlan plan){
        this.plan = plan;
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0){
            return "Můžeš odemknout jen jednu věc najednou!";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniMistnost = plan.getAktualniProstor();
        Vec pozadovanaVec = aktualniMistnost.vratVec(nazevVeci);

        if (aktualniMistnost.obsahujeVec(nazevVeci)) {
            if (pozadovanaVec.jeZamcena()){
                switch (pozadovanaVec.getNazev()){
                    case "Šatník":
                        if (plan.getKosicek().obsahujeVec("Klíče_od_šatníku")) {
                            pozadovanaVec.Odemceni(false);
                            pozadovanaVec.setProhledatelna(true);
                            plan.getAktualniProstor().vlozVec(new Vec("Kabat", true, false, true, false));
                            System.out.printf("Odemkl jsi " + nazevVeci + " ale musíš ho ještě prohledat");
                        }
                        break;
                    case "Šuplík":
                        if (plan.getKosicek().obsahujeVec("Klíček_od_šuplíku"))
                        {
                            plan.getAktualniProstor().vratVec(nazevVeci).Odemceni(false);
                            plan.getAktualniProstor().vratVec(nazevVeci).setProhledatelna(true);
                            System.out.printf("Odemkl jsi " + nazevVeci + " ale musíš ho ještě prohledat");
                        }
                        break;
                    case "Zvláštní_dvířka":
                        if (plan.getKosicek().obsahujeVec("Zvláštní_kód")) {
                            plan.setTajnyVchod(plan.getAktualniProstor());
                            System.out.println("Odemkl jsi " + nazevVeci + " a našel jsi novou místnost");
                            System.out.println("Nová místnost: Skrytá_místnost" );
                        }
                        break;

                }

            }
            else {
                return nazevVeci + "je už otevřená, nebo nelze otevřít";
            }

        }
        return "";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

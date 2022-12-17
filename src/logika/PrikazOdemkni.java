package logika;

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
                        if (plan.getKosicek().obsahujeVec("Klíč_od_šatníku")) {
                            pozadovanaVec.Odemceni(false);
                            pozadovanaVec.setProhledatelna(true);
                            plan.getAktualniProstor().vlozVec(new Vec("Kabat", true, false, true, false));
                            System.out.printf("Odemkl jsi " + nazevVeci + " ale musíš ho ještě prohledat");
                        }
                        break;
                    case "Pracovní_stůl":
                        if (plan.getKosicek().obsahujeVec("Klíč_od_pracovního_stolu"))
                        {
                            plan.getAktualniProstor().vratVec(nazevVeci).Odemceni(false);
                            plan.getAktualniProstor().vratVec(nazevVeci).setProhledatelna(true);
                            System.out.printf("Odemkl jsi" + nazevVeci + " ale musíš ho ještě prohledat");
                        }
                        break;
                    case "Zvláštní_dvířka":
                        if (plan.getKosicek().obsahujeVec("Tajný_kód")) {
                            plan.setAktualniProstor(new Prostor("Skrytá_místnost", "co se zde asi skrývá ?"));
                            plan.getAktualniProstor().vlozVec(new Vec("Truhla",false,false,true,false));
                            //Vypsat Itemy a podobné
                            //aktualniMistnost.setVychod(plan.getVyherniProstor());// Až po použití doutníku
                            System.out.printf("Odemkl jsi " + nazevVeci + " a našel jsi novou místnost, do které jsi ihned vešel");
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

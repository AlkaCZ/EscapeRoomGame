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
        Vec pozadovanaVec = aktualniMistnost.vyberVec(nazevVeci);

        if (aktualniMistnost.obsahujeVec(nazevVeci)) {
            if (pozadovanaVec.jeZamcena()){
                switch (pozadovanaVec.getNazev()){
                    case "Šatník":
                        if (plan.getKosicek().obsahujeVec("Klíč_od_šatníku")) {
                            plan.getAktualniProstor().vyberVec(nazevVeci).Odemceni();
                            plan.getAktualniProstor().vlozVec(new Vec("Kabat", true, false, true, false));
                            System.out.printf("Odemkl jsi" + nazevVeci);
                        }
                        break;
                    case "Pracovní_stůl":
                        if (plan.getKosicek().obsahujeVec("Klíč_od_pracovního_stolu")) {
                            plan.getAktualniProstor().vyberVec(nazevVeci).Odemceni();
                            plan.getAktualniProstor().vlozVec(new Vec("Popis nebezpečné látky", true, false, false, false));
                            System.out.printf("Odemkl jsi" + nazevVeci);
                        }
                        break;
                    case "Zvláštní_dvířka":
                        if (plan.getKosicek().obsahujeVec("Tajný_kód")) {
                            plan.getAktualniProstor().vyberVec(nazevVeci).Odemceni();
                            plan.setVyherniProstor(new Prostor("Skrytá_místnost", "co se zde asi skrývá ?"));
                            plan.getVyherniProstor().vlozVec(new Vec("Truhla",false,false,true,false));
                            aktualniMistnost.setVychod(plan.getVyherniProstor());// Až po použití doutníku
                            System.out.printf("Odemkl jsi" + nazevVeci + " a našel jsi novou místnost");
                        }
                        break;

                }

            }
            else {
                return nazevVeci + "je už otevřená, nebo nelze otevřít";
            }

        }
        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}

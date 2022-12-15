package logika;

public class PrikazProhledat implements IPrikaz{
    private static final String NAZEV = "prohledat";
    private HerniPlan plan;

    public PrikazProhledat(HerniPlan plan){
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length == 0){
            return "Můžeš prohledat jen jednu věc najednou!";
        }
        String nazevVeci = parametry[0];
        Prostor aktualniMistnost = plan.getAktualniProstor();

        if (aktualniMistnost.obsahujeVec(nazevVeci)) {
            Vec pozadovanaVec = aktualniMistnost.vyberVec(nazevVeci);
            if (pozadovanaVec.jeProhledatelna() && !pozadovanaVec.jeZamcena()) {

                switch (pozadovanaVec.getNazev()){
                    case "Šatník":
                        //otevření šatníku
                        break;
                    case "Stolek":
                        //otevření stolku
                        break;
                    case "Kabát":
                        //otevření šatníku
                        break;
                    case "Pracovní stůl":
                        //otevření šatníku
                        break;
                    case "Stojan":
                        //otevření šatníku
                        break;
                    case "Skříň":
                        //otevření šatníku
                        break;
                    case "Řídící_deska":
                        //otevření šatníku
                        break;
                    case "Zvláštní_dvířka":
                        //otevření šatníku
                        break;
                    case "Postel":
                        //otevření šatníku
                        break;
                    case "Noční_stolek":
                        //otevření šatníku
                        break;


                }
                return "prohledal jsi" + nazevVeci;// přesunout do CASU

            }
            if (pozadovanaVec.jeProhledatelna() && pozadovanaVec.jeZamcena()){
                return nazevVeci + "nelze prohledat, protože je zamčený";
            }

            }

        return nazevVeci + "nejde prohledat, nic tam není";
    }

    @Override
    public String getNazev() {
        return null;
    }
}

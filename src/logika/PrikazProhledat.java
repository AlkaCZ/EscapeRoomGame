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
            Vec pozadovanaVec = aktualniMistnost.vratVec(nazevVeci);
            if (pozadovanaVec.jeProhledatelna() && !pozadovanaVec.jeZamcena()) {

                switch (pozadovanaVec.getNazev()){
                    case "Šatník":
                        //otevření šatníku
                        plan.getAktualniProstor().vlozVec(new Vec("Kabát", true,false,true,false));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi šatník a našel jsi v něm kabát");
                        break;
                    case "Stolek":
                        plan.getAktualniProstor().vlozVec(new Vec("Doutník_se_zapalovačem", true,true,false,false, true));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi stolek a našel jsi v něm set doutníku se zapalovačem");
                        //Podle potřeby přidat hint
                        break;
                    case "Kabát":
                        plan.getAktualniProstor().vlozVec(new Vec("Tajný_kód", true,false,false,false));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi kabát a našel jsi v něm nějaký kód.");
                        break;
                    case "Pracovní stůl":
                        plan.getAktualniProstor().vlozVec(new Vec("Popis_tajné_látky", true,false,false,false));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi pracovní stůl a našel jsi v něm popis oné tajné látky.");
                        break;
                    case "Stojan":
                        System.out.printf("Prohledal jsi stojan ale nic jsi tam nenašel.");
                        break;
                    case "Skříň":
                        System.out.printf("Prohledal jsi skříň ale nic jsi tam nenašel.");
                        break;
                    case "Řídící_deska":
                        plan.getAktualniProstor().vlozVec(new Vec("Klíč_od_pracovního_stolu", true,false,false,false));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi řídící desku a našel jsi v ní klíč, nejspíše od pracovního stolu z laboratoře.");
                        break;

                    case "Postel":
                        System.out.printf("Prohledal jsi postel a zjistil jsi že to je opravdu velmi pohodlná postel.");
                        break;
                    case "Noční_stolek":
                        plan.getAktualniProstor().vlozVec(new Vec("Klíč_od_šatníku", true,false,false,false));
                        pozadovanaVec.setProhledatelna(false);
                        System.out.printf("Prohledal jsi noční stolek a našel jsi nějaké malé klíčky, nejspíše od šatníku.");
                        break;


                }

            }
            if (pozadovanaVec.jeProhledatelna() && pozadovanaVec.jeZamcena()){
                return nazevVeci + " nelze prohledat, protože je zamčený.";
            }

            }
     return "";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

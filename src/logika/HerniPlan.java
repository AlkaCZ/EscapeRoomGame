package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Prostor vyherniProstor;

    private Kosicek kosicek;
    

    public HerniPlan() {
        kosicek = new Kosicek(7);
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví predsin.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor predsin = new Prostor("Předsíň", "předsíň, první místnost do které jsi se dostal");
        Prostor chodba = new Prostor("Chodba", "chodba se šatníkem a s mnoha východy do dalších částí laboratoře");
        Prostor laborator = new Prostor("Laboratoř", "Laboratoř ve které se provádí pokusy a výzkum");
        Prostor ridiciMistnost = new Prostor("Řídící_místnost", "Hlavní místnost s velkým pracovním stolem");
        Prostor osobniPokoj = new Prostor("Osobní_pokoj", "každý musí někde odpočívat, možná tady výzkumníci něco zapoměli");
        //Prostor skrytaMistnost = new Prostor("Skrytá_místnost", "co se zde asi skrývá ?");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        predsin.setVychod(chodba);
        chodba.setVychod(ridiciMistnost);
        chodba.setVychod(laborator);
        chodba.setVychod(predsin);
        laborator.setVychod(chodba);
        ridiciMistnost.setVychod(chodba);
        ridiciMistnost.setVychod(osobniPokoj);
        //ridiciMistnost.setVychod(skrytaMistnost);
        osobniPokoj.setVychod(ridiciMistnost);
        //skrytaMistnost.setVychod(ridiciMistnost); //Asi není ani potřeba

        //Vytvoření Předmětů

        //Předsíň
        Vec baterka = new Vec("Baterka", true, true, false, false);
        predsin.vlozVec(baterka);
        //TEST
        Vec TEST = new Vec("Tajný_kód", true,false,false,false);
        Vec Test2 = new Vec("Zapalovač",true, true, false, false);
        predsin.vlozVec(TEST);
        predsin.vlozVec(Test2);
        //TEST
        //Chodba
        Vec stolek = new Vec("Stolek", false, false, true, false);
        Vec satnik = new Vec("Šatník", false, false, true, true);
        chodba.vlozVec(stolek);
        chodba.vlozVec(satnik);

        //Laboratoř
        Vec pracovniStul = new Vec("Pracovní_stůl", false, false, true, false);
        Vec stojan = new Vec("Stojan", false, false, true, false);
        laborator.vlozVec(pracovniStul);
        laborator.vlozVec(stojan);

        //Řídící místnost
        Vec skrin = new Vec("Skříň", false, false, true, true);
        Vec zvlastniDvirka = new Vec("Zvláštní_dvířka", false, false, true, true);
        Vec ridiciDeska = new Vec("Řídící_deska", false, false, true, false);
        ridiciMistnost.vlozVec(skrin);
        ridiciMistnost.vlozVec(zvlastniDvirka);
        ridiciMistnost.vlozVec(ridiciDeska);

        //Osobní pokoj
        // Vše se vloží až po rozsvícení baterky
        //Skrytá místnost
       // Vec truhla = new Vec("Truhla", false, false, true, true);
        //skrytaMistnost.vlozVec(truhla);



/**
        Vec hamburger = new Vec("hamburger",true);
        sousedniDomecek.vlozVec(hamburger);
        sousedniDomecek.vlozVec(new Vec("stul",false));
 */
        aktualniProstor = predsin;  // hra začíná v peředsíňi
        vyherniProstor = null;

    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    public void setVyherniProstor(Prostor vyherniProstor) {
        this.vyherniProstor = vyherniProstor;
    }




    public Prostor getVyherniProstor() {
        return vyherniProstor;
    }

    public Kosicek getKosicek(){return  kosicek;}




}

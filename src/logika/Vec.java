package logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;

    private boolean specialniVlastnost;

    private boolean prohledatelna;

    private boolean zamcena;

    private boolean rozebiratelna;




    /**
     * Vytvoření věci se zadaným názvem
     *
     * @param nazev        Jméno věci, jednoznačný identifikátor,
     *                     pokud možno jedno slovo
     * @param prenositelna Parametr určuje, zda je věc
     *                     přenositelná hráčem
     */
    public Vec(String nazev, boolean prenositelna, boolean specialniVlastnost, boolean prohledatelna, boolean zamcena) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.specialniVlastnost = specialniVlastnost;
        this.prohledatelna = prohledatelna;
        this.zamcena = zamcena;
    }
    public Vec(String nazev, boolean prenositelna, boolean specialniVlastnost, boolean prohledatelna, boolean zamcena, boolean rozebiratelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.specialniVlastnost = specialniVlastnost;
        this.prohledatelna = prohledatelna;
        this.zamcena = zamcena;
        this.rozebiratelna = rozebiratelna;
    }

    /**
     * Vrací název věci.
     *
     * @return název věci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací informaci o tom, zda je věc přenositelná ve hře.
     *
     * @return true, pokud je věc přenositelná, jinak false
     */
    public boolean jePrenositelna() {
        return prenositelna;
    }
    public boolean maSpecialniVlastnost() {
        return specialniVlastnost;
    }
    public boolean jeProhledatelna() {
        return prohledatelna;
    }

    public boolean jeZamcena() { return zamcena; }



    public boolean jeRozebiratelna(){return rozebiratelna;}

    public boolean Odemceni(boolean nepravda){
       return this.zamcena = nepravda;
    }

    public boolean setProhledatelna(boolean pravda){
       return this.prohledatelna = pravda;
    }



}

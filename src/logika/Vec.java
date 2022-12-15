package logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;

    private boolean specialniVlastnost;

    private boolean prohledatelna;

    private boolean zamcena;




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


}

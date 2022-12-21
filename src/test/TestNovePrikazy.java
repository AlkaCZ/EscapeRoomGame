import logika.HerniPlan;
import logika.Hra;
import logika.Postava;
import logika.Prostor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testy které prověřují nově přidané příkazy
 */
public class TestNovePrikazy {
    /**
     Vytvoření instance planu, holder
     */
    private HerniPlan plan;
    /**
     Vytvoření instance hry, holder
     */
    private Hra hra;


    /**
     * Setup před zahájením testů
     */
    @BeforeEach
    public void setUp() {
        plan = new HerniPlan();
        hra = new Hra();

    }
    /**
     * Test který kontroluje správné fungování a vkládání postavy
    */
    @Test
    void testPostava() {
        Prostor prostor1 = new Prostor("p1", "p1 - Start");
        Prostor prostor2 = new Prostor("p2", "p1 - místnost 1");
        Prostor prostor3 = new Prostor("p3", "p3 - místnost 2");
        Postava pepa = new Postava("Pepa","ahoj");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        prostor3.setVychod(prostor2);
        prostor3.vlozPostavu(pepa);
        assertEquals(null, prostor3.vratSousedniProstor("p1"));
        assertEquals(null,prostor2.vratPostavu("Pepa"));
        assertEquals(pepa,prostor3.vratPostavu("Pepa"));
        assertEquals("ahoj",prostor3.vratPostavu("Pepa").getInterakce());


    }
    /**
     * Test který kontroluje správné fungování metody na pro zobrazení a nastavení stavu hádanky
     */
    @Test
    void testHadanka() {
       assertEquals(false, hra.getHadankaInProgress());
       assertEquals(true, hra.setHadanka(true));
       assertEquals(false, hra.setHadanka(false));

    }
}
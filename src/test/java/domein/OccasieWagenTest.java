package domein;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OccasieWagenTest {

    private static final String GELDIG_MERK = "Abcde";
    private static final double GELDIGE_KILOMETERSTAND = 12345.6;
    private static final int GELDIG_AANTAL_DEUREN = 4;

    private static final double ONDERGRENS_KILOMETERSTAND_EXCL = 0.0;
    private static final double BOVENGRENS_KILOMETERSTAND_INCL = 200000.0;
    private static final int GRENSWAARDE_AANTAL_DEUREN_INCL = 2;

    @Test
    public void maakOccasieWagen_GeldigGeval_maaktOccasieWagen() {
        OccasieWagen o = new OccasieWagen(GELDIG_MERK, GELDIGE_KILOMETERSTAND, GELDIG_AANTAL_DEUREN);

        assertEquals(GELDIG_MERK, o.getMerk());
        assertEquals(GELDIGE_KILOMETERSTAND, o.getKilometerstand(), 0.1);
        assertEquals(GELDIG_AANTAL_DEUREN, o.getAantalDeuren());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings= {"  \t \r ", "A", "Ab"})
    public void maakOccasieWagen_OngeldigMerk_maaktOccasieWagen(String ongeldigMerk) {
        assertThrows(IllegalArgumentException.class,
                ()-> new OccasieWagen(ongeldigMerk, GELDIGE_KILOMETERSTAND, GELDIG_AANTAL_DEUREN));
    }

    @Test
    public void maakOccasieWagen_LengteMerkNetGrootGenoeg_maaktOccasieWagen() {
        OccasieWagen o = new OccasieWagen("Abc", GELDIGE_KILOMETERSTAND, GELDIG_AANTAL_DEUREN);

        assertEquals("Abc", o.getMerk());
        assertEquals(GELDIGE_KILOMETERSTAND, o.getKilometerstand(), 0.1);
        assertEquals(GELDIG_AANTAL_DEUREN, o.getAantalDeuren());
    }

    @ParameterizedTest
    @ValueSource(doubles= {-20.3, ONDERGRENS_KILOMETERSTAND_EXCL, BOVENGRENS_KILOMETERSTAND_INCL + 0.1, 312345.6})
    public void maakOccasieWagen_OngeldigeKilometerstand_maaktOccasieWagen(double ongeldigeKilometerstand) {
        assertThrows(IllegalArgumentException.class,
                ()-> new OccasieWagen(GELDIG_MERK, ongeldigeKilometerstand, GELDIG_AANTAL_DEUREN));
    }

    @ParameterizedTest
    @ValueSource(doubles= {ONDERGRENS_KILOMETERSTAND_EXCL + 0.1, BOVENGRENS_KILOMETERSTAND_INCL})
    public void maakOccasieWagen_GeldigeGrenswaardeKilometerstand_maaktOccasieWagen(double grensKilometerstand) {
        OccasieWagen o = new OccasieWagen(GELDIG_MERK, grensKilometerstand, GELDIG_AANTAL_DEUREN);

        assertEquals(GELDIG_MERK, o.getMerk());
        assertEquals(grensKilometerstand, o.getKilometerstand(), 0.1);
        assertEquals(GELDIG_AANTAL_DEUREN, o.getAantalDeuren());
    }

    @ParameterizedTest
    @ValueSource(ints= {-2, GRENSWAARDE_AANTAL_DEUREN_INCL-1})
    public void maakOccasieWagen_OngeldigAantalDeuren_maaktOccasieWagen(int ongeldigAantalDeuren) {
        assertThrows(IllegalArgumentException.class,
                ()-> new OccasieWagen(GELDIG_MERK, GELDIGE_KILOMETERSTAND, ongeldigAantalDeuren));
    }

    @Test
    public void maakOccasieWagen_AantalDeurenNetGrootGenoeg_maaktOccasieWagen() {
        OccasieWagen o = new OccasieWagen(GELDIG_MERK, GELDIGE_KILOMETERSTAND, GRENSWAARDE_AANTAL_DEUREN_INCL);

        assertEquals(GELDIG_MERK, o.getMerk());
        assertEquals(GELDIGE_KILOMETERSTAND, o.getKilometerstand(), 0.1);
        assertEquals(GRENSWAARDE_AANTAL_DEUREN_INCL, o.getAantalDeuren());
    }
}

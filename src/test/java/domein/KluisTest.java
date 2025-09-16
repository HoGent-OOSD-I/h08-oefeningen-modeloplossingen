package domein;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class KluisTest {
    @Test
    void maakKluis_GeenCode_WerptException() {
        // arrange
        String ongeldigeCode = null;
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeIsTeKort_WerptException() {
        // arrange
        String ongeldigeCode = "1";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeIsNetTeKort_WerptException() {
        // arrange
        String ongeldigeCode = "123";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeIsTeLang_WerptException() {
        // arrange
        String ongeldigeCode = "1234567";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeIsNetTeLang_WerptException() {
        // arrange
        String ongeldigeCode = "12345";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeBevatEenTekenDatGeenCijferIs_WerptException() {
        // arrange
        String ongeldigeCode = "12A3";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeBestaatUit4GelijkeCijfers_WerptException() {
        // arrange
        String ongeldigeCode = "3333";
        // act && assert
        assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
    }

    @Test
    void maakKluis_CodeBestaatUitCijfers_MaaktKluis() {
        // arrange
        String geldigeCode = "1258";
        // act & assert
        assertDoesNotThrow(() -> new Kluis(geldigeCode));
    }

    @Test
    void maakKluis_CodeBestaatUitNetGeen4GelijkeCijfers_MaaktKluis() {
        // arrange
        String geldigeCode = "3133";
        // act & assert
        assertDoesNotThrow(() -> new Kluis(geldigeCode));
    }

    @Test
    void valideer_CodesKomenOvereen_RetourneertTrue() {
        // arrange
        String geldigeCode = "1285";
        Kluis kluis = new Kluis(geldigeCode);
        // act
        boolean resultaat = kluis.valideerCode(geldigeCode);
        // assert
        assertTrue(resultaat);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1222", "1286"})
    void valideer_CodesVerschillen_RetourneertFalse(String code) {
        // arrange
        String geldigeCode = "1285";
        Kluis kluis = new Kluis(geldigeCode);
        // act
        boolean resultaat = kluis.valideerCode(code);
        // assert
        assertFalse(resultaat);
    }

// REFACTORING

//    @ParameterizedTest
//    @NullSource // geen code
//    @ValueSource(strings = {"1", // te kort
//            "123", // net te kort
//            "1234567", // te lang
//            "12345", // net te lang
//            "12A4", // bevat teken dat geen cijfer is
//            "3333" // bevat 4 dezelfde cijfers
//    })
//    void maakKluis_OngeldigeCode_WerptException(String code) {
//        assertThrows(IllegalArgumentException.class, () -> new Kluis(code));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1258", "3133"})
//    void maakKluis_CodeGeldig_MaaktKluis(String code) {
//
//        assertDoesNotThrow(() -> new Kluis(code));
//    }
}

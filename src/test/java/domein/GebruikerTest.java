package domein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.domein.Gebruiker;

public class GebruikerTest {

	@ParameterizedTest
	@ValueSource(strings = { "abc.de", "a.bc..de", "a.bcde", "abcd.e" })
	void maakGebruiker_GeldigeGebruikersnaam_MaaktGebruiker(String naam) {
		assertEquals(naam, new Gebruiker(naam).getGebruikersnaam());
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { "a.b", "abc.d", "abcdefg", ".ab.cd", "ab.cd.", "a. bcd", "a. b c " })
	void maakGebruiker_OngeldigeGebruikersnaam_WerptException(String naam) {
		assertThrows(IllegalArgumentException.class, () -> new Gebruiker(naam));
	}
}

package domein;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ZichtrekeningTest {

	private Zichtrekening rekening;

	@BeforeEach
	void beforeEach() {
		rekening = new Zichtrekening();
	}

	@Test
	void maakZichtrekening_MaaktZichtrekeningMetSaldoNul() {
		Assertions.assertEquals(BigDecimal.ZERO, rekening.getSaldo());
	}

	@Test
	void stort_PositiefBedrag_VermeerdertHetSaldo() {
		rekening.stort(BigDecimal.valueOf(10));
		BigDecimal bedrag = BigDecimal.valueOf(22.5);
		rekening.stort(bedrag);
		Assertions.assertEquals(BigDecimal.valueOf(32.5), rekening.getSaldo());
	}

	@Test
	void stort_BedragNetGrootGenoeg_VermeerdertHetSaldo() {
		rekening.stort(BigDecimal.valueOf(10));
		BigDecimal bedrag = BigDecimal.valueOf(0.05);
		rekening.stort(bedrag);
		Assertions.assertEquals(BigDecimal.valueOf(10.05), rekening.getSaldo());
	}

	@Test
	void stort_BedragNetTeKlein_WerptException() {
		rekening.stort(BigDecimal.valueOf(10));
		Assertions.assertThrows(IllegalArgumentException.class, () -> rekening.stort(BigDecimal.valueOf(0.04)));
	}

	@Test
	void stort_BedragTeKlein_WerptException() {
		rekening.stort(BigDecimal.valueOf(10));
		Assertions.assertThrows(IllegalArgumentException.class, () -> rekening.stort(BigDecimal.valueOf(-10.55)));
	}

	@Test
	void stort_BedragNull_WerptException() {
		rekening.stort(BigDecimal.valueOf(10));
		assertThrows(IllegalArgumentException.class, () -> rekening.stort(null));
	}


// Met Geparameterizeerde Testen

//	private Zichtrekening rekening;
//
//	@BeforeEach
//	void beforeEach() {
//		rekening = new Zichtrekening();
//	}
//
//	@Test
//	void maakZichtrekening_MaaktZichtrekeningMetSaldoNul() {
//		Assertions.assertEquals(BigDecimal.ZERO, rekening.getSaldo());
//	}
//
//	@Test
//	void stort_PositiefBedrag_VermeerdertHetSaldo() {
//		rekening.stort(BigDecimal.valueOf(10));
//		BigDecimal bedrag = BigDecimal.valueOf(22.5);
//		rekening.stort(bedrag);
//		Assertions.assertEquals(BigDecimal.valueOf(32.5), rekening.getSaldo());
//	}
//
//	@Test
//	void stort_BedragNetGrootGenoeg_VermeerdertHetSaldo() {
//		rekening.stort(BigDecimal.valueOf(10));
//		BigDecimal bedrag = BigDecimal.valueOf(0.05);
//		rekening.stort(bedrag);
//		Assertions.assertEquals(BigDecimal.valueOf(10.05), rekening.getSaldo());
//	}
//
//	@ParameterizedTest
//	@ValueSource(doubles = { 0.04, -10.55 })
//	void stort_BedragTeKlein_WerptException(double bedrag) {
//		rekening.stort(BigDecimal.valueOf(10));
//		Assertions.assertThrows(IllegalArgumentException.class, () -> rekening.stort(BigDecimal.valueOf(bedrag)));
//	}
//
//	@Test
//	void stort_BedragNull_WerptException() {
//		rekening.stort(BigDecimal.valueOf(10));
//		assertThrows(IllegalArgumentException.class, () -> rekening.stort(null));
//	}

}

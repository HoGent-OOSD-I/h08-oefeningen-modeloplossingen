package domein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WaterflesTest {

	@Test
	void maakWaterfles_GeldigeCapaciteit_MaaktWaterfles() {
		// Arrange
		int capaciteit = 250;
		// Act
		Waterfles waterfles = new Waterfles(capaciteit);
		// Assert
		assertEquals(250, waterfles.getCapaciteit());
		assertEquals(0, waterfles.getInhoud());
	}

	@Test
	void maakWaterfles_GeldigeCapaciteitGrootstMogelijk_MaaktWaterfles() {
		// Arrange
		int capaciteit = 2000;
		// Act
		Waterfles waterfles = new Waterfles(capaciteit);
		// Assert
		assertEquals(capaciteit, waterfles.getCapaciteit());
		assertEquals(0, waterfles.getInhoud());
	}

	@Test
	void maakWaterfles_GeldigeCapaciteitKleinstMogelijk_MaaktWaterfles() {
		// Arrange
		int capaciteit = 100;
		// Act
		Waterfles waterfles = new Waterfles(capaciteit);
		// Assert
		assertEquals(capaciteit, waterfles.getCapaciteit());
		assertEquals(0, waterfles.getInhoud());
	}

	@Test
	void maakWaterfles_CapaciteitNetTeGroot_WerptException() {
		// Arrange
		int capaciteit = 2001;
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
	}

	@Test
	void maakWaterfles_CapaciteitTeGroot_WerptException() {
		// Arrange
		int capaciteit = 2500;
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
	}

	@Test
	void maakWaterfles_CapaciteitNetTeKlein_WerptException() {
		// Arrange
		int capaciteit = 99;
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
	}

	@Test
	void maakWaterfles_CapaciteitTeKlein_WerptException() {
		// Arrange
		int capaciteit = 25;
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
	}

	@Test
	void vulBij_HoeveelheidWaterDoetFlesNietOverlopen_VermeerderdInhoudVanFles() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 100;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act && Asserts
		waterfles.vulBij(hoeveelheidWater);
		assertEquals(150, waterfles.getInhoud());
	}

	@Test
	void vulBij_HoeveelheidWaterDoetFlesNetNietOverlopen_VermeerderdInhoudVanFles() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 200;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act
		waterfles.vulBij(hoeveelheidWater);
		// Assert
		assertEquals(capaciteit, waterfles.getInhoud());
	}

	@Test
	void vulBij_HoeveelheidWaterDoetFlesOverlopen_VermeerderdInhoudVanFlesTotZijnCapaciteit() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 500;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act
		waterfles.vulBij(hoeveelheidWater);
		// Assert
		assertEquals(capaciteit, waterfles.getInhoud());
	}

	@Test
	void vulBij_HoeveelheidWaterDoetFlesNetOverlopen_VermeerderdInhoudVanFlesTotZijnCapaciteit() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 201;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act
		waterfles.vulBij(hoeveelheidWater);
		// Assert
		assertEquals(capaciteit, waterfles.getInhoud());
	}

	@Test
	void vulBij_HoeveelheidWaterIsKleinstMogelijk_VermeerderdInhoudVanFles() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 1;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act
		waterfles.vulBij(hoeveelheidWater);
		// Assert
		assertEquals(51, waterfles.getInhoud());
	}

	@Test
	void vulBij_HoeveelheidWaterIsNul_WerptException() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = 0;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> waterfles.vulBij(hoeveelheidWater));
	}

	@Test
	void vulBij_HoeveelheidWaterIsNegatief_WerptException() {
		// Arrange
		int capaciteit = 250;
		int hoeveelheidWater = -150;
		Waterfles waterfles = new Waterfles(capaciteit);
		waterfles.vulBij(50);
		// Act en Assert
		assertThrows(IllegalArgumentException.class, () -> waterfles.vulBij(hoeveelheidWater));
	}

// REFACTORING

//	private final static int MAX_CAPACITEIT = 2000;
//	private final static int MIN_CAPACITEIT = 100;
//	private final static int CAPACITEIT = 250;
//	private Waterfles waterfles;
//
//	@BeforeEach
//	void maakWaterfles() {
//		waterfles = new Waterfles(CAPACITEIT);
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = { MIN_CAPACITEIT, 250, MAX_CAPACITEIT })
//	void maakWaterfles_GeldigeCapaciteit_MaaktWaterfles(int capaciteit) {
//		Waterfles waterfles = new Waterfles(capaciteit);
//		assertEquals(capaciteit, waterfles.getCapaciteit());
//		assertEquals(0, waterfles.getInhoud());
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = { 25, MIN_CAPACITEIT - 1, MAX_CAPACITEIT + 1, 2500 })
//	void maakWaterfles_OngeldigeCapaciteit_WerptException(int capaciteit) {
//		assertThrows(IllegalArgumentException.class, () -> new Waterfles(capaciteit));
//	}
//
//	@Test
//	void vulBij_HoeveelheidWaterDoetFlesNietOverlopen_VermeerderdInhoudVanFles() {
//		// Arrange
//		int hoeveelheidWater = 100;
//		waterfles.vulBij(50);
//		// Act
//		waterfles.vulBij(hoeveelheidWater);
//		// Assert
//		assertEquals(150, waterfles.getInhoud());
//	}
//
//	@Test
//	void vulBij_HoeveelheidWaterDoetFlesNetNietOverlopen_VermeerderdInhoudVanFles() {
//		// Arrange
//		int hoeveelheidWater = 200;
//		waterfles.vulBij(50);
//		// Act
//		waterfles.vulBij(hoeveelheidWater);
//		// Assert
//		assertEquals(CAPACITEIT, waterfles.getInhoud());
//	}
//
//	@Test
//	void vulBij_HoeveelheidWaterIsKleinstMogelijk_VermeerderdInhoudVanFles() {
//		// Arrange
//		int hoeveelheidWater = 1;
//		waterfles.vulBij(50);
//		// Act
//		waterfles.vulBij(hoeveelheidWater);
//		// Assert
//		assertEquals(51, waterfles.getInhoud());
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = { 201, 500 })
//	void vulBij_HoeveelheidWaterDoetFlesOverlopen_VermeerderdInhoudVanFlesTotZijnCapaciteit(int hoeveelheidWater) {
//		waterfles.vulBij(50);
//		waterfles.vulBij(hoeveelheidWater);
//		assertEquals(CAPACITEIT, waterfles.getInhoud());
//	}
//
//	@ParameterizedTest
//	@ValueSource(ints = { -150, 0 })
//	void vulBij_HoeveelheidWaterIsNietStriktPositief_WerptException(int hoeveelheidWater) {
//		assertThrows(IllegalArgumentException.class, () -> waterfles.vulBij(hoeveelheidWater));
//	}

}

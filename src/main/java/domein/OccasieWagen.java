package domein;

public class OccasieWagen {

    private final String merk;
    private double kilometerstand;
    private final int aantalDeuren;

    private static final int MIN_LENGTE_MERK = 3;
    private static final int MIN_AANTALDEUREN = 2;
    private static final int MAX_AANTALDEUREN = 4;
    private static final double MIN_KILOMETERSTAND = 0.0;
    private static final double MAX_KILOMETERSTAND = 200000.0;

    public OccasieWagen(String merk, double kilometerstand, int aantalDeuren) {
        controleerMerk(merk);
        controleerAantalDeuren(aantalDeuren);
        setKilometerstand(kilometerstand);
        this.merk = merk;
        this.aantalDeuren = aantalDeuren;
    }

    private void controleerAantalDeuren(int aantalDeuren) {
        if (aantalDeuren < MIN_AANTALDEUREN || aantalDeuren > MAX_AANTALDEUREN)
            throw new IllegalArgumentException(String.format("Aantal deuren moet minstens %d en maximaal %d zijn", MIN_AANTALDEUREN, MAX_AANTALDEUREN));
    }

    private void controleerMerk(String merk) {
        if (merk == null || merk.isBlank() || merk.trim().length() < MIN_LENGTE_MERK)
            throw new IllegalArgumentException(
                    String.format("Merk moet ingevuld zijn en minimaal %d tekens bevatten", MIN_LENGTE_MERK));
    }


    //Afspraak: foutboodschap met 1 cijfer na de komma afbeelden
    public final void setKilometerstand(double kilometerstand) {
        if (kilometerstand < MIN_KILOMETERSTAND || kilometerstand > MAX_KILOMETERSTAND)
            throw new IllegalArgumentException(String.format("De kilometerstand moet tussen %.1f en %.1f liggen",
                    MIN_KILOMETERSTAND, MAX_KILOMETERSTAND));

        this.kilometerstand = kilometerstand;
    }

    public double getKilometerstand() {
        return kilometerstand;
    }

    public String getMerk() {
        return merk;
    }

    public int getAantalDeuren() {
        return aantalDeuren;
    }


}

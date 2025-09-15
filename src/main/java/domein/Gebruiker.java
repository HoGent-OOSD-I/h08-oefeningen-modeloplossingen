package main.java.domein;

public class Gebruiker {
	private String gebruikersnaam;

	/**
	 * Class constructor. <br>
	 * - de gebruikersnaam moet minstens 6 tekens bevatten <br>
	 * - de gebruikersnaam moet minstens 1 punt bevatten <br>
	 * - de gebruikersnaam mag niet beginnnen of eindigen met een punt <br>
	 * - de gebruikersnaam mag geen spaties bevatten
	 * 
	 * @param gebruikersnaam de <code>String</code> met de gebruikersnaam voor de
	 *                       nieuwe <code>Gebruiker</code>
	 * @throws <code>IllegalArgumentException</code> wanneer de gebruikersnaam niet
	 * voldoet
	 */
	public Gebruiker(String gebruikersnaam) {
		setGebruikersnaam(gebruikersnaam);
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	private void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam == null)
			throw new IllegalArgumentException("Je moet een gebruikersnaam opgeven");
		if (gebruikersnaam.length() < 6)
			throw new IllegalArgumentException("De naam moet minstens 6 tekens bevatten");
		int indexPunt = gebruikersnaam.indexOf('.');
		if (indexPunt == -1)
			throw new IllegalArgumentException("De naam moet minstens een punt bevatten");
		if (indexPunt == 0 || gebruikersnaam.lastIndexOf('.') == gebruikersnaam.length() - 1)
			throw new IllegalArgumentException("De gebruikersnaam mag niet beginnnen of eindigen met een punt");
		if (gebruikersnaam.indexOf(' ') != -1)
			throw new IllegalArgumentException("De naam mag geen spaties bevatten");
		this.gebruikersnaam = gebruikersnaam;
	}

}

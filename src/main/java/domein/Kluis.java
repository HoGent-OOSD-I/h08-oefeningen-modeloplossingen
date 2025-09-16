package domein;

public class Kluis {
	private final String code;

	/**
	 * Class constructor. Maakt een nieuwe kluis met de opgegeven code.<br>
	 * 
	 * - De code moet uit exact 4 tekens bestaan. <br>
	 * - De code mag enkel cijfers bevatten. <br>
	 * - De code mag niet allemaal gelijke tekens bevatten.
	 * 
	 * @param code de <code>String</code> die de code voor de kluis bevat
	 * @throws IllegalArgumentException voor een ongeldige code
	 * 
	 */
	public Kluis(String code) {
		controleerCode(code);
		this.code = code;
	}

	private void controleerCode(String code) {
		if (code == null)
			throw new IllegalArgumentException("Je moet een code opgeven");
		if (code.length() != 4)
			throw new IllegalArgumentException("De code moet exact 4 cijfers lang zijn");
		boolean allemaalCijfers = true;
		for (int i = 0; i < 4; i++)
			allemaalCijfers = allemaalCijfers && code.charAt(i) >= '0' && code.charAt(i) <= '9';
		if (!allemaalCijfers)
			throw new IllegalArgumentException("De code mag enkel cijfers bevatten");
		if (code.charAt(0) == code.charAt(1) && code.charAt(1) == code.charAt(2) && code.charAt(2) == code.charAt(3))
			throw new IllegalArgumentException("De code mag niet uit 4 gelijke cijfers bestaan");
	}

	public boolean valideerCode(String code) {
		return this.code.equals(code);
	}

}

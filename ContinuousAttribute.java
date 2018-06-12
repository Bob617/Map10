
public class ContinuousAttribute extends Attribute { // modella un attributo continuo (numerico). Tale classe include i
														// metodi per la “normalizzazione” del dominio dell'attributo
														// nell'intervallo [0,1] al fine da rendere confrontabili
														// attributi aventi domini diversi
	private double max;
	private double min; // rappresentano gli estremi dell'intervallo di valori (dominio) che l'attributo
						// può reamente assumere.

	ContinuousAttribute(String name, int index, double min, double max) { // Invoca il costruttore della classe madre e
																			// inizializza i membri aggiunti per
																			// estensione
		super(name, index);
		this.max = max;
		this.min = min;
	}

	double getScaledValue(double v) { // Calcola e restituisce il valore normalizzato del parametro passato in input.
										// La normalizzazione ha come codominio l' intervallo [0,1].
		double normalizedVal = 0.0;
		normalizedVal = (v - min) / (max - min);
		return normalizedVal;
	}

}

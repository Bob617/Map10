
public class DiscreteAttribute extends Attribute {
	public String values[];// array di oggetti String, uno per ciascun valore del dominio discreto. I
							// valori del dominio sono memorizzati in values seguendo un ordine
							// lessicografico.

	public DiscreteAttribute(String name, int index, String values[]) {
		super(name, index);
		this.values = values;
	}

	int getNumberOfDistinctTuples() { // Restituisce la dimensione di values
		return values.length;
	}

	String getValue(int i) { // Restituisce values[i]
		return values[i];
	}

}

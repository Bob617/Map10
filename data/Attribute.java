package data;

public abstract class Attribute {
	protected String name; // nome simbolico dell'attributo
	protected int index; // identificativo numerico dell'attributo

	Attribute(String name, int index) { // inizializza i valori dei membri name e index
		this.name = name;
		this.index = index;
	}

	String getName() { // restituisce name;
		return name;
	}

	int getIndex() { // : restituisce index
		return index;
	}

	public String toString() { // restituisce name
		return name;
	}

}

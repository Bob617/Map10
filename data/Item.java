package data;

import utility.ArraySet;

public abstract class Item { // modella un generico item (coppia attributo-valore, per esempio
								// Outlook=”Sunny”).
	protected Attribute attribute; // attributo coinvolto nell'item
	protected Object value; // valore assegnato all'attributo

	public Item(Attribute attribute, Object value) {
		this.attribute = attribute;
		this.value = value;
	}

	Attribute getAttribute() {
		return attribute;
	}

	Object getValue() {
		return value;
	}

	public String toString() {
		return (String) value;
	}

	abstract double distance(Object a);

	public void update(Data data, ArraySet clusteredData) { // Modifica il membro value, assegnandogli il valore restituito da
														// data.computePrototype(clusteredData,attribute);
		this.value = data.computePrototype(clusteredData, attribute);

	}

}

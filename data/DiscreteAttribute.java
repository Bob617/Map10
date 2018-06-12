package data;
import java.util.Iterator;

import utility.ArraySet;
import java.util.TreeSet;

public class DiscreteAttribute extends Attribute implements Iterable<String> {
	public TreeSet<String> values;// collezione di oggetti String, uno per ciascun valore del dominio discreto. I
							// valori del dominio sono memorizzati in values seguendo un ordine
							// lessicografico.

	public DiscreteAttribute(String name, int index, TreeSet<String> values) {
		super(name, index);
		this.values = values;
	}

	int getNumberOfDistinctValues() { // Restituisce la dimensione di values
		return values.size();
	}


	public int frequency(Data data, ArraySet idList, String V) {
		int j = 0, freq = 0;
		int attributeIndex = data.getNumberOfAttributes();
		for (int i = 0; i < idList.toArray().length; i++) {
			j = 0;
			while (j < attributeIndex) {
				if (V.equals(data.getAttributeValue(i, j))) {
					freq++;
				}
				j++;
			}
		}
		return freq;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

import java.util.Random;

public class Data {
	private Object data[][]; // una matrice nXm di tipo Object dove ogni riga modella una transazioni
	private int numberOfExamples; // cardinalità dell'insieme di transazioni (numero di righe in "data")
	private Attribute explanatorySet[]; // un vettore degli attributi in ciascuna tupla (schema della tabella di dati)

	Data() { /*
				 * Inizializza la matrice data [ ][ ] con transazioni di esempio (in questo
				 * momento, 14 esempi e 5 attributi come riportato nella tabella sottostante);
				 * Inizializza explanatorySet creando cinque oggetti di tipo DiscreteAttribute,
				 * uno per ciascun attributo (nella tabella sottostante). Attenzione a modellare
				 * correttamente, nome, indice e dominio di ciascun attributo. Inizializza
				 * numberOfExamples
				 */

		data = new Object[14][5];
		numberOfExamples = 14;

		data[0][0] = "Sunny";
		data[0][1] = "Hot";
		data[0][2] = "High";
		data[0][3] = "weak";
		data[0][4] = "No";

		data[1][0] = "Sunny";
		data[1][1] = "Hot";
		data[1][2] = "High";
		data[1][3] = "Strong";
		data[1][4] = "No";

		data[2][0] = "Overcast";
		data[2][1] = "Hot";
		data[2][2] = "High";
		data[2][3] = "Weak";
		data[2][4] = "Yes";

		data[3][0] = "Rain";
		data[3][1] = "Mild";
		data[3][2] = "High";
		data[3][3] = "Weak";
		data[3][4] = "Yes";

		data[4][0] = "Rain";
		data[4][1] = "Cool";
		data[4][2] = "Normal";
		data[4][3] = "Weak";
		data[4][4] = "Yes";

		data[5][0] = "Rain";
		data[5][1] = "Cool";
		data[5][2] = "Normal";
		data[5][3] = "Strong";
		data[5][4] = "No";

		data[6][0] = "Overcast";
		data[6][1] = "Cool";
		data[6][2] = "Normal";
		data[6][3] = "Strong";
		data[6][4] = "Yes";

		data[7][0] = "Sunny";
		data[7][1] = "Mild";
		data[7][2] = "High";
		data[7][3] = "Weak";
		data[7][4] = "No";

		data[8][0] = "Sunny";
		data[8][1] = "Cool";
		data[8][2] = "Normal";
		data[8][3] = "Weak";
		data[8][4] = "Yes";

		data[9][0] = "Rain";
		data[9][1] = "Mild";
		data[9][2] = "Normal";
		data[9][3] = "Strong";
		data[9][4] = "Yes";

		data[10][0] = "Sunny";
		data[10][1] = "Mild";
		data[10][2] = "Normal";
		data[10][3] = "Strong";
		data[10][4] = "Yes";

		data[11][0] = "Overcast";
		data[11][1] = "Mild";
		data[11][2] = "High";
		data[11][3] = "Strong";
		data[11][4] = "Yes";

		data[12][0] = "Overcast";
		data[12][1] = "Hot";
		data[12][2] = "Normal";
		data[12][3] = "Weak";
		data[12][4] = "Yes";

		data[13][0] = "Rain";
		data[13][1] = "Mild";
		data[13][2] = "High";
		data[13][3] = "Strong";
		data[13][4] = "No";

		explanatorySet = new Attribute[5];
		String outlookValues[] = new String[3];
		outlookValues[0] = "overcast";
		outlookValues[1] = "rain";
		outlookValues[2] = "sunny";
		explanatorySet[0] = new DiscreteAttribute("Outlook", 0, outlookValues);

		String temperatureValues[] = new String[3];
		temperatureValues[0] = "Hot";
		temperatureValues[1] = "Mild";
		temperatureValues[2] = "Cold";
		explanatorySet[1] = new DiscreteAttribute("Temperature", 1, temperatureValues);

		String humidityValues[] = new String[2];
		humidityValues[0] = "High";
		humidityValues[1] = "Normal";
		explanatorySet[2] = new DiscreteAttribute("Humidity", 2, humidityValues);

		String windValues[] = new String[2];
		windValues[0] = "Weak";
		windValues[1] = "Strong";
		explanatorySet[3] = new DiscreteAttribute("Wind", 3, windValues);

		String playTennisValues[] = new String[2];
		playTennisValues[0] = "No";
		playTennisValues[1] = "Yes";
		explanatorySet[4] = new DiscreteAttribute("PlayTennis", 4, playTennisValues);

	}

	int getNumberOfExamples() { // restituisce numberOfExamples
		return numberOfExamples;
	}

	int getNumberOfAttributes() { // restituisce la dimensione di explanatorySet
		return explanatorySet.length;
	}

	Object getAttributeValue(int exampleIndex, int attributeIndex) { // : restituisce data[exampleIndex][attributeIndex]
		return data[exampleIndex][attributeIndex];
	}

	Attribute[] getAttributeSchema() { // restituisce explanatorySet
		return explanatorySet;
	}

	public String toString() { /*
								 * crea una stringa in cui memorizza lo schema della tabella (vedi
								 * explanatorySet) e le transazioni memorizzate in data, opportunamente
								 * enumerate. Restituisce tale stringa
								 */
		String tabella = new String();
		int n = getNumberOfExamples();
		int m = getNumberOfAttributes();
		for (int righe = 0; righe < n; righe++) {
			int rigaCorrente = righe + 1;
			tabella += "\n" + rigaCorrente + ": ";
			int colonne;
			for (colonne = 0; colonne < m; colonne++) {
				tabella += getAttributeValue(righe, colonne) + " ";
			}
		}
		return tabella;

	}

	public static void main(String args[]) {
		Data trainingSet = new Data();
		System.out.println(trainingSet);

	}

	Tuple getItemSet(int index) { // Crea e restituisce un oggetto di Tuple che modella come sequenza di coppie
									// Attributo-valore la i-esima riga in data
		Tuple tuple = new Tuple(explanatorySet.length);
		for (int i = 0; i < explanatorySet.length; i++)
			tuple.add(new DiscreteItem(explanatorySet[i], (String) data[index][i]), i);
		return tuple;

	}

	int[] sampling(int k) {
		int centroidIndexes[] = new int[k];
		// choose k random different centroids in data.
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < k; i++) {
			boolean found = false;
			int c;
			do {
				found = false;
				c = rand.nextInt(getNumberOfExamples());
				// verify that centroid[c] is not equal to a centroide already stored in
				// CentroidIndexes
				for (int j = 0; j < i; j++)
					if (compare(centroidIndexes[j], c)) {
						found = true;
						break;
					}
			} while (found);
			centroidIndexes[i] = c;
		}
		return centroidIndexes;
	}

	private boolean compare(int i, int j) {
		int attributeIndex = this.getNumberOfAttributes();
		int attrib = 0;
		for (attrib = 0; attrib < attributeIndex; attrib++) {
			if (data[i][attrib] == data[j][attrib])
				return false;
		}
		return true;

	}

	Object computePrototype(ArraySet idList, Attribute attribute) {
		// return computePrototype(idList, (DiscreteAttribute) attribute);
		if (attribute instanceof DiscreteAttribute)
			return computePrototype(idList, (DiscreteAttribute) attribute);
		else
			return computePrototype(idList, (ContinuousAttribute) attribute);
	}

	String computePrototype(ArraySet idList, DiscreteAttribute attribute) {
		int maxFreq = 0, attrFreq = 0;
		String prot = new String();

		for (int i = 0; i < attribute.values.length; i++) {
			attrFreq = attribute.frequency(this, idList, attribute.getValue(i));

			if (maxFreq < attrFreq) {
				maxFreq = attrFreq;
				prot = attribute.getValue(i);
			}
		}
		return prot;
	}

}

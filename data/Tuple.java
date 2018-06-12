package data;

public class Tuple { // rappresenta una tupla come sequenza di coppie attributo-valore
	Item[] tuple;

	Tuple(int size) {
		tuple = new Item[size];
	}

	public int getLength() {
		return tuple.length;
	}

	public Item get(int i) {
		return tuple[i];
	}

	void add(Item c, int i) {
		tuple[i] = c;
	}

	public double getDistance(Tuple obj) { /*
									 * determina la distanza tra la tupla riferita da obj e la tupla corrente
									 * (riferita da this). La distanza è ottenuta come la somma delle distanze tra
									 * gli item in posizioni eguali nelle due tuple. Fare uso di double
									 * distance(Object a) di Item
									 */
		double distance = 0;
		for (int i = 0; i < obj.getLength(); i++) {
			distance += tuple[i].distance(obj.get(i));
		}
		return distance;

	}

	public double avgDistance(Data data, int clusteredData[]) { // restituisce la media delle distanze tra la tupla corrente e
															// quelle ottenibili dalle righe della matrice in data
															// aventi indice in clusteredData.
		double p = 0.0, sumD = 0.0;
		for (int i = 0; i < clusteredData.length; i++) {
			double d = getDistance(data.getItemSet(clusteredData[i]));
			sumD += d;
		}
		p = sumD / clusteredData.length;
		return p;

	}

}

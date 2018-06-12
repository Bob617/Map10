package mining;

import data.Data;
import data.OutOfRangeSampleSize;
import data.Tuple;

public class ClusterSet {
	Cluster C[];
	int i = 0;

	ClusterSet(int k) {
		C = new Cluster[k];
	}

	void add(Cluster c) {
		C[i] = c;
		i++;
	}

	Cluster get(int i) {
		return C[i];
	}

	void initializeCentroids(Data data) throws OutOfRangeSampleSize { // sceglie i centroidi, crea un cluster per ogni
																		// centroide e lo memorizza in C
		int centroidIndexes[] = data.sampling(C.length);
		for (int i = 0; i < centroidIndexes.length; i++) {
			Tuple centroidI = data.getItemSet(centroidIndexes[i]);
			add(new Cluster(centroidI));
		}
	}

	Cluster nearestCluster(Tuple tuple) {
		int i, pos = 0;
		double min = tuple.getDistance(C[0].getCentroid());
		double curr;
		for (i = 1; i < C.length; i++) {
			curr = tuple.getDistance(C[i].getCentroid());
			if (min > curr) {
				min = curr;
				pos = i;
			}
		}
		return get(pos);
	}

	Cluster currentCluster(int id) {
		int i, pos = 0;
		Cluster emptyCluster = null;

		for (i = 0; i < C.length; i++) {
			if (this.get(i).contain(id)) {
				pos = i;
				emptyCluster = get(pos);
			}
		}

		return emptyCluster;
	}

	void updateCentroids(Data data) {
		for (int i = 0; i < C.length; i++) {
			C[i].computeCentroid(data);
		}
	}

	public String toString() { // Restituisce una stringa fatta da ciascun centroide dell’insieme dei cluster.
		String centroids = new String();
		for (int i = 0; i < C.length; i++) {
			centroids += C[i].toString() + " ";
		}
		return centroids;
	}

	public String toString(Data data) {
		String str = "";
		for (int i = 0; i < C.length; i++) {
			if (C[i] != null) {
				str += i + ":" + C[i].toString(data) + "\n";
			}
		}
		return str;
	}

}

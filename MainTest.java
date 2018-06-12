import data.Data;
import data.OutOfRangeSampleSize;
import keyboardinput.Keyboard;
import mining.KmeansMiner;

public class MainTest {

	/**
	 * @param args
	 * @throws OutOfRangeSampleSize
	 */
	public static void main(String[] args) throws OutOfRangeSampleSize {
		char user = 0;
		Data data = new Data();
		boolean dec = true;
		while (dec == true) {
			System.out.println(data);
			int k = 3;
			KmeansMiner kmeans = new KmeansMiner(k);
			int numIter = kmeans.kmeans(data);
			System.out.println("Numero di Iterazione:" + numIter);
			System.out.println(kmeans.getC().toString(data));
			System.out.println("vuoi ripetere l'esecuzione?");
			user= Keyboard.readChar();
			if (user == 'n')
				dec = false;

		}

	}

}

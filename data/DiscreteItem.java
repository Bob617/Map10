package data;

public class DiscreteItem extends Item { // rappresenta una coppia <Attributo discreto- valore discreto> (per esempio
											// Outlook=”Sunny”)
	DiscreteItem(Attribute explanatorySet, String value) {
		super(explanatorySet, value);
	}

	double distance(Object a) {
		double dist;
		boolean flag = false;
		flag = getValue().equals(a.toString());
		if (flag == true)
			dist = 0;
		else
			dist =  1;
		return dist;
	}

}

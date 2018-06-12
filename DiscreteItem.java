
public class DiscreteItem extends Item { // rappresenta una coppia <Attributo discreto- valore discreto> (per esempio
											// Outlook=”Sunny”)
	DiscreteItem(Attribute explanatorySet, String value) {
		super(explanatorySet, value);
	}

	double distance(Object a) {
		if (getValue().equals(a))
			return 0;
		else
			return 1;
	}

}

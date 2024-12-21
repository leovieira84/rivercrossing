package rivercrossing.representations;

import rivercrossing.representations.interfaces.Comestivel;
import rivercrossing.representations.interfaces.Elemento;

public class Repolho implements Elemento,Comestivel{
	@Override
	public String identificar() {
		return "Repolho";
	}
}

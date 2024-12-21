package rivercrossing.representations;

import rivercrossing.representations.interfaces.Comedor;
import rivercrossing.representations.interfaces.Comestivel;
import rivercrossing.representations.interfaces.Elemento;

public class Lobo implements Elemento,Comedor{
	public boolean comer(Comestivel c) {
		if(c instanceof Ovelha) {
			System.out.println("Lobo comeu a ovelha!");
			return true;
		}
		return false;
	}

	@Override
	public String identificar() {
		return "Lobo";
	}
}

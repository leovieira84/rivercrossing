package rivercrossing.representations;

import rivercrossing.representations.interfaces.Comedor;
import rivercrossing.representations.interfaces.Comestivel;
import rivercrossing.representations.interfaces.Elemento;

public class Ovelha implements Elemento, Comestivel, Comedor {
	public boolean comer(Comestivel c) {
		if(c instanceof Repolho) {
			System.out.println("Ovelha comeu o repolho!");
			return true;
		}
		return false;
	}
	
	@Override
	public String identificar() {
		return "Ovelha";
	}
}

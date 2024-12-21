package rivercrossing.representations;

import java.util.ArrayList;
import java.util.List;

import rivercrossing.representations.enums.Localizacao;
import rivercrossing.representations.interfaces.Comedor;
import rivercrossing.representations.interfaces.Comestivel;
import rivercrossing.representations.interfaces.Elemento;

public class Margem {
	private Localizacao lado;
	private List<Elemento> elementos = new ArrayList<>();
	
	public Margem(Localizacao localizacao) {
		this.lado = localizacao;
	}
	
	public void receberElemento(Elemento elemento) {
		elementos.add(elemento);
	}
	
	public void retirarElemento(Elemento e) {
		elementos.remove(e);
	}
	
	public Localizacao getLado() {
		return this.lado;
	}

	public List<Elemento> getElementos() {
		return elementos;
	}

	public boolean validar(Localizacao localizacaoBarco) {
		int qtdElementosNaMargem = elementos.size();
		
		if(qtdElementosNaMargem != 2) 
			return true;
		
		boolean comeu = false;
		
		if(elementos.get(0) instanceof Comedor) {
			Comedor comedor = (Comedor) elementos.get(0);
			if(elementos.get(1) instanceof Comestivel) {
				Comestivel comestivel = (Comestivel) elementos.get(1);
				comeu = comedor.comer(comestivel);
			}
		}
		
		if(elementos.get(1) instanceof Comedor) {
			Comedor comedor = (Comedor) elementos.get(1);
			if(elementos.get(0) instanceof Comestivel) {
				Comestivel comestivel = (Comestivel) elementos.get(0);
				comeu = comedor.comer(comestivel);
			}
		}
		
		return !comeu;
	}

	public boolean elementoExiste(Elemento elemento) {
		return elementos.contains(elemento);
	}
}

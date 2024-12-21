package rivercrossing.representations;

import rivercrossing.representations.enums.Localizacao;
import rivercrossing.representations.interfaces.Elemento;

public class Rio {
	private Margem margemLeste;
	private Margem margemOeste;
	
	public Rio() {
		this.margemLeste = new Margem(Localizacao.LESTE);
		this.margemOeste = new Margem(Localizacao.OESTE);
	}
	
	public void receber(Elemento elemento, Localizacao localizacao) {
		if(localizacao == Localizacao.LESTE) {
			margemLeste.receberElemento(elemento);
		}else {
			margemOeste.receberElemento(elemento);
		}
	}
	
	public void retirar(Elemento elemento, Localizacao localizacao) {
		if(elementoExisteNaMargem(elemento, localizacao)) {
			if(localizacao == Localizacao.LESTE)
				margemLeste.retirarElemento(elemento);
			else
				margemOeste.retirarElemento(elemento);
				
		}
	}
	
	public boolean elementoExisteNaMargem(Elemento elemento, Localizacao localizacao) {
		if(localizacao == Localizacao.LESTE) {
			return margemLeste.elementoExiste(elemento);
		}
		return margemOeste.elementoExiste(elemento);
	}

	public Margem getMargemLeste() {
		return margemLeste;
	}

	public Margem getMargemOeste() {
		return margemOeste;
	}

	public boolean validaMargem(Localizacao localizacao) {
		if(localizacao == Localizacao.LESTE) {
			return margemLeste.validar(localizacao);
		}else {
			return margemOeste.validar(localizacao);
		}
	}
	
	
}

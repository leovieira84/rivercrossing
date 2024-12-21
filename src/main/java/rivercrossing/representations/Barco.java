package rivercrossing.representations;

import rivercrossing.representations.enums.Localizacao;
import rivercrossing.representations.interfaces.Elemento;

public class Barco {
	private Localizacao localizacao;
	private Elemento ocupante;
	
	public Barco() {
		reset();
	}
	
	public void reset() {
		this.localizacao = Localizacao.LESTE;
		this.ocupante = null;
	}
	
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}
	
	public boolean estaLotado() {
		return this.ocupante != null;
	}
	
	public void carregarBarco(Elemento e) {
		if(estaLotado()) {
			System.out.println("O barco está lotado");
			return;
		}
		
		ocupante = e;
		System.out.println(e.identificar() + " está no barco!");
		
	}
	
	public void descarregarBarco() {
		if(!estaLotado()) {
			System.out.println("O barco está lotado!!!");
		}
		
		System.out.println(this.ocupante.identificar() + " saiu do barco!");
		this.ocupante = null;
	}
	
	public void atravessarRio() {
		System.out.print("Barco atravessando o rio de " + getLocalizacao());
		this.localizacao = this.localizacao == Localizacao.LESTE ? Localizacao.OESTE : Localizacao.LESTE;
		System.out.println(" para " + getLocalizacao());
	}
	
	public Elemento getOcupante() {
		return this.ocupante;
	}
}

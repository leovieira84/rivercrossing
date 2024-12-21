package rivercrossing.desafio;

import rivercrossing.representations.Barco;
import rivercrossing.representations.Lobo;
import rivercrossing.representations.Ovelha;
import rivercrossing.representations.Repolho;
import rivercrossing.representations.Rio;
import rivercrossing.representations.interfaces.Elemento;

public class Desafio {
	private Barco barco;
	private Lobo lobo;
	private Ovelha ovelha;
	private Repolho repolho;
	private Rio rio;
	
	public Desafio() {
		reset();
	}
	
	public void reset() {
		barco = new Barco();
		rio = new Rio();
		lobo = new Lobo();
		ovelha = new Ovelha();
		repolho = new Repolho();
		
		rio.receber(lobo, barco.getLocalizacao());
		rio.receber(ovelha, barco.getLocalizacao());
		rio.receber(repolho, barco.getLocalizacao());
	}
	
	public void estadoAtual() {
		
		String txtOcupante = barco.getOcupante() != null  ? (" com " + barco.getOcupante().identificar()) : " sem carga";
		System.out.println("------------------------------------");
		System.out.println("\n\nEstado Atual do Desafio\n"
				+ "------------------------------------");
		System.out.println("Barco localizado na margem " + barco.getLocalizacao() + txtOcupante);
		System.out.println("Rio:");
		System.out.println("\t Margem Leste: ");
		
		for(Elemento e : rio.getMargemLeste().getElementos()) {
			System.out.println("\t\t\t" + e.identificar());
		}
		
		System.out.println("\t Margem Oeste: ");
		for(Elemento e : rio.getMargemOeste().getElementos()) {
			System.out.println("\t\t\t" + e.identificar());
		}
		System.out.println("------------------------------------");
	}
	
	public void embarcarOvelha() {
		if(!validarEmbarque(ovelha,barco)) {
			System.out.println("Ovelha não está na margem " + barco.getLocalizacao());
		}
	}
	
	public void embarcarLobo() {
		if(!validarEmbarque(lobo,barco)) {
			System.out.println("Lobo não está na margem " + barco.getLocalizacao());
		}
	}
	
	public void embarcarRepolho() {
		if (!validarEmbarque(repolho,barco)) {
			System.out.println("Repolho não está na margem " + barco.getLocalizacao());
		}
	}
	
	public void desembarcarOvelha() {
		if(!(barco.getOcupante() instanceof Ovelha)) {
			System.out.println("Ovelha não está no barco!");
			return;
		}
		desembarcar(ovelha,barco);
	}
	
	public void desembarcarLobo() {
		if(!(barco.getOcupante() instanceof Lobo)) {
			System.out.println("Lobo não está no barco!");
			return;
		}
		desembarcar(lobo,barco);
	}
	
	public void desembarcarRepolho() {
		if(!(barco.getOcupante() instanceof Repolho)) {
			System.out.println("Repolho não está no barco!");
			return;
		}
		desembarcar(repolho,barco);
	}
	
	public boolean atravessar() {
		if(validarDesafio()) {
			barco.atravessarRio();
			return true;
		}
		System.out.println("Perdeu!!!!");
		return false;
	}

	public boolean validarDesafio() {
		 return rio.validaMargem(barco.getLocalizacao());
	}
	
	private boolean validarEmbarque(Elemento elemento, Barco barco) {
		if(!rio.elementoExisteNaMargem(elemento, barco.getLocalizacao())){
			return false;
		}
		rio.retirar(elemento, barco.getLocalizacao());
		barco.carregarBarco(elemento);
		return true;
	}
	
	private void desembarcar(Elemento elemento, Barco barco) {
		barco.descarregarBarco();
		rio.receber(elemento, barco.getLocalizacao());
	}
}

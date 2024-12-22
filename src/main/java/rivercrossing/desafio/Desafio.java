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
	
	public String estadoAtual() {
		StringBuilder txtEstadoJogo = new StringBuilder();
		
		String txtOcupante = barco.getOcupante() != null  ? (" com " + barco.getOcupante().identificar()) : " sem carga";	
		txtEstadoJogo.append("Estado atual do Desafio:\n");
		txtEstadoJogo.append("\nBarco localizado na margem " + barco.getLocalizacao() + txtOcupante);
		txtEstadoJogo.append("\nRio:");
		txtEstadoJogo.append("\n\t Margem Leste: ");
		for(Elemento e : rio.getMargemLeste().getElementos()) {
			txtEstadoJogo.append("\n\t\t\t" + e.identificar());
		}
		txtEstadoJogo.append("\n\t Margem Oeste: ");
		for(Elemento e : rio.getMargemOeste().getElementos()) {
			txtEstadoJogo.append("\n\t\t\t" + e.identificar());
		}
		
		System.out.println(txtEstadoJogo.toString());
		return txtEstadoJogo.toString();
	}
	
	public String embarcarOvelha() {
		if(validarEmbarque(ovelha,barco)) {
			return "Ovelha entrou no barco!";
		}
		return("Ovelha não está na margem "  + barco.getLocalizacao());
	}
	
	public String embarcarLobo() {
		if(validarEmbarque(lobo,barco)) {
			return "Lobo entrou no barco!";
		}
		return "Lobo não está na margem " + barco.getLocalizacao();
	}
	
	public String embarcarRepolho() {
		if (validarEmbarque(repolho,barco)) {
			return "Repolho entrou no barco!";
		}
		return "Lobo não está na margem " + barco.getLocalizacao();
	}
	
	public String desembarcarOvelha() {
		if(!(barco.getOcupante() instanceof Ovelha)) {
			return "Ovelha não está no barco!";
		}
		return desembarcar(ovelha,barco);
	}
	
	public String desembarcarLobo() {
		if(!(barco.getOcupante() instanceof Lobo)) {
			return "Lobo não está no barco!";
		}
		return desembarcar(lobo,barco);
	}
	
	public String desembarcarRepolho() {
		if(!(barco.getOcupante() instanceof Repolho)) {
			return "Repolho não está no barco!";
		}
		return desembarcar(repolho,barco);
	}
	
	public String atravessar() {
		if(validarDesafio()) {
			return barco.atravessarRio();
		}
		return "PERDEU";
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
	
	private String desembarcar(Elemento elemento, Barco barco) {
		barco.descarregarBarco();
		rio.receber(elemento, barco.getLocalizacao());
		return elemento.identificar() + " saiu do barco";
	}
}

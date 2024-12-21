package rivercrossing;

import java.util.Scanner;

import rivercrossing.desafio.Desafio;

public class Main {

	public static void main(String[] args) {
		Desafio desafio = new Desafio();
		
		Scanner entrada = new Scanner(System.in);
		int opcao;
		do {
			System.out.println("################################");
			System.out.println("Escolha uma opção:\n"
					+ "(1) Embarcar Ovelha\n"
					+ "(2) Desembarcar Ovelha\n"
					+ "(3) Embarcar Lobo\n"
					+ "(4) Desembarcar Lobo\n"
					+ "(5) Embarcar Repolho\n"
					+ "(6) Desembarcar Repolho\n"
					+ "(7) Atravessar o Rio\n"
					+ "(8) Ver estado atual do desafio\n"
					+ "(9) Reiniciar\n"
					+ "(0) Sair");
			opcao = entrada.nextInt();
			
			switch(opcao) {
				case 1 : desafio.embarcarOvelha(); break;
				case 2 : desafio.desembarcarOvelha(); break;
				case 3 : desafio.embarcarLobo(); break;
				case 4 : desafio.desembarcarLobo(); break;
				case 5 : desafio.embarcarRepolho(); break;
				case 6 : desafio.desembarcarRepolho(); break;
				case 7 : desafio.atravessar(); break;
				case 8 : desafio.estadoAtual(); break;
				case 9 : desafio.reset(); break;
				case 0 : entrada.close(); System.exit(0);
				default : System.out.println("Opção inválida!");
			}
			
		} while(opcao != 0);
	}
}

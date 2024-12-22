package rivercrossing.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import rivercrossing.desafio.Desafio;

public class PainelControle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Desafio desafio = new Desafio();
	
	JPanel botoes;
	JButton embarcarOvelha;
	JButton desembarcarOvelha;
	
	JButton embarcarLobo;
	JButton desembarcarLobo;
	
	JButton embarcarRepolho;
	JButton desembarcarRepolho;
	
	JButton atravessar;
	JButton reiniciar;
	
	JPanel areaJogo;
	JTextArea txtAreaJogo;
	
	JPanel areaEstadoJogo;
	JTextArea txtAreaEstadoJogo;
	
	JPanel telaJogo;
	
	JLabel clickLabel;
	int clicks = 0;
	
	boolean habilitarBotoesAcao = true;
	boolean habilitarBotaoReset;
	
	public PainelControle() {
		super.setLayout(new GridLayout(3,1));
		iniciarBotoes();
		iniciarTelaJogo();
		
		
		clickLabel = new JLabel("Total de cliques : " + clicks);
		checarBotaoReset();
		checarBotoesAcao();
		
		this.add(telaJogo);
		this.add(botoes);
		this.add(clickLabel);
		
		atualizarEstadoJogo();
	}
	
	
	private void iniciarTelaJogo() {
		iniciarAreaJogo();
		iniciarAreaEstadoJogo();
		
		telaJogo = new JPanel(new GridLayout(1,2,1,1));
		telaJogo.add(areaJogo);
		telaJogo.add(areaEstadoJogo);
		telaJogo.setVisible(true);
	}


	private void iniciarAreaEstadoJogo() {
		txtAreaEstadoJogo = new JTextArea(10,30);
		txtAreaEstadoJogo.setEditable(false);
		
		areaEstadoJogo = new JPanel(new FlowLayout());
		areaEstadoJogo.add(new JScrollPane(txtAreaEstadoJogo));
		areaEstadoJogo.setVisible(true);
		
	}


	private void iniciarAreaJogo() {
		txtAreaJogo = new JTextArea(10, 40);
		txtAreaJogo.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtAreaJogo);
		
		areaJogo = new JPanel(new FlowLayout());
		areaJogo.add(scroll);
		areaJogo.setVisible(true);
	}
	
	private void atualizarClicks() {
		clicks++;
		clickLabel.setText("Total de cliques : " + clicks);
		checarBotaoReset();
		checarBotoesAcao();
		atualizarEstadoJogo();
	}


	private void checarBotoesAcao() {
		embarcarOvelha.setEnabled(habilitarBotoesAcao);
		embarcarLobo.setEnabled(habilitarBotoesAcao);
		embarcarRepolho.setEnabled(habilitarBotoesAcao);
		atravessar.setEnabled(habilitarBotoesAcao);
		desembarcarOvelha.setEnabled(habilitarBotoesAcao);
		desembarcarLobo.setEnabled(habilitarBotoesAcao);
		desembarcarRepolho.setEnabled(habilitarBotoesAcao);
		reiniciar.setEnabled(habilitarBotaoReset);
	}


	private void checarBotaoReset() {
		habilitarBotaoReset = false;
		if(clicks > 0) {
			habilitarBotaoReset = true;
		}
		reiniciar.setEnabled(habilitarBotaoReset);
	}

	private void iniciarBotoes() {
		
		botoes = new JPanel(new GridLayout(2, 4, 1, 1));
		
		embarcarOvelha = new JButton("Embarcar ovelha");
		embarcarLobo = new JButton("Embarcar lobo");
		embarcarRepolho = new JButton("Embarcar Repolho");
		atravessar = new JButton("Atravessar");
		desembarcarOvelha = new JButton("Desembarcar ovelha");
		desembarcarLobo = new JButton("Desembarcar lobo");
		desembarcarRepolho = new JButton("Desembarcar Repolho");
		reiniciar = new JButton("Reiniciar");
		
		botoes.add(embarcarOvelha);
		botoes.add(embarcarLobo);
		botoes.add(embarcarRepolho);
		botoes.add(atravessar);
		botoes.add(desembarcarOvelha);
		botoes.add(desembarcarLobo);
		botoes.add(desembarcarRepolho);
		botoes.add(reiniciar);
		
		configurarAcao();
		
		botoes.setVisible(true);
	}

	private void configurarAcao() {
		embarcarOvelha.addActionListener(new EmbarcarOvelhaListener());
		desembarcarOvelha.addActionListener(new DesembarcarOvelhaListener());
		
		embarcarLobo.addActionListener(new EmbarcarLoboListener());
		desembarcarLobo.addActionListener(new DesembarcarLoboListener());
		
		embarcarRepolho.addActionListener(new EmbarcarRepolhoListener());
		desembarcarRepolho.addActionListener(new DesembarcarRepolhoListener());
		
		atravessar.addActionListener(new AtravessarListener());
		reiniciar.addActionListener(new ReiniciarListener());
	}
	
	private void atualizarEstadoJogo() {
		txtAreaEstadoJogo.setText(desafio.estadoAtual());
	}
	
	private class EmbarcarOvelhaListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.embarcarOvelha());
			atualizarClicks();
		}
	}
	
	private class DesembarcarOvelhaListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.desembarcarOvelha());
			atualizarClicks();
		}
	}
	
	private class EmbarcarLoboListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.embarcarLobo());
			atualizarClicks();
		}
	}
	
	private class DesembarcarLoboListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.desembarcarLobo());
			atualizarClicks();
		}
	}
	
	private class EmbarcarRepolhoListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.embarcarRepolho());
			atualizarClicks();
		}
	}
	
	private class DesembarcarRepolhoListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtAreaJogo.append("\n"+desafio.desembarcarRepolho());
			atualizarClicks();
		}
	}
	
	private class AtravessarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			var retorno = desafio.atravessar();
			txtAreaJogo.append("\n"+retorno);
			
			
			if("PERDEU".equalsIgnoreCase(retorno)) {
				gameOver();
			}
			atualizarClicks();
		}

		private void gameOver() {
			habilitarBotoesAcao = false;
		}
	}
	
	private class ReiniciarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			desafio.reset();
			txtAreaJogo.setText("");
			clicks=0;
			checarBotaoReset();
			habilitarBotoesAcao=true;
			checarBotoesAcao();
			atualizarEstadoJogo();
		}
	}
}

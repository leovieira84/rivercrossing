package rivercrossing.gui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame janelaPrincipal;
	private JLabel statusLabel;
	
	private static JanelaPrincipal instancia = null;
	
	public static JanelaPrincipal getInstance() {
		if(instancia == null) {
			instancia = new JanelaPrincipal();  
		}
		return instancia;
	}
	
	private JanelaPrincipal() {
		iniciarInterfaceGrafica();
	}

	private void iniciarInterfaceGrafica() {
		montarJanelaPrincipal();
	}

	private void montarJanelaPrincipal() {
		janelaPrincipal = new JFrame("Desafio da travessia do rio");
		janelaPrincipal.setLayout(new GridLayout(1,1,5,1));
		janelaPrincipal.setSize(950,550);
		janelaPrincipal.setResizable(false);
		
		janelaPrincipal.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		var painel = new PainelControle();
		
		janelaPrincipal.add(painel);
		janelaPrincipal.setVisible(true);
	}
	
	public void setStatusLabel(String status) {
		statusLabel.setText("teste");
	}

}

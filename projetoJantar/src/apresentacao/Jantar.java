package apresentacao;


import javax.swing.JFrame;

public class Jantar extends JFrame {
	private int qtde;
	public Jantar() {
		add(new Mesa());
		
		
		setTitle("Jantar dos N Filósofos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        // SETA O TAMANHO
        setSize(410, 410);
        // SETA A LOCALIZAÇÃO
        setLocationRelativeTo(null);
        // SETA A VISIBILIDADE
        setVisible(true);
        // SETA SE É REDIMENSIONAVEL
        setResizable(true);
    
	}
}

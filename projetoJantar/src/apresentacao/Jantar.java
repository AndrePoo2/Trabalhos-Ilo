package apresentacao;


import javax.swing.JFrame;

public class Jantar extends JFrame {
	private int qtde;
	public Jantar() {
		add(new Mesa());
		
		
		setTitle("Jantar dos N Fil�sofos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

        // SETA O TAMANHO
        setSize(410, 410);
        // SETA A LOCALIZA��O
        setLocationRelativeTo(null);
        // SETA A VISIBILIDADE
        setVisible(true);
        // SETA SE � REDIMENSIONAVEL
        setResizable(true);
    
	}
}

package apresentacao;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import negocio.*;

public class Mesa extends JPanel implements Runnable {
	// Cria padr�es de comportamento dos fil�sofos
	final int PENSANDO = 0;
	final int FAMINTO = 1;
	final int COMENDO = 2;

	// Mensagem para cada um dos estados
	String mensagem = "";

	// Thread principal da aplica��o
	Thread animador;

	// Cria��o dos sem�foros da aplica��o

	// O sem�foro mutex que recebe o valor incial 1 para o contador
	// e � o sem�foro principal da nossa aplica��o
	public static Semaforo mutex = new Semaforo(1);

	// O vetor sem�foros s�o normais e existe um sem�foro para cada fil�sofo
	// que ser� criado, esses semaf�ros n�o recebem valores de inicializa��o
	// portanto iniciando o contador em 0
	public static Semaforo semaforos[] = new Semaforo[FPrincipal.qtdeFilosofos];

	// Define um vetor para o estado de cada um dos fil�sofos presentes
	// na aplica��o
	public static int estado[] = new int[FPrincipal.qtdeFilosofos];

	// Cria 5 fil�sofos em um vetor para a aplica��o
	public static Filosofo filosofo[] = new Filosofo[FPrincipal.qtdeFilosofos];

	public Mesa() {
		init();
	}

	public void init() {
		// Inicializa todos estados para zero
		for (int i = 0; i < estado.length; i++) {
			estado[i] = 0;
		}

		// Verifica se o Thread de anima��o � vazio
		if (animador == null) {
			// Ent�o cria um novo Thread
			animador = new Thread(this);
			// Inicia sua execu��o
			animador.start();
		}

		// Define a prioridade principal para este atual Thread
		Thread.currentThread().setPriority(1);

		for (int i = 0; i < FPrincipal.qtdeFilosofos; i++) {
			filosofo[i] = new Filosofo("F " + (i + 1), i);
			semaforos[i] = new Semaforo(0);
			filosofo[i].start();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		// Para cada um dos fil�sofos ser� feito um desenho
		for (int i = 0; i < FPrincipal.qtdeFilosofos; i++) {
			// Define a cor para cara tipo de estado
			if (estado[i] == 0) {
				g.setColor(Color.gray);
				 mensagem = "PENSANDO";
				
			}
			if (estado[i] == 1) {
				g.setColor(Color.yellow);
				 mensagem = "FAMINTO";
				
			}
			if (estado[i] == 2) {
				g.setColor(Color.green);
				 mensagem = "COMENDO";
				
			}
			
			
			g.fillOval((int) (200D - 100D * Math.cos(1.2D * (double) i)) - 5, (int) (200D - 100D * Math.sin(1.2D * (double) i)) - 5, 10, 10);
			g.setColor(Color.black);			
			g.drawString(filosofo[i].getName(), (int) (200D - 100D * Math.cos(1.2D * (double) i)) - 15, (int) (200D - 100D * Math.sin(1.2D * (double) i)) + 25);
		

		}

		// ATIVA A SINCRONIA
		Toolkit.getDefaultToolkit().sync();
		// PAUSA
		g.dispose();

	}

	// M�todo de execu��o da classe, onde o ambiente ser� rodado
	public void run() {
		// Uma execu��o infinita
		do {
			// Redesenha a tela
			repaint();

			// Dorme durante um tempo para redesenhar novamente
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException ex) {
				// Exibe uma mensagem de controle de erro
				System.out.println("ERROR>" + ex.getMessage());
			}
		} while (true);
	}
}

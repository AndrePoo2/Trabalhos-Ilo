package apresentacao;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import negocio.*;

public class Mesa extends JPanel implements Runnable {
	// Cria padrões de comportamento dos filósofos
	final int PENSANDO = 0;
	final int FAMINTO = 1;
	final int COMENDO = 2;

	// Mensagem para cada um dos estados
	String mensagem = "";

	// Thread principal da aplicação
	Thread animador;

	// Criação dos semáforos da aplicação

	// O semáforo mutex que recebe o valor incial 1 para o contador
	// e é o semáforo principal da nossa aplicação
	public static Semaforo mutex = new Semaforo(1);

	// O vetor semáforos são normais e existe um semáforo para cada filósofo
	// que será criado, esses semafóros não recebem valores de inicialização
	// portanto iniciando o contador em 0
	public static Semaforo semaforos[] = new Semaforo[FPrincipal.qtdeFilosofos];

	// Define um vetor para o estado de cada um dos filósofos presentes
	// na aplicação
	public static int estado[] = new int[FPrincipal.qtdeFilosofos];

	// Cria 5 filósofos em um vetor para a aplicação
	public static Filosofo filosofo[] = new Filosofo[FPrincipal.qtdeFilosofos];

	public Mesa() {
		init();
	}

	public void init() {
		// Inicializa todos estados para zero
		for (int i = 0; i < estado.length; i++) {
			estado[i] = 0;
		}

		// Verifica se o Thread de animação é vazio
		if (animador == null) {
			// Então cria um novo Thread
			animador = new Thread(this);
			// Inicia sua execução
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

		// Para cada um dos filósofos será feito um desenho
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

	// Método de execução da classe, onde o ambiente será rodado
	public void run() {
		// Uma execução infinita
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

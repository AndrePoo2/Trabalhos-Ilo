package negocio;


import java.security.Principal;

import apresentacao.FPrincipal;
import apresentacao.Mesa;

public class Filosofo extends Thread
{
	
    // Cria um c�digo privado para o fil�sofo
    private int ID;

    // Cria padr�es de comportamento do fil�sofo
    final int PENSANDO = 0;
    final int FAMINTO  = 1;
    final int COMENDO  = 2;

    // M�todo construtor que recebe um nome para a classe e um c�digo de
    // identifica��o do fil�sofo
    public Filosofo (String nome, int ID)
    {
        super(nome);
        this.ID = ID;
    }
/*final int PENSANDO = 0;
	final int FAMINTO = 1;
	final int COMENDO = 2;*/
    // M�todo para definir que o fil�sofo est� com fome
    public void ComFome ()
    {
        // Seta o estado deste fil�sofo na classe Mesa para FAMINTO
        Mesa.estado[this.ID] = 1;
        // Exibe uma mensagem de controle na tela
        System.out.println("O Fil�sofo " + getName() + " est� FAMINTO!");
    }

    // M�todo para definir que o fil�sofo est� comendo
    public void Come ()
    {
        // Seta o estado deste fil�sofo na classe Mesa para COMENDO
        Mesa.estado[this.ID] = 2;
        // Exibe uma mensagem de controle na tela
        System.out.println("O Fil�sofo " + getName() + " est� COMENDO!");

        // Ser� criado um controle para o fil�sofo permanecer comendo
        // durante certo per�odo de tempo
        try
        {
            // Fica parado neste estado por 1000 milisegundos
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex)
        {
            // Exibe uma mensagem de controle de erro
            System.out.println("ERROR>" + ex.getMessage());
        }
    }

    // M�todo para definir que o fil�sofo est� pensando
    public void Pensa ()
    {
        // Seta o estado deste fil�sofo na classe Mesa para PENSANDO
        Mesa.estado[this.ID] = 0;
        // Exibe uma mensagem de controle na tela
        System.out.println("O Fil�sofo " + getName() + " est� PENSANDO!");

        // Ser� criado um controle para o fil�sofo permanecer pensando
        // durante certo per�odo de tempo
        try
        {
            // Fica parado neste estado por 1000 milisegundos
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex)
        {
            // Exibe uma mensagem de controle de erro
            System.out.println("ERROR>" + ex.getMessage());
        }
    }

    // M�todo para o fil�sofo soltar um garfo que ele pegou
    public void LargarGarfo ()
    {
        // Decrementa o sem�foro mutex principal da classe, isso permite
        // informar que o atual m�todo est� operando na mesa dos fil�sofos
        Mesa.mutex.decrementar();

        // Coloca o fil�sofo para pensar determinado tempo
        Pensa();

        // Ap�s o fil�sofo pensar, ele vai informar para os seus vizinhos
        // que podem tentar pegar os garfos que j� est�o dispon�veis
        Mesa.filosofo[VizinhoEsquerda()].TentarObterGarfos();
        Mesa.filosofo[VizinhoDireita()].TentarObterGarfos();

        // Ap�s operar, volta o sem�foro mutex para o estado normal
        // indicando que j� realizou todos procedimentos na mesa
        Mesa.mutex.incrementar();
    }

    // M�todo para o fil�sofo pegar um garfo na mesa
    public void PegarGarfo ()
    {
        // Decrementa o sem�foro mutex principal da classe, isso permite
        // informar que o atual m�todo est� operando na mesa dos fil�sofos
        Mesa.mutex.decrementar();

        // Deixa o fil�sofo faminto por determinado tempo
        ComFome();

        // Ap�s o fil�sofo o per�odo de fome, ele vai verificar com seus
        // vizinhos se ele pode pegar os garfos
        TentarObterGarfos();

        // Ap�s operar, volta o sem�foro mutex para o estado normal
        // indicando que j� realizou todos procedimentos na mesa
        Mesa.mutex.incrementar();
        // Decrementa seu sem�foro
        Mesa.semaforos[this.ID].decrementar();
    }

    // M�todo para verificar se o fil�sofo pode pegar um garfo disposto na mesa
    public void TentarObterGarfos()
    {

        // Verifica se este fil�sofo est� com fome, e se o vizinho da esquerda
        // e da direita n�o est�o comendo
        if (Mesa.estado[this.ID] == 1 &&
            Mesa.estado[VizinhoEsquerda()] != 2 && 
            Mesa.estado[VizinhoDireita()] != 2)
        {
            // Ent�o este fil�sofo pode comer
            Come();
            // E incrementa o seu sem�foro
            Mesa.semaforos[this.ID].incrementar();
        }

    }

    // M�todo de execu��o da classe, onde o ambiente do fil�sofo ser� rodado
    @Override
    public void run ()
    {

        try
        {
            // Coloca o fil�sofo para pensar
            Pensa();

            // Ent�o realiza uma vida infinita para o fil�sofo onde inicialmente
            // ele executa os procedimentos de pergar os garfos da mesa, posteriormente
            // ele descansa um pouco, e por fim, ele largar os garfos que ele pegou
            do
            {
                PegarGarfo();
                Thread.sleep(1000L);
                LargarGarfo();
            }
            while (true);
        }
        catch (InterruptedException ex)
        {
            // Exibe uma mensagem de controle de erro
            System.out.println("ERROR>" + ex.getMessage());
            // E da um retorno de cancelamento
            return;
        }

    }

    // M�todo para obter o fil�sofo vizinho da direita
    public int VizinhoDireita ()
    {
        // Rationa o valor em 5 posi��es, ou seja, se o ID deste fil�sofo acrescentado
        // de um for maior que quatro, passa a ser zero
        return (this.ID + 1) % FPrincipal.qtdeFilosofos;
    }

    // M�todo para obter o fil�sofo vizinho da esquerda
    public int VizinhoEsquerda ()
    {
        if (this.ID == 0)
        {
            // Retorna a ultima posi��o
            return (FPrincipal.qtdeFilosofos - 1);
        }
        else
        {
            // Rationa o valor em 5 posi��es, ou seja, se o ID deste fil�sofo decrescido
            // de um for menor que zero, passa a ser quatro
            return (this.ID - 1) % FPrincipal.qtdeFilosofos;
        }
    }

}
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

 class Recebe implements Runnable {

        byte[] dadosReceber = new byte[255];
        boolean erro = false;
        DatagramSocket socket = null;

        @Override
        public void run() {
            while (true) {
                try {
                    socket = new DatagramSocket(getPorta());
                } catch (SocketException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }
                erro = false;
                while (!erro) {
                    DatagramPacket pacoteRecebido = new DatagramPacket(dadosReceber, dadosReceber.length);
                    try {
                        socket.receive(pacoteRecebido);
                        byte[] b = pacoteRecebido.getData();
                        String s = "";
                        for (int i = 0; i < b.length; i++) {
                            if (b[i] != 0) {
                                s += (char) b[i];
                            }
                        }
                        String nome = pacoteRecebido.getAddress().toString() + " disse:";
                        notifica(nome + s);
                    } catch (Exception e) {
                        System.out.println("erro");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        erro = true;
                        continue;
                    }
                }
            }
        }

		private void notifica(String string) {
			// TODO Auto-generated method stub
			
		}

		private SocketAddress getPorta() {
			// TODO Auto-generated method stub
			return null;
		}
    }
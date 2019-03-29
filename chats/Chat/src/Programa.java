

import javax.swing.JOptionPane;

public class Programa {
    
    public static void main(String[] args) {
        String  ip = (String)JOptionPane.showInputDialog("Informe o IP","192.168.1.10");
        int porta = Integer.parseInt(JOptionPane.showInputDialog("Informe a Porta","3300"));
        
        Conexao c = new Conexao(ip, porta);
        
        JanelaChat j = new JanelaChat(c);
      
        j.setVisible(true);
    }
}
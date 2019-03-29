package apresentacao;

import javax.swing.*;


public class FPrincipal extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private JButton btnIniciar;
	private JLabel labelImagem, lbQtdeFilosofos, lbTituloFilosofos;
	private JPanel jpPrincipal;
	private JTextField tbQtdeFilosofos;
	
	public static int qtdeFilosofos;
	public FPrincipal() {
		
		criarComponentes();
	}

	private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
		qtdeFilosofos = Integer.parseInt(tbQtdeFilosofos.getText());
		 Jantar jantar = new Jantar();
		 Legenda legenda = new Legenda();
		 jantar.setVisible(true);
		 legenda.setVisible(true);
		 
		 this.dispose();
	}

	public static void main(String args[]) {
		new FPrincipal();
	}
	
	public void criarComponentes(){
		jpPrincipal = new JPanel();
		lbQtdeFilosofos = new JLabel();
		tbQtdeFilosofos = new JTextField();
		btnIniciar = new JButton();
		labelImagem = new JLabel();
		lbTituloFilosofos = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Jantar dos Filósofos");

		jpPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lbQtdeFilosofos.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		lbQtdeFilosofos.setText("Qtde Filósofos");

		btnIniciar.setText("Iniciar Jantar");
		
		//evento btnIniciaar
		btnIniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIniciarActionPerformed(evt);
			}
		});

		lbTituloFilosofos.setFont(new java.awt.Font("Tahoma", 1, 18)); 
		lbTituloFilosofos.setText("Jantar dos  Filósofos");

		javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
		jpPrincipal.setLayout(jpPrincipalLayout);
		jpPrincipalLayout.setHorizontalGroup(jpPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpPrincipalLayout.createSequentialGroup().addGroup(jpPrincipalLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jpPrincipalLayout.createSequentialGroup().addGap(66, 66, 66)
								.addComponent(lbTituloFilosofos))
						.addGroup(
								jpPrincipalLayout.createSequentialGroup().addGap(97, 97, 97).addComponent(labelImagem))
						.addGroup(jpPrincipalLayout.createSequentialGroup().addGap(78, 78, 78)
								.addComponent(lbQtdeFilosofos)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(tbQtdeFilosofos, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jpPrincipalLayout.createSequentialGroup().addGap(112, 112, 112)
								.addComponent(btnIniciar)))
						.addContainerGap(73, Short.MAX_VALUE)));
		jpPrincipalLayout.setVerticalGroup(jpPrincipalLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
						.addContainerGap().addComponent(lbTituloFilosofos).addGap(18, 18, 18).addComponent(labelImagem)
						.addGap(18, 18, 18)
						.addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbQtdeFilosofos).addComponent(tbQtdeFilosofos,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(btnIniciar)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jpPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jpPrincipal,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

}

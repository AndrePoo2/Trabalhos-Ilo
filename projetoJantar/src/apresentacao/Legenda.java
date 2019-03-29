package apresentacao;

import java.awt.Color;


import javax.swing.*;

public class Legenda extends JFrame {
	
	 private JLabel comendo, faminto, pensando, legenda;
	
	    private JPanel iconComendo, iconFaminto, iconPensando;
	    
	public Legenda() {
		inicio();
		/*largura altura*/
		setSize(200, 200);
		
	
		
	}
	
	private void inicio(){
	       comendo = new JLabel("Comendo");
	        pensando = new JLabel("Pensando");
	        faminto = new JLabel("Faminto");
	        legenda = new JLabel();
	        iconComendo = new JPanel();
	        iconPensando = new JPanel();
	        iconFaminto = new JPanel();

	        setDefaultCloseOperation(EXIT_ON_CLOSE);


	        iconComendo.setBackground(Color.green);
	        javax.swing.GroupLayout iconComendoLayout = new javax.swing.GroupLayout(iconComendo);
	        iconComendo.setLayout(iconComendoLayout);
	        iconComendoLayout.setHorizontalGroup(
	            iconComendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 19, Short.MAX_VALUE)
	        );
	        iconComendoLayout.setVerticalGroup(
	            iconComendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 21, Short.MAX_VALUE)
	        );

	        iconPensando.setBackground(Color.gray);

	        javax.swing.GroupLayout iconPensandoLayout = new javax.swing.GroupLayout(iconPensando);
	        iconPensando.setLayout(iconPensandoLayout);
	        iconPensandoLayout.setHorizontalGroup(
	            iconPensandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 19, Short.MAX_VALUE)
	        );
	        iconPensandoLayout.setVerticalGroup(
	            iconPensandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 21, Short.MAX_VALUE)
	        );

	        iconFaminto.setBackground(Color.yellow);

	        javax.swing.GroupLayout iconFamintoLayout = new javax.swing.GroupLayout(iconFaminto);
	        iconFaminto.setLayout(iconFamintoLayout);
	        iconFamintoLayout.setHorizontalGroup(
	            iconFamintoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 19, Short.MAX_VALUE)
	        );
	        iconFamintoLayout.setVerticalGroup(
	            iconFamintoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 19, Short.MAX_VALUE)
	        );

	        legenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	        legenda.setText("Legenda");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(44, 44, 44)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(iconComendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(iconPensando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(iconFaminto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(comendo)
	                            .addComponent(pensando)
	                            .addComponent(faminto)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(legenda)
	                        .addGap(2, 2, 2)))
	                .addContainerGap(55, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addComponent(legenda)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(iconComendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(comendo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(pensando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(iconPensando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(iconFaminto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(faminto))
	                .addGap(27, 27, 27))
	        );
	}
	
}

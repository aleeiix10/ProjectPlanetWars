package Proyecto2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Thread {
	JFrame frame = new JFrame("Threads");
	JLabel[] labels = new JLabel[20];
	JPanel[] paneles = new JPanel [35];
	JButton exit = new JButton();
	
	//Necesito la cantidad de unidades y el planeta pq las unidades enemigas tienen el mismo nivel que planeta
	Thread(int[][] initialNumberUnitsEnemy, Planet planeta){
		frame.setLayout(new GridLayout(7,5));
		frame.setBackground(Color.black);
		
		for(int i=0; i<labels.length;i++) {
			labels[i] = new JLabel();
			labels[i].setBackground(Color.black);
			labels[i].setForeground(Color.white);
			labels[i].setVisible(true);
		}
		
		for(int i=0; i<paneles.length;i++) {
			paneles[i] = new JPanel();
			paneles[i].setBackground(Color.black);
			frame.add(paneles[i]);
		}
		
		
		
		//Set text de todas las labels
		labels[0].setText("Enemy Fleet");
		paneles[2].add(labels[0]);
		
		labels[1].setText("Quantity");
		paneles[6].add(labels[1]);

		labels[2].setText("Technology Attack");
		paneles[7].add(labels[2]);

		labels[3].setText("Technology Defense");
		paneles[8].add(labels[3]);

		
		labels[4].setText("Light Hunter");
		labels[5].setText(""+initialNumberUnitsEnemy[1][0]);
		labels[6].setText(""+planeta.getTechonologyAttack());
		labels[7].setText(""+planeta.getTechnologyDefense());
		if (initialNumberUnitsEnemy[1][0] == 0) {
			labels[6].setText("0");
			labels[7].setText("0");
		}
		
		labels[8].setText("Heavy Hunter");
		labels[9].setText(""+initialNumberUnitsEnemy[1][1]);
		labels[10].setText(""+planeta.getTechonologyAttack());
		labels[11].setText(""+planeta.getTechnologyDefense());
		if (initialNumberUnitsEnemy[1][1] == 0) {
			labels[10].setText("0");
			labels[11].setText("0");
		}
		
		labels[12].setText("Battle Ship");
		labels[13].setText(""+initialNumberUnitsEnemy[1][2]);
		labels[14].setText(""+planeta.getTechonologyAttack());
		labels[15].setText(""+planeta.getTechnologyDefense());
		if (initialNumberUnitsEnemy[1][2] == 0) {
			labels[14].setText("0");
			labels[15].setText("0");
		}
		
		labels[16].setText("Armored Ship");
		labels[17].setText(""+initialNumberUnitsEnemy[1][3]);
		labels[18].setText(""+planeta.getTechonologyAttack());
		labels[19].setText(""+planeta.getTechnologyDefense());
		if (initialNumberUnitsEnemy[1][3] == 0) {
			labels[18].setText("0");
			labels[19].setText("0");
		}
		
		//Paneles
		paneles[10].add(labels[4]);
		paneles[11].add(labels[5]);
		paneles[12].add(labels[6]);
		paneles[13].add(labels[7]);
		paneles[15].add(labels[8]);
		paneles[16].add(labels[9]);
		paneles[17].add(labels[10]);
		paneles[18].add(labels[11]);
		paneles[20].add(labels[12]);
		paneles[21].add(labels[13]);
		paneles[22].add(labels[14]);
		paneles[23].add(labels[15]);
		paneles[25].add(labels[16]);
		paneles[26].add(labels[17]);
		paneles[27].add(labels[18]);
		paneles[28].add(labels[19]);

		
		//Boton de salir
		exit.setBackground(Color.red);
		exit.setForeground(Color.black);
		exit.setText("Go Back");
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		paneles[34].add(exit);
		
		
		
		
		
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		frame.setIconImage(img_icon);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	
	}
	
}

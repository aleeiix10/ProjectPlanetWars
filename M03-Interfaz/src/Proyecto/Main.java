package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		new menu_principal();
	}

}

class menu_principal extends JFrame{
	JFrame frame = new JFrame("Planet Wars");
	JPanel panel[] = new JPanel[30];
	JLabel etiqueta[]= new JLabel[30];
	JButton boton[]=new JButton[3];
	menu_principal() {
		for (int i=0;i<etiqueta.length;i++) {
		etiqueta[i] = new JLabel();
		etiqueta[i].setForeground(Color.white);
		
		}
		
		for (int i=0;i<panel.length;i++) {
			panel[i] =  new JPanel();
			panel[i].setBackground(Color.black);
		}
		for (int i=0;i<boton.length;i++) {
			boton[i]= new JButton();
			boton[i].setForeground(Color.black);
			boton[i].setBackground(Color.white);
			boton[i].setFocusable(false);
		}
		etiqueta[0].setIcon(new javax.swing.ImageIcon("gif.gif"));
		etiqueta[14].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[15].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[16].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[17].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[18].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[19].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[0].setLayout(new GridLayout(3,3));
		panel[0].add(panel[1]);
		panel[0].add(panel[2]);
		panel[2].add(etiqueta[0]);
		panel[0].add(panel[3]);
		panel[0].add(panel[4]);
		panel[1].add(etiqueta[14]);
		panel[3].add(etiqueta[15]);
		panel[4].add(etiqueta[16]);
		panel[6].add(etiqueta[17]);
		panel[7].add(etiqueta[18]);
		panel[8].add(etiqueta[19]);
		etiqueta[1].setText("fffwfwfwfwfwfwf");
		etiqueta[2].setText("fwfwwfwfwfwfwfw");
		etiqueta[3].setText("cqcwwvwvwvwvwvw");
		etiqueta[1].setForeground(Color.black);
		etiqueta[2].setForeground(Color.black);
		etiqueta[3].setForeground(Color.black);		
		boton[0].setText("LOGIN");
		boton[1].setText("REGISTER");
		boton[2].setText("EXIT");
		panel[5].setLayout(new GridLayout(1,3));
		etiqueta[20].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[21].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[10].add(etiqueta[20]);
		panel[12].add(etiqueta[21]);
		panel[5].add(panel[10]);
		panel[5].add(panel[11]);
		panel[5].add(panel[12]);
		panel[11].add(etiqueta[1]);
		panel[11].add(etiqueta[2]);
		panel[11].add(etiqueta[3]);
		panel[11].add(boton[0]); 
		panel[11].add(etiqueta[12]);
		panel[11].add(boton[1]);
		panel[11].add(etiqueta[13]);
		panel[11].add(boton[2]);
		panel[9].setLayout(new GridLayout(1,3));
		panel[9].add(panel[13]);
		panel[9].add(panel[14]);
		panel[9].add(panel[15]);
		etiqueta[22].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[23].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[13].add(etiqueta[22]);
		panel[15].add(etiqueta[23]);
		etiqueta[4].setFont(new Font("Serif", Font.PLAIN, 14));
		etiqueta[5].setFont(new Font("Serif", Font.PLAIN, 14));
		etiqueta[6].setFont(new Font("Serif", Font.PLAIN, 14));
		etiqueta[7].setFont(new Font("Serif", Font.PLAIN, 14));
		etiqueta[8].setText("Vwsvvwvwvwvv");
		etiqueta[9].setText("Vwsvvwvwvwvv");
		etiqueta[10].setText("Vwsvvwvwvwvv");
		etiqueta[11].setText("Vwsvvwvwvwvv");
		etiqueta[12].setText("Vwsvvwvwvwvv");
		etiqueta[13].setText("Vwsvvwvwvwvv");
		etiqueta[8].setForeground(Color.black);	
		etiqueta[9].setForeground(Color.black);	
		etiqueta[8].setForeground(Color.black);	
		etiqueta[9].setForeground(Color.black);	
		etiqueta[10].setForeground(Color.black);	
		etiqueta[11].setForeground(Color.black);
		etiqueta[12].setForeground(Color.black);	
		etiqueta[13].setForeground(Color.black);
		etiqueta[4].setText("Eric Escric");
		etiqueta[5].setText("Borja Montoro");
		etiqueta[6].setText("Brahian Monsalve");
		etiqueta[7].setText("Aleix Sastre");
		panel[14].add(etiqueta[8]);		
		panel[14].add(etiqueta[9]);
		panel[14].add(etiqueta[10]);
		panel[14].add(etiqueta[11]);
		panel[14].add(etiqueta[4]);
		panel[14].add(etiqueta[5]);
		panel[14].add(etiqueta[6]);
		panel[14].add(etiqueta[7]);
		
		panel[0].add(panel[5]);
		panel[0].add(panel[6]);
		panel[0].add(panel[7]);
		panel[0].add(panel[8]);
		panel[0].add(panel[9]);
		frame.add(panel[0]);
		frame.setResizable(false);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		boton[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new menu_login();
				
			}
		});
		boton[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new menu_register();
				
			}
		});
		boton[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		
	}
}
class menu_login extends JFrame{
	JFrame frame = new JFrame("LOGIN");
	JPasswordField pass = new JPasswordField(15);
	JPanel panel[] = new JPanel[30];
	JLabel etiqueta[]= new JLabel[35];
	JButton boton[]=new JButton[3];
	JTextField text[]= new JTextField[3];
	menu_login() {
		pass.setBorder(null);
		for (int i=0;i<etiqueta.length;i++) {
		etiqueta[i] = new JLabel();
		etiqueta[i].setForeground(Color.white);
		
		}
		
		for (int i=0;i<panel.length;i++) {
			panel[i] =  new JPanel();
			panel[i].setBackground(Color.black);
		}
		for (int i=0;i<boton.length;i++) {
			boton[i]= new JButton();
			boton[i].setForeground(Color.black);
			boton[i].setBackground(Color.white);
			boton[i].setFocusable(false);
			text[i]= new JTextField(15);
			text[i].setBorder(null);
		}
		etiqueta[0].setIcon(new javax.swing.ImageIcon("gif.gif"));
		etiqueta[15].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[16].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[17].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[18].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[19].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[0].setLayout(new GridLayout(3,3));
		panel[0].add(panel[1]);
		panel[0].add(panel[2]);
		panel[2].add(etiqueta[0]);
		panel[0].add(panel[3]);
		panel[0].add(panel[4]);
		panel[1].add(etiqueta[14]);
		panel[3].add(etiqueta[15]);
		panel[4].add(etiqueta[16]);
		panel[6].add(etiqueta[17]);
		panel[7].add(etiqueta[18]);
		panel[8].add(etiqueta[19]);
		etiqueta[1].setText("fffwfwfwfwfwfwf");
		etiqueta[2].setText("fwfwwfwfwfwfwfw");
		etiqueta[3].setText("cqcwwvwvwvwvwvw");
		etiqueta[4].setText("cqcwwvwvwvwvwvw");
		etiqueta[5].setText("cqcwwvwvwvwvwvw");
		etiqueta[12].setText("Vwsvvwvwvwvv");
		etiqueta[13].setText("fvwvwvv");
		etiqueta[14].setText("cqcwwvwvwvwvwvw");
		etiqueta[14].setForeground(Color.black);
		etiqueta[1].setForeground(Color.black);
		etiqueta[2].setForeground(Color.black);
		etiqueta[3].setForeground(Color.black);
		etiqueta[4].setForeground(Color.black);
		etiqueta[5].setForeground(Color.black);
		etiqueta[12].setForeground(Color.black);
		etiqueta[13].setForeground(Color.black);
		boton[0].setText("LOGIN");
		boton[2].setText("BACK");
		panel[5].setLayout(new GridLayout(2,1));
		etiqueta[21].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[14].setLayout(new GridLayout(1,2));
		etiqueta[6].setText("USER:    ");
		etiqueta[7].setText("PASSWORD:");
		panel[16].add(etiqueta[14]);
		panel[16].add(etiqueta[12]);
		panel[16].add(etiqueta[6]);
		panel[16].add(etiqueta[13]);
		panel[16].add(etiqueta[7]);
	
		panel[16].setBackground(Color.black);
		panel[17].setBackground(Color.black);
		etiqueta[23].setText("cqcwwvwvwvwvwvw");
		etiqueta[23].setForeground(Color.black);
		panel[17].add(etiqueta[23]);
		panel[17].add(text[0]);
		panel[17].add(pass);
		panel[14].add(panel[16]);
		panel[14].add(panel[17]);
		panel[15].setLayout(new GridLayout(1,3));
		panel[19].add(etiqueta[27]);
		panel[19].add(boton[0]);
		panel[19].add(boton[2]);
		panel[15].add(panel[18]);
		panel[15].add(panel[19]);
		panel[15].add(panel[20]);
		etiqueta[24].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[25].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[26].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[27].setText("jdjdjdjdjdj");
		etiqueta[27].setForeground(Color.black);
		panel[18].add(etiqueta[24]);
		panel[20].add(etiqueta[25]);
		panel[19].setBackground(Color.black);
		panel[1].add(etiqueta[26]);
		panel[5].add(panel[14]);
		panel[5].add(panel[15]);
		panel[12].add(etiqueta[21]);
		panel[10].add(etiqueta[3]);
		panel[10].add(etiqueta[4]);
		panel[9].add(panel[13]);
		etiqueta[22].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[13].add(etiqueta[22]);
		
		panel[0].add(panel[5]);
		panel[0].add(panel[6]);
		panel[0].add(panel[7]);
		panel[0].add(panel[8]);
		panel[0].add(panel[9]);
		frame.add(panel[0]);
		frame.setResizable(false);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		boton[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new menu_principal();
				
			}
		});
	}
}
	class menu_register extends JFrame{
		JFrame frame = new JFrame("REGISTER");
		JPasswordField pass= new JPasswordField(15);
		JPanel panel[] = new JPanel[30];
		JLabel etiqueta[]= new JLabel[40];
		JButton boton[]=new JButton[3];
		JTextField text[]= new JTextField[3];
		JComboBox dia,mes,ano;
		menu_register() {
			pass.setBorder(null);
			for (int i=0;i<etiqueta.length;i++) {
			etiqueta[i] = new JLabel();
			etiqueta[i].setForeground(Color.white);
			
			}
			
			for (int i=0;i<panel.length;i++) {
				panel[i] =  new JPanel();
				panel[i].setBackground(Color.black);
			}
			for (int i=0;i<boton.length;i++) {
				boton[i]= new JButton();
				boton[i].setForeground(Color.black);
				boton[i].setBackground(Color.white);
				boton[i].setFocusable(false);
				text[i]= new JTextField(15);
				text[i].setBorder(null);
			
			}
			etiqueta[0].setIcon(new javax.swing.ImageIcon("gif.gif"));
			etiqueta[15].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[16].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[17].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[18].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[19].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			panel[0].setLayout(new GridLayout(3,3));
			panel[0].add(panel[1]);
			panel[0].add(panel[2]);
			panel[2].add(etiqueta[0]);
			panel[0].add(panel[3]);
			panel[0].add(panel[4]);
			panel[1].add(etiqueta[14]);
			panel[3].add(etiqueta[15]);
			panel[4].add(etiqueta[16]);
			panel[6].add(etiqueta[17]);
			panel[7].add(etiqueta[18]);
			panel[8].add(etiqueta[19]);
			etiqueta[1].setText("fffwfwfwfwfwfwf");
			etiqueta[2].setText("fwfwwfwfwfwfwfw");
			etiqueta[3].setText("cqcwwvwvwvwvwvw");
			etiqueta[4].setText("cqcwwvwvwvwvwvw");
			etiqueta[5].setText("cqcwwvwvwvwvwvw");
			etiqueta[12].setText("Vwsvvwvwvwvv");
			etiqueta[13].setText("fvwvwvv");
			etiqueta[14].setText("cqcwwvwvwvwvwvw");
			etiqueta[14].setForeground(Color.black);
			etiqueta[1].setForeground(Color.black);
			etiqueta[2].setForeground(Color.black);
			etiqueta[3].setForeground(Color.black);
			etiqueta[4].setForeground(Color.black);
			etiqueta[5].setForeground(Color.black);
			etiqueta[12].setForeground(Color.black);
			etiqueta[13].setForeground(Color.black);
			boton[0].setText("SUBMIT");
			boton[2].setText("BACK");
			panel[5].setLayout(new GridLayout(2,1));
			etiqueta[21].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			panel[14].setLayout(new GridLayout(1,2));
			etiqueta[29].setText("vccwscwc");
			etiqueta[29].setForeground(Color.black);
			etiqueta[6].setText("USER:    ");
			etiqueta[28].setText("BORN DAY:");
			etiqueta[7].setText("PASSWORD:");
			panel[16].add(etiqueta[14]);
			panel[16].add(etiqueta[12]);
			panel[16].add(etiqueta[6]);
			panel[16].add(etiqueta[13]);
			panel[16].add(etiqueta[7]);
			panel[16].add(etiqueta[29]);
			panel[16].add(etiqueta[28]);
			
		
			panel[16].setBackground(Color.black);
			panel[17].setBackground(Color.black);
			etiqueta[23].setText("cssswwwvw");
			etiqueta[23].setForeground(Color.black);
			panel[17].add(etiqueta[23]);
			panel[17].add(text[0]);
			//panel[17].add(etiqueta[31]);
			panel[17].add(pass);
			etiqueta[30].setText("wcaw");
			etiqueta[30].setForeground(Color.black);
			etiqueta[31].setText("wcaw");
			etiqueta[31].setForeground(Color.black);
			//panel[17].add(etiqueta[30]);
			String[] anopos= new String[73];
			int anoEm=2022;
			for (int i=0;i<anopos.length;i++) {
				anopos[i]=(String.valueOf(anoEm-i));
			}
			ano = new JComboBox(anopos);
			String AnoStr = (String)ano.getSelectedItem();
			String[] mespos= {"01","02","03","04","05","06","07","08","09","10","11","12"};
			mes = new JComboBox(mespos);
			String mesStr = (String)mes.getSelectedItem();
			if (((Integer.parseInt(AnoStr)%4==0 && Integer.parseInt(AnoStr)%100!=0) && mesStr=="02") || (Integer.parseInt(AnoStr)%400==0 && Integer.parseInt(AnoStr)%100==0 && mesStr=="02")) {
				String[] diasV= new String[29];
				int diaEm=1;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
				}
			}
			else if (mesStr=="02") {
				String[] diasNV= new String[28];
				int diaEm=1;
				for (int i=0;i<diasNV.length;i++) {
					diasNV[i]=(String.valueOf(diaEm+i));
				}

			}
			else if (mesStr=="01" && mesStr=="03" && mesStr=="05" && mesStr=="07" && mesStr=="08" && mesStr=="10" && mesStr=="12") {
				String[] dias31= new String[31];
				int diaEm=1;
				for (int i=0;i<dias31.length;i++) {
					dias31[i]=(String.valueOf(diaEm+i));
				}
			}
			else if (mesStr=="04" && mesStr=="06" && mesStr=="09" && mesStr=="11") {
				String[] dias30= new String[30];
				int diaEm=1;
				for (int i=0;i<dias30.length;i++) {
					dias30[i]=(String.valueOf(diaEm+i));
				}
			}
			String[] dias31= new String[31];
			int diaEm=1;
			for (int i=0;i<dias31.length;i++) {
				dias31[i]=(String.valueOf(diaEm+i));
			}
			dia = new JComboBox(dias31);
			
			
			ano.setPreferredSize(new Dimension(65,20));
			mes.setPreferredSize(new Dimension(45,20));
			dia.setPreferredSize(new Dimension(45,20));
			panel[17].add(ano);
			panel[17].add(mes);
			panel[17].add(dia);
			
			//panel[17].add(text[2]);
			panel[14].add(panel[16]);
			panel[14].add(panel[17]);
			panel[15].setLayout(new GridLayout(1,3));
			panel[19].add(etiqueta[27]);
			panel[19].add(boton[0]);
			panel[19].add(boton[2]);
			panel[15].add(panel[18]);
			panel[15].add(panel[19]);
			panel[15].add(panel[20]);
			etiqueta[24].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[25].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[26].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			etiqueta[27].setText("jdjdjdjdjdj");
			etiqueta[27].setForeground(Color.black);
			panel[18].add(etiqueta[24]);
			panel[20].add(etiqueta[25]);
			panel[19].setBackground(Color.black);
			panel[1].add(etiqueta[26]);
			panel[5].add(panel[14]);
			panel[5].add(panel[15]);
			panel[12].add(etiqueta[21]);
			panel[10].add(etiqueta[3]);
			panel[10].add(etiqueta[4]);
			panel[9].add(panel[13]);
			etiqueta[22].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
			panel[13].add(etiqueta[22]);
			
			panel[0].add(panel[5]);
			panel[0].add(panel[6]);
			panel[0].add(panel[7]);
			panel[0].add(panel[8]);
			panel[0].add(panel[9]);
			frame.add(panel[0]);
			frame.setResizable(false);
			frame.setSize(1120,682);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			boton[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new menu_principal();
					
				}
			});
		}
}


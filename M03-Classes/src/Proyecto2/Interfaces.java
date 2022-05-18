package Proyecto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D;
import java.sql.CallableStatement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;

import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.border.Border;
class Interfaces {
	public static void main(String[] args) {
		Planet a = new Planet();
		//a.printStats();
		//new menu_upgradeTec(a);
		new menu_principal();
	}
}

class RoundButton extends JButton {
	 
	  public RoundButton(String label) {
	    super(label);
	    setBackground(Color.lightGray);
	    setFocusable(false);
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, size.height);
	    setPreferredSize(size);
	    setContentAreaFilled(false);
	  }
	 
	  protected void paintComponent(Graphics g) {
	    if (getModel().isArmed()) {
	      g.setColor(Color.gray);
	    } else {
	      g.setColor(getBackground());
	    }
	    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
	 
	    super.paintComponent(g);
	  }
	 
	  protected void paintBorder(Graphics g) {
	    g.setColor(Color.darkGray);
	    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	  }
	  Shape shape;
	 
	  public boolean contains(int x, int y) {
	    if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	    }
	    return shape.contains(x, y);
	  }
}

class menu_principal extends JFrame{
	JFrame frame = new JFrame("Planet Wars");
	JPanel panel[] = new JPanel[30];
	JLabel etiqueta[]= new JLabel[30];
	JButton boton[]=new JButton[3];
	menu_principal() {
		Planet planeta= new Planet(); 
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
				frame.dispose();
				new menu_login();
				
			}
		});
		boton[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
class menu_login{
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
		
		panel[0].setLayout(new GridLayout(3,3));
		etiqueta[0].setIcon(new javax.swing.ImageIcon("gif.gif"));
		etiqueta[15].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[16].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[17].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[18].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		etiqueta[19].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
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
		boton[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion db=new Conexion("jdbc:oracle:thin:@192.168.40.2:1521:orcl","alumnoAMS5","alumnoAMS5");
				CallableStatement cst;
				String user= text[0].getText();
				String password=pass.getText();
				if (user.isEmpty() || password.isEmpty()) {
					new PopUpPers("One of two fields are ampty", "usuario.png", 50, 50);
				}
				else {
				try {
					cst = db.getCn().prepareCall("{CALL log_in (?,?,?)}");
					cst.setString(1, user);
					cst.setString(2, password);
					cst.registerOutParameter(3, java.sql.Types.INTEGER);
					cst.execute();
					Integer resultado = cst.getInt(3);
					text[0].setText("");
					pass.setText("");
					if (resultado ==1) {
							frame.dispose();
							new menu_inicial();
					}
					else {
						new PopUpRegister("You dont have account registed in game, press register to register an account or log in to try it again", "usuario.png", 50, 50,frame);
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
		});
		boton[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
		String[] mespos= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		mes = new JComboBox(mespos);
		String [] diasV= new String[30];
		int diaEm=1;
		for (int i=0;i<diasV.length;i++) {
			diasV[i]=(String.valueOf(diaEm+i));
		}
		dia = new JComboBox(diasV);
		ano.setPreferredSize(new Dimension(65,20));
		mes.setPreferredSize(new Dimension(45,20));
		panel[17].add(ano);
		panel[17].add(mes);
		dia.setPreferredSize(new Dimension(45,20));
		panel[17].add(dia);
		mes.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String[] diasV = null;
				String AnoStr = (String)ano.getSelectedItem();
				String mesStr = (String)mes.getSelectedItem();
				if (e.getStateChange()==ItemEvent.SELECTED) {
			if ((Integer.parseInt(AnoStr)%4==0 && Integer.parseInt(AnoStr)%100!=0 && mesStr=="02") || (Integer.parseInt(AnoStr)%400==0 && Integer.parseInt(AnoStr)%100==0 && mesStr=="02")) {
				diasV= new String[29];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="02") {
				diasV= new String[28];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="01" || mesStr=="03" || mesStr=="05" || mesStr=="07" || mesStr=="08" || mesStr=="10" || mesStr=="12") {
				diasV= new String[31];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="04" || mesStr=="06" || mesStr=="09" || mesStr=="11") {
				System.out.println("if 4");
				dia.removeAllItems();
				diasV= new String[30];
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			}
			}
		});

		ano.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String[] diasV = null;
				String AnoStr = (String)ano.getSelectedItem();
				String mesStr = (String)mes.getSelectedItem();
				if (e.getStateChange()==ItemEvent.SELECTED) {
			if ((Integer.parseInt(AnoStr)%4==0 && Integer.parseInt(AnoStr)%100!=0 && mesStr=="02") || (Integer.parseInt(AnoStr)%400==0 && Integer.parseInt(AnoStr)%100==0 && mesStr=="02")) {
				diasV= new String[29];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="02") {
				diasV= new String[28];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="01" || mesStr=="03" || mesStr=="05" || mesStr=="07" || mesStr=="08" || mesStr=="10" || mesStr=="12") {
				diasV= new String[31];
				dia.removeAllItems();
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			else if (mesStr=="04" || mesStr=="06" || mesStr=="09" || mesStr=="11") {
				dia.removeAllItems();
				diasV= new String[30];
				int diaEm=01;
				for (int i=0;i<diasV.length;i++) {
					diasV[i]=(String.valueOf(diaEm+i));
					dia.addItem(diasV[i]);
				}
			}
			}
			}
		});
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
		boton[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = text[0].getText();
				String password = pass.getText();
				String data = dia.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+ano.getSelectedItem();	
				text[0].setText("");
				pass.setText("");
				ano.setSelectedItem("2022");
				dia.setSelectedItem("1");
				mes.setSelectedItem("01");
				Conexion db=new Conexion("jdbc:oracle:thin:@192.168.40.2:1521:orcl","alumnoAMS5","alumnoAMS5");
				CallableStatement cst;
				try {
					if (user.isEmpty() || password.isEmpty()){
						new PopUpPers("One of the two fields is empty","ERROR", "usuario.png",50,50);
					}
					else {
					cst = db.getCn().prepareCall("{CALL registro (?,?,?,?)}");
					cst.setString(1, user);
					cst.setString(2, password);
					cst.setString(3, data);
					cst.registerOutParameter(4, java.sql.Types.INTEGER);
					cst.execute();
					Integer resultado = cst.getInt(4);
					if (resultado == 0) {
							new PopUpPers("The user name already exists","ERROR","usuario.png",50,50);
					}
					else {
							new PopUpPers("User added succesfully","USER","usuario.png",50,50,frame);
							new menu_inicial();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		boton[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new menu_principal();
			}
			
		});
	}
}
class menu_inicial{
	String user;
	JFrame frame = new JFrame("INICIAL");
	JPanel panel[] = new JPanel[70];
	JButton botones[]= new JButton[7];
	JLabel etiqueta[]= new JLabel[50];
	protected Planet planeta;
	menu_inicial(String user){
		this.user = user;
		for (int i=0;i<panel.length;i++) {
			panel[i]= new JPanel();
			panel[i].setBackground(Color.black);
		}
		for (int i=0;i<botones.length;i++) {
			botones[i]= new JButton();
			botones[i].setFocusable(false);
			
			
		}
		for (int i=0;i<etiqueta.length;i++) {
			etiqueta[i]= new JLabel();
			etiqueta[i].setForeground(Color.white);
			
		}
		
		panel[0].setLayout(new GridLayout(3,3));
		//PANEL 1
		etiqueta[0].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[1].add(etiqueta[0]);
		panel[0].add(panel[1]);
		//PANEL 2
		etiqueta[1].setIcon(new javax.swing.ImageIcon("gif.gif"));
		panel[2].add(etiqueta[1]);
		panel[0].add(panel[2]);
		
		//PANEL 3
		panel[3].setLayout(new GridLayout(2,2));
		
		etiqueta[2].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[10].add(etiqueta[2]);
		panel[3].add(panel[10]);
		panel[3].add(panel[11]);
		
		etiqueta[3].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[12].add(etiqueta[3]);
		panel[3].add(panel[12]);
		
		etiqueta[4].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[13].add(etiqueta[4]);
		panel[3].add(panel[13]);
		
		panel[11].setLayout(new GridLayout(2,1));
		panel[11].add(panel[14]);
		panel[11].add(panel[15]);
		panel[0].add(panel[3]);
		//PANEL 4
		panel[4].setLayout(new GridLayout(2,2));
		etiqueta[5].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[16].add(etiqueta[5]);
		panel[4].add(panel[16]);
		panel[4].add(panel[17]);
		
		etiqueta[6].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[18].add(etiqueta[6]);
		panel[4].add(panel[18]);
		
		etiqueta[7].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[19].add(etiqueta[7]);
		panel[4].add(panel[19]);
		
		panel[17].setLayout(new GridLayout(2,1));
		etiqueta[8].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[20].add(etiqueta[8]);
		panel[17].add(panel[20]);
		panel[17].add(panel[21]);
		botones[0].setText("   BUILD  ");
		panel[21].add(botones[0]);
		panel[0].add(panel[4]);
		//PANEL 5
		panel[5].setLayout(new GridLayout(2,3));
		
		etiqueta[9].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[22].add(etiqueta[9]);
		panel[5].add(panel[22]);
		
		panel[23].setLayout(new GridLayout(2,1));
		etiqueta[10].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[24].add(etiqueta[10]);
		panel[23].add(panel[24]);
		botones[1].setText("VIEW STATS");
		panel[25].add(botones[1]);
		panel[23].add(panel[25]);
		panel[5].add(panel[23]);
		
		etiqueta[11].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[26].add(etiqueta[11]);
		panel[5].add(panel[26]);
		
		etiqueta[12].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[27].add(etiqueta[12]);
		panel[5].add(panel[27]);
		
		etiqueta[13].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[28].add(etiqueta[13]);
		panel[5].add(panel[28]);
		
		etiqueta[14].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[29].add(etiqueta[14]);
		panel[5].add(panel[29]);
		
		panel[0].add(panel[5]);
		
		//PANEL 6
		panel[6].setLayout(new GridLayout(2,2));
		panel[6].add(panel[30]);
		panel[30].setLayout(new GridLayout(2,1));
		etiqueta[15].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[31].add(etiqueta[15]);
		panel[30].add(panel[31]);
		botones[2].setText("UPGRADE");
		panel[32].add(botones[2]);
		panel[30].add(panel[32]);
		panel[0].add(panel[6]);
		
		etiqueta[16].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[33].add(etiqueta[16]);
		panel[6].add(panel[33]);
		
		etiqueta[17].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[34].add(etiqueta[17]);
		panel[6].add(panel[34]);
		
		etiqueta[18].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[35].add(etiqueta[18]);
		panel[6].add(panel[35]);
		
		
		//PANEL 7 
		panel[7].setLayout(new GridLayout(2,2));
		etiqueta[19].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[36].add(etiqueta[19]);
		panel[7].add(panel[36]);
		panel[7].add(panel[37]);
		
		etiqueta[20].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[38].add(etiqueta[20]);
		panel[7].add(panel[38]);
		
		etiqueta[21].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[39].add(etiqueta[21]);
		panel[7].add(panel[39]);
		
		panel[37].setLayout(new GridLayout(2,1));
		etiqueta[22].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[40].add(etiqueta[22]);
		panel[37].add(panel[40]);
		panel[37].add(panel[41]);
		botones[3].setText("   THREAD  ");
		panel[41].add(botones[3]);
		panel[0].add(panel[7]);
		
		//PANEL 8
		panel[8].setLayout(new GridLayout(2,3));
		etiqueta[23].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[42].add(etiqueta[23]);
		panel[8].add(panel[42]);
		
		botones[4]=new RoundButton("  DANGER  ");
		botones[4].setBackground(Color.red);
		botones[4].setForeground(Color.white);
		panel[43].add(botones[4]);
		panel[8].add(panel[43]);
		
		etiqueta[24].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[44].add(etiqueta[24]);
		panel[8].add(panel[44]);
		
		etiqueta[25].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[45].add(etiqueta[25]);
		panel[8].add(panel[45]);
		
		panel[46].setLayout(new GridLayout(2,1));
		
		etiqueta[27].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		
		panel[49].add(etiqueta[27]);
		panel[46].add(panel[49]);
		
		botones[6].setText("  EXIT  ");
		panel[48].add(botones[6]);
		panel[46].add(panel[48]);
		
		panel[8].add(panel[46]);
		
		etiqueta[26].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[47].add(etiqueta[26]);
		panel[8].add(panel[47]);
		
		panel[0].add(panel[8]);
		//PANEL 9
		panel[9].setLayout(new GridLayout(2,2));
		panel[9].add(panel[50]);
		panel[50].setLayout(new GridLayout(2,1));
		etiqueta[28].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[51].add(etiqueta[28]);
		panel[50].add(panel[51]);
		botones[5].setText("REPORTS");
		panel[52].add(botones[5]);
		panel[50].add(panel[52]);
		panel[0].add(panel[9]);
		
		etiqueta[29].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[53].add(etiqueta[29]);
		panel[9].add(panel[53]);
		
		etiqueta[30].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[54].add(etiqueta[30]);
		panel[9].add(panel[54]);
		
		etiqueta[31].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[55].add(etiqueta[31]);
		panel[9].add(panel[55]);
		
		panel[0].add(panel[9]);
		
		frame.add(panel[0]);
		frame.setResizable(false);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		botones[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Build(planeta);
				
			}
		});
		botones[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				planeta.printStats();
				
			}
		});
		botones[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new menu_upgradeTec(planeta);
				
			}
		});
		botones[6].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new menu_principal();
				
			}
		});
	}
	
}

class menu_upgradeTec{
	JFrame buildFrame = new JFrame("BUILD");
	JPanel [] paneles = new JPanel[52];
	JPanel [] fleet_buttons = new JPanel[7];
	JLabel [] listalabels = new JLabel[19];
	JLabel [] label_image = new JLabel[9];
	JLabel [] label_deut = new JLabel[7];
	JPanel [] panel_cost = new JPanel[7];
	
	JButton exit = new JButton();
	JButton [] plus = new JButton[7]; 
	JButton [] minus = new JButton[7]; 
	JButton [] add = new JButton[7];
	menu_upgradeTec(Planet planeta){
		planeta.setDeuterium(5000);
		planeta.setTechonologyAttack(1);
		planeta.setTechnologyDefense(1);
			buildFrame.setLayout(new GridLayout(10,5));
			buildFrame.setBackground(Color.BLACK);
			//instanciar los paneles
			for (int i=0; i<50; i++) {
				paneles[i] = new JPanel();
				paneles[i].setBackground(Color.black);
				buildFrame.add(paneles[i]);
			}
			//panel con el metal y el deuterium
			paneles[4].setLayout(new GridLayout(2,1));
			paneles[50] = new JPanel();
			paneles[51] = new JPanel();
			
			paneles[50].setBackground(Color.black);
			paneles[51].setBackground(Color.black);
			
			paneles[4].add(paneles[50]);  //Panel del metal
			paneles[4].add(paneles[51]);  //Panel del deuterium
			
			
			//for para instanciar las labels con img
			for (int i=0;i<label_image.length;i++) {
				label_image[i] = new JLabel();
				label_image[i].setBackground(Color.black);
			}
	
			//instanciar labels
			for (int i=0; i<listalabels.length; i++) {
				listalabels[i] = new JLabel();
				listalabels[i].setVisible(true);
				listalabels[i].setBackground(Color.black);
				listalabels[i].setForeground(Color.white);
			}
					
			//instanciar botones de aumento y disminucion de tropas
			for (int i=0; i<plus.length;i++) {
				fleet_buttons[i] = new JPanel();
				fleet_buttons[i].setLayout(new GridLayout(2,1));
			
				plus[i] = new JButton();
				plus[i].setBackground(Color.yellow);
				plus[i].setForeground(Color.black);
				plus[i].setText("+");
				plus[i].setFocusable(false);
				
				minus[i] = new JButton();
				minus[i].setBackground(Color.yellow);
				minus[i].setForeground(Color.black);
				minus[i].setText("-");
				minus[i].setFocusable(false);
				
				add[i] = new JButton();
				add[i].setBackground(new Color(245,213,27));
				add[i].setForeground(Color.black);
				add[i].setText("ADD");
				add[i].setFocusable(false);
				
			
				
				
				//Etiquetas y paneles de cost
				panel_cost[i] = new JPanel();
				panel_cost[i].setLayout(new GridLayout(2,1));
				panel_cost[i].setBackground(Color.black);
				
				label_deut[i] = new JLabel();
				label_deut[i].setBackground(Color.black);
				label_deut[i].setForeground(Color.white);
			}
	
			
			listalabels[0].setText("UPGRADE");
			listalabels[1].setText("Metal       "+ planeta.getMetal());
			listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
			listalabels[3].setText("ATTACK");
			listalabels[4].setText("DEFENSE");
			
			
			listalabels[9].setText("Upgrade attack "+planeta.getTechonologyAttack());
			label_deut[2].setText("Deuterium: "+planeta.getUpgradeAttackTechologyDeuteriumCost());
			
			listalabels[11].setText("Upgrade defense "+planeta.getTechnologyDefense());
			label_deut[3].setText("Deuterium: "+planeta.getUpgradeDefenseTechologyDeuteriumCost());
		
			
			Image img_heavy = new ImageIcon("attack_tech.png").getImage();
			Image new_imgheavy = img_heavy.getScaledInstance(80, 60,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon heavy = new ImageIcon(new_imgheavy);
			label_image[1].setIcon(heavy);
			
			Image img_ion = new ImageIcon("defense_tech.png").getImage();
			Image new_imgion = img_ion.getScaledInstance(70, 60,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon ion = new ImageIcon(new_imgion);
			label_image[5].setIcon(ion);
			
			Image img_metal = new ImageIcon("metal.png").getImage();
			Image new_imgmetal = img_metal.getScaledInstance(45, 30,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon metal = new ImageIcon(new_imgmetal);
			label_image[7].setIcon(metal);

			Image img_deut = new ImageIcon("deuterium.png").getImage();
			Image new_imgdeut = img_deut.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon deuterium = new ImageIcon(new_imgdeut);
			label_image[8].setIcon(deuterium);
			
			
			//a�adir labels con imagen a los paneles
			paneles[10].add(label_image[0]);
			paneles[20].add(label_image[1]);
			paneles[30].add(label_image[2]);
			paneles[40].add(label_image[3]);
			paneles[13].add(label_image[4]);
			paneles[23].add(label_image[5]);
			paneles[33].add(label_image[6]);
			paneles[50].add(label_image[7]);
			paneles[51].add(label_image[8]);
			
			//poner los paneles con bordelayout para mover el texto
			paneles[11].setLayout(new BorderLayout());
			paneles[21].setLayout(new BorderLayout());
		paneles[31].setLayout(new BorderLayout());
		paneles[41].setLayout(new BorderLayout());
		paneles[14].setLayout(new BorderLayout());
		paneles[24].setLayout(new BorderLayout());
		paneles[34].setLayout(new BorderLayout());

		
		//a�adir texto a los paneles a traves de las labels, el coste centrarlo y los botones despu�s de los labeles de cost
		paneles[2].add(listalabels[0]);
		paneles[50].add(listalabels[1]);
		paneles[51].add(listalabels[2]);
		paneles[5].add(listalabels[3]);
		paneles[8].add(listalabels[4]);

		paneles[20].add(listalabels[9]);
		panel_cost[2].add(listalabels[10]);
		panel_cost[2].add(label_deut[2]);
		paneles[21].add(panel_cost[2],BorderLayout.CENTER);
		paneles[21].add(fleet_buttons[2],BorderLayout.EAST);
		paneles[21].add(add[2],BorderLayout.SOUTH);


		paneles[23].add(listalabels[11]);
		panel_cost[3].add(listalabels[12]);
		panel_cost[3].add(label_deut[3]);
		paneles[24].add(panel_cost[3],BorderLayout.CENTER);
		paneles[24].add(fleet_buttons[3],BorderLayout.EAST);
		paneles[24].add(add[3],BorderLayout.SOUTH);		
		//boton salir
		exit.setBackground(Color.red);
		exit.setForeground(Color.black);
		exit.setText("Go Back");
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildFrame.dispose();
				new menu_principal();
			}
		});
		paneles[49].add(exit);
		//BOTON UPGRADE ATTACK
				add[2].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.upgradeTechnologyAttack();
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
							listalabels[9].setText("Upgrade attack "+planeta.getTechonologyAttack());
							label_deut[2].setText("Deuterium: "+planeta.getUpgradeAttackTechologyDeuteriumCost());

						} catch (ResourceException e1) {
						}
					}
				});
		//BOTON UPGRADE DEFENSE
				add[3].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.upgradeTechnologyDefense();
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
							listalabels[11].setText("Upgrade defense "+planeta.getTechnologyDefense());
							label_deut[3].setText("Deuterium: "+planeta.getUpgradeDefenseTechologyDeuteriumCost());

						} catch (ResourceException e1) {
						}
					}
				});
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		buildFrame.setIconImage(img_icon);
		buildFrame.setSize(1120,682);
		buildFrame.setLocationRelativeTo(null);
		buildFrame.setVisible(true);
		buildFrame.setResizable(false);
		
		
	}
	
	
}
class Build{
	JFrame buildFrame = new JFrame("BUILD");
	JPanel [] paneles = new JPanel[52];
	JPanel [] fleet_buttons = new JPanel[7];
	JLabel [] listalabels = new JLabel[19];
	JLabel [] label_image = new JLabel[9];
	JLabel [] label_deut = new JLabel[7];
	JPanel [] panel_cost = new JPanel[7];
	
	JButton exit = new JButton();
	JButton [] plus = new JButton[7]; 
	JButton [] minus = new JButton[7]; 
	JButton [] add = new JButton[7];
	int light_num = 1, heavy_num = 1, battle_num = 1, armored_num = 1, missile_num = 1, ion_num = 1, plasma_num = 1; 


	Build(Planet planeta){
		buildFrame.setLayout(new GridLayout(10,5));
		buildFrame.setBackground(Color.BLACK);
		//instanciar los paneles
		for (int i=0; i<50; i++) {
			paneles[i] = new JPanel();
			paneles[i].setBackground(Color.black);
			buildFrame.add(paneles[i]);
		}
		//panel con el metal y el deuterium
		paneles[4].setLayout(new GridLayout(2,1));
		paneles[50] = new JPanel();
		paneles[51] = new JPanel();
		
		paneles[50].setBackground(Color.black);
		paneles[51].setBackground(Color.black);
		
		paneles[4].add(paneles[50]);  //Panel del metal
		paneles[4].add(paneles[51]);  //Panel del deuterium
		
		
		//for para instanciar las labels con img
		for (int i=0;i<label_image.length;i++) {
			label_image[i] = new JLabel();
			label_image[i].setBackground(Color.black);
		}

		//instanciar labels
		for (int i=0; i<listalabels.length; i++) {
			listalabels[i] = new JLabel();
			listalabels[i].setVisible(true);
			listalabels[i].setBackground(Color.black);
			listalabels[i].setForeground(Color.white);
		}
				
		//instanciar botones de aumento y disminucion de tropas
		for (int i=0; i<plus.length;i++) {
			fleet_buttons[i] = new JPanel();
			fleet_buttons[i].setLayout(new GridLayout(2,1));
		
			plus[i] = new JButton();
			plus[i].setBackground(Color.yellow);
			plus[i].setForeground(Color.black);
			plus[i].setText("+");
			plus[i].setFocusable(false);
			
			minus[i] = new JButton();
			minus[i].setBackground(Color.yellow);
			minus[i].setForeground(Color.black);
			minus[i].setText("-");
			minus[i].setFocusable(false);
			
			add[i] = new JButton();
			add[i].setBackground(new Color(245,213,27));
			add[i].setForeground(Color.black);
			add[i].setText("ADD");
			add[i].setFocusable(false);
			
			fleet_buttons[i].add(plus[i]);
			fleet_buttons[i].add(minus[i]);
			
			
			//Etiquetas y paneles de cost
			panel_cost[i] = new JPanel();
			panel_cost[i].setLayout(new GridLayout(2,1));
			panel_cost[i].setBackground(Color.black);
			
			label_deut[i] = new JLabel();
			label_deut[i].setBackground(Color.black);
			label_deut[i].setForeground(Color.white);
		}

		
		listalabels[0].setText("Build");
		listalabels[1].setText("Metal       "+ planeta.getMetal());
		listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
		listalabels[3].setText("TROOPS");
		listalabels[4].setText("DEFENSES");
		
		listalabels[5].setText("     Light Hunters    "+light_num);
		listalabels[6].setText("Metal: "+Variables.METAL_COST_LIGTHHUNTER*light_num);
		label_deut[0].setText("Deuterium: "+Variables.DEUTERIUM_COST_LIGTHHUNTER*light_num);
		
		listalabels[7].setText("Missile Launcher   "+ missile_num);
		listalabels[8].setText("Metal: "+Variables.METAL_COST_MISSILELAUNCHER*missile_num);
		label_deut[1].setText("Deuterium: "+Variables.DEUTERIUM_COST_MISSILELAUNCHER*missile_num);
		
		listalabels[9].setText("Heavy Hunters  "+heavy_num);
		listalabels[10].setText("Metal: "+Variables.METAL_COST_HEAVYHUNTER*heavy_num);
		label_deut[2].setText("Deuterium: "+Variables.DEUTERIUM_COST_HEAVYHUNTER*heavy_num);
		
		listalabels[11].setText("Ion Cannon           "+ion_num);
		listalabels[12].setText("Metal: "+Variables.METAL_COST_IONCANNON*ion_num);
		label_deut[3].setText("Deuterium: "+Variables.DEUTERIUM_COST_IONCANNON*ion_num);
		
		listalabels[13].setText("         Battle Ship        "+ battle_num);
		listalabels[14].setText("Metal: "+Variables.METAL_COST_BATTLESHIP*battle_num);
		label_deut[4].setText("Deuterium: "+Variables.DEUTERIUM_COST_BATTLESHIP*battle_num);
		
		listalabels[15].setText("Plasma Cannon    "+plasma_num);
		listalabels[16].setText("Metal: "+Variables.METAL_COST_PLASMACANNON*plasma_num);
		label_deut[5].setText("Deuterium: "+Variables.DEUTERIUM_COST_PLASMACANNON*plasma_num);
		
		listalabels[17].setText("         Armored Ship  "+armored_num);
		listalabels[18].setText("Metal: "+Variables.METAL_COST_ARMOREDSHIP*armored_num);
		label_deut[6].setText("Deuterium: "+Variables.DEUTERIUM_COST_ARMOREDSHIP*armored_num);
		
		Image img_sold = new ImageIcon("SOLDIER.png").getImage();
		Image new_imgsoldier = img_sold.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon soldiers = new ImageIcon(new_imgsoldier);
		label_image[0].setIcon(soldiers);
		
		Image img_heavy = new ImageIcon("heavyHunter.png").getImage();
		Image new_imgheavy = img_heavy.getScaledInstance(80, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon heavy = new ImageIcon(new_imgheavy);
		label_image[1].setIcon(heavy);
		
		Image img_ship = new ImageIcon("BattleShip.png").getImage();
		Image new_imgship = img_ship.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon ships = new ImageIcon(new_imgship);
		label_image[2].setIcon(ships);
		
		Image img_armor = new ImageIcon("BattleShip.png").getImage();
		Image new_imgarmor = img_armor.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon armor = new ImageIcon(new_imgarmor);
		label_image[3].setIcon(armor);
		
		Image img_miss = new ImageIcon("missile.png").getImage();
		Image new_imgmis = img_miss.getScaledInstance(60, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon missile = new ImageIcon(new_imgmis);
		label_image[4].setIcon(missile);
		
		Image img_ion = new ImageIcon("ioncannon.png").getImage();
		Image new_imgion = img_ion.getScaledInstance(70, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon ion = new ImageIcon(new_imgion);
		label_image[5].setIcon(ion);
		
		Image img_plas = new ImageIcon("PlasmaCannon.png").getImage();
		Image new_imgplas = img_plas.getScaledInstance(70, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon plasma = new ImageIcon(new_imgplas);
		label_image[6].setIcon(plasma);

		Image img_metal = new ImageIcon("metal.png").getImage();
		Image new_imgmetal = img_metal.getScaledInstance(45, 30,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon metal = new ImageIcon(new_imgmetal);
		label_image[7].setIcon(metal);

		Image img_deut = new ImageIcon("deuterium.png").getImage();
		Image new_imgdeut = img_deut.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon deuterium = new ImageIcon(new_imgdeut);
		label_image[8].setIcon(deuterium);
		
		
		//a�adir labels con imagen a los paneles
		paneles[10].add(label_image[0]);
		paneles[20].add(label_image[1]);
		paneles[30].add(label_image[2]);
		paneles[40].add(label_image[3]);
		paneles[13].add(label_image[4]);
		paneles[23].add(label_image[5]);
		paneles[33].add(label_image[6]);
		paneles[50].add(label_image[7]);
		paneles[51].add(label_image[8]);
		
		//poner los paneles con bordelayout para mover el texto
		paneles[11].setLayout(new BorderLayout());
		paneles[21].setLayout(new BorderLayout());
		paneles[31].setLayout(new BorderLayout());
		paneles[41].setLayout(new BorderLayout());
		paneles[14].setLayout(new BorderLayout());
		paneles[24].setLayout(new BorderLayout());
		paneles[34].setLayout(new BorderLayout());

		
		//a�adir texto a los paneles a traves de las labels, el coste centrarlo y los botones despu�s de los labeles de cost
		paneles[2].add(listalabels[0]);
		paneles[50].add(listalabels[1]);
		paneles[51].add(listalabels[2]);
		paneles[5].add(listalabels[3]);
		paneles[8].add(listalabels[4]);
		
		paneles[10].add(listalabels[5]);
		panel_cost[0].add(listalabels[6]);
		panel_cost[0].add(label_deut[0]);
		paneles[11].add(panel_cost[0],BorderLayout.CENTER);
		paneles[11].add(fleet_buttons[0],BorderLayout.EAST);
		paneles[11].add(add[0],BorderLayout.SOUTH);
		
		paneles[13].add(listalabels[7]);
		panel_cost[1].add(listalabels[8]);
		panel_cost[1].add(label_deut[1]);
		paneles[14].add(panel_cost[1],BorderLayout.CENTER);
		paneles[14].add(fleet_buttons[1],BorderLayout.EAST);
		paneles[14].add(add[1],BorderLayout.SOUTH);


		paneles[20].add(listalabels[9]);
		panel_cost[2].add(listalabels[10]);
		panel_cost[2].add(label_deut[2]);
		paneles[21].add(panel_cost[2],BorderLayout.CENTER);
		paneles[21].add(fleet_buttons[2],BorderLayout.EAST);
		paneles[21].add(add[2],BorderLayout.SOUTH);


		paneles[23].add(listalabels[11]);
		panel_cost[3].add(listalabels[12]);
		panel_cost[3].add(label_deut[3]);
		paneles[24].add(panel_cost[3],BorderLayout.CENTER);
		paneles[24].add(fleet_buttons[3],BorderLayout.EAST);
		paneles[24].add(add[3],BorderLayout.SOUTH);


		paneles[30].add(listalabels[13]);
		panel_cost[4].add(listalabels[14]);
		panel_cost[4].add(label_deut[4]);
		paneles[31].add(panel_cost[4],BorderLayout.CENTER);
		paneles[31].add(fleet_buttons[4],BorderLayout.EAST);
		paneles[31].add(add[4],BorderLayout.SOUTH);


		paneles[33].add(listalabels[15]);
		panel_cost[5].add(listalabels[16]);
		panel_cost[5].add(label_deut[5]);
		paneles[34].add(panel_cost[5],BorderLayout.CENTER);
		paneles[34].add(fleet_buttons[5],BorderLayout.EAST);
		paneles[34].add(add[5],BorderLayout.SOUTH);


		paneles[40].add(listalabels[17]);
		panel_cost[6].add(listalabels[18]);
		panel_cost[6].add(label_deut[6]);
		paneles[41].add(panel_cost[6],BorderLayout.CENTER);
		paneles[41].add(fleet_buttons[6],BorderLayout.EAST);
		paneles[41].add(add[6],BorderLayout.SOUTH);


		
		//boton salir
		exit.setBackground(Color.red);
		exit.setForeground(Color.black);
		exit.setText("Go Back");
		exit.setFocusable(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildFrame.dispose();
			}
		});
		paneles[49].add(exit);

	//Funcionalidad de botones "+", "-" y "ADD"	
		
		//BOTONES LIGHTHUNTER
		plus[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				light_num += 1;
				listalabels[5].setText("     Light Hunters      "+light_num);
				listalabels[6].setText("Metal: "+Variables.METAL_COST_LIGTHHUNTER*light_num);
				label_deut[0].setText("Deuterium: "+Variables.DEUTERIUM_COST_LIGTHHUNTER*light_num);
			}
		});
		minus[0].addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (light_num > 1) {
					light_num -= 1;
					listalabels[5].setText("     Light Hunters      "+light_num);
					listalabels[6].setText("Metal: "+Variables.METAL_COST_LIGTHHUNTER*light_num);
					label_deut[0].setText("Deuterium: "+Variables.DEUTERIUM_COST_LIGTHHUNTER*light_num);
				}
			}
		});
		add[0].addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					planeta.newLigthHunter(light_num);
					light_num = 1;
					listalabels[5].setText("     Light Hunters      "+light_num);
					listalabels[6].setText("Metal: "+Variables.METAL_COST_LIGTHHUNTER*light_num);
					label_deut[0].setText("Deuterium: "+Variables.DEUTERIUM_COST_LIGTHHUNTER*light_num);
					listalabels[1].setText("Metal       "+ planeta.getMetal());
					listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
				} catch (ResourceException e1) {
					e1.printStackTrace();
					light_num = 1;
					listalabels[5].setText("     Light Hunters      "+light_num);
					listalabels[6].setText("Metal: "+Variables.METAL_COST_LIGTHHUNTER*light_num);
					label_deut[0].setText("Deuterium: "+Variables.DEUTERIUM_COST_LIGTHHUNTER*light_num);
					
					listalabels[1].setText("Metal       "+ planeta.getMetal());
					listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
				}
			}
		});
		
		//BOTONES MISSILELAUNCHER
				plus[1].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						missile_num += 1;
						listalabels[7].setText("    Missile Launcher   "+ missile_num);
						listalabels[8].setText("Metal: "+Variables.METAL_COST_MISSILELAUNCHER*missile_num);
						label_deut[1].setText("Deuterium: "+Variables.DEUTERIUM_COST_MISSILELAUNCHER*missile_num);
					}
				});
				minus[1].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (missile_num > 1) {
							missile_num -= 1;
							listalabels[7].setText("    Missile Launcher   "+ missile_num);
							listalabels[8].setText("Metal: "+Variables.METAL_COST_MISSILELAUNCHER*missile_num);
							label_deut[1].setText("Deuterium: "+Variables.DEUTERIUM_COST_MISSILELAUNCHER*missile_num);
						}
					}
				});
				add[1].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newMissileLauncher(missile_num);
							missile_num = 1;
							listalabels[7].setText("    Missile Launcher   "+ missile_num);
							listalabels[8].setText("Metal: "+Variables.METAL_COST_MISSILELAUNCHER*missile_num);
							label_deut[1].setText("Deuterium: "+Variables.DEUTERIUM_COST_MISSILELAUNCHER*missile_num);
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							missile_num = 1;
							listalabels[7].setText("    Missile Launcher   "+ missile_num);
							listalabels[8].setText("Metal: "+Variables.METAL_COST_MISSILELAUNCHER*missile_num);
							label_deut[1].setText("Deuterium: "+Variables.DEUTERIUM_COST_MISSILELAUNCHER*missile_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		//BOTONES HEAVYHUNTER
				plus[2].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						heavy_num += 1;
						listalabels[9].setText("Heavy Hunters    "+heavy_num);
						listalabels[10].setText("Metal: "+Variables.METAL_COST_HEAVYHUNTER*heavy_num);
						label_deut[2].setText("Deuterium: "+Variables.DEUTERIUM_COST_HEAVYHUNTER*heavy_num);
					}
				});
				minus[2].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (heavy_num > 1) {
							heavy_num -= 1;
							listalabels[9].setText("Heavy Hunters    "+heavy_num);
							listalabels[10].setText("Metal: "+Variables.METAL_COST_HEAVYHUNTER*heavy_num);
							label_deut[2].setText("Deuterium: "+Variables.DEUTERIUM_COST_HEAVYHUNTER*heavy_num);
						}
					}
				});
				add[2].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newHeavyHunter(heavy_num);
							heavy_num = 1;
							listalabels[9].setText("Heavy Hunters    "+heavy_num);
							listalabels[10].setText("Metal: "+Variables.METAL_COST_HEAVYHUNTER*heavy_num);
							label_deut[2].setText("Deuterium: "+Variables.DEUTERIUM_COST_HEAVYHUNTER*heavy_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							heavy_num = 1;
							listalabels[9].setText("Heavy Hunters    "+heavy_num);
							listalabels[10].setText("Metal: "+Variables.METAL_COST_HEAVYHUNTER*heavy_num);
							label_deut[2].setText("Deuterium: "+Variables.DEUTERIUM_COST_HEAVYHUNTER*heavy_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		//BOTONES IONCANNON
				plus[3].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ion_num += 1;
						listalabels[11].setText("    Ion Cannon           "+ion_num);
						listalabels[12].setText("Metal: "+Variables.METAL_COST_IONCANNON*ion_num);
						label_deut[3].setText("Deuterium: "+Variables.DEUTERIUM_COST_IONCANNON*ion_num);
					}
				});
				minus[3].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (ion_num > 1) {
							ion_num -= 1;
							listalabels[11].setText("    Ion Cannon           "+ion_num);
							listalabels[12].setText("Metal: "+Variables.METAL_COST_IONCANNON*ion_num);
							label_deut[3].setText("Deuterium: "+Variables.DEUTERIUM_COST_IONCANNON*ion_num);
						}
					}
				});
				add[3].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newIonCannon(ion_num);
							ion_num = 1;
							listalabels[11].setText("    Ion Cannon           "+ion_num);
							listalabels[12].setText("Metal: "+Variables.METAL_COST_IONCANNON*ion_num);
							label_deut[3].setText("Deuterium: "+Variables.DEUTERIUM_COST_IONCANNON*ion_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							ion_num = 1;
							listalabels[11].setText("    Ion Cannon           "+ion_num);
							listalabels[12].setText("Metal: "+Variables.METAL_COST_IONCANNON*ion_num);
							label_deut[3].setText("Deuterium: "+Variables.DEUTERIUM_COST_IONCANNON*ion_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		//BOTONES BATTLESHIP
				plus[4].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						battle_num += 1;
						listalabels[13].setText("         Battle Ship          "+ battle_num);
						listalabels[14].setText("Metal: "+Variables.METAL_COST_BATTLESHIP*battle_num);
						label_deut[4].setText("Deuterium: "+Variables.DEUTERIUM_COST_BATTLESHIP*battle_num);
					}
				});
				minus[4].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (battle_num > 1) {
							battle_num -= 1;
							listalabels[13].setText("         Battle Ship          "+ battle_num);
							listalabels[14].setText("Metal: "+Variables.METAL_COST_BATTLESHIP*battle_num);
							label_deut[4].setText("Deuterium: "+Variables.DEUTERIUM_COST_BATTLESHIP*battle_num);
						}
					}
				});
				add[4].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newBattleShip(battle_num);
							battle_num = 1;
							listalabels[13].setText("         Battle Ship          "+ battle_num);
							listalabels[14].setText("Metal: "+Variables.METAL_COST_BATTLESHIP*battle_num);
							label_deut[4].setText("Deuterium: "+Variables.DEUTERIUM_COST_BATTLESHIP*battle_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							battle_num = 1;
							listalabels[13].setText("         Battle Ship          "+ battle_num);
							listalabels[14].setText("Metal: "+Variables.METAL_COST_BATTLESHIP*battle_num);
							label_deut[4].setText("Deuterium: "+Variables.DEUTERIUM_COST_BATTLESHIP*battle_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		
		//BOTONES PLASMACANNON
				plus[5].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						plasma_num += 1;
						listalabels[15].setText("Plasma Cannon    "+plasma_num);
						listalabels[16].setText("Metal: "+Variables.METAL_COST_PLASMACANNON*plasma_num);
						label_deut[5].setText("Deuterium: "+Variables.DEUTERIUM_COST_PLASMACANNON*plasma_num);
					}
				});
				minus[5].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (plasma_num > 1) {
							plasma_num -= 1;
							listalabels[15].setText("Plasma Cannon    "+plasma_num);
							listalabels[16].setText("Metal: "+Variables.METAL_COST_PLASMACANNON*plasma_num);
							label_deut[5].setText("Deuterium: "+Variables.DEUTERIUM_COST_PLASMACANNON*plasma_num);
						}
					}
				});
				add[5].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newPlasmaCannon(plasma_num);
							plasma_num = 1;
							listalabels[15].setText("Plasma Cannon    "+plasma_num);
							listalabels[16].setText("Metal: "+Variables.METAL_COST_PLASMACANNON*plasma_num);
							label_deut[5].setText("Deuterium: "+Variables.DEUTERIUM_COST_PLASMACANNON*plasma_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							plasma_num = 1;
							listalabels[15].setText("Plasma Cannon    "+plasma_num);
							listalabels[16].setText("Metal: "+Variables.METAL_COST_PLASMACANNON*plasma_num);
							label_deut[5].setText("Deuterium: "+Variables.DEUTERIUM_COST_PLASMACANNON*plasma_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		//BOTONES ARMOREDSHIP
				plus[6].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						armored_num += 1;
						listalabels[17].setText("         Armored Ship    "+armored_num);
						listalabels[18].setText("Metal: "+Variables.METAL_COST_ARMOREDSHIP*armored_num);
						label_deut[6].setText("Deuterium: "+Variables.DEUTERIUM_COST_ARMOREDSHIP*armored_num);
					}
				});
				minus[6].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						if (armored_num > 1) {
							armored_num -= 1;
							listalabels[17].setText("         Armored Ship    "+armored_num);
							listalabels[18].setText("Metal: "+Variables.METAL_COST_ARMOREDSHIP*armored_num);
							label_deut[6].setText("Deuterium: "+Variables.DEUTERIUM_COST_ARMOREDSHIP*armored_num);
						}
					}
				});
				add[6].addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							planeta.newArmoredShip(armored_num);
							armored_num = 1;
							listalabels[17].setText("         Armored Ship    "+armored_num);
							listalabels[18].setText("Metal: "+Variables.METAL_COST_ARMOREDSHIP*armored_num);
							label_deut[6].setText("Deuterium: "+Variables.DEUTERIUM_COST_ARMOREDSHIP*armored_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						} catch (ResourceException e1) {
							e1.printStackTrace();
							armored_num = 1;
							listalabels[17].setText("         Armored Ship    "+armored_num);
							listalabels[18].setText("Metal: "+Variables.METAL_COST_ARMOREDSHIP*armored_num);
							label_deut[6].setText("Deuterium: "+Variables.DEUTERIUM_COST_ARMOREDSHIP*armored_num);
							
							listalabels[1].setText("Metal       "+ planeta.getMetal());
							listalabels[2].setText("Deuterium   "+ planeta.getDeuterium());
						}
					}
				});
		
		
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		buildFrame.setIconImage(img_icon);
		buildFrame.setSize(1120,682);
		buildFrame.setLocationRelativeTo(null);
		buildFrame.setVisible(true);
		buildFrame.setResizable(false);
		
		
	}
	
	
}
	
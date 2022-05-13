package Proyecto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class Main {

	public static void main(String[] args) {
		new menu_inicial();
	}

}

class RoundButton extends JButton {
	 
	  public RoundButton(String label) {
	    super(label);
	 
	    setBackground(Color.lightGray);
	    setFocusable(false);
	 
	    /*
	     These statements enlarge the button so that it 
	     becomes a circle rather than an oval.
	    */
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width, size.height);
	    setPreferredSize(size);
	 
	    /*
	     This call causes the JButton not to paint the background.
	     This allows us to paint a round background.
	    */
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
	 
	  // Hit detection.
	  Shape shape;
	 
	  public boolean contains(int x, int y) {
	    // If the button has changed size,  make a new shape object.
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
							//new play();
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
							new PopUpPers("User added succesfully","USER","usuario.png",50,50);
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
				frame.setVisible(false);
				new menu_principal();
			}
			
		});
	}
}
class menu_inicial{
	JFrame frame = new JFrame();
	JPanel panel[] = new JPanel[42];
	JButton botones[]= new JButton[6];
	JLabel etiqueta[]= new JLabel[32];
	menu_inicial(){
		for (int i=0;i<panel.length;i++) {
			panel[i]= new JPanel();
		}
		for (int i=0;i<botones.length;i++) {
			botones[i]= new JButton();
			botones[i].setFocusable(false);
			botones[i].setForeground(Color.white);
			botones[i].setBackground(Color.lightGray);
			
		}
		for (int i=0;i<etiqueta.length;i++) {
			etiqueta[i]= new JLabel();
			
		}
		frame.add(panel[0]);
		panel[0].setLayout(new GridLayout(3,3));
		
		panel[0].add(panel[1]);
		panel[0].add(panel[2]);
		panel[0].add(panel[3]);
		panel[0].add(panel[4]);
		panel[0].add(panel[5]);
		panel[0].add(panel[6]);
		panel[0].add(panel[7]);
		panel[0].add(panel[8]);
		panel[0].add(panel[9]);
		
		etiqueta[2].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[1].add(etiqueta[2]);
		etiqueta[3].setIcon(new javax.swing.ImageIcon("gif.gif"));
		panel[2].add(etiqueta[3]);	
		/*
		etiqueta[4].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[14].add(etiqueta[4]);
		etiqueta[5].setIcon(new javax.swing.ImageIcon("neptuno.gif"));
		panel[15].add(etiqueta[5]);
		panel[3].add(panel[14]);
		panel[13].add(panel[16]);
		panel[13].add(panel[17]);
		panel[3].add(panel[15]);
		*/
		//panel[12].add(etiqueta[4]);
		//PANEL 3
		panel[3].setLayout(new GridLayout(2,1));
		panel[3].add(panel[10]);
		panel[10].setBackground(Color.white);
		panel[3].add(panel[11]);
		panel[11].setBackground(Color.red);
		panel[10].setLayout(new GridLayout(1,2));
		panel[10].add(panel[12]);
		panel[12].setBackground(Color.pink);
		panel[10].add(panel[13]);
		panel[13].setBackground(Color.green);
		panel[13].setLayout(new GridLayout(2,1));
		panel[13].add(panel[14]);
		panel[14].setBackground(Color.blue);
		panel[13].add(panel[15]);
		panel[15].setBackground(Color.cyan);
		//PANEL 4
		panel[4].setLayout(new GridLayout(2,1));
		panel[4].add(panel[16]);
		panel[16].setBackground(Color.white);
		panel[4].add(panel[17]);
		panel[17].setBackground(Color.red);
		panel[16].setLayout(new GridLayout(1,2));
		panel[16].add(panel[18]);
		panel[18].setBackground(Color.pink);
		panel[16].add(panel[19]);
		panel[19].setBackground(Color.green);
		panel[19].setLayout(new GridLayout(2,1));
		panel[19].add(panel[20]);
		panel[20].setBackground(Color.blue);
		panel[19].add(panel[21]);
		panel[21].setBackground(Color.cyan);
		//PANEL 6
		panel[6].setLayout(new GridLayout(2,1));
		panel[6].add(panel[22]);
		panel[22].setBackground(Color.white);
		panel[6].add(panel[23]);
		panel[23].setBackground(Color.red);
		panel[22].setLayout(new GridLayout(1,2));
		panel[25].add(panel[24]);
		panel[24].setBackground(Color.pink);
		panel[22].add(panel[25]);
		panel[25].setBackground(Color.green);
		panel[25].setLayout(new GridLayout(2,1));
		panel[22].add(panel[26]);
		panel[26].setBackground(Color.blue);
		panel[22].add(panel[27]);
		panel[27].setBackground(Color.cyan);
		
		
		
		botones[5]=new RoundButton("AUTORDESTRUCTION");
		botones[5].setBackground(Color.red);
		botones[5].setForeground(Color.white);
		frame.setResizable(false);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
	
package Proyecto2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Reports {
	JFrame frame = new JFrame("Reports");
	JTabbedPane pestanas = new JTabbedPane();
	JPanel [] menu_panel = new JPanel [3];
	int num_batallas;
	String[] lista_batallas;
	
	//Caracteristicas army
	JPanel [] paneles_army = new JPanel [70];
	JButton exit_army = new JButton();
	JLabel [] labels_army = new JLabel[40];
	JComboBox opc_battle = new JComboBox();
	
	//Caracteristicas Resource report
	
	//Caracteristicas Battle Development
	
	Reports(String user, Connection con) throws SQLException{
		
		//Num batallas total
		this.num_batallas = getIDBattles(user, con);
		System.out.println(num_batallas);
		//Lista con las batallas {1,2,3,4,5,6} --> num_batallas = 6;
		this.lista_batallas = new String [this.num_batallas];
		for (int i=0; i< lista_batallas.length; i++) {
			lista_batallas[i] = String.valueOf(i+1);
			opc_battle.addItem(lista_batallas[i]);
		}
		
		
	//MENU INITAL ARMIES
		for (int i=0; i<menu_panel.length; i++) {
			menu_panel[i] = new JPanel();
			menu_panel[i].setBackground(Color.black);
		}
		
		menu_panel[0].setLayout(new GridLayout(10,7));
		
		exit_army.setBackground(Color.red);
		exit_army.setForeground(Color.black);
		exit_army.setText("Go Back");
		exit_army.setFocusable(false);
		exit_army.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});		
		for (int i=0; i<paneles_army.length; i++) {
			paneles_army[i] = new JPanel();
			paneles_army[i].setBackground(Color.black);
			menu_panel[0].add(paneles_army[i]);
		}
		paneles_army[69].add(exit_army);
		
		
		//Instancia de etiquetas
		for (int i=0; i<labels_army.length; i++) {
			labels_army[i] = new JLabel();
			labels_army[i].setBackground(Color.black);
			labels_army[i].setForeground(Color.white);
			labels_army[i].setVisible(true);
		}
		
		labels_army[0].setText("Select Battle");
		labels_army[1].setText("Army Planet");
		labels_army[2].setText("Units");
		labels_army[3].setText("Drops");
		labels_army[4].setText("Initial Army Enemy");
		labels_army[5].setText("Units");
		labels_army[6].setText("Drops");
		labels_army[7].setText("Light Hunter");
		labels_army[8].setText("");
		labels_army[9].setText("");
		labels_army[10].setText("Light Junter");
		labels_army[11].setText("");
		labels_army[12].setText("");
		labels_army[13].setText("Heavy Hunter");
		labels_army[14].setText("");
		labels_army[15].setText("");
		labels_army[16].setText("Heavy Hunter");
		labels_army[17].setText("");
		labels_army[18].setText("");
		labels_army[19].setText("Battle Ship");
		labels_army[20].setText("");
		labels_army[21].setText("");
		labels_army[22].setText("Battle Ship");
		labels_army[23].setText("");
		labels_army[24].setText("");
		labels_army[25].setText("Armored Ship");
		labels_army[26].setText("");
		labels_army[27].setText("");
		labels_army[28].setText("Armored Ship");
		labels_army[29].setText("");
		labels_army[30].setText("");
		labels_army[31].setText("Missile Launcher");
		labels_army[32].setText("");
		labels_army[33].setText("");
		labels_army[34].setText("Ion Cannon");
		labels_army[35].setText("");
		labels_army[36].setText("");
		labels_army[37].setText("Plasma Cannon");
		labels_army[38].setText("");
		labels_army[39].setText("");
		
		paneles_army[0].add(labels_army[0]);
		
		paneles_army[1].add(opc_battle);
		
		paneles_army[14].add(labels_army[1]);
		paneles_army[15].add(labels_army[2]);
		paneles_army[16].add(labels_army[3]);
		paneles_army[18].add(labels_army[4]);
		paneles_army[19].add(labels_army[5]);
		paneles_army[20].add(labels_army[6]);
		paneles_army[21].add(labels_army[7]);
		paneles_army[22].add(labels_army[8]);
		paneles_army[23].add(labels_army[9]);
		paneles_army[25].add(labels_army[10]);
		paneles_army[26].add(labels_army[11]);
		paneles_army[27].add(labels_army[12]);
		paneles_army[28].add(labels_army[13]);
		paneles_army[29].add(labels_army[14]);
		paneles_army[30].add(labels_army[15]);
		paneles_army[32].add(labels_army[16]);
		paneles_army[33].add(labels_army[17]);
		paneles_army[34].add(labels_army[18]);
		paneles_army[35].add(labels_army[19]);
		paneles_army[36].add(labels_army[20]);
		paneles_army[37].add(labels_army[21]);
		paneles_army[39].add(labels_army[22]);
		paneles_army[40].add(labels_army[23]);
		paneles_army[41].add(labels_army[24]);
		paneles_army[42].add(labels_army[25]);
		paneles_army[43].add(labels_army[26]);
		paneles_army[44].add(labels_army[27]);
		paneles_army[46].add(labels_army[28]);
		paneles_army[47].add(labels_army[29]);
		paneles_army[48].add(labels_army[30]);
		paneles_army[49].add(labels_army[31]);
		paneles_army[50].add(labels_army[32]);
		paneles_army[51].add(labels_army[33]);
		paneles_army[56].add(labels_army[34]);
		paneles_army[57].add(labels_army[35]);
		paneles_army[58].add(labels_army[36]);
		paneles_army[63].add(labels_army[37]);
		paneles_army[64].add(labels_army[38]);
		paneles_army[65].add(labels_army[39]);
		
		
		//FINAL
		opc_battle.setPreferredSize(new Dimension(45,20));
		pestanas.addTab("Initial Armies", menu_panel[0]);
		pestanas.addTab("Resources report", menu_panel[1]);
		pestanas.addTab("Battle Development", menu_panel[2]);
		frame.add(pestanas);
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		frame.setIconImage(img_icon);
		frame.setSize(1120,682);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		

	}
	
	public int getIDBattles(String user, Connection con) throws SQLException {
		int contador=0;
		int [] lista_id = new int[5];
		String query = "select count(id_battle) from battle where id_user = "
				+ "(select id_user from user_pw where username = '"+user+"') order by id_battle desc";
		Statement stmn = con.createStatement();
		ResultSet rs = stmn.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}

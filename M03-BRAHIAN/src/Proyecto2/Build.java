package Proyecto2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

public class Build{
	JFrame buildFrame = new JFrame("BUILD");
	JPanel [] paneles = new JPanel[52];
	JLabel [] listalabels = new JLabel[19];
	JLabel [] label_image = new JLabel[9];

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

		listalabels[0].setText("Build");
		listalabels[1].setText("Metal       "+ planeta.getMetal());
		listalabels[2].setText("Deuterium   "+planeta.getDeuterium());
		listalabels[3].setText("TROOPS");
		listalabels[4].setText("DEFENSES");
		listalabels[5].setText("Light Hunters");
		listalabels[6].setText("Cost");
		listalabels[7].setText("Missile Launcher");
		listalabels[8].setText("Cost");
		listalabels[9].setText("Heavy Hunters");
		listalabels[10].setText("Cost");
		listalabels[11].setText("Ion Cannon");
		listalabels[12].setText("Cost");
		listalabels[13].setText("  Battle Ship");
		listalabels[14].setText("Cost");
		listalabels[15].setText("Plasma Cannon");
		listalabels[16].setText("Cost");
		listalabels[17].setText("Armoured Ship");
		listalabels[18].setText("Cost");
		
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
		Image new_imgplas = img_plas.getScaledInstance(90, 60,  java.awt.Image.SCALE_SMOOTH);
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
		
		
		
		paneles[10].add(label_image[0]);
		paneles[20].add(label_image[1]);
		paneles[30].add(label_image[2]);
		paneles[40].add(label_image[3]);
		paneles[13].add(label_image[4]);
		paneles[23].add(label_image[5]);
		paneles[33].add(label_image[6]);
		paneles[50].add(label_image[7]);
		paneles[51].add(label_image[8]);
		
		
		paneles[2].add(listalabels[0]);
		paneles[50].add(listalabels[1]);
		paneles[51].add(listalabels[2]);
		paneles[5].add(listalabels[3]);
		paneles[8].add(listalabels[4]);
		paneles[10].add(listalabels[5]);
		paneles[11].add(listalabels[6]);
		paneles[13].add(listalabels[7]);
		paneles[14].add(listalabels[8]);
		paneles[20].add(listalabels[9]);
		paneles[21].add(listalabels[10]);
		paneles[23].add(listalabels[11]);
		paneles[24].add(listalabels[12]);
		paneles[30].add(listalabels[13]);
		paneles[31].add(listalabels[14]);
		paneles[33].add(listalabels[15]);
		paneles[34].add(listalabels[16]);
		paneles[40].add(listalabels[17]);
		paneles[41].add(listalabels[18]);


		
		
		
		
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		buildFrame.setIconImage(img_icon);
		buildFrame.setSize(1120,682);
		buildFrame.setLocationRelativeTo(null);
		buildFrame.setVisible(true);
		buildFrame.setResizable(false);
		
		
	}
	
	
}

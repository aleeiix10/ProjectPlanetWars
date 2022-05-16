package Proyecto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Build{
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

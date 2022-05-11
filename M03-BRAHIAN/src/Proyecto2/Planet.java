package Proyecto2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Planet {
	String planetName;
	int technologyDefense;
	int techonologyAttack;
	int metal;
	int deuterium;
	int upgradeDefenseTechologyDeuteriumCost;
	int upgradeAttackTechologyDeuteriumCost;
	ArrayList <MilitaryUnit> [] army = new ArrayList[7];
	/*Army[0] → arrayList de Ligth Hunter
	Army[1] → arrayList de Heavy Hunter
	Army[2] → arrayList de Battle Ship 
	Army[3] → arrayList de Armored Ship
	Army[4] → arrayList de Missile Launcher
	Army[5] → arrayList de Ion Cannon
	Army[6] → arrayList de Plasma Cannon*/
	Planet(String nombrePlaneta){
		this.planetName = nombrePlaneta;
		for (int i=0; i<army.length; i++) {
			army[i] = new ArrayList <MilitaryUnit>();
		}
	};
	
	public int getTechnologyDefense() {
		return technologyDefense;
	}
	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}
	public int getTechonologyAttack() {
		return techonologyAttack;
	}
	public void setTechonologyAttack(int techonologyAttack) {
		this.techonologyAttack = techonologyAttack;
	}
	public int getMetal() {
		return metal;
	}
	public void setMetal(int metal) {
		this.metal = metal;
	}
	public int getDeuterium() {
		return deuterium;
	}
	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}
	public int getUpgradeDefenseTechologyDeuteriumCost() {
		return upgradeDefenseTechologyDeuteriumCost;
	}
	public void setUpgradeDefenseTechologyDeuteriumCost(int upgradeDefenseTechologyDeuteriumCost) {
		this.upgradeDefenseTechologyDeuteriumCost = upgradeDefenseTechologyDeuteriumCost;
	}
	public int getUpgradeAttackTechologyDeuteriumCost() {
		return upgradeAttackTechologyDeuteriumCost;
	}
	public void setUpgradeAttackTechologyDeuteriumCost(int upgradeAttackTechologyDeuteriumCost) {
		this.upgradeAttackTechologyDeuteriumCost = upgradeAttackTechologyDeuteriumCost;
	}
	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}
	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	public void upgradeTechnologyDefense() throws ResourceException {
		int nivel =getTechnologyDefense();
		int coste = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
		int porcentaje = Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
		int costeTotal=coste+(nivel*coste*(porcentaje/100));
		if (costeTotal> getDeuterium()) {
			int recursos_que_faltan=costeTotal-getDeuterium();
			throw new ResourceException("You don't have the resources to upgrade tecnology defense, you need "+recursos_que_faltan+" more.");
		}
		else {
			setTechnologyDefense(nivel+1);
			setDeuterium(getDeuterium()-costeTotal);
			new PopUpPers("Your defense technology has been upgraded", "LevelUP.png",70,60);
			
		}
	}
	
	public void upgradeTechnologyAttack() throws ResourceException {
		int nivel =getTechonologyAttack();
		int coste = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
		int porcentaje = Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
		int costeTotal=coste+(nivel*coste*(porcentaje/100));
		if (costeTotal> getDeuterium()) {
			int recursos_que_faltan=costeTotal-getDeuterium();
			throw new ResourceException("You don't have the resources to upgrade tecnology attack, you need "+recursos_que_faltan+" more.");
		}
		else {
			setTechnologyDefense(nivel+1);
			setDeuterium(getDeuterium()-costeTotal);
			new PopUpPers("Your attack technology has been upgraded", "LevelUP.png",70,60);
			
		}
	}
	
	public void newLigthHunter(int n) throws ResourceException {
		int coste_deuter = Variables.DEUTERIUM_COST_LIGTHHUNTER;
		int coste_metal = Variables.METAL_COST_LIGTHHUNTER;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any Light Hunter");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_LIGTHHUNTER;
			int plus_dmg = Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_LIGTHHUNTER;
			int plus_armor = Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[0].add(new LigthHunter(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all LightHunters."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[0].add(new LigthHunter(final_armor, final_dmg));
				}
				new PopUpPers("LightHunters added succesfully","SOLDIER.png",60,50);
			}
		}
		
	}
	public void newHeavyHunter(int n) throws ResourceException{
		
		int coste_deuter = Variables.DEUTERIUM_COST_HEAVYHUNTER;
		int coste_metal = Variables.METAL_COST_HEAVYHUNTER;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any HeavyHunter");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_HEAVYHUNTER;
			int plus_dmg = Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_HEAVYHUNTER;
			int plus_armor = Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[1].add(new HeavyHunter(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all HeavyHunters."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[1].add(new HeavyHunter(final_armor, final_dmg));
				}
				new PopUpPers("HeavyHunter added succesfully","heavyHunter.png",60,50);
			}
		}
		
	}
	public void newBattleShip(int n) throws ResourceException {
		
		int coste_deuter = Variables.DEUTERIUM_COST_BATTLESHIP;
		int coste_metal = Variables.METAL_COST_BATTLESHIP;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any BattleShip");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_BATTLESHIP;
			int plus_dmg = Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_BATTLESHIP;
			int plus_armor = Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[2].add(new BattleShip(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all BattleShip."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[2].add(new BattleShip(final_armor, final_dmg));
				}
				new PopUpPers("BattleShip added succesfully","BattleShip.png",70,60);
			}
		}
		
	}
	public void newArmoredShip(int n) throws ResourceException {
		
		int coste_deuter = Variables.DEUTERIUM_COST_ARMOREDSHIP;
		int coste_metal = Variables.METAL_COST_ARMOREDSHIP;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any ArmoredShip");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_ARMOREDSHIP;
			int plus_dmg = Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_ARMOREDSHIP;
			int plus_armor = Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[3].add(new ArmoredShip(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all ArmoredShip."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[3].add(new ArmoredShip(final_armor, final_dmg));
				}
				new PopUpPers("ArmoredShip added succesfully","BattleShip.png",70,60);
			}
		}
		
	}
	
	
	public void newMissileLauncher(int n) throws ResourceException {
		int coste_deuter = Variables.DEUTERIUM_COST_MISSILELAUNCHER;
		int coste_metal = Variables.METAL_COST_MISSILELAUNCHER;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any MissileLauncher");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_MISSILELAUNCHER;
			int plus_dmg = Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_MISSILELAUNCHER;
			int plus_armor = Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[4].add(new MissileLauncher(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all MissileLauncher."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[4].add(new MissileLauncher(final_armor, final_dmg));
				}
				new PopUpPers("MissileLauncher added succesfully","missile.png",120,80);
			}
		}
		
	}
	public void newIonCannon(int n) throws ResourceException {
		
		int coste_deuter = Variables.DEUTERIUM_COST_IONCANNON;
		int coste_metal = Variables.METAL_COST_IONCANNON;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any IonCannon");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_IONCANNON;
			int plus_dmg = Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_IONCANNON;
			int plus_armor = Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[5].add(new IonCannon(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all IonCannon."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[5].add(new IonCannon(final_armor, final_dmg));
				}
				new PopUpPers("IonCannon added succesfully","ioncannon.png",70,60);
			}
		}
		
	}
	public void newPlasmaCannon(int n) throws ResourceException {
		
		int coste_deuter = Variables.DEUTERIUM_COST_PLASMACANNON;
		int coste_metal = Variables.METAL_COST_PLASMACANNON;
		
		if (getDeuterium() < coste_deuter || getMetal() < coste_metal) {
			throw new ResourceException("You dont't have the resources to add any PlasmaCannon");
		}
		else {
			int coste_total_deuter = (coste_deuter * n);
			int coste_total_metal = (coste_metal * n);
			//Daño y plus de damage
			int base_dmg = Variables.BASE_DAMAGE_PLASMACANNON;
			int plus_dmg = Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY;
			//Armadura y plus de armor
			int base_armor = Variables.ARMOR_PLASMACANNON;
			int plus_armor = Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY;
			//Armadura y Daño final
			int final_dmg = base_dmg + (getTechonologyAttack() * plus_dmg * 10);
			int final_armor = base_armor + (getTechnologyDefense() * plus_armor *10);
			
			//Caso que no tenga los recursos para meter a todos los soldados, solo algunos
			if (getDeuterium() < coste_total_deuter || getMetal() < coste_total_metal) {
				int contador=0;
				while (getDeuterium() >= coste_deuter && getMetal() >= coste_metal) {
					contador++;
					setDeuterium(getDeuterium()-coste_deuter);
					setMetal(getMetal()-coste_metal);
					army[6].add(new PlasmaCannon(final_armor,final_dmg));
				}
				
				throw new ResourceException("You need more resources to add all PlasmaCannon."
						+ " You were available to add only "+contador+"\n you have left "+
						getDeuterium()+" of Deuterium and "+getMetal()+" of Metal");
				
			}
			else {
				setDeuterium(getDeuterium()-coste_total_deuter);
				setMetal(getMetal()-coste_total_metal);
				for (int i=0; i<n;i++) {
					army[6].add(new PlasmaCannon(final_armor, final_dmg));
				}
				new PopUpPers("PlasmaCannon added succesfully","PlasmaCannon.png",90,60);
			}
		}
		
	}
	public void printStats() {
		JFrame mostrarDatos = new JFrame("Datos del Planeta");
		mostrarDatos.setLayout(new GridLayout(8,5));
		JPanel [] paneles = new JPanel[40];
		JLabel [] labels = new JLabel[16];
		JLabel [] label_image = new JLabel[11];
		JButton bt_salir = new JButton();
		
		
		//for para instanciar los paneles y incluirlos al JFrame
		for (int i=0;i<paneles.length;i++) {
			paneles[i] = new JPanel();
			paneles[i].setBackground(Color.black);
			paneles[i].setLayout(new BorderLayout());
			mostrarDatos.add(paneles[i]);
		}	
		//for para incluir las labels con sus respectivos fondos
		for (int i=0;i<labels.length;i++) {
			labels[i] = new JLabel();
			labels[i].setBackground(Color.black);
			labels[i].setForeground(Color.white);
		}
		
		//for para incluir los image_labels a la lista
		for (int i=0;i<label_image.length;i++) {
			label_image[i] = new JLabel();
			label_image[i].setBackground(Color.black);
		}
		
		//Boton para salir del menu de Datos del planeta
			bt_salir.setText("Go Back");
			bt_salir.setBackground(new Color(225, 201, 134));
			bt_salir.setForeground(Color.black);
			bt_salir.setFocusable(false);
			bt_salir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarDatos.dispose();
				}
			});
			paneles[4].setLayout(new FlowLayout());
			paneles[4].add(bt_salir);
		
		int lvlatt = getTechonologyAttack();
		int lvldef = getTechnologyDefense();
		int num_light = army[0].size();
		int num_heavy = army[1].size();
		int num_battle = army[2].size();
		int num_armor = army[3].size();
		int num_missile = army[4].size();
		int num_ion = army[5].size();
		int num_plasma = army[6].size();
		
		Image img_icon = new ImageIcon("iconoTotal.png").getImage();
		
		Image img_sold = new ImageIcon("SOLDIER.png").getImage();
		Image new_imgsoldier = img_sold.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon soldiers = new ImageIcon(new_imgsoldier);
		label_image[0].setIcon(soldiers);
		
		Image img_heavy = new ImageIcon("heavyHunter.png").getImage();
		Image new_imgheavy = img_heavy.getScaledInstance(80, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon heavy = new ImageIcon(new_imgheavy);
		label_image[9].setIcon(heavy);
		
		Image img_ship = new ImageIcon("BattleShip.png").getImage();
		Image new_imgship = img_ship.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon ships = new ImageIcon(new_imgship);
		label_image[1].setIcon(ships);
		
		Image img_armor = new ImageIcon("BattleShip.png").getImage();
		Image new_imgarmor = img_armor.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon armor = new ImageIcon(new_imgarmor);
		label_image[8].setIcon(armor);
		
		Image img_miss = new ImageIcon("missile.png").getImage();
		Image new_imgmis = img_miss.getScaledInstance(60, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon missile = new ImageIcon(new_imgmis);
		label_image[2].setIcon(missile);
		
		Image img_ion = new ImageIcon("ioncannon.png").getImage();
		Image new_imgion = img_ion.getScaledInstance(70, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon ion = new ImageIcon(new_imgion);
		label_image[3].setIcon(ion);
		
		Image img_plas = new ImageIcon("PlasmaCannon.png").getImage();
		Image new_imgplas = img_plas.getScaledInstance(90, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon plasma = new ImageIcon(new_imgplas);
		label_image[4].setIcon(plasma);

		Image img_metal = new ImageIcon("metal.png").getImage();
		Image new_imgmetal = img_metal.getScaledInstance(45, 30,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon metal = new ImageIcon(new_imgmetal);
		label_image[5].setIcon(metal);

		Image img_deut = new ImageIcon("deuterium.png").getImage();
		Image new_imgdeut = img_deut.getScaledInstance(50, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon deuterium = new ImageIcon(new_imgdeut);
		label_image[6].setIcon(deuterium);

		Image img_tech = new ImageIcon("attack_tech.png").getImage();
		Image new_imgtech = img_tech.getScaledInstance(80, 40,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon technology = new ImageIcon(new_imgtech);
		label_image[7].setIcon(technology);
		
		Image img_tech_DEF = new ImageIcon("defense_tech.png").getImage();
		Image new_imgtech_def = img_tech_DEF.getScaledInstance(70, 60,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon technology_def = new ImageIcon(new_imgtech_def);
		label_image[10].setIcon(technology_def);
		
		
		labels[0].setText("             PLANET STATS");
		labels[1].setText("Technology");
		labels[2].setText("Fleet");
		labels[3].setText("Attack Technology: "+lvlatt);
		labels[4].setText("Light Hunter: " + num_light);
		labels[5].setText("Defense Technology: "+lvldef);
		labels[6].setText("Heavy Hunter: "+ num_heavy);
		labels[7].setText("Defenses");
		labels[8].setText("Battle Ship: "+num_battle);
		labels[9].setText("Missile Launcher: "+num_missile);
		labels[10].setText("Armored Ship: "+num_armor);
		labels[11].setText("Ion Cannon: "+num_ion);
		labels[12].setText("Resources");
		labels[13].setText("Plasma Cannon: "+num_plasma);
		labels[14].setText("Metal: "+ getMetal());
		labels[15].setText("Deuterium: "+getDeuterium());
		
		//Labels de los paneles
		paneles[2].add(labels[0],BorderLayout.CENTER);
		paneles[5].add(labels[1],BorderLayout.CENTER);
		paneles[8].add(labels[2],BorderLayout.CENTER);
		paneles[11].add(labels[3],BorderLayout.CENTER);
		paneles[14].add(labels[4],BorderLayout.CENTER);
		paneles[16].add(labels[5],BorderLayout.CENTER);
		paneles[19].add(labels[6],BorderLayout.CENTER);
		paneles[20].add(labels[7],BorderLayout.CENTER);
		paneles[24].add(labels[8],BorderLayout.CENTER);
		paneles[26].add(labels[9],BorderLayout.CENTER);
		paneles[29].add(labels[10],BorderLayout.CENTER);
		paneles[31].add(labels[11],BorderLayout.CENTER);
		paneles[33].add(labels[12],BorderLayout.CENTER);
		paneles[36].add(labels[13],BorderLayout.CENTER);
		
		//Panel de resources
		paneles[38].setLayout(new GridLayout(2,1));
		paneles[38].add(label_image[5]);
		paneles[38].add(label_image[6]);
		
		paneles[39].setLayout(new GridLayout(2,1));
		paneles[39].add(labels[14]);
		paneles[39].add(labels[15]);

		
		
		//ponerle las image_labels a los paneles
		paneles[10].add(label_image[7],BorderLayout.CENTER);
		paneles[15].add(label_image[10],BorderLayout.CENTER);
		paneles[13].add(label_image[0],BorderLayout.CENTER);
		paneles[18].add(label_image[9],BorderLayout.CENTER);
		paneles[25].add(label_image[2],BorderLayout.CENTER);
		paneles[23].add(label_image[1],BorderLayout.CENTER);
		paneles[28].add(label_image[8],BorderLayout.CENTER);
		paneles[30].add(label_image[3],BorderLayout.CENTER);
		paneles[35].add(label_image[4],BorderLayout.CENTER);

		
		mostrarDatos.setIconImage(img_icon);
		mostrarDatos.setSize(1120,682);
		mostrarDatos.setLocationRelativeTo(null);
		mostrarDatos.setVisible(true);
		mostrarDatos.setResizable(false);
		
		
	}
}

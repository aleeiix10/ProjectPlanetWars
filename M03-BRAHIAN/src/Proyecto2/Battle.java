package Proyecto2;

import java.util.ArrayList;

public class Battle {
	private ArrayList <MilitaryUnit> [] enemyArmy; //→ para almacenar la flota enemiga.
	
	private ArrayList <MilitaryUnit> [] planetArmy; // para almacenar la flota de nuestro planeta
	
	private ArrayList[][] armies; //almacenaremos nuestro ejercito en la primera fila,
						//y el ejercito enemigo en la segunda fila;

	private String battleDevelopment;
	
	private int[][] initialCostFleet;//el coste de metal y deuterio de los ejercitos iniciales 
	
	//La batalla termina si uno de los 2 tiene menos de un 20% del ejercito inicial
	private int initialNumberUnitsPlanet;
	private int initialNumberUnitsEnemy;
	
	private int[] wasteMetalDeuterium; //Residuos [Metal,Deuterium], asumo que la suma del coste de matar una unidad
	
	//Perdidas materiales de cada ejercito para reportes
	private int[] enemyDrops = new int[2]; 
	private int[] planetDrops = new int[2];
	
	/*
	   → array de dos filas y tres columnas,  resourcesLooses[0] = {perdidas metal planeta, perdidas deuterio planeta, 
	    perdidas metal planeta + 5* perdidas deuterio planeta}, resourcesLooses[1] lo mismo pero para el ejercito 
	    enemigo.
		Lo de multiplicar por 5 las pérdidas de deuterio, es debido al mayor valor de este material.
	 	Para decidir el ganador, será que que tenga el numero menor en la tercera columna.
	 	ResourcesLooses[0][2] y ResourcesLooses[1][2], que representan las pérdidas ponderadas.
	 */
	private int[][] resourcesLooses;
	
	
	private int[][] initialArmies;   //Array de 2*7 que cuantifica cada tipo de unidad de los ejercitos iniciales
	
	private int[] actualNumberUnitsPlanet;
	private int[] actualNumberUnitsEnemy;
	//Array igual que initialArmies pero por separado y de las unidades actuales
	
	public Battle(ArrayList <MilitaryUnit> [] planetArmy,int metal,int deuterium,int lvl_att,int lvl_def) {
		this.planetArmy = planetArmy;
		this.enemyArmy = createEnemyFleet(metal, deuterium, lvl_att, lvl_def);
		enemyDrops[0] = 0;
		enemyDrops[1] = 0;
		planetDrops[0] = 0;
		planetDrops[1] = 0;
		
	}
	public void setArmies(ArrayList <MilitaryUnit> [] planetArmy, ArrayList <MilitaryUnit> [] enemyArmy) {
		ArrayList[][] armi2 = {planetArmy,enemyArmy};
		this.armies = armi2;
	}
	public ArrayList[][] getArmies(){
		return this.armies;
	}
	
	//metodo para crear el enemyArmy, por variables de entrada tiene el metal, deuterium i el nivel de las tecnologias para adaptar la dificultad 
	public ArrayList <MilitaryUnit> [] createEnemyFleet(int metal,int deuterium,int lvl_att, int lvl_def){
		int num_random;
		//el array enemyFleet: [arrayListLightHunter, arrayListHeavyHunter, arrayListBattleShip, arrayListArmoredShip]
		ArrayList <MilitaryUnit> [] enemyFleet = new ArrayList[4];
		enemyFleet[0] = new ArrayList <MilitaryUnit>();
		enemyFleet[1] = new ArrayList <MilitaryUnit>();
		enemyFleet[2] = new ArrayList <MilitaryUnit>();
		enemyFleet[3] = new ArrayList <MilitaryUnit>();
		
		

		
		while (metal >= Variables.METAL_COST_LIGTHHUNTER && deuterium >= Variables.DEUTERIUM_COST_LIGTHHUNTER) {
			
			//numero random entre 0 i 3
			num_random = (int)(Math.random()*101);
			
			if (num_random >= 0 && num_random<35) {
				int plus_AttTech = Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY;
				int plus_DefTech = Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY;
				
				metal = metal - Variables.METAL_COST_LIGTHHUNTER;
				deuterium = deuterium - Variables.DEUTERIUM_COST_LIGTHHUNTER;
				
				enemyFleet[0].add(new LigthHunter((Variables.BASE_DAMAGE_LIGTHHUNTER + (lvl_att * plus_AttTech * 10)),
						(Variables.ARMOR_LIGTHHUNTER + (lvl_def * plus_DefTech * 10))));
			}
			else if (num_random>=35 && num_random<60 && metal >= Variables.METAL_COST_HEAVYHUNTER && deuterium >= Variables.DEUTERIUM_COST_HEAVYHUNTER) {
				int plus_AttTech = Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
				int plus_DefTech = Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
				
				metal = metal - Variables.METAL_COST_HEAVYHUNTER;
				deuterium = deuterium - Variables.DEUTERIUM_COST_HEAVYHUNTER;
				
				enemyFleet[1].add(new HeavyHunter((Variables.BASE_DAMAGE_HEAVYHUNTER + (lvl_att * plus_AttTech * 10)),
						(Variables.ARMOR_HEAVYHUNTER + (lvl_def * plus_DefTech * 10))));
			}
			else if (num_random >= 60 && num_random<80 && metal >= Variables.METAL_COST_BATTLESHIP && deuterium >= Variables.DEUTERIUM_COST_BATTLESHIP) {
				int plus_AttTech = Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY;
				int plus_DefTech = Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY;
				
				metal = metal - Variables.METAL_COST_BATTLESHIP;
				deuterium = deuterium - Variables.DEUTERIUM_COST_BATTLESHIP;
				
				enemyFleet[2].add(new BattleShip((Variables.BASE_DAMAGE_BATTLESHIP + (lvl_att * plus_AttTech * 10)),
						(Variables.ARMOR_BATTLESHIP + (lvl_def * plus_DefTech * 10))));
			}
			else if (num_random >= 80 && num_random <=100 && metal >= Variables.METAL_COST_ARMOREDSHIP && deuterium >= Variables.DEUTERIUM_COST_ARMOREDSHIP){
				int plus_AttTech = Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY;
				int plus_DefTech = Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY;
				
				metal = metal - Variables.METAL_COST_ARMOREDSHIP;
				deuterium = deuterium - Variables.DEUTERIUM_COST_ARMOREDSHIP;
				
				enemyFleet[3].add(new ArmoredShip((Variables.BASE_DAMAGE_ARMOREDSHIP + (lvl_att * plus_AttTech * 10)),
						(Variables.ARMOR_ARMOREDSHIP + (lvl_def * plus_DefTech * 10))));
			}	
			
		}

		return enemyFleet;
	}
	
	//Rellena la lista initialArmies y initialNumberUnitsPlanet/enemy 
	public void initInitialArmies() {
		int [] num_enemies = new int [4];
		int num_totalEnemies = 0;
		int [] num_alies = new int [7];
		int num_totalAlies = 0;
		//For que cuenta el número de enemigos y los añade a la lista num_enemies
		for(int i=0; i<enemyArmy.length;i++) {
			num_enemies[i] = enemyArmy[i].size();
			num_totalEnemies = num_totalEnemies + enemyArmy[i].size();
		}
		
		for(int i=0; i<planetArmy.length;i++) {
			num_alies[i] = planetArmy[i].size();
			num_totalAlies = num_totalAlies + planetArmy[i].size();

		}
		int [][] armies =  {num_alies,num_enemies};
		
		this.initialNumberUnitsEnemy = num_totalEnemies;
		this.initialNumberUnitsPlanet = num_totalAlies;
		this.initialArmies = armies;
	}
	
	//team=0 indica que army se refiere a planet, team != 1 significa que se refiere a enemies 
	public int remainderPercentageFleet (ArrayList<MilitaryUnit>[] army,int team) {
		int num_totalUnits = 0;
		//For que cuenta el número de tropas restantes y los añade a num_totalUnits
		for(int i=0; i<army.length;i++) {
			num_totalUnits = num_totalUnits + army[i].size();
		}
		//Caso en el que se refiera a Planet
		if(team == 0) {
			return (num_totalUnits/this.initialNumberUnitsPlanet)*100;
		}
		else {
			return (num_totalUnits/this.initialNumberUnitsEnemy)*100;
		}

	}
	
	
	public int[] fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		int cost_metal = 0, cost_deuter = 0;
		for (int i=0; i<army.length;i++) {
			cost_deuter = cost_deuter + army[i].size() * Variables.DEUTERIUM_COST_UNITS[i];
			cost_metal = cost_metal + army[i].size() * Variables.METAL_COST_UNITS[i];
		}
		int[] cost_fleet = {cost_metal,cost_deuter};
		return cost_fleet;
	}
	
	public void setinitialCostFleet() {
		int [][] lista = {fleetResourceCost(planetArmy),fleetResourceCost(enemyArmy)};
		this.initialCostFleet = lista;
	}
	
	public int getGroupAttacker(ArrayList<MilitaryUnit>[] army, int team) {
		//genera numero random entre 0 i 100
		int num_random = (int)(Math.random()*101);
		
		//Cas de Planet
		if (team == 0) {
			if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 0;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[1] + Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 1;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[2] + Variables.CHANCE_ATTACK_PLANET_UNITS[1] + Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 2;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[3] + Variables.CHANCE_ATTACK_PLANET_UNITS[2] + Variables.CHANCE_ATTACK_PLANET_UNITS[1] + Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 3;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[4] + Variables.CHANCE_ATTACK_PLANET_UNITS[3] + Variables.CHANCE_ATTACK_PLANET_UNITS[2] + Variables.CHANCE_ATTACK_PLANET_UNITS[1] + Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 4;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_PLANET_UNITS[5] + Variables.CHANCE_ATTACK_PLANET_UNITS[4] + Variables.CHANCE_ATTACK_PLANET_UNITS[3] + Variables.CHANCE_ATTACK_PLANET_UNITS[2] + Variables.CHANCE_ATTACK_PLANET_UNITS[1] + Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
				return 5;
			}
			else {
				return 6;
			}
		}
		//Cas de Enemy
		else {
			if (num_random<=Variables.CHANCE_ATTACK_ENEMY_UNITS[0]) {
				return 0;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_ENEMY_UNITS[1] + Variables.CHANCE_ATTACK_ENEMY_UNITS[0]) {
				return 1;
			}
			else if (num_random<=Variables.CHANCE_ATTACK_ENEMY_UNITS[2] + Variables.CHANCE_ATTACK_ENEMY_UNITS[1] + Variables.CHANCE_ATTACK_ENEMY_UNITS[0]) {
				return 2;
			}
			else {
				return 3;
			}

		}
	}
	
	public boolean probWaste(int num_groupFleet) {
		int num_random = (int)(Math.random()*101);
		if (num_groupFleet == 0) {
			if (Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER >= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 1) {
			if (Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER>= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 2) {
			if (Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP>= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 3) {
			if (Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP>= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 4) {
			if (Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER>= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 5) {
			if (Variables.CHANCE_GENERATNG_WASTE_IONCANNON>= num_random) {
				return true;
			}
			return false;
		}
		else{
			if (Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON>= num_random) {
				return true;
			}
			return false;
		}
	}
	
	public boolean probDoubleAttack(int num_groupFleet) {
		int num_random = (int)(Math.random()*101);
		if (num_groupFleet == 0) {
			if (Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER >= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 1) {
			if (Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER >= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 2) {
			if (Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP >= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 3) {
			if (Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP >= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 4) {
			if (Variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER>= num_random) {
				return true;
			}
			return false;
		}
		else if (num_groupFleet == 5) {
			if (Variables.CHANCE_ATTACK_AGAIN_IONCANNON>= num_random) {
				return true;
			}
			return false;
		}
		else{
			if (Variables.CHANCE_ATTACK_AGAIN_PLASMACANNON>= num_random) {
				return true;
			}
			return false;
		}
	}
	
	public int getGroupDefender (ArrayList<MilitaryUnit>[] army, int team) {
		//genera numero random entre 0 i 100
		int num_random = (int)(Math.random()*101);
		
		//contador de tropas totales, se guardan en num_total
		int num_total = 0;
		for (int i=0;i<army.length;i++) {
			num_total = num_total + army[i].size();
		}
		
		//Cas de Planet
		if (team == 0) {
			//llista on es guarden les probabilitats de que surtin cada tropa
			int [] listaProb = new int[7];
			//for que omple la llista prob amb les probabilitats
			for (int i=0;i<army.length; i++) {
				listaProb[i] =(int) ((100 * (army[i].size())) / num_total);
			}
			int num_prob = 0;
			for (int i=0;i<listaProb.length; i++) {
				num_prob = num_prob + listaProb[i];
				if (num_random <= num_prob) {
					return i;
				}
			}
			return -1;
			
		}
		else {
			int [] listaProb = new int[4];
			//for que omple la llista prob amb les probabilitats
			for (int i=0;i<army.length; i++) {
				listaProb[i] =(int) ((100 * (army[i].size())) / num_total);
			}
			int num_prob = 0;
			for (int i=0;i<listaProb.length; i++) {
				num_prob = num_prob + listaProb[i];
				if (num_random <= num_prob) {
					return i;
				}
			}
			return -1;
		}
		
	}
	
	//Para generar array de pérdidas totales
	public void updateResourcesLooses() {
		int [] totalWaste = {this.enemyDrops[0]+this.planetDrops[0], this.enemyDrops[1]+this.planetDrops[1]};
		this.wasteMetalDeuterium = totalWaste;
		
		int [] loosesEnemy = {this.enemyDrops[0], this.enemyDrops[1], (this.enemyDrops[0] + (5*this.enemyDrops[1]))};
		int [] loosesPlanet = {this.planetDrops[0], this.planetDrops[1], (this.planetDrops[0] + (5*this.planetDrops[1]))};
		int [][] resLooses = {loosesPlanet, loosesEnemy};
		this.resourcesLooses = resLooses;
	}
	
	public int[] getfleetDrops(int team) {
		if (team==0) {
			return this.planetDrops;
		}
		else {
			return this.enemyDrops;
		}
	}
	
	public void setfleetDrops(int num_fleet, int team) {
		if (team == 1) {
			this.enemyDrops[0] = this.enemyDrops[0] + (int)(Variables.METAL_COST_UNITS[num_fleet] * 0.7);
			this.enemyDrops[1] = this.enemyDrops[1] + (int)(Variables.DEUTERIUM_COST_UNITS[num_fleet] * 0.7);
		}
		else if (team == 0) {
			this.planetDrops[0] = this.planetDrops[0] + (int)(Variables.METAL_COST_UNITS[num_fleet] * 0.7);
			this.planetDrops[1] = this.planetDrops[1] + (int)(Variables.DEUTERIUM_COST_UNITS[num_fleet] * 0.7);
		}
	}
	
	public void setActualNumberUnits(ArrayList<MilitaryUnit>[] army, int team) {
		
		if (team == 0) {
			int [] listaUnits = new int [7];
			for(int i=0; i<army.length;i++) {
				listaUnits[i] = army[i].size();
			}
			this.actualNumberUnitsPlanet = listaUnits;
		}
		else if(team == 1) {
			int [] listaUnits = new int [4];
			for(int i=0; i<army.length;i++) {
				listaUnits[i] = army[i].size();
			}
			this.actualNumberUnitsEnemy = listaUnits;
		}
		
	}
	
	public int[] getActualNumberUnits(int team) {
		if (team == 0) {
			return this.actualNumberUnitsPlanet;
		}
		else {
			return this.actualNumberUnitsEnemy;
		}
	}
	
	
	
	public void LOLPlayers() {
		setArmies(planetArmy, enemyArmy);
		initInitialArmies();
		setinitialCostFleet();
		
		
		
		int turno = (int)(Math.random()*2);
		String development="START THE BATTLE\n";
		while (remainderPercentageFleet(enemyArmy,1) >= 20 ||  remainderPercentageFleet(planetArmy,0) >= 20) {
			//Turno de ataque de PLANET
			if (turno == 0) {
				
				//grupo(LightHunter, HeavyHunter...)
				int group_att = 0, num_attFleet;
				while(true) {
					group_att = getGroupAttacker(planetArmy, 0);
					if (planetArmy[group_att].size() != 0) {
						break;
					}
				}
				
				
				//una vez escogido el grupo atacante, el numero de tropa
				num_attFleet = (int)(Math.random()*planetArmy[group_att].size());
				
				
				do {
				
				int group_def = 0;
				while(true) {
					group_def = getGroupDefender(enemyArmy, 1);
					if (enemyArmy[group_def].size() != 0) {
						break;
					}
				}
				
				
				int num_defFleet = (int)(Math.random()*enemyArmy[group_def].size());
				
				//Cogemos a los objetos que pelearán como tal
				MilitaryUnit attacker = planetArmy[group_att].get(num_attFleet);
				MilitaryUnit defender = enemyArmy[group_def].get(num_defFleet);
				
				development += "Attacks Planet: "+ attacker.toString() + " attacks " + defender.toString()+"\n";
				
				//Se le resta el damage a su armor
				defender.takeDamage(attacker.attack());
				
				development += attacker.toString()+" generates the damage = " + attacker.attack()+"\n";
				development += defender.toString()+" stays with armor = "+ defender.getActualArmor()+"\n";
				
				//Caso en el que elimine al defensor
				if (defender.getActualArmor()<=0) {
					development += defender.toString() + " was defeated\n";
					//Caso que se de la probabilidad de que se creen residuos
					if (probWaste(group_def)) {
						setfleetDrops(group_def, 1);
					}
					enemyArmy[group_def].remove(num_defFleet);
				}
				}while(probDoubleAttack(group_att));
				turno += 1;
			}
			//Turno de ataque de ENEMY
			else if(turno == 1){
				
				//grupo(LightHunter, HeavyHunter...)
				int group_att = getGroupAttacker(enemyArmy, 1);
				
				
				//una vez escogido el grupo atacante, el numero de tropa
				int num_attFleet = (int)(Math.random()*enemyArmy[group_att].size());
				
				do {
				int group_def = getGroupDefender(planetArmy, 0);
				int num_defFleet = (int)(Math.random()*planetArmy[group_def].size());
				
				//Cogemos a los objetos que pelearán como tal
				MilitaryUnit attacker = enemyArmy[group_att].get(num_attFleet);
				MilitaryUnit defender = planetArmy[group_def].get(num_defFleet);
				
				development += "Attacks Enemy Fleet: "+ attacker.toString() + " attacks " + defender.toString()+"\n";
				
				//Se le resta el damage a su armor
				defender.takeDamage(attacker.attack());
				
				development += attacker.toString()+" generates the damage = " + attacker.attack()+"\n";
				development += defender.toString()+" stays with armor = "+ defender.getActualArmor()+"\n";
				
				//Caso en el que elimine al defensor
				if (defender.getActualArmor()<=0) {
					development += defender.toString() + " was defeated\n";
					//Caso que se de la probabilidad de que se creen residuos
					if (probWaste(group_def)) {
						setfleetDrops(group_def, 0);
					}
					planetArmy[group_def].remove(num_defFleet);
				}
				}while(probDoubleAttack(group_att));
				turno -= 1;
			}
			development += ("\n*******************CHANGE ATTACKER********************\n");
		}
		//Rellena las listas wasteMetalDeuterium y resourceLooses
		updateResourcesLooses();
		development = development.substring(0,development.length()-56);
		
		//Significa que gana Planet
		if (resourcesLooses[0][2] < resourcesLooses[1][2]) {
			development += "\n                     PLANET WINS";
		}
		else {
			development += "\n                     ENEMY WINS";
		}
		
		this.battleDevelopment = development;
	}
	
	public String getDevelopment() {
		return this.battleDevelopment;
	}
	
	
}
	


package Proyecto2;

import java.util.ArrayList;

public class Battle {
	ArrayList <MilitaryUnit> [] enemyArmy; //→ para almacenar la flota enemiga.
	
	ArrayList <MilitaryUnit> [] planetArmy; // para almacenar la flota de nuestro planeta
	
	ArrayList[][] armies; //almacenaremos nuestro ejercito en la primera fila,
						//y el ejercito enemigo en la segunda fila;

	String battleDevelopment;
	
	int[][] initialCostFleet;//el coste de metal y deuterio de los ejercitos iniciales 
	
	//La batalla termina si uno de los 2 tiene menos de un 20% del ejercito inicial
	int initialNumberUnitsPlanet;
	int initialNumberUnitsEnemy;
	
	int[] wasteMetalDeuterium; //Residuos [Metal,Deuterium], asumo que la suma del coste de matar una unidad
	
	//Perdidas materiales de cada ejercito para reportes
	int[] enemyDrops; 
	int[] planetDrops;
	
	/*
	   → array de dos filas y tres columnas,  resourcesLooses[0] = {perdidas metal planeta, perdidas deuterio planeta, 
	    perdidas metal planeta + 5* perdidas deuterio planeta}, resourcesLooses[1] lo mismo pero para el ejercito 
	    enemigo.
		Lo de multiplicar por 5 las pérdidas de deuterio, es debido al mayor valor de este material.
	 	Para decidir el ganador, será que que tenga el numero menor en la tercera columna.
	 	ResourcesLooses[0][2] y ResourcesLooses[1][2], que representan las pérdidas ponderadas.
	 */
	int[][] resourcesLooses;
	
	
	int[][] initialArmies;   //Array de 2*7 que cuantifica cada tipo de unidad de los ejercitos iniciales
	
	int[] actualNumberUnitsPlanet;
	int[] actualNumberUnitsEnemy;
	//Array igual que initialArmies pero por separado y de las unidades actuales
	
	public Battle(ArrayList <MilitaryUnit> [] planetArmy,int metal,int deuterium,int lvl_att,int lvl_def) {
		this.planetArmy = planetArmy;
		this.enemyArmy = createEnemyFleet(metal, deuterium, lvl_att, lvl_def);
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
		//For que cuenta el número de enemigos y los añade a num_totalUnits
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
	
	//Para generar array de pérdidas
	public void updateResourcesLooses() {
		System.out.println("Implementar");
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
	
}

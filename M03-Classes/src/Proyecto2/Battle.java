package Proyecto2;

import java.util.ArrayList;

public class Battle {
	ArrayList <MilitaryUnit> [] enemyArmy = new ArrayList[7]; //→ para almacenar 
													//la flota de nuestro planeta.
	ArrayList <MilitaryUnit> [] planetArmy; //→ para almacenar la flota enemiga
	
	ArrayList[][] armies; //almacenaremos nuestro ejército en la primera fila,
						//y el ejército enemigo en la segunda fila;

	String battleDevelopment;
	int[][] initialCostFleet;//→ coste de metal deuterio de los ejercitos iniciales 
	
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
	
	public Battle(ArrayList <MilitaryUnit> [] planetArmy) {
		this.planetArmy = planetArmy;
	}
	
}

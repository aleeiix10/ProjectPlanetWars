package Proyecto2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ResourceException {
		
		if (1<2) {
			Planet a = new Planet("Pito");
			a.setDeuterium(15000);
			a.setMetal(301000);
			a.setTechonologyAttack(3);
			a.setTechnologyDefense(2);
			a.newLigthHunter(3);
			a.newHeavyHunter(2);
			a.newBattleShip(2);
			a.printStats();
			
			Battle batalla = new Battle(a.getArmy(),Variables.METAL_BASE_ENEMY_ARMY, Variables.DEUTERIUM_BASE_ENEMY_ARMY,2,1);
			batalla.LOLPlayers();
			System.out.println(batalla.getDevelopment());
			
			//a.newBattleShip(1);
			//throw new ResourceException("You don't have the resources");
		}
	}

}

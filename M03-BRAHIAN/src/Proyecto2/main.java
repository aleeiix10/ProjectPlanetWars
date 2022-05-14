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
			//a.newLigthHunter(3);
			//a.newHeavyHunter(2);
			//a.newBattleShip(2);
			
			new Build(a);
			
			//a.newBattleShip(1);
			//throw new ResourceException("You don't have the resources");
		}


	}
}
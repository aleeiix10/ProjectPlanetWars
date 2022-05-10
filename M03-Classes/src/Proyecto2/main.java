package Proyecto2;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		if (1<2) {
			Planet a = new Planet();
			a.setDeuterium(15000);
			a.setMetal(301000);
			a.setTechonologyAttack(3);
			a.setTechnologyDefense(2);
			a.printStats();
			//a.newBattleShip(1);
			//throw new ResourceException("You don't have the resources");
		}
	}

}

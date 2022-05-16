package Proyecto2;

import java.sql.SQLException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws ResourceException, SQLException {
		
		if (1<2) {
			Planet a = new Planet("Pito");
			a.setDeuterium(15000);
			a.setMetal(301000);
			a.setTechonologyAttack(3);
			a.setTechnologyDefense(2);
			
			//INTERFAZ THREADS
			//Battle b = new Battle(a.getArmy(),180000,26000,3,2);
			//b.initInitialArmies();
			//Thread t  = new Thread(b.getInitialArmies(),a);
			
			//AÑADIR UNIDADES
			//a.newLigthHunter(3);
			//a.newHeavyHunter(2);
			//a.newBattleShip(2);
			
			//INTEFAZ BUILD
			//new Build(a);
			
			//INTERFAZ REPORTS
			Conexion db=new Conexion("jdbc:oracle:thin:@192.168.40.2:1521:orcl","alumnoAMS5","alumnoAMS5");	
			new Reports("brahian", db.getCn());

		}


	}
}
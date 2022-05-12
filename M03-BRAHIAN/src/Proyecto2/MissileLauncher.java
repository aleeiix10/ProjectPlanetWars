package Proyecto2;

public class MissileLauncher extends Defense implements MilitaryUnit{
	
	private int armadura_plus = Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY;
	private int dano_plus = Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY;
	
	MissileLauncher(int armor,int baseDamage){
		super(armor, baseDamage);
	}

	@Override
	public int attack() {
		return getBaseDamage();
	}

	@Override
	public void takeDamage(int receivedDamage) {
		setArmor(getArmor()-receivedDamage);
	}

	@Override
	public int getActualArmor() {
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		return Variables.METAL_COST_MISSILELAUNCHER;
	}

	@Override
	public int getDeuteriumCost() {
		return Variables.DEUTERIUM_COST_MISSILELAUNCHER;
	}

	@Override
	public int getChanceGeneratinWaste() {
		int porcentaje=Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		int porcentaje=Variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
	}
	
	@Override
	public String toString() {
		return "Missile Launcher";
	}
	
}

package Proyecto2;

public class LigthHunter extends Ship implements MilitaryUnit{
	
	private int armadura_plus = Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY;
	private int dano_plus = Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY;
	
	LigthHunter(int armor,int baseDamage){
		super(armor, baseDamage);
	}
	
	LigthHunter() {
		super(Variables.ARMOR_LIGTHHUNTER, Variables.BASE_DAMAGE_LIGTHHUNTER);
	};
	
	
	@Override
	public int attack() {
		return getBaseDamage();
	}

	@Override
	public void takeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
	}

	@Override
	public int getActualArmor() {
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		return Variables.METAL_COST_LIGTHHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		return Variables.DEUTERIUM_COST_LIGTHHUNTER;
	}

	@Override
	public int getChanceGeneratinWaste() {
		int porcentaje=Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		int porcentaje=Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER;
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
		return "Ligth Hunter";
	}

}

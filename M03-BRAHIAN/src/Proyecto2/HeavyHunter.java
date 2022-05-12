package Proyecto2;

public class HeavyHunter extends Ship implements MilitaryUnit{
	
	private int armadura_plus = Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
	private int dano_plus = Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
	
	HeavyHunter(int armor,int baseDamage){
		super(armor,baseDamage);
	}
	
	HeavyHunter(){
		super(Variables.ARMOR_HEAVYHUNTER, Variables.BASE_DAMAGE_HEAVYHUNTER);
	};
	
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
		return Variables.METAL_COST_HEAVYHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		return Variables.DEUTERIUM_COST_HEAVYHUNTER;
	}

	@Override
	public int getChanceGeneratinWaste() {
		int porcentaje=Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		int porcentaje=Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());;
	}
	
	@Override
	public String toString() {
		return "Heavy Hunter";
	}

}
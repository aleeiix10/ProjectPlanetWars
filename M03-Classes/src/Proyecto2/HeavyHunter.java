package Proyecto2;

public class HeavyHunter extends Ship implements MilitaryUnit{
	
	int armadura_plus = Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
	int dano_plus = Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
	
	HeavyHunter(int armor,int baseDamage){
		this.baseDamage = baseDamage;
		this.armor = armor;
		this.initialArmor = armor;
	}
	
	HeavyHunter(){
		this.baseDamage = Variables.BASE_DAMAGE_HEAVYHUNTER;
		this.armor = Variables.ARMOR_HEAVYHUNTER;
		this.initialArmor = Variables.ARMOR_HEAVYHUNTER;
	};
	@Override
	public int attack() {
		return baseDamage;
	}

	@Override
	public void takeDamage(int receivedDamage) {
		this.armor = this.armor - receivedDamage;
	}

	@Override
	public int getActualArmor() {
		return this.armor;
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
		this.armor = this.initialArmor;
	}

}
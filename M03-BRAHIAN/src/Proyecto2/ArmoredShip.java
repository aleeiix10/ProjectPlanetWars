package Proyecto2;

public class ArmoredShip extends Ship implements MilitaryUnit{
	
	int armadura_plus = Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY;
	int dano_plus = Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY;
	
	ArmoredShip(int armor,int baseDamage){
		this.baseDamage = baseDamage;
		this.armor = armor;
		this.initialArmor = armor;
	}
	
	ArmoredShip(){
		this.baseDamage = Variables.BASE_DAMAGE_ARMOREDSHIP;
		this.armor = Variables.ARMOR_ARMOREDSHIP;
		this.initialArmor = Variables.ARMOR_ARMOREDSHIP;
	};
	@Override
	public int attack() {
		return this.baseDamage;
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
		return Variables.METAL_COST_ARMOREDSHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return Variables.DEUTERIUM_COST_ARMOREDSHIP;
	}

	@Override
	public int getChanceGeneratinWaste() {
		int porcentaje=Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP;
		int num_random;
		
		num_random = (int)(Math.random()*101);
		
		if (num_random<=porcentaje) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		int porcentaje=Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP;
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

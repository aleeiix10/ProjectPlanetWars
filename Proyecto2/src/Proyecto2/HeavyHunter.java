package Proyecto2;

public class HeavyHunter extends Ship{
	int armadura = Variables.ARMOR_HEAVYHUNTER;
	int armadura_plus = Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY;
	int dano = Variables.BASE_DAMAGE_HEAVYHUNTER;
	int dano_plus = Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY;
	int initialArmor;
	
	HeavyHunter(int armor,int baseDamage){
		this.dano = baseDamage;
		this.initialArmor = armor;
	}
	HeavyHunter(){};
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void takeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}

}
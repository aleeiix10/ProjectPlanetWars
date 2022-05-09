package Proyecto2;

public class LigthHunter extends Ship{
	int armadura = Variables.ARMOR_LIGTHHUNTER;
	int armadura_plus = Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY;
	int dano_plus = Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY;
	int dano = Variables.BASE_DAMAGE_LIGTHHUNTER;
	int initialArmor;
	LigthHunter(int armor,int baseDamage){
		this.dano = baseDamage;
		this.initialArmor = armor;
	}
	LigthHunter() {};
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

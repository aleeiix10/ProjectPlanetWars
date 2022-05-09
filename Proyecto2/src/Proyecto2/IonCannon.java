package Proyecto2;

public class IonCannon extends Defense{
	int armadura = Variables.ARMOR_MISSILELAUNCHER;
	int armadura_plus = Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY;
	int dano = Variables.BASE_DAMAGE_MISSILELAUNCHER;
	int dano_plus = Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY;
	IonCannon(int armor,int baseDamage){
		this.dano = baseDamage;
		this.initialArmor = armor;
	}

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


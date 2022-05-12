package Proyecto2;

public abstract class Defense implements Variables,MilitaryUnit {
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	
 
	public Defense(int initialArmor, int baseDamage) {
		this.armor = initialArmor;
		this.initialArmor = initialArmor;
		this.baseDamage = baseDamage;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getInitialArmor() {
		return initialArmor;
	}
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	} 
}

package robotPackage;

public class Battlebot extends Robot{

	private String weapon;
	private String armor;
	private boolean attack = false;
	
	public Battlebot(String name, int[] position, int speed, int direction){
		super(name, position, speed, direction);
		this.weapon = "horizontal spinning blade";
		this.armor = "adamantium skeleton";
		this.attack = false;
	}
	
	public String getWeapon() {
		return this.weapon;
	}

	public void setWeapon(String newWeapon) {
		this.weapon = newWeapon;
	}

	public String getArmor() {
		return this.armor;
	}

	public void setArmor(String newArmor) {
		this.armor = newArmor;
	}

	public boolean attack(){
		this.attack = !this.attack;
		return this.attack;
	}
}

package trpg;

abstract class Unit {
	String name;
	int level = 1;
	int exp;
	int maxhp;
	int hp;
	int att;
	int def;
	int speed;
	
	boolean party;
	
	
	@Override
	public String toString() {
		return "";
	}
}

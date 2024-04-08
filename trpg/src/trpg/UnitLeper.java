package trpg;

public class UnitLeper extends Unit implements hero{
	
	UnitLeper(String name){
		this.name = name;
		maxhp = 35;
		hp = maxhp;
		att = 10; // +=3
		speed = 2;
	}
}

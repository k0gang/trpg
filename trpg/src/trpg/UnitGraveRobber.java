package trpg;

public class UnitGraveRobber extends Unit implements hero{
	
	UnitGraveRobber(String name){
		this.name = name;
		maxhp = 20;
		hp = maxhp;
		att = 6; // +=2;
		speed = 8;
	}
}

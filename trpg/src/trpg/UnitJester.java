package trpg;

public class UnitJester extends Unit implements hero{

	UnitJester(String name){
		this.name = name;
		maxhp = 19;
		hp = maxhp;
		att = 5; // +=1
		speed = 7;
	}
}

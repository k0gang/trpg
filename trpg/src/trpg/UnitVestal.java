package trpg;

public class UnitVestal extends Unit{

	UnitVestal(String name){
		this.name = name;
		maxhp = 24;
		hp = maxhp;
		att = 6; // +=2
		speed = 4;
	}
}

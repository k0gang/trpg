package trpg;

public class UnitHoundMaster extends Unit implements hero{

	UnitHoundMaster(String name) {
		this.name = name;
		maxhp = 21;
		hp = maxhp;
		att = 5; // +=1;
		speed = 6;
	}
}

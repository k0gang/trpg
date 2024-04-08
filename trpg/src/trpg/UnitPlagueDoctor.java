package trpg;

public class UnitPlagueDoctor extends Unit implements hero{
	
	UnitPlagueDoctor(String name){
		this.name = name;
		maxhp = 22;
		hp = maxhp;
		att = 5; // +=1
		speed = 7;
	}
}

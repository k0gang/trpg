package trpg;

public class MonsterFanatic extends Unit implements Boss{

	MonsterFanatic(){
		name = "광신도";
		maxhp = 99;
		hp = maxhp;
		att = 2;
		speed = 7;
	}
}

package trpg;

public class MonsterCollector extends Unit implements Boss{

	MonsterCollector(){
		this.name = "수짒가";
		maxhp = 70;
		hp = maxhp;
		att = 5;
		speed = 5;
	}
}

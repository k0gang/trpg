package trpg;

public  class Monster extends Unit{

	Monster() {

	}

	void attack(Unit target) {
		target.hp -= (att - target.def);
		System.out.println("-----------------");
		System.out.println("[" + name + "] 가 " + "[" + target.name + "] 에게 " + (att - target.def) + "의 데미지를 입힙니다. ");
		if (target.hp <= 0) {
			System.out.println("[" + target.name + "] 을 처치했습니다.");
			target.hp = 0;
		}
	}

	void printData() {
		System.out.println("[" + name + "] [" + hp + "/" + maxhp + "] [" + att + "]");
	}
	
	public Unit MonsterCultist() {
		Unit cultist = new MonsterCultist();
		return cultist;
	}
	
}

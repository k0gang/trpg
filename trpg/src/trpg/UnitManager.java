package trpg;

import java.util.Vector;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	
	Player player = new Player();
	
	Vector<Unit> party_list = new Vector<>();
	Vector<Unit> mon_list = new Vector<>();
	String pate = "trpg.";
	String mons[] = {"MonsterCultist", "MonsterGargoyle", "MonsterGhoul", "MonsterPliskin", "MonsterSkeleton", "MonsterWebber"};
	
	void init() {
		player.init();
	}
	
	
	void monster_rand_set(int size) {
		for(int i=0; i<size; i++) {
			int num = GameManager.ran.nextInt(mons.length);
			try {
				// 물리적인 클래스 파일명을 인자로 넣어 클래스를 반환해 객체 만들기
				Class<?> clazz = Class.forName(pate+mons[num]);
				// 생성자를 얻어와 new 연산자로 객체 생성하는 메서드 사용 (형변환 필요)
				Object obj = clazz.newInstance();
				Unit temp = (Unit) obj;
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

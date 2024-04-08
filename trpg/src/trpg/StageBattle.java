package trpg;

import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager um = null;
	Vector<Unit> monList = null;
	Vector<Unit> partyList = null;
	int monDead;
	int playerDead;

	public StageBattle() {
		um = UnitManager.instance;

	}

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		Vector<Unit> allUnitList = allUnitData();

		while (true) {
			if (turn) {
				attBySpeed(allUnitList);
				check_live();
				if (monDead <= 0 || playerDead <= 0)
					break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		um.mon_list.clear();
		um.monster_rand_set(4);
		um.player = null;
		um.player = new Player();
		monList = null;
		monList = um.mon_list;
		partyList = um.player.guild.partyList;
		monDead = monList.size();
		playerDead = Player.guild.partyList.size();
	}

	public void print_character() {
		System.out.println("========[BATTLE]=========");
		for (int i = 0; i < partyList.size(); i++) {
			System.out.print("[" + partyList.get(i).name + "]");
			System.out.println("[" + partyList.get(i).hp + "/" + partyList.get(i).maxhp + "]");
		}
		System.out.println("==========VS===========");
		for (int i = 0; i < monList.size(); i++) {
			System.out.print("[" + monList.get(i).name + "]");
			System.out.println("[" + monList.get(i).hp + "/" + monList.get(i).maxhp + "]");
		}
	}

	public Vector<Unit> allUnitData() {
		Vector<Unit> allUnitList = new Vector<>();

		for (int i = 0; i < monList.size(); i++)
			allUnitList.add(monList.get(i));

		for (int i = 0; i < partyList.size(); i++)
			allUnitList.add(partyList.get(i));

		Unit target = allUnitList.get(0);
		for (int i = 0; i < allUnitList.size(); i++) {
			if (target.speed < allUnitList.get(i).speed) {
				target = allUnitList.get(i);
				i--;
			}
		}

		return allUnitList;
	}

	public void attBySpeed(Vector<Unit> list) {
		for (int i = 0; i < list.size(); i++) {
			try {
				if (list.get(i) instanceof hero && list.get(i).hp > 0) {
					print_character();
					System.out.print("[" + list.get(i).name + "의 턴]");
					System.out.print("공격할 적 선택 : ");
					int sel = GameManager.sc.nextInt() - 1;
					monList.get(sel).hp -= list.get(i).att;
					if (monList.get(sel).hp < 0)
						monList.get(sel).hp = 0;

					System.out.print("[" + list.get(i).name + "]이 ");
					System.out.print("[" + monList.get(sel).name + "]을 ");
					System.out.println(list.get(i).att + "의 데미지로 공격");
				} else if (list.get(i).hp > 0) {
					print_character();
					int r = GameManager.ran.nextInt(partyList.size());

					partyList.get(r).hp -= list.get(i).att;

					System.out.print("[" + list.get(i).name + "]");
					System.out.print("이 [" + partyList.get(r).name + "]을 ");
					System.out.println(list.get(i).att + "의 데미지로 공격");
				}
				if (i == list.size() - 1)
					continue;
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	public void check_live() {
		int num = 0;
		for (int i = 0; i < partyList.size(); i++)
			if (partyList.get(i).hp <= 0)
				num += 1;
		playerDead = partyList.size() - num;

		num = 0;
		for (int i = 0; i < monList.size(); i++)
			if (monList.get(i).hp <= 0)
				num += 1;

		monDead = monList.size() - num;
	}

}

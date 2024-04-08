package trpg;

import java.util.Vector;

public class Guild {
	final int PARTY_SIZE = 4;
	Vector<Unit> guildList = new Vector<>();
	Vector<Unit> partyList = new Vector<>();

	void setGuild() {
		guildList.add(new Player().UnitHighwayMan());
		guildList.add(new Player().UnitCrusader());
		guildList.add(new Player().UnitAbomination());
		guildList.add(new Player().UnitGraveRobber());
		guildList.add(new Player().UnitHoundMaster());
		guildList.add(new Player().UnitJester());
		guildList.add(new Player().UnitLeper());
		guildList.add(new Player().UnitPlagueDoctor());
		guildList.add(new Player().UnitVestal());

	}

	public void updateParty() {

		partyList.clear();
		for (int i = 0; i < guildList.size(); i++)
			if (guildList.get(i).party)
				partyList.add(guildList.get(i));
	}

	public void printAllUnitStatus() {
		System.out.println("=========용병 목록========");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "]번");
			System.out.print(" [이름 : " + guildList.get(i).name + "]");
			System.out.print(" [레벨 : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxhp + "]");
			System.out.print("[공격력 : " + guildList.get(i).att + "]");
			System.out.print(" [방어력 : " + guildList.get(i).def + "]");
			System.out.print(" [속도 : " + guildList.get(i).speed + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
			System.out.println();
		}
		System.out.println("=======================");
	}

	public void printPartyList() {
		System.out.println("==========파티 목록=========");
		for (int i = 0; i < partyList.size(); i++) {
			if (partyList.get(i) != null) {
				System.out.print("[" + (i + 1) + "]번");
				System.out.print(" [이름 : " + partyList.get(i).name + "]");
				System.out.print(" [레벨 : " + partyList.get(i).level + "]");
				System.out.print(" [체력 : " + partyList.get(i).hp);
				System.out.println(" / " + partyList.get(i).maxhp + "]");
				System.out.print("[공격력 : " + partyList.get(i).att + "]");
				System.out.print(" [방어력 : " + partyList.get(i).def + "]");
				System.out.println(" [파티중 : " + partyList.get(i).party + "]");
			} else {
				System.out.println((i + 1) + "번 자리 고용 가능");
			}
		}
		System.out.println("=========================");
	}

	public void guildMenu() {
		while (true) {
			System.out.println("==== 길드 ====");
			System.out.println("[1.길드목록]\t[2.파티추가]\t[3.파티원 제외]");
			System.out.println("[4.파티현황]\t[5.파티원 정보]\t[0.뒤로가기]");
			int sel = GameManager.sc.nextInt();

			if (sel == 1)
				printAllUnitStatus();
			else if (sel == 2)
				hireUnit();
			else if (sel == 3)
				fireUnit();
			else if (sel == 4)
				printPartyList();
			else if (sel == 0)
				return;
		}
	}

	public void hireUnit() {
		printAllUnitStatus();

		System.out.print("고용할 용병의 번호를 입력하세요 : ");
		int sel = GameManager.sc.nextInt() - 1;

		if (guildList.get(sel).party) {
			System.out.println("이미 고용중입니다.");
			return;
		}

		guildList.get(sel).party = true;

		System.out.println("[" + guildList.get(sel).name + "가 파티에 합류합니다.]");

		updateParty();
	}

	public void fireUnit() {
		printPartyList();

		System.out.print("해고할 용병의 번호를 입력하세요 : ");
		int sel = GameManager.sc.nextInt() - 1;

		System.out.println("[" + partyList.get(sel).name + "가 파티에서 제외되었습니다.]");
		partyList.get(sel).party = false;

		updateParty();
	}

}

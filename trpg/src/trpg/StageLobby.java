package trpg;

public class StageLobby extends Stage {
	@Override
	public boolean update() {
		System.out.println("===== 영지 =====");
		System.out.println("[1. 출정] [2. 정비] [0. 종료]");
		int sel = GameManager.sc.nextInt();
		if (sel == 1)
			GameManager.nextStage = "BATTLE";
		else if (sel == 2)
			GameManager.nextStage = "SETTING";
		else if (sel == 0)
			GameManager.nextStage = "";

		return false;
	}

	@Override
	public void init() {
		UnitManager.instance.init();
	}
}

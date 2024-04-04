package trpg;

public class StageLobby extends Stage {
	UnitManager um = null;
	Shop shop;
	
	@Override
	public boolean update() {
		while (true) {
			System.out.println("===== 영지 =====");
			System.out.println("[1. 출정] [2. 길드] [3. 인벤토리] [4. 상점] [0. 종료]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1)
				GameManager.nextStage = "BATTLE";
			else if (sel == 2)
				um.player.guildMenu();
			else if (sel == 3)
				um.player.printInventory();
			else if (sel == 4)
			 	shop.shopMenu();
			else if (sel == 5)
				break;
		}
		return false;
	}

	@Override
	public void init() {
		
	}
}

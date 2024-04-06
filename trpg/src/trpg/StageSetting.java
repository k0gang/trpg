package trpg;

public class StageSetting extends Stage {
	UnitManager um = null;
	Shop shop;

	@Override
	public boolean update() {
		while (true) {
			System.out.println("===== 영지 =====");
			System.out.println("[1. 길드]\t[2. 상점]\t[3. 인벤토리]");
			System.out.println("[4. 저장]\t[5. 로드]\t[0. 종료]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1)
				um.player.guildMenu();
			else if (sel == 2)
				shop.shopMenu();
			else if (sel == 3)
				um.player.inventoryMenu(); 
//			else if (sel == 4)
//			 	shop.shopMenu();
//			else if (sel == 5)
			
			else if(sel == 0) {
				GameManager.nextStage = "";
				break;
			}
		}
		return false;
	}

	@Override
	public void init() {
		um = UnitManager.instance;
		shop = new Shop();
		// fileData = new FileData();

	}
}

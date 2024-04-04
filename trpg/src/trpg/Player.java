package trpg;

public class Player extends Unit {
	static int money;

	static Guild guild = new Guild();
	static Inventory inven = new Inventory();

	Player() {

	}

	void init() {
		money = 10000;
		guild.setGuild();
	}

	// 길드 메뉴 메서드
	public void guildMenu() {
		guild.guildMenu();
	}

	// 인벤토리 메뉴 메서드
	public void inventoryMenu() {
		inven.printInventory();
	}

	public Unit dismas() {
		Unit dismas = new UnitHighwayMan();
		return dismas;
	}

	public Unit Reynauld() {
		Unit reynauld = new UnitCrusader();
		return reynauld;
	}

}

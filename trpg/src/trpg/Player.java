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

	public Unit UnitHighwayMan() {
		String name = "Dismas";
		Unit highwayMan = new UnitHighwayMan(name);
		return highwayMan;
	}

	public Unit UnitCrusader() {
		String name = "Reynauld";
		Unit crusader = new UnitCrusader(name);
		return crusader;
	}

	public Unit UnitAbomination() {
		String name = "bigby";
		Unit abomination = new UnitAbomination(name);
		return abomination;
	}

	public Unit UnitLeper() {
		String name = "Baldwin";
		Unit leper = new UnitLeper(name);
		return leper;
	}

	public Unit UnitGraveRobber() {
		String name = "Audrey";
		Unit graveRobber = new UnitGraveRobber(name);
		return graveRobber;
	}

	public Unit UnitPlagueDoctor() {
		String name = "Paracelsus";
		Unit plagueDoctor = new UnitPlagueDoctor(name);
		return plagueDoctor;
	}

	public Unit UnitVestal() {
		String name = "Junia";
		Unit vestal = new UnitVestal(name);
		return vestal;
	}

	public Unit UnitJester() {
		String name = "Sarmenti";
		Unit jester = new UnitJester(name);
		return jester;
	}

	public Unit UnitHoundMaster() {
		String name = "William & Fergus";
		Unit houndMaster = new UnitHoundMaster(name);
		return houndMaster;
	}

}

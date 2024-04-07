package trpg;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	
	Player player = new Player();
	
	
	void init() {
		player.init();

	}
}

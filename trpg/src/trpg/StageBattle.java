package trpg;

import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager um = null;
	Vector<Monster> monList = null;
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
		
		while(true) {
			if(turn) {
				print_character();
				
			}
		}
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}

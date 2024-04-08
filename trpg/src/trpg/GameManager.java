package trpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static GameManager instance = new GameManager();
	static Random ran = new Random();
	static Scanner sc = new Scanner(System.in);
	
	static String nextStage = "";
	
	String curStage = "";
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	GameManager(){
		
	}
	
	void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		stageList.put("BATTLE", new StageBattle());
		
		nextStage = "TITLE";
	}
	
	boolean stageChange() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
		if(curStage.equals(nextStage))
			return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(run) {
			run = stage.update();
			if(run == false)
				break;
		}
		// 로비에서 종료시 false
		if(nextStage.equals(""))
			return false;
		else return true;		
	}
}

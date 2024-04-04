package trpg;

public class Main {
	public static void main(String[] args) {
		boolean run = true;
		GameManager.instance.init();
		while(true) {
			run = GameManager.instance.stageChange();
			if(run == false)
				break;
		}
		System.out.println("게임종료");
	}
}

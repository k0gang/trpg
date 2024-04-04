package trpg;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<>();
	int[] ea = new int[itemList.size()];

	public void printInventory() {
		System.out.println("=======인벤토리=======");
		for (int i = 0; i < itemList.size(); i++)
			if (ea[i] > 0)
				System.out.println("[" + itemList.get(i).name + " : " + ea[i] + "개]");
		System.out.println("====================");
	}
}

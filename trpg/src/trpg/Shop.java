package trpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList();

	// 생성자
	public Shop() {
		Item temp = new Item();
		temp.name = "식량";
		temp.price = 300;
		itemList.add(temp);

		temp = new Item();
		temp.name = "붕대";
		temp.price = 200;
		itemList.add(temp);

		// ...

	}

	public void shopMenu() {
		while (true) {
			System.out.println(Player.money + "원 보유");
			System.out.println("=========상점=========");
			System.out.println("[1.소모품 구매] [2] [0.뒤로가기]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1)
				buyItem();
			else if (sel == 0)
				return;
		}
	}

	public void buyItem() {
		printItemList();
		System.out.println("구매하실 상품 번호 입력");
		int sel = GameManager.sc.nextInt() - 1;
		System.out.print("구매하실 개수 : ");
		int ea = GameManager.sc.nextInt();

		int total = itemList.get(sel).price * ea;
		if (Player.money >= total)
			Player.money -= total;
		else
			System.err.println("소지 골드 부족");

		// 갖고있는 품목이면
		for (int i = 0; i < Player.inven.itemList.size(); i++)
			if (itemList.get(sel).name.equals(Player.inven.itemList.get(i).name)) {
				Player.inven.ea[sel] += ea;
				System.out.println("[" + Player.inven.itemList.get(sel).name + " : " + ea + "개 구매완료]");
				return;
			}

		Item item = itemList.get(sel);
		Player.inven.itemList.add(item);
		int[] temp = Player.inven.ea;
		Player.inven.ea = new int[Player.inven.itemList.size()];
		int n = 0;
		for (int i = 0; i < Player.inven.itemList.size() - 1; i++)
			Player.inven.ea[i] = temp[i];
		Player.inven.ea[Player.inven.itemList.size() - 1] = ea;

		Player.inven.ea[sel] += ea;
		System.out.println("[" + Player.inven.itemList.get(sel).name + " : " + ea + "개 구매완료]");
	}

	public void printItemList() {
		System.out.println("==========아이템 목록=========");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번] [");
			System.out.println(itemList.get(i).name + " : " + itemList.get(i).price + "원]");
		}
		System.out.println("==========================");
	}

}

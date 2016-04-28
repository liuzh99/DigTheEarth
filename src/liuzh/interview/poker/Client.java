package liuzh.interview.poker;

public class Client {

	public static void main(String[] args) {
		CommonDealer commonDealer = new CommonDealer();
		Player player1 = (Player) Factory.getBean("Player");
		player1.setId(1);
		player1.setName("玩家1");
		Player player2 = (Player) Factory.getBean("Player");
		player2.setId(2);
		player2.setName("玩家2");
		Player player3 = (Player) Factory.getBean("Player");
		player3.setId(3);
		player3.setName("玩家3");
		Player player4 = (Player) Factory.getBean("Player");
		player4.setId(4);
		player4.setName("玩家4");
		commonDealer.addPlayer(player1);
		commonDealer.addPlayer(player2);
		commonDealer.addPlayer(player3);
		commonDealer.addPlayer(player4);
		try {
			commonDealer.deal();
			commonDealer.display();
		} catch (PokerException e) {
			e.printStackTrace();
		} catch (DealerException e) {
			e.printStackTrace();
		}
	}

}

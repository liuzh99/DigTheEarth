package liuzh.poker.test;

import liuzh.poker.controler.Dealer;
import liuzh.poker.domain.Player;
import liuzh.poker.exception.DealerException;
import liuzh.poker.exception.PokerException;
import liuzh.poker.factory.Factory;

public class Client {

	public static void main(String[] args) {
		Dealer dealer = (Dealer) Factory.getBean("Dealer");
		//创建玩家
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
		//添加玩家
		dealer.addPlayer(player1);
		dealer.addPlayer(player2);
		dealer.addPlayer(player3);
		dealer.addPlayer(player4);
		try {
			dealer.deal();
			dealer.display();
		} catch (PokerException e) {
			e.printStackTrace();
		} catch (DealerException e) {
			e.printStackTrace();
		}
	}

}

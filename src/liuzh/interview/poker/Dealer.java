package liuzh.interview.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * title:Dealer
 * descript:定义发牌器抽象类
 * @author liuzh
 * @date 2016年4月27日 下午10:10:22
 */
public abstract class Dealer {
	
	protected Poker poker;
	protected List<Player> players;
	
	/**
	 * 初始化发牌器
	 */
	public Dealer() {
		//创建锄大地扑克牌
		poker = (Poker) Factory.getBean("Poker");
		//初始化玩家集合
		players = new ArrayList<Player>();
	}
	
	/**
	 * 添加玩家
	 */
	public void addPlayer(Player player){
		players.add(player);
	}
	
	/**
	 * 用于发牌给4个玩家
	 */
	public abstract void deal() throws PokerException, DealerException ;
	
	/**
	 * 显示4个玩家的牌
	 */
	public void display(){
		for(int i=0;i<4;i++){
			System.out.println(players.get(i));
		}
	}

}

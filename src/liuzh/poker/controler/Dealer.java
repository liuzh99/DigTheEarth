package liuzh.poker.controler;

import java.util.ArrayList;
import java.util.List;

import liuzh.poker.domain.Poker;
import liuzh.poker.domain.Player;
import liuzh.poker.exception.DealerException;
import liuzh.poker.exception.PokerException;

/**
 * title:Dealer
 * descript:定义发牌器抽象类
 * @author liuzh
 * @date 2016年4月27日 下午10:10:22
 */
public abstract class Dealer {
	//锄大地扑克牌
	protected Poker poker = new Poker();
	//玩家集合
	protected List<Player> players = new ArrayList<Player>();
	
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

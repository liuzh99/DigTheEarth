package liuzh.interview.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * title:Poker
 * descript:定义扑克牌的基本操作
 * @author liuzh
 * @date 2016年4月27日 下午12:18:17
 */
public abstract class Poker {
	
	protected List<PokerElem> pokerElems;
	
	
	/**
	 * 将扑克牌随机排序
	 * 实现方式：
	 * 将一副牌拷贝到一个新的链表中
	 * 然后随机从拷贝的扑克牌中移动到新的集合
	 * 最终得到一副新的扑克牌
	 */
	public void doRandom(){
		List<PokerElem> temp = new ArrayList<PokerElem>();
		temp.addAll(pokerElems);
		Random random = new Random();
		pokerElems.clear();
		int randomIndex;
		while(temp.size() > 0){
			randomIndex = random.nextInt(temp.size());
			pokerElems.add(temp.get(randomIndex));
			temp.remove(randomIndex);
		}
	}
	
	/**
	 * 获取扑克牌集合
	 */
	public List<PokerElem> getPokerCollection(){
		return pokerElems;
	}

}

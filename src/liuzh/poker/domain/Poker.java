package liuzh.poker.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * title:Poker
 * descript:定义扑克牌的基本操作
 * @author liuzh
 * @date 2016年4月27日 下午12:18:17
 */
public class Poker {
	
	protected List<PokerElem> pokerElems = new ArrayList<PokerElem>();
	
	//初始化扑克牌
	public Poker() {
		String[] size = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		PokerElem pokerElem = null;
		for(PokerType pokerType : PokerType.values()){
			for(String s : size){
				pokerElem = new PokerElem();
				pokerElem.setPokerType(pokerType);
				pokerElem.setSize(s);
				pokerElems.add(pokerElem);
			}
		}
	}
	
	
	/**
	 * 将扑克牌随机排序
	 * 实现方式：
	 * 将一副牌拷贝到一个新的链表中
	 * 然后随机从拷贝的扑克牌中移动到新的集合
	 * 最终得到一副新的扑克牌
	 */
	private void doRandom(){
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
		doRandom();
		return pokerElems;
	}

}

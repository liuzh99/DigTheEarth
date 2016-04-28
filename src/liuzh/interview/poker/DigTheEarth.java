package liuzh.interview.poker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * title:DigTheEarth
 * descript:定义锄大地扑克牌
 * @author liuzh
 * @date 2016年4月27日 下午2:10:34
 */
public class DigTheEarth extends Poker{

	
	/**
	 * 对一副牌初始化
	 */
	public DigTheEarth(){
		pokerElems = new ArrayList<PokerElem>();
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
}

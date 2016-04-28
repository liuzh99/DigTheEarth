package liuzh.interview.poker;

import java.util.List;

/**
 * title:常规发牌器
 * descript:
 * @author liuzh
 * @date 2016年4月27日 上午9:36:26
 */
public class CommonDealer extends Dealer {
	
	public CommonDealer() {
		super();
	}

	@Override
	public void deal() throws PokerException, DealerException {
		poker.doRandom();
		List<PokerElem> pokerElems = (List<PokerElem>) poker.getPokerCollection();
		if(pokerElems.size() != 52){
			throw new PokerException("扑克牌不是52张");
		}
		if(players.size() < 4){
			throw new DealerException("玩家数量不足");
		}
		int index = 0;
		while(index < 52){
			for(int i=0;i<4;i++){
				players.get(i).addPokerElem(pokerElems.get(index));
				index++;
			}
		}
	}

}

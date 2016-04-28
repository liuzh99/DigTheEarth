package liuzh.interview.poker;

/**
 * title:PokerElem
 * descript:此类定义了一张牌，用于组成一副没有大小鬼的扑克牌
 * @author liuzh
 * @date 2016年4月26日 下午11:30:10
 */
public class PokerElem {
	
	private String size;
	private PokerType pokerType;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public PokerType getPokerType() {
		return pokerType;
	}
	public void setPokerType(PokerType pokerType) {
		this.pokerType = pokerType;
	}
	
	@Override
	public String toString() {
		return pokerType.toString() + size;
	}

}

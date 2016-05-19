package liuzh.poker.domain;

/**
 * title:PokerElem
 * descript:此类定义了一张牌，用于组成一副没有大小鬼的扑克牌
 * @author liuzh
 * @date 2016年4月26日 下午11:30:10
 */
public class PokerElem implements Comparable<PokerElem>{
	
	private String size;
	private PokerType pokerType;
	//百度百科-锄大地 查找到的大小
	private String[] sizes = new String[]{"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
	
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
	/**
	 * 花色可以直接比较出大小，如果花色相同，
	 * 则根据sizes数组定义的规律，比较两张扑克牌的大小
	 * @param elem
	 * @return 0  相同
	 * @return -1 传入的为大
	 * @return 1  传入的为小
	 */
	@Override
	public int compareTo(PokerElem elem) {
		if(this.pokerType.ordinal() < elem.pokerType.ordinal()){
			return -1;
		}else if(this.pokerType.ordinal() > elem.pokerType.ordinal()){
			return 1;
		}else{
			int indexIn = -1, indexOut = -1;
			for(int i=0;i<sizes.length;i++){
				if(this.size.equals(sizes[i])){
					indexIn = i;
				}
				if(elem.size.equals(sizes[i])){
					indexOut = i;
				}
				if(indexIn != -1 && indexOut != -1){
					break;
				}
			}
			//索引越靠前，权值越大
			if(indexIn < indexOut){
				return -1;
			}
			if(indexIn > indexOut){
				return 1;
			}
			return 0;
		}
	}

}

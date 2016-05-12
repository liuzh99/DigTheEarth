package liuzh.poker.domain;


/**
 * title:SortPlayer
 * descript:将插入的牌按照A,2,3,4,5...J,Q,K排序
 * @author liuzh
 * @date 2016年4月27日 下午12:11:10
 */
public class SizeSortPlayer extends Player {
	
	public SizeSortPlayer() {
	}
	
	public SizeSortPlayer(Integer id, String name) {
		super(id,name);
	}
	
	/**
	 * 首先在已添加的牌中找将要添加牌的花色，
	 * 1 如果没找到就找前面的花色，如果到最前面都没找到，则直接将牌插入到第一个
     * 2 找到了就从 当前位置到当前花色结束 这段区间找比添加牌小的位置，
     * 2.1 找到了，然后插入到index处
     * 2.2 没找到，插入到index处
     */
	@Override
	public void addPokerElem(PokerElem addPokerElem) {
		int index;
		PokerType pokerType = addPokerElem.getPokerType();
		
		//查找花色
		for(index=0;index<pokerElems.size();index++){
			if(pokerElems.get(index).getPokerType().equals(pokerType)){
				break;
			}
		}

		//1
		if(index == pokerElems.size()){
			pokerElems.add(0, addPokerElem);
			return;
		}
		for(;index<pokerElems.size();index++){
			//花色相同才继续做对比
			if(pokerElems.get(index).getPokerType().equals(pokerType)){
				//2.1
				if(pokerElems.get(index).compareTo(addPokerElem) == -1){
					pokerElems.add(index,addPokerElem);
					return;
				}
			}
			//2.2
			else{
				pokerElems.add(index,addPokerElem);
				return;
			}
		}
		//如果花色为最后一个，而且没有找到比插入牌小的，则插入到最后一个
		pokerElems.add(pokerElems.size(),addPokerElem);
	}

}

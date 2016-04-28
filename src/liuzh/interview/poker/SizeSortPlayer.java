package liuzh.interview.poker;

/**
 * title:SortPlayer
 * descript:将插入的牌按照A,2,3,4,5...J,Q,K排序
 * @author liuzh
 * @date 2016年4月27日 下午12:11:10
 */
public class SizeSortPlayer extends Player {
	//百度百科-锄大地 查找到的大小
	private String[] size = new String[]{"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

	public SizeSortPlayer() {
	}
	
	public SizeSortPlayer(Integer id, String name) {
		super(id,name);
	}

	/**
	 * 根本size数组定义的规律，比较size1,size2的大小
	 * @param size1
	 * @param size2
	 * @return 0  相同
	 * @return -1 size1 < size2
	 * @return 1  size1 > size2
	 */
	private int compare(String size1,String size2){
		int index1 = -1, index2 = -1;
		for(int i=0;i<size.length;i++){
			if(size1.equals(size[i])){
				index1 = i;
			}
			if(size2.equals(size[i])){
				index2 = i;
			}
			if(index1 != -1 && index2 != -1){
				break;
			}
		}
		//索引越靠前，权值越大
		if(index1 > index2){
			return -1;
		}
		if(index1 < index2){
			return 1;
		}
		return 0;
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
				if(compare(pokerElems.get(index).getSize(),addPokerElem.getSize()) == -1){
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

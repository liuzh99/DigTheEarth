package liuzh.poker.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * title:扑克牌玩家
 * descript:定义了玩家ID，与玩家名称
 * @author liuzh
 * @date 2016年4月26日 下午11:42:05
 */
public class Player {
	
	protected Integer id;
	protected String name;
	protected Set<PokerElem> pokerElems = new TreeSet<PokerElem>();
	
	public Player() {
		super();
	}
	public Player(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<PokerElem> getPokerElems() {
		return pokerElems;
	}
	public void setPokerElems(Set<PokerElem> pokerElems) {
		this.pokerElems = pokerElems;
	}
	public void removeAll(){
		pokerElems.removeAll(pokerElems);
	}
	
	public void addPokerElem(PokerElem pokerElem){
		pokerElems.add(pokerElem);
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", pokerElems="
				+ pokerElems + "]";
	}

}

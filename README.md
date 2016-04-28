# DigTheEarth<br>
锄大地发牌程序<br>
1.一开始想到后续可能需要保留大小鬼，可能不是固定的发给4个人。后来百度查找才知道锄大地一定是52张，一定是发给4个人<br>
2.接下来，我从寻找实体开始：扑克牌，玩家。于是就定义了PokerElem(一张牌)，Poker(一副扑克牌)，Player(玩家)<br>
3.想到扑克牌的组成方式可能还有其它种类，于是我把Poker定义为抽象类，让DigTheEarth(锄大地)实现继承，只需要在构造函数中写入牌的组成方式即可<br>
4.一开始我定义Player是一个类，后面当我写到liuzh.interview.poker.Player.addPokerElem(PokerElem)时，发现这个地方应该要写成抽象函数，然后用实现类来实现，于是我又定义了liuzh.interview.poker.SizeSortPlayer，这个对象中的liuzh.interview.poker.SizeSortPlayer.addPokerElem会在收到一张牌时，会自动地按照A,2,3,4,5...J,Q,K大小顺序插入。<br>
5.接下来就开始定义发牌程序，我在定义这个类时，发现liuzh.interview.poker.Dealer.deal()需要逻辑处理，于是就将其定义为抽象函数，然后我定义一个常规发牌器liuzh.interview.poker.CommonDealer来实现，使用4个人轮流发牌的方式，循环13次便可完成。<br>

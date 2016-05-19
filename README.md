- 一开始想到后续可能需要保留大小鬼，可能不是固定的发给4个人。后来百度查找才知道锄大地一定是52张，一定是发给4个人
- 接下来，我从寻找实体开始：扑克牌，玩家。于是就定义了PokerElem(一张牌)，Poker(一副扑克牌)，Player(玩家)
- 想到扑克牌的组成方式可能还有其它种类，于是我把Poker定义为抽象类，让DigTheEarth(锄大地)实现继承，只需要在构造函数中写入牌的组成方式即可
- 一开始我定义Player是一个类，后面当我写到Player.addPokerElem(PokerElem)时，发现这个地方应该要写成抽象函数，然后用实现类来实现，于是我又定义了SizeSortPlayer，这个对象中的SizeSortPlayer.addPokerElem会在收到一张牌时，会自动地按照A,2,3,4,5...J,Q,K大小顺序插入。
- 接下来就开始定义发牌程序，我在定义这个类时，发现Dealer.deal()需要逻辑处理，于是就将其定义为抽象函数，然后我定义一个常规发牌器CommonDealer来实现，使用4个人轮流发牌的方式，循环13次便可完成。

- 优化结构：
- 由于此程序只用于锄大地发牌，所以DigTheEarth已经删除。
- 对于对象的大小比较，原来是放在SizeSortPlayer中，这样是不合适的，现在PokerElem已经实现Comparable接口中的compareTo用于比较大小。
- 程序对外提供的API应该精简，由于每次调用Poker.getPokerCollection()一定会调用Poker.doRandom()，现在已经将Poker.doRandom()定义为私有，由Poker.getPokerCollection()自行调用

- 简化代码
TreeSet可根据对象的compareTo方法自动排序，此次将List改为TreeSet，简化代码

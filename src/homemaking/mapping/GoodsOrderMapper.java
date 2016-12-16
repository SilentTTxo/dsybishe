package homemaking.mapping;

import java.util.List;

import homemaking.data.Goods;
import homemaking.data.GoodsOrder;
import homemaking.data.State;

public interface GoodsOrderMapper {
	
	GoodsOrder findById(int id);
	List<GoodsOrder> findAll();
	List<GoodsOrder> findByUser(int uid);
	List<GoodsOrder> findByState(int state,int uid);
	int add(GoodsOrder goodsOrder);
	void state(GoodsOrder goodsOrder);
	List<State> findByStateCount(int uid);
	void del(int id);
}

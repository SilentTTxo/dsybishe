package homemaking.mapping;

import java.util.List;

import homemaking.data.Goods;
import homemaking.data.GoodsOrder;

public interface GoodsOrderMapper {
	
	GoodsOrder findById(int id);
	List<GoodsOrder> findAll();
	int add(GoodsOrder goodsOrder);
	void state(GoodsOrder goodsOrder);
}

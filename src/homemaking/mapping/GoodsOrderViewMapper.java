package homemaking.mapping;

import java.util.List;

import homemaking.data.Goods;
import homemaking.data.GoodsOrder;
import homemaking.data.GoodsOrderView;

public interface GoodsOrderViewMapper {
	
	GoodsOrderView findById(int id);
	List<GoodsOrderView> findAll();
	List<GoodsOrderView> findByUser(int uid);
	List<GoodsOrderView> findByState(int state,int uid);
}

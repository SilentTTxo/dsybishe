package homemaking.mapping;

import java.util.List;

import homemaking.data.Goods;
import homemaking.data.GoodsOrder;
import homemaking.data.GoodsOrder2GoodsView;
import homemaking.data.GoodsOrderView;

public interface GoodsOrder2GoodsViewMapper {
	
	GoodsOrder2GoodsView findById(int id);
	List<GoodsOrder2GoodsView> findAll();
	List<GoodsOrder2GoodsView> findByUser(int uid);
	List<GoodsOrder2GoodsView> findByState(int state,int uid);
}

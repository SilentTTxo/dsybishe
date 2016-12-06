package homemaking.mapping;

import java.util.List;

import homemaking.data.Goods;

public interface GoodsMapper {
	
	Goods findById(int id);
	List<Goods> findAll();
	List<Goods> searchByName(String name);
	List<Goods> searchByType(String type);
	int add(Goods goods);
	void isSell(Goods goods);
	List<String> getType();
}

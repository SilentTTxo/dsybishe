package homemaking.mapping;

import java.util.List;

import homemaking.data.Ad;

public interface AdMapper {
	
	Ad findById(int id);
	List<Ad> findAll();
	int add(Ad ad);
	void del(int id);
}

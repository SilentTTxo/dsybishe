package homemaking.mapping;

import java.util.List;

import homemaking.data.Ad;
import homemaking.data.Notice;

public interface NoticeMapper {
	
	Notice findById(int id);
	List<Notice> findAll();
	int add(Notice notice);
	void del(int id);
}

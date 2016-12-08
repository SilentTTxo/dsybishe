package homemaking.mapping;

import java.util.List;

import homemaking.data.User;

public interface UserMapper {
	
	User findById(int id);
	List<User> findAll();
	User findByName(String username);
	int register(User user);
	void fixImg(User user);
	void fixPaypassword(User user);
}

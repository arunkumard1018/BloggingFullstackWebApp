package com.app.user;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app.jpa.UserRepositry;

@Service
public class UserDaoService {
	
	private UserRepositry userRepositry;
	
	public UserDaoService(UserRepositry userRepositry) {
		super();
		this.userRepositry = userRepositry;
	}
	
	public List<User> findAll(){
		return userRepositry.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return userRepositry.findById(id);
	}

	public User save(User user) {
		return userRepositry.save(user);
	}

	public void deleteById(Integer id) {
		userRepositry.deleteById(id);
		
	}

}

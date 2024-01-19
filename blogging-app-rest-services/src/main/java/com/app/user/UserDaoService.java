package com.app.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	static List<User> users = new ArrayList<>();
	static int  id= 110;
	static {
		users.add(new User(++id, "Arun", "arun@gmail.com", "Arun@password", LocalDate.now().minusYears(20)));
		users.add(new User(++id, "Chirag", "Chirag@gmail.com", "Chirag@password", LocalDate.now().minusYears(21)));
		users.add(new User(++id, "Manoj", "Manoj@gmail.com", "Manoj@password", LocalDate.now().minusYears(22)));
		users.add(new User(++id, "Chandan", "Chandan@gmail.com", "Chandan@password", LocalDate.now().minusYears(23)));

	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int userId) {
		Predicate<? super User> predicate = user -> user.getId().equals(userId);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++id);
		users.add(user);
		return user;
	}

}

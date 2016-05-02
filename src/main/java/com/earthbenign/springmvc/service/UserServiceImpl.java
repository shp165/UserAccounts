package com.earthbenign.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.earthbenign.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	public User findByName(String name) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);

	}

	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}

	}

	public List<User> findAllUsers() {
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"John Citizen", "Austin, TX", "john.citizen@xyz.com"));
		users.add(new User(counter.incrementAndGet(),"Jane Doe", "Memphis, TN", "jane.doe@xyz.com"));
		users.add(new User(counter.incrementAndGet(),"Another User", "Las Vegas, NV", "another.user@xyz.com"));
		return users;
	}

}

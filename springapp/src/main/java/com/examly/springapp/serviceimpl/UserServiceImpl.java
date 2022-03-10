package com.example.springbootproject.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	

	@Override
	public User addUser(User user) {
   return this.userRepository.save(user);
	}



	@Override
	public User updateUser(User user) {
        User user1=getUser(user.getId());
        user.setRole(user1.getRole());
		return this.userRepository.save(user);
	}



	@Override
	public Set<User> getUsers() {
		return new LinkedHashSet<>(this.userRepository.findAll());
	}



	@Override
	public User getUser(Long id) {
		Optional<User> user=this.userRepository.findById(id);
		User user1=null;
		if(user.isPresent())
			user1=user.get();
		return user1;
	}



	@Override
	public void deleteUser(Long id) {
		 this.userRepository.deleteById(id);
	}
	
	
	public String getRole(Long id) {
		Optional<User> user=this.userRepository.findById(id);
		User user1=null;
		if(user.isPresent()) {
			user1=user.get();
		  return user1.getRole().getRoleName();}
		else {
			return null;
		}
	}

}

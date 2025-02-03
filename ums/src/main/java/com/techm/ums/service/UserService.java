package com.techm.ums.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.ums.entity.User;
import com.techm.ums.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository UserRepository;

	public List<User> getUsers() {
		System.out.println("inside getUsers method");
		List<User> results = UserRepository.findAll();
		System.out.println(results);
		return results;
	}
	
	public String createUser(int id,String name)
	{
		System.out.println("inside createUser method");
		User user= new User();
		user.setId(id);
		user.setName(name);
		boolean isUserExist = UserRepository.existsById(Integer.toString(id));
		if(isUserExist)
		{	
		  return "user already exist";	
		 	
		}
		else
		{
			UserRepository.save(user);
		  return "user created sucesfully";
		}
		
	}
	
	public String updateUser(int id,String name)
	{
		System.out.println("inside updateUser method");
		boolean isUserExist = UserRepository.existsById(Integer.toString(id));
		if(isUserExist)
		{	
		 Optional<User> user = UserRepository.findById(Integer.toString(id));
		 User updateUser =user.get();
		 updateUser.setName(name);
		 UserRepository.save(updateUser);
		 return "user updated sucessfully";	
		 	
		}
		else
		{
		  return "user not exist";
		}
		
	}

	public String deleteUser(int id)
	{
		System.out.println("inside deleteUser method test");
		boolean isUserExist = UserRepository.existsById(Integer.toString(id));
		if(isUserExist)
		{	
		 UserRepository.deleteById(Integer.toString(id));
		 return "user deleted sucessfully";	 	
		}
		else
		{
		  return "user not exist";
		}
		
	}
}

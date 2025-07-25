package com.techm.ums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techm.ums.entity.User;
import com.techm.ums.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userServiceObj;

	@RequestMapping("getUsers")
	@ResponseBody
	public List<User> getAllUsers() {
		System.out.println("inside getAllUsers method");
		List<User> results = userServiceObj.getUsers();
		return results;
	}

	@RequestMapping("createUser")
	public String createUser() {	
		return "createuser";
	}
	
	@RequestMapping("updateUser")
	public String updateUser() {	
		return "updateuser";
	}
	
	@RequestMapping("deleteUser")
	public String deleteUser() {
		return "deleteuser";
		
	}
	
	
	@RequestMapping("home")
	public String homepage() {	
		return "home";
	}
	
	
	@RequestMapping("submitUser")
	@ResponseBody
	public String submitUser(int id, String name)
	{
		String result =userServiceObj.createUser(id, name);
		return result;
	}
	
	@RequestMapping("updateUserDetails")
	@ResponseBody
	public String updateUserDetails(int id, String name)
	{
		System.out.println("id"+id);
		System.out.println("name"+name);
	    String result =userServiceObj.updateUser(id, name);
		return result;
	}
	
	@RequestMapping("deleteUserDetails")
	@ResponseBody
	public String deleteUserDetails(int id)
	{
		System.out.println("id"+id);
	    String result =userServiceObj.deleteUser(id);
		return result;
	}
	

}

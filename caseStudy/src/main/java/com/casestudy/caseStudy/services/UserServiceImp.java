package com.casestudy.caseStudy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.caseStudy.entityModels.Address;
import com.casestudy.caseStudy.entityModels.Patient;
import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository ur;
	
	
	@Override
	public boolean addNewUser(User user) {
		// add new user
		boolean status = false;
		try {
			ur.save(user);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		return status;
	}

	@Override
	public List<User> getAllUsers() {
		// fetch list of users from the database 
				List<User> usersList = new ArrayList<User>();
				try {
					usersList = ur.findAll();
				}catch(Exception e) {
					System.out.println(e.getMessage());
					usersList = null;
				}
				return usersList;
	}



	@Override
	public boolean updateUserById(Integer id, User user) {
		// update patient using id value
				boolean status = false;
				User userToUpdate = ur.getOne(id);
				if(userToUpdate != null) {
					System.out.println("user with id: " + id + " found");
					userToUpdate.setUserName(user.getUserName());
					userToUpdate.setEmail(user.getEmail());
					userToUpdate.setPassword(user.getPassword());
					userToUpdate.setRoles(user.getRoles());
					userToUpdate.setActive(user.isActive());
					ur.save(userToUpdate);
					status = true;
				}else {
					System.out.println("user with id: " + id + " not found");
					status = false;
				}
				return status;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		//delete user using id value
		boolean status = false;
		try {
			ur.deleteById(id);
			status = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}finally {
			return status;
		}
	}

	@Override
	public User getUserById(Integer id) {
		// get user using id value
		User foundUser = ur.getOne(id);
		if(foundUser  != null) {
			System.out.println("user with id: " + id + " found");
		}else {
			System.out.println("user with id: " + id + " not found");
		}
		
		return foundUser ;
	}

	@Override
	public User getUserByUserNmae(String username) {
		//get user by user name
		return ur.getUserByUsername(username);
	}

}

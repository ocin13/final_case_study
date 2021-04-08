package com.casestudy.caseStudy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.caseStudy.entityModels.User;
import com.casestudy.caseStudy.services.UserServiceImp;


@SpringBootTest
class testUserServiceImp {
	
	@Autowired
	UserServiceImp us;
	
	List<User> userList;
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"", "  "})
	@DisplayName(value = "insert new User obejct to the database and check the return value")
	void testAddNewUser(String input) {
		User uTest = new User(input,"user@gmail.com","user123456",true,"USER");
		Assertions.assertFalse(us.addNewUser(uTest));
		User uTestVal = new User("username","user@gmail.com","user123456",true,"USER");
		Assertions.assertTrue(us.addNewUser(uTestVal));
	}

	@Test
	void testGetAllUsers() {
		userList = us.getAllUsers();
		Assertions.assertFalse(userList.isEmpty());
	}



	@Test
	void testDeleteUserById() {
		Assertions.assertTrue(us.deleteUserById(7));
	}

	@Test
	void testGetUserById() {
		Assertions.assertTrue(us.getUserById(6) != null);
	}

	@Test
	void testGetUserByUserNmae() {
		Assertions.assertTrue(us.getUserByUserNmae("turkia") != null);
		Assertions.assertFalse(us.getUserByUserNmae("kamelaitda") != null);
	}

}

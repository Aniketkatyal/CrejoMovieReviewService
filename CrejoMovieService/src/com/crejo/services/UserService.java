package com.crejo.services;
import com.crejo.dao.UserDao;
import com.crejo.model.User;


public class UserService {


	static int userIdCount = 0;

	 
public String addUser(String userName) {
	
	System.out.println("Adding User ......");
	User user = new User();
	UserDao userDao = new UserDao();
	
	user.setUserName(userName);
	user.setUserProfile("viewer");
	user.setMoviewReviewCount(0);
	user.setUserId(UserService.userIdCount);
	userIdCount = userIdCount + 1;
	
	if (userDao.isUserExist(user.getUserName()) != null) {
		return "ERROR !!!!! User " + userName + " already in database \n";
	} 
	return userDao.addUser(user) + " \n";
}
}

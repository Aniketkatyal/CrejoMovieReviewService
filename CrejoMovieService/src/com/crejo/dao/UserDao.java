package com.crejo.dao;

import java.util.ArrayList;
import java.util.List;

import com.crejo.DataBase.UserDB;
import com.crejo.model.User;


public class UserDao {
	
	UserDB db = UserDB.getInstance();
	
//	ADDING USER
	public String addUser(User user) {

		if(db.getUserDatabase() == null) {
			List<User> userList = new ArrayList<User>();
			userList.add(user);
			db.setUserDatabase(userList);
		}
		
		db.getUserDatabase().add(user);
		return user.getUserName() + " added to database";
	}
	
//	CHECKING IF USER EXISTS IN DATABASE
	public User isUserExist(String userName) {
		
		if (db.getUserDatabase() == null) {
			return null;
		}

		for (int i = 0;i<db.getUserDatabase().size();i++) {
			if (db.getUserDatabase().get(i).getUserName() == userName) {
				return db.getUserDatabase().get(i);
			}
		}
		return null;
	}
}

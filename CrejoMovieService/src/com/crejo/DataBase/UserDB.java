package com.crejo.DataBase;

import java.util.List;

import com.crejo.model.User;

public class UserDB {

private List<User> userDatabase;
private static UserDB userDB = null;

public List<User> getUserDatabase() {
	return userDatabase;
}

public void setUserDatabase(List<User> userDatabase) {
	this.userDatabase = userDatabase;
}

public static UserDB getInstance() {
	if (userDB == null) {
		userDB = new UserDB();
	}
	return userDB;
}

}

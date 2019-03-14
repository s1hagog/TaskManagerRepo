package taskManagerPro.controllers;

import java.util.HashMap;
import java.util.Map;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Login;
import taskManagerPro.entities.User;

public class UserController {
	
	private DBManager dbmgr = new DBManager();
	private Map<String, String> map = new HashMap<String,String>();
	
	
	public void deleteUser(String email) {
		dbmgr.deleteUser(email);
		
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		dbmgr.createUser(user);
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dbmgr.updateUser(user);
		
	}

	public User getUser(Login l) {
		// TODO Auto-generated method stub
		return dbmgr.getUser(l.userLogin);
	}
	

}

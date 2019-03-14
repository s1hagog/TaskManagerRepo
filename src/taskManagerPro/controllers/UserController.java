package taskManagerPro.controllers;

import java.util.HashMap;
import java.util.Map;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Login;
import taskManagerPro.entities.User;

public class UserController {
	
	private DBManager dbmgr = new DBManager();
	private Map<String, String> map = new HashMap<String,String>();
	
	public void setUser(User u, Login l) {
		//send login to dbmgr
		map = dbmgr.getUserData(l.userLogin);
		//get array of info
		//assign to user
		u.first_name = map.get("first_name");
		u.last_name = map.get("last_name");
		u.email = map.get("email");
		u.dept_name = map.get("dept_name");
		u.dept_desc = map.get("dept_desc");
		
	}
	
	public void deleteUser(String email) {
		dbmgr.deleteUser(email);
		
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		dbmgr.createUser(user);
		
	}
	

}

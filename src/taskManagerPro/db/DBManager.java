package taskManagerPro.db;

import java.util.List;
import java.util.Map;

import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

public class DBManager {
	
	DBImplInterface imp = new MongoDBImpl();
	
	public String getUserPassword(String username) {
		
		return imp.getUserPassword(username);
	}
	
	public List<Task> getTasks(String username){
		
		return imp.getTasks(username);
	}
	
	public void setTaskStatus(String username, String name, String status) {
		imp.setTaskStatus(username, name, status);
	}
	
	public void deleteUser(String email) {
		imp.deleteUser(email);
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		imp.createUser(user);
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		imp.updateUser(user);
		
	}

	public User getUser(String userLogin) {
		// TODO Auto-generated method stub
		return imp.getUser(userLogin);
		
	}

	public void deleteTask(String username, String name) {
		// TODO Auto-generated method stub
		imp.deleteTask(username, name);
		
	}

}

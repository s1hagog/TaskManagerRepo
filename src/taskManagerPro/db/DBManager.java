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
	
	public Map<String, String> getUserData(String username){
		
		return imp.getUserData(username);
	}
	
	public List<Task> getTasks(String username){
		
		return imp.getTasks(username);
	}
	
	public void setTaskStatus(String username, int id, String status) {
		imp.setTaskStatus(username, id, status);
	}
	
	public void deleteUser(String email) {
		imp.deleteUser(email);
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		imp.createUser(user);
		
	}

}

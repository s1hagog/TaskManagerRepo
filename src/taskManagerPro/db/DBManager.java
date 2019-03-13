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
	
	public void setTaskStatus(String username, Task t) {
		imp.setTaskStatus(username, t);
	}
	
	public void deleteUser(User u) {
		imp.deleteUser(u);
	}

}

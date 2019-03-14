package taskManagerPro.db;

import java.util.List;
import java.util.Map;

import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

public interface DBImplInterface {
	
	//connect to the database
	public void dbOpenConnection();	
	
	//close connection
	public void dbCloseConnection();
	
	//get password for login
	public String getUserPassword(String username);
	
	//get tasks for user using login
	//this one return list of tasks without any Maps;
	public List<Task> getTasks(String username);
	
	//delete user from db
	public void deleteUser(String email);
	
	//set new status for a task
	public void setTaskStatus(String username, int id, String status);

	//create new user in db
	public void createUser(User user);

	//update user info in db
	public void updateUser(User user);

	public User getUser(String userLogin);
	

}

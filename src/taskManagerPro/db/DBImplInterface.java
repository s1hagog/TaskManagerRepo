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
	
	//////////////////////////////////////////////////////////////////////
	
	//get password for login
	public String getUserPassword(String username);
	
	//create new user in db
	public void createUser(User user);

	//update user info in db
	public void updateUser(User user);
		
	//get user object from db
	public User getUser(String userLogin);
	
	//delete user from db
	public void deleteUser(String email);
	
	///////////////////////////////////////////////////////////////////////
	
	//get tasks for user using login
	//this one return list of tasks without any Maps;
	public List<Task> getTasks(String username);
		
	//set new status for a task
	public void setTaskStatus(String username, String name, String status);

	//delete task from the db
	public void deleteTask(String username, String name);

	//put new task in the db
	public void createTask(String username, Task task);
	

}

package taskManagerPro.db;

import java.util.List;
import java.util.Map;

import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
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

	
	////////////////////////////////////////////////////////////////
	
	//get all users that are in the same project
	public List<User> getUsersFromProject(String projectName);
	
	//gets projects in which user takes part
	public List<Project> getProjects(String userName);

	
	//////////////////////////////////////////////////////////////////
	
	//Manager Functions
	
	
	//get all users in db
	public List<User> getAllUsers(Manager m);

	//get all projects in db
	public List<Project> getAllProjects(Manager m);

	//assign user to project
	public void assignUserToProject(User u, Project p);

	//assign task to user
	public void assignTaskToUser(User u, Task t);
	
	//add new task to the project
	public void addTaskToProject(Task t, Project p);

	//get tasks based on project
	public List<Task> getTasks(String m_username, Project p);

	//create task into a project
	public void createTask(Manager m, Project p, Task task);

	//unassign project from user
	public void unassignProject(String email, String name);

	//add new project in a project list
	public void createProject(String email, Project p);

	

}

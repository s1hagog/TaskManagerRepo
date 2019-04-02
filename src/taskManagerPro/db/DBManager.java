package taskManagerPro.db;

import java.util.List;
import java.util.Map;

import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
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

	public void createTask(String username, Task task) {
		// TODO Auto-generated method stub
		imp.createTask(username, task);
		
	}

	public List<User> getUsersFromProject(String projectName) {
		// TODO Auto-generated method stub
		return imp.getUsersFromProject(projectName);
	}

	public List<Project> getProjects(String userName) {
		// TODO Auto-generated method stub
		return imp.getProjects(userName);
	}

	public List<User> getAllUsers(Manager m) {
		// TODO Auto-generated method stub
		return imp.getAllUsers(m);
	}

	public List<Project> getAllProjects(Manager m) {
		// TODO Auto-generated method stub
		return imp.getAllProjects(m);
	}

	public void assignUserToProject(User u, Project p) {
		// TODO Auto-generated method stub
		imp.assignUserToProject(u, p);
	}

	public void assignTaskToUser(User u, Task t) {
		// TODO Auto-generated method stub
		imp.assignTaskToUser(u,t);
	}

	public void addTaskToProject(Task t, Project p) {
		// TODO Auto-generated method stub
		imp.addTaskToProject(t,p);
		
	}

	public List<Task> getTasks(String m_username, Project p) {
		// TODO Auto-generated method stub
		return imp.getTasks(m_username, p);
	}

	public void createTask(Manager m, Project p, Task task) {
		// TODO Auto-generated method stub
		imp.createTask(m,p,task);
	}

	public void unassignProject(String email, String name) {
		// TODO Auto-generated method stub
		imp.unassignProject(email,name);
		
	}

	public void createProject(String email, Project p) {
		imp.createProject(email, p);
		
	}

	public boolean isUserPartOfProject(String email,String projectName){
		
		return imp.isUserPartOfProject(email,projectName);
	}
}
